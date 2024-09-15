/**
 * A Gacha game
 * 
 * modified     20210727
 * date         20210724
 *
 * @filename WalletImpact.java
 * @author Kevin Zhang + team
 * @version 1.0
 * @see Culminating
 */
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
public class WalletImpact extends javax.swing.JFrame {

    // currency variables
    int summons = 0;
    int credits = 1000; // Starting credits
    final int SUMMON_COST = 160;

    // luck and pity counter variables and constants
    final int FIVE_STAR_GUARANTEE = 50; // at 50 summons you are guaranteed to win a five star character
    final double BASE_CHANCE_5 = 0.05; // the starting chance of winning a five star (0.5%)
    final double LUCK_INCREASE = 0.00125; // increase in chance after each summon without a five star (0.125%)
    final double BASE_CHANCE_4 = 0.1; // the chance of winning a four star (10%)
    int numSummons = 0;
    int summonsUntil5 = FIVE_STAR_GUARANTEE;
    double currentChance = BASE_CHANCE_5; // the changing chance of winning a five star

    // storing the 5 star images with a resizable ArrayList so that it can only be unlocked once
    ArrayList<String> fiveStarsPics = new ArrayList<>(Arrays.asList("/archer.png", "/knight.png", "wizard.png"));
    // names
    ArrayList<String> fiveStarsNames = new ArrayList<>(Arrays.asList("Archer", "Knight", "Wizard"));

    // 4 star items
    String[] fourStarsPics = {"/mgs.png", "/mlb.png", "/arcanescepter.png"};
    String[] fourStarsNames = {"Mysterious Greatsword", "Mysterious Longbow", "Arcane Sceptor"};

    // 3 star items
    String[] threeStarsPics = {"/earthborneblade.png", "/earthbornebow.png", "/earthbornestaff.png", "/seaborneblade.png", "/seabornebow.png", "/seabornestaff.png", "/fireborneblade.png", "/firebornebow.png", "/firebornestaff.png"};
    String[] threeStarsNames = {"Earthborne Blade", "Earthborne Bow", "Earthborne Staff", "Seaborne Blade", "Seaborne Bow", "Seaborne Staff", "Fireborne Blade", "Fireborne Bow", "Fireborne Staff"};

    // gamble variables
    int gambleAmount = 0;
    int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    int score = 0;
    int dealer = 0;

    // Earning money with questions variables
    int num1;
    int num2;
    String symbol;

    // Inventory variables
    int p4 = 3; // index of item variable for four stars (current value out of bounds)
    int p3 = 9; // index of item variable for three stars (current value out of bounds)
    int numMGS = 0;
    int numMLB = 0;
    int numAS = 0;
    int numEBBow = 0;
    int numFBBow = 0;
    int numSBBow = 0;
    int numEBBlade = 0;
    int numFBBlade = 0;
    int numSBBlade = 0;
    int numEBStaff = 0;
    int numFBStaff = 0;
    int numSBStaff = 0;

    // for the change in item number, reset every time the inventory is opened
    int chgMGS = 0;
    int chgMLB = 0;
    int chgAS = 0;
    int chgEBBow = 0;
    int chgFBBow = 0;
    int chgSBBow = 0;
    int chgEBBlade = 0;
    int chgFBBlade = 0;
    int chgSBBlade = 0;
    int chgEBStaff = 0;
    int chgFBStaff = 0;
    int chgSBStaff = 0;

    // variables and constants related to the defeating enemies mechanism
    // player damage
    final int BASE_DMG = 100; // player damage without items
    final int THREE_STAR_DMG = 10; // Each three star weapon owned increases damage by 10
    final int FOUR_STAR_DMG = 100; // Each three star weapon owned increases damage by 100
    // used for 5 star multipliers
    int bowDMG = 0;
    int swordDMG = 0;
    int staffDMG = 0;
    int totalDMG = BASE_DMG + bowDMG + swordDMG + staffDMG;
    // archer gives 3x bow DMG, knight 3x sword DMG, wizard 3x staff DMG
    final int FIVE_STAR_MULT = 3;
    boolean bowMult = false;
    boolean swordMult = false;
    boolean staffMult = false;

    // enemy images and names
    String[] enemyNames = {"Goblin", "Barbarian", "Giant", "Dragon"};
    String[] enemyPics = {"goblin.png", "barbarian.png", "giant.png", "dragon.png"}; // TBD
    // enemy HP and reward
    final int MIN_GOBLIN_HP = 100; // all enemies have random hp in a range
    final int MAX_GOBLIN_HP = 200;
    final int MIN_GOBLIN_R = 20; // all enemies drop a random reward in a range
    final int MAX_GOBLIN_R = 40;
    final int MIN_BARB_HP = 500;
    final int MAX_BARB_HP = 1000;
    final int MIN_BARB_R = 100;
    final int MAX_BARB_R = 200;
    final int MIN_GIANT_HP = 2000;
    final int MAX_GIANT_HP = 4000;
    final int MIN_GIANT_R = 400;
    final int MAX_GIANT_R = 800;
    final int MIN_DRAGON_HP = 5000;
    final int MAX_DRAGON_HP = 10000;
    final int MIN_DRAGON_R = 1000;
    final int MAX_DRAGON_R = 2000;

    // enemy spawn rates
    final int GOBLIN_CHANCE = 40; // percent 
    final int BARB_CHANCE = 30;
    final int GIANT_CHANCE = 20;
    final int DRAGON_CHANCE = 10;

    // current enemy variables
    int eType;
    int enemyHP;
    int reward;

    /**
     * Creates new form FrmWalletImpact
     */
    public WalletImpact() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInventoryPage = new javax.swing.JButton();
        btnSummonPage = new javax.swing.JButton();
        btnEarnPage = new javax.swing.JButton();
        btnGamble = new javax.swing.JButton();
        pnlMain = new javax.swing.JPanel();
        pnlInventory = new javax.swing.JPanel();
        lblInventoryTitle = new javax.swing.JLabel();
        pnl5Stars = new javax.swing.JPanel();
        lblArcher = new javax.swing.JLabel();
        lblWizard = new javax.swing.JLabel();
        lblKnight = new javax.swing.JLabel();
        pnl4Stars = new javax.swing.JPanel();
        lblMLB = new javax.swing.JLabel();
        lblAS = new javax.swing.JLabel();
        lblMGS = new javax.swing.JLabel();
        lblNMGS = new javax.swing.JLabel();
        lblNMLB = new javax.swing.JLabel();
        lblNAS = new javax.swing.JLabel();
        lblCMLB = new javax.swing.JLabel();
        lblCMGS = new javax.swing.JLabel();
        lblCAS = new javax.swing.JLabel();
        pnl3Stars = new javax.swing.JPanel();
        lblEBStaff = new javax.swing.JLabel();
        lblSBStaff = new javax.swing.JLabel();
        lblFBStaff = new javax.swing.JLabel();
        lblNFBStaff = new javax.swing.JLabel();
        lblNEBStaff = new javax.swing.JLabel();
        lblNSBStaff = new javax.swing.JLabel();
        lblSBBlade = new javax.swing.JLabel();
        lblNSBBlade = new javax.swing.JLabel();
        lblFBBlade = new javax.swing.JLabel();
        lblNFBBlade = new javax.swing.JLabel();
        lblEBBlade = new javax.swing.JLabel();
        lblNEBBlade = new javax.swing.JLabel();
        lblSBBow = new javax.swing.JLabel();
        lblNSBBow = new javax.swing.JLabel();
        lblFBBow = new javax.swing.JLabel();
        lblNFBBow = new javax.swing.JLabel();
        lblEBBow = new javax.swing.JLabel();
        lblNEBBow = new javax.swing.JLabel();
        lblCEBBow = new javax.swing.JLabel();
        lblCFBBow = new javax.swing.JLabel();
        lblCSBBow = new javax.swing.JLabel();
        lblCEBBlade = new javax.swing.JLabel();
        lblCFBBlade = new javax.swing.JLabel();
        lblCSBBlade = new javax.swing.JLabel();
        lblCEBStaff = new javax.swing.JLabel();
        lblCFBStaff = new javax.swing.JLabel();
        lblCSBStaff = new javax.swing.JLabel();
        lblInstructions = new javax.swing.JLabel();
        pnlSummon = new javax.swing.JPanel();
        pnlSummon2 = new javax.swing.JPanel();
        btnSummon = new javax.swing.JButton();
        pnlPrize = new javax.swing.JPanel();
        lblPrize = new javax.swing.JLabel();
        lblPrizeD = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        lblDes1 = new javax.swing.JLabel();
        lblDesTitle = new javax.swing.JLabel();
        lblDes2 = new javax.swing.JLabel();
        lblDes3 = new javax.swing.JLabel();
        pnlSummons = new javax.swing.JPanel();
        lblSummons = new javax.swing.JLabel();
        pnlCredits = new javax.swing.JPanel();
        lblCredits = new javax.swing.JLabel();
        pnlBuySummons = new javax.swing.JPanel();
        txtBuySummons = new javax.swing.JTextField();
        btnBuy = new javax.swing.JButton();
        lblMaxSummons = new javax.swing.JLabel();
        lblNotEnough = new javax.swing.JLabel();
        lblPrizeR = new javax.swing.JLabel();
        lblSummonTitle1 = new javax.swing.JLabel();
        pnlEarn = new javax.swing.JPanel();
        pnlCredits2 = new javax.swing.JPanel();
        lblCredits2 = new javax.swing.JLabel();
        lblEarnTitle = new javax.swing.JLabel();
        lblCreditChange = new javax.swing.JLabel();
        pnlQuestion = new javax.swing.JPanel();
        lblQ = new javax.swing.JLabel();
        txtAns = new javax.swing.JTextField();
        btnEnter = new javax.swing.JButton();
        lblIsCorrect = new javax.swing.JLabel();
        lblEarnTitle1 = new javax.swing.JLabel();
        pnlEnemy = new javax.swing.JPanel();
        lblEnemy = new javax.swing.JLabel();
        btnClaim = new javax.swing.JButton();
        lblDMG = new javax.swing.JLabel();
        lblEnemyHP = new javax.swing.JLabel();
        lblSummonInfo = new javax.swing.JLabel();
        lblEnemyD = new javax.swing.JLabel();
        pnlGamble = new javax.swing.JPanel();
        lblGambleTitle = new javax.swing.JLabel();
        pnlCredits1 = new javax.swing.JPanel();
        lblCredits1 = new javax.swing.JLabel();
        pnlGambleAmount = new javax.swing.JPanel();
        txtGambleAmount = new javax.swing.JTextField();
        btnConfirmGamble = new javax.swing.JButton();
        lblFeedback = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblDealer = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblCurrentCard = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCard = new javax.swing.JLabel();
        btnHit = new javax.swing.JButton();
        btnStand = new javax.swing.JButton();
        lblDes4 = new javax.swing.JLabel();
        pnlGuide = new javax.swing.JPanel();
        lblGambleTitle1 = new javax.swing.JLabel();
        pnlSummonigInfo = new javax.swing.JPanel();
        lblTotalSummons = new javax.swing.JLabel();
        lblOutput1 = new javax.swing.JLabel();
        lblSummonsUntil5Star = new javax.swing.JLabel();
        lblOutput2 = new javax.swing.JLabel();
        lbl5StarChance = new javax.swing.JLabel();
        lblOutput3 = new javax.swing.JLabel();
        lbl5StarChance1 = new javax.swing.JLabel();
        lbl5StarChance2 = new javax.swing.JLabel();
        lblOutput17 = new javax.swing.JLabel();
        lblOutput18 = new javax.swing.JLabel();
        pnlPlayerDMG = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblBowM = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblSwordM = new javax.swing.JLabel();
        lblStaffM = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblOutput4 = new javax.swing.JLabel();
        lblOutput5 = new javax.swing.JLabel();
        lblOutput6 = new javax.swing.JLabel();
        lblOutput7 = new javax.swing.JLabel();
        lblOutput8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblGobHP = new javax.swing.JLabel();
        lblGobR = new javax.swing.JLabel();
        lblBarbHP = new javax.swing.JLabel();
        lblGHP = new javax.swing.JLabel();
        lblGR = new javax.swing.JLabel();
        lblDHP = new javax.swing.JLabel();
        lblBarbR = new javax.swing.JLabel();
        lbllblDR = new javax.swing.JLabel();
        lblOutput9 = new javax.swing.JLabel();
        lblOutput10 = new javax.swing.JLabel();
        lblOutput11 = new javax.swing.JLabel();
        lblOutput12 = new javax.swing.JLabel();
        lblOutput13 = new javax.swing.JLabel();
        lblOutput14 = new javax.swing.JLabel();
        lblOutput15 = new javax.swing.JLabel();
        lblOutput16 = new javax.swing.JLabel();
        btnGuide = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnInventoryPage.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btnInventoryPage.setText("Inventory");
        btnInventoryPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryPageActionPerformed(evt);
            }
        });

        btnSummonPage.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btnSummonPage.setText("Summon");
        btnSummonPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummonPageActionPerformed(evt);
            }
        });

        btnEarnPage.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btnEarnPage.setText("Earn Credits");
        btnEarnPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEarnPageActionPerformed(evt);
            }
        });

        btnGamble.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btnGamble.setText("Gamble");
        btnGamble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGambleActionPerformed(evt);
            }
        });

        pnlMain.setLayout(new java.awt.CardLayout());

        pnlInventory.setBackground(new java.awt.Color(46, 60, 84));

        lblInventoryTitle.setBackground(new java.awt.Color(46, 60, 84));
        lblInventoryTitle.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        lblInventoryTitle.setForeground(new java.awt.Color(59, 247, 176));
        lblInventoryTitle.setText("<html>Inventory - View Your items below!");
        lblInventoryTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInventoryTitleMousePressed(evt);
            }
        });

        pnl5Stars.setBackground(new java.awt.Color(46, 60, 84));
        pnl5Stars.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "5STAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(255, 185, 0))); // NOI18N
        pnl5Stars.setForeground(new java.awt.Color(255, 185, 0));

        lblArcher.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblArcher.setText("<html> archer - locked ");

        lblWizard.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblWizard.setText("<html> wizard - locked ");

        lblKnight.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblKnight.setText("<html> Knight - locked ");

        javax.swing.GroupLayout pnl5StarsLayout = new javax.swing.GroupLayout(pnl5Stars);
        pnl5Stars.setLayout(pnl5StarsLayout);
        pnl5StarsLayout.setHorizontalGroup(
            pnl5StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl5StarsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl5StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblKnight, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArcher, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWizard, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        pnl5StarsLayout.setVerticalGroup(
            pnl5StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl5StarsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblArcher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKnight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWizard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl4Stars.setBackground(new java.awt.Color(46, 60, 84));
        pnl4Stars.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "4Star", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(255, 185, 0))); // NOI18N
        pnl4Stars.setForeground(new java.awt.Color(255, 185, 0));

        lblMLB.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblMLB.setText("Mysterious long bow:  ");

        lblAS.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblAS.setText("Arcane sceptor:");

        lblMGS.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblMGS.setText("Mysterious Greatsword: ");

        lblNMGS.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNMGS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNMGS.setText("locked ");

        lblNMLB.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNMLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNMLB.setText("locked ");

        lblNAS.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNAS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNAS.setText("locked ");

        lblCMLB.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCMLB.setForeground(new java.awt.Color(46, 60, 84));
        lblCMLB.setText("+1");

        lblCMGS.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCMGS.setForeground(new java.awt.Color(46, 60, 84));
        lblCMGS.setText("+1");

        lblCAS.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCAS.setForeground(new java.awt.Color(46, 60, 84));
        lblCAS.setText("+1");

        javax.swing.GroupLayout pnl4StarsLayout = new javax.swing.GroupLayout(pnl4Stars);
        pnl4Stars.setLayout(pnl4StarsLayout);
        pnl4StarsLayout.setHorizontalGroup(
            pnl4StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl4StarsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl4StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblMGS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMLB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl4StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl4StarsLayout.createSequentialGroup()
                        .addComponent(lblNMGS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCMGS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(pnl4StarsLayout.createSequentialGroup()
                        .addGroup(pnl4StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl4StarsLayout.createSequentialGroup()
                                .addComponent(lblNMLB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCMLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnl4StarsLayout.createSequentialGroup()
                                .addComponent(lblNAS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCAS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnl4StarsLayout.setVerticalGroup(
            pnl4StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4StarsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl4StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMLB)
                    .addComponent(lblNMLB)
                    .addComponent(lblCMLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl4StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMGS)
                    .addComponent(lblNMGS)
                    .addComponent(lblCMGS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl4StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAS)
                    .addComponent(lblNAS)
                    .addComponent(lblCAS))
                .addContainerGap())
        );

        pnl3Stars.setBackground(new java.awt.Color(46, 60, 84));
        pnl3Stars.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "3Star", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(255, 185, 0))); // NOI18N
        pnl3Stars.setForeground(new java.awt.Color(255, 185, 0));

        lblEBStaff.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblEBStaff.setText("Earthborne staff:");

        lblSBStaff.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblSBStaff.setText("Seaborne staff:");

        lblFBStaff.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblFBStaff.setText("Fireborne Staff");

        lblNFBStaff.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNFBStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNFBStaff.setText("locked ");

        lblNEBStaff.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNEBStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNEBStaff.setText("locked ");

        lblNSBStaff.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNSBStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNSBStaff.setText("locked ");

        lblSBBlade.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblSBBlade.setText("Seaborne Blade:");

        lblNSBBlade.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNSBBlade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNSBBlade.setText("locked ");

        lblFBBlade.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblFBBlade.setText("FireBorne Blade:");

        lblNFBBlade.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNFBBlade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNFBBlade.setText("locked ");

        lblEBBlade.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblEBBlade.setText("Earthborne Blade:");

        lblNEBBlade.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNEBBlade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNEBBlade.setText("locked ");

        lblSBBow.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblSBBow.setText("SeaBorne Bow:");

        lblNSBBow.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNSBBow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNSBBow.setText("locked ");

        lblFBBow.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblFBBow.setText("FireBorne Bow:");

        lblNFBBow.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNFBBow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNFBBow.setText("locked ");

        lblEBBow.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblEBBow.setText("EarthBorne bow:");

        lblNEBBow.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblNEBBow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNEBBow.setText("locked ");

        lblCEBBow.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCEBBow.setForeground(new java.awt.Color(46, 60, 84));
        lblCEBBow.setText("+1");

        lblCFBBow.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCFBBow.setForeground(new java.awt.Color(46, 60, 84));
        lblCFBBow.setText("+1");

        lblCSBBow.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCSBBow.setForeground(new java.awt.Color(46, 60, 84));
        lblCSBBow.setText("+1");

        lblCEBBlade.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCEBBlade.setForeground(new java.awt.Color(46, 60, 84));
        lblCEBBlade.setText("+1");

        lblCFBBlade.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCFBBlade.setForeground(new java.awt.Color(46, 60, 84));
        lblCFBBlade.setText("+1");

        lblCSBBlade.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCSBBlade.setForeground(new java.awt.Color(46, 60, 84));
        lblCSBBlade.setText("+1");

        lblCEBStaff.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCEBStaff.setForeground(new java.awt.Color(46, 60, 84));
        lblCEBStaff.setText("+1");

        lblCFBStaff.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCFBStaff.setForeground(new java.awt.Color(46, 60, 84));
        lblCFBStaff.setText("+1");

        lblCSBStaff.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblCSBStaff.setForeground(new java.awt.Color(46, 60, 84));
        lblCSBStaff.setText("+1");

        javax.swing.GroupLayout pnl3StarsLayout = new javax.swing.GroupLayout(pnl3Stars);
        pnl3Stars.setLayout(pnl3StarsLayout);
        pnl3StarsLayout.setHorizontalGroup(
            pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3StarsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl3StarsLayout.createSequentialGroup()
                        .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFBStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEBStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSBStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl3StarsLayout.createSequentialGroup()
                                .addComponent(lblNFBStaff)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCFBStaff))
                            .addGroup(pnl3StarsLayout.createSequentialGroup()
                                .addComponent(lblNSBStaff)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCSBStaff))
                            .addGroup(pnl3StarsLayout.createSequentialGroup()
                                .addComponent(lblNEBStaff)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCEBStaff)))
                        .addGap(94, 94, 94))
                    .addGroup(pnl3StarsLayout.createSequentialGroup()
                        .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEBBow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFBBow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl3StarsLayout.createSequentialGroup()
                                .addComponent(lblNFBBow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCFBBow))
                            .addGroup(pnl3StarsLayout.createSequentialGroup()
                                .addComponent(lblNEBBow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCEBBow)))
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl3StarsLayout.createSequentialGroup()
                        .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSBBlade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFBBlade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEBBlade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSBBow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl3StarsLayout.createSequentialGroup()
                                .addComponent(lblNEBBlade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCEBBlade))
                            .addGroup(pnl3StarsLayout.createSequentialGroup()
                                .addComponent(lblNFBBlade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCFBBlade))
                            .addGroup(pnl3StarsLayout.createSequentialGroup()
                                .addComponent(lblNSBBlade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCSBBlade))
                            .addGroup(pnl3StarsLayout.createSequentialGroup()
                                .addComponent(lblNSBBow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCSBBow)))
                        .addGap(94, 94, 94))))
        );
        pnl3StarsLayout.setVerticalGroup(
            pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3StarsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEBBow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNEBBow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCEBBow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFBBow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNFBBow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCFBBow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSBBow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNSBBow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCSBBow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEBBlade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNEBBlade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCEBBlade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFBBlade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNFBBlade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCFBBlade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSBBlade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNSBBlade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCSBBlade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEBStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNEBStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCEBStaff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFBStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNFBStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCFBStaff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl3StarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSBStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNSBStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCSBStaff))
                .addContainerGap())
        );

        lblInstructions.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblInstructions.setForeground(new java.awt.Color(255, 185, 0));
        lblInstructions.setText("<html>Everything is Locked. Summon some items !");

        javax.swing.GroupLayout pnlInventoryLayout = new javax.swing.GroupLayout(pnlInventory);
        pnlInventory.setLayout(pnlInventoryLayout);
        pnlInventoryLayout.setHorizontalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInventoryTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl5Stars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInventoryLayout.createSequentialGroup()
                        .addComponent(pnl4Stars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addGroup(pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl3Stars, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(119, 253, Short.MAX_VALUE))
        );
        pnlInventoryLayout.setVerticalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblInventoryTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlInventoryLayout.createSequentialGroup()
                        .addComponent(pnl5Stars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl4Stars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnl3Stars, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pnlMain.add(pnlInventory, "card2");

        pnlSummon.setBackground(new java.awt.Color(46, 60, 84));
        pnlSummon.setForeground(new java.awt.Color(46, 60, 84));
        pnlSummon.setToolTipText("");

        pnlSummon2.setBackground(new java.awt.Color(46, 60, 84));

        btnSummon.setBackground(new java.awt.Color(0, 0, 0));
        btnSummon.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnSummon.setForeground(new java.awt.Color(59, 247, 176));
        btnSummon.setText("SUMMON");
        btnSummon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummonActionPerformed(evt);
            }
        });

        pnlPrize.setBackground(new java.awt.Color(0, 0, 0));
        pnlPrize.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblPrize.setForeground(new java.awt.Color(240, 240, 240));
        lblPrize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlPrizeLayout = new javax.swing.GroupLayout(pnlPrize);
        pnlPrize.setLayout(pnlPrizeLayout);
        pnlPrizeLayout.setHorizontalGroup(
            pnlPrizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPrize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPrizeLayout.setVerticalGroup(
            pnlPrizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPrize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblPrizeD.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPrizeD.setForeground(new java.awt.Color(59, 247, 176));
        lblPrizeD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrizeD.setText("<HTML> CLICK SUMMON AND VIEW YOUR PRIZE BELOW");

        btnConfirm.setBackground(new java.awt.Color(46, 60, 84));
        btnConfirm.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 185, 0));
        btnConfirm.setText("CONFIRM");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        lblDes1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblDes1.setText("<html> archer - locked ");

        lblDesTitle.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        lblDesTitle.setForeground(new java.awt.Color(255, 185, 0));
        lblDesTitle.setText("<html> PREMIUM 5-star PRIZES TO BE WON: ");

        lblDes2.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblDes2.setText("<html> Knight - locked ");

        lblDes3.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblDes3.setText("<html> wizard - locked ");

        pnlSummons.setBackground(new java.awt.Color(46, 60, 84));
        pnlSummons.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Summons", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(59, 247, 176))); // NOI18N
        pnlSummons.setForeground(new java.awt.Color(59, 247, 176));

        lblSummons.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblSummons.setForeground(new java.awt.Color(255, 185, 0));
        lblSummons.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSummons.setText("0");
        lblSummons.setToolTipText("");

        javax.swing.GroupLayout pnlSummonsLayout = new javax.swing.GroupLayout(pnlSummons);
        pnlSummons.setLayout(pnlSummonsLayout);
        pnlSummonsLayout.setHorizontalGroup(
            pnlSummonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSummons, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSummonsLayout.setVerticalGroup(
            pnlSummonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummonsLayout.createSequentialGroup()
                .addComponent(lblSummons)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCredits.setBackground(new java.awt.Color(46, 60, 84));
        pnlCredits.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Credits", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(59, 247, 176))); // NOI18N
        pnlCredits.setForeground(new java.awt.Color(59, 247, 176));
        pnlCredits.setToolTipText("");

        lblCredits.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblCredits.setForeground(new java.awt.Color(255, 185, 0));
        lblCredits.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCredits.setText("1000");

        javax.swing.GroupLayout pnlCreditsLayout = new javax.swing.GroupLayout(pnlCredits);
        pnlCredits.setLayout(pnlCreditsLayout);
        pnlCreditsLayout.setHorizontalGroup(
            pnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreditsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCredits, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCreditsLayout.setVerticalGroup(
            pnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreditsLayout.createSequentialGroup()
                .addComponent(lblCredits)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBuySummons.setBackground(new java.awt.Color(46, 60, 84));
        pnlBuySummons.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buy Summons", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(255, 185, 0))); // NOI18N
        pnlBuySummons.setForeground(new java.awt.Color(255, 185, 0));
        pnlBuySummons.setToolTipText("[39, 255, 14]");

        txtBuySummons.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtBuySummons.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnBuy.setBackground(new java.awt.Color(0, 0, 0));
        btnBuy.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(59, 247, 176));
        btnBuy.setText("Buy");
        btnBuy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuySummonsLayout = new javax.swing.GroupLayout(pnlBuySummons);
        pnlBuySummons.setLayout(pnlBuySummonsLayout);
        pnlBuySummonsLayout.setHorizontalGroup(
            pnlBuySummonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuySummonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuySummons, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuy)
                .addGap(22, 22, 22))
        );
        pnlBuySummonsLayout.setVerticalGroup(
            pnlBuySummonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuySummonsLayout.createSequentialGroup()
                .addGroup(pnlBuySummonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuySummons, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblMaxSummons.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblMaxSummons.setForeground(new java.awt.Color(59, 247, 176));
        lblMaxSummons.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaxSummons.setText("MAX Summons is...");
        lblMaxSummons.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblNotEnough.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblNotEnough.setForeground(new java.awt.Color(59, 247, 176));
        lblNotEnough.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNotEnough.setText("Cost per Summon: 160");
        lblNotEnough.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblPrizeR.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblPrizeR.setForeground(new java.awt.Color(255, 185, 0));
        lblPrizeR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlSummon2Layout = new javax.swing.GroupLayout(pnlSummon2);
        pnlSummon2.setLayout(pnlSummon2Layout);
        pnlSummon2Layout.setHorizontalGroup(
            pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSummon2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSummon2Layout.createSequentialGroup()
                        .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDesTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDes2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDes3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSummon, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirm)
                            .addComponent(lblPrizeR, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlSummon2Layout.createSequentialGroup()
                        .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlSummon2Layout.createSequentialGroup()
                                .addComponent(pnlCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlSummons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblMaxSummons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlBuySummons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNotEnough, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblPrizeD, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(pnlPrize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pnlSummon2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnConfirm, btnSummon});

        pnlSummon2Layout.setVerticalGroup(
            pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSummon2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPrizeD, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPrize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSummon2Layout.createSequentialGroup()
                        .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlBuySummons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlCredits, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlSummons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaxSummons)
                            .addComponent(lblNotEnough, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrizeR))
                        .addGap(18, 18, 18)
                        .addGroup(pnlSummon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSummon2Layout.createSequentialGroup()
                                .addComponent(lblDes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSummon2Layout.createSequentialGroup()
                                .addComponent(btnConfirm)
                                .addGap(18, 18, 18)
                                .addComponent(btnSummon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28))
        );

        pnlSummon2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnConfirm, btnSummon});

        lblSummonTitle1.setBackground(new java.awt.Color(46, 60, 84));
        lblSummonTitle1.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        lblSummonTitle1.setForeground(new java.awt.Color(59, 247, 176));
        lblSummonTitle1.setText("<html>Summon to Gain and unlock items  and characters!");
        lblSummonTitle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSummonTitle1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlSummonLayout = new javax.swing.GroupLayout(pnlSummon);
        pnlSummon.setLayout(pnlSummonLayout);
        pnlSummonLayout.setHorizontalGroup(
            pnlSummonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSummon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlSummonLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblSummonTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSummonLayout.setVerticalGroup(
            pnlSummonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummonLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblSummonTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlSummon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pnlMain.add(pnlSummon, "card3");

        pnlEarn.setBackground(new java.awt.Color(46, 60, 84));
        pnlEarn.setForeground(new java.awt.Color(46, 60, 84));

        pnlCredits2.setBackground(new java.awt.Color(46, 60, 84));
        pnlCredits2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Credits", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(59, 247, 176))); // NOI18N
        pnlCredits2.setForeground(new java.awt.Color(59, 247, 176));
        pnlCredits2.setToolTipText("");

        lblCredits2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblCredits2.setForeground(new java.awt.Color(255, 185, 0));
        lblCredits2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCredits2.setText("1000");

        javax.swing.GroupLayout pnlCredits2Layout = new javax.swing.GroupLayout(pnlCredits2);
        pnlCredits2.setLayout(pnlCredits2Layout);
        pnlCredits2Layout.setHorizontalGroup(
            pnlCredits2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCredits2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCredits2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCredits2Layout.setVerticalGroup(
            pnlCredits2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCredits2Layout.createSequentialGroup()
                .addComponent(lblCredits2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEarnTitle.setBackground(new java.awt.Color(46, 60, 84));
        lblEarnTitle.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        lblEarnTitle.setForeground(new java.awt.Color(59, 247, 176));
        lblEarnTitle.setText("<html>Earn Credits by defeating enemies! ");
        lblEarnTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblEarnTitleMousePressed(evt);
            }
        });

        lblCreditChange.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblCreditChange.setForeground(new java.awt.Color(255, 185, 0));
        lblCreditChange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        pnlQuestion.setBackground(new java.awt.Color(46, 60, 84));
        pnlQuestion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Question", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(59, 247, 176))); // NOI18N
        pnlQuestion.setForeground(new java.awt.Color(46, 60, 84));

        lblQ.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblQ.setForeground(new java.awt.Color(255, 185, 0));
        lblQ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQ.setText("Question");

        txtAns.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtAns.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnsActionPerformed(evt);
            }
        });

        btnEnter.setBackground(new java.awt.Color(0, 0, 0));
        btnEnter.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnEnter.setForeground(new java.awt.Color(59, 247, 176));
        btnEnter.setText("Attack");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        lblIsCorrect.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblIsCorrect.setForeground(new java.awt.Color(59, 247, 176));
        lblIsCorrect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlQuestionLayout = new javax.swing.GroupLayout(pnlQuestion);
        pnlQuestion.setLayout(pnlQuestionLayout);
        pnlQuestionLayout.setHorizontalGroup(
            pnlQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuestionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQuestionLayout.createSequentialGroup()
                        .addComponent(txtAns, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnter, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addComponent(lblIsCorrect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlQuestionLayout.setVerticalGroup(
            pnlQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuestionLayout.createSequentialGroup()
                .addComponent(lblQ, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(pnlQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAns, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(lblIsCorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblEarnTitle1.setBackground(new java.awt.Color(46, 60, 84));
        lblEarnTitle1.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        lblEarnTitle1.setForeground(new java.awt.Color(255, 185, 0));
        lblEarnTitle1.setText("<html>Attack Enemies by answering the questions correctly.");
        lblEarnTitle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblEarnTitle1MousePressed(evt);
            }
        });

        pnlEnemy.setBackground(new java.awt.Color(0, 0, 0));

        lblEnemy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlEnemyLayout = new javax.swing.GroupLayout(pnlEnemy);
        pnlEnemy.setLayout(pnlEnemyLayout);
        pnlEnemyLayout.setHorizontalGroup(
            pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnemyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlEnemyLayout.setVerticalGroup(
            pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnemyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnClaim.setBackground(new java.awt.Color(46, 60, 84));
        btnClaim.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnClaim.setForeground(new java.awt.Color(255, 185, 0));
        btnClaim.setText("Claim");
        btnClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaimActionPerformed(evt);
            }
        });

        lblDMG.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblDMG.setForeground(new java.awt.Color(255, 185, 0));
        lblDMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblEnemyHP.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblEnemyHP.setForeground(new java.awt.Color(59, 247, 176));
        lblEnemyHP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyHP.setText("Enemy HP");

        lblSummonInfo.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblSummonInfo.setForeground(new java.awt.Color(59, 247, 176));
        lblSummonInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSummonInfo.setText("Summon weapons and characters to increase your attack damage!");

        lblEnemyD.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblEnemyD.setForeground(new java.awt.Color(255, 185, 0));
        lblEnemyD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlEarnLayout = new javax.swing.GroupLayout(pnlEarn);
        pnlEarn.setLayout(pnlEarnLayout);
        pnlEarnLayout.setHorizontalGroup(
            pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEarnLayout.createSequentialGroup()
                .addGroup(pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEarnLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClaim)
                        .addGap(18, 18, 18))
                    .addGroup(pnlEarnLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEarnLayout.createSequentialGroup()
                                .addGroup(pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblCreditChange, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlCredits2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(57, 57, 57)
                                .addGroup(pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDMG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblEarnTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEarnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSummonInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)))
                .addGroup(pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEnemyHP, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(lblEnemyD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        pnlEarnLayout.setVerticalGroup(
            pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEarnLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClaim)
                    .addGroup(pnlEarnLayout.createSequentialGroup()
                        .addComponent(lblEarnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEarnTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEnemyHP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEarnLayout.createSequentialGroup()
                                .addComponent(pnlCredits2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCreditChange, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlEarnLayout.createSequentialGroup()
                                .addComponent(pnlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDMG))
                            .addComponent(pnlEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnlEarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEarnLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblSummonInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEarnLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEnemyD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );

        pnlMain.add(pnlEarn, "card4");

        pnlGamble.setBackground(new java.awt.Color(46, 60, 84));
        pnlGamble.setToolTipText("");

        lblGambleTitle.setBackground(new java.awt.Color(46, 60, 84));
        lblGambleTitle.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        lblGambleTitle.setForeground(new java.awt.Color(59, 247, 176));
        lblGambleTitle.setText("blackjack");
        lblGambleTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblGambleTitleMousePressed(evt);
            }
        });

        pnlCredits1.setBackground(new java.awt.Color(46, 60, 84));
        pnlCredits1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Credits", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(59, 247, 176))); // NOI18N
        pnlCredits1.setForeground(new java.awt.Color(59, 247, 176));
        pnlCredits1.setToolTipText("");

        lblCredits1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblCredits1.setForeground(new java.awt.Color(255, 185, 0));
        lblCredits1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCredits1.setText("1000");

        javax.swing.GroupLayout pnlCredits1Layout = new javax.swing.GroupLayout(pnlCredits1);
        pnlCredits1.setLayout(pnlCredits1Layout);
        pnlCredits1Layout.setHorizontalGroup(
            pnlCredits1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCredits1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCredits1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCredits1Layout.setVerticalGroup(
            pnlCredits1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCredits1Layout.createSequentialGroup()
                .addComponent(lblCredits1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlGambleAmount.setBackground(new java.awt.Color(46, 60, 84));
        pnlGambleAmount.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Amount to Gamble", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(255, 185, 0))); // NOI18N
        pnlGambleAmount.setForeground(new java.awt.Color(255, 185, 0));
        pnlGambleAmount.setToolTipText("[39, 255, 14]");

        txtGambleAmount.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtGambleAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGambleAmount.setText("0");

        btnConfirmGamble.setBackground(new java.awt.Color(0, 0, 0));
        btnConfirmGamble.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnConfirmGamble.setForeground(new java.awt.Color(59, 247, 176));
        btnConfirmGamble.setText("Gamble");
        btnConfirmGamble.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConfirmGamble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmGambleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGambleAmountLayout = new javax.swing.GroupLayout(pnlGambleAmount);
        pnlGambleAmount.setLayout(pnlGambleAmountLayout);
        pnlGambleAmountLayout.setHorizontalGroup(
            pnlGambleAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGambleAmountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtGambleAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmGamble, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlGambleAmountLayout.setVerticalGroup(
            pnlGambleAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGambleAmountLayout.createSequentialGroup()
                .addGroup(pnlGambleAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmGamble, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGambleAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        lblFeedback.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblFeedback.setForeground(new java.awt.Color(59, 247, 176));
        lblFeedback.setText("<html>");

        jPanel1.setBackground(new java.awt.Color(46, 60, 84));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dealer Hand", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(255, 185, 0))); // NOI18N

        lblDealer.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblDealer.setForeground(new java.awt.Color(255, 185, 0));
        lblDealer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDealer.setText("--");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDealer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDealer, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(46, 60, 84));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Your Hand", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(59, 247, 176))); // NOI18N

        lblCurrentCard.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblCurrentCard.setForeground(new java.awt.Color(255, 185, 0));
        lblCurrentCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurrentCard.setText("Current Card:");
        lblCurrentCard.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblScore.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblScore.setForeground(new java.awt.Color(59, 247, 176));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("--");

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(59, 247, 176));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total Sum:");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblCard.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblCard.setForeground(new java.awt.Color(255, 185, 0));
        lblCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCard.setText("--");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCurrentCard, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(lblScore, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(lblCard, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblCurrentCard, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCard, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScore, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnHit.setBackground(new java.awt.Color(0, 0, 0));
        btnHit.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnHit.setForeground(new java.awt.Color(59, 247, 176));
        btnHit.setText("Hit");
        btnHit.setEnabled(false);
        btnHit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitActionPerformed(evt);
            }
        });

        btnStand.setBackground(new java.awt.Color(0, 0, 0));
        btnStand.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnStand.setForeground(new java.awt.Color(255, 185, 0));
        btnStand.setText("Stand");
        btnStand.setEnabled(false);
        btnStand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStandActionPerformed(evt);
            }
        });

        lblDes4.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblDes4.setForeground(new java.awt.Color(59, 247, 176));
        lblDes4.setText("<html> Win to double the amount bet! <p> get 21 to triple the amount bet!");

        javax.swing.GroupLayout pnlGambleLayout = new javax.swing.GroupLayout(pnlGamble);
        pnlGamble.setLayout(pnlGambleLayout);
        pnlGambleLayout.setHorizontalGroup(
            pnlGambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGambleLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlGambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGambleLayout.createSequentialGroup()
                        .addGroup(pnlGambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGambleLayout.createSequentialGroup()
                                .addComponent(btnHit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnStand))
                            .addGroup(pnlGambleLayout.createSequentialGroup()
                                .addComponent(pnlCredits1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(pnlGambleAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlGambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblFeedback, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDes4, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addComponent(lblGambleTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        pnlGambleLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHit, btnStand});

        pnlGambleLayout.setVerticalGroup(
            pnlGambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGambleLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblGambleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCredits1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlGambleAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(lblFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblDes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnlGambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStand, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(258, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGambleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pnlGambleLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHit, btnStand});

        pnlMain.add(pnlGamble, "card5");

        pnlGuide.setBackground(new java.awt.Color(46, 60, 84));
        pnlGuide.setForeground(new java.awt.Color(46, 60, 84));

        lblGambleTitle1.setBackground(new java.awt.Color(46, 60, 84));
        lblGambleTitle1.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        lblGambleTitle1.setForeground(new java.awt.Color(59, 247, 176));
        lblGambleTitle1.setText("The guidebook - view your stats below:");
        lblGambleTitle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblGambleTitle1MousePressed(evt);
            }
        });

        pnlSummonigInfo.setBackground(new java.awt.Color(46, 60, 84));
        pnlSummonigInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Summoning", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(255, 185, 0))); // NOI18N
        pnlSummonigInfo.setForeground(new java.awt.Color(46, 60, 84));

        lblTotalSummons.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblTotalSummons.setForeground(new java.awt.Color(59, 247, 176));
        lblTotalSummons.setText("Total Summons:");

        lblOutput1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput1.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput1.setText("Output");

        lblSummonsUntil5Star.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblSummonsUntil5Star.setForeground(new java.awt.Color(59, 247, 176));
        lblSummonsUntil5Star.setText("Summons until 5STAR guarantee:");

        lblOutput2.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput2.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput2.setText("Output");

        lbl5StarChance.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lbl5StarChance.setForeground(new java.awt.Color(59, 247, 176));
        lbl5StarChance.setText("4Star summon chance:");

        lblOutput3.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput3.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput3.setText("Output");

        lbl5StarChance1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lbl5StarChance1.setForeground(new java.awt.Color(59, 247, 176));
        lbl5StarChance1.setText("Current 5Star summon chance:");

        lbl5StarChance2.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lbl5StarChance2.setForeground(new java.awt.Color(59, 247, 176));
        lbl5StarChance2.setText("3Star summon chance:");

        lblOutput17.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput17.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput17.setText("Output");

        lblOutput18.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput18.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput18.setText("10%");

        javax.swing.GroupLayout pnlSummonigInfoLayout = new javax.swing.GroupLayout(pnlSummonigInfo);
        pnlSummonigInfo.setLayout(pnlSummonigInfoLayout);
        pnlSummonigInfoLayout.setHorizontalGroup(
            pnlSummonigInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummonigInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSummonigInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSummonigInfoLayout.createSequentialGroup()
                        .addComponent(lblTotalSummons)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOutput1))
                    .addGroup(pnlSummonigInfoLayout.createSequentialGroup()
                        .addComponent(lblSummonsUntil5Star)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(lblOutput2))
                    .addGroup(pnlSummonigInfoLayout.createSequentialGroup()
                        .addGroup(pnlSummonigInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl5StarChance2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl5StarChance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl5StarChance1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlSummonigInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOutput3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblOutput17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblOutput18, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        pnlSummonigInfoLayout.setVerticalGroup(
            pnlSummonigInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummonigInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSummonigInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalSummons)
                    .addComponent(lblOutput1))
                .addGap(18, 18, 18)
                .addGroup(pnlSummonigInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSummonsUntil5Star)
                    .addComponent(lblOutput2))
                .addGap(18, 18, 18)
                .addGroup(pnlSummonigInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutput3)
                    .addComponent(lbl5StarChance1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSummonigInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl5StarChance)
                    .addComponent(lblOutput18))
                .addGap(18, 18, 18)
                .addGroup(pnlSummonigInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl5StarChance2)
                    .addComponent(lblOutput17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPlayerDMG.setBackground(new java.awt.Color(46, 60, 84));
        pnlPlayerDMG.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Player DMG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 2, 18), new java.awt.Color(255, 185, 0))); // NOI18N
        pnlPlayerDMG.setForeground(new java.awt.Color(46, 60, 84));

        jLabel8.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(59, 247, 176));
        jLabel8.setText("Base DMG:");

        lblBowM.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblBowM.setText("3x Bow Multiplier - Locked");

        lblSwordM.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblSwordM.setText("3x Sword Multiplier - Locked");

        lblStaffM.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblStaffM.setText("3x Staff Multiplier - Locked");

        jLabel13.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(59, 247, 176));
        jLabel13.setText("Bow DMG:");

        jLabel14.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(59, 247, 176));
        jLabel14.setText("Sword DMG:");

        jLabel15.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(59, 247, 176));
        jLabel15.setText("Staff DMG:");

        jLabel16.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(59, 247, 176));
        jLabel16.setText("Total DMG:");

        lblOutput4.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput4.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput4.setText("Output");

        lblOutput5.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput5.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput5.setText("Output");

        lblOutput6.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput6.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput6.setText("Output");

        lblOutput7.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput7.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput7.setText("Output");

        lblOutput8.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput8.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput8.setText("Output");

        javax.swing.GroupLayout pnlPlayerDMGLayout = new javax.swing.GroupLayout(pnlPlayerDMG);
        pnlPlayerDMG.setLayout(pnlPlayerDMGLayout);
        pnlPlayerDMGLayout.setHorizontalGroup(
            pnlPlayerDMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayerDMGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPlayerDMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPlayerDMGLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOutput5))
                    .addGroup(pnlPlayerDMGLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOutput6))
                    .addGroup(pnlPlayerDMGLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOutput7))
                    .addGroup(pnlPlayerDMGLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOutput8))
                    .addGroup(pnlPlayerDMGLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOutput4))
                    .addComponent(lblBowM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSwordM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStaffM, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPlayerDMGLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, jLabel14, jLabel15, jLabel16, jLabel8});

        pnlPlayerDMGLayout.setVerticalGroup(
            pnlPlayerDMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayerDMGLayout.createSequentialGroup()
                .addGroup(pnlPlayerDMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlayerDMGLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel10))
                    .addGroup(pnlPlayerDMGLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlPlayerDMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblOutput4))
                        .addGap(18, 18, 18)
                        .addComponent(lblBowM)
                        .addGap(18, 18, 18)
                        .addComponent(lblSwordM)
                        .addGap(18, 18, 18)
                        .addComponent(lblStaffM)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPlayerDMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblOutput5))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPlayerDMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(lblOutput6))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPlayerDMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lblOutput7))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPlayerDMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lblOutput8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(46, 60, 84));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enemy Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 0, 18), new java.awt.Color(255, 185, 0))); // NOI18N

        lblGobHP.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblGobHP.setForeground(new java.awt.Color(59, 247, 176));
        lblGobHP.setText("Goblin HP:");

        lblGobR.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblGobR.setForeground(new java.awt.Color(59, 247, 176));
        lblGobR.setText("Goblin Drop:");

        lblBarbHP.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblBarbHP.setForeground(new java.awt.Color(59, 247, 176));
        lblBarbHP.setText("Barb. HP:");

        lblGHP.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblGHP.setForeground(new java.awt.Color(59, 247, 176));
        lblGHP.setText("Giant HP:");

        lblGR.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblGR.setForeground(new java.awt.Color(59, 247, 176));
        lblGR.setText("Giant Drop:");

        lblDHP.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblDHP.setForeground(new java.awt.Color(59, 247, 176));
        lblDHP.setText("Dragon Hp:");

        lblBarbR.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblBarbR.setForeground(new java.awt.Color(59, 247, 176));
        lblBarbR.setText("Barb. Drop:");

        lbllblDR.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lbllblDR.setForeground(new java.awt.Color(59, 247, 176));
        lbllblDR.setText("DRAGON DROP:");

        lblOutput9.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput9.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput9.setText("20-40 credits");

        lblOutput10.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput10.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput10.setText("100-200 HP");

        lblOutput11.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput11.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput11.setText("500-1000 HP");

        lblOutput12.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput12.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput12.setText("100-200 credits");

        lblOutput13.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput13.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput13.setText("2000-4000 HP");

        lblOutput14.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput14.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput14.setText("5000-10000 Hp");

        lblOutput15.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput15.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput15.setText("1000-2000 credtis");

        lblOutput16.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblOutput16.setForeground(new java.awt.Color(255, 185, 0));
        lblOutput16.setText("400-800 credits");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblGobR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOutput9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblGobHP, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOutput10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblBarbHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOutput11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblBarbR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOutput12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblGHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOutput13))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblDHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOutput14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblGR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOutput16))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbllblDR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(lblOutput15)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGobHP)
                    .addComponent(lblOutput10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGobR)
                    .addComponent(lblOutput9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBarbHP)
                    .addComponent(lblOutput11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBarbR)
                    .addComponent(lblOutput12))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGHP)
                    .addComponent(lblOutput13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGR)
                    .addComponent(lblOutput16))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDHP)
                    .addComponent(lblOutput14))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbllblDR)
                    .addComponent(lblOutput15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGuideLayout = new javax.swing.GroupLayout(pnlGuide);
        pnlGuide.setLayout(pnlGuideLayout);
        pnlGuideLayout.setHorizontalGroup(
            pnlGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGuideLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGuideLayout.createSequentialGroup()
                        .addComponent(pnlSummonigInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlPlayerDMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(154, Short.MAX_VALUE))
                    .addGroup(pnlGuideLayout.createSequentialGroup()
                        .addComponent(lblGambleTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlGuideLayout.setVerticalGroup(
            pnlGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGuideLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblGambleTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPlayerDMG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSummonigInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pnlMain.add(pnlGuide, "card6");

        btnGuide.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btnGuide.setText("Guidebook");
        btnGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuideActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInventoryPage)
                        .addGap(18, 18, 18)
                        .addComponent(btnSummonPage)
                        .addGap(18, 18, 18)
                        .addComponent(btnEarnPage)
                        .addGap(18, 18, 18)
                        .addComponent(btnGamble)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuide)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInventoryPage)
                    .addComponent(btnSummonPage)
                    .addComponent(btnEarnPage)
                    .addComponent(btnGamble)
                    .addComponent(btnGuide))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInventoryPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryPageActionPerformed
        CardLayout card = (CardLayout) pnlMain.getLayout();
        card.show(pnlMain, "card2");

        if (chgEBBlade > 0) {
            unlockChange(lblCEBBlade);
        }
        if (chgFBBlade > 0) {
            unlockChange(lblCFBBlade);
        }
        if (chgSBBlade > 0) {
            unlockChange(lblCSBBlade);
        }
        if (chgEBBow > 0) {
            unlockChange(lblCEBBow);
        }
        if (chgFBBow > 0) {
            unlockChange(lblCFBBow);
        }
        if (chgSBBow > 0) {
            unlockChange(lblCSBBow);
        }
        if (chgEBStaff > 0) {
            unlockChange(lblCEBStaff);
        }
        if (chgFBStaff > 0) {
            unlockChange(lblCFBStaff);
        }
        if (chgSBStaff > 0) {
            unlockChange(lblCSBStaff);
        }

        if (chgMGS > 0) {
            unlockChange(lblCMGS);
        }
        if (chgMLB > 0) {
            unlockChange(lblCMLB);
        }
        if (chgAS > 0) {
            unlockChange(lblCAS);
        }

        lblCEBBlade.setText(String.valueOf("+" + chgEBBlade));
        lblCFBBlade.setText(String.valueOf("+" + chgFBBlade));
        lblCSBBlade.setText(String.valueOf("+" + chgSBBlade));
        lblCEBBow.setText(String.valueOf("+" + chgEBBow));
        lblCFBBow.setText(String.valueOf("+" + chgFBBow));
        lblCSBBow.setText(String.valueOf("+" + chgSBBow));
        lblCEBStaff.setText(String.valueOf("+" + chgEBStaff));
        lblCFBStaff.setText(String.valueOf("+" + chgFBStaff));
        lblCSBStaff.setText(String.valueOf("+" + chgSBStaff));

        lblCMGS.setText(String.valueOf("+" + chgMGS));
        lblCMLB.setText(String.valueOf("+" + chgMLB));
        lblCAS.setText(String.valueOf("+" + chgAS));

        // resetting the amount changed
        chgMGS = 0;
        chgMLB = 0;
        chgAS = 0;
        chgEBBow = 0;
        chgFBBow = 0;
        chgSBBow = 0;
        chgEBBlade = 0;
        chgFBBlade = 0;
        chgSBBlade = 0;
        chgEBStaff = 0;
        chgFBStaff = 0;
        chgSBStaff = 0;
    }//GEN-LAST:event_btnInventoryPageActionPerformed

    private void btnSummonPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummonPageActionPerformed
        CardLayout card = (CardLayout) pnlMain.getLayout();
        card.show(pnlMain, "card3");
        btnConfirm.show(false);
        lblCredits.setText(String.valueOf(credits));
        lblMaxSummons.setText("MAX summons is: " + String.valueOf(credits / SUMMON_COST));
        lblInstructions.setText(null);

        // make it hide change for all
        hideChange(lblCEBBlade);
        hideChange(lblCFBBlade);
        hideChange(lblCSBBlade);
        hideChange(lblCEBBow);
        hideChange(lblCFBBow);
        hideChange(lblCSBBow);
        hideChange(lblCEBStaff);
        hideChange(lblCFBStaff);
        hideChange(lblCSBStaff);
        hideChange(lblCMGS);
        hideChange(lblCMLB);
        hideChange(lblCAS);


    }//GEN-LAST:event_btnSummonPageActionPerformed

    private void btnEarnPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEarnPageActionPerformed
        CardLayout card = (CardLayout) pnlMain.getLayout();
        card.show(pnlMain, "card4");
        lblQ.setText(generateQuestion());
        lblCredits2.setText(String.valueOf(credits));
        lblCreditChange.setText(null);
        lblIsCorrect.setText(null);

        bowDMG();
        swordDMG();
        staffDMG();

        totalDMG = BASE_DMG + bowDMG + swordDMG + staffDMG;

        // generating a new enemy, hp, and reward
        int enemy = randomNum(100); // choosing enemy - generates number 0-99

        if (enemy < DRAGON_CHANCE) {
            eType = 3; // DRAGON
            enemyHP = randomNum(MIN_DRAGON_HP) + MAX_DRAGON_HP - MIN_DRAGON_HP;
            reward = randomNum(MIN_DRAGON_R) + MAX_DRAGON_R - MIN_DRAGON_R;
        } else if (enemy < DRAGON_CHANCE + GIANT_CHANCE) {
            eType = 2; // GIANT
            enemyHP = randomNum(MIN_GIANT_HP) + MAX_GIANT_HP - MIN_GIANT_HP;
            reward = randomNum(MIN_GIANT_R) + MAX_GIANT_R - MIN_GIANT_R;
        } else if (enemy < DRAGON_CHANCE + GIANT_CHANCE + BARB_CHANCE) {
            eType = 1; // BARBARIAN
            enemyHP = randomNum(MIN_BARB_HP) + MAX_BARB_HP - MIN_BARB_HP;
            reward = randomNum(MIN_BARB_R) + MAX_BARB_R - MIN_BARB_R;
        } else {
            eType = 0; // GOBLIN
            enemyHP = randomNum(MIN_GOBLIN_HP) + MAX_GOBLIN_HP - MIN_GOBLIN_HP;
            reward = randomNum(MIN_GOBLIN_R) + MAX_GOBLIN_R - MIN_GOBLIN_R;
        }

        // showing the enemy
        lblEnemy.setIcon(new javax.swing.ImageIcon(getClass().getResource(enemyPics[eType])));
        lblEnemyD.setText("A " + enemyNames[eType] + " has appeared!");
        lblEnemyHP.setText("Enemy HP: " + enemyHP);

        // hiding the claim button
        btnClaim.show(false);

        // increasing weapon damage

    }//GEN-LAST:event_btnEarnPageActionPerformed

    private void btnSummonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummonActionPerformed
        lblPrize.setIcon(null);
        lblPrizeD.setText("");
        double p = Math.random();
        boolean isFiveStar = false;

        // resetting indexes
        p4 = 3;
        p3 = 9;

        summons = Integer.parseInt(lblSummons.getText());
        if (summons > 0) {

            if ((p < currentChance || currentChance == (BASE_CHANCE_5 + (FIVE_STAR_GUARANTEE - 1) * LUCK_INCREASE)) && fiveStarsPics.size() > 0) { // winning by the currentChance or ensuring a win after 50
                // prize is five star
                isFiveStar = true;
                int p5 = (int) (Math.random() * fiveStarsPics.size());
                lblPrize.setIcon(new javax.swing.ImageIcon(getClass().getResource(fiveStarsPics.get(p5))));
                lblPrizeD.setText("You've unlocked the " + fiveStarsNames.get(p5) + "!");
                lblPrizeR.setText("5STAR");
                summonsUntil5 = FIVE_STAR_GUARANTEE;
                // for changing the labels under "Five Star Prizes to be won!"
                if (fiveStarsNames.get(p5).equals("Archer")) {
                    unlock(lblDes1, fiveStarsNames.get(p5));
                    unlock(lblArcher, fiveStarsNames.get(p5));
                    bowMult = true;
                } else if (fiveStarsNames.get(p5).equals("Knight")) {
                    unlock(lblDes2, fiveStarsNames.get(p5));
                    unlock(lblKnight, fiveStarsNames.get(p5));
                    swordMult = true;
                } else if (fiveStarsNames.get(p5).equals("Wizard")) {
                    unlock(lblDes3, fiveStarsNames.get(p5));
                    unlock(lblWizard, fiveStarsNames.get(p5));
                    staffMult = true;
                }

                fiveStarsPics.remove(p5);
                fiveStarsNames.remove(p5);

            } else if (p >= 1 - BASE_CHANCE_4) {
                // prize is four star
                p4 = (int) (Math.random() * fourStarsPics.length);

                lblPrize.setIcon(new javax.swing.ImageIcon(getClass().getResource(fourStarsPics[p4])));
                lblPrizeD.setText("You gained a " + fourStarsNames[p4] + "!");
                lblPrizeR.setText("4STAR");
                summonsUntil5--;
            } else {
                // prize is three star
                p3 = (int) (Math.random() * threeStarsPics.length);

                lblPrize.setIcon(new javax.swing.ImageIcon(getClass().getResource(threeStarsPics[p3])));
                lblPrizeD.setText("You gained a " + threeStarsNames[p3] + "!");
                lblPrizeR.setText("3STAR");
                summonsUntil5--;
            }
            if (isFiveStar) {
                currentChance = BASE_CHANCE_5; // resetting chance if five star is won
            } else {
                currentChance += LUCK_INCREASE; // increasing chance if not
            }
            summons--;
            lblSummons.setText(String.valueOf(summons));
            numSummons++;
            btnConfirm.show(true);
            btnSummon.setEnabled(false);

            // making sure user doesn't do anything until confirm is clicked
            btnGamble.setEnabled(false);
            btnEarnPage.setEnabled(false);
            btnInventoryPage.setEnabled(false);
            btnSummonPage.setEnabled(false);

        } else {
            btnSummon.setEnabled(false);
            lblPrizeD.setText("<html>Buy summons with credits first!<P> You can earn credits by performing tasks or gambling.");
        }
        // add more stuff to tell use to buy more summons


    }//GEN-LAST:event_btnSummonActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        // TODO add your handling code here:        
        btnClaim.show(false);
        credits = Integer.parseInt(lblCredits.getText());
        summons = Integer.parseInt(lblSummons.getText());
        int n = Integer.parseInt(txtBuySummons.getText());
        if (credits >= 160 * n) {
            credits -= 160 * n;
            summons += n;
            btnSummon.setEnabled(true);
            lblNotEnough.setText("Cost per Summon: 160");
        } else {
            lblNotEnough.setText("Not enough credits!");
        }

        lblCredits.setText(String.valueOf(credits));
        lblSummons.setText(String.valueOf(summons));
        txtBuySummons.setText("");
        lblMaxSummons.setText("MAX summons is: " + String.valueOf(credits / SUMMON_COST));
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        // re-enabling buttons
        btnSummon.setEnabled(true);
        btnGamble.setEnabled(true);
        btnEarnPage.setEnabled(true);
        btnInventoryPage.setEnabled(true);
        btnSummonPage.setEnabled(true);
        // todoadd to inventory
        switch (p3) {
            case 0:
                if (numEBBlade == 0) {
                    unlockEarth(lblEBBlade);
                    unlockEarth(lblNEBBlade);
                }
                numEBBlade++;
                chgEBBlade++;
                lblNEBBlade.setText(String.valueOf(numEBBlade));
                break;
            case 1:
                if (numEBBow == 0) {
                    unlockEarth(lblEBBow);
                    unlockEarth(lblNEBBow);
                }
                numEBBow++;
                chgEBBow++;
                lblNEBBow.setText(String.valueOf(numEBBow));
                break;
            case 2:
                if (numEBStaff == 0) {
                    unlockEarth(lblEBStaff);
                    unlockEarth(lblNEBStaff);
                }
                numEBStaff++;
                chgEBStaff++;
                lblNEBStaff.setText(String.valueOf(numEBStaff));
                break;
            case 6:
                if (numFBBlade == 0) {
                    unlockFire(lblFBBlade);
                    unlockFire(lblNFBBlade);
                }
                numFBBlade++;
                chgFBBlade++;
                lblNFBBlade.setText(String.valueOf(numFBBlade));
                break;
            case 7:
                if (numFBBow == 0) {
                    unlockFire(lblFBBow);
                    unlockFire(lblNFBBow);
                }
                numFBBow++;
                chgFBBow++;
                lblNFBBow.setText(String.valueOf(numFBBow));
                break;
            case 8:
                if (numFBStaff == 0) {
                    unlockFire(lblFBStaff);
                    unlockFire(lblNFBStaff);
                }
                numFBStaff++;
                chgFBStaff++;
                lblNFBStaff.setText(String.valueOf(numFBStaff));
                break;
            case 3:
                if (numSBBlade == 0) {
                    unlockSea(lblSBBlade);
                    unlockSea(lblNSBBlade);
                }
                numSBBlade++;
                chgSBBlade++;
                lblNSBBlade.setText(String.valueOf(numSBBlade));
            case 4:
                if (numSBBow == 0) {
                    unlockSea(lblSBBow);
                    unlockSea(lblNSBBow);
                }
                numSBBow++;
                chgSBBow++;
                lblNSBBow.setText(String.valueOf(numSBBow));
                break;
            case 5:
                if (numSBStaff == 0) {
                    unlockSea(lblSBStaff);
                    unlockSea(lblNSBStaff);
                }
                numSBStaff++;
                chgSBStaff++;
                lblNSBStaff.setText(String.valueOf(numSBStaff));
                break;
            default:
                break;
        }
        switch (p4) {
            case 0:
                if (numMGS == 0) {
                    unlock4Star(lblMGS);
                    unlock4Star(lblNMGS);
                }
                numMGS++;
                chgMGS++;
                lblNMGS.setText(String.valueOf(numMGS));
                break;
            case 1:
                if (numMLB == 0) {
                    unlock4Star(lblMLB);
                    unlock4Star(lblNMLB);
                }
                numMLB++;
                chgMLB++;
                lblNMLB.setText(String.valueOf(numMLB));
                break;
            case 2:
                if (numAS == 0) {
                    unlock4Star(lblAS);
                    unlock4Star(lblNAS);
                }
                numAS++;
                chgAS++;
                lblNAS.setText(String.valueOf(numAS));
                break;
        }

        // resetting labels and hiding the confirm button
        btnConfirm.show(false);
        lblPrize.setIcon(null);
        lblPrize.setText(null);
        lblPrizeD.setText(null);
        lblPrizeR.setText(null);

    }//GEN-LAST:event_btnConfirmActionPerformed

    private void lblSummonTitle1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSummonTitle1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSummonTitle1MousePressed

    private void btnGambleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGambleActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout) pnlMain.getLayout();
        card.show(pnlMain, "card5");
        lblCredits1.setText(String.valueOf(credits));
    }//GEN-LAST:event_btnGambleActionPerformed

    private void lblGambleTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGambleTitleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGambleTitleMousePressed

    private void btnConfirmGambleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmGambleActionPerformed
        // TODO add your handling code here:
        gambleAmount = Integer.parseInt(txtGambleAmount.getText());

        if (credits < 0 || gambleAmount > credits) {
            lblFeedback.setText("Not enough credits. Enter a valid amount!");
        } else if (credits >= 0 && gambleAmount > 0 && credits > gambleAmount) {
            lblFeedback.setText(null);
            credits -= gambleAmount;
            btnHit.setEnabled(true);
            btnStand.setEnabled(true);
            lblCredits1.setText(String.valueOf(credits));
            btnConfirmGamble.setEnabled(false);

            // diabling other pages while in blackjack game
            btnSummonPage.setEnabled(false);
            btnEarnPage.setEnabled(false);
            btnInventoryPage.setEnabled(false);
            btnGamble.setEnabled(false);

            lblDealer.setText("--");
            lblCard.setText("--");
            lblScore.setText("--");
        }


    }//GEN-LAST:event_btnConfirmGambleActionPerformed


    private void btnHitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitActionPerformed
        // TODO add your handling code here:
        int card = cards[randomNum(13)];

        switch (card) {
            case 1:
                lblCard.setText("Ace");
                score = score + card;
                lblScore.setText(String.valueOf(score));
                break;
            case 10:
                int face = randomNum(4);
                switch (face) {
                    case 0:
                        lblCard.setText("10");
                        break;
                    case 1:
                        lblCard.setText("Jack");
                        break;
                    case 2:
                        lblCard.setText("Queen");
                        break;
                    case 3:
                        lblCard.setText("King");
                        break;
                    default:
                        break;
                }
                score = score + 10;
                lblScore.setText(String.valueOf(score));
                break;
            default:
                lblCard.setText(String.valueOf(card));
                score += card;
                lblScore.setText(String.valueOf(score));
                break;
        }
        //automatic bust
        if (score > 21) {
            lblScore.setText("Bust!");
            btnHit.setEnabled(false);
            btnStand.setEnabled(false);
            dealer = 0;
            score = 0;
            btnConfirmGamble.setEnabled(true);
            btnSummonPage.setEnabled(true);
            btnEarnPage.setEnabled(true);
            btnInventoryPage.setEnabled(true);
            btnGamble.setEnabled(true);
        }

    }//GEN-LAST:event_btnHitActionPerformed

    private void btnStandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStandActionPerformed
        // calculate dealer store
        while (dealer < 16) { // dealer's score has to minimum 16
            int card = cards[randomNum(13)];
            dealer += cards[card];
        }
        lblDealer.setText(String.valueOf(dealer));
        btnGamble.setEnabled(false);

        if (score < 21 && score > dealer) {
            lblScore.setText("You win!");
            credits += gambleAmount * 2;
        } else if (score == 21 && score != dealer) {
            lblScore.setText("Blackjack!");
            credits += gambleAmount * 3;
        } else if (score < 21 && dealer > 21) {
            lblScore.setText("You win!");
            credits += gambleAmount * 2;
        } else if (score == dealer) {
            lblScore.setText("Push!");
            credits += gambleAmount;
        } else if (score > 21) {
            lblScore.setText("Bust!");
        } else if (dealer == 21) {
            lblScore.setText("Bust!");
        } else if (score < dealer && dealer <= 21) {
            lblScore.setText("Bust!");
        }

        dealer = 0;
        score = 0;

        lblCredits1.setText(String.valueOf(credits));
        txtGambleAmount.setText("0");
        btnConfirmGamble.setEnabled(true);

        btnHit.setEnabled(false);
        btnStand.setEnabled(false);

        // enabling the other pages because game is complete
        btnSummonPage.setEnabled(true);
        btnEarnPage.setEnabled(true);
        btnInventoryPage.setEnabled(true);
        btnGamble.setEnabled(true);
    }//GEN-LAST:event_btnStandActionPerformed

    private void lblEarnTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEarnTitleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEarnTitleMousePressed

    private void txtAnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnsActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        lblCreditChange.setText(null);
        btnInventoryPage.setEnabled(false);
        btnSummonPage.setEnabled(false);
        btnEarnPage.setEnabled(false);
        btnGamble.setEnabled(false);
        btnGuide.setEnabled(false);

        lblIsCorrect.setText("");
        int input = Integer.parseInt(txtAns.getText());
        int ans;
        boolean correct = false;
        switch (symbol) {
            case "+":
                ans = num1 + num2;
                if (input == ans) {
                    correct = true;
                }
                break;
            case "-":
                ans = num1 - num2;
                if (input == ans) {
                    correct = true;
                }
                break;
            case "*":
                ans = num1 * num2;
                if (input == ans) {
                    correct = true;
                }
                break;
            case "/":
                double temp;
                temp = num1 / num2;
                //ans = Math.round(temp * 10) / 10;
                //if (input == ans) {
                //   correct = true;
                //}
                break;
            default:
                break;
        }
        if (correct) {
            enemyHP -= totalDMG;
            lblDMG.setText("You attacked for " + totalDMG + " damage!");

            if (enemyHP <= 0) {
                lblEnemyD.setText("Enemy Defeated");
                btnClaim.show(true);
                btnEnter.setEnabled(false);
                lblEnemyHP.setText("Enemy HP remaining: " + 0);
            } else {
                lblEnemyHP.setText("Enemy HP remaining: " + enemyHP);
            }
        } else {
            lblIsCorrect.setText("Incorrect!");
            lblDMG.setText("You missed your attack!");
        }

        // next question
        txtAns.setText("");
        lblQ.setText(generateQuestion());

    }//GEN-LAST:event_btnEnterActionPerformed

    private void lblInventoryTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInventoryTitleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblInventoryTitleMousePressed

    private void btnGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuideActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout) pnlMain.getLayout();
        card.show(pnlMain, "card6");

        lblOutput1.setText(String.valueOf(numSummons));
        lblOutput2.setText(String.valueOf(summonsUntil5));
        lblOutput3.setText(String.valueOf(100 * Math.round(currentChance * 100000.0) / 100000.0) + "%");

        if (bowMult) {
            unlock(lblBowM, "3x Bow Multiplier");
        }
        if (swordMult) {
            unlock(lblSwordM, "3x Sword Multiplier");
        }
        if (staffMult) {
            unlock(lblStaffM, "3x Staff Multiplier");
        }

        lblOutput4.setText(String.valueOf(BASE_DMG));
        bowDMG();
        swordDMG();
        staffDMG();
        lblOutput5.setText(String.valueOf(bowDMG));
        lblOutput6.setText(String.valueOf(swordDMG));
        lblOutput7.setText(String.valueOf(staffDMG));
        lblOutput8.setText(String.valueOf(bowDMG + swordDMG + staffDMG + BASE_DMG));
        
        lblOutput17.setText(String.valueOf(100*(0.9 - (Math.round(currentChance * 100000.0) / 100000.0)) + "%"));
    }//GEN-LAST:event_btnGuideActionPerformed

    private void lblEarnTitle1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEarnTitle1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEarnTitle1MousePressed

    private void btnClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaimActionPerformed
        // claiming reward from previous enemy
        credits += reward;
        lblCreditChange.setText("+" + reward + " Credits");
        lblCredits2.setText(String.valueOf(credits));

        // generating a new enemy, hp, and reward
        int enemy = randomNum(100); // choosing enemy - generates number 0-99

        if (enemy < DRAGON_CHANCE) {
            eType = 3; // DRAGON
            enemyHP = randomNum(MIN_DRAGON_HP) + MAX_DRAGON_HP - MIN_DRAGON_HP;
            reward = randomNum(MAX_DRAGON_R - MIN_DRAGON_R) + MIN_DRAGON_R;
        } else if (enemy < DRAGON_CHANCE + GIANT_CHANCE) {
            eType = 2; // GIANT
            enemyHP = randomNum(MIN_GIANT_HP) + MAX_GIANT_HP - MIN_GIANT_HP;
            reward = randomNum(MAX_GIANT_R - MIN_GIANT_R) + MIN_GIANT_R;
        } else if (enemy < DRAGON_CHANCE + GIANT_CHANCE + BARB_CHANCE) {
            eType = 1; // BARBARIAN
            enemyHP = randomNum(MIN_BARB_HP) + MAX_BARB_HP - MIN_BARB_HP;
            reward = randomNum(MAX_BARB_R - MIN_BARB_R) + MIN_BARB_R;
        } else {
            eType = 0; // GOBLIN
            enemyHP = randomNum(MIN_GOBLIN_HP) + MAX_GOBLIN_HP - MIN_GOBLIN_HP;
            reward = randomNum(MAX_GOBLIN_R - MIN_GOBLIN_R) + MIN_GOBLIN_R;
        }

        // showing the enemy
        lblEnemy.setIcon(new javax.swing.ImageIcon(getClass().getResource(enemyPics[eType])));
        lblEnemyD.setText("A " + enemyNames[eType] + " has appeared!");
        lblEnemyHP.setText("Enemy HP: " + enemyHP);

        btnClaim.show(false);
        lblDMG.setText(null);
        btnInventoryPage.setEnabled(true);
        btnSummonPage.setEnabled(true);
        btnEarnPage.setEnabled(true);
        btnGamble.setEnabled(true);
        btnGuide.setEnabled(true);
        btnEnter.setEnabled(true);

    }//GEN-LAST:event_btnClaimActionPerformed

    private void lblGambleTitle1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGambleTitle1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGambleTitle1MousePressed

    public String generateQuestion() {

        symbol = generateOperation();
        if (symbol.equals("/")) {
            // only using divisible numbers
            num1 = randomNum(99) + 1;
            ArrayList<Integer> factors = factors(num1);
            num2 = factors.get(randomNum(factors.size()));
        } else if (symbol.equals("*")) {
            // making multiplication use easier numbers
            num1 = randomNum(20) + 1;
            num2 = randomNum(20) + 1;
        } else {
            // addition and subtraction
            num1 = randomNum(99) + 1;
            num2 = randomNum(99) + 1;
        }

        return num1 + " " + symbol + " " + num2;
    }

    public static ArrayList<Integer> factors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static String generateOperation() {
        String symbol;

        int num = randomNum(3);
        String[] operation = {"+", "-", "*", "/"};
        symbol = operation[num];
        return symbol;
    }

    public static int randomNum(int n) {
        // randomly generates a number between 0 and "n - 1" (inclusive). 
        return (int) (Math.random() * n);
    }

    public static void unlock(javax.swing.JLabel label, String item) {
        label.setText(item + " - Unlocked");
        label.setForeground(new java.awt.Color(59, 247, 176));
    }

    public static void unlockChange(javax.swing.JLabel label) {
        label.setForeground(new java.awt.Color(59, 247, 176));
    }

    public static void hideChange(javax.swing.JLabel label) {
        label.setForeground(new java.awt.Color(46, 60, 84));
    }

    // changes label colors
    public static void unlockEarth(javax.swing.JLabel label) {
        label.setForeground(new java.awt.Color(97, 122, 91));
    }

    public static void unlockFire(javax.swing.JLabel label) {
        label.setForeground(new java.awt.Color(240, 39, 72));
    }

    public static void unlockSea(javax.swing.JLabel label) {
        label.setForeground(new java.awt.Color(107, 178, 228));
    }

    public static void unlock4Star(javax.swing.JLabel label) {
        label.setForeground(new java.awt.Color(157, 39, 176));
    }

    public void bowDMG() {
        bowDMG = (numEBBow + numFBBow + numSBBow) * THREE_STAR_DMG + numMLB * FOUR_STAR_DMG;
        if (bowMult) {
            bowDMG *= 3;
        }
    }

    public void swordDMG() {
        swordDMG = (numEBBlade + numFBBlade + numSBBlade) * THREE_STAR_DMG + numMGS * FOUR_STAR_DMG;
        if (swordMult) {
            swordDMG *= 3;
        }
    }

    public void staffDMG() {
        staffDMG = (numEBStaff + numFBStaff + numSBStaff) * THREE_STAR_DMG + numAS * FOUR_STAR_DMG;
        if (staffMult) {
            staffDMG *= 3;
        }
    }

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
            java.util.logging.Logger.getLogger(WalletImpact.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WalletImpact.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WalletImpact.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WalletImpact.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WalletImpact().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnClaim;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnConfirmGamble;
    private javax.swing.JButton btnEarnPage;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnGamble;
    private javax.swing.JButton btnGuide;
    private javax.swing.JButton btnHit;
    private javax.swing.JButton btnInventoryPage;
    private javax.swing.JButton btnStand;
    private javax.swing.JButton btnSummon;
    private javax.swing.JButton btnSummonPage;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl5StarChance;
    private javax.swing.JLabel lbl5StarChance1;
    private javax.swing.JLabel lbl5StarChance2;
    private javax.swing.JLabel lblAS;
    private javax.swing.JLabel lblArcher;
    private javax.swing.JLabel lblBarbHP;
    private javax.swing.JLabel lblBarbR;
    private javax.swing.JLabel lblBowM;
    private javax.swing.JLabel lblCAS;
    private javax.swing.JLabel lblCEBBlade;
    private javax.swing.JLabel lblCEBBow;
    private javax.swing.JLabel lblCEBStaff;
    private javax.swing.JLabel lblCFBBlade;
    private javax.swing.JLabel lblCFBBow;
    private javax.swing.JLabel lblCFBStaff;
    private javax.swing.JLabel lblCMGS;
    private javax.swing.JLabel lblCMLB;
    private javax.swing.JLabel lblCSBBlade;
    private javax.swing.JLabel lblCSBBow;
    private javax.swing.JLabel lblCSBStaff;
    private javax.swing.JLabel lblCard;
    private javax.swing.JLabel lblCreditChange;
    private javax.swing.JLabel lblCredits;
    private javax.swing.JLabel lblCredits1;
    private javax.swing.JLabel lblCredits2;
    private javax.swing.JLabel lblCurrentCard;
    private javax.swing.JLabel lblDHP;
    private javax.swing.JLabel lblDMG;
    private javax.swing.JLabel lblDealer;
    private javax.swing.JLabel lblDes1;
    private javax.swing.JLabel lblDes2;
    private javax.swing.JLabel lblDes3;
    private javax.swing.JLabel lblDes4;
    private javax.swing.JLabel lblDesTitle;
    private javax.swing.JLabel lblEBBlade;
    private javax.swing.JLabel lblEBBow;
    private javax.swing.JLabel lblEBStaff;
    private javax.swing.JLabel lblEarnTitle;
    private javax.swing.JLabel lblEarnTitle1;
    private javax.swing.JLabel lblEnemy;
    private javax.swing.JLabel lblEnemyD;
    private javax.swing.JLabel lblEnemyHP;
    private javax.swing.JLabel lblFBBlade;
    private javax.swing.JLabel lblFBBow;
    private javax.swing.JLabel lblFBStaff;
    private javax.swing.JLabel lblFeedback;
    private javax.swing.JLabel lblGHP;
    private javax.swing.JLabel lblGR;
    private javax.swing.JLabel lblGambleTitle;
    private javax.swing.JLabel lblGambleTitle1;
    private javax.swing.JLabel lblGobHP;
    private javax.swing.JLabel lblGobR;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JLabel lblInventoryTitle;
    private javax.swing.JLabel lblIsCorrect;
    private javax.swing.JLabel lblKnight;
    private javax.swing.JLabel lblMGS;
    private javax.swing.JLabel lblMLB;
    private javax.swing.JLabel lblMaxSummons;
    private javax.swing.JLabel lblNAS;
    private javax.swing.JLabel lblNEBBlade;
    private javax.swing.JLabel lblNEBBow;
    private javax.swing.JLabel lblNEBStaff;
    private javax.swing.JLabel lblNFBBlade;
    private javax.swing.JLabel lblNFBBow;
    private javax.swing.JLabel lblNFBStaff;
    private javax.swing.JLabel lblNMGS;
    private javax.swing.JLabel lblNMLB;
    private javax.swing.JLabel lblNSBBlade;
    private javax.swing.JLabel lblNSBBow;
    private javax.swing.JLabel lblNSBStaff;
    private javax.swing.JLabel lblNotEnough;
    private javax.swing.JLabel lblOutput1;
    private javax.swing.JLabel lblOutput10;
    private javax.swing.JLabel lblOutput11;
    private javax.swing.JLabel lblOutput12;
    private javax.swing.JLabel lblOutput13;
    private javax.swing.JLabel lblOutput14;
    private javax.swing.JLabel lblOutput15;
    private javax.swing.JLabel lblOutput16;
    private javax.swing.JLabel lblOutput17;
    private javax.swing.JLabel lblOutput18;
    private javax.swing.JLabel lblOutput2;
    private javax.swing.JLabel lblOutput3;
    private javax.swing.JLabel lblOutput4;
    private javax.swing.JLabel lblOutput5;
    private javax.swing.JLabel lblOutput6;
    private javax.swing.JLabel lblOutput7;
    private javax.swing.JLabel lblOutput8;
    private javax.swing.JLabel lblOutput9;
    private javax.swing.JLabel lblPrize;
    private javax.swing.JLabel lblPrizeD;
    private javax.swing.JLabel lblPrizeR;
    private javax.swing.JLabel lblQ;
    private javax.swing.JLabel lblSBBlade;
    private javax.swing.JLabel lblSBBow;
    private javax.swing.JLabel lblSBStaff;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblStaffM;
    private javax.swing.JLabel lblSummonInfo;
    private javax.swing.JLabel lblSummonTitle1;
    private javax.swing.JLabel lblSummons;
    private javax.swing.JLabel lblSummonsUntil5Star;
    private javax.swing.JLabel lblSwordM;
    private javax.swing.JLabel lblTotalSummons;
    private javax.swing.JLabel lblWizard;
    private javax.swing.JLabel lbllblDR;
    private javax.swing.JPanel pnl3Stars;
    private javax.swing.JPanel pnl4Stars;
    private javax.swing.JPanel pnl5Stars;
    private javax.swing.JPanel pnlBuySummons;
    private javax.swing.JPanel pnlCredits;
    private javax.swing.JPanel pnlCredits1;
    private javax.swing.JPanel pnlCredits2;
    private javax.swing.JPanel pnlEarn;
    private javax.swing.JPanel pnlEnemy;
    private javax.swing.JPanel pnlGamble;
    private javax.swing.JPanel pnlGambleAmount;
    private javax.swing.JPanel pnlGuide;
    private javax.swing.JPanel pnlInventory;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPlayerDMG;
    private javax.swing.JPanel pnlPrize;
    private javax.swing.JPanel pnlQuestion;
    private javax.swing.JPanel pnlSummon;
    private javax.swing.JPanel pnlSummon2;
    private javax.swing.JPanel pnlSummonigInfo;
    private javax.swing.JPanel pnlSummons;
    private javax.swing.JTextField txtAns;
    private javax.swing.JTextField txtBuySummons;
    private javax.swing.JTextField txtGambleAmount;
    // End of variables declaration//GEN-END:variables
}
