package org.juliangranda.pooclasesabstractas.form.elementos;

    public abstract class ElementoForm {

        protected String valor;
        protected String nombre;

        public ElementoForm() {
        }

        public ElementoForm(String nombre) {
            this(); //Inicializar las listas.
            this.nombre = nombre;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        //Clase abstracta
        public abstract String dibujarHtml();

}
