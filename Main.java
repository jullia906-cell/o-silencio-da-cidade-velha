
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    static boolean encontrouDocumento = false;
    static boolean encontrouLivro = false;
    static boolean encontrouCopo = false;

    static boolean interrogouHelena = false;
    static boolean interrogouRicardo = false;
    static boolean interrogouBeatriz = false;
    static boolean interrogouDaniel = false;

    static boolean jogoAtivo = true;
    static boolean casoResolvido = false;

    static int[] entrevistasCaso002 = new int[7];

    static boolean[] vagoesInvestigados = new boolean[5];

    static boolean encontrouArma = false;
    static boolean encontrouBilhete = false;
    static boolean encontrouMarcas = false;
    static boolean encontrouMala = false;
    static boolean encontrouCompartimento = false;
    static boolean encontrouRelogio = false;
    static boolean encontrouEstojo = false;
    static boolean encontrouBilheteEncontro = false;
    static boolean encontrouMancha = false;
    static boolean caso002Resolvido = false;

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("       QUEM COMETEU O CRIME?");
        System.out.println("======================================");
        System.out.println();
        System.out.println("CASO 001 - O MISTERIO DA MANSÃO CARVALHO");
        System.out.println();
        System.out.println("Arthur Carvalho foi encontrado morto");
        System.out.println("em seu escritorio, durante uma festa.");
        System.out.println();
        System.out.println("Quatro pessoas estavam na mansao.");
        System.out.println("Todas afirmam nao ter envolvimento.");
        System.out.println();
        System.out.println("Sua missao e investigar o local,");
        System.out.println("interrogar os suspeitos e descobrir");
        System.out.println("quem cometeu o crime.");
        System.out.println();
        System.out.println("Boa sorte, detetive!");
        System.out.println();

        while (jogoAtivo) {

            mostrarMenu();

            int opcao = lerOpcao();

            switch (opcao) {

                case 1:
                    investigarMansao();
                    break;

                case 2:
                    interrogarSuspeitos();
                    break;

                case 3:
                    consultarPistas();
                    break;

                case 4:
                    fazerAcusacao();
                    break;

                case 5:
                    jogoAtivo = false;
                    System.out.println();
                    System.out.println("Voce encerrou a investigacao.");
                    System.out.println("Ate a proxima, detetive!");
                    break;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }

            System.out.println();
        }

        entrada.close();
    }

    public static void mostrarMenu() {

        System.out.println("======================================");
        System.out.println("             MENU PRINCIPAL");
        System.out.println("======================================");
        System.out.println("1 - Investigar a mansao");
        System.out.println("2 - Interrogar suspeitos");
        System.out.println("3 - Consultar pistas");
        System.out.println("4 - Fazer acusacao");
        System.out.println("5 - Sair do jogo");
        System.out.println("======================================");
        System.out.print("Escolha uma opcao: ");
    }

    public static int lerOpcao() {

        String resposta = entrada.nextLine();

        try {
            return Integer.parseInt(resposta);
        } catch (NumberFormatException erro) {
            return -1;
        }
    }

    // CASO 001 - INVESTIGACAO DA MANSAO

    public static void investigarMansao() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          INVESTIGAR A MANSÃO");
        System.out.println("======================================");
        System.out.println("1 - Escritorio de Arthur");
        System.out.println("2 - Biblioteca");
        System.out.println("3 - Cozinha");
        System.out.println("4 - Voltar ao menu");
        System.out.println("======================================");
        System.out.print("Qual local deseja investigar? ");

        int local = lerOpcao();

        switch (local) {

            case 1:
                investigarEscritorio();
                break;

            case 2:
                investigarBiblioteca();
                break;

            case 3:
                investigarCozinha();
                break;

            case 4:
                System.out.println("Voce voltou ao menu principal.");
                break;

            default:
                System.out.println("Local invalido.");
        }
    }

    public static void investigarEscritorio() {

        System.out.println();

        if (!encontrouDocumento) {

            System.out.println("Voce entrou no escritorio de Arthur.");
            System.out.println("A sala esta desorganizada.");
            System.out.println();
            System.out.println("Sobre a mesa, voce encontrou um documento");
            System.out.println("rasgado, aparentemente escrito por Arthur.");
            System.out.println();
            System.out.println("\"Preciso resolver isso antes da meia-noite.");
            System.out.println("Nao posso confiar em R.C. novamente.\"");
            System.out.println();
            System.out.println("O restante do documento foi destruido.");
            System.out.println("As iniciais R.C. podem ser importantes.");

            encontrouDocumento = true;

        } else {

            System.out.println("Voce ja investigou o escritorio.");
            System.out.println("Nao encontrou nada novo por aqui.");
        }
    }

    public static void investigarBiblioteca() {

        System.out.println();

        if (!encontrouLivro) {

            System.out.println("Voce entrou na biblioteca.");
            System.out.println("Ha varios livros espalhados pelas estantes.");
            System.out.println();
            System.out.println("Um livro esta aberto sobre uma poltrona.");
            System.out.println("Dentro dele, voce encontrou um papel");
            System.out.println("com uma anotacao:");
            System.out.println();
            System.out.println("\"22h20 - deixar o livro e ir ao escritorio.\"");
            System.out.println();
            System.out.println("A anotacao nao tem assinatura.");
            System.out.println("Mas parece indicar um horario importante.");

            encontrouLivro = true;

        } else {

            System.out.println("Voce ja investigou a biblioteca.");
            System.out.println("Nao encontrou nada novo por aqui.");
        }
    }

    public static void investigarCozinha() {

        System.out.println();

        if (!encontrouCopo) {

            System.out.println("Voce entrou na cozinha.");
            System.out.println("Perto da pia, ha um copo quebrado.");
            System.out.println();
            System.out.println("Ao lado dos cacos, voce encontrou");
            System.out.println("um pequeno pedaco de papel.");
            System.out.println();
            System.out.println("Nele esta escrito:");
            System.out.println();
            System.out.println("\"O dinheiro precisa ser devolvido.");
            System.out.println("Arthur nao vai esperar mais.\"");
            System.out.println();
            System.out.println("O papel parece ter sido arrancado");
            System.out.println("de uma carta ou de um bilhete maior.");

            encontrouCopo = true;

        } else {

            System.out.println("Voce ja investigou a cozinha.");
            System.out.println("Nao encontrou nada novo por aqui.");
        }
    }

    // CASO 001 - INTERROGATORIOS

    public static void interrogarSuspeitos() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          INTERROGATORIO");
        System.out.println("======================================");
        System.out.println("1 - Helena (Governanta)");
        System.out.println("2 - Ricardo (Irmao de Arthur)");
        System.out.println("3 - Beatriz (Sobrinha de Arthur)");
        System.out.println("4 - Daniel (Mordomo)");
        System.out.println("5 - Voltar ao menu");
        System.out.println("======================================");
        System.out.print("Quem deseja interrogar? ");

        int suspeito = lerOpcao();

        switch (suspeito) {

            case 1:
                interrogarHelena();
                break;

            case 2:
                interrogarRicardo();
                break;

            case 3:
                interrogarBeatriz();
                break;

            case 4:
                interrogarDaniel();
                break;

            case 5:
                System.out.println("Voce voltou ao menu principal.");
                break;

            default:
                System.out.println("Opcao invalida.");
        }
    }

    public static void interrogarHelena() {

        System.out.println();

        if (!interrogouHelena) {

            System.out.println("HELENA - GOVERNANTA");
            System.out.println();
            System.out.println("\"Eu estava preparando o jantar naquela");
            System.out.println("noite. Por volta das 22h30, ouvi um");
            System.out.println("barulho vindo do escritorio de Arthur.");
            System.out.println("Nao fui verificar porque estava ocupada");
            System.out.println("na cozinha.");
            System.out.println();
            System.out.println("Arthur parecia preocupado nos ultimos");
            System.out.println("dias, mas nunca me contou o motivo.\"");

            interrogouHelena = true;

        } else {

            System.out.println("Voce ja interrogou Helena.");
            System.out.println("Ela nao tem mais nada a acrescentar.");
        }
    }

    public static void interrogarRicardo() {

        System.out.println();

        if (!interrogouRicardo) {

            System.out.println("RICARDO - IRMAO DE ARTHUR");
            System.out.println();
            System.out.println("\"Eu estava na biblioteca lendo um livro.");
            System.out.println("Nao tinha motivo para entrar no");
            System.out.println("escritorio naquela noite.");
            System.out.println();
            System.out.println("E verdade que Arthur e eu discutimos");
            System.out.println("por causa de dinheiro, mas isso e");
            System.out.println("um assunto de familia.");
            System.out.println();
            System.out.println("Eu jamais faria algo contra meu");
            System.out.println("proprio irmao.\"");

            interrogouRicardo = true;

        } else {

            System.out.println("Voce ja interrogou Ricardo.");
            System.out.println("Ele nao tem mais nada a acrescentar.");
        }
    }

    public static void interrogarBeatriz() {

        System.out.println();

        if (!interrogouBeatriz) {

            System.out.println("BEATRIZ - SOBRINHA DE ARTHUR");
            System.out.println();
            System.out.println("\"Eu estava no jardim quando tudo");
            System.out.println("aconteceu. Precisava de um pouco de ar.");
            System.out.println();
            System.out.println("Meu tio estava estranho naquela noite");
            System.out.println("e parecia desconfiar de alguem.");
            System.out.println();
            System.out.println("Nao sei quem poderia querer");
            System.out.println("machuca-lo.\"");

            interrogouBeatriz = true;

        } else {

            System.out.println("Voce ja interrogou Beatriz.");
            System.out.println("Ela nao tem mais nada a acrescentar.");
        }
    }

    public static void interrogarDaniel() {

        System.out.println();

        if (!interrogouDaniel) {

            System.out.println("DANIEL - MORDOMO");
            System.out.println();
            System.out.println("\"Eu estava organizando o salao para");
            System.out.println("o encerramento da festa.");
            System.out.println();
            System.out.println("Passei pelo corredor do escritorio");
            System.out.println("por volta das 22h45, mas a porta");
            System.out.println("estava fechada.");
            System.out.println();
            System.out.println("Nao vi ninguem entrando ou saindo.\"");

            interrogouDaniel = true;

        } else {

            System.out.println("Voce ja interrogou Daniel.");
            System.out.println("Ele nao tem mais nada a acrescentar.");
        }
    }

    // CASO 001 - QUADRO DE PISTAS

    public static void consultarPistas() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("             QUADRO DE PISTAS");
        System.out.println("======================================");

        boolean encontrouAlgumaPista = false;

        if (encontrouDocumento) {

            System.out.println();
            System.out.println("PISTA 1 - DOCUMENTO RASGADO");
            System.out.println("Arthur escreveu que nao podia confiar");
            System.out.println("em alguem identificado pelas iniciais");
            System.out.println("R.C. novamente.");

            encontrouAlgumaPista = true;
        }

        if (encontrouLivro) {

            System.out.println();
            System.out.println("PISTA 2 - ANOTACAO NA BIBLIOTECA");
            System.out.println("Um papel indica que alguem deveria");
            System.out.println("deixar o livro e ir ao escritorio");
            System.out.println("as 22h20.");

            encontrouAlgumaPista = true;
        }

        if (encontrouCopo) {

            System.out.println();
            System.out.println("PISTA 3 - PAPEL NA COZINHA");
            System.out.println("O bilhete fala sobre dinheiro que");
            System.out.println("precisava ser devolvido a Arthur.");

            encontrouAlgumaPista = true;
        }

        if (!encontrouAlgumaPista) {

            System.out.println();
            System.out.println("Voce ainda nao encontrou nenhuma pista.");
            System.out.println("Explore os comodos da mansao primeiro.");
        }

        System.out.println();
        System.out.println("======================================");
    }

    // CASO 001 - ACUSACAO FINAL

    public static void fazerAcusacao() {

        System.out.println();

        if (casoResolvido) {

            System.out.println("O caso ja foi encerrado.");
            return;
        }

        System.out.println("======================================");
        System.out.println("           ACUSACAO FINAL");
        System.out.println("======================================");
        System.out.println("Antes de acusar alguem, pense bem.");
        System.out.println();
        System.out.println("1 - Helena");
        System.out.println("2 - Ricardo");
        System.out.println("3 - Beatriz");
        System.out.println("4 - Daniel");
        System.out.println("5 - Voltar ao menu");
        System.out.println("======================================");
        System.out.print("Quem voce acusa? ");

        int acusacao = lerOpcao();

        if (acusacao == 5) {
            System.out.println("Acusacao cancelada.");
            return;
        }

        if (acusacao < 1 || acusacao > 4) {
            System.out.println("Opcao invalida.");
            return;
        }

        System.out.println();

        if (acusacao == 2) {

            System.out.println("======================================");
            System.out.println("             CASO RESOLVIDO");
            System.out.println("======================================");
            System.out.println("PARABENS, DETETIVE!");
            System.out.println();
            System.out.println("Voce descobriu que Ricardo");
            System.out.println("Carvalho cometeu o crime.");
            System.out.println();
            System.out.println("As iniciais R.C. no documento");
            System.out.println("apontavam para Ricardo.");
            System.out.println();
            System.out.println("A discussao sobre dinheiro e o");
            System.out.println("bilhete encontrado na cozinha");
            System.out.println("reforcaram a suspeita.");
            System.out.println();
            System.out.println("Ricardo mentiu sobre sua noite");
            System.out.println("na biblioteca.");
            System.out.println();
            System.out.println("Arthur descobriu que o proprio");
            System.out.println("irmao estava envolvido em algo");
            System.out.println("que ele nao poderia mais esconder.");
            System.out.println();
            System.out.println("Voce solucionou o Caso 001!");
            System.out.println("======================================");

            casoResolvido = true;

            System.out.println();
            System.out.println("Uma nova investigacao esta prestes");
            System.out.println("a comecar...");

            iniciarCaso002();

        } else {

            String nomeSuspeito = "";

            switch (acusacao) {

                case 1:
                    nomeSuspeito = "Helena";
                    break;

                case 3:
                    nomeSuspeito = "Beatriz";
                    break;

                case 4:
                    nomeSuspeito = "Daniel";
                    break;
            }

            System.out.println("Voce acusou " + nomeSuspeito + ".");
            System.out.println();
            System.out.println("Mas as evidencias nao confirmam");
            System.out.println("essa acusacao.");
            System.out.println();
            System.out.println("O verdadeiro culpado continua livre.");
            System.out.println("A investigacao foi encerrada.");

            jogoAtivo = false;
        }
    }

    // CASO 002 - O ULTIMO TREM DE SANTA CECILIA

    public static void iniciarCaso002() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("   O ULTIMO TREM DE SANTA CECILIA");
        System.out.println("======================================");
        System.out.println();
        System.out.println("ANO: 1898");
        System.out.println("LOCAL: Trem de Santa Cecilia");
        System.out.println();
        System.out.println("Augusto Vasconcelos, um rico empresario,");
        System.out.println("foi encontrado morto em sua cabine");
        System.out.println("durante uma viagem noturna.");
        System.out.println();
        System.out.println("Sete pessoas estavam a bordo.");
        System.out.println("Todas possuem algo a esconder.");
        System.out.println();
        System.out.println("Sua missao e investigar os passageiros,");
        System.out.println("os vagoes e as circunstancias do crime.");

        boolean investigacaoAtiva = true;

        while (investigacaoAtiva) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("             CASO 002");
            System.out.println("======================================");
            System.out.println("1 - Investigar os vagoes");
            System.out.println("2 - Interrogar passageiros");
            System.out.println("3 - Consultar pistas");
            System.out.println("4 - Fazer acusacao");
            System.out.println("5 - Encerrar investigacao");
            System.out.println("======================================");
            System.out.print("Escolha uma opcao: ");

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    investigarVagoes();
                    break;
                case 2:
                    interrogarPassageiros();
                    break;
                case 3:
                    consultarPistasCaso002();
                    break;
                case 4:
                    fazerAcusacaoCaso002();
                    if (caso002Resolvido || !jogoAtivo) {
                        investigacaoAtiva = false;
                    }
                    break;
                case 5:
                    investigacaoAtiva = false;
                    jogoAtivo = false;
                    System.out.println();
                    System.out.println("Voce encerrou a investigacao.");
                    System.out.println("Ate a proxima, detetive!");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

    // CASO 002 - INVESTIGACAO DOS VAGOES

    static void investigarVagoes() {

        System.out.println("\n========== VAGOES ==========");
        System.out.println("1 - Cabine de Augusto");
        System.out.println("2 - Vagao-restaurante");
        System.out.println("3 - Vagao de passageiros");
        System.out.println("4 - Vagao de bagagens");
        System.out.println("5 - Vagao dos funcionarios");
        System.out.print("Escolha um vagao: ");

        int opcao = lerOpcao();

        if (opcao < 1 || opcao > 5) {
            System.out.println("\nVagao invalido.");
            return;
        }

        // O compartimento pode ser examinado novamente depois de encontrado.
        if (opcao == 4 && encontrouCompartimento && !encontrouArma) {
            examinarCompartimento();
            return;
        }

        if (vagoesInvestigados[opcao - 1]) {
            System.out.println("\nVoce ja investigou esse vagao.");
            System.out.println("Nao encontrou nada novo por aqui.");
            return;
        }

        vagoesInvestigados[opcao - 1] = true;

        switch (opcao) {

            case 1:
                System.out.println("\n========== CABINE DE AUGUSTO ==========");
                System.out.println("A cabine esta parcialmente desorganizada.");
                System.out.println("Ha sinais de que houve uma luta.");
                System.out.println();
                System.out.println("Voce encontra marcas na madeira");
                System.out.println("proxima a cama e vestigios de sangue.");
                System.out.println("O ferimento parece ter sido causado");
                System.out.println("por um objeto estreito e pontiagudo.");
                System.out.println();
                System.out.println("A posicao dos objetos sugere que Augusto");
                System.out.println("tentou se defender de alguem proximo.");
                encontrouMancha = true;
                break;

            case 2:
                System.out.println("\n========== VAGAO-RESTAURANTE ==========");
                System.out.println("Entre os assentos, voce encontra");
                System.out.println("um bilhete amassado.");
                System.out.println();
                System.out.println("O papel contem uma frase:");
                System.out.println("\"Voce vai pagar pelo que fez.\"");
                System.out.println();
                System.out.println("Nao ha assinatura. A letra parece");
                System.out.println("ter sido escrita com bastante pressa.");
                encontrouBilhete = true;
                break;

            case 3:
                System.out.println("\n========== VAGAO DE PASSAGEIROS ==========");
                System.out.println("Voce observa marcas recentes");
                System.out.println("proximas a porta de comunicacao.");
                System.out.println();
                System.out.println("A poeira foi removida em uma faixa");
                System.out.println("estreita, como se alguem tivesse");
                System.out.println("passado carregando um objeto comprido.");
                System.out.println();
                System.out.println("As marcas seguem na direcao do");
                System.out.println("vagao de bagagens.");
                encontrouMarcas = true;
                break;

            case 4:
                System.out.println("\n========== VAGAO DE BAGAGENS ==========");
                System.out.println("Uma mala parece ter sido aberta");
                System.out.println("as pressas.");
                System.out.println();
                System.out.println("Ao examinar o forro, voce percebe");
                System.out.println("uma costura diferente das demais.");
                System.out.println("Ha um pequeno compartimento escondido.");
                System.out.println();
                System.out.println("A abertura esta emperrada. Parece");
                System.out.println("que alguem tentou fecha-la rapidamente.");
                encontrouMala = true;
                encontrouCompartimento = true;
                break;

            case 5:
                System.out.println("\n========== VAGAO DOS FUNCIONARIOS ==========");
                System.out.println("O local esta quase vazio.");
                System.out.println();
                System.out.println("Voce encontra um relogio de bolso");
                System.out.println("esquecido proximo a um armario.");
                System.out.println("Os ponteiros estao parados as 22h20.");
                System.out.println();
                System.out.println("Em um espaco pouco visivel, ha um");
                System.out.println("estojo de partituras.");
                System.out.println("Entre as folhas, voce encontra um");
                System.out.println("pequeno bilhete dobrado:");
                System.out.println();
                System.out.println("\"Depois da ultima troca de turno.");
                System.out.println("No mesmo lugar de sempre.");
                System.out.println("Nao podemos continuar nos arriscando.\"");
                System.out.println();
                System.out.println("Apenas uma inicial aparece no papel:");
                System.out.println("I.");
                System.out.println("No verso, ha uma letra quase apagada:");
                System.out.println("C.");
                System.out.println();
                System.out.println("O bilhete sugere um encontro secreto,");
                System.out.println("mas ainda nao revela quem o marcou.");
                encontrouRelogio = true;
                encontrouEstojo = true;
                encontrouBilheteEncontro = true;
                break;
        }
    }

    static void examinarCompartimento() {

        System.out.println("\n========== COMPARTIMENTO ESCONDIDO ==========");
        System.out.println("Com cuidado, voce consegue abrir");
        System.out.println("o compartimento encontrado na mala.");
        System.out.println();
        System.out.println("Dentro dele ha um punhal fino,");
        System.out.println("com cabo de madreperola.");
        System.out.println();
        System.out.println("A lamina foi limpa, mas ha vestigios");
        System.out.println("escuros perto da guarda.");
        System.out.println("O objeto pode corresponder ao ferimento");
        System.out.println("encontrado na cabine de Augusto.");
        System.out.println();
        System.out.println("O punhal estava escondido. Isso prova");
        System.out.println("que alguem tentou retirar a arma");
        System.out.println("de circulacao, mas nao revela quem");
        System.out.println("a colocou ali.");

        encontrouArma = true;
    }

    // CASO 002 - INTERROGATORIOS

    static void interrogarPassageiros() {

        System.out.println("\n========== PASSAGEIROS ==========");
        System.out.println("1 - Antonio Ferraz");
        System.out.println("2 - Cecilia Albuquerque");
        System.out.println("3 - Henrique Velanza");
        System.out.println("4 - Isabel Montenegro");
        System.out.println("5 - Thomaz Azevedo");
        System.out.println("6 - Olivia Duarte");
        System.out.println("7 - Caio");
        System.out.print("Quem deseja interrogar? ");

        int opcao = lerOpcao();

        if (opcao < 1 || opcao > 7) {
            System.out.println("\nPassageiro invalido.");
            return;
        }

        if (entrevistasCaso002[opcao - 1] >= 2) {
            System.out.println("\nVoce ja realizou as duas entrevistas");
            System.out.println("com esse passageiro.");
            return;
        }

        entrevistasCaso002[opcao - 1]++;

        switch (opcao) {
            case 1:
                interrogarAntonio();
                break;
            case 2:
                interrogarCecilia();
                break;
            case 3:
                interrogarHenrique();
                break;
            case 4:
                interrogarIsabel();
                break;
            case 5:
                interrogarThomaz();
                break;
            case 6:
                interrogarOlivia();
                break;
            case 7:
                interrogarCaio();
                break;
        }
    }

    static void interrogarAntonio() {

        if (entrevistasCaso002[0] == 1) {
            System.out.println("\nANTONIO FERRAZ:");
            System.out.println("\"Augusto era meu amigo e parceiro");
            System.out.println("de negocios. Discutimos algumas vezes,");
            System.out.println("mas nada que justificasse uma tragedia.\"");
        } else {
            System.out.println("\nANTONIO FERRAZ:");
            System.out.println("\"Augusto investiu dinheiro em um projeto");
            System.out.println("ligado a uma pianista. O negocio fracassou");
            System.out.println("e houve uma perda consideravel.");
            System.out.println("Ele dizia que alguem teria de responder");
            System.out.println("por aquele prejuizo.\"");
        }
    }

    static void interrogarCecilia() {

        if (entrevistasCaso002[1] == 1) {
            System.out.println("\nCECILIA ALBUQUERQUE:");
            System.out.println("\"Augusto era meu marido.");
            System.out.println("Nosso casamento nao estava bem,");
            System.out.println("mas eu jamais desejaria sua morte.\"");
        } else {
            System.out.println("\nCECILIA ALBUQUERQUE:");
            System.out.println("\"Augusto vinha escondendo problemas");
            System.out.println("financeiros de mim.");
            System.out.println("Recebeu uma carta pouco antes da viagem");
            System.out.println("e ficou bastante nervoso.");
            System.out.println("Ele mencionou uma mulher, mas nao");
            System.out.println("quis dizer o nome.\"");
        }
    }

    static void interrogarHenrique() {

        if (entrevistasCaso002[2] == 1) {
            System.out.println("\nHENRIQUE VELANZA:");
            System.out.println("\"Sou medico e conhecia Augusto.");
            System.out.println("Quando o encontrei, ele ja estava morto.\"");
        } else {
            System.out.println("\nHENRIQUE VELANZA:");
            System.out.println("\"A lesao nao parece ter sido causada");
            System.out.println("por um objeto grande.");
            System.out.println("O ferimento e compativel com um");
            System.out.println("instrumento estreito e pontiagudo.");
            System.out.println("A vitima provavelmente estava proxima");
            System.out.println("do agressor quando foi atingida.\"");
        }
    }

    static void interrogarIsabel() {

        if (entrevistasCaso002[3] == 1) {
            System.out.println("\nISABEL MONTENEGRO:");
            System.out.println("\"Sou pianista. Estava viajando para");
            System.out.println("uma apresentacao.");
            System.out.println("Conhecia Augusto apenas de vista.\"");
        } else {
            System.out.println("\nISABEL MONTENEGRO:");
            System.out.println("\"Augusto era um homem dificil.");
            System.out.println("Ele investiu em um projeto musical meu,");
            System.out.println("mas o negocio fracassou.");
            System.out.println("Perdi muito dinheiro naquela epoca.");
            System.out.println("Isso nao significa que eu o tenha matado.\"");
            System.out.println();
            System.out.println("Ao terminar, Isabel evita olhar");
            System.out.println("diretamente para voce.");
        }
    }

    static void interrogarThomaz() {

        if (entrevistasCaso002[4] == 1) {
            System.out.println("\nTHOMAZ AZEVEDO:");
            System.out.println("\"Sou advogado e conhecia Augusto.");
            System.out.println("Ele tinha assuntos juridicos pendentes.\"");
        } else {
            System.out.println("\nTHOMAZ AZEVEDO:");
            System.out.println("\"Augusto estava envolvido em uma");
            System.out.println("disputa financeira.");
            System.out.println("Havia um contrato de investimento");
            System.out.println("que terminou em prejuizo para ele.");
            System.out.println("A outra parte era uma artista, mas");
            System.out.println("nao posso revelar mais sem provas.\"");
        }
    }

    static void interrogarOlivia() {

        if (entrevistasCaso002[5] == 1) {
            System.out.println("\nOLIVIA DUARTE:");
            System.out.println("\"Sou jornalista.");
            System.out.println("Estava viajando para investigar");
            System.out.println("uma historia sobre empresarios.\"");
        } else {
            System.out.println("\nOLIVIA DUARTE:");
            System.out.println("\"Ouvi comentarios sobre Augusto");
            System.out.println("e uma pessoa ligada a musica.");
            System.out.println("Tambem ouvi que um funcionario do trem");
            System.out.println("estava sempre por perto dessa pessoa.");
            System.out.println("Nao consegui descobrir o motivo.\"");
        }
    }

    static void interrogarCaio() {

        if (entrevistasCaso002[6] == 1) {
            System.out.println("\nCAIO:");
            System.out.println("\"Sou funcionario do trem.");
            System.out.println("Conheco a rotina dos vagoes e estava");
            System.out.println("trabalhando naquela noite.\"");
        } else {
            System.out.println("\nCAIO:");
            System.out.println("\"Conheco cada corredor deste trem.");
            System.out.println("Sei os horarios dos funcionarios");
            System.out.println("e os momentos em que os vagoes ficam vazios.\"");
            System.out.println();
            if (encontrouBilheteEncontro) {
                System.out.println("Ao ver o bilhete encontrado no estojo,");
                System.out.println("Caio perde a cor por um instante.");
                System.out.println("\"Nao sei de quem e essa letra.");
                System.out.println("Deve ter sido deixado por algum passageiro.\"");
            } else {
                System.out.println("Ao ser questionado sobre a cabine");
                System.out.println("de Augusto, Caio hesita.");
                System.out.println("\"Nao tenho nada a esconder.\"");
            }
        }
    }

    // CASO 002 - QUADRO DE PISTAS

    public static void consultarPistasCaso002() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          QUADRO DE PISTAS");
        System.out.println("======================================");

        boolean encontrouAlgumaPista = false;

        if (encontrouMancha) {
            System.out.println();
            System.out.println("PISTA 1 - CABINE DE AUGUSTO");
            System.out.println("Ha sinais de luta e vestigios de sangue.");
            System.out.println("O ferimento foi causado por algo fino");
            System.out.println("e pontiagudo.");
            encontrouAlgumaPista = true;
        }

        if (encontrouBilhete) {
            System.out.println();
            System.out.println("PISTA 2 - BILHETE AMEACADOR");
            System.out.println("O papel encontrado no restaurante diz:");
            System.out.println("\"Voce vai pagar pelo que fez.\"");
            encontrouAlgumaPista = true;
        }

        if (encontrouMarcas) {
            System.out.println();
            System.out.println("PISTA 3 - MARCAS NA PASSAGEM");
            System.out.println("Marcas recentes seguem em direcao");
            System.out.println("ao vagao de bagagens.");
            encontrouAlgumaPista = true;
        }

        if (encontrouMala) {
            System.out.println();
            System.out.println("PISTA 4 - MALA MEXIDA");
            System.out.println("O forro de uma mala esconde um");
            System.out.println("compartimento que foi aberto as pressas.");
            encontrouAlgumaPista = true;
        }

        if (encontrouArma) {
            System.out.println();
            System.out.println("PISTA 5 - PUNHAL DE MADREPEROLA");
            System.out.println("Um punhal fino foi encontrado no");
            System.out.println("compartimento escondido da mala.");
            System.out.println("A arma pode corresponder ao ferimento.");
            encontrouAlgumaPista = true;
        }

        if (encontrouRelogio) {
            System.out.println();
            System.out.println("PISTA 6 - RELOGIO DE BOLSO");
            System.out.println("O relogio encontrado no vagao dos");
            System.out.println("funcionarios parou as 22h20.");
            encontrouAlgumaPista = true;
        }

        if (encontrouEstojo) {
            System.out.println();
            System.out.println("PISTA 7 - ESTOJO DE PARTITURAS");
            System.out.println("Um estojo de partituras foi escondido");
            System.out.println("em um espaco pouco visivel.");
            encontrouAlgumaPista = true;
        }

        if (encontrouBilheteEncontro) {
            System.out.println();
            System.out.println("PISTA 8 - BILHETE DE ENCONTRO");
            System.out.println("O bilhete fala sobre um encontro depois");
            System.out.println("da troca de turno e traz as letras I e C.");
            System.out.println("Ainda nao e possivel afirmar quem");
            System.out.println("escreveu ou a natureza da relacao.");
            encontrouAlgumaPista = true;
        }

        if (!encontrouAlgumaPista) {
            System.out.println();
            System.out.println("Voce ainda nao encontrou pistas.");
            System.out.println("Investigue os vagoes primeiro.");
        }

        System.out.println();
        System.out.println("======================================");
        System.out.println("ENTREVISTAS REALIZADAS:");

        String[] passageiros = {
            "Antonio Ferraz",
            "Cecilia Albuquerque",
            "Henrique Velanza",
            "Isabel Montenegro",
            "Thomaz Azevedo",
            "Olivia Duarte",
            "Caio"
        };

        for (int i = 0; i < passageiros.length; i++) {
            System.out.println(passageiros[i] + ": " + entrevistasCaso002[i] + "/2");
        }

        System.out.println("======================================");
    }

    // CASO 002 - ACUSACAO FINAL

    static void fazerAcusacaoCaso002() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          ACUSACAO FINAL");
        System.out.println("======================================");
        System.out.println("1 - Antonio Ferraz");
        System.out.println("2 - Cecilia Albuquerque");
        System.out.println("3 - Henrique Velanza");
        System.out.println("4 - Isabel Montenegro");
        System.out.println("5 - Thomaz Azevedo");
        System.out.println("6 - Olivia Duarte");
        System.out.println("7 - Caio");
        System.out.println("8 - Voltar");
        System.out.println("======================================");
        System.out.print("Quem voce acusa? ");

        int acusacao = lerOpcao();

        if (acusacao == 8) {
            System.out.println("Acusacao cancelada.");
            return;
        }

        if (acusacao < 1 || acusacao > 7) {
            System.out.println("Opcao invalida.");
            return;
        }

        if (acusacao == 4) {
            System.out.println();
            System.out.println("======================================");
            System.out.println("             CASO RESOLVIDO");
            System.out.println("======================================");
            System.out.println("PARABENS, DETETIVE!");
            System.out.println();
            System.out.println("Isabel Montenegro foi a responsavel");
            System.out.println("pela morte de Augusto Vasconcelos.");
            System.out.println();
            System.out.println("Augusto havia investido no projeto");
            System.out.println("musical de Isabel. Quando o negocio");
            System.out.println("fracassou, ela perdeu muito dinheiro.");
            System.out.println("A disputa financeira se transformou");
            System.out.println("em ressentimento e desejo de vinganca.");
            System.out.println();
            System.out.println("Mas Isabel nao agiu sozinha.");
            System.out.println("Caio conhecia os horarios, os corredores");
            System.out.println("e os compartimentos do trem.");
            System.out.println("Ele facilitou a movimentacao e ajudou");
            System.out.println("a esconder o punhal.");
            System.out.println();
            System.out.println("O bilhete com as letras I e C revelou");
            System.out.println("que os dois mantinham um relacionamento");
            System.out.println("secreto. Caio ajudou Isabel porque");
            System.out.println("estava apaixonado por ela.");
            System.out.println();
            System.out.println("O relogio parado, as marcas nos corredores,");
            System.out.println("o compartimento escondido e as mentiras");
            System.out.println("dos dois ajudaram a reconstruir o crime.");
            System.out.println();
            System.out.println("Voce solucionou o Caso 002!");
            System.out.println("======================================");
            caso002Resolvido = true;
            jogoAtivo = false;
        } else {
            String nome = "";
            switch (acusacao) {
                case 1: nome = "Antonio Ferraz"; break;
                case 2: nome = "Cecilia Albuquerque"; break;
                case 3: nome = "Henrique Velanza"; break;
                case 5: nome = "Thomaz Azevedo"; break;
                case 6: nome = "Olivia Duarte"; break;
                case 7: nome = "Caio"; break;
            }
            System.out.println();
            System.out.println("Voce acusou " + nome + ".");
            System.out.println("Mas as evidencias ainda nao sustentam");
            System.out.println("essa conclusao.");
            System.out.println("A investigacao continua. Reavalie as pistas.");
        }
    }
}
