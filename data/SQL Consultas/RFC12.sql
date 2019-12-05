select Afiliados.nombre, afiliados.correo_electronico, afiliados.num_documento, 
case when siempre_espec = 1 then  'Siempre especializado'
when count_citas is not null then 'Pide cita todos los meses' when siempreHosp=1 then 'Siempre hospitalizado'
end razon 
, case when count_citas is not null then count_citas else 0 end CitasSolicitadas ,
case when cuenta is not null then cuenta else 0 end ServiciosDistintosSolicitados, 
case when hospitalizaciones is not null then hospitalizaciones else 0 end hospitalizaciones
from Afiliados
left outer join  (select cit_mes.id_afiliado, first_cita, count_citas, meses_primera_cita
 from   (  -- Cuenta cuántos meses han transcurrido desde su primera cita
SELECT id_afiliado, MONTHS_BETWEEN 
   (TO_DATE('11-2019','MM-YYYY'), TO_DATE(to_char(first_cita,'mm/yyyy') ,'MM-YYYY')
     ) meses_primera_cita, first_cita
    FROM( select id_afiliado, min(TO_DATE(fecha_consulta,'dd/mm/yyyy hh24:mi')) as first_cita   -- Cuenta el número de meses distintos en los que ha hecho una cita
 from citas_reservadas
 group by id_afiliado
 )  )  month_fd
    inner join ( -- Cuenta el número de meses distintos en los que ha hecho una cita
 select id_afiliado, count(distinct to_char(TO_DATE(fecha_consulta,'dd/mm/yyyy hh24:mi'),'mm/yy')) as count_citas
 from CITAS_RESERVADAS
 group by id_afiliado
 order by count_citas desc) cit_mes 
    on cit_mes.id_afiliado = month_fd.id_afiliado
    where count_citas = meses_primera_cita) final_freq
on final_freq.id_afiliado = afiliados.num_documento
left outer join  (select ID_Afiliado, 1 siempre_espec,count(distinct sds.ID_PROCEDIMIENTO_ESPECIALIZADO)cuenta
from CITAS_RESERVADAS cita
inner join SERVICIOS_DE_SALUD sds on cita.servicio_asociado= SDS.id
and sds.id_procedimiento_especializado IS NOT NULL
where cita.id_afiliado not in (select id_afiliado from  (select *
from CITAS_RESERVADAS
inner join Servicios_de_salud sds 
on CITAS_RESERVADAS.Servicio_asociado = SDS.id
and sds.id_procedimiento_especializado IS NULL)  oth_no_esp )
group by id_afiliado
)  espec 
on espec.id_afiliado = afiliados.num_documento left outer join  (SELECT c.ID_AFILIADO, 1 siempreHosp, c.citasUsuario as citas, h.cuentaHospitalizaciones as hospitalizaciones 
FROM ( SELECT COUNT(*) as citasUsuario, ID_AFILIADO 
    FROM CITAS_RESERVADAS
    WHERE estado='cumplida'
    GROUP BY ID_AFILIADO 
    order by count(*) desc)  c , ( SELECT COUNT(*) as cuentaHospitalizaciones, cr.id_AFILIADO 
                                    FROM SERVICIOS_DE_SALUD s  
                                    inner join  CITAS_RESERVADAS cr 
                                    ON s.id=cr.servicio_asociado 
                                    where s.ID_HOSPITALIZACION IS NOT NULL
                                    GROUP BY cr.ID_afiliado) h  
WHERE c.ID_AFILIADO=h.ID_AFILIADO AND c.citasUSUARIO/2=h.cuentaHospitalizaciones)  c2 on c2.id_afiliado=espec.id_afiliado
where siempre_espec = 1 or count_citas is not null or siempreHosp=1;