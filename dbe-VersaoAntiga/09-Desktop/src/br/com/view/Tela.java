package br.com.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrecoPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrecoPrazoResponse;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtNumero1;
	private Text txtNumero2;
	private Text txtOrigem;
	private Text txtDestino;
	private Text txtPrazo;
	private Text txtDataMaxima;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNumero1 = new Label(shell, SWT.NONE);
		lblNumero1.setBounds(55, 35, 55, 15);
		lblNumero1.setText("N\u00FAmero 1");
		
		txtNumero1 = new Text(shell, SWT.BORDER);
		txtNumero1.setBounds(117, 32, 118, 21);
		
		Label lblNumero2 = new Label(shell, SWT.NONE);
		lblNumero2.setBounds(55, 82, 55, 15);
		lblNumero2.setText("N\u00FAmero 2");
		
		txtNumero2 = new Text(shell, SWT.BORDER);
		txtNumero2.setBounds(117, 82, 118, 21);
		
		Label lblResult = new Label(shell, SWT.NONE);
		lblResult.setBounds(88, 186, 55, 15);
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//clique do botão
			int num1 = Integer.parseInt(txtNumero1.getText());
			int num2 = Integer.parseInt(txtNumero2.getText());
				
				
				lblResult.setText(Integer.toString(num1+num2));
				
			}
		});
		btnCalcular.setBounds(93, 129, 75, 25);
		btnCalcular.setText("Calcular");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(241, 35, 73, 15);
		lblNewLabel.setText("CEP Origem");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(241, 82, 73, 21);
		lblNewLabel_1.setText("CEP Destino");
		
		txtOrigem = new Text(shell, SWT.BORDER);
		txtOrigem.setBounds(325, 35, 76, 21);
		
		txtDestino = new Text(shell, SWT.BORDER);
		txtDestino.setBounds(325, 76, 76, 21);
		
		Label lblPrazo = new Label(shell, SWT.NONE);
		lblPrazo.setBounds(237, 159, 55, 15);
		lblPrazo.setText("Prazo");
		
		Label lblDataMaxima = new Label(shell, SWT.NONE);
		lblDataMaxima.setBounds(241, 199, 73, 15);
		lblDataMaxima.setText("Data Maxima");
		
		txtPrazo = new Text(shell, SWT.BORDER);
		txtPrazo.setBounds(325, 159, 76, 21);
		
		txtDataMaxima = new Text(shell, SWT.BORDER);
		txtDataMaxima.setBounds(325, 199, 76, 21);
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String origem = txtOrigem.getText();
				String destino = txtDestino.getText();
				
				try {
					CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
					CalcPrazo cpp = new CalcPrazo();
					//cpp.setNCdServico("40010");
					cpp.setSCepOrigem(origem);
					cpp.setSCepDestino(destino);
					CalcPrazoResponse resposta = stub.calcPrazo(cpp);
					
					
					String prazo = resposta.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega();
					String dataMaxima = resposta.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega();
					
					txtPrazo.setText(prazo);
					txtDataMaxima.setText(dataMaxima);
					
					
				 
					
			
				} catch (Exception e1) {
					e1.printStackTrace();
					MessageBox dialog  = new MessageBox(shell);
					dialog.setMessage(e1.getMessage());
					dialog.open();
					}
			}
		});
		btnPesquisar.setBounds(241, 116, 75, 25);
		btnPesquisar.setText("Pesquisar");
		
		

	}
}
