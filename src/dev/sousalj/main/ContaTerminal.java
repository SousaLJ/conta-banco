package dev.sousalj.main;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;

public class ContaTerminal {
    private Integer numero;
    private String agencia;
    private String nomeCliente;
    private Double saldo;

    public static void main(String[] args){
        ContaTerminal conta = new ContaTerminal();
        lerdadosUsuario("Por favor, digite o seu nome", String.class, conta::setNomeCliente);
        // Requisitando número da agência e dígito verificador
        String agNumero = lerdadosUsuario("Por favor, digite o número da agência", String.class);
        String agDigitoVerificador = lerdadosUsuario("Por favor, digite o dígito verificador da agência", String.class);
        conta.setAgencia(agNumero +"-"+agDigitoVerificador);

        lerdadosUsuario("Por favor, digite o número da conta", Integer.class, conta::setNumero);
        lerdadosUsuario("Qual o valor do primeiro depósito?", Double.class, conta::depositar);

        //Formatação e envio da saída para o usuário
        String saida = "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.";
        String saidaFormatada = String.format(saida, conta.getNomeCliente(), conta.getAgencia(), conta.getNumero(), conta.getSaldo());

        System.out.println(saidaFormatada);
    }

    public void depositar(Double valor){
        if (this.getSaldo() != null && this.getSaldo() != 0){
            this.setSaldo(this.getSaldo()+valor);
        } else {
            this.setSaldo(valor);
        }
    }

    public static <T> T lerdadosUsuario(String mensagem, Class<T> tipo) {
        Scanner input = new Scanner(System.in);
        System.out.println(mensagem);
        while (true) {
            try {
                if (tipo == String.class) {
                    return tipo.cast(input.nextLine());
                } else if (tipo == Integer.class) {
                    return tipo.cast(input.nextInt());
                    // Consumir a nova linha pendente
                } else if (tipo == Double.class) {
                    input.useLocale(Locale.US);
                    return tipo.cast(input.nextDouble());
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, tente novamente.");
                input.next(); // Consumir a entrada inválida
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        return null; // Retorno padrão para evitar erro de compilação
    }

    public static <T> void lerdadosUsuario(String mensagem, Class<T> tipo, Consumer<T> setter) {
        setter.accept(lerdadosUsuario(mensagem, tipo));
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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
