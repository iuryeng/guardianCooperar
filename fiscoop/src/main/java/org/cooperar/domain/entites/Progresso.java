package org.cooperar.domain.entites;

import org.cooperar.domain.enums.StatusProgresso;

import java.time.LocalDate;

public class Progresso {

   private float percentualConcluido;
   private LocalDate dataInicio;
   private LocalDate dataFim;
   private final StatusProgresso status;

   public Progresso() {
      this.percentualConcluido = 0;
      this.dataInicio = null;
      this.dataFim = null;
      this.status = StatusProgresso.NAO_INICIADA;
   }

   public Progresso(float percentualConcluido, LocalDate dataInicio, LocalDate dataFim, StatusProgresso status) {
      this.percentualConcluido = percentualConcluido;
      this.dataInicio = dataInicio;
      this.dataFim = dataFim;
      this.status = status;
   }

   public float getPercentualConcluido() {
      return percentualConcluido;
   }

   public void setPercentualConcluido(float percentualConcluido) {
      this.percentualConcluido = percentualConcluido;
   }

   public LocalDate getDataInicio() {
      return dataInicio;
   }

   public void setDataInicio(LocalDate dataInicio) {
      this.dataInicio = dataInicio;
   }

   public LocalDate getDataFim() {
      return dataFim;
   }

   public void setDataFim(LocalDate dataFim) {
      this.dataFim = dataFim;
   }

   public StatusProgresso getStatus() {
      return status;
   }
}
