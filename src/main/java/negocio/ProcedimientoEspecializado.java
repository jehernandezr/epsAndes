package negocio;

public class ProcedimientoEspecializado extends ServicioDeSalud {

		private Procedimiento tipoDeProcedimiento;

		/**
		 * @return the tipoDeProcedimiento
		 */
		public Procedimiento getTipoDeProcedimiento() {
			return tipoDeProcedimiento;
		}

		/**
		 * @param tipoDeProcedimiento the tipoDeProcedimiento to set
		 */
		public void setTipoDeProcedimiento(Procedimiento tipoDeProcedimiento) {
			this.tipoDeProcedimiento = tipoDeProcedimiento;
		}
}
