select s1.Num_Documento,s1.nombre,s1.correo_electronico,s1.tipo_de_documento,s1.fecha_nacimiento 
				    from AFILIADOS s1 
				    where s1.Num_documento not in( 
				    select Num_documento from ( 
				    SELECT * FROM AFILIADOS a, (  
				    select count(distinct c.servicio_asociado) c1,c.id_afiliado 
				    FROM CITAS_reservadas c WHERE c.estado = 'cumplida' and to_date(c.fecha_consulta,'dd/mm/yyyy hh24:mi')  
				    between to_date( '07/11/2015' ,'dd/mm/yyyy hh24:mi') and to_date( '07/11/2019' ,'dd/mm/yyyy hh24:mi') 
				    group by c.id_afiliado order by c.id_afiliado desc 
				    ) c,( 
				    SELECT sum(count(distinct servicio_asociado)) c2 
				    FROM CITAs_reservadas
				    group by servicio_asociado 
				    ) cs where c.id_afiliado=a.Num_Documento and c.c1=cs.c2 
				    ))  
				    and s1.Num_documento not in(select id_afiliado from ( 
				    SELECT * 
				    FROM AFILIADOS a, (  
				    select count(distinct s.id) c1,id_afiliado 
				    FROM CITAs_reservadas c, SERVICIOs_de_Salud s 
				    WHERE c.servicio_asociado=s.id and c.estado = 'cumplida' 
				    group by id_afiliado order by count(distinct s.id) desc 
				    ) c,( 
				    SELECT sum(count(distinct s.id)) c2 
				    FROM CITAS_reservadas c,SERVICIOS_de_salud s 
				    WHERE c.servicio_asociado =s.id group by s.id  
				    ) cs where c.id_afiliado=a.Num_Documento and c.c1=cs.c2  
				    )) 
				    and s1.Num_documento not in(select id_afiliado 
				    from ( select distinct c.id_afiliado from CITAs_reservadas c, PRESTAN p where c.fecha_consulta=p.dia And c.servicio_asociado=p.id_servicio and p.id_ips 
				    in(select ID_IPS from PRESTAN)
					));