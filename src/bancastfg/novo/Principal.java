package bancastfg.novo;

import comp.JCalendar;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    private ArrayList<Professor> listaProfessores;
    private ArrayList<Banca> listaBancas;
    private ArrayList<Horario> calendarioBancas;

    String vetorSala[] = {"A", "B", "C", "D", "E", "F", "G"};
    private boolean primeiraVez = true;

    //verifica se o professor já está na lista de professores
    boolean verificaProfessorExiste(String nomeProfessor) {
        for (Professor p : listaProfessores) {
            if (p.getNome().equals(nomeProfessor)) {
                return true;
            }
        }
        return false;
    }

    Professor getProfessorPorNome(String nomeProfessor) {
        for (Professor p : listaProfessores) {
            if (p.getNome().equals(nomeProfessor)) {
                return p;
            }
        }
        return null;
    }

    public Principal() {
        initComponents();
        listaProfessores = new ArrayList<>();
        listaBancas = new ArrayList<>();
        calendarioBancas = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserXLS = new javax.swing.JFileChooser();
        jFileChooserXLSX = new javax.swing.JFileChooser();
        btnGerarHorario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbDataIncial = new comp.JCalendar(false);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spHoraInicial = new javax.swing.JSpinner();
        spHoraFinal = new javax.swing.JSpinner();
        spBancasPorHora = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBancas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRestricoes = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableHorarios = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jCBPausado = new javax.swing.JCheckBox();
        cbDataFinal = new comp.JCalendar(false);
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuImportar = new javax.swing.JMenuItem();
        menuImportar2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Excel 2003", new String[] { "xls", "XLS" });
        jFileChooserXLS.setFileFilter(filter1);
        jFileChooserXLS.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Excel 2007", new String[] { "xlsx", "XLSX" });
        jFileChooserXLSX.setFileFilter(filter2);
        jFileChooserXLSX.setAcceptAllFileFilterUsed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGerarHorario.setText("Gerar horário");
        btnGerarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarHorarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Data inicial:");

        cbDataIncial.setToolTipText("Data de início das bancas");
        cbDataIncial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDataIncialActionPerformed(evt);
            }
        });

        jLabel2.setText("Horário inicial:");

        jLabel3.setText("Horário final:");

        jLabel4.setText("Bancas por hora:");

        spHoraInicial.setModel(new javax.swing.SpinnerNumberModel(14, 0, 23, 1));

        spHoraFinal.setModel(new javax.swing.SpinnerNumberModel(18, 0, 23, 1));

        spBancasPorHora.setModel(new javax.swing.SpinnerNumberModel(3, 1, 5, 1));

        jLabel5.setText("Restrições");

        jTableBancas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Aluno", "Orientador", "Avaliador 1", "Avaliador 2"
            }
        ));
        jScrollPane1.setViewportView(jTableBancas);

        jLabel6.setText("Bancas");

        jTableRestricoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Professor", "Dia", "Hora"
            }
        ));
        jScrollPane3.setViewportView(jTableRestricoes);

        jTableHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Acadêmico", "Título do TFG", "Orientador", "Avaliador 1", "Avaliador 2", "Data", "Horário", "Local"
            }
        ));
        jTableHorarios.setDoubleBuffered(true);
        jTableHorarios.getColumnModel().getColumn(0).setPreferredWidth(300);
        jTableHorarios.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTableHorarios.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTableHorarios.getColumnModel().getColumn(7).setPreferredWidth(50);
        jScrollPane5.setViewportView(jTableHorarios);

        jLabel8.setText("Resultado:");

        jCBPausado.setText("Pausadamente");

        cbDataFinal.setToolTipText("Data de início das bancas");
        cbDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDataFinalActionPerformed(evt);
            }
        });

        jLabel7.setText("Data final:");

        jMenu1.setText("Importar");

        menuImportar.setText("Importar XLS");
        menuImportar.setName(""); // NOI18N
        menuImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuImportarActionPerformed(evt);
            }
        });
        jMenu1.add(menuImportar);

        menuImportar2.setText("Importar XLSX");
        menuImportar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuImportar2ActionPerformed(evt);
            }
        });
        jMenu1.add(menuImportar2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Importar Restrições");

        jMenuItem1.setText("Importar XLS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Importar XLSX");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(cbDataIncial, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(119, 119, 119)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spBancasPorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCBPausado)))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnGerarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDataIncial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spBancasPorHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBPausado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGerarHorario)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void processar() {
        final String strDataInicial = ((JCalendar) cbDataIncial).getText();
        final String strDataFinal = ((JCalendar) cbDataFinal).getText();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInicial = null;
        Date dataFinal = null;
        try {
            dataInicial = format.parse(strDataInicial);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Selecione uma data inicial!");
            return;
        }
        try {
            dataFinal = format.parse(strDataFinal);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Selecione uma data final!");
            return;
        }
        if (dataFinal.before(dataInicial)) {
            JOptionPane.showMessageDialog(this, "A data final precisa ser após a data inicial!");
            return;
        }
        /*
        adiciona as restrições as bancas, com base nas restrições dos professores
        a ideia é contabilizar quantas restrições cada banca tem e não repetir,
        pois podem ter 2 professores numa banca com a mesma restrição
         */
        limpaTabela(jTableHorarios);
        if (primeiraVez) {
            for (Banca b : listaBancas) {//para cada banca
                for (Professor p : b.getListaProfessores()) {//para cada professor da banca
                    for (Restricao r : p.getListaRestricoes()) {//para cada restricao do professor
                        b.addRestricao(r);//adiciona a restricao a banca
                    }
                }
            }
        }
        primeiraVez = false;
        calendarioBancas.clear();
        //ORDENA AS BANCAS DE FORMA DECRESCENTE DE QUANTIDADE DE RESTRICOES
        Collections.sort(listaBancas);

        //monta o calendario de bancas, vazio ate entao, encaixando as bancas nos horários de acordo com suas restrições
        final int diaInicial = Integer.parseInt(strDataInicial.split("/")[0]);
        final int mesInicial = Integer.parseInt(strDataInicial.split("/")[1]);
        final int anoInicial = Integer.parseInt(strDataInicial.split("/")[2]);
        final int horaInicial = (int) spHoraInicial.getValue();
        final int horaFinal = (int) spHoraFinal.getValue();
        final int bancasPorHora = (int) spBancasPorHora.getValue();

        String bancasExtrapoladas = "";
        for (Banca b : listaBancas) {//para cada banca
            int horaAtual = horaInicial;
            int diaAtual = diaInicial;
            int mesAtual = mesInicial;
            int anoAtual = anoInicial;
            do {
                boolean flag = true;
                for (Restricao r : b.getListaRestricoes()) {//para cada restricao da banca
                    int diaRestricao = r.getDia();
                    int horaRestricao = r.getHora();
                    if (diaRestricao == diaAtual && horaRestricao == horaAtual) {
                        flag = false;
                        break;
                    }
                }
                //se flag == true, então a banca pode acontecer naquele horário pois não há restricao \o/
                if (flag) {
                    boolean horarioJaExiste = false;
                    /*
                    mas antes de adicionar a banca no horario, é preciso verificar se algum professor 
                    dessa banca ja não está nesse horário :S
                     */
                    for (Horario hh : calendarioBancas) {//para cada horario ja registrado
                        if (hh.getDia() == diaAtual && hh.getHora() == horaAtual) {//caso tenha um horario registrado já com a data atual
                            horarioJaExiste = true;
                            for (Banca bh : hh.getListaBancas()) {//para cada banca no horario
                                for (Professor ph : bh.getListaProfessores()) {//para cada professor daquela banca daquele horario
                                    for (Professor padd : b.getListaProfessores()) {//para cada professor da banca que está sendo adicionada
                                        if (ph.getNome().equals(padd.getNome())) {//se o professor ja tiver alguma banca naquele horario
                                            flag = false;//nao pode adicioná-lo naquele horario
                                            break;
                                        }
                                    }
                                    if (!flag) {
                                        break;
                                    }
                                }
                                if (!flag) {
                                    break;
                                }
                            }
                        }
                        if (!flag) {
                            break;
                        }
                        /*
                        se por acaso já existe um horário para aquela banca e o professor 
                        não esteja naquele horário, coloca ele nesse horário
                        
                         */
                    }
                    if (flag && !horarioJaExiste) {
                        Horario h = new Horario(anoAtual, mesAtual, diaAtual, horaAtual);
                        h.addBancaHorario(b);
                        calendarioBancas.add(h);
                        break;
                    } else if (flag && horarioJaExiste) {//se ja existe o horario, tenta adicionar a banca nele se não estourar as bancasPorHora
                        boolean estourouBancasPorHora = false;
                        for (Horario hh : calendarioBancas) {//para cada horario ja registrado
                            if (hh.getDia() == diaAtual && hh.getHora() == horaAtual) {
                                if (hh.getListaBancas().size() < bancasPorHora) {
                                    hh.addBancaHorario(b);
                                    break;
                                } else {
                                    estourouBancasPorHora = true;
                                    continue;
                                }
                            }
                        }
                        if (!estourouBancasPorHora) {
                            break;
                        }
                    }
                }
                horaAtual++;
                if (horaAtual >= horaFinal) {
                    horaAtual = horaInicial;
                    //verifica se, ao pular um dia, não caiu num sabado/domingo
                    Calendar c = Calendar.getInstance();
                    try {
                        Date data = format.parse(diaAtual + "/" + mesAtual + "/" + anoInicial);
                        c.setTime(data);
                        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {//se for sexta
                            //diaAtual+=3;
                            c.add(Calendar.DATE, 3);// pula 3 dias para segunda
                        } else {
                            c.add(Calendar.DATE, 1);//pula 1 dia
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    diaAtual = c.get(Calendar.DAY_OF_MONTH);
                    mesAtual = c.get(Calendar.MONTH) + 1;
                    anoAtual = c.get(Calendar.YEAR);
                    try {
                        //verifico se o horario já não extrapolou a data final/limite
                        Date dataAtual = format.parse(diaAtual + "/" + mesAtual + "/" + anoAtual);
                        if (dataAtual.after(dataFinal)) {
                            if (!bancasExtrapoladas.contains(b.getAluno())) {
                                bancasExtrapoladas = bancasExtrapoladas + "\n" + (b.getAluno());
                            }
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } while (true);

            if (jCBPausado.isSelected()) {
                atualizaTabelaHorarios();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (!bancasExtrapoladas.equals("")) {
            JOptionPane.showMessageDialog(this, "Algumas bancas extrapolaram a data limite:" + bancasExtrapoladas);
        }

        atualizaTabelaHorarios();
    }

    public void limpaTabela(JTable tabela) {
        DefaultTableModel linhasHorarios = (DefaultTableModel) tabela.getModel();
        linhasHorarios.setRowCount(0);
    }

    public void atualizaTabelaHorarios() {
        Collections.sort(calendarioBancas);
        DefaultTableModel linhasHorarios = (DefaultTableModel) jTableHorarios.getModel();
        linhasHorarios.setRowCount(0);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (Horario h : calendarioBancas) {
            for (int i = 0; i < h.getListaBancas().size(); i++) {
                Banca b = h.getListaBancas().get(i);
                String linha[] = new String[8];
                linha[0] = b.getAluno();
                linha[1] = "<titulo>";
                linha[2] = b.getListaProfessores().get(0).getNome();
                linha[3] = b.getListaProfessores().get(1).getNome();
                linha[4] = b.getListaProfessores().get(2).getNome();
                Date data = null;
                try {
                    data = format.parse(h.getDia() + "/" + h.getMes() + "/" + "2016");

                } catch (ParseException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                linha[5] = format.format(data);
                linha[6] = h.getHora() + "h";
                linha[7] = vetorSala[i];
                linhasHorarios.addRow(linha);
            }
        }
    }
    private void btnGerarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarHorarioActionPerformed
        new Thread() {
            public void run() {

                processar();
            }
        }.start();
    }//GEN-LAST:event_btnGerarHorarioActionPerformed

    private void cbDataIncialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDataIncialActionPerformed

    }//GEN-LAST:event_cbDataIncialActionPerformed

    private void addLinhaBanca(DefaultTableModel model, String[] linha) {

        ArrayList<Professor> listaProfessoresBanca = new ArrayList<>();
        for (int i = 1; i < linha.length; i++) {
            String nomeProfessor = linha[i];
            if (!verificaProfessorExiste(nomeProfessor)) {
                Professor p = new Professor(nomeProfessor);
                listaProfessores.add(p);
                listaProfessoresBanca.add(p);
            } else {
                Professor p = getProfessorPorNome(nomeProfessor);
                listaProfessoresBanca.add(p);
            }
        }
        Banca b = new Banca();
        b.setAluno(linha[0]);
        b.setListaProfessores(listaProfessoresBanca);
        listaBancas.add(b);
        model.addRow(linha);
    }

    private void menuImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuImportarActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableBancas.getModel();
        model.setRowCount(0);
        jFileChooserXLS.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnVal = jFileChooserXLS.showOpenDialog(this);
        if (returnVal == jFileChooserXLS.APPROVE_OPTION) {
            File file = jFileChooserXLS.getSelectedFile();
            try {
                FileInputStream fileInput = new FileInputStream(file);
                HSSFWorkbook workbook = new HSSFWorkbook(fileInput);
                HSSFSheet planilha = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = planilha.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int cont = 0;
                    String linha[] = new String[4];
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                linha[cont] = cell.getStringCellValue();
                                break;
                        }
                        cont++;

                    }
                    addLinhaBanca(model, linha);
                }
                fileInput.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo.");
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_menuImportarActionPerformed

    private void menuImportar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuImportar2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableBancas.getModel();
        model.setRowCount(0);
        jFileChooserXLSX.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnVal = jFileChooserXLSX.showOpenDialog(this);
        if (returnVal == jFileChooserXLSX.APPROVE_OPTION) {
            File file = jFileChooserXLSX.getSelectedFile();
            try {
                FileInputStream fileInput = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
                XSSFSheet planilha = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = planilha.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int cont = 0;
                    String linha[] = new String[4];
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                linha[cont] = cell.getStringCellValue();
                                break;
                        }
                        cont++;

                    }
                    addLinhaBanca(model, linha);
                }
                fileInput.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo.");
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_menuImportar2ActionPerformed

    private void addLinhaRestricao(DefaultTableModel model, String[] linha) {
        String nomeProfessor = linha[0];
        int dia = Integer.parseInt(linha[1]);
        int hora = Integer.parseInt(linha[2]);
        Restricao r = new Restricao(dia, hora);
        //adiciona a restricao ao seu professor
        for (Professor p : listaProfessores) {
            if (p.getNome().equals(nomeProfessor)) {
                p.addRestricao(r);
                break;
            }
        }

        //adiciona a linha na tabela
        model.addRow(linha);
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableRestricoes.getModel();
        model.setRowCount(0);
        jFileChooserXLS.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnVal = jFileChooserXLS.showOpenDialog(this);
        if (returnVal == jFileChooserXLS.APPROVE_OPTION) {
            File file = jFileChooserXLS.getSelectedFile();
            try {
                FileInputStream fileInput = new FileInputStream(file);
                HSSFWorkbook workbook = new HSSFWorkbook(fileInput);
                HSSFSheet planilha = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = planilha.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int cont = 0;
                    String linha[] = new String[3];
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                linha[cont] = cell.getStringCellValue(); //pega o professor da restricao
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                linha[cont] = (int) (cell.getNumericCellValue()) + ""; //pega o dia e hora da restricao

                        }
                        cont++;

                    }
                    addLinhaRestricao(model, linha);
                    //model.addRow(linha);
                }
                fileInput.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo.");
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableRestricoes.getModel();
        model.setRowCount(0);
        jFileChooserXLSX.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnVal = jFileChooserXLSX.showOpenDialog(this);
        if (returnVal == jFileChooserXLSX.APPROVE_OPTION) {
            File file = jFileChooserXLSX.getSelectedFile();
            try {
                FileInputStream fileInput = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
                XSSFSheet planilha = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = planilha.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int cont = 0;
                    String linha[] = new String[3];
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                linha[cont] = cell.getStringCellValue(); //pega o professor da restricao
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                linha[cont] = (int) (cell.getNumericCellValue()) + ""; //pega o dia e hora da restricao

                        }
                        cont++;

                    }
                    addLinhaRestricao(model, linha);
                    //model.addRow(linha);
                }
                fileInput.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo.");
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cbDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDataFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDataFinalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarHorario;
    private javax.swing.JComboBox cbDataFinal;
    private javax.swing.JComboBox cbDataIncial;
    private javax.swing.JCheckBox jCBPausado;
    private javax.swing.JFileChooser jFileChooserXLS;
    private javax.swing.JFileChooser jFileChooserXLSX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableBancas;
    private javax.swing.JTable jTableHorarios;
    private javax.swing.JTable jTableRestricoes;
    private javax.swing.JMenuItem menuImportar;
    private javax.swing.JMenuItem menuImportar2;
    private javax.swing.JSpinner spBancasPorHora;
    private javax.swing.JSpinner spHoraFinal;
    private javax.swing.JSpinner spHoraInicial;
    // End of variables declaration//GEN-END:variables
}
