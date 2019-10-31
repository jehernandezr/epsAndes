package eps.negocio;

public interface VOProcedimientoEspecializado extends VOServicioDeSalud 
{

		public Procedimiento getTipoDeProcedimiento();

		public void setTipoDeProcedimiento(Procedimiento tipoDeProcedimiento);
}
