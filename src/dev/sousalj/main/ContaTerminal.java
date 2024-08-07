package de.sousalj.main;


import java.util.Scanner;

public class ContaTerminal {
    private Integer numero;
    private String agencia;
    private String nomeCliente;
    private Float saldo;

    public static void main(String[] args){
        ContaTerminal conta = new ContaTerminal();
        Scanner input = new Scanner(System.in);

        System.out.println("Por favor, digite o seu nome");
        conta.setNomeCliente(input.nextLine());

        System.out.println("Por favor, digite o número da agência");
        String agNumero = input.nextLine();

        System.out.println("Por favor, digite o dígito verificador da agência");
        String agDigitoVerificador = input.nextLine();
        conta.setAgencia(agNumero+agNumero);


        System.out.println("Por favor, digite o número da conta");
        conta.setNumero(input.nextInt());
        //nextline é necessário para evitar InputMismatchException
        input.nextLine();

        System.out.println("Qual o valor do primeiro depósito?");
        Float vlrDeposito= input.nextFloat();
        conta.depositar(vlrDeposito, conta);

        String saida = "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %,d e seu saldo %f já está disponível par asaque.";

        String saidaFOrmatada = String.format(saida, conta.getNomeCliente(), conta.getAgencia(), conta.getNumero(), conta.getSaldo());
        System.out.println(saidaFOrmatada);
    }

    public void depositar(Float valor, ContaTerminal conta){
        if(conta.getSaldo() != 0){
            conta.setSaldo(conta.getSaldo()+valor);
        } else {
            conta.setSaldo(valor);
        }
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
}
