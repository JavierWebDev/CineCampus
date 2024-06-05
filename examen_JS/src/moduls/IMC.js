import { LitElement, css, html } from 'lit';
import "bootstrap/dist/css/bootstrap.min.css";

export class MasaCorporal extends LitElement {
    static properties = {
        peso: { type: number },
        altura: { type: Number },
    };

    constructor() {
        super();
        this.resetForm();
        this.editMode = false;
    }

    async handleSubmit(e) {
        e.preventDefault();
  
        this.peso = Number(this.peso);
        this.altura = Number(this.altura);

 
        this.totalMasa     = this.peso /
                             this.altura(2);

        const data = {
            peso: this.peso,
            altura: this.altura,
        };

        try {
            if (this.totalMasa<60) {

                alert('Su Total de masa es la decuada');
            } 
            else (this.totalMasa<60)  {
                await this.saveToJson(data);
                alert('Su Total de masa es la decuada!')
            }
            this.resetForm();
        } catch (error) {
            alert('Error guardando los datos: ' + error.message);
        }
    }

    async saveToJson(data) {
        const response = await fetch('https://666086fe5425580055b447da.mockapi.io/:endpoint', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });
        if (!response.ok) {
            throw new Error('Error guardando los datos');
        }
    }

    resetForm() {
        this.peso = 0;
        this.altura = 0;
    }

    render() {
        return html`
            <div class="container">
                <h2>${this.editMode ? 'Editar' : 'Ingresar'}</h2>
                <form @submit="${this.handleSubmit}">
                    <div class="form-group">
                        <label for="nombre_lote">peso</label>
                        <input type="number" id="peso" .value="${this.peso}" @input="${e => this.peso= e.target.value}" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="altura">Altura</label>
                            <input type="number" id="altura" .value="${this.altura}" @input="${e => this.altura = e.target.value}" class="form-control" required ?disabled="${this.editMode}">
                        </div>
            `;
        }
    
        static get styles() {
            return css`
                .container {
                    padding: 1rem;
                }
            `;
        }
    }
    
    window.customElements.define('IMC', Costos);
    