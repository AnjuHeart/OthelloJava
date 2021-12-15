/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectothello;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author jybra
 */
public class MiniGameForm extends javax.swing.JFrame {

    boolean SecondPlayer;
    int BOTCOLOR;
    int board[][] = new int[8][8];
    JButton boardCells[][] = new JButton[8][8];
    int turn;
    boolean gameEnded = false;
    PassFrame test;
    MusicThread sound;

    public MiniGameForm() {
        initComponents();
    }

    public MiniGameForm(boolean Player2) {
        initComponents();
        this.SecondPlayer = Player2;
        if(!Player2){
            lblPlayer2.setText("Máquina(BLANCO)");
        }
        initializeBoard();
        turn = 2;
        if (turn == 2) {
            BOTCOLOR = 1;
        } else {
            BOTCOLOR = 2;
        }
        startGame();
        updateBoardOnMove();
        drawPossibleMove();
        test = new PassFrame();
        test.setLocationRelativeTo(null);
        test.setVisible(false);
        setMusic();
    }

    void setMusic() {

        sound = new MusicThread();
        sound.start();
    }

    void botTurn() {
        if (SecondPlayer == false && turn == BOTCOLOR) {
            lblPlayerTurn.setText("Máquina/Bot");
            List<JButton> PressableBot = new ArrayList<JButton>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (canClickSpot(i, j) == true && board[i][j] == 0) {
                        PressableBot.add(boardCells[i][j]);
                    }
                    boardCells[i][j].setEnabled(false);
                }
            }
            Timer timer = new Timer();

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    JButton[] PossibleBot = PressableBot.toArray(new JButton[0]);
                    int reserved = new Random().nextInt(PossibleBot.length);
                    PossibleBot[reserved].setEnabled(true);
                    PossibleBot[reserved].doClick();
                    PossibleBot[reserved].doClick();
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board.length; j++) {
                            boardCells[i][j].setEnabled(true);
                        }
                    }
                }

            };

            timer.schedule(task, 1000);

        }
    }

    void initializeBoard() {
        Color BoardGreen = new Color(4, 138, 69);
        Color CellBorder = new Color(25, 25, 25);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
                JButton btn = new JButton();
                btn.setBounds((j * 65) + 30, (i * 65) + 60, 65, 65);
                btn.setBorder(new LineBorder(CellBorder));
                btn.setVisible(true);
                btn.setBackground(BoardGreen);
                btn.setIcon(new ImageIcon(getClass().getResource("/proyectothello/ficha1.png")));
                btn.setName("btnX" + i + "Y" + j);

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        makeAMovement(btn);
                    }
                });

                boardCells[i][j] = btn;
                this.add(boardCells[i][j]);
            }
        }
    }

    void updateBoardOnMove() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                boardCells[i][j].setIcon(null);
                switch (board[i][j]) {
                    case 1:
                        boardCells[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectothello/ficha1.png")));
                        boardCells[i][j].setDisabledIcon(new ImageIcon(getClass().getResource("/proyectothello/ficha1.png")));
                        break;
                    case 2:
                        boardCells[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectothello/ficha2.png")));
                        boardCells[i][j].setDisabledIcon(new ImageIcon(getClass().getResource("/proyectothello/ficha2.png")));
                        break;
                    case 3:
                        boardCells[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectothello/ficha3.png")));
                        boardCells[i][j].setDisabledIcon(new ImageIcon(getClass().getResource("/proyectothello/ficha3.png")));
                        break;
                }
            }
        }
    }

    void checkPass() {
        int counterPossMove = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (canClickSpot(i, j) == true && board[i][j] == 0) {
                    counterPossMove++;
                }
            }
        }
        if (counterPossMove == 0) {
            switchPlayer();
            endGameCheck();
            if (gameEnded == false) {
                //PASS ROUTINE
                test.setlblPlayer(turn, SecondPlayer);
                test.setVisible(true);
                try {
                    ClassLoader CLDR = this.getClass().getClassLoader();
                    InputStream soundName = CLDR.getResourceAsStream("proyectothello/pass.wav");
                    AudioStream audioStream = new AudioStream(soundName);
                    AudioPlayer.player.start(audioStream);
                } catch (IOException ex) {
                    Logger.getLogger(MiniGameForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                Timer timer = new Timer();

                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        test.setVisible(false);
                    }

                };

                timer.schedule(task, 1000);

                drawPossibleMove();
            }
        }
    }

    JButton[] getAffectedCells(int row, int column) {
        List<String[]> affectedCells = new ArrayList<String[]>();

        //TO THE RIGHT
        List<String> couldBeAffected = new ArrayList<String>();
        int columnIterator = column;
        while (columnIterator < 7) {
            columnIterator++;
            int valorEn = board[row][columnIterator];
            if (valorEn == 0 || valorEn == turn) {
                if (valorEn == turn) {
                    String[] confirmedAffected = couldBeAffected.toArray(new String[0]);
                    affectedCells.add(confirmedAffected);
                }
                break;
            } else {
                String location = row + "," + columnIterator + "#";
                couldBeAffected.add(location);
            }
        }

        //TO THE LEFT
        couldBeAffected = new ArrayList<String>();
        columnIterator = column;
        while (columnIterator > 0) {
            columnIterator--;
            int valorEn = board[row][columnIterator];
            if (valorEn == 0 || valorEn == turn) {
                if (valorEn == turn) {
                    String[] confirmedAffected = couldBeAffected.toArray(new String[0]);
                    affectedCells.add(confirmedAffected);
                }
                break;
            } else {
                String location = row + "," + columnIterator + "#";
                couldBeAffected.add(location);
            }
        }

        //UPWARDS
        couldBeAffected = new ArrayList<String>();
        int rowIterator = row;
        while (rowIterator > 0) {
            rowIterator--;
            int valorEn = board[rowIterator][column];
            if (valorEn == 0 || valorEn == turn) {
                if (valorEn == turn) {
                    String[] confirmedAffected = couldBeAffected.toArray(new String[0]);
                    affectedCells.add(confirmedAffected);
                }
                break;
            } else {
                String location = rowIterator + "," + column + "#";
                couldBeAffected.add(location);
            }
        }

        //DOWNWARDS
        couldBeAffected = new ArrayList<String>();
        rowIterator = row;
        while (rowIterator < 7) {
            rowIterator++;
            int valorEn = board[rowIterator][column];
            if (valorEn == 0 || valorEn == turn) {
                if (valorEn == turn) {
                    String[] confirmedAffected = couldBeAffected.toArray(new String[0]);
                    affectedCells.add(confirmedAffected);
                }
                break;
            } else {
                String location = rowIterator + "," + column + "#";
                couldBeAffected.add(location);
            }
        }

        //DOOWN RIGHT
        couldBeAffected = new ArrayList<String>();
        rowIterator = row;
        columnIterator = column;
        while (rowIterator < 7 && columnIterator < 7) {
            rowIterator++;
            columnIterator++;
            int valorEn = board[rowIterator][columnIterator];
            if (valorEn == 0 || valorEn == turn) {
                if (valorEn == turn) {
                    String[] confirmedAffected = couldBeAffected.toArray(new String[0]);
                    affectedCells.add(confirmedAffected);
                }
                break;
            } else {
                String location = rowIterator + "," + columnIterator + "#";
                couldBeAffected.add(location);
            }
        }

        //DOOWN LEFT
        couldBeAffected = new ArrayList<String>();
        rowIterator = row;
        columnIterator = column;
        while (rowIterator < 7 && columnIterator > 0) {
            rowIterator++;
            columnIterator--;
            int valorEn = board[rowIterator][columnIterator];
            if (valorEn == 0 || valorEn == turn) {
                if (valorEn == turn) {
                    String[] confirmedAffected = couldBeAffected.toArray(new String[0]);
                    affectedCells.add(confirmedAffected);
                }
                break;
            } else {
                String location = rowIterator + "," + columnIterator + "#";
                couldBeAffected.add(location);
            }
        }

        //UP LEFT
        couldBeAffected = new ArrayList<String>();
        rowIterator = row;
        columnIterator = column;
        while (rowIterator > 0 && columnIterator > 0) {
            rowIterator--;
            columnIterator--;
            int valorEn = board[rowIterator][columnIterator];
            if (valorEn == 0 || valorEn == turn) {
                if (valorEn == turn) {
                    String[] confirmedAffected = couldBeAffected.toArray(new String[0]);
                    affectedCells.add(confirmedAffected);
                }
                break;
            } else {
                String location = rowIterator + "," + columnIterator + "#";
                couldBeAffected.add(location);
            }
        }
        //UP RIGHT
        couldBeAffected = new ArrayList<String>();
        rowIterator = row;
        columnIterator = column;
        while (rowIterator > 0 && columnIterator < 7) {
            rowIterator--;
            columnIterator++;
            int valorEn = board[rowIterator][columnIterator];
            if (valorEn == 0 || valorEn == turn) {
                if (valorEn == turn) {
                    String[] confirmedAffected = couldBeAffected.toArray(new String[0]);
                    affectedCells.add(confirmedAffected);
                }
                break;
            } else {
                String location = rowIterator + "," + columnIterator + "#";
                couldBeAffected.add(location);
            }
        }

        String arrayCoordinates = toArrayNotLostData(affectedCells);

        JButton[] arrayButtons = coordinateListTransform(arrayCoordinates);
        return arrayButtons;
    }

    JButton[] coordinateListTransform(String Coordinates) {
        List<JButton> toConvertBtn = new ArrayList<JButton>();
        if (Coordinates != "") {
            String[] btnListCoor = Coordinates.split("#");
            for (int i = 0; i < btnListCoor.length; i++) {
                String[] coordinate = btnListCoor[i].split(",");
                int posX = Integer.parseInt(coordinate[0]);
                int posY = Integer.parseInt(coordinate[1]);
                toConvertBtn.add(boardCells[posX][posY]);
            }
        }
        JButton[] Affected = toConvertBtn.toArray(new JButton[0]);
        return Affected;
    }

    void endGameCheck() {
        int countZero = 0;
        int player1Score = 0;
        int player2Score = 0;
        int possibleMoves = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                switch (board[i][j]) {
                    case 0:
                        countZero++;
                        if (canClickSpot(i, j) == true) {
                            possibleMoves++;
                        }
                        break;
                    case 1:
                        player1Score++;
                        break;
                    case 2:
                        player2Score++;
                        break;
                }
            }
        }
        lblScore1.setText(String.valueOf(player2Score));
        lblScore2.setText(String.valueOf(player1Score));

        if (player2Score == 0 || player1Score == 0 || countZero == 0 || possibleMoves == 0) {
            //THE GAME ENDED
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    boardCells[i][j].setEnabled(false);
                }
            }
            try {
                ClassLoader CLDR = this.getClass().getClassLoader();
                InputStream soundName = CLDR.getResourceAsStream("proyectothello/win.wav");
                AudioStream audioStream = new AudioStream(soundName);
                AudioPlayer.player.start(audioStream);
            } catch (IOException ex) {
                Logger.getLogger(MiniGameForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (turn == 1) {
                this.setTitle("El ganador es: Jugador 2");
            } else {
                this.setTitle("El ganador es: Jugador 1");
            }
            EndGamePop pop = new EndGamePop();
            pop.setLocationRelativeTo(null);
            pop.setLblWinner(turn);
            pop.setVisible(true);
            btnInstrucciones.setEnabled(false);
            btnSalir.setEnabled(false);

            Timer timer = new Timer();

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    pop.setVisible(false);
                    btnSalir.setEnabled(true);
                    btnInstrucciones.setEnabled(true);
                    btnReset.setVisible(true);
                }

            };

            timer.schedule(task, 5000);

            gameEnded = true;
        }
    }

    String toArrayNotLostData(List<String[]> AfectedStreams) {
        String toConvert = "";
        if (AfectedStreams.size() != 0) {
            for (int i = 0; i < AfectedStreams.size(); i++) {
                String[] each = AfectedStreams.get(i);
                for (int j = 0; j < each.length; j++) {
                    toConvert = toConvert + (each[j]);
                }
            }
        }
        return toConvert;
    }

    boolean canClickSpot(int row, int column) {
        JButton[] afectedCells = getAffectedCells(row, column);
        if (afectedCells.length == 0) {
            return false;
        } else {
            return true;
        }
    }

    void flipCells(JButton[] affectedCells) {
        for (int i = 0; i < affectedCells.length; i++) {
            String name = affectedCells[i].getName();
            int x = Integer.parseInt(name.substring(4, 5));
            int y = Integer.parseInt(name.substring(6, 7));

            if (board[x][y] == 1) {
                board[x][y] = 2;
            } else {
                board[x][y] = 1;
            }
        }

        try {
            ClassLoader CLDR = this.getClass().getClassLoader();
            InputStream soundName = CLDR.getResourceAsStream("proyectothello/piece.wav");
            AudioStream audioStream = new AudioStream(soundName);
            AudioPlayer.player.start(audioStream);
        } catch (IOException ex) {
            Logger.getLogger(MiniGameForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void startGame() {
        btnReset.setVisible(false);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                boardCells[i][j].setEnabled(true);
                boardCells[i][j].setIcon(null);
                board[i][j] = 0;
            }
        }
        lblPlayerTurn.setText("Jugador 1");
        this.setTitle("Othello - Turno del Jugador 1");
        board[3][3] = 1;
        board[4][4] = 1;
        board[3][4] = 2;
        board[4][3] = 2;
    }

    void switchPlayer() {
        if (turn == 1) {
            turn = 2;
        } else {
            turn = 1;
        }
        String realturn;
        if (turn == 1) {
            realturn = "2";
        } else {
            realturn = "1";
        }
        lblPlayerTurn.setText("Jugador " + realturn);
        this.setTitle("Ohello - Turno del Jugador " + realturn);
        if (SecondPlayer == false && turn == BOTCOLOR) {
            this.setTitle("Othello - Turno de la máquina");
        }
    }

    public void makeAMovement(JButton pressedBtn) {
        String name = pressedBtn.getName();
        int posX = Integer.parseInt(name.substring(4, 5));
        int posY = Integer.parseInt(name.substring(6, 7));

        if (board[posX][posY] == 0) {
            if (canClickSpot(posX, posY) == true) {
                JButton[] affectedCells = getAffectedCells(posX, posY);
                flipCells(affectedCells);
                board[posX][posY] = turn;
                updateBoardOnMove();
                switchPlayer();
                drawPossibleMove();
                checkPass();
                if (gameEnded == false) {
                    endGameCheck();
                }
                if (gameEnded == false) {
                    botTurn();
                }
            }
        }
    }

    void drawPossibleMove() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (canClickSpot(i, j) == true && board[i][j] == 0) {
                    if (SecondPlayer == true || turn != BOTCOLOR) {
                        boardCells[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectothello/ficha3.png")));
                    } else {
                        boardCells[i][j].setIcon(null);
                    }

                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        panelScore = new javax.swing.JPanel();
        lblPlayer1 = new javax.swing.JLabel();
        lblScore1 = new javax.swing.JLabel();
        lblScore2 = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        panelTurno = new javax.swing.JPanel();
        lblPlayerTurn = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnInstrucciones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Othello");

        panelScore.setBorder(javax.swing.BorderFactory.createTitledBorder("Puntuación"));

        lblPlayer1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPlayer1.setText("Jugador 1 (NEGRO)");

        lblScore1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblScore1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore1.setText("2");

        lblScore2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblScore2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore2.setText("2");

        lblPlayer2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer2.setText("Jugador 2 (BLANCO)");

        javax.swing.GroupLayout panelScoreLayout = new javax.swing.GroupLayout(panelScore);
        panelScore.setLayout(panelScoreLayout);
        panelScoreLayout.setHorizontalGroup(
            panelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelScoreLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelScoreLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(lblScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblPlayer1)
                    .addGroup(panelScoreLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        panelScoreLayout.setVerticalGroup(
            panelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlayer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblPlayer2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTurno.setBorder(javax.swing.BorderFactory.createTitledBorder("Turno del Jugador"));

        lblPlayerTurn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPlayerTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerTurn.setText("Jugador 1");

        javax.swing.GroupLayout panelTurnoLayout = new javax.swing.GroupLayout(panelTurno);
        panelTurno.setLayout(panelTurnoLayout);
        panelTurnoLayout.setHorizontalGroup(
            panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTurnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlayerTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTurnoLayout.setVerticalGroup(
            panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurnoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblPlayerTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnSalir.setText("Salir del Juego");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnReset.setText("Volver a jugar");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnInstrucciones.setText("Instrucciones");
        btnInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruccionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(626, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInstrucciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addComponent(panelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addGap(18, 18, 18)
                .addComponent(btnInstrucciones)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Launch regression = new Launch();
        regression.setLocationRelativeTo(null);
        regression.setTitle("Menú Principal");
        regression.setVisible(true);
        test.dispose();
        this.dispose();
        sound.setShouldExit(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        turn = 2;
        if (turn == 2) {
            BOTCOLOR = 1;
        } else {
            BOTCOLOR = 2;
        }
        startGame();
        updateBoardOnMove();
        drawPossibleMove();
        gameEnded = false;
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruccionesActionPerformed
        Instrucciones pop = new Instrucciones();
        pop.setLocationRelativeTo(null);
        pop.setVisible(true);
    }//GEN-LAST:event_btnInstruccionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MiniGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniGameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInstrucciones;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JLabel lblPlayerTurn;
    private javax.swing.JLabel lblScore1;
    private javax.swing.JLabel lblScore2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelScore;
    private javax.swing.JPanel panelTurno;
    // End of variables declaration//GEN-END:variables
}
