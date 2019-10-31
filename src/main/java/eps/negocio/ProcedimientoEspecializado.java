package eps.negocio;

public class ProcedimientoEspecializado extends ServicioDeSalud {

		private Procedimiento tipoDeProcedimiento;

		
		/**
		 * Constructor por defecto
		 */
		public ProcedimientoEspecializado() {
			super();
			this.tipoDeProcedimiento = null;
		}
		/**
		 * @param tipoDeProcedimiento
		 */
		public ProcedimientoEspecializado(Procedimiento tipoDeProcedimiento) {
			super();
			this.tipoDeProcedimiento = tipoDeProcedimiento;
		}

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
