import { LitElement, css, html } from 'lit'
import "bootstrap/dist/css/bootstrap.min.css";

export class MyElement extends LitElement {
  static get properties() {
    return {

    }
  }

  constructor() {
    super()
  
  }

  render() {
    return html`
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Vale_Pro</title>
        <link rel="stylesheet" href="/node_modules/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="./src/index.css">
        <script type="module" src="/app.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>

        <div class="card">
        <div class="card-img"><div class="img"></div></div>
        <div class="card-title">Product title</div>
        <div class="card-subtitle">Product description. Lorem ipsum dolor sit amet, consectetur adipisicing elit.</div>
        <hr class="card-divider">
        <div class="card-footer">
            <div class="card-price"><span>$</span> 123.45</div>
            <button class="card-btn">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path d="m397.78 316h-205.13a15 15 0 0 1 -14.65-11.67l-34.54-150.48a15 15 0 0 1 14.62-18.36h274.27a15 15 0 0 1 14.65 18.36l-34.6 150.48a15 15 0 0 1 -14.62 11.67zm-193.19-30h181.25l27.67-120.48h-236.6z"></path><path d="m222 450a57.48 57.48 0 1 1 57.48-57.48 57.54 57.54 0 0 1 -57.48 57.48zm0-84.95a27.48 27.48 0 1 0 27.48 27.47 27.5 27.5 0 0 0 -27.48-27.47z"></path><path d="m368.42 450a57.48 57.48 0 1 1 57.48-57.48 57.54 57.54 0 0 1 -57.48 57.48zm0-84.95a27.48 27.48 0 1 0 27.48 27.47 27.5 27.5 0 0 0 -27.48-27.47z"></path><path d="m158.08 165.49a15 15 0 0 1 -14.23-10.26l-25.71-77.23h-47.44a15 15 0 1 1 0-30h58.3a15 15 0 0 1 14.23 10.26l29.13 87.49a15 15 0 0 1 -14.23 19.74z"></path></svg>
            </button>
        </div>
        </div>

        <div class="card">
        <div class="card-img"><div class="img"></div></div>
        <div class="card-title">Product title</div>
        <div class="card-subtitle">Product description. Lorem ipsum dolor sit amet, consectetur adipisicing elit.</div>
        <hr class="card-divider">
        <div class="card-footer">
            <div class="card-price"><span>$</span> 123.45</div>
            <button class="card-btn">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path d="m397.78 316h-205.13a15 15 0 0 1 -14.65-11.67l-34.54-150.48a15 15 0 0 1 14.62-18.36h274.27a15 15 0 0 1 14.65 18.36l-34.6 150.48a15 15 0 0 1 -14.62 11.67zm-193.19-30h181.25l27.67-120.48h-236.6z"></path><path d="m222 450a57.48 57.48 0 1 1 57.48-57.48 57.54 57.54 0 0 1 -57.48 57.48zm0-84.95a27.48 27.48 0 1 0 27.48 27.47 27.5 27.5 0 0 0 -27.48-27.47z"></path><path d="m368.42 450a57.48 57.48 0 1 1 57.48-57.48 57.54 57.54 0 0 1 -57.48 57.48zm0-84.95a27.48 27.48 0 1 0 27.48 27.47 27.5 27.5 0 0 0 -27.48-27.47z"></path><path d="m158.08 165.49a15 15 0 0 1 -14.23-10.26l-25.71-77.23h-47.44a15 15 0 1 1 0-30h58.3a15 15 0 0 1 14.23 10.26l29.13 87.49a15 15 0 0 1 -14.23 19.74z"></path></svg>
            </button>
        </div>
        </div>

        <div class="card">
        <div class="card-img"><div class="img"></div></div>
        <div class="card-title">Product title</div>
        <div class="card-subtitle">Product description. Lorem ipsum dolor sit amet, consectetur adipisicing elit.</div>
        <hr class="card-divider">
        <div class="card-footer">
            <div class="card-price"><span>$</span> 123.45</div>
            <button class="card-btn">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path d="m397.78 316h-205.13a15 15 0 0 1 -14.65-11.67l-34.54-150.48a15 15 0 0 1 14.62-18.36h274.27a15 15 0 0 1 14.65 18.36l-34.6 150.48a15 15 0 0 1 -14.62 11.67zm-193.19-30h181.25l27.67-120.48h-236.6z"></path><path d="m222 450a57.48 57.48 0 1 1 57.48-57.48 57.54 57.54 0 0 1 -57.48 57.48zm0-84.95a27.48 27.48 0 1 0 27.48 27.47 27.5 27.5 0 0 0 -27.48-27.47z"></path><path d="m368.42 450a57.48 57.48 0 1 1 57.48-57.48 57.54 57.54 0 0 1 -57.48 57.48zm0-84.95a27.48 27.48 0 1 0 27.48 27.47 27.5 27.5 0 0 0 -27.48-27.47z"></path><path d="m158.08 165.49a15 15 0 0 1 -14.23-10.26l-25.71-77.23h-47.44a15 15 0 1 1 0-30h58.3a15 15 0 0 1 14.23 10.26l29.13 87.49a15 15 0 0 1 -14.23 19.74z"></path></svg>
            </button>
        </div>
        </div>








        
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                console.log("dasdadasdadasd")
                const openAddModalBtn = document.getElementById('openAddModalBtn');
                const addModal = new bootstrap.Modal(document.getElementById('addModal'));
                openAddModalBtn.addEventListener('click', () => {
                    const addMateriaPrima = document.querySelector('#addModal materia-prima');
                    addMateriaPrima.resetForm();
                    addModal.show();
                });

                const openEditModalBtn = document.getElementById('openEditModalBtn');
                const editModal = new bootstrap.Modal(document.getElementById('editModal'));
                openEditModalBtn.addEventListener('click', async () => {
                    console.log("dasdadasdadasd")
                    const editMateriaPrima = document.querySelector('#editModal materia-prima');
                    await editMateriaPrima.handleEdit();
                    if (editMateriaPrima.editMode) {
                        editModal.show();
                    }
                });

                const deleteBtn = document.getElementById('deleteBtn');
                deleteBtn.addEventListener('click', async () => {
                    const deleteMateriaPrima = document.querySelector('#editModal materia-prima');
                    await deleteMateriaPrima.handleDelete();
                });
            });
        </script>
    </body>
    </html>
    
    `
  }

  _onClick() {
    this.count++
  }

  static get styles() {
    return css`
    
  
    `
  }
}

window.customElements.define('mi-element', MyElement)