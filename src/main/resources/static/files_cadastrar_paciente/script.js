$('#inputTelefone').mask("(99)9999-9999");
$('#inputCpf').mask("999.999.999-99");
$('#inputCep').mask("99999-999");

document.getElementById('formCadastro').addEventListener('submit', function(e) {
	const inputCpf = document.getElementById('inputCpf');
	inputCpf.value = somenteNumeros(inputCpf.value);
});

function somenteNumeros(string) {
	return string.replace(/\D+/g, '');
}

document.getElementById('formCadastro').addEventListener('submit', function(e) {
	const inputs = document.querySelectorAll('#formCadastro input');
	inputs.forEach(input => localStorage.setItem(input.id, input.value));
});

document.addEventListener('DOMContentLoaded', function() {
	const inputs = document.querySelectorAll('#formCadastro input');
	inputs.forEach(input => {
		const valorSalvo = localStorage.getItem(input.id);
		if (valorSalvo) {
			if (input.id === 'inputCpf') {
				input.value = valorSalvo.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
			} else {
				input.value = valorSalvo;
			}
		}
	});
});

window.addEventListener('beforeunload', function () {
    const form = document.getElementById('formCadastro');
    if (form.checkValidity() === true) {
        localStorage.clear();
		sessionStorage.clear();
    }
});