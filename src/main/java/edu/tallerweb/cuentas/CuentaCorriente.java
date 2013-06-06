package edu.tallerweb.cuentas;

/**
 * La más compleja de las cuentas, ésta permite establecer una
 * cantidad de dinero a girar en descubierto. Es por ello que
 * cada vez que se desee extraer dinero, no sólo se considera
 * el que se posee, sino el límite adicional que el banco
 * estará brindando.
 *
 * Por supuesto esto no es gratis, ya que el banco nos cobrará
 * un 5% como comisión sobre todo el monto en descubierto
 * consumido en la operación.
 *
 * Por ejemplo, si tuviéramos $ 100 en la cuenta, y quisiéramos
 * retirar $ 200 (con un descubierto de $ 150), podremos hacerlo.
 * Pasaremos a deberle al banco $ 105 en total: los $ 100 que
 * nos cubrió, más el 5% adicional sobre el descubierto otorgado.
 * 
 * 
 * 
 */


public class CuentaCorriente {

	/**
	 * Toda cuenta corriente se inicia con un límite total
	 * para el descubierto.
	 * @param descubiertoTotal
	 * 
	 *
	 */
	
	private Double monto=0.0;
	private Double descubiertoTotal=0.0;
	private Double descubiertoFijo=0.0;
	private Double diferenciaMonto=0.0;
	private Double descubiertoDeuda=0.0;
	private Double restoDeudaMonto;
	private Double descubiertoPorcentaje=0.0;
	private double descubiertoDeuda1;
	private double descubiertoMonto1;
	
	public CuentaCorriente(final Double descubiertoTotal) {
		this.descubiertoTotal=descubiertoTotal;
		this.descubiertoFijo=descubiertoTotal;
	}
	
	/**
	 * Todo depósito deberá cubrir primero el descubierto,
	 * si lo hubiera, y luego contar para el saldo de la
	 * cuenta.
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {

		
		
	
		if (this.descubiertoTotal<this.descubiertoFijo && this.monto<monto)
		{
			this.descubiertoMonto1=monto-this.monto;
			this.descubiertoDeuda1=this.descubiertoMonto1-this.descubiertoMonto1;
			this.descubiertoTotal=this.descubiertoTotal+this.descubiertoDeuda1;
			this.monto=this.monto+this.descubiertoMonto1;
		}
	
		
	else
		{
		this.monto+=monto;
		}	
		}
		
		
		
	/**
	 * Se cobrará el 5% de comisión sobre el monto girado
	 * en descubierto.
	 * Por supuesto, no puede extraerse más que el total
	 * de la cuenta, más el descubierto (comisión incluída)
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
	
	 if(monto>this.monto && this.descubiertoFijo==this.descubiertoTotal)
		{
		 this.descubiertoDeuda=monto-this.monto;
		 this.descubiertoPorcentaje=(this.descubiertoFijo/100)*5;
		 this.diferenciaMonto=monto-this.descubiertoDeuda;
		 this.descubiertoTotal=this.descubiertoTotal-(this.descubiertoDeuda+this.descubiertoPorcentaje);	
		}
	 else
	   { 
		 this.monto=this.monto-monto;
		 
		 
		 
	   }
		 
		 
		 
		 
		
	}
	
	
	
	/**
	 * Permite saber el saldo de la cuenta
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
	/*	throw new RuntimeException("No implementado aún");*/
		
		return this.monto;
		
	}
	
	/**
	 * Permite saber el saldo en descubierto
	 * @return el descubierto de la cuenta
	 */
	public Double getDescubierto() {
		return this.descubiertoTotal;
	/*	throw new RuntimeException("No implementado aún");*/				
	}

}
