const pistas = {
  documento: {
    titulo: "Documento rasgado",
    local: "Escritório de Arthur",
    texto: "Arthur escreveu: “Preciso resolver isso antes da meia-noite. Não posso confiar em R.C. novamente.” O restante do documento foi destruído. As iniciais podem ser importantes.",
    imagem: "https://images.unsplash.com/photo-1455390582262-044c42eef2a4?auto=format&fit=crop&w=900&q=85"
  },
  livro: {
    titulo: "Anotação na biblioteca",
    local: "Biblioteca",
    texto: "Um papel escondido em um livro contém a anotação: “22h20 - deixar o livro e ir ao escritório.” A anotação não tem assinatura.",
    imagem: "https://images.unsplash.com/photo-1507842217343-583bb7270b66?auto=format&fit=crop&w=900&q=85"
  },
  bilhete: {
    titulo: "Bilhete sobre dinheiro",
    local: "Cozinha",
    texto: "Ao lado de um copo quebrado, há um pedaço de papel: “O dinheiro precisa ser devolvido. Arthur não vai esperar mais.”",
    imagem: "https://images.unsplash.com/photo-1517842645767-c639042777db?auto=format&fit=crop&w=900&q=85"
  }
};

const depoimentos = {
  helena: {
    nome: "Helena · Governanta",
    texto: "“Eu estava preparando o jantar naquela noite. Por volta das 22h30, ouvi um barulho vindo do escritório de Arthur. Não fui verificar porque estava ocupada na cozinha. Arthur parecia preocupado nos últimos dias, mas nunca me contou o motivo.”"
  },
  ricardo: {
    nome: "Ricardo · Irmão de Arthur",
    texto: "“Eu estava na biblioteca lendo um livro. Não tinha motivo para entrar no escritório naquela noite. É verdade que Arthur e eu discutimos por causa de dinheiro, mas isso é um assunto de família. Eu jamais faria algo contra meu próprio irmão.”"
  },
  beatriz: {
    nome: "Beatriz · Sobrinha de Arthur",
    texto: "“Eu estava no jardim quando tudo aconteceu. Precisava de um pouco de ar. Meu tio estava estranho naquela noite e parecia desconfiar de alguém. Não sei quem poderia querer machucá-lo.”"
  },
  daniel: {
    nome: "Daniel · Mordomo",
    texto: "“Eu estava organizando o salão para o encerramento da festa. Passei pelo corredor do escritório por volta das 22h45, mas a porta estava fechada. Não vi ninguém entrando ou saindo.”"
  }
};

const salas = {
  escritorio: { nome: "Escritório de Arthur", pista: "documento", descricao: "A sala está desorganizada. Sobre a mesa, entre papéis espalhados, você encontra um documento rasgado." },
  biblioteca: { nome: "Biblioteca", pista: "livro", descricao: "Entre as estantes, um livro está aberto sobre uma poltrona. Há um pequeno papel escondido entre as páginas." },
  cozinha: { nome: "Cozinha", pista: "bilhete", descricao: "Perto da pia há um copo quebrado. Ao lado dos cacos, você encontra um pedaço de papel." }
};

let pistasEncontradas = JSON.parse(localStorage.getItem("carvalho_pistas") || "[]");
let interrogados = JSON.parse(localStorage.getItem("carvalho_interrogados") || "[]");
let casoEncerrado = localStorage.getItem("carvalho_encerrado") === "true";

function mostrarTela(nome) {
  document.querySelectorAll(".screen").forEach(tela => tela.classList.add("hidden"));
  const tela = document.getElementById("tela-" + nome);
  if (tela) tela.classList.remove("hidden");

  document.querySelectorAll(".nav-button").forEach(botao => {
    botao.classList.toggle("active", botao.dataset.nav === nome);
  });

  if (nome === "pistas") renderizarPistas();
  atualizarInterface();
  window.scrollTo({ top: 0, behavior: "smooth" });
}

function investigar(local) {
  const sala = salas[local];
  if (!sala) return;

  const jaEncontrou = pistasEncontradas.includes(sala.pista);
  const pista = pistas[sala.pista];
  const painel = document.getElementById("resultadoInvestigacao");

  painel.classList.remove("hidden");
  painel.innerHTML = `
    <span class="evidence-label">${sala.nome.toUpperCase()}</span>
    <h3>${jaEncontrou ? "Você já esteve aqui" : "Nova descoberta"}</h3>
    <p>${sala.descricao}\n\n${pista.texto}</p>
    <button class="outline-button" onclick="mostrarTela('pistas')">Abrir quadro de evidências →</button>
  `;

  if (!jaEncontrou) {
    pistasEncontradas.push(sala.pista);
    salvarProgresso();
    mostrarToast("Nova evidência adicionada ao quadro.");
  }
  atualizarInterface();
}

function interrogar(id) {
  const depoimento = depoimentos[id];
  if (!depoimento) return;

  const painel = document.getElementById("resultadoInterrogatorio");
  const jaInterrogou = interrogados.includes(id);
  painel.classList.remove("hidden");
  painel.innerHTML = `
    <span class="evidence-label">REGISTRO DE INTERROGATÓRIO</span>
    <h3>${depoimento.nome}</h3>
    <p>${depoimento.texto}${jaInterrogou ? "\n\nEste depoimento já foi registrado anteriormente." : ""}</p>
  `;

  if (!jaInterrogou) {
    interrogados.push(id);
    salvarProgresso();
    mostrarToast("Depoimento registrado.");
  }
  atualizarInterface();
}

function renderizarPistas() {
  const lista = document.getElementById("listaPistas");
  if (pistasEncontradas.length === 0) {
    lista.innerHTML = `<div class="detail-panel"><h3>Nenhuma evidência coletada</h3><p>Visite os cômodos da mansão para encontrar as primeiras pistas.</p><button class="outline-button" onclick="mostrarTela('investigacao')">Investigar a mansão →</button></div>`;
    return;
  }

  const imagens = {
    documento: "https://images.unsplash.com/photo-1455390582262-044c42eef2a4?auto=format&fit=crop&w=900&q=85",
    livro: "https://images.unsplash.com/photo-1507842217343-583bb7270b66?auto=format&fit=crop&w=900&q=85",
    bilhete: "https://images.unsplash.com/photo-1517842645767-c639042777db?auto=format&fit=crop&w=900&q=85"
  };

  lista.innerHTML = pistasEncontradas.map(id => {
    const p = pistas[id];
    return `<article class="clue-card">
      <img src="${imagens[id]}" alt="${p.titulo}" onerror="this.style.display='none'">
      <div class="clue-info"><span class="clue-tag">${p.local.toUpperCase()}</span><h3>${p.titulo}</h3><p>${p.texto}</p></div>
    </article>`;
  }).join("");
}

function acusar(id) {
  const resultado = document.getElementById("resultadoAcusacao");
  resultado.classList.remove("hidden");

  if (casoEncerrado) {
    resultado.innerHTML = "<h3>Este caso já foi encerrado.</h3><p>Inicie uma nova investigação para jogar novamente.</p><button onclick='reiniciarCaso()'>Nova investigação</button>";
    return;
  }

  if (id === "ricardo") {
    resultado.innerHTML = `<h3> Caso resolvido, detetive.</h3><p>Você identificou Ricardo Carvalho como responsável pela morte de Arthur. As iniciais R.C. no documento, a discussão sobre dinheiro e o bilhete encontrado na cozinha apontam para ele. Ricardo mentiu sobre sua noite na biblioteca. Arthur havia descoberto que o próprio irmão estava envolvido em algo que não poderia mais esconder.</p><button onclick="reiniciarCaso()">Jogar novamente</button>`;
  } else {
    const nomes = { helena: "Helena", beatriz: "Beatriz", daniel: "Daniel" };
    resultado.innerHTML = `<h3>Acusação incorreta</h3><p>Você acusou ${nomes[id]}, mas as evidências não confirmam essa conclusão. O verdadeiro culpado continua livre. Você pode reiniciar o caso e investigar novamente.</p><button onclick="reiniciarCaso()">Tentar novamente</button>`;
  }

  casoEncerrado = true;
  localStorage.setItem("carvalho_encerrado", "true");
  mostrarToast("Investigação encerrada.");
}

function reiniciarCaso() {
  pistasEncontradas = [];
  interrogados = [];
  casoEncerrado = false;
  localStorage.removeItem("carvalho_pistas");
  localStorage.removeItem("carvalho_interrogados");
  localStorage.removeItem("carvalho_encerrado");
  document.getElementById("resultadoAcusacao").classList.add("hidden");
  document.getElementById("resultadoInvestigacao").classList.add("hidden");
  document.getElementById("resultadoInterrogatorio").classList.add("hidden");
  mostrarTela("inicio");
  mostrarToast("Uma nova investigação começou.");
}

function salvarProgresso() {
  localStorage.setItem("carvalho_pistas", JSON.stringify(pistasEncontradas));
  localStorage.setItem("carvalho_interrogados", JSON.stringify(interrogados));
}

function atualizarInterface() {
  document.getElementById("contadorPistas").textContent = pistasEncontradas.length;
  document.getElementById("resumoPistas").textContent = `${pistasEncontradas.length} DE 3 EVIDÊNCIAS`;

  Object.keys(salas).forEach(id => {
    const status = document.getElementById("status-" + id);
    if (status) {
      const achou = pistasEncontradas.includes(salas[id].pista);
      status.textContent = achou ? "INVESTIGADO · EVIDÊNCIA COLETADA" : "NÃO INVESTIGADO";
      status.classList.toggle("done", achou);
    }
  });

  Object.keys(depoimentos).forEach(id => {
    const status = document.getElementById("status-" + id);
    if (status) {
      const feito = interrogados.includes(id);
      status.textContent = feito ? "DEPOIMENTO REGISTRADO" : "NÃO INTERROGADO";
      status.classList.toggle("done", feito);
    }
  });
}

let toastTimer;
function mostrarToast(mensagem) {
  const toast = document.getElementById("toast");
  toast.textContent = mensagem;
  toast.classList.add("show");
  clearTimeout(toastTimer);
  toastTimer = setTimeout(() => toast.classList.remove("show"), 2600);
}

atualizarInterface();
