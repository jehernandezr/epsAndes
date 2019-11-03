package eps.negocio;

public class ProcedimientoEspecializado extends ServicioDeSalud {

		private String tipo_Procedimiento;

		
		/**
		 * Constructor por defecto
		 */
		public ProcedimientoEspecializado() {
			super();
			this.tipo_Procedimiento = null;
		}
		/**
		 * @param tipoDeProcedimiento
		 */
		public ProcedimientoEspecializado(String tipoDeProcedimiento) {
			super();
			this.tipo_Procedimiento = tipoDeProcedimiento;
		}

		/**
		 * @return the tipoDeProcedimiento
		 */
		public String getTipo_Procedimiento() {
			return tipo_Procedimiento;
		}

		/**
		 * @param tipoDeProcedimiento the tipoDeProcedimiento to set
		 */
		public void setTipo_Procedimiento(String tipoDeProcedimiento) {
			this.tipo_Procedimiento = tipoDeProcedimiento;
		}
}
