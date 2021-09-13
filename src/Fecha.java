import java.time.LocalDate;

public class Fecha {

    private int anio;
    private int mes;
    private int dia;

    public Fecha(){
        dia = LocalDate.now().getDayOfMonth();
        mes = LocalDate.now().getMonthValue();
        anio = LocalDate.now().getYear();
    }

    public Fecha(int anio, int mes, int dia) {
        if(anio > 0){
            this.anio = anio;
        }
        if(mes > 0 && mes < 13){
            this.mes = mes;
        }

        if((mes == 1 || mes == 3 || mes == 5 || mes==7 || mes == 8 || mes == 10 || mes == 12) && dia <32){
            this.dia = dia;
        }

        if(mes == 4 || mes == 6 || mes== 9 || mes == 11 &&  dia <31){
            this.dia = dia;
        }

        if(mes == 2 ) {
            if (anio % 4 == 0 && dia < 30) {
                this.dia = dia;
            } else if (dia < 29) {
                this.dia = dia;
            }
        }

    }


    public void avanzaDias(int dia){
        if(dia < 30) {
            dia++;
        }
    }

    public void retrocedeDias(int dia){
        if(dia > 1) {
            dia--;
        }
    }

    public boolean esMismoDia(Fecha fecha){
        boolean valida = false;
        if(anio == fecha.anio && mes == fecha.mes  && dia == fecha.dia){
            valida = true;
        }
        return valida;
    }

    public String format(String format) {
        return this.dia + "/" + this.mes + "/" + this.anio;
    }

    public int diferenciaEnAnios(Fecha fechaActual) {
        int diferenciaAnios;
        if(anio>fechaActual.anio){
            diferenciaAnios = anio - fechaActual.anio;
        }
        else{
            diferenciaAnios = fechaActual.anio - anio;
        }
        return diferenciaAnios;
    }

    public boolean isAfter(Fecha fecha) {
        boolean valida = false;
        if(fecha.anio < anio){
            valida = true;
        }
            else if(fecha.anio - anio == 0 && fecha.mes < mes){
                valida = true;
            }
                else if(fecha.mes - mes == 0 && fecha.dia < dia){
                    valida = true;
            }
        return valida;
    }

    public int diferenciaEnDias(Fecha fecha) {
        int diferenciaDias;
        int diasMes;

        if(mes>fecha.mes){
            diasMes = mes - fecha.mes;
        }
        else {
            diasMes = fecha.mes - mes;
        }
        diasMes = diasMes * 30;

        if(dia>fecha.dia){
            diferenciaDias = dia - fecha.dia;
        }
        else {
            diferenciaDias = fecha.dia - dia;
        }
        return diferenciaDias+diasMes;
    }

    public boolean isBefore(Fecha fecha) {
        boolean valida = false;
        if(fecha.anio > anio){
            valida = true;
        }
        else if(fecha.anio - anio == 0 && fecha.mes > mes){
            valida = true;
        }
        else if(fecha.mes - mes == 0 && fecha.dia > dia){
            valida = true;
        }
        return valida;
    }
}