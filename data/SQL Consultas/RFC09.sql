select  s1.correo_electronico,s1.nombre,s1.num_documento,s1.tipo_de_documento,s1.fecha_nacimiento 
				from (
				    SELECT *
				    FROM AFILIADOS a, (
				                select count(distinct cit.id) c1, cit.id_afiliado 
				                FROM ordenes cit WHERE cit.tipo_Servicio IN('Consulta','ConsultaUrgencia') and cit.CITA_RESERVADA = 'T'
				                                                        and to_date(cit.fecha,'dd/mm/yyyy hh24:mi') between to_date('11/02/2015','dd/mm/yyyy hh24:mi') 
				                                                        and to_date('11/02/2019','dd/mm/yyyy hh24:mi') 
				                                                        group by cit.id_afiliado 
				                                                        order by cit.id_afiliado desc
				                      ) tab2,(
				                           SELECT sum(count(distinct id_servicio)) var2 
				                            FROM ordenes WHERE tipo_Servicio IN('Consulta','ConsultaUrgencia') 
				                             group by id_servicio
				                            ) tab3 
				    where  tab2.id_afiliado=a.num_documento and tab2.c1=tab3.var2
				    ) s1    

				where s1.num_documento in(
				                    select id_afiliado 
				                            from (SELECT * 
				                                  FROM  AFILIADOS a, (
                                                                                select count(distinct ser.tipo_servicio) c1, c.id_afiliado 
				                                                                FROM CITAS_RESERVADAS c, ORDENES ser 
				                                                                WHERE c.Servicio_asociado= ser.id and ser.tipo_servicio IN('Examen') and c.estado='cumplida'
                                                                                group by c.id_afiliado
                                                                                order by count(distinct ser.tipo_servicio) desc
				                                                                ) c,    
				                                                                (
				                                                                SELECT sum(count(distinct ser.tipo_servicio)) c3 
				                                                                FROM CITAS_RESERVADAS ,ORDENES ser 
				                                                                WHERE CITAS_RESERVADAS.Servicio_asociado=ser.id_servicio and ser.tipo_servicio IN('Examen') group by ser.tipo_servicio
				                                                                ) tab4 
				                            where   c.id_afiliado=a.num_documento and c.c1=tab4.c3
				                                 )
				                             ) 
				    and s1.num_documento in( select id_afiliado 
				                              from ( select distinct c.id_afiliado 
				                                     from CITAS_RESERVADAS c, PRESTAN p 
				                                     where c.fecha_consulta=p.dia And c.servicio_asociado=p.id_servicio and p.id_ips in
				                                                                                         (select ID_IPS 
				                                                                                          from PRESTAN)
				                                   )
				);