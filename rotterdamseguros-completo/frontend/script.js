const form = document.getElementById("form");
const resultado = document.getElementById("resultado");

form.addEventListener("submit", async (e) => {
e.preventDefault();

const data = {
nome: nome.value,
whatsapp: whatsapp.value,
cidade: cidade.value,
marca: marca.value,
modelo: modelo.value,
ano: parseInt(ano.value),
plano: plano.value
};

const res = await fetch("https://SEU_BACKEND_RENDER/api/simulacao", {
method: "POST",
headers: {"Content-Type": "application/json"},
body: JSON.stringify(data)
});

const json = await res.json();

resultado.innerHTML = `<p><strong>Valor estimado:</strong> R$ ${json.valorEstimado}</p>
<a href="${json.whatsappLink}" target="_blank">Falar no WhatsApp</a>`;
});