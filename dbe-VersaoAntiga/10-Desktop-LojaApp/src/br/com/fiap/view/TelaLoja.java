package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.Produto;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaLoja {

	protected Shell shell;
	private Text txtNumero;
	private Text txtProduto;
	private Label lblCodigo;
	private Label lblPreo;
	private Text txtCodigo;
	private Text txtPreco;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaLoja window = new TelaLoja();
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
		shell.setSize(450, 363);
		shell.setText("SWT Application");
		
		Label lblNumeroDaCamiseta = new Label(shell, SWT.NONE);
		lblNumeroDaCamiseta.setBounds(40, 44, 122, 21);
		lblNumeroDaCamiseta.setText("Numero da camiseta");
		
		txtNumero = new Text(shell, SWT.BORDER);
		txtNumero.setBounds(40, 81, 122, 21);
		
		
		Label lblProduto = new Label(shell, SWT.NONE);
		lblProduto.setBounds(286, 84, 55, 15);
		lblProduto.setText("Produto");
		
		txtProduto = new Text(shell, SWT.BORDER);
		txtProduto.setBounds(278, 123, 130, 21);
		
		Button btnConsultar = new Button(shell, SWT.NONE);
		btnConsultar.addSelectionListener(new SelectionAdapter() {
			
			
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				int numero = Integer.parseInt(txtNumero.getText());
				 
				try {
					EstoqueBOStub stub = new EstoqueBOStub();
					ConsultarProduto cp= new ConsultarProduto();
					cp.setCodigo(numero);
					ConsultarProdutoResponse resposta = stub.consultarProduto(cp);
					
					Produto produto1 = resposta.get_return();
					
					String produto = produto1.getDescricao();
					txtProduto.setText(produto);
					
					String codigo = Integer.toString(produto1.getCodigo());
					txtCodigo.setText(codigo);
					
					String preco = Double.toString(produto1.getPreco());
					txtPreco.setText(preco);
					
					
					
					//table.removeAll();
					
					//TableItem item = new TableItem(table,0);
					//item.setText(new String[]{produto.getDescricao(),
					//Integer.toString(produto.getQuantidade()),
					//String.valueOf(produto.getPreco())
					//});
					
					
					
				}catch(Exception ei) {
					ei.printStackTrace();
					MessageBox dialog  = new MessageBox(shell);
					dialog.setMessage(ei.getMessage());
					dialog.open();
				}
				
			}
		});
		btnConsultar.setBounds(58, 133, 75, 25);
		btnConsultar.setText("Consultar");
		
		lblCodigo = new Label(shell, SWT.NONE);
		lblCodigo.setBounds(286, 30, 55, 15);
		lblCodigo.setText("codigo");
		
		lblPreo = new Label(shell, SWT.NONE);
		lblPreo.setBounds(286, 164, 55, 15);
		lblPreo.setText("Pre\u00E7o");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(278, 51, 130, 21);
		
		txtPreco = new Text(shell, SWT.BORDER);
		txtPreco.setBounds(278, 185, 130, 21);
	

	}
}
