package br.com.gft.cursojava.exficacaointerface.service;

import java.util.Calendar;
import java.util.Date;

import br.com.gft.cursojava.exficacaointerface.entities.Contract;
import br.com.gft.cursojava.exficacaointerface.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService ops;
	
	public ContractService() {
		
	}
	
	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}

	public OnlinePaymentService getOps() {
		return ops;
	}

	public void setOps(OnlinePaymentService ops) {
		this.ops = ops;
	}

	public void processContract(Contract contract, Integer months) {
		double basicQuota = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            Date date = addMonths(contract.getDate(), i);
            double updatedQuota = basicQuota + ops.interest(basicQuota, i);
            double fullQuota =  updatedQuota + ops.paymentFee(updatedQuota);
            contract.addInstallment(new Installment(date, fullQuota));
        }

	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
