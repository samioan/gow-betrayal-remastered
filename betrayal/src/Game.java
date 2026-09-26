import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

// $VF: renamed from: e
public final class Game extends Engine {
   private static boolean iL = false;
   // $VF: renamed from: iM d
   private final SoundPlayer soundPlayer;
   // $VF: renamed from: o c[]
   public Sprite[] menuFont;
   // $VF: renamed from: p c[]
   public Sprite[] titleFont;
   // $VF: renamed from: q c[]
   public Sprite[] mainFont;
   // $VF: renamed from: r c[]
   public Sprite[] menuSprites;
   // $VF: renamed from: s int
   public int pressedKey;
   // $VF: renamed from: t int
   public int heldKey;
   // $VF: renamed from: u int
   public int levelLoadStep = 0;
   // $VF: renamed from: v boolean
   public boolean levelLoadStarted = false;
   // $VF: renamed from: w int
   public static int languageIndex = 0;
   // $VF: renamed from: x int[]
   public static final int[] languageStringBanks = new int[]{10240, 12288, 33792, 29696, 30720, 32768};
   // $VF: renamed from: y int[]
   public static final int[] languageNameStrings = new int[]{23, 24, 21, 20, 22, 19};
   // $VF: renamed from: z int
   public static int lineHeight;
   // $VF: renamed from: A int
   public static int halfLineHeight;
   // $VF: renamed from: B boolean
   public boolean cheatsEnabled;
   public boolean C = false;
   public boolean D = false;
   // $VF: renamed from: E int
   public int screenWidth = 240;
   // $VF: renamed from: F int
   public int screenHeight = 320;
   // $VF: renamed from: G int
   public static int halfWidth;
   // $VF: renamed from: H int
   public static int halfHeight;
   // $VF: renamed from: I int
   public static int state;
   public int J;
   // $VF: renamed from: K int
   public int bootStep = 0;
   // $VF: renamed from: L int
   public int frameDelta;
   public int M;
   // $VF: renamed from: N int
   public int randomValue;
   // $VF: renamed from: O java.util.Random
   public static Random random;
   // $VF: renamed from: iN boolean
   private static boolean challengeMode = false;
   // $VF: renamed from: iO b
   private Scene scene;
   // $VF: renamed from: iP javax.microedition.lcdui.Image
   private Image tileSheet;
   // $VF: renamed from: iQ int
   private static int cameraX;
   // $VF: renamed from: iR int
   private static int cameraY;
   public int[] P = new int[4];
   private Sprite[] iS;
   public int Q = 0;
   private static boolean iT = false;
   private static boolean iU = false;
   public static int[] R;
   public static byte[] S;
   // $VF: renamed from: T int
   public int topBar;
   // $VF: renamed from: U int
   public int bottomBar;
   public int V;
   public boolean W;
   public boolean X;
   public boolean Y;
   public boolean Z;
   // $VF: renamed from: aa int
   public int topBarTarget;
   // $VF: renamed from: ab int
   public int bottomBarTarget;
   // $VF: renamed from: ac int
   public int topBarSpeed;
   // $VF: renamed from: ad int
   public int bottomBarSpeed;
   public boolean ae;
   public int af;
   public int ag;
   public boolean ah;
   public boolean ai;
   public boolean aj;
   public boolean ak;
   public boolean al;
   public boolean am;
   // $VF: renamed from: an boolean
   public boolean pendingQuit;
   // $VF: renamed from: ao boolean
   public boolean pendingMainMenu;
   public boolean ap;
   // $VF: renamed from: aq boolean
   public boolean pendingHelp;
   // $VF: renamed from: ar byte
   public static byte pauseMenuIndex = 4;
   // $VF: renamed from: as boolean
   public boolean pauseConfirming;
   public int at;
   public boolean au;
   // $VF: renamed from: av int
   public int cameraShake = 0;
   // $VF: renamed from: aw int
   public int shakeTimer = 0;
   // $VF: renamed from: ax int
   public int shakeDuration = 200;
   // $VF: renamed from: ay int
   public int cameraPanX = -1;
   // $VF: renamed from: az int
   public int cameraPanY = -1;
   // $VF: renamed from: aA int
   public int cameraPanTimer;
   // $VF: renamed from: aB int
   public int maxCameraX;
   // $VF: renamed from: aC int
   public int maxCameraY;
   // $VF: renamed from: aD int
   public int lockRectCount = -1;
   // $VF: renamed from: aE int[]
   public int[] lockX;
   // $VF: renamed from: aF int[]
   public int[] lockY;
   // $VF: renamed from: aG boolean[]
   public boolean[] lockReverse;
   // $VF: renamed from: aH boolean[]
   public boolean[] lockVertical;
   public int aI = 0;
   public int aJ = 0;
   public int aK = 45;
   public static Sprite[] aL;
   public int aM;
   public int aN;
   public int aO;
   public int aP;
   public int[] aQ = new int[2];
   public boolean aR = false;
   public boolean aS;
   public int aT = -1;
   public Sprite[] aU;
   public static final byte[] aV = new byte[]{11, 2, 2, 2, 2};
   public boolean aW = false;
   public int aX;
   public int[] aY = new int[40];
   public int[] aZ = new int[40];
   public int ba;
   public int bb;
   public boolean bc;
   public int bd;
   public boolean be = false;
   public boolean bf = false;
   public int bg = 0;
   public static byte bh = 3;
   public boolean bi;
   // $VF: renamed from: bj byte
   public static byte upgradeSelection = 0;
   public int bk = 0;
   public int bl = 0;
   public static String bm;
   public int bn;
   public static Sprite[] bo;
   // $VF: renamed from: bp int
   public int flashTimer = 0;
   // $VF: renamed from: bq int
   public int flashColor;
   // $VF: renamed from: iV byte[]
   private byte[] cellTileTypes;
   // $VF: renamed from: iW short[]
   private short[] cellFlags;
   // $VF: renamed from: iX int
   private static int mapWidth;
   // $VF: renamed from: iY int
   private static int mapHeight;
   // $VF: renamed from: iZ int
   private static int mapCellCount;
   // $VF: renamed from: ja int
   private static int worldWidthPx;
   // $VF: renamed from: jb int
   private static int worldHeightPx;
   public int br;
   public int[] bs;
   public int[] bt;
   public int bu;
   public int bv;
   public int bw;
   public int bx;
   public int by;
   public int bz;
   // $VF: renamed from: bA int
   public int levelResourceId = -1;
   // $VF: renamed from: bB int[]
   public static final int[] levelIds = new int[]{9217, 19456, 20480, 21504, 22528, 23552, 24576, 25600, 26624, 27648};
   // $VF: renamed from: bC int
   public int levelIndex;
   // $VF: renamed from: bD int
   public int furthestLevel;
   // $VF: renamed from: bE int
   public int demoMode;
   // $VF: renamed from: bF java.lang.String
   public String demoBuyUrl;
   // $VF: renamed from: bG int[]
   public static final int[] levelPaletteVariants = new int[]{-1, -1, -1, 2, 0, 1, 1, 0, 2, 2};
   // $VF: renamed from: jc byte[]
   private byte[] levelData;
   // $VF: renamed from: jd int
   private int levelBytePos;
   // $VF: renamed from: je int
   private int levelCurByte;
   // $VF: renamed from: jf int
   private int levelBitsLeft;
   public Sprite[] bH;
   // $VF: renamed from: bI int[]
   public static int[] effectAnim = new int[10];
   // $VF: renamed from: bJ int[]
   public int[] effectX = new int[10];
   // $VF: renamed from: bK int[]
   public int[] effectY = new int[10];
   // $VF: renamed from: bL int[]
   public int[] effectFlip = new int[10];
   // $VF: renamed from: bM int
   public int effectLast = -1;
   public Sprite[] bN;
   public int[] bO = new int[10];
   public static int[] bP = new int[10];
   public int[] bQ = new int[10];
   public static int[] bR = new int[10];
   public int[] bS = new int[10];
   public int[] bT = new int[10];
   public int[] bU = new int[10];
   public boolean[] bV = new boolean[10];
   public static int bW = -1;
   public Sprite[] bX;
   public int[] bY = new int[20];
   public static int[] bZ = new int[20];
   public static int[] ca = new int[20];
   public int[] cb = new int[20];
   public int[] cc = new int[20];
   public static int cd = -1;
   public Sprite[] ce;
   public int[] cf = new int[20];
   public int[] cg = new int[20];
   public static int[] ch = new int[20];
   public int[] ci = new int[20];
   public int[] cj = new int[20];
   public static int ck = -1;
   public int[] cl;
   public static int[] cm;
   public int[] cn;
   public int[] co;
   public Sprite[] cp;
   public Sprite[] cq;
   public int cr = -1;
   public int cs;
   public int ct;
   public int cu;
   public static int cv;
   public static Sprite[] cw;
   // $VF: renamed from: cx int
   public int switchLast = -1;
   // $VF: renamed from: cy int[]
   public int[] switchX;
   // $VF: renamed from: cz int[]
   public static int[] switchY;
   // $VF: renamed from: cA boolean[]
   public boolean[] switchIsLever;
   public int[] cB;
   public int[] cC;
   // $VF: renamed from: cD boolean[]
   public boolean[] switchOn;
   // $VF: renamed from: cE int[]
   public static int[] switchAnim;
   // $VF: renamed from: cF int[]
   public int[] switchTileX;
   // $VF: renamed from: cG int[]
   public static int[] switchTileY;
   // $VF: renamed from: cH int[]
   public int[] switchTargets;
   // $VF: renamed from: cI int
   public static int gateLast = -1;
   public Sprite[] cJ;
   // $VF: renamed from: cK int[]
   public static int[] gateTileX;
   // $VF: renamed from: cL int[]
   public static int[] gateTileY;
   // $VF: renamed from: cM int[]
   public static int[] gateX;
   // $VF: renamed from: cN int[]
   public int[] gateY;
   // $VF: renamed from: cO int[]
   public static int[] gateTilesW;
   // $VF: renamed from: cP int[]
   public static int[] gateWidth;
   // $VF: renamed from: cQ int[]
   public int[] gateTilesH;
   // $VF: renamed from: cR int[]
   public int[] gateHeight;
   // $VF: renamed from: cS int[]
   public int[] gateId;
   // $VF: renamed from: cT int[]
   public static int[] gateAnim;
   // $VF: renamed from: cU int[]
   public int[] gateStyle;
   // $VF: renamed from: cV boolean[]
   public static boolean[] gateOpen;
   // $VF: renamed from: cW boolean[]
   public boolean[] gateShowsCamera;
   // $VF: renamed from: cX byte[]
   public byte[] triggerGateId;
   // $VF: renamed from: cY int[]
   public int[] triggerTileX;
   // $VF: renamed from: cZ int[]
   public static int[] triggerTileY;
   // $VF: renamed from: da int[]
   public int[] arenaTileX;
   // $VF: renamed from: db int[]
   public int[] arenaTileY;
   // $VF: renamed from: dc int[]
   public int[] arenaWidth;
   // $VF: renamed from: dd int[]
   public static int[] arenaHeight;
   // $VF: renamed from: de int[]
   public int[] arenaGateId;
   // $VF: renamed from: df int[]
   public static int[] arenaKills;
   // $VF: renamed from: dg int[]
   public int[] arenaKillsNeeded;
   public Sprite[] dh;
   public int[] di = new int[10];
   public int[] dj = new int[10];
   public int[] dk = new int[10];
   public static int[] dl = new int[10];
   public static int[] dm = new int[10];
   public int[] dn = new int[10];
   // $VF: renamed from: do int[]
   public int[] do_ = new int[10];
   public int dp = -1;
   public Sprite[] dq;
   // $VF: renamed from: dr int[]
   public int[] hazardAnim = new int[15];
   // $VF: renamed from: ds int[]
   public int[] hazardDamage = new int[15];
   // $VF: renamed from: dt int[]
   public static int[] hazardX = new int[15];
   // $VF: renamed from: du int[]
   public int[] hazardY = new int[15];
   // $VF: renamed from: dv int[]
   public int[] hazardHomeX = new int[15];
   // $VF: renamed from: dw int[]
   public int[] hazardHomeY = new int[15];
   // $VF: renamed from: dx int[]
   public static int[] hazardHeight = new int[15];
   // $VF: renamed from: dy int[]
   public int[] hazardWidth = new int[15];
   // $VF: renamed from: dz int
   public int hazardLast = -1;
   public boolean dA;
   public boolean dB;
   public Sprite[] dC;
   public static Sprite[] dD;
   public Sprite[] dE;
   public Sprite[] dF;
   public int dG;
   public int dH = 0;
   // $VF: renamed from: dI int
   public int killCount;
   public static int[] dJ = new int[15];
   public int[] dK = new int[15];
   public int dL;
   // $VF: renamed from: dM int
   public static int bossIndex;
   // $VF: renamed from: dN int
   public int finalBossIndex;
   // $VF: renamed from: dO byte
   public byte finalBossPhase;
   // $VF: renamed from: dP int[]
   public int[] enemyId = new int[15];
   // $VF: renamed from: dQ byte[]
   public byte[] enemyClass = new byte[15];
   // $VF: renamed from: dR int[]
   public int[] enemyAction = new int[15];
   public byte[] dS = new byte[15];
   // $VF: renamed from: dT int[]
   public static int[] enemyX = new int[15];
   // $VF: renamed from: dU int[]
   public int[] enemyY = new int[15];
   // $VF: renamed from: dV int[]
   public static int[] enemyHomeX = new int[15];
   // $VF: renamed from: dW int[]
   public static int[] enemyHomeY = new int[15];
   // $VF: renamed from: dX int[]
   public int[] enemyStatus = new int[15];
   // $VF: renamed from: dY byte[]
   public byte[] enemyWaveSlot = new byte[15];
   // $VF: renamed from: dZ int[]
   public int[] enemyTileX = new int[15];
   // $VF: renamed from: ea int[]
   public int[] enemyTileY = new int[15];
   // $VF: renamed from: eb byte[]
   public static byte[] enemyHalfWidthTiles = new byte[15];
   // $VF: renamed from: ec byte[]
   public static byte[] enemyRespawns = new byte[15];
   public static byte[] ed = new byte[15];
   // $VF: renamed from: ee short[]
   public short[] enemyWidth = new short[15];
   // $VF: renamed from: ef short[]
   public short[] enemyHeight = new short[15];
   // $VF: renamed from: eg byte[]
   public byte[] enemyHeightTiles = new byte[15];
   public boolean[] eh = new boolean[15];
   // $VF: renamed from: ei boolean[]
   public boolean[] enemyClimbing = new boolean[15];
   // $VF: renamed from: ej boolean[]
   public boolean[] enemyFacingRight = new boolean[15];
   // $VF: renamed from: ek int[]
   public static int[] enemyHealth = new int[15];
   // $VF: renamed from: el byte[]
   public byte[] enemyContactDamage = new byte[15];
   // $VF: renamed from: em int[]
   public int[] enemyDropAmount = new int[15];
   // $VF: renamed from: en int[]
   public static int[] enemyMaxHealth = new int[15];
   // $VF: renamed from: eo int[]
   public int[] enemySubX = new int[15];
   // $VF: renamed from: ep int[]
   public int[] enemySubY = new int[15];
   // $VF: renamed from: eq boolean[]
   public boolean[] enemyAtLadderTop = new boolean[15];
   // $VF: renamed from: er int[]
   public static int[] enemyRespawnTimer = new int[15];
   public static boolean[] es = new boolean[15];
   // $VF: renamed from: et int[]
   public int[] enemyRespawnDelay = new int[15];
   public static int[] eu = new int[15];
   public static boolean[] ev = new boolean[15];
   // $VF: renamed from: ew short[]
   public static short[] enemyBoxes = new short[30];
   // $VF: renamed from: ex boolean
   public static boolean enemyCanMoveX = true;
   // $VF: renamed from: ey boolean
   public boolean playerInvulnerable;
   // $VF: renamed from: ez boolean
   public boolean enemyCanMoveY = true;
   // $VF: renamed from: eA boolean
   public static boolean enemyOnGround = true;
   // $VF: renamed from: eB int
   public int enemyCount;
   // $VF: renamed from: eC int[]
   public int[] waveTileX;
   // $VF: renamed from: eD int[]
   public int[] waveTileY;
   // $VF: renamed from: eE int[]
   public int[] waveEnemyX;
   // $VF: renamed from: eF int[]
   public int[] waveEnemyY;
   // $VF: renamed from: eG boolean[]
   public boolean[] waveEnemyFacing;
   public Sprite[] eH;
   public int[] eI;
   public int[] eJ;
   public int[] eK;
   public static byte[] eL;
   public Sprite[] eM;
   // $VF: renamed from: eN int[]
   public int[] pushAnim;
   // $VF: renamed from: eO int[]
   public int[] pushX;
   // $VF: renamed from: eP int[]
   public int[] pushY;
   // $VF: renamed from: eQ int[]
   public static int[] pushTileX;
   // $VF: renamed from: eR int[]
   public int[] pushTileY;
   // $VF: renamed from: eS int[]
   public int[] pushWidth;
   // $VF: renamed from: eT int[]
   public int[] pushHeight;
   // $VF: renamed from: eU byte[]
   public byte[] pushTilesW;
   // $VF: renamed from: eV byte[]
   public byte[] pushTilesH;
   public static boolean[] eW;
   // $VF: renamed from: eX int
   public static int pushLast = -1;
   public Sprite[] eY;
   // $VF: renamed from: eZ int
   public int breakLast = -1;
   // $VF: renamed from: fa int[]
   public int[] breakAnim;
   // $VF: renamed from: fb int[]
   public int[] breakTileX;
   // $VF: renamed from: fc int[]
   public static int[] breakTileY;
   // $VF: renamed from: fd int[]
   public static int[] breakX;
   // $VF: renamed from: fe int[]
   public int[] breakY;
   // $VF: renamed from: ff int[]
   public static int[] breakWidth;
   // $VF: renamed from: fg int[]
   public int[] breakHeight;
   // $VF: renamed from: fh byte[]
   public byte[] breakTilesW;
   // $VF: renamed from: fi byte[]
   public byte[] breakTilesH;
   // $VF: renamed from: fj boolean[]
   public static boolean[] breakStopsCamera;
   // $VF: renamed from: fk boolean[]
   public static boolean[] breakCameraRight;
   // $VF: renamed from: fl c[]
   public Sprite[] chestSprites;
   // $VF: renamed from: fm int
   public int chestLast = -1;
   // $VF: renamed from: fn int
   public int chestWidth;
   // $VF: renamed from: fo int
   public int chestHeight;
   // $VF: renamed from: fp boolean[]
   public static boolean[] chestOpened;
   // $VF: renamed from: fq int[]
   public int[] chestX;
   // $VF: renamed from: fr int[]
   public int[] chestY;
   // $VF: renamed from: fs int[]
   public static int[] chestReward;
   // $VF: renamed from: ft int[]
   public int[] chestAnim = new int[10];
   public Sprite[] fu;
   // $VF: renamed from: fv int
   public int chestPopupKind = -1;
   // $VF: renamed from: fw int
   public int chestPopupTimer = 0;
   public Sprite[] fx;
   // $VF: renamed from: fy int[]
   public static final int[] pickupTrailX = new int[80];
   // $VF: renamed from: fz int[]
   public static final int[] pickupTrailY = new int[80];
   // $VF: renamed from: fA int[]
   public static final int[] pickupVelX = new int[20];
   // $VF: renamed from: fB int[]
   public static final int[] pickupVelY = new int[20];
   // $VF: renamed from: fC int[]
   public static final int[] pickupTarget = new int[20];
   // $VF: renamed from: fD int[]
   public static final int[] pickupAge = new int[20];
   // $VF: renamed from: fE int[]
   public static final int[] pickupKind = new int[20];
   // $VF: renamed from: fF int[]
   public static final int[] pickupAmount = new int[20];
   // $VF: renamed from: fG int
   public int pickupLast = -1;
   public Sprite[] fH;
   public static final byte[] fI = new byte[]{2, 2, 2, 4, 4, 4, 8};
   public static final byte[] fJ = new byte[]{4, 4, 10, 10, 18, 18};
   public static final byte[] fK = new byte[]{2, 3, 4, 5, 6};
   public static final int[] fL = new int[]{128, 256, 512, 1024, 1536};
   // $VF: renamed from: fM int
   public int weaponMode = 0;
   public boolean fN;
   public int fO;
   public int fP;
   // $VF: renamed from: fQ int
   public int qteRequired;
   // $VF: renamed from: fR boolean
   public static boolean qteActive;
   // $VF: renamed from: fS int
   public int qteProgress;
   // $VF: renamed from: fT int
   public int qteDirection;
   // $VF: renamed from: fU int[]
   public static final int[] qteKeyAnims = new int[]{2, 4, 5, 6, 8};
   // $VF: renamed from: fV boolean
   public boolean queuedFacingRight;
   public int fW;
   public int fX;
   // $VF: renamed from: fY int
   public int checkpointX;
   // $VF: renamed from: fZ int
   public int checkpointY;
   // $VF: renamed from: ga int
   public int playerX;
   // $VF: renamed from: gb int
   public int playerY;
   public static int gc;
   // $VF: renamed from: gd int
   public static int pushedCrate;
   // $VF: renamed from: ge int
   public int grappledEnemy = -1;
   // $VF: renamed from: gf boolean
   public boolean hitFromRight;
   public static boolean gg;
   public static boolean gh;
   // $VF: renamed from: gi boolean
   public boolean blockedHit;
   // $VF: renamed from: gj boolean
   public boolean usingSwitch;
   public boolean gk;
   public byte gl;
   // $VF: renamed from: gm boolean
   public boolean openingChest;
   // $VF: renamed from: gn boolean
   public boolean climbing;
   // $VF: renamed from: go boolean
   public boolean balancing;
   // $VF: renamed from: gp boolean
   public boolean airAttacking;
   // $VF: renamed from: gq boolean
   public static boolean hangingOnBar;
   // $VF: renamed from: gr boolean
   public static boolean ledgeHanging;
   // $VF: renamed from: gs boolean
   public boolean grabbingLedge;
   // $VF: renamed from: gt boolean
   public boolean pushing;
   // $VF: renamed from: gu boolean
   public boolean atLadderTop;
   // $VF: renamed from: gv boolean
   public boolean attacking;
   public int gw;
   public static int gx;
   // $VF: renamed from: gy boolean
   public boolean onGround;
   // $VF: renamed from: gz boolean
   public boolean onPlatform;
   public boolean gA;
   public static boolean gB;
   // $VF: renamed from: gC int
   public static int playerWidth;
   // $VF: renamed from: gD int
   public int playerHeight;
   // $VF: renamed from: gE boolean
   public boolean attackQueued;
   // $VF: renamed from: gF int
   public static int attackTimer;
   // $VF: renamed from: gG int
   public int comboIndex;
   // $VF: renamed from: gH int
   public static int comboHits = 0;
   // $VF: renamed from: gI int
   public int comboTimer = 0;
   // $VF: renamed from: gJ int
   public int activeArena = -1;
   // $VF: renamed from: gK int
   public int arenaBannerTimer;
   public int gL;
   public static boolean gM;
   // $VF: renamed from: gN byte
   public static byte bladesComboLength;
   // $VF: renamed from: gO byte
   public byte magicAComboLength;
   // $VF: renamed from: gP byte
   public static byte bladesLevel;
   // $VF: renamed from: gQ byte
   public static byte magicALevel;
   // $VF: renamed from: gR int[]
   public static final int[] bladesCosts = new int[]{1000, 2000, 3000, 4000};
   // $VF: renamed from: gS int[]
   public static final int[] magicACosts = new int[]{1000, 2000, 3000, 4000};
   // $VF: renamed from: gT int[]
   public static final int[] magicBCosts = new int[]{1000, 2000, 3000, 4000};
   // $VF: renamed from: gU int[]
   public static final int[] magicCCosts = new int[]{1000, 2000, 3000, 4000};
   // $VF: renamed from: gV byte
   public static byte magicBLevel = 0;
   // $VF: renamed from: gW byte
   public static byte magicCLevel = 0;
   // $VF: renamed from: gX int
   public int upgradeProgressA;
   // $VF: renamed from: gY int
   public int upgradeProgressB;
   // $VF: renamed from: gZ int
   public int upgradeProgressC;
   // $VF: renamed from: ha int
   public int upgradeProgressD;
   // $VF: renamed from: hb boolean
   public static boolean magicModeA = false;
   // $VF: renamed from: hc boolean
   public static boolean magicModeB = false;
   // $VF: renamed from: hd boolean
   public boolean magicModeC = false;
   // $VF: renamed from: he int
   public static int chestFlags;
   public static byte hf;
   public int hg;
   // $VF: renamed from: hh int
   public static int subX;
   // $VF: renamed from: hi int
   public int subY;
   // $VF: renamed from: hj int
   public int health;
   // $VF: renamed from: hk int
   public int healthPrev;
   // $VF: renamed from: hl int
   public static int magic;
   // $VF: renamed from: hm int
   public int maxHealth;
   // $VF: renamed from: hn int
   public int maxMagic;
   // $VF: renamed from: ho int
   public int healthChestsFound;
   // $VF: renamed from: hp int
   public int magicChestsFound;
   // $VF: renamed from: hq int
   public int upgradePoints;
   // $VF: renamed from: hr int
   public static int orbsCollected;
   // $VF: renamed from: hs int
   public int orbBudget;
   // $VF: renamed from: ht short[]
   public short[] playerBoxes = new short[20];
   // $VF: renamed from: hu boolean
   public static boolean facingRight;
   // $VF: renamed from: hv boolean
   public boolean checkpointFacingRight;
   // $VF: renamed from: hw boolean
   public boolean blocking;
   // $VF: renamed from: hx int
   public int frontExtent;
   // $VF: renamed from: hy int
   public int backExtent;
   // $VF: renamed from: hz int
   public int bestKillCount;
   // $VF: renamed from: hA int
   public int playerAction = -1;
   // $VF: renamed from: hB int
   public static int playerAnim = -1;
   // $VF: renamed from: hC boolean
   public boolean canMoveX = true;
   // $VF: renamed from: hD boolean
   public static boolean canMoveY = true;
   // $VF: renamed from: hE boolean
   public boolean landed = false;
   // $VF: renamed from: hF boolean
   public boolean blockedByWall = false;
   public boolean hG = false;
   // $VF: renamed from: hH int
   public int slowMotionShift = 0;
   // $VF: renamed from: hI int
   public int moveAccumX;
   // $VF: renamed from: hJ int
   public int moveAccumY;
   // $VF: renamed from: hK int
   public int fallSpeed = 0;
   // $VF: renamed from: hL int
   public int fallTimer = 0;
   // $VF: renamed from: hM short[]
   public short[] framePartsBuffer = new short[256];
   // $VF: renamed from: hN int
   public int sceneObjectCount = 0;
   public int hO;
   public int hP = -1;
   public int hQ;
   public boolean hR;
   public static int hS;
   public static int hT;
   public static int hU;
   public static int hV;
   public static String[] hW;
   // $VF: renamed from: hX java.lang.String[]
   public static String[] panelText;
   public static byte[] hY;
   public static int hZ;
   public static int ia;
   public static int ib;
   public static boolean ic;
   public static final int[] id = new int[]{40, -1, -3, -3, -3};
   public static final int[] ie = new int[]{42, -1, -3, -3, -3};
   // $VF: renamed from: if int[]
   public static final int[] if_ = new int[]{44, -1, -3, -3, -3};
   public static final byte[] ig = new byte[]{13, 4, 2, 2, 2};
   public static final byte[] ih = new byte[]{13, 4, 4, 4, 4};
   public int ii;
   public int ij;
   public int ik;
   public int il;
   public int im;
   public int in;
   public int io;
   public boolean ip;
   // $VF: renamed from: iq byte[]
   public static byte[] saveBuffer;
   // $VF: renamed from: ir byte[]
   public static byte[] fireHeat;
   // $VF: renamed from: is int[]
   public static int[] firePixels;
   // $VF: renamed from: it boolean
   public static boolean fireReseed = true;
   public int iu;
   public int iv = -1;
   // $VF: renamed from: iw int[]
   public static int[] menuTable;
   // $VF: renamed from: ix int
   public static int menuCursor;
   public int iy;
   public int iz;
   public int iA;
   public boolean iB;
   public boolean iC = false;
   public int iD;
   public int iE;
   public int iF;
   public int iG;
   public int iH;
   public boolean iI = false;
   public int iJ;
   public static boolean iK;

   static {
      // (obfuscator dead code removed: arrays built and discarded, see rename_gow.py)
   }

   // $VF: renamed from: k () void
   private void readPressedKey() {
      int var1 = super.keysPressed;
      if (super.keysPressed != 0) {
         if ((var1 & 2097408) != 0) {
            this.pressedKey = 8;
         } else if ((var1 & 4194336) != 0) {
            this.pressedKey = 5;
         } else if ((var1 & 1048580) != 0) {
            this.pressedKey = 2;
         } else if ((var1 & 262146) != 0) {
            this.pressedKey = 1;
         } else if ((var1 & 16777280) != 0) {
            this.pressedKey = 6;
         } else if ((var1 & 131072) != 0) {
            this.pressedKey = 49;
         } else if ((var1 & 524288) != 0) {
            this.pressedKey = 51;
         } else if ((var1 & 8388608) != 0) {
            this.pressedKey = 55;
         } else if ((var1 & 33554432) != 0) {
            this.pressedKey = 57;
         } else if ((var1 & 65536) != 0) {
            this.pressedKey = 48;
         } else if ((var1 & 1024) != 0) {
            this.pressedKey = 42;
         } else if ((var1 & 8) != 0) {
            this.pressedKey = 35;
         } else if ((var1 & 134217728) != 0) {
            this.pressedKey = 27;
         } else {
            this.pressedKey = 0;
         }

         if ((var1 & 603979776) != 0) {
            this.pressedKey = 29;
            return;
         }
      } else {
         this.pressedKey = 0;
      }
   }

   // $VF: renamed from: l () void
   private void readHeldKey() {
      int var1 = super.keysHeld;
      if (super.keysHeld != 0) {
         if ((var1 & 2097408) != 0) {
            this.heldKey = 8;
         } else if ((var1 & 4194336) != 0) {
            this.heldKey = 5;
         } else if ((var1 & 1048580) != 0) {
            this.heldKey = 2;
         } else if ((var1 & 262146) != 0) {
            this.heldKey = 1;
         } else if ((var1 & 16777280) != 0) {
            this.heldKey = 6;
         } else if ((var1 & 131072) != 0) {
            this.heldKey = 49;
         } else if ((var1 & 524288) != 0) {
            this.heldKey = 51;
         } else if ((var1 & 8388608) != 0) {
            this.heldKey = 55;
         } else if ((var1 & 33554432) != 0) {
            this.heldKey = 57;
         } else if ((var1 & 65536) != 0) {
            this.heldKey = 48;
         } else if ((var1 & 1024) != 0) {
            this.heldKey = 42;
         } else if ((var1 & 8) != 0) {
            this.heldKey = 35;
         } else if ((var1 & 134217728) != 0) {
            this.heldKey = 27;
         } else if ((var1 & 604012544) != 0) {
            this.heldKey = 29;
         } else {
            this.heldKey = 0;
         }
      } else {
         this.heldKey = 0;
      }
   }

   public Game(GOWMIDlet var1) {
      super(var1);
      super.maxFrameTime = 100;
      super.minFrameTime = 40;
      this.setViewSize(240, 320);
      this.soundPlayer = new SoundPlayer(this, 12);
      this.soundPlayer.setSoundOn(false);
      state = 0;

      try {
         this.cheatsEnabled = Engine.parseIntOr(var1.getAppProperty("ENABLECHEATS"), 0) == 1;
      } catch (Exception var3) {
         this.cheatsEnabled = false;
      }

      try {
         this.demoMode = Engine.parseIntOr(var1.getAppProperty("DEMO"), 0);
         this.demoBuyUrl = var1.getAppProperty("DemoBuyURL");
      } catch (Exception var2) {
         this.demoMode = 0;
         this.demoBuyUrl = "";
      }
   }

   // $VF: renamed from: i (int) void
   public final void onLifecycle(int var1) {
      if (var1 != 0) {
         if (var1 == 1) {
            if (state != 102 && state != 107) {
               this.af = this.topBarTarget >> 8;
               this.ag = this.bottomBarTarget >> 8;
            }

            if (state != 107 && state != 102) {
               this.J = state;
            }

            if (state != 100
               && state != 78
               && state != 105
               && state != 108
               && state != 101
               && state != 102
               && state != 104
               && state != 106
               && state != 109
               && state != 103
               && state != 79
               && state != -3
               && state != 16
               && state != 107
               && state != 0
               && state != 1) {
               state = 80;
               this.hR = false;
            } else if (state != 79
               && state != 106
               && state != 108
               && state != 109
               && state != -3
               && state != 1
               && state != 16
               && state != 107
               && state != 0
               && state != 78) {
               this.setBarTargets(halfHeight - (lineHeight << 1), halfHeight - (lineHeight << 1), 35, 35);
               this.hR = false;
               this.topBar = halfHeight - (lineHeight << 1) << 8;
               this.bottomBar = halfHeight - (lineHeight << 1) << 8;
               this.W = false;
               state = 102;
               this.iB = true;
            }

            this.iI = false;
            this.iC = true;
         } else if (var1 == 5) {
            if (this.hR && state == 80) {
               this.hR = false;
               this.playSound(0);
            }
         } else if (var1 == 2) {
            if (state == 80) {
               this.playSound(0);
            }
         } else if (var1 == 3) {
            this.soundPlayer.stop();
         }
      }

      super.onLifecycle(var1);
   }

   // $VF: renamed from: a () void
   public final void update() {
      this.frameDelta = super.frameTime >> this.slowMotionShift;
      this.pollKeys();
      this.readPressedKey();
      this.readHeldKey();
      switch (state) {
         case 0:
            if (this.bootStep <= 13) {
               this.runBootStep();
               return;
            }

            this.iS = null;
            this.parseBank(null);
            this.iC = true;
            this.loadGame(1);
            this.iS = null;
            panelText = new String[3];
            panelText[0] = this.getString(36);
            panelText[1] = "";
            panelText[2] = "";
            this.a(if_, ih);
            state = 78;
            this.releaseTransientAnimSets();
            this.bootStep = 0;
            return;
         case 1:
            this.updateBars();
            if (this.levelLoadStarted) {
               clearPanelText();
               if (this.levelLoadStep == 0) {
                  this.resetLevelState();
                  this.loadMenuSprites(false);
                  S = this.getResourceBytes(this.levelResourceId);
                  this.grappledEnemy = -1;
                  bossIndex = -1;
                  this.finalBossIndex = -1;
               }

               if (this.levelLoadStep <= 10) {
                  this.loadLevelStep(S, false);
                  return;
               }

               this.clearKeys();
               S = null;
               if (this.enemyCount >= 1) {
                  this.enemyCount--;
               }

               this.t();
               int var2 = this.levelLoadStep;
               this.levelLoadStep = 0;
               this.levelLoadStep = var2;
               this.levelLoadStarted = false;
               this.loadMenuSprites(false);
               this.updateCamera();
               this.scene.setScroll(cameraX, cameraY);
               this.setBarTargets(halfHeight, halfHeight, 35, 35);
               this.bf = true;
               if (this.Q <= 0) {
                  this.al = true;
                  return;
               }
            }

            return;
         case 78:
            if (this.pressedKey == 27 || this.pressedKey == 8) {
               this.loadStringTable(languageStringBanks[languageIndex]);
               this.iC = true;
               this.requestClear();
               panelText = new String[3];
               panelText[0] = this.getString(36);
               panelText[1] = "";
               panelText[2] = "";
               this.a(if_, ih);
               state = 79;
               return;
            }

            if (this.pressedKey == 1) {
               if (languageIndex > 0) {
                  languageIndex--;
                  return;
               }

               return;
            } else {
               if (this.pressedKey == 6) {
                  if (languageIndex < 5) {
                     languageIndex++;
                     return;
                  }
               } else if (this.pressedKey == 29) {
                  this.saveAndQuit();
                  return;
               }

               return;
            }
         case 79:
            this.updateFireEffect();
            this.updateBars();
            if ((this.pressedKey == 27 || this.pressedKey == 29) && this.topBar == 0) {
               if (this.pressedKey == 27) {
                  this.soundPlayer.setSoundOn(true);
               } else {
                  this.soundPlayer.setSoundOn(false);
               }

               iL = this.soundPlayer.isSoundOn();
               this.playSound(0);
               if (this.topBarTarget == halfHeight << 8) {
                  this.setBarTargets(0, 0, 35, 35);
               } else {
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
               }

               this.iC = true;
               return;
            }

            return;
         case 80:
            this.randomValue = random.nextInt();
            if (this.topBar == 0) {
               this.L();
               this.updateMenu();
            }

            this.updateBars();
            if (this.pressedKey == 48 && this.cheatsEnabled) {
               for (int var1 = 0; var1 < 10; var1++) {
                  menuTable[9 + var1] = menuTable[9 + var1] = menuTable[9 + var1] | 50331648;
               }

               return;
            }

            return;
         case 101:
         case 102:
         case 105:
         case 108:
            break;
         case 104:
            this.slowMotionShift = 0;
            if (this.chestPopupKind == 10) {
               this.maxHealth += 3;
               this.health = this.health + this.maxHealth / 64;
               if (this.health > this.maxHealth) {
                  this.health = this.maxHealth;
               }
            } else {
               this.maxMagic += 3;
               magic = magic + this.maxMagic / 64;
               if (magic > this.maxMagic) {
                  magic = this.maxMagic;
               }
            }

            if (this.chestPopupTimer <= 0) {
               state = 100;
               this.iB = true;
               if (this.health > this.maxHealth && this.chestPopupKind == 10) {
                  this.health = this.maxHealth;
               } else if (this.chestPopupKind == 9) {
                  magic = this.maxMagic;
               }
            }

            this.chestPopupTimer -= 3;
         case 100:
            this.flashTimer = this.flashTimer + this.frameDelta;
            if (this.flashTimer >= 250) {
               this.flashTimer = 0;
               if (this.flashColor == 0) {
                  this.flashColor = 16777215;
               } else {
                  this.flashColor = 0;
               }
            }

            this.bc = false;
            break;
         case 106:
            this.updateBars();
            this.bi = false;
            this.updateUpgradeScreen();
            return;
         case 107:
            if (!this.aW) {
               this.E();
            }

            if (this.aW) {
               if (this.heldKey == 1) {
                  this.aX = 24;
               } else {
                  this.aX = 4;
               }

               if (this.heldKey == 6) {
                  this.aX = -24;
               }

               this.in = this.in + this.frameDelta * this.aX;
               if (this.in < 0) {
                  this.in = 0;
               }

               if ((this.in >> 8 > 50 + this.screenHeight - lineHeight || this.heldKey == 29 && this.topBar == this.topBarTarget)
                  && state == 107
                  && this.topBarTarget < halfHeight << 8) {
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
                  if (this.Q > 0) {
                     this.al = true;
                  } else {
                     this.am = true;
                     this.Q = -1;
                  }
               }
            } else if (this.pressedKey == 29 && this.topBar == this.topBarTarget) {
               this.ah = true;
               this.setBarTargets(halfHeight, halfHeight, 35, 35);
               this.iC = true;
            }

            this.updateBars();
            return;
         case 109:
            this.updateBars();
            if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && !this.W) {
               if (this.pressedKey == 27 && (this.demoMode <= 0 || this.levelIndex < this.demoMode)) {
                  this.au = true;
                  this.saveGame(1);
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
               }

               if (this.pressedKey == 29) {
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
                  this.pendingMainMenu = true;
                  this.cr = -1;
                  return;
               }
            }

            return;
         default:
            return;
      }

      this.randomValue = random.nextInt();
      if ((state == 100 || state == 105 || state == 108) && !this.bc) {
         this.updateGameplay();
      }

      if (state == 105) {
         this.heldKey = 0;
         this.pressedKey = 0;
      }

      if (state == 101) {
         if (this.topBar >= this.topBarTarget && this.topBar < this.screenHeight << 8) {
            this.bd = this.bd + (this.frameDelta >> 4 - (this.heldKey == 8 ? 3 : 0));
         }

         this.updateDialogue();
      } else {
         this.bd = 0;
      }

      this.updateCamera();
      this.scene.setScroll(cameraX, cameraY);
      this.updateBars();
   }

   // $VF: renamed from: a (int, int, int, int) void
   private void setBarTargets(int var1, int var2, int var3, int var4) {
      this.Y = this.topBar <= var1 << 8;
      this.Z = this.bottomBar <= var2 << 8;
      this.W = this.Z || this.Y;
      if (this.W) {
         this.V = 375;
      }

      this.topBarTarget = var1 << 8;
      this.bottomBarTarget = var2 << 8;
      this.topBarSpeed = var3;
      this.bottomBarSpeed = var4;
      this.levelLoadStarted = false;
      this.ap = false;
      this.pendingMainMenu = false;
      this.X = false;
   }

   // $VF: renamed from: m () void
   private void updateBars() {
      if (this.topBar >= this.topBarTarget && this.bottomBar >= this.bottomBarTarget && (state == 105 || state == 100)) {
         this.bc = false;
      }

      if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && this.V > 0) {
         if (this.V == 375 && state != 101 && state != 105) {
            this.playSound(1);
         }

         this.V = this.V - this.frameDelta;
         if (this.V < 0) {
            this.V = 0;
            return;
         }
      } else {
         if (state == 1) {
            if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && this.W && this.Q <= 0) {
               if (!this.al) {
                  if (!challengeMode) {
                     this.setBarTargets(halfHeight - (lineHeight << 1), halfHeight - (lineHeight << 1), 35, 35);
                  } else {
                     this.setBarTargets(halfHeight - (lineHeight << 1) - lineHeight, halfHeight - (lineHeight << 1) - lineHeight, 35, 35);
                  }

                  this.W = false;
               } else {
                  this.setBarTargets(0, 0, 35, 35);
                  state = 100;
                  this.iB = true;
                  this.levelLoadStep = 0;
                  this.Q = 0;
                  this.bf = false;
                  this.al = false;
               }
            } else if (this.Q > 0 && this.levelLoadStep >= 10 && this.topBar >= this.topBarTarget && this.bottomBar >= this.bottomBarTarget && this.W) {
               this.bf = true;
               int[] var2;
               (var2 = new int[3])[0] = -1;
               var2[1] = this.Q;
               var2[2] = -1;
               this.cr = -1;
               this.a(var2, aV, 8, 25, 211, 270, 30);
               this.aW = true;
               this.setBarTargets(25, 25, 35, 35);
               this.in = 0;
               state = 107;
            } else if (this.Q > 0 && this.levelLoadStep > 10 && !this.W && this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget) {
               this.aW = true;
               this.bf = true;
               this.setBarTargets(halfHeight, halfHeight, 35, 35);
               this.levelLoadStarted = true;
            } else if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && !this.W && !this.levelLoadStarted) {
               this.W = false;
               this.levelLoadStarted = true;
            }
         } else if (state == 101) {
            if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && this.W && this.aW) {
               this.a(this.aQ, aV, 8, 25, 211, 270, 30);
               if (panelText != null) {
                  panelText[0] = "";
                  panelText[2] = "";
               }

               this.setBarTargets(25, 25, 35, 35);
               state = 107;
               this.in = 0;
            }
         } else if (state == 102) {
            if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && this.W) {
               if (this.ap) {
                  this.setBarTargets(this.af, this.ag, 35, 35);
                  state = this.J;
                  this.ap = false;
                  this.W = false;
                  this.a(this.aQ, aV, 8, 0, 211, lineHeight * 5 + halfLineHeight, 30);
               } else if (this.pendingMainMenu) {
                  this.pendingMainMenu = false;
                  this.resetLevelState();
                  this.playSound(0);
                  this.loadMenuSprites(true);
                  this.parseBank(null);
                  menuCursor = 0;
                  this.iy = 0;
                  state = 80;
                  this.setBarTargets(0, 0, 35, 35);
                  this.saveGame(1);
               } else if (this.pendingQuit) {
                  this.saveAndQuit();
               } else if (this.pendingHelp) {
                  this.requestClear();
                  panelText = new String[3];
                  panelText[0] = "";
                  panelText[2] = "";
                  this.setFont(this.mainFont);
                  panelText[1] = this.getString(114) + "\n" + this.getString(292) + "\n\n\n\n";
                  this.a(id, ig);
                  this.setBarTargets(25, 25, 35, 35);
                  state = 107;
                  this.in = 0;
               } else {
                  this.setBarTargets(halfHeight - (lineHeight << 1), halfHeight - (lineHeight << 1), 35, 35);
                  this.X = true;
               }

               this.W = false;
            }
         } else if (state == 80) {
            if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && this.W && this.aj) {
               this.aj = false;
               this.requestClear();
               panelText = new String[3];
               panelText[0] = "";
               panelText[2] = "";
               this.setFont(this.mainFont);
               if (this.ai) {
                  panelText[1] = this.getString(115);
                  int var1;
                  if ((var1 = panelText[1].indexOf(37)) != -1) {
                     panelText[1] = panelText[1].substring(0, var1) + "1.4.8" + panelText[1].substring(var1 + 1, panelText[1].length());
                  }

                  this.a(ie, ig);
               } else {
                  panelText[1] = this.getString(114) + "\n" + this.getString(292) + "\n\n\n\n";
                  this.a(id, ig);
               }

               this.setBarTargets(25, 25, 35, 35);
               state = 107;
            }
         } else if (state == 79) {
            if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && this.W) {
               this.setBarTargets(0, 0, 35, 35);
               this.iI = false;
               this.iC = true;
               this.saveGame(1);
               state = 80;
            }
         } else if (state != 107) {
            if (state == 109) {
               if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && this.W) {
                  if (!this.pendingMainMenu && !this.au) {
                     this.setBarTargets(halfHeight - (lineHeight << 1), halfHeight - (lineHeight << 1), 35, 35);
                  } else if (this.au) {
                     state = 106;
                     this.setBarTargets(0, 0, 35, 35);
                  } else {
                     state = 80;
                     this.playSound(0);
                     this.pendingMainMenu = false;
                     this.saveGame(1);
                     if (this.furthestLevel >= 10) {
                        menuCursor = 9;
                     } else {
                        menuCursor = this.furthestLevel + 9;
                     }

                     this.resetLevelState();
                     this.loadMenuSprites(true);
                     this.parseBank(null);
                     this.bf = false;
                     this.iy = 0;
                     this.setBarTargets(0, 0, 35, 35);
                  }
               }
            } else if (state == 108 && this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && this.W) {
               if (!this.pendingMainMenu && !this.ap) {
                  if (challengeMode) {
                     this.setBarTargets(
                        halfHeight - (lineHeight << 1) - lineHeight - (lineHeight >> 2),
                        halfHeight - (lineHeight << 1) - lineHeight - (lineHeight >> 2),
                        35,
                        35
                     );
                  } else {
                     this.setBarTargets(halfHeight - halfLineHeight - (lineHeight >> 2), halfHeight - halfLineHeight - (lineHeight >> 2), 35, 35);
                  }

                  this.X = true;
               } else if (!this.ap && this.pendingMainMenu) {
                  this.pendingMainMenu = false;
                  this.resetLevelState();
                  this.playSound(0);
                  this.loadMenuSprites(true);
                  this.parseBank(null);
                  this.iy = 0;
                  menuCursor = 0;
                  state = 80;
                  this.setBarTargets(0, 0, 35, 35);
                  this.saveGame(1);
               } else {
                  state = 100;
                  this.iB = true;
                  this.setBarTargets(0, 0, 35, 35);
                  this.X = true;
               }
            }
         } else {
            if (this.topBar != this.topBarTarget || this.bottomBar == this.bottomBarTarget) {
               this.requestClear();
            }

            if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && this.ah) {
               if (!this.pendingHelp) {
                  state = 80;
                  this.ah = false;
                  menuCursor = 0;
                  this.iy = 0;
                  this.setBarTargets(0, 0, 35, 35);
               } else if (this.topBar == halfHeight << 8) {
                  this.cr = this.at;
                  this.pendingHelp = false;
                  this.ah = false;
                  this.setBarTargets(halfHeight - (lineHeight << 1), halfHeight - (lineHeight << 1), 35, 35);
                  state = 102;
               }
            } else if (this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && this.am && this.Q < 0) {
               this.setBarTargets(halfHeight - (lineHeight << 1), halfHeight - (lineHeight << 1), 35, 35);
               this.bf = true;
               this.am = false;
               this.iI = false;
               menuCursor++;
               this.levelIndex++;
               if (this.levelIndex > this.furthestLevel && (this.demoMode <= 0 || this.levelIndex < this.demoMode)) {
                  this.furthestLevel = this.levelIndex;
               }

               if (this.levelIndex < 10) {
                  this.levelResourceId = levelIds[this.levelIndex];
               }

               this.ae = true;
               this.levelLoadStarted = false;
               this.resetLevelState();
               if (this.levelIndex < 10) {
                  state = 109;
               } else {
                  this.resetLevelState();
                  this.playSound(0);
                  this.loadMenuSprites(true);
                  this.parseBank(null);
                  this.setBarTargets(0, 0, 35, 35);
                  this.iy = 0;
                  menuCursor = 0;
                  this.bf = false;
                  state = 80;
                  this.saveGame(1);
               }
            } else if (this.topBar >= this.topBarTarget && this.bottomBar >= this.bottomBarTarget && this.Q > 0 && this.al) {
               state = 100;
               this.iB = true;
               this.bf = false;
               this.al = false;
               this.levelLoadStep = 0;
               this.Q = 0;
               this.setBarTargets(0, 0, 35, 35);
            }
         }

         if (state == 102 && this.X && this.V < 0) {
            this.X = false;
            state = this.J;
            this.bc = true;
            this.iB = true;
         }

         if (this.topBar > 115) {
            if (state == 108 && this.topBar == this.topBarTarget && !this.W) {
               if (this.pressedKey != 8 && this.pressedKey != 27) {
                  if (this.pressedKey == 29) {
                     this.setBarTargets(halfHeight, halfHeight, 35, 35);
                     this.pendingMainMenu = true;
                  }
               } else if (!challengeMode) {
                  this.playerX = this.checkpointX;
                  this.playerY = this.checkpointY;
                  facingRight = this.checkpointFacingRight;
                  cameraX = this.playerX - 120 - ((facingRight ? 1 : -1) * 240 >> 2);
                  cameraY = this.playerY - 266;
                  this.aO = cameraX << 8;
                  this.aP = cameraY << 8;
                  this.blocking = false;
                  this.setPlayerAction(0);
                  this.health = this.maxHealth;
                  this.healthPrev = this.maxHealth;
                  magic = this.maxMagic;
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
                  this.X = true;
                  this.iB = true;
                  this.activeArena = -1;
                  this.ap = true;
               }
            } else if (state == 102 && this.topBar == this.topBarTarget && !this.W) {
               if (this.pressedKey != 8 && this.pressedKey != 27) {
                  if (this.pressedKey == 29) {
                     if (this.pauseConfirming) {
                        this.pauseConfirming = false;
                     } else {
                        this.setBarTargets(halfHeight, halfHeight, 35, 35);
                        this.ap = true;
                     }
                  } else if (this.pressedKey == 2) {
                     if (!this.pauseConfirming) {
                        pauseMenuIndex++;
                        if (pauseMenuIndex > 4) {
                           pauseMenuIndex = 4;
                        }
                     }
                  } else if (this.pressedKey == 5 && !this.pauseConfirming) {
                     pauseMenuIndex--;
                     if (pauseMenuIndex < 1) {
                        pauseMenuIndex = 1;
                     }
                  }
               } else if (pauseMenuIndex == 4) {
                  this.soundPlayer.setSoundOn(!this.soundPlayer.isSoundOn());
                  iL = this.soundPlayer.isSoundOn();
               } else if (pauseMenuIndex == 2 && this.pauseConfirming) {
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
                  this.cr = -1;
                  this.pendingMainMenu = true;
               } else if (pauseMenuIndex == 1 && this.pauseConfirming) {
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
                  this.pendingQuit = true;
               } else if ((pauseMenuIndex == 2 || pauseMenuIndex == 1) && !this.pauseConfirming) {
                  this.pauseConfirming = true;
               } else if (pauseMenuIndex == 3) {
                  this.aW = false;
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
                  this.pendingHelp = true;
                  this.at = this.cr;
                  this.cr = -1;
               } else {
                  this.pauseConfirming = false;
                  this.pendingHelp = false;
               }
            }
         }

         if (this.topBar < this.topBarTarget && this.Y && (this.ae && this.bottomBar <= this.bottomBar || !this.ae)) {
            this.iB = true;
            this.topBar = this.topBar + this.frameDelta * this.topBarSpeed;
            if (this.topBar >= this.topBarTarget) {
               this.topBar = this.topBarTarget;
               if (state == 105) {
                  this.bc = false;
               }
            }
         }

         if (this.bottomBar < this.bottomBarTarget && this.Z) {
            this.bottomBar = this.bottomBar + this.frameDelta * this.topBarSpeed;
            this.iB = true;
            if (this.bottomBar > this.bottomBarTarget) {
               this.bottomBar = this.bottomBarTarget;
            }
         }

         if (this.topBar > this.topBarTarget && !this.Y) {
            this.iB = true;
            this.topBar = this.topBar - this.frameDelta * this.topBarSpeed;
            if (this.topBar <= this.topBarTarget) {
               this.topBar = this.topBarTarget;
            }

            this.ak = true;
         }

         if (this.bottomBar > this.bottomBarTarget && !this.Z) {
            this.iB = true;
            this.bottomBar = this.bottomBar - this.frameDelta * this.bottomBarSpeed;
            if (this.bottomBar < this.bottomBarTarget) {
               this.bottomBar = this.bottomBarTarget;
            }
         }
      }
   }

   // $VF: renamed from: a (int, int, int, short[], boolean) void
   private void getBoxesAt(int var1, int var2, int var3, short[] var4, boolean var5) {
      for (int var6 = 0; var6 < var4.length; var6++) {
         var4[var6] = 0;
      }

      this.getFrameBoxes(var4, var3, var5 ? 0 : 2);

      for (int var7 = 0; var7 < var4.length; var7 += 5) {
         var4[var7] = (short)(var4[var7] + var1);
         var4[var7 + 1] = (short)(var4[var7 + 1] + var2);
      }
   }

   // $VF: renamed from: n () void
   private void runBootStep() {
      switch (this.bootStep) {
         case 0:
            this.ensureAnimSlots(138);
            this.screenWidth = 240;
            this.screenHeight = 320;
            halfWidth = this.screenWidth >> 1;
            halfHeight = this.screenHeight >> 1;
            this.loadStringTable(10240);
            byte[] var1;
            R = new int[(var1 = this.getResourceBytes(1053)).length / 3];
            int var2 = 0;

            for (int var5 = 0; var5 < var1.length; var5 += 3) {
               R[var2] = var1[var5] << 18 | var1[var5 + 1] << 10 | var1[var5 + 2] << 2;
               var2++;
            }

            random = new Random();
            this.loadMenuSprites(true);
            this.iS = this.loadSprites(1037);
            this.cp = this.loadSprites(1035);
            this.loadAnimSet(1024);
            this.setAnimSetPersistent(1024, true);
            this.cq = this.loadSprites(1030);
            this.fu = this.loadSprites(1038);
            this.loadAnimSet(1026);
            this.setAnimSetPersistent(1026, true);
            break;
         case 1:
            this.mainFont = this.loadSprites(1031);
            this.setFont(this.mainFont);
            lineHeight = this.fontHeight();
            halfLineHeight = lineHeight >> 1;
            this.iJ = this.stringWidth("W") * 4;
            this.fx = this.loadSprites(1034);

            for (int var3 = 0; var3 < 5; var3++) {
               this.updateFireEffect();
            }
         case 2:
         case 6:
         case 9:
         case 10:
         case 11:
         default:
            break;
         case 3:
            this.loadAnimSet(1025);
            this.setAnimSetPersistent(1025, true);
            aL = this.loadSprites(1036);
            this.loadAnimSet(1027);
            this.setAnimSetPersistent(1027, true);
            this.aU = this.loadSprites(1040);
            bo = this.loadSprites(1029);
            this.loadMenuTable();
            break;
         case 4:
            this.soundPlayer.load(0, 1063, -1, 0);
            this.soundPlayer.load(1, 1064, 1, 0);
            this.soundPlayer.load(2, 1062, 1, 0);
            break;
         case 5:
            this.loadAnimSet(2048);
            this.setAnimSetPersistent(2048, true);
            this.loadAnimSet(2049);
            this.loadAnimSet(2050);
            this.setAnimSetPersistent(2049, true);
            this.setAnimSetPersistent(2050, true);
            break;
         case 7:
            this.loadAnimSet(3074);
            this.setAnimSetPersistent(3074, true);
            this.loadAnimSet(3072);
            this.setAnimSetPersistent(3072, true);
            this.loadAnimSet(3073);
            this.setAnimSetPersistent(3073, true);
            this.loadAnimSet(5122);
            this.setAnimSetPersistent(5122, true);
            break;
         case 8:
            this.loadAnimSet(5121);
            this.setAnimSetPersistent(5121, true);
            this.loadAnimSet(6145);
            this.setAnimSetPersistent(6145, true);
            this.loadAnimSet(6144);
            this.setAnimSetPersistent(6144, true);
            this.loadAnimSet(5120);
            this.setAnimSetPersistent(5120, true);
            this.loadAnimSet(28672);
            this.setAnimSetPersistent(28672, true);
            this.loadAnimSet(7168);
            this.setAnimSetPersistent(7168, true);
            break;
         case 12:
            menuTable[5] = (menuTable[5] & -256) + 68;
            menuTable[5] = menuTable[5] & -50331649;
            menuTable[6] = menuTable[6] & -50331649;
            break;
         case 13:
            this.requestClear();
            if (!iU) {
               iT = true;
               this.iS = this.loadSprites(8193);
               this.loadAnimSet(8192);
               this.startAnim(0, 8192, 0);
               iU = true;
            } else {
               iU = this.stepAnim(0, super.frameTime);
               if (!iU) {
                  this.M = 0;
               }
            }

            this.requestClear();
      }

      if (!iU && this.bootStep <= 13) {
         this.bootStep++;
      }

      for (int var4 = 0; var4 < 6 && !iU; var4++) {
         this.updateFireEffect();
      }
   }

   // $VF: renamed from: b (boolean) void
   private void loadMenuSprites(boolean var1) {
      if (var1) {
         this.menuSprites = this.loadSprites(1039);
         this.menuFont = this.loadSprites(1032);
         this.titleFont = this.loadSprites(1033);
         this.iI = false;
         this.iC = true;
         this.iu = this.menuSprites[3].width;
         this.releaseTransientAnimSets();
         this.levelIndex = this.furthestLevel;
         this.parseBank(null);
      } else {
         this.startAnim(132, 1027, 10);
         this.menuSprites = null;
         this.menuFont = null;
         this.titleFont = null;
      }
   }

   // $VF: renamed from: o () void
   private void updateCamera() {
      int var1 = this.frameDelta << 8;
      int var2;
      int var3;
      if (this.cameraPanX > 0) {
         var2 = this.cameraPanX;
         var3 = this.cameraPanY;
      } else {
         var2 = this.playerX;
         var3 = this.playerY;
      }

      int var10000 = (facingRight && this.cameraPanX < 0 ? 1 : -1) * (playerAnim != 109 && playerAnim != 110 ? 240 : -240) >> 2;
      int var4 = 0;
      var4 = var10000 - (this.climbing ? (facingRight ? this.screenWidth >> 2 : -(this.screenWidth >> 2)) : 0);
      if (playerAnim == 116) {
         var4 = 0;
      }

      int var5 = this.climbing ? 80 : 0;
      int var6 = var2 - 120 + var4;
      int var7 = var3 - 266 + var5;
      int var8 = (var6 - cameraX + this.aI) * this.frameDelta;
      int var9 = (var7 - cameraY + this.aJ) * this.frameDelta;
      if (Math.abs(var8) > var1) {
         if (var8 > 0) {
            var8 = var1;
         } else {
            var8 = -var1;
         }
      }

      if (Math.abs(var9) > var1) {
         if (var9 > 0) {
            var9 = var1;
         } else {
            var9 = -var1;
         }
      }

      this.aO += var8;
      this.aP += var9;
      var6 = this.aO >> 8;
      var7 = this.aP >> 8;
      this.aM = cameraX - var6;
      this.aN = cameraY - var7;
      cameraX = var6;
      cameraY = var7;
      boolean var10 = false;
      boolean var11 = false;
      if (this.cameraPanX < 0) {
         for (int var12 = this.lockRectCount - 1; var12 >= 0; var12--) {
            if (pointInRect(this.lockX[var12], this.lockY[var12], cameraX, cameraY, 240, 320)) {
               if (!this.lockVertical[var12]) {
                  var10 = true;
                  int var13 = this.aK * this.frameDelta >> 8;
                  if (this.lockReverse[var12]) {
                     this.aI -= var13;
                  } else {
                     this.aI += var13;
                  }

                  if (!pointInRect(this.lockX[var12], this.lockY[var12], cameraX + this.aI, cameraY + this.aJ, 240, 320)) {
                     this.aI = this.lockX[var12] - cameraX - (this.lockReverse[var12] ? 240 : 0);
                  }
               } else {
                  var11 = true;
                  int var18 = this.aK * this.frameDelta >> 8;
                  if (this.lockReverse[var12]) {
                     this.aJ -= var18;
                  } else {
                     this.aJ += var18;
                  }

                  if (!pointInRect(this.lockX[var12], this.lockY[var12], cameraX + this.aI, cameraY + this.aJ, 240, 320)) {
                     this.aJ = this.lockY[var12] - cameraY - (this.lockReverse[var12] ? 320 : 0);
                  }
               }
            }
         }

         for (int var17 = this.breakLast; var17 >= 0; var17--) {
            if (breakStopsCamera[var17]
               && pointInRect(breakX[var17] + (breakCameraRight[var17] ? breakWidth[var17] : 0), this.breakY[var17], cameraX, cameraY, 240, 320)) {
               var10 = true;
               int var19 = this.aK * this.frameDelta >> 8;
               if (breakCameraRight[var17]) {
                  this.aI -= var19;
               } else {
                  this.aI += var19;
               }

               if (!pointInRect(
                  breakX[var17] + (breakCameraRight[var17] ? breakWidth[var17] : 0), this.breakY[var17], cameraX + this.aI, cameraY + this.aJ, 240, 320
               )) {
                  this.aI = breakX[var17] + (breakCameraRight[var17] ? breakWidth[var17] : 0) - cameraX - (breakCameraRight[var17] ? 240 : 0);
               }
            }
         }

         cameraX = cameraX + this.aI;
         cameraY = cameraY + this.aJ;
         if (!var10 && this.aI != 0) {
            if (this.aI > 0) {
               this.aI = this.aI - (this.aK * this.frameDelta >> 8);
               if (this.aI < 0) {
                  this.aI = 0;
               }
            } else {
               this.aI = this.aI + (this.aK * this.frameDelta >> 8);
               if (this.aI > 0) {
                  this.aI = 0;
               }
            }
         }

         if (!var11 && this.aJ != 0) {
            if (this.aJ > 0) {
               this.aJ = this.aJ - (this.aK * this.frameDelta >> 8);
               if (this.aJ < 0) {
                  this.aJ = 0;
               }
            } else {
               this.aJ = this.aJ + (this.aK * this.frameDelta >> 8);
               if (this.aJ > 0) {
                  this.aJ = 0;
               }
            }
         }

         this.aM = this.aM - this.aI;
         this.aN = this.aN - this.aJ;
         if (this.cameraShake != 0) {
            if (this.shakeTimer + this.shakeTimer * this.slowMotionShift >= this.shakeDuration) {
               cameraY = cameraY + this.cameraShake;
               cameraX = cameraX + this.cameraShake * ((this.randomValue & 1) == 1 ? -1 : 1);
               this.cameraShake = this.cameraShake + (this.cameraShake < 0 ? 1 : -1);
               this.cameraShake = -this.cameraShake;
               this.shakeTimer = 0;
            } else {
               this.shakeTimer = this.shakeTimer + this.frameDelta;
            }
         } else {
            this.shakeDuration = 0;
         }
      } else if (var8 != 0 && this.cameraPanTimer <= 3500) {
         this.cameraPanTimer = this.cameraPanTimer + this.frameDelta;
      } else {
         this.cameraPanX = -1;
         this.cameraPanY = -1;
         this.iB = true;
         this.cameraPanTimer = 0;
      }

      if (cameraX < 0) {
         cameraX = 0;
         this.aO = 0;
         this.aM = 0;
      }

      if (cameraX >= this.maxCameraX) {
         cameraX = this.maxCameraX;
         this.aO = this.maxCameraX << 8;
         this.aM = 0;
      }

      if (cameraY < 0) {
         cameraY = 0;
         this.aP = 0;
         this.aN = 0;
      }

      if (cameraY >= this.maxCameraY) {
         cameraY = this.maxCameraY;
         this.aP = this.maxCameraY << 8;
         this.aN = 0;
      }
   }

   // $VF: renamed from: p () void
   private void startDialogueLine() {
      this.ip = false;
      this.aQ[0] = -1;
      this.aQ[1] = this.cs;
      panelText = new String[3];
      panelText[0] = "";
      panelText[1] = this.getString(this.aQ[1]);
      this.setFont(this.mainFont);
      if (panelText[1].charAt(0) == '!') {
         state = 105;
         this.bc = true;
         this.setPlayerAction(this.aY[this.ba]);
         if (this.dL != -1) {
            this.setEnemyAction(this.aZ[this.bb], this.dL);
            return;
         }
      } else {
         if (panelText[1].charAt(0) == '^') {
            this.cr = Engine.parseIntOr(panelText[1].substring(1, 2), 0);
            if (this.cr > 3) {
               int var1 = this.cr - 3 - 1;
               this.weaponMode = var1;
               magicModeA = this.weaponMode == 1;
               magicModeB = this.weaponMode == 2;
               this.magicModeC = this.weaponMode == 3;
            }
         } else {
            this.cr = -1;
         }

         panelText[1].charAt(0);
         if (panelText[1].charAt(0) == '*') {
            if (panelText[1].length() != 1) {
               this.aW = true;
               this.setBarTargets(halfHeight, halfHeight, 35, 35);
            } else {
               this.be = true;
            }

            this.iC = true;
            return;
         }

         this.aW = false;
         this.a(this.aQ, aV, 8, 0, 211, lineHeight * 5 + halfLineHeight, 30);
      }
   }

   // $VF: renamed from: q () void
   private void updateUpgradeScreen() {
      if (this.bk <= 0 && !this.bi) {
         switch (this.pressedKey) {
            case 1:
            case 2:
               upgradeSelection++;
               if (upgradeSelection > bh) {
                  upgradeSelection = 0;
               }
               break;
            case 5:
            case 6:
               upgradeSelection--;
               if (upgradeSelection < 0) {
                  upgradeSelection = bh;
               }
               break;
            case 29:
            case 35:
               if (!this.au) {
                  state = 100;
               } else {
                  this.au = false;
                  state = 1;
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
               }

               this.iB = true;
         }

         switch (this.heldKey) {
            case 8:
               if (this.upgradePoints > 0 && this.upgradePoints >= this.bg) {
                  if (this.bg < 16) {
                     this.bg++;
                  }
               } else if (this.upgradePoints < this.bg) {
                  this.bg = this.upgradePoints;
               } else if (this.upgradePoints <= 0) {
                  this.bg = 0;
               }
            case 27:
               if (this.upgradePoints > 100) {
                  this.bg = 100;
               } else {
                  this.bg = this.upgradePoints;
               }

               switch (upgradeSelection) {
                  case 0:
                     if (bladesLevel <= 3) {
                        this.upgradeProgressA = this.upgradeProgressA + this.bg;
                        if (this.upgradeProgressA >= bladesCosts[bladesLevel]) {
                           this.bg = bladesCosts[bladesLevel] - (this.upgradeProgressA - this.bg);
                           if (bladesLevel == 0 || bladesLevel == 1 || bladesLevel == 2) {
                              bladesComboLength++;
                           }

                           this.upgradeProgressA = 0;
                           bladesLevel++;
                           this.bk = 2500;
                        }
                     } else {
                        this.bg = 0;
                     }
                     break;
                  case 1:
                     if (magicALevel <= 3) {
                        this.upgradeProgressB = this.upgradeProgressB + this.bg;
                        if (this.upgradeProgressB < magicACosts[magicALevel]) {
                           break;
                        }

                        this.bg = magicACosts[magicALevel] - (this.upgradeProgressB - this.bg);
                        if (magicALevel == 0 || magicALevel == 1 || magicALevel == 3) {
                           this.magicAComboLength++;
                        }

                        this.upgradeProgressB = 0;
                        magicALevel++;
                        this.bk = 2500;
                        break;
                     }

                     this.bg = 0;
                     break;
                  case 2:
                     if (magicBLevel < 4) {
                        this.upgradeProgressC = this.upgradeProgressC + this.bg;
                        if (this.upgradeProgressC >= magicBCosts[magicBLevel]) {
                           this.bg = magicBCosts[magicBLevel] - (this.upgradeProgressC - this.bg);
                           this.upgradeProgressC = 0;
                           magicBLevel++;
                           this.bk = 2500;
                        }
                     } else {
                        this.bg = 0;
                     }
                     break;
                  case 3:
                     if (magicCLevel < 4) {
                        this.upgradeProgressD = this.upgradeProgressD + this.bg;
                        if (this.upgradeProgressD >= magicCCosts[magicCLevel]) {
                           this.bg = magicCCosts[magicCLevel] - (this.upgradeProgressD - this.bg);
                           this.upgradeProgressD = 0;
                           magicCLevel++;
                           this.bk = 2500;
                        }
                     } else {
                        this.bg = 0;
                     }
               }

               this.upgradePoints = this.upgradePoints - this.bg;
               if (this.upgradePoints < 0) {
                  this.upgradePoints = 0;
               }
               break;
            default:
               this.bg = 0;
         }
      } else {
         this.bk = this.bk - this.frameDelta;
      }

      if (this.cheatsEnabled) {
         if (this.heldKey == 57) {
            this.upgradePoints += 20;
            return;
         }

         if (this.heldKey == 55) {
            this.upgradePoints -= 20;
            if (this.upgradePoints < 0) {
               this.upgradePoints = 0;
            }
         }
      }
   }

   // $VF: renamed from: r () void
   private void updateDialogue() {
      if (this.topBar >= this.topBarTarget && this.ip) {
         switch (this.pressedKey) {
            case 1:
            case 2:
               if (this.il >= 5) {
                  this.bd = 0;
                  this.il -= 5;
                  return;
               }

               if (this.cs > this.ct) {
                  this.cs--;
                  this.bd = 0;
                  this.startDialogueLine();
                  return;
               }
               break;
            case 5:
            case 6:
            case 8:
            case 27:
               if (this.im > 0) {
                  this.bd = 0;
                  this.il = this.im;
                  return;
               }

               if ((this.cr <= 3 || this.pressedKey != 27) && this.cr > 3) {
                  break;
               }

               this.bd = 0;
               this.il = -1;
               this.im = -1;
               this.cs++;
               if (this.cs >= this.cu) {
                  if (!this.be) {
                     state = 100;
                     this.setBarTargets(0, 0, 35, 35);
                     this.iB = true;
                     this.aW = false;
                     this.cu = -1;
                     this.cs = -1;
                     this.ct = -1;
                     return;
                  }

                  this.requestClear();
                  this.levelIndex++;
                  if (this.levelIndex > this.furthestLevel && (this.demoMode <= 0 || this.levelIndex < this.demoMode)) {
                     this.furthestLevel = this.levelIndex;
                  }

                  this.levelResourceId = levelIds[this.levelIndex];
                  this.resetLevelState();
                  this.iC = true;
                  this.iS = null;
                  this.bf = true;
                  state = 1;
                  this.levelLoadStarted = false;
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
                  return;
               }

               this.startDialogueLine();
               return;
            case 29:
               if (this.topBar == this.topBarTarget) {
                  this.af = this.topBarTarget >> 8;
                  this.ag = this.bottomBarTarget >> 8;
                  this.J = state;
                  state = 102;
                  pauseMenuIndex = 4;
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
               }
         }
      }
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void render(Graphics var1) {
      switch (state) {
         case 0:
            this.u(var1);
            if (!iU && this.bootStep <= 13) {
               drawProgressBar(var1, this.bootStep, 13, true);
               return;
            }
            break;
         case 1:
         case 80:
         case 109:
            if (!this.bf && state != 1) {
               this.drawMenu(var1);
            }

            this.drawBars(var1);
            if (state == 109 && this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget && !this.W) {
               if (this.levelIndex >= this.demoMode && this.demoMode != 0) {
                  this.drawBottomBar(var1, -1, 197);
                  return;
               }

               this.drawBottomBar(var1, 28, 29);
               return;
            }
            break;
         case 78:
            this.v(var1);
            this.menuSprites[0].draw(var1, halfWidth, 0, 0);
            this.menuSprites[1].draw(var1, halfWidth, 0, 0);
            int var2 = (lineHeight << 2) + lineHeight;

            for (int var3 = 0; var3 <= 5; var3++) {
               this.drawString(var1, this.getString(languageNameStrings[var3]), halfWidth, var2, 1);
               if (var3 == languageIndex) {
                  bo[2].draw(var1, (halfWidth >> 1) - bo[2].width, var2 + (lineHeight >> 2), 0);
                  bo[3].draw(var1, this.screenWidth - (halfWidth >> 1), var2 + (lineHeight >> 2), 0);
               }

               var2 = var2 + lineHeight + (lineHeight >> 2);
            }

            if (this.topBarTarget != halfHeight << 8) {
               this.drawBottomBar(var1, 0, 1);
               return;
            }

            this.resetClip(var1);
            return;
         case 79:
            this.v(var1);
            this.menuSprites[0].draw(var1, halfWidth, 0, 0);
            this.menuSprites[1].draw(var1, halfWidth, 0, 0);
            this.drawDialogueText(var1, false);
            this.drawBars(var1);
            if (this.topBarTarget != halfHeight << 8) {
               this.drawBottomBar(var1, 28, 29);
               return;
            }

            this.resetClip(var1);
            return;
         case 100:
         case 101:
         case 102:
         case 104:
         case 105:
         case 108:
            if (state == 100 && this.topBar <= 0 && !this.iB) {
               this.setClip(var1, 0, 0, 240, 306);
            } else {
               this.iB = true;
               this.resetClip(var1);
            }

            this.drawWorld(var1);
            if (state != 101) {
               this.drawHud(var1);
            }

            if (state == 100) {
               if (this.aR
                  && this.aS == facingRight
                  && !qteActive
                  && pointInRect(this.playerX, this.playerY, cameraX, cameraY, this.screenWidth, this.screenHeight)) {
                  this.drawFrame(var1, this.aU, 131, 12, this.screenHeight - 25, 0);
               }

               if (qteActive && this.qteProgress >= 0 && this.qteProgress < this.qteRequired && this.grappledEnemy >= 0) {
                  this.drawFrame(
                     var1,
                     this.aU,
                     131,
                     enemyX[this.grappledEnemy] - cameraX,
                     this.enemyY[this.grappledEnemy] - this.enemyHeight[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 2) - cameraY,
                     0
                  );
               }
            }

            if (state == 104) {
               var1.setColor(855564);
               var1.fillRect(halfWidth >> 3, halfHeight - (halfHeight >> 1), this.screenWidth - (halfWidth >> 2), halfHeight + lineHeight);
               var1.setColor(4269080);
               var1.drawRect((halfWidth >> 3) - 1, halfHeight - (halfHeight >> 1) - 1, this.screenWidth - (halfWidth >> 2) + 1, halfHeight + lineHeight + 1);
               var1.setColor(5911589);
               var1.drawRect((halfWidth >> 3) - 2, halfHeight - (halfHeight >> 1) - 2, this.screenWidth - (halfWidth >> 2) + 3, halfHeight + lineHeight + 3);
               this.cq[0].draw(var1, (halfWidth >> 3) - 3, halfHeight - (halfHeight >> 1) - 2, 0);
               this.cq[0].draw(var1, this.screenWidth - (halfWidth >> 3) + 3, halfHeight - (halfHeight >> 1) - 2, 2);
               this.cq[0].draw(var1, (halfWidth >> 3) - 3, halfHeight + (halfHeight >> 1) + 2 + lineHeight, 1);
               this.cq[0].draw(var1, this.screenWidth - (halfWidth >> 3) + 3, halfHeight + (halfHeight >> 1) + 2 + lineHeight, 3);
               this.drawFrame(var1, this.fu, 136, halfWidth, halfHeight - (lineHeight << 1), 0);
               if (this.chestPopupKind == 9) {
                  this.drawString(var1, this.getString(148), halfWidth, halfHeight + lineHeight, 1);
                  if (this.chestPopupTimer < 96) {
                     this.drawString(var1, this.getString(189), halfWidth, halfHeight + (lineHeight << 1) + lineHeight, 1);
                  } else {
                     this.drawString(var1, this.getString(151), halfWidth, halfHeight + (lineHeight << 1) + lineHeight, 1);
                  }
               } else {
                  this.drawString(var1, this.getString(147), halfWidth, halfHeight + lineHeight, 1);
                  if (this.chestPopupTimer < 96) {
                     this.drawString(var1, this.getString(158), halfWidth, halfHeight + (lineHeight << 1) + lineHeight, 1);
                  } else {
                     this.drawString(var1, this.getString(151), halfWidth, halfHeight + (lineHeight << 1) + lineHeight, 1);
                  }
               }
            }

            this.drawBars(var1);
            if (state == 101 && this.topBar >= this.topBarTarget && !this.aW) {
               this.drawDialogueText(var1, false);
            }

            switch (state) {
               case 100:
                  if (this.iB) {
                     this.drawBottomBar(var1, 160, 197);
                     return;
                  }

                  return;
               case 101:
                  if (this.ip) {
                     this.drawBottomBar(var1, 174, 197);
                     return;
                  }

                  this.drawBottomBar(var1, -1, -1);
                  return;
               case 102:
                  if (this.topBar == this.topBarTarget && !this.W) {
                     if ((pauseMenuIndex == 1 || pauseMenuIndex == 2) && this.pauseConfirming) {
                        this.drawBottomBar(var1, 28, 29);
                        return;
                     }

                     if (pauseMenuIndex == 4 && pauseMenuIndex != 3) {
                        this.drawBottomBar(var1, 200, 199);
                        return;
                     }

                     this.drawBottomBar(var1, 0, 199);
                     return;
                  }

                  return;
               case 103:
               default:
                  return;
               case 104:
                  return;
               case 105:
                  this.drawBottomBar(var1, -1, 197);
                  return;
            }
         case 106:
            this.drawUpgradeScreen(var1);
            this.drawBars(var1);
            if (this.bk <= 0) {
               if (this.upgradePoints > 0) {
                  this.drawBottomBar(var1, !this.bi ? (this.bn <= 3 ? 149 : -1) : -1, !this.bi ? (this.au ? 174 : 2) : -1);
                  return;
               }

               this.drawBottomBar(var1, -1, !this.bi ? (this.au ? 174 : 2) : -1);
               return;
            }

            this.drawBottomBar(var1, -1, -1);
            return;
         case 107:
            if (super.bordersCleared) {
               this.v(var1);
               this.drawDialogueText(var1, true);
            }

            this.drawBars(var1);
            if (state == 107 && this.topBar <= 6400) {
               if (!this.aW) {
                  this.drawBottomBar(var1, -1, 2);
                  return;
               }

               this.drawBottomBar(var1, -1, 240);
               return;
            }
      }
   }

   // $VF: renamed from: c (javax.microedition.lcdui.Graphics) void
   private void drawBars(Graphics var1) {
      int var2 = this.topBar >> 8;
      int var3 = this.bottomBar >> 8;
      if (var2 > 0) {
         if ((!this.W || this.X || this.pendingMainMenu || this.pendingHelp || this.ap || this.pendingQuit)
            && (state == 108 || state == 102 || state == 1 || state == 109)) {
            var1.setColor(0);
            var1.fillRect(0, var2 + 1, 240, 320 - (var3 << 1) - 1);
            if (state == 108) {
               if (!challengeMode) {
                  this.drawString(var1, this.getString(173), halfWidth, halfHeight + halfLineHeight + (lineHeight >> 3), 33);
               } else {
                  this.drawString(var1, this.getString(173), halfWidth, halfHeight - (lineHeight << 1) + (lineHeight >> 1), 33);
                  this.drawString(var1, this.getString(206), halfWidth, halfHeight - (lineHeight >> 2) + (lineHeight >> 1), 33);
                  this.drawString(var1, String.valueOf(this.killCount), halfWidth, halfHeight + lineHeight + (lineHeight >> 2), 33);
                  if (this.killCount > this.bestKillCount) {
                     this.drawString(var1, this.getString(207), halfWidth, halfHeight + (lineHeight << 1) + (lineHeight >> 1), 33);
                  } else {
                     this.drawString(
                        var1, this.getString(208) + String.valueOf(this.bestKillCount), halfWidth, halfHeight + (lineHeight << 1) + (lineHeight >> 1), 33
                     );
                  }
               }
            } else if (state == 102) {
               this.drawString(var1, !challengeMode ? this.getString(54 + this.levelIndex) : this.getString(66), halfWidth, halfHeight - (lineHeight >> 1), 33);
               if (pauseMenuIndex == 4) {
                  this.drawString(
                     var1,
                     this.getString(47) + " " + (this.soundPlayer.isSoundOn() ? this.getString(234) : this.getString(235)),
                     halfWidth,
                     halfHeight + lineHeight + halfLineHeight,
                     33
                  );
                  bo[3].draw(var1, this.screenWidth - 5 - 7, halfHeight + (lineHeight >> 1) + 4, 0);
               } else if (pauseMenuIndex == 2 && !this.pauseConfirming) {
                  this.drawString(var1, this.getString(50), halfWidth, halfHeight + lineHeight + halfLineHeight, 33);
                  bo[2].draw(var1, 12 - bo[2].width, halfHeight + (lineHeight >> 1) + 4, 0);
                  bo[3].draw(var1, this.screenWidth - 5 - 7, halfHeight + (lineHeight >> 1) + 4, 0);
               } else if (pauseMenuIndex == 2 && this.pauseConfirming) {
                  this.drawString(var1, this.getString(186), halfWidth, halfHeight + lineHeight + halfLineHeight, 33);
               } else if (pauseMenuIndex == 1 && !this.pauseConfirming) {
                  this.drawString(var1, this.getString(1), halfWidth, halfHeight + lineHeight + halfLineHeight, 33);
                  bo[2].draw(var1, 12 - bo[2].width, halfHeight + (lineHeight >> 1) + 4, 0);
               } else if (pauseMenuIndex == 1 && this.pauseConfirming) {
                  this.drawString(var1, this.getString(185), halfWidth, halfHeight + lineHeight + halfLineHeight, 33);
               } else if (pauseMenuIndex == 3) {
                  this.drawString(var1, this.getString(46), halfWidth, halfHeight + lineHeight + halfLineHeight, 33);
                  bo[3].draw(var1, this.screenWidth - 5 - 7, halfHeight + (lineHeight >> 1) + 4, 0);
                  bo[2].draw(var1, 12 - bo[2].width, halfHeight + (lineHeight >> 1) + 4, 0);
               }
            } else if (state == 1) {
               this.setFont(this.mainFont);
               if (challengeMode) {
                  this.drawString(var1, this.getString(66), halfWidth, halfHeight - lineHeight - (lineHeight >> 1), 33);
                  this.drawString(var1, this.getString(190), halfWidth, halfHeight - (lineHeight >> 1), 33);
                  this.drawString(var1, this.getString(238), halfWidth, halfHeight + (lineHeight >> 1), 33);
                  this.drawString(var1, this.getString(39), halfWidth, halfHeight + lineHeight + (lineHeight >> 1) + (lineHeight >> 2), 33);
                  drawProgressBar(var1, this.levelLoadStep, 11, true);
               } else {
                  this.drawString(var1, this.getString(54 + this.levelIndex), halfWidth, halfHeight - halfLineHeight, 33);
                  this.drawString(var1, this.getString(39), halfWidth, halfHeight + halfLineHeight, 33);
                  drawProgressBar(var1, this.levelLoadStep, 11, true);
               }
            } else if (state == 109) {
               if (this.levelIndex >= this.demoMode && this.demoMode != 0) {
                  this.drawString(var1, this.getString(279), halfWidth, halfHeight, 33);
                  this.drawString(var1, this.getString(280), halfWidth, halfHeight + lineHeight, 33);
                  byte var4 = 0;

                  for (int var5 = halfHeight + lineHeight + (lineHeight << 1) + 4; var4 < this.demoBuyUrl.length(); var5 += lineHeight) {
                     this.drawString(
                        var1, this.demoBuyUrl.substring(var4, var4 + 18 < this.demoBuyUrl.length() ? var4 + 18 : this.demoBuyUrl.length()), halfWidth, var5, 33
                     );
                     var4 += 18;
                  }
               } else {
                  this.drawString(var1, this.getString(54 + this.levelIndex - 1) + this.getString(169), halfWidth, halfHeight, 33);
                  this.drawString(
                     var1, this.getString(168) + this.getString(54 + this.levelIndex) + this.getString(159), halfWidth, halfHeight + lineHeight, 33
                  );
               }
            }
         }

         var1.setColor(855564);
         var1.fillRect(0, 0, 240, var2);
         var1.setColor(4269080);
         var1.drawLine(0, var2 - 1, 240, var2 - 1);
         var1.setColor(5911589);
         var1.drawLine(0, var2, 240, var2);
         var1.setColor(4269080);
         var1.drawLine(0, var2 - 1, 240, var2 - 1);
         var1.setColor(855564);
         var1.fillRect(0, 320 - var3, 240, var3);
         var1.setColor(10246204);
         var1.drawLine(0, 320 - var3, 240, 320 - var3);
         var1.setColor(4269080);
         var1.drawLine(0, 320 - var3 + 1, 240, 320 - var3 + 1);
         if (!this.W && state == 108) {
            this.drawBottomBar(var1, challengeMode ? -1 : 198, 45);
         }

         this.cq[0].draw(var1, 0, var2, 1);
         this.cq[0].draw(var1, 240, var2, 3);
         this.cq[0].draw(var1, 0, 320 - (var3 - 1), 0);
         this.cq[0].draw(var1, 240, 320 - (var3 - 1), 2);
         if (this.levelIndex >= this.demoMode && this.demoMode != 0 && state == 109 && this.topBar == this.topBarTarget && !this.W) {
            byte var6 = 0;

            for (int var7 = halfHeight + lineHeight + (lineHeight << 1) + 4; var6 < this.demoBuyUrl.length(); var7 += lineHeight) {
               this.drawString(
                  var1, this.demoBuyUrl.substring(var6, var6 + 18 < this.demoBuyUrl.length() ? var6 + 18 : this.demoBuyUrl.length()), halfWidth, var7, 33
               );
               var6 += 18;
            }
         }
      }

      if (state == 80 && this.topBar == 0) {
         switch (this.iG) {
            case 0:
               this.drawBottomBar(var1, 0, 1);
               return;
            case 9:
               if (this.furthestLevel >= menuCursor - this.iG + 1) {
                  this.drawBottomBar(var1, 196, 2);
                  return;
               }

               this.drawBottomBar(var1, 120, 2);
               return;
            case 23:
               this.drawBottomBar(var1, 28, 29);
               return;
            case 30:
               this.drawBottomBar(var1, 28, 29);
               return;
            default:
               this.drawBottomBar(var1, 0, 2);
         }
      }
   }

   // $VF: renamed from: d (javax.microedition.lcdui.Graphics) void
   private void drawWorld(Graphics var1) {
      this.scene.draw(var1);
      var1.translate(-cameraX, -(cameraY + this.bl));
      this.drawScenery36(var1);
      this.drawHazards(var1);
      this.drawHealthProps(var1);
      this.drawSwitches(var1);
      this.drawBoxedProps(var1);
      this.drawGates(var1);
      this.drawPushables(var1);
      this.drawBreakables(var1);
      this.drawChests(var1);
      if (this.grappledEnemy >= 0 && !qteActive && playerAnim != 109 && playerAnim != 113 && this.enemyClass[this.grappledEnemy] != 2) {
         this.drawPlayer(var1);
         this.drawEnemies(var1);
      } else {
         this.drawEnemies(var1);
         this.drawPlayer(var1);
      }

      this.drawPickups(var1);
      this.drawEffects(var1);
      this.drawScenery17(var1);
      var1.translate(cameraX, cameraY + this.bl);
   }

   // $VF: renamed from: e (javax.microedition.lcdui.Graphics) void
   private void drawUpgradeScreen(Graphics var1) {
      this.v(var1);
      this.setFont(this.mainFont);
      this.drawString(var1, this.getString(149), 120, lineHeight, 1);
      bm = String.valueOf(this.upgradePoints) + " ~";
      this.drawString(var1, bm, 132, 44, 8);
      bm = this.getString(116 + upgradeSelection);
      bo[0].draw(var1, 120, 78 - bo[0].height, 0);
      if (bm.indexOf(10) != -1) {
         this.drawString(var1, bm.substring(0, bm.indexOf(10)), 120, 80, 1);
         this.drawString(var1, bm.substring(bm.indexOf(10) + 1, bm.length()), 120, 80 + lineHeight, 1);
      } else {
         this.drawString(var1, this.getString(116 + upgradeSelection), 120, 80, 1);
      }

      int var2 = 0;
      if (upgradeSelection == 0) {
         this.bn = bladesLevel;
         if (bladesLevel <= 3) {
            var2 = bladesCosts[this.bn] - this.upgradeProgressA;
         }
      } else if (upgradeSelection == 1) {
         this.bn = magicALevel;
         if (magicALevel <= 3) {
            var2 = magicACosts[this.bn] - this.upgradeProgressB;
         }
      } else if (upgradeSelection == 3) {
         this.bn = magicCLevel;
         if (magicCLevel <= 3) {
            var2 = magicCCosts[this.bn] - this.upgradeProgressD;
         }
      } else {
         this.bn = magicBLevel;
         if (magicBLevel <= 3) {
            var2 = magicBCosts[this.bn] - this.upgradeProgressC;
         }
      }

      if (this.bn <= 3) {
         this.drawString(var1, this.getString(223) + String.valueOf(this.bn + 1), 120, 80 + (lineHeight << 1), 1);
         this.drawString(var1, String.valueOf(var2) + "~", 132, 120 + (lineHeight << 1), 8);
         this.drawString(var1, this.getString(224), 120, 120 + (lineHeight << 1) + lineHeight, 1);
         this.drawString(var1, this.getString(225), 120, 120 + (lineHeight << 2), 1);
      } else {
         this.drawString(var1, this.getString(241), 120, 80 + (lineHeight << 1), 1);
      }

      bo[1].draw(var1, 120, 80 + (lineHeight << 1) + lineHeight, 0);
      if (this.bk > 0) {
         var1.setColor(855564);
         var1.fillRect(halfWidth - (halfWidth >> 1), halfHeight - (halfHeight >> 2), halfWidth, (halfHeight >> 1) + lineHeight);
         var1.setColor(4269080);
         var1.drawRect(halfWidth - (halfWidth >> 1) - 1, halfHeight - (halfHeight >> 2) - 1, halfWidth + 1, (halfHeight >> 1) + 1 + lineHeight);
         var1.setColor(5911589);
         var1.drawRect(halfWidth - (halfWidth >> 1) - 2, halfHeight - (halfHeight >> 2) - 2, halfWidth + 3, (halfHeight >> 1) + 3 + lineHeight);
         if (bm.indexOf(10) != -1) {
            this.drawString(var1, bm.substring(0, bm.indexOf(10)), halfWidth, halfHeight - lineHeight - (lineHeight >> 1), 1);
            this.drawString(var1, bm.substring(bm.indexOf(10) + 1, bm.length()), halfWidth, halfHeight - (lineHeight >> 1), 1);
         } else {
            this.drawString(var1, this.getString(116 + upgradeSelection), halfWidth, halfHeight - (halfHeight >> 2), 1);
         }

         this.drawString(var1, this.getString(222), halfWidth, halfHeight + lineHeight, 1);
      }
   }

   // $VF: renamed from: f (javax.microedition.lcdui.Graphics) void
   private void drawHud(Graphics var1) {
      this.drawFrame(var1, aL, 133, 0, 0, 0);
      int var2 = 5 + this.weaponMode;
      aL[var2].draw(var1, 6, 17, 0);
      var1.setColor(4342338);
      var1.drawRect(42, 13, this.maxHealth * 6 >> 8, 3);
      var1.drawRect(42, 17, this.maxMagic * 6 >> 8, 2);
      var1.setColor(0);
      var1.fillRect(42, 14, this.maxHealth * 6 >> 8, 2);
      var1.fillRect(42, 17, this.maxMagic * 6 >> 8, 2);
      var1.setColor(4783872);
      var1.fillRect(42, 14, this.health * 6 >> 8, 2);
      if (magic <= 0 && (magicModeA || this.magicModeC || magicModeB)) {
         var1.setColor(this.flashColor);
         var1.fillRect(42, 17, this.maxMagic * 6 >> 8, 2);
      } else {
         var1.setColor(104191);
         var1.fillRect(42, 17, magic * 6 >> 8, 2);
      }

      this.drawString(var1, String.valueOf(this.upgradePoints), 58, 24, 1);
   }

   // $VF: renamed from: g (javax.microedition.lcdui.Graphics) void
   private void drawChests(Graphics var1) {
      for (int var2 = this.chestLast; var2 >= 0; var2--) {
         int var3 = this.chestX[var2];
         int var4 = this.chestY[var2];
         int var5 = var3 - cameraX;
         int var6 = var4 - cameraY;
         if (var5 + (this.chestWidth << 1) >= 0 && var6 + this.chestHeight >= 0 && var5 - this.chestWidth <= 240 && var6 - this.chestHeight <= 320) {
            this.drawFrame(var1, this.chestSprites, var2 + 121, var3, var4, 0);
         }
      }
   }

   // $VF: renamed from: h (javax.microedition.lcdui.Graphics) void
   private void drawPickups(Graphics var1) {
      for (int var2 = this.pickupLast; var2 >= 0; var2--) {
         for (int var3 = 0; var3 < 4; var3++) {
            int var4 = (var2 << 2) + var3;
            int var5 = pickupTrailX[var4];
            int var6 = pickupTrailY[var4];
            int var7 = var5 - cameraX;
            int var8 = var6 - cameraY;
            if (var7 + this.fx[pickupKind[var2]].width >= 0
               && var8 + this.fx[pickupKind[var2]].height >= 0
               && var7 - this.fx[pickupKind[var2]].width <= 240
               && var8 - this.fx[pickupKind[var2]].height <= 320) {
               this.fx[(pickupKind[var2] << 2) + var3].draw(var1, var5, var6, 0);
            }
         }
      }
   }

   // $VF: renamed from: i (javax.microedition.lcdui.Graphics) void
   private void drawScenery36(Graphics var1) {
      for (int var2 = cd; var2 >= 0; var2--) {
         if (this.bY[var2] >= 0) {
            int var3 = bZ[var2];
            int var4 = ca[var2];
            int var5 = var3 - cameraX;
            int var6 = var4 - cameraY;
            if (var5 + this.cc[var2] >= 0 && var6 + this.cb[var2] >= 0 && var5 - this.cc[var2] <= 240 && var6 - this.cb[var2] <= 320) {
               this.drawFrame(var1, this.bX, var2 + 10, var3, var4, 0);
            }
         }
      }
   }

   // $VF: renamed from: j (javax.microedition.lcdui.Graphics) void
   private void drawBoxedProps(Graphics var1) {
      for (int var2 = bW; var2 >= 0; var2--) {
         if (this.bO[var2] >= 0) {
            int var3 = bP[var2];
            int var4 = this.bQ[var2];
            int var5 = var3 - cameraX;
            int var6 = var4 - cameraY;
            if (var5 + this.bU[var2] >= 0 && var6 + this.bT[var2] >= 0 && var5 - this.bU[var2] <= 240 && var6 - this.bT[var2] <= 320) {
               this.drawFrame(var1, this.bN, var2 + 30, var3, var4, 0);
            }
         }
      }
   }

   // $VF: renamed from: k (javax.microedition.lcdui.Graphics) void
   private void drawScenery17(Graphics var1) {
      for (int var2 = ck; var2 >= 0; var2--) {
         if (this.cf[var2] >= 0) {
            int var3 = this.cg[var2];
            int var4 = ch[var2];
            int var5 = var3 - cameraX;
            int var6 = var4 - cameraY;
            if (var5 + this.cj[var2] >= 0 && var6 + this.ci[var2] >= 0 && var5 - this.cj[var2] <= 240 && var6 - this.ci[var2] <= 320) {
               this.drawFrame(var1, this.ce, var2 + 40, var3, var4, 0);
            }
         }
      }
   }

   // $VF: renamed from: l (javax.microedition.lcdui.Graphics) void
   private void drawHazards(Graphics var1) {
      for (int var2 = this.hazardLast; var2 >= 0; var2--) {
         if (this.hazardAnim[var2] >= 0) {
            int var3 = hazardX[var2];
            int var4 = this.hazardY[var2];
            int var5 = var3 - cameraX;
            int var6 = var4 - cameraY;
            if (var5 + this.hazardWidth[var2] >= 0
               && var6 + hazardHeight[var2] >= 0
               && var5 - this.hazardWidth[var2] <= 240
               && var6 - hazardHeight[var2] <= 320) {
               this.drawFrame(var1, this.dq, var2 + 70, var3, var4, 0);
            }
         }
      }
   }

   // $VF: renamed from: m (javax.microedition.lcdui.Graphics) void
   private void drawHealthProps(Graphics var1) {
      for (int var2 = this.dp; var2 >= 0; var2--) {
         if (this.di[var2] >= 0) {
            int var3 = dl[var2];
            int var4 = dm[var2];
            int var5 = var3 - cameraX;
            int var6 = var4 - cameraY;
            if (var5 + this.do_[var2] >= 0 && var6 + this.dn[var2] >= 0 && var5 - this.do_[var2] <= 240 && var6 - this.dn[var2] <= 320) {
               this.drawFrame(var1, this.dh, var2 + 60, var3, var4, this.dk[var2]);
            }
         }
      }
   }

   // $VF: renamed from: n (javax.microedition.lcdui.Graphics) void
   private void drawPushables(Graphics var1) {
      for (int var2 = pushLast; var2 >= 0; var2--) {
         if (this.pushAnim[var2] >= 0) {
            int var3 = this.pushX[var2];
            int var4 = this.pushY[var2];
            int var5 = var3 - cameraX;
            int var6 = var4 - cameraY;
            if (var5 + this.pushWidth[var2] >= 0 && var6 + this.pushHeight[var2] >= 0 && var5 <= 240 && var6 - this.pushHeight[var2] <= 320) {
               this.drawFrame(var1, this.eM, var2 + 111, var3, var4, 0);
            }
         }
      }
   }

   // $VF: renamed from: o (javax.microedition.lcdui.Graphics) void
   private void drawBreakables(Graphics var1) {
      for (int var2 = this.breakLast; var2 >= 0; var2--) {
         if (this.breakAnim[var2] >= 0) {
            int var3 = breakX[var2];
            int var4 = this.breakY[var2];
            int var5 = var3 - cameraX;
            int var6 = var4 - cameraY;
            if (var5 + (breakWidth[var2] << 1) >= 0
               && var6 + this.breakHeight[var2] >= 0
               && var5 - breakWidth[var2] <= 240
               && var6 - this.breakHeight[var2] <= 320) {
               this.drawFrame(var1, this.eY, var2 + 116, var3, var4, 0);
            }
         }
      }
   }

   // $VF: renamed from: p (javax.microedition.lcdui.Graphics) void
   private void drawSwitches(Graphics var1) {
      for (int var2 = this.switchLast; var2 >= 0; var2--) {
         int var3 = this.switchX[var2];
         int var4 = switchY[var2];
         int var5 = var3 - cameraX;
         int var6 = var4 - cameraY;
         if (var5 + this.cB[var2] >= 0 && var6 + this.cC[var2] >= 0 && var5 - this.cB[var2] <= 240 && var6 - this.cC[var2] <= 320) {
            this.drawFrame(var1, cw, var2 + 106, var3, var4, 0);
         }
      }
   }

   // $VF: renamed from: q (javax.microedition.lcdui.Graphics) void
   private void drawGates(Graphics var1) {
      for (int var2 = gateLast; var2 >= 0; var2--) {
         if (gateAnim[var2] >= 0) {
            int var3 = gateX[var2];
            int var4 = this.gateY[var2];
            int var5 = var3 - cameraX;
            int var6 = var4 - cameraY;
            if (var5 + gateWidth[var2] >= 0 && var6 + this.gateHeight[var2] >= 0 && var5 - gateWidth[var2] <= 240 && var6 - this.gateHeight[var2] <= 320) {
               this.drawFrame(var1, this.cJ, var2 + 100, var3, var4, 0);
            }
         }
      }
   }

   // $VF: renamed from: r (javax.microedition.lcdui.Graphics) void
   private void drawEnemies(Graphics var1) {
      for (int var2 = this.enemyCount; var2 >= 0; var2--) {
         if (this.enemyId[var2] >= 0) {
            int var3 = enemyX[var2];
            int var4 = this.enemyY[var2];
            int var5 = var3 - cameraX;
            int var6 = var4 - cameraY;
            if (var5 + this.enemyWidth[var2] >= 0
               && var6 + this.enemyHeight[var2] >= 0
               && var5 - this.enemyWidth[var2] <= 240
               && var6 - this.enemyHeight[var2] <= 320) {
               boolean var7 = this.enemyFacingRight[var2];
               switch (this.enemyClass[var2]) {
                  case 1:
                     this.drawFrame(var1, this.dC, var2 + 85, enemyX[var2], this.enemyY[var2], var7 ? 0 : 2);
                     break;
                  case 2:
                     this.drawFrame(var1, dD, var2 + 85, enemyX[var2], this.enemyY[var2], var7 ? 0 : 2);
                     break;
                  case 3:
                     if (bossIndex == var2) {
                        this.drawFrame(var1, this.dF, var2 + 85, enemyX[var2], this.enemyY[var2], var7 ? 0 : 2);
                     } else {
                        this.drawFrame(var1, this.dE, var2 + 85, enemyX[var2], this.enemyY[var2], var7 ? 0 : 2);
                     }
               }

               if (this.enemyStatus[var2] > 0) {
                  this.drawFrame(var1, this.bH, 137, enemyX[var2], this.enemyY[var2], 0);
                  this.stepAnim(137, this.frameDelta);
               }

               if (state == 100
                  && (
                     this.grappledEnemy < 0
                           && this.enemyStatus[var2] <= 0
                           && enemyHealth[var2] < enemyMaxHealth[var2] >> 1
                           && !this.eh[var2]
                           && enemyHealth[var2] >= 0
                        || this.enemyClass[var2] == 3 && this.enemyAction[var2] == 12 && bossIndex != var2 && this.finalBossIndex != var2
                        || this.enemyClass[var2] == 2 && this.enemyAction[var2] == 12 && bossIndex != var2
                  )) {
                  this.drawFrame(
                     var1,
                     this.aU,
                     132,
                     enemyX[var2],
                     this.enemyY[var2] - this.enemyHeight[var2] - (this.finalBossIndex == var2 ? -(this.enemyHeight[var2] >> 3) : this.enemyHeight[var2] >> 2),
                     0
                  );
               }
            }
         }
      }
   }

   // $VF: renamed from: s (javax.microedition.lcdui.Graphics) void
   private void drawPlayer(Graphics var1) {
      this.drawFrame(var1, this.fH, 135, this.playerX, this.playerY, facingRight ? 0 : 2);
   }

   // $VF: renamed from: t (javax.microedition.lcdui.Graphics) void
   private void drawEffects(Graphics var1) {
      for (int var2 = this.effectLast; var2 >= 0; var2--) {
         if (effectAnim[var2] >= 0) {
            this.drawFrame(var1, this.bH, effectAnim[var2], this.effectX[var2], this.effectY[var2], this.effectFlip[var2]);
         }
      }
   }

   // $VF: renamed from: d (int, int) void
   private void spawnObjects(int var1, int var2) {
      switch (var1) {
         case 0:
            for (int var47 = 0; var47 < var2; var47++) {
               int var62 = this.readBits(10);
               int var76 = this.bs[var47] / 16;
               int var87 = this.bt[var47] / 16;

               for (int var94 = 0; var94 <= var62; var94++) {
                  this.setCellFlags(var76 + var94, var87, 8192);
               }
            }

            return;
         case 3:
            this.lockRectCount = var2;
            this.lockVertical = new boolean[var2];
            this.lockReverse = new boolean[var2];
            this.lockX = new int[var2];
            this.lockY = new int[var2];

            for (int var23 = 0; var23 < var2; var23++) {
               this.lockX[var23] = this.bs[var23];
               this.lockY[var23] = this.bt[var23];
               this.lockVertical[var23] = this.readBits(1) == 1;
               this.lockReverse[var23] = this.readBits(1) == 1;
            }

            return;
         case 4:
            this.chestLast = var2 - 1;
            this.chestAnim = new int[var2];
            this.chestX = new int[var2];
            this.chestY = new int[var2];
            chestOpened = new boolean[var2];
            chestReward = new int[var2];
            int var46 = 1 << this.levelIndex;

            for (int var61 = 0; var61 < var2; var61++) {
               this.chestAnim[var61] = this.readBits(3);
               chestReward[var61] = this.readBits(10);
               if (this.chestAnim[var61] == 3) {
                  if (chestReward[var61] > 0) {
                     chestReward[var61] = -1;
                  } else {
                     chestReward[var61] = -2;
                  }
               }

               this.chestX[var61] = this.bs[var61];
               this.chestY[var61] = this.bt[var61];
               if ((chestReward[var61] != -1 || (chestFlags & var46) != var46) && (chestReward[var61] != -2 || (chestFlags & var46 << 10) != var46 << 10)) {
                  chestOpened[var61] = false;
               } else {
                  chestOpened[var61] = true;
                  chestReward[var61] = 0;
                  this.chestAnim[var61] = this.chestAnim[var61] + 4;
               }

               this.startAnim(121 + var61, 5120, this.chestAnim[var61]);
               if (chestOpened[var61]) {
                  this.stepAnim(121 + var61, 2000);
               }

               this.getFrameBounds(this.chestSprites, 121 + var61, 0, 0, 0, this.P);
               this.chestWidth = this.P[2];
               this.chestHeight = this.P[3];
            }
         case 1:
         case 2:
         case 15:
         case 16:
         case 19:
         case 20:
         case 24:
         default:
            return;
         case 5:
            for (int var45 = 0; var45 < var2; var45++) {
               int var60 = this.readBits(10);
               int var75 = this.bs[var45] / 16;
               int var86 = this.bt[var45] / 16;

               for (int var93 = 0; var93 <= var60; var93++) {
                  this.setCellFlags(var75, var86 + var93, 8);
               }
            }

            return;
         case 6:
            for (int var13 = 0; var13 < 40; var13++) {
               this.aY[var13] = this.readBits(10);
            }

            for (int var14 = 0; var14 < 40; var14++) {
               this.aZ[var14] = this.readBits(10);
            }

            return;
         case 7:
            this.breakAnim = new int[var2];
            this.breakTileX = new int[var2];
            breakTileY = new int[var2];
            breakX = new int[var2];
            this.breakY = new int[var2];
            breakWidth = new int[var2];
            this.breakHeight = new int[var2];
            this.breakTilesW = new byte[var2];
            this.breakTilesH = new byte[var2];
            breakStopsCamera = new boolean[var2];
            breakCameraRight = new boolean[var2];

            for (int var44 = 0; var44 < var2; var44++) {
               this.breakLast = var44;
               this.breakAnim[var44] = this.readBits(6) << 1;
               breakStopsCamera[var44] = this.readBits(1) == 1;
               breakCameraRight[var44] = this.readBits(1) == 1;
               this.startAnim(116 + var44, 2048, this.breakAnim[var44]);
               this.getFrameBounds(this.eY, 116 + var44, 0, 0, 0, this.P);
               breakX[var44] = this.bs[var44];
               this.breakY[var44] = this.bt[var44];
               this.breakTileX[var44] = this.bs[var44] / 16;
               breakTileY[var44] = this.bt[var44] / 16;
               breakWidth[var44] = this.P[2];
               this.breakHeight[var44] = this.P[3];
               this.breakTilesW[var44] = (byte)(breakWidth[var44] / 16);
               this.breakTilesH[var44] = (byte)(this.breakHeight[var44] / 16);
               int var59 = this.breakTileX[var44];
               int var74 = breakTileY[var44];
               if (!this.stepAnim(116 + var44, 1)) {
                  this.spawnDebris(var44, 2);
                  this.removeBreakable(var44);
               } else {
                  for (int var85 = 0; var85 < this.breakTilesW[var44]; var85++) {
                     for (int var92 = 1; var92 <= this.breakTilesH[var44]; var92++) {
                        this.setCellFlags(var59 + var85, var74 - var92, 1);
                     }
                  }
               }
            }

            return;
         case 8:
            this.cl = new int[var2];
            cm = new int[var2];
            this.cn = new int[var2];
            this.co = new int[var2];
            cv = var2 - 1;

            for (int var43 = 0; var43 < var2; var43++) {
               this.cl[var43] = this.bs[var43] / 16;
               cm[var43] = this.bt[var43] / 16;
               this.setCellFlags(this.cl[var43], cm[var43], 128);
               this.cn[var43] = this.readBits(10);
               this.co[var43] = this.readBits(3);
            }

            return;
         case 9:
            this.triggerGateId = new byte[var2];
            this.triggerTileX = new int[var2];
            triggerTileY = new int[var2];

            for (int var42 = 0; var42 < var2; var42++) {
               int var58 = this.readBits(10);
               this.triggerGateId[var42] = (byte)this.readBits(3);
               int var73 = this.bs[var42] / 16;
               int var84 = this.bt[var42] / 16;
               this.triggerTileX[var42] = var73;
               triggerTileY[var42] = var84;

               for (int var91 = 0; var91 <= var58; var91++) {
                  this.setCellFlags(var73, var84 + var91, 256);
               }
            }

            return;
         case 10:
            for (int var41 = 0; var41 < var2; var41++) {
               int var57 = this.readBits(10);
               int var72 = this.bs[var41] / 16;
               int var83 = this.bt[var41] / 16;

               for (int var90 = 0; var90 <= var57; var90++) {
                  this.setCellFlags(var72 + var90, var83, 64);
               }
            }

            return;
         case 11:
         case 12:
         case 13:
            Sprite[] var22 = (Sprite[])null;
            byte var26 = -1;
            byte var28 = -1;
            if (var1 == 11) {
               var22 = this.dC;
               var26 = 1;
               var28 = 0;
               if (this.dA) {
               }
            } else if (var1 == 12) {
               var22 = dD;
               var26 = 2;
               var28 = 0;
               if (this.dB) {
               }
            } else if (var1 == 13) {
               var22 = this.dE;
               var26 = 3;
               var28 = 0;
            }

            for (int var40 = this.enemyCount; var40 < this.enemyCount + var2; var40++) {
               this.enemyId[var40] = var40;
               enemyX[var40] = this.bs[var40 - this.enemyCount];
               this.enemyY[var40] = this.bt[var40 - this.enemyCount];
               this.enemyTileX[var40] = enemyX[var40] / 16;
               this.enemyTileY[var40] = (this.enemyY[var40] - 1) / 16;
               this.setCellFlags(this.enemyTileX[var40], this.enemyTileY[var40] - 1, 2);
               this.enemyAction[var40] = var28;
               this.enemyId[var40] = var40;
               this.enemyClass[var40] = var26;
               eu[var40] = 0;
               enemyHomeX[var40] = enemyX[var40];
               enemyHomeY[var40] = this.enemyY[var40];
               this.enemySubY[var40] = this.enemyY[var40] - this.enemyTileY[var40] * 16 << 8;
               this.enemyStatus[var40] = 0;
               enemyRespawns[var40] = (byte)this.readBits(3);
               ed[var40] = enemyRespawns[var40];
               this.enemyRespawnDelay[var40] = this.readBits(10) * 1000;
               this.dL = this.readBits(1) == 1 ? var40 : 0;
               enemyRespawnTimer[var40] = this.enemyRespawnDelay[var40];
               enemyMaxHealth[var40] = this.readBits(16);
               enemyHealth[var40] = enemyMaxHealth[var40];
               this.enemyDropAmount[var40] = this.readBits(16);
               this.enemyContactDamage[var40] = (byte)this.readBits(10);
               this.enemyWaveSlot[var40] = (byte)this.readBits(10);
               this.enemyFacingRight[var40] = this.readBits(1) != 1;
               es[var40] = this.enemyFacingRight[var40];
               ev[var40] = this.readBits(1) == 1;
               if (var1 == 13) {
                  boolean var56 = this.readBits(1) == 1;
                  boolean var71 = this.readBits(1) == 1;
                  if (ev[var40]) {
                     var28 = 1;
                  }

                  if (var56 && !var71) {
                     this.dF = this.loadSprites(
                        13313, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(13315 + levelPaletteVariants[this.levelIndex]) : null
                     );
                     this.loadAnimSet(13312);
                     bossIndex = var40;
                     enemyHealth[var40] = enemyHealth[var40] << 2;
                     enemyMaxHealth[var40] = enemyHealth[var40];
                  } else if (var71) {
                     this.dF = this.loadSprites(14337);
                     this.loadAnimSet(14336);
                     this.finalBossIndex = var40;
                     bossIndex = var40;
                     enemyHealth[var40] = enemyHealth[var40] << 2;
                     enemyMaxHealth[var40] = enemyHealth[var40];
                  } else {
                     this.loadAnimSet(15360);
                  }
               } else if (ev[var40]) {
                  var28 = 1;
               }

               this.setEnemyAction(var28, var40);
               this.getFrameBounds(var22, 85 + var40, 0, 0, 0, this.P);
               this.enemyWidth[var40] = (short)this.P[2];
               enemyHalfWidthTiles[var40] = (byte)(this.enemyWidth[var40] / 16 >> 1);
               if (enemyHalfWidthTiles[var40] == 0) {
                  enemyHalfWidthTiles[var40] = 1;
               }

               this.enemyHeight[var40] = (short)this.P[3];
               this.enemyHeightTiles[var40] = (byte)(this.enemyHeight[var40] / 16);
            }

            this.enemyCount += var2;
            return;
         case 14:
            this.waveTileX = new int[var2];
            this.waveTileY = new int[var2];
            this.waveEnemyX = new int[var2 * 15];
            this.waveEnemyY = new int[var2 * 15];
            this.waveEnemyFacing = new boolean[var2 * 15];

            for (int var39 = 0; var39 < var2; var39++) {
               int var55 = this.readBits(10);
               this.waveTileX[var39] = this.bs[var39] / 16;
               this.waveTileY[var39] = this.bt[var39] / 16;

               for (int var69 = 0; var69 < 15; var69++) {
                  if (var69 < 15) {
                     this.waveEnemyX[var69 + var39 * 15] = this.readBits(10);
                     this.waveEnemyY[var69 + var39 * 15] = this.readBits(10);
                     this.waveEnemyFacing[var69 + var39 * 15] = this.readBits(1) != 1;
                  } else {
                     this.readBits(10);
                     this.readBits(10);
                     this.readBits(1);
                  }
               }

               for (int var70 = 0; var70 < var55; var70++) {
                  this.setCellFlags(this.waveTileX[var39], this.waveTileY[var39] + var70, 4);
               }
            }

            return;
         case 17:
            ck = var2 - 1;

            for (int var21 = 0; var21 < var2; var21++) {
               this.cf[var21] = this.readBits(6);
               this.cg[var21] = this.bs[var21];
               ch[var21] = this.bt[var21];
               this.startAnim(40 + var21, 3072, this.cf[var21]);
               this.getFrameBounds(this.ce, 40 + var21, 0, 0, 0, this.P);
               this.cj[var21] = this.P[2];
               this.ci[var21] = this.P[3];
            }

            return;
         case 18:
            for (int var38 = 0; var38 < var2; var38++) {
               int var54 = this.readBits(10);
               int var68 = this.bs[var38] / 16;
               int var82 = this.bt[var38] / 16;

               for (int var89 = 0; var89 <= var54; var89++) {
                  this.setCellFlags(var68 + var89, var82, 16);
               }
            }

            return;
         case 21:
            this.dp = var2 - 1;

            for (int var37 = 0; var37 < var2; var37++) {
               this.di[var37] = this.readBits(6) << 1;
               dl[var37] = this.bs[var37];
               dm[var37] = this.bt[var37];
               this.dk[var37] = 0;
               this.startAnim(60 + var37, 5121, this.di[var37]);
               this.getFrameBounds(this.dh, 60 + var37, 0, 0, 0, this.P);
               this.do_[var37] = this.P[2];
               this.dn[var37] = this.P[3];
            }

            return;
         case 22:
            for (int var15 = 0; var15 < var2; var15++) {
               int var3 = 0;

               for (int var19 = 0; var19 < 1; var19++) {
                  if (this.readBits(1) == 1) {
                     var3 |= 1 << var19;
                  }
               }

               int var20 = this.bs[var15] / 16;
               int var25 = this.bt[var15] / 16;
               int var27 = this.readBits(10);
               int var36 = this.readBits(10);
               int var53 = this.readBits(10);
               int var67 = this.readBits(10);

               for (int var78 = 0; var78 <= var27; var78++) {
                  this.setCellFlags(var20, var25 - var78, var3);
               }

               for (int var79 = 0; var79 <= var36; var79++) {
                  this.setCellFlags(var20, var25 + var79, var3);
               }

               for (int var80 = 0; var80 <= var53; var80++) {
                  this.setCellFlags(var20 - var80, var25, var3);
               }

               for (int var81 = 0; var81 <= var67; var81++) {
                  this.setCellFlags(var20 + var81, var25, var3);
               }
            }

            return;
         case 23:
            this.eI = new int[var2];
            this.eJ = new int[var2];
            this.eK = new int[var2];
            eL = new byte[var2];
            this.br = var2;

            for (int var18 = var2 - 1; var18 >= 0; var18--) {
               this.eI[var18] = this.readBits(8);
               this.eJ[var18] = this.bs[var2 - var18 - 1];
               this.eK[var18] = this.bt[var2 - var18 - 1];
               eL[var18] = (byte)this.readBits(3);
            }

            return;
         case 25:
            for (int var35 = 0; var35 < var2; var35++) {
               this.setCellFlags(this.bs[var35] / 16, this.bt[var35] / 16, 1024);
            }

            return;
         case 26:
            this.fW = this.bs[0];
            this.fX = this.bt[0];
            this.checkpointX = this.fW;
            this.checkpointY = this.fX;
            this.atLadderTop = false;
            this.climbing = false;
            this.health = this.maxHealth;
            magic = this.maxMagic;
            this.blocking = false;
            gg = false;
            this.playerX = this.fW;
            this.playerY = this.fX;
            return;
         case 27:
            pushLast = var2 - 1;
            this.pushAnim = new int[var2];
            this.pushX = new int[var2];
            this.pushY = new int[var2];
            pushTileX = new int[var2];
            this.pushTileY = new int[var2];
            this.pushWidth = new int[var2];
            this.pushHeight = new int[var2];
            this.pushTilesW = new byte[var2];
            this.pushTilesH = new byte[var2];
            eW = new boolean[var2];

            for (int var34 = 0; var34 < var2; var34++) {
               this.pushAnim[var34] = this.readBits(3);
               eW[var34] = this.readBits(1) == 1;
               this.startAnim(111 + var34, 6144, this.pushAnim[var34]);
               this.getFrameBounds(this.eM, 111 + var34, 0, 0, 0, this.P);
               this.pushX[var34] = this.bs[var34];
               this.pushY[var34] = this.bt[var34];
               pushTileX[var34] = this.bs[var34] / 16;
               this.pushTileY[var34] = this.bt[var34] / 16;
               this.pushWidth[var34] = this.P[2];
               this.pushHeight[var34] = this.P[3];
               this.pushTilesW[var34] = (byte)(this.pushWidth[var34] / 16);
               this.pushTilesH[var34] = (byte)(this.pushHeight[var34] / 16);
               int var52 = pushTileX[var34];
               int var66 = this.pushTileY[var34];

               for (int var77 = 0; var77 < this.pushTilesW[var34]; var77++) {
                  for (int var88 = 1; var88 <= this.pushTilesH[var34]; var88++) {
                     this.setCellFlags(var52 + var77, var66 - var88, 1);
                     this.setCellFlags(var52 + var77, var66 - var88, 512);
                     if (eW[var34]) {
                        this.setCellFlags(var52 + var77, var66 - var88, 8);
                     }
                  }
               }

               this.setCellFlags(var52, var66, 1);
            }

            return;
         case 28:
            this.arenaTileY = new int[var2];
            this.arenaTileX = new int[var2];
            this.arenaWidth = new int[var2];
            arenaHeight = new int[var2];
            this.arenaGateId = new int[var2];
            arenaKills = new int[var2];
            this.arenaKillsNeeded = new int[var2];

            for (int var33 = 0; var33 < var2; var33++) {
               this.arenaTileX[var33] = this.bs[var33] / 16;
               this.arenaTileY[var33] = this.bt[var33] / 16;
               this.arenaWidth[var33] = this.readBits(10);
               arenaHeight[var33] = this.readBits(10);
               this.arenaGateId[var33] = this.readBits(3);
               this.arenaKillsNeeded[var33] = this.readBits(10);
               arenaKills[var33] = 0;

               for (int var51 = 0; var51 <= this.arenaWidth[var33]; var51++) {
                  for (int var65 = 0; var65 <= arenaHeight[var33]; var65++) {
                     this.setCellFlags(this.arenaTileX[var33] + var51, this.arenaTileY[var33] + var65, 32);
                  }
               }
            }

            return;
         case 29:
            for (int var32 = 0; var32 < var2; var32++) {
               int var50 = this.readBits(10);
               int var64 = this.bs[var32] / 16;
               int var11 = this.bt[var32] / 16;

               for (int var12 = 0; var12 <= var50; var12++) {
                  this.setCellFlags(var64 + var12, var11, 16384);
               }
            }

            return;
         case 30:
            for (int var31 = 0; var31 < var2; var31++) {
               if (this.readBits(1) != 0) {
                  this.setCellFlags(this.bs[var31] / 16, this.bt[var31] / 16, 2048);
               } else {
                  this.setCellFlags(this.bs[var31] / 16, this.bt[var31] / 16, 4096);
               }
            }

            return;
         case 31:
            for (int var17 = 0; var17 < var2; var17++) {
               int var4 = 0;

               for (int var6 = 0; var6 < 1; var6++) {
                  if (this.readBits(1) == 1) {
                     var4 |= 1 << var6;
                  }
               }

               int var24 = this.bs[var17] / 16;
               int var7 = this.bt[var17] / 16;
               this.setCellFlags(var24, var7, var4);
            }

            return;
         case 32:
            bW = var2 - 1;

            for (int var16 = 0; var16 < var2; var16++) {
               this.bO[var16] = this.readBits(6) << 1;
               bP[var16] = this.bs[var16];
               this.bQ[var16] = this.bt[var16];
               this.bV[var16] = this.readBits(1) == 1;
               this.startAnim(30 + var16, 5122, this.bO[var16]);
               this.getFrameBoxes(this.playerBoxes, 30 + var16, 0);
               bR[var16] = this.playerBoxes[0] + bP[var16];
               this.bS[var16] = this.playerBoxes[1] + this.bQ[var16];
               this.bU[var16] = this.playerBoxes[2];
               this.bT[var16] = this.playerBoxes[3];
            }

            return;
         case 33:
            this.hazardLast = var2 - 1;

            for (int var30 = 0; var30 < var2; var30++) {
               this.hazardAnim[var30] = this.readBits(6);
               this.hazardDamage[var30] = this.readBits(10);
               int var49 = this.readBits(3) * 100;
               hazardX[var30] = this.bs[var30];
               this.hazardY[var30] = this.bt[var30];
               this.hazardHomeX[var30] = this.bs[var30];
               this.hazardHomeY[var30] = this.bt[var30];
               this.startAnim(70 + var30, 6145, this.hazardAnim[var30]);
               this.getFrameBounds(this.dq, 70 + var30, 0, 0, 0, this.P);
               this.stepAnim(70 + var30, var49);
               this.hazardWidth[var30] = this.P[2];
               hazardHeight[var30] = this.P[3];
            }

            return;
         case 34:
            this.switchLast = var2 - 1;
            this.switchX = new int[var2];
            switchY = new int[var2];
            this.switchOn = new boolean[var2];
            switchTileY = new int[var2];
            this.switchTileX = new int[var2];
            this.switchTargets = new int[var2 + 1 << 2];
            switchAnim = new int[var2];
            this.cB = new int[var2];
            this.switchIsLever = new boolean[var2];
            this.cC = new int[var2];

            for (int var29 = 0; var29 < var2; var29++) {
               int var48 = this.bs[var29] / 16;
               int var63 = this.bt[var29] / 16;
               this.switchX[var29] = var48 * 16;
               switchY[var29] = var63 * 16;
               this.switchTileX[var29] = var48;
               switchTileY[var29] = var63;
               this.switchOn[var29] = false;
               this.switchIsLever[var29] = this.readBits(1) == 1;
               switchAnim[var29] = 0 + (this.switchIsLever[var29] ? 4 : 0);
               this.switchTargets[var29 << 2] = this.readBits(3);
               this.switchTargets[(var29 << 2) + 1] = this.readBits(3);
               this.switchTargets[(var29 << 2) + 2] = this.readBits(3);
               this.switchTargets[(var29 << 2) + 3] = this.readBits(3);
               this.startAnim(106 + var29, 2050, switchAnim[var29]);
               this.getFrameBounds(cw, 106 + var29, 0, 0, 0, this.P);
               this.cB[var29] = this.P[2];
               this.cC[var29] = this.P[3];
            }

            return;
         case 35:
            gateLast = var2 - 1;
            gateX = new int[var2];
            this.gateY = new int[var2];
            gateTileX = new int[var2];
            gateTileY = new int[var2];
            gateOpen = new boolean[var2];
            this.gateId = new int[var2];
            gateAnim = new int[var2];
            this.gateStyle = new int[var2];
            gateTilesW = new int[var2];
            this.gateTilesH = new int[var2];
            gateWidth = new int[var2];
            this.gateHeight = new int[var2];
            this.gateShowsCamera = new boolean[var2];

            for (int var8 = 0; var8 < var2; var8++) {
               gateX[var8] = this.bs[var8];
               this.gateY[var8] = this.bt[var8];
               gateTileX[var8] = this.bs[var8] / 16;
               gateTileY[var8] = this.bt[var8] / 16;
               this.gateId[var8] = this.readBits(3);
               this.gateStyle[var8] = this.readBits(10);
               gateOpen[var8] = this.readBits(1) == 1;
               this.gateShowsCamera[var8] = this.readBits(1) == 1;
               gateAnim[var8] = (this.gateStyle[var8] << 2) + 0;
               this.startAnim(100 + var8, 2049, gateAnim[var8]);
               this.getFrameBounds(this.cJ, 100 + var8, 0, 0, 0, this.P);
               gateTilesW[var8] = this.P[2] / 16;
               this.gateTilesH[var8] = this.P[3] / 16;
               gateWidth[var8] = this.P[2];
               this.gateHeight[var8] = this.P[3];
               gateAnim[var8] = (this.gateStyle[var8] << 2) + 2 - (gateOpen[var8] ? 2 : 0);
               this.startAnim(100 + var8, 2049, gateAnim[var8]);

               for (int var9 = 0; var9 < this.gateTilesH[var8]; var9++) {
                  for (int var10 = 0; var10 < gateTilesW[var8]; var10++) {
                     if (gateOpen[var8]) {
                        this.clearCellFlags(gateTileX[var8] + var10, gateTileY[var8] - var9, 1);
                     } else {
                        this.setCellFlags(gateTileX[var8] + var10, gateTileY[var8] - var9, 1);
                     }
                  }
               }
            }

            return;
         case 36:
            cd = var2 - 1;

            for (int var5 = 0; var5 < var2; var5++) {
               this.bY[var5] = this.readBits(6);
               bZ[var5] = this.bs[var5];
               ca[var5] = this.bt[var5];
               this.startAnim(10 + var5, 3074, this.bY[var5]);
               this.getFrameBounds(this.bX, 10 + var5, 0, 0, 0, this.P);
               this.cc[var5] = this.P[2];
               this.cb[var5] = this.P[3];
            }
      }
   }

   // $VF: renamed from: a (byte[], boolean) void
   private void loadLevelStep(byte[] var1, boolean var2) {
      switch (this.levelLoadStep) {
         case 0:
            if (!var2) {
               this.scene = null;
               this.cellFlags = null;
               this.cellTileTypes = null;
            }

            for (int var3 = 0; var3 < 10; var3++) {
               effectAnim[var3] = -1;
            }

            this.setLevelData(var1);
            this.readBits(1);
            this.readBits(10);
            this.readLevelHeaderFlags(var2);
            this.readBits(1);
            this.bw = this.readBits(16);
            this.bx = this.readBits(4);
            int[] var10 = new int[this.bw];

            for (int var4 = 0; var4 < this.bw; var4++) {
               var10[var4] = this.readBits(this.bx);
            }

            this.by = bitsFor(this.bw);
            int var13 = 0;
            int var5 = 0;
            if (var2 && mapHeight != 0) {
               var13 = mapHeight;
               var5 = mapWidth;
            }

            mapWidth = this.readBits(16);
            mapHeight = this.readBits(16);
            if (!var2) {
               this.bu = 16 * mapWidth;
               this.bv = 16 * mapHeight;
               this.maxCameraX = this.bu - 240;
               this.maxCameraY = this.bv - 320;
            }

            mapCellCount = mapWidth * mapHeight;
            if (!var2) {
               this.cellFlags = new short[mapCellCount];
            }

            this.cellTileTypes = new byte[mapCellCount];

            for (int var6 = 0; var6 < this.cellTileTypes.length; var6++) {
               this.cellTileTypes[var6] = (byte)this.readBits(this.by);
            }

            this.readBits(8);
            this.readTileSolidFlags(this.bw, var2);
            this.scene = Scene.create(240, 320);
            this.scene.setTileMap(mapWidth, mapHeight, this.tileSheet, 16, 16);
            int var7 = 0;

            for (int var8 = 0; var8 < mapHeight; var8++) {
               for (int var9 = 0; var9 < mapWidth; var9++) {
                  this.scene.setTile(var9, var8, 1 + var10[this.cellTileTypes[var7] & 0xFF]);
                  var7++;
               }
            }

            this.cellTileTypes = null;
            this.bw = this.readBits(10);
            if (!var2) {
               worldWidthPx = mapWidth * 16;
               worldHeightPx = mapHeight * 16;
            }

            this.bz = bitsFor(worldWidthPx * worldHeightPx + 1);
            worldWidthPx = mapWidth * 16;
            worldHeightPx = mapHeight * 16;
            if (var2 && var13 != 0) {
               mapHeight = var13;
               mapWidth = var5;
            }
         case 1:
         default:
            break;
         case 2:
            if (!var2) {
               this.eY = this.loadSprites(
                  2051, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(2059 + levelPaletteVariants[this.levelIndex]) : null
               );
            }
            break;
         case 3:
            if (!var2) {
               this.fH = this.loadSprites(
                  28673, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(28675 + levelPaletteVariants[this.levelIndex]) : null
               );
            }
            break;
         case 4:
            if (!var2) {
               this.eH = this.loadSprites(
                  3076, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(3084 + levelPaletteVariants[this.levelIndex]) : null
               );
            }
            break;
         case 5:
            if (!var2) {
               if (this.dA) {
                  this.dC = this.loadSprites(
                     18433, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(18435 + levelPaletteVariants[this.levelIndex]) : null
                  );
                  this.loadAnimSet(18432);
               } else {
                  this.dC = this.loadSprites(
                     4097, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(4099 + levelPaletteVariants[this.levelIndex]) : null
                  );
                  this.loadAnimSet(4096);
               }

               if (this.dB) {
                  dD = this.loadSprites(
                     16385, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(16387 + levelPaletteVariants[this.levelIndex]) : null
                  );
                  this.loadAnimSet(16384);
               } else {
                  dD = this.loadSprites(
                     17409, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(17411 + levelPaletteVariants[this.levelIndex]) : null
                  );
                  this.loadAnimSet(17408);
               }

               this.dE = this.loadSprites(
                  15361, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(15363 + levelPaletteVariants[this.levelIndex]) : null
               );
               this.loadAnimSet(15360);
            }
            break;
         case 6:
            if (!var2) {
               this.bN = this.loadSprites(
                  5125, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(5142 + levelPaletteVariants[this.levelIndex]) : null
               );
               this.dh = this.loadSprites(
                  5124, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(5132 + levelPaletteVariants[this.levelIndex]) : null
               );
               this.eM = this.loadSprites(
                  6146, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(6150 + levelPaletteVariants[this.levelIndex]) : null
               );
            }
            break;
         case 7:
            if (!var2) {
               this.dq = this.loadSprites(
                  6147, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(6153 + levelPaletteVariants[this.levelIndex]) : null
               );
               this.chestSprites = this.loadSprites(
                  5123, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(5129 + levelPaletteVariants[this.levelIndex]) : null
               );
            }
            break;
         case 8:
            if (!var2) {
               this.cJ = this.loadSprites(
                  2052, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(2062 + levelPaletteVariants[this.levelIndex]) : null
               );
               cw = this.loadSprites(
                  2053, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(2065 + levelPaletteVariants[this.levelIndex]) : null
               );
            }
            break;
         case 9:
            if (!var2) {
               this.bX = this.loadSprites(
                  3077, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(3087 + levelPaletteVariants[this.levelIndex]) : null
               );
               this.ce = this.loadSprites(
                  3075, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(3081 + levelPaletteVariants[this.levelIndex]) : null
               );
               this.bH = this.loadSprites(7169, null);
               this.startAnim(137, 7168, 31);
            }
      }

      if (this.levelLoadStep == 10 && !var2 || var2) {
         this.br = 0;
         if (!var2) {
            this.scene.initObjects(1000);
         }

         this.sceneObjectCount = 0;

         while (this.bw-- > 0) {
            int var11 = this.readBits(10);
            int var14 = this.readBits(16);
            int var15 = 0;
            this.bs = new int[var14];
            this.bt = new int[var14];
            int var16 = 0;

            for (int var17 = 0; var17 < var14; var17++) {
               for (var15 += this.readBits(this.bz); var15 >= worldWidthPx; var16++) {
                  var15 -= worldWidthPx;
               }

               this.bs[var17] = var15;
               this.bt[var17] = var16;
            }

            this.spawnObjects(var11, var14);
         }

         for (int var12 = this.chestLast; var12 >= 0; var12--) {
            if (chestOpened[var12]) {
               this.e(this.chestX[var12] / 16, this.chestY[var12] / 16);
            }
         }

         this.levelData = null;
         this.buildStaticSprites();
         this.stopSounds();
         this.parseBank(null);
      }

      this.levelLoadStep++;
   }

   // $VF: renamed from: s () void
   private void buildStaticSprites() {
      short[] var1 = new short[256];
      int var2 = 0;

      for (int var3 = 0; var3 < this.br; var3++) {
         this.startAnim(136, 3073, this.eI[var3]);
         var2 += this.getFrameParts(var1, 136, 0);
      }

      this.scene.initStaticSprites(this.br + var2, mapWidth <= mapHeight);

      for (int var7 = 0; var7 <= 7; var7++) {
         for (int var4 = this.br - 1; var4 >= 0; var4--) {
            if (eL[var4] == var7) {
               this.startAnim(136, 3073, this.eI[var4]);
               int var5 = this.getFrameParts(var1, 136, 0);

               for (int var6 = 0; var6 < var5; var6++) {
                  this.scene
                     .addStaticSprite(this.eH[var1[var6 * 4]], this.eJ[var4] + var1[var6 * 4 + 1], this.eK[var4] + var1[var6 * 4 + 2], var1[var6 * 4 + 3]);
               }
            }
         }
      }

      this.eJ = null;
      this.eK = null;
      this.eI = null;
      eL = null;
   }

   // $VF: renamed from: c (boolean) void
   private void readLevelHeaderFlags(boolean var1) {
      if (!var1) {
         this.Q = this.readBits(10);
         facingRight = this.readBits(1) != 1;
         this.checkpointFacingRight = facingRight;
         this.dA = this.readBits(1) == 1;
         this.dB = this.readBits(1) == 1;
         this.readBits(1);
         int var2 = this.readBits(16);
         this.orbBudget = this.orbBudget < var2 ? var2 : this.orbBudget;
      }
   }

   // $VF: renamed from: l (int) int
   private static int bitsFor(int var0) {
      int var1 = -1;

      while (var0 - 1 >> ++var1 > 0) {
      }

      return var1;
   }

   // $VF: renamed from: a (byte[]) void
   private void setLevelData(byte[] var1) {
      this.levelData = var1;
      this.levelBytePos = 0;
      this.levelCurByte = 0;
      this.levelBitsLeft = 0;
   }

   // $VF: renamed from: m (int) int
   private int readBits(int var1) {
      int var2 = 0;
      int var3 = var1;

      while (var3 > 0) {
         if (this.levelBitsLeft == 0) {
            this.levelCurByte = this.levelData[this.levelBytePos++] & 255;
            this.levelBitsLeft = 8;
         }

         int var4 = Math.min(var3, this.levelBitsLeft);
         var2 |= (this.levelCurByte >> 8 - this.levelBitsLeft & ~(-1 << var4)) << var1 - var3;
         this.levelBitsLeft -= var4;
         var3 -= var4;
      }

      return var2;
   }

   // $VF: renamed from: b (int, boolean) void
   private void readTileSolidFlags(int var1, boolean var2) {
      for (int var3 = 0; var3 < var1; var3++) {
         for (int var4 = 0; var4 < 1; var4++) {
            if (this.readBits(1) == 1 && !var2) {
               this.cellFlags[var3] = (short)(this.cellFlags[var3] | 1 << var4);
            }
         }
      }

      if (!var2) {
         this.tileSheet = this.loadImage(
            2058, levelPaletteVariants[this.levelIndex] >= 0 ? this.getResourceBytes(2068 + levelPaletteVariants[this.levelIndex]) : null
         );
      }
   }

   // $VF: renamed from: n (int) void
   private void removeEffect(int var1) {
      this.copyAnimSlot(0 + this.effectLast, 0 + effectAnim[var1]);
      this.effectFlip[var1] = this.effectFlip[this.effectLast];
      this.effectX[var1] = this.effectX[this.effectLast];
      this.effectY[var1] = this.effectY[this.effectLast];
      effectAnim[this.effectLast] = -1;
      if (this.effectLast >= 0) {
         this.effectLast--;
      }
   }

   private void o(int var1) {
      if (this.bO[bW] >= 0) {
         this.copyAnimSlot(bW + 30, var1 + 30);
      }

      this.bO[var1] = this.bO[bW];
      bP[var1] = bP[bW];
      this.bQ[var1] = this.bQ[bW];
      this.bU[var1] = this.bU[bW];
      this.bT[var1] = this.bT[bW];
      bR[var1] = bR[bW];
      this.bS[var1] = this.bS[bW];
      this.bO[bW] = -1;
      if (bW > 0) {
         bW--;
      }
   }

   private void p(int var1) {
      if (this.di[this.dp] >= 0) {
         this.copyAnimSlot(this.dp + 60, var1 + 60);
      }

      this.di[var1] = this.di[this.dp];
      dl[var1] = dl[this.dp];
      dm[var1] = dm[this.dp];
      this.dk[var1] = this.dk[this.dp];
      this.dj[var1] = this.dj[this.dp];
      this.dn[var1] = this.dn[var1];
      this.do_[var1] = this.do_[var1];
      this.di[this.dp] = -1;
      if (this.dp >= 0) {
         this.dp--;
      }
   }

   // $VF: renamed from: q (int) void
   private void removeBreakable(int var1) {
      if (this.breakAnim[this.breakLast] >= 0) {
         this.copyAnimSlot(this.breakLast + 116, var1 + 116);
      }

      this.breakAnim[var1] = this.breakAnim[this.breakLast];
      breakX[var1] = breakX[this.breakLast];
      this.breakY[var1] = this.breakY[this.breakLast];
      this.breakTileX[var1] = this.breakTileX[this.breakLast];
      breakTileY[var1] = breakTileY[this.breakLast];
      this.breakTilesW[var1] = this.breakTilesW[this.breakLast];
      this.breakTilesH[var1] = this.breakTilesH[this.breakLast];
      this.breakAnim[this.breakLast] = -1;
      if (this.breakLast >= 0) {
         this.breakLast--;
      }
   }

   private void e(int var1, int var2) {
      this.clearCellFlags(var1 + 1, var2, 128);
      this.clearCellFlags(var1 - 1, var2 + 1, 128);
      this.clearCellFlags(var1 - 1, var2, 128);
      this.clearCellFlags(var1 + 1, var2 + 1, 128);
      this.clearCellFlags(var1, var2 + 1, 128);
      this.clearCellFlags(var1, var2, 128);
   }

   // $VF: renamed from: r (int) void
   private void removePickup(int var1) {
      int var2 = var1 << 2;
      int var3 = this.pickupLast << 2;
      System.arraycopy(pickupTrailX, var3, pickupTrailX, var2, 4);
      System.arraycopy(pickupTrailY, var3, pickupTrailY, var2, 4);
      pickupAge[var1] = pickupAge[this.pickupLast];
      pickupVelX[var1] = pickupVelX[this.pickupLast];
      pickupVelY[var1] = pickupVelY[this.pickupLast];
      pickupTarget[var1] = pickupTarget[this.pickupLast];
      pickupKind[var1] = pickupKind[this.pickupLast];
      pickupAmount[var1] = pickupAmount[this.pickupLast];
      if (this.pickupLast >= 0) {
         this.pickupLast--;
      }
   }

   // $VF: renamed from: b (int, int, int, int) void
   private void spawnPickup(int var1, int var2, int var3, int var4) {
      if (var4 != 0 && (var3 != 0 || orbsCollected < this.orbBudget)) {
         if (var3 == 1 || var3 == 2) {
            var4 <<= 3;
         }

         byte var5;
         byte var6;
         if (var4 > 60) {
            var5 = 18;
            var6 = 9;
         } else {
            var5 = 6;
            var6 = 3;
         }

         int var7 = -1;
         if (var3 == 3) {
            for (int var8 = this.enemyCount; var8 >= 0; var8--) {
               if (rectsOverlap(
                  cameraX - 64,
                  cameraY - 64,
                  368,
                  448,
                  enemyX[var8] - this.enemyWidth[var8],
                  this.enemyY[var8] - this.enemyHeight[var8],
                  this.enemyWidth[var8] << 1,
                  this.enemyHeight[var8]
               )) {
                  if (++var7 >= this.P.length) {
                     var7 = this.P.length - 1;
                     break;
                  }

                  this.P[var7] = var8;
               }
            }

            if (var7 == -1) {
               return;
            }

            magic -= 256;
            if (magic <= 0) {
               magic = 0;
               this.resetWeaponMode();
            }
         }

         int var13 = 0;
         boolean var9 = false;

         while (!var9) {
            this.randomValue = random.nextInt();
            if (this.pickupLast >= 18 && var4 > 0) {
               var9 = true;
               pickupAmount[this.pickupLast - 1] = pickupAmount[this.pickupLast - 1] + var4;
               var4 = 0;
            } else {
               this.pickupLast++;
               int var10 = this.pickupLast << 2;
               int var11 = (this.randomValue & 128) > 0 ? 1 : -1;
               int var12 = var1 + var11 * (this.randomValue & 9);
               pickupTrailX[var10++] = var12;
               pickupTrailX[var10++] = var12;
               pickupTrailX[var10++] = var12;
               pickupTrailX[var10++] = var12;
               var10 -= 4;
               pickupVelX[this.pickupLast] = var11 * (this.randomValue & 7) << 8;
               var11 = (this.randomValue & 256) > 0 ? 1 : -1;
               var12 = var2 + var11 * (this.randomValue & 9) - 7;
               pickupTrailY[var10++] = var12;
               pickupTrailY[var10++] = var12;
               pickupTrailY[var10++] = var12;
               pickupTrailY[var10] = var12;
               pickupVelY[this.pickupLast] = (this.randomValue >> 3 & 7) << 8;
               pickupKind[this.pickupLast] = var3;
               pickupAge[this.pickupLast] = 0;
               if (var3 == 3) {
                  pickupTarget[this.pickupLast] = this.P[var13];
                  if (++var13 > var7) {
                     var13 = 0;
                  }
               } else {
                  pickupTarget[this.pickupLast] = -1;
               }

               if (var4 > 24) {
                  pickupAmount[this.pickupLast] = var5;
                  var4 -= var5;
               } else {
                  pickupAmount[this.pickupLast] = var6;
                  var4 -= var6;
               }

               if (var4 < 0) {
                  pickupAmount[this.pickupLast] = pickupAmount[this.pickupLast] + var4;
                  var4 = 0;
                  var9 = true;
               }
            }
         }
      }
   }

   private void t() {
      this.blockedHit = false;
      this.grappledEnemy = -1;
      qteActive = false;
      this.aR = false;
      this.blocking = false;
      this.resetWeaponMode();
      this.gw = this.playerX / 16;
      gx = this.playerY / 16;
      this.health = this.maxHealth;
      this.healthPrev = this.health;
      cameraX = this.playerX - 120 - ((facingRight ? 1 : -1) * 240 >> 2);
      cameraY = this.playerY - 266;
      this.aO = cameraX << 8;
      this.aP = cameraY << 8;
      this.activeArena = -1;
      this.arenaBannerTimer = -1;
      this.setPlayerAction(0);
      this.startAnim(133, 1025, 4);
      this.getFrameBounds(this.fH, 135, 0, 0, 0, this.P);
      this.subY = this.playerY % 16;
      subX = this.playerX % 16;
      playerWidth = this.P[2] >> 1;
      this.playerHeight = this.P[3];
      this.hg = this.playerHeight / 16;
      this.frontExtent = playerWidth >> 1;
      this.backExtent = -(playerWidth >> 1);
   }

   // $VF: renamed from: f (int, int) void
   private void movePlayer(int var1, int var2) {
      if (super.animDeltaX != 0) {
         this.playerX = this.playerX
            + ((!facingRight || super.animDeltaX <= 0) && (facingRight || super.animDeltaX >= 0) ? this.backExtent : this.frontExtent - 1);
      }

      if (super.animDeltaY < 0) {
         this.playerY = this.playerY - this.playerHeight;
      } else {
         this.playerY--;
      }

      int var5 = var1;
      int var6 = this.playerTileY();
      subX = this.playerX - var5 * 16 << 8;
      if (subX <= 0) {
         var5--;
         subX += 4096;
      } else if (subX >= 4096) {
         var5++;
         subX -= 4096;
      }

      this.subY = this.playerY - var6 * 16 << 8;
      if (super.animDeltaX != 0) {
         this.playerX = this.playerX
            - ((!facingRight || super.animDeltaX <= 0) && (facingRight || super.animDeltaX >= 0) ? this.backExtent : this.frontExtent - 1);
      }

      if (super.animDeltaY < 0) {
         this.playerY = this.playerY + this.playerHeight;
      } else {
         this.playerY++;
      }

      int var7 = (super.animDeltaX > 0 ? super.animDeltaX : -super.animDeltaX) << 8;
      int var8 = (super.animDeltaY > 0 ? super.animDeltaY : -super.animDeltaY) << 8;
      int var9 = var7;
      int var10 = var8;
      this.canMoveX = true;
      canMoveY = true;
      if (var7 > var8) {
         if (var7 > 4096) {
            var8 = (var8 * 16 << 8) / var7;
            var7 = 4096;
         }
      } else if (var8 > 4096) {
         var7 = (var7 * 16 << 8) / var8;
         var8 = 4096;
      }

      int var3;
      if ((!facingRight || super.animDeltaX <= 0) && (facingRight || super.animDeltaX >= 0)) {
         var3 = -var7;
      } else {
         var3 = var7;
      }

      int var4 = super.animDeltaY > 0 ? var8 : -var8;
      int var11 = 0;
      int var12 = 0;
      this.moveAccumX = 0;
      this.moveAccumY = 0;

      while (var11 < var9 || var12 < var10) {
         subX += var3;
         this.subY += var4;
         if (subX >= 4096) {
            subX -= 4096;
            var5++;
         } else if (subX < 0) {
            subX += 4096;
            var5--;
         }

         if (this.subY >= 4096) {
            this.subY -= 4096;
            var6++;
         } else if (this.subY < 0) {
            this.subY += 4096;
            var6--;
         }

         this.onPlayerCell(var5, var6);
         if ((this.getCellFlags(var5, var6) & 32) == 0) {
            this.arenaBannerTimer = -1;
            this.activeArena = -1;
         } else {
            this.iB = true;
            if (this.activeArena == -1) {
               for (int var13 = 0; var13 < this.arenaTileX.length; var13++) {
                  if (pointInRect(var1, var2, this.arenaTileX[var13], this.arenaTileY[var13], this.arenaWidth[var13], arenaHeight[var13])) {
                     if (arenaKills[var13] < this.arenaKillsNeeded[var13] && this.arenaKillsNeeded[var13] > 0 && this.arenaBannerTimer <= 0) {
                        this.activeArena = var13;
                        this.arenaBannerTimer = 2000;
                        if (arenaKills[0] < this.arenaKillsNeeded[var13]) {
                           gM = true;
                        }
                     } else {
                        this.arenaBannerTimer = -1;
                        this.activeArena = -1;
                        this.iB = true;
                     }
                  }
               }
            }
         }

         if (this.canMoveX) {
            this.moveAccumX += var3;
            var11 += var7;
         } else {
            subX -= var3;
            var9 = var11;
            if ((this.getCellFlags(var1, var2) & 1) != 0 && !this.blockedByWall) {
               this.moveAccumX = 0;
               if ((!facingRight || super.animDeltaX <= 0) && (facingRight || super.animDeltaX >= 0)) {
                  this.playerX = var1 * 16 + (playerWidth >> 1);
               } else {
                  this.playerX = (var1 + 1) * 16 - (playerWidth >> 1);
               }
            }
         }

         if (canMoveY) {
            this.moveAccumY += var4;
            var12 += var8;
         } else {
            this.subY -= var4;
            var10 = var12;
            if (super.animDeltaY < 0 && this.climbing) {
               var6 += this.hg + 1;
            }
         }
      }

      this.playerX = this.playerX + (this.moveAccumX >> 8);
      this.playerY = this.playerY + (this.moveAccumY >> 8);
      if (var11 > var9) {
         int var14 = var11 - var9 >> 8;
         this.playerX -= var3 > 0 ? var14 : -var14;
      }

      if (var12 > var10) {
         int var15 = var12 - var10 >> 8;
         this.playerY -= var4 > 0 ? var15 : -var15;
      }

      if (!this.canMoveX) {
         if (subX < 0) {
            var5--;
         } else if (subX > 16) {
            var5++;
         }
      }

      this.gw = var5;
      gx = var6;
   }

   // $VF: renamed from: u () boolean
   private boolean tryPushCrate() {
      int var1 = (!facingRight || this.playerAction != 22) && (facingRight || this.playerAction != 23) ? -1 : 1;
      byte var2 = 0;
      if (this.gl == 1) {
         var2 = 1;
      }

      int var3 = pushTileX[pushedCrate] + (var1 < 0 ? this.pushTilesW[pushedCrate] - 1 : 0);
      int var4 = gx;
      int var5 = this.pushTilesH[pushedCrate];
      if (this.playerAction == 23 && var5 <= this.hg) {
         var5 = this.hg + 1;
      }

      for (int var6 = 0; var6 < var5; var6++) {
         if ((this.getCellFlags(var3 + var1 + var1, var4 - var6) & 1) != 0) {
            return false;
         }

         if (this.playerAction == 23
            && (
               (this.getCellFlags(var3 + var1 + var1 + var1, var4 - var6) & 1) != 0
                  || (this.getCellFlags(var3 + var1 + var1 + var1 + var1, var4 - var6) & 1) != 0
            )) {
            return false;
         }

         if ((this.getCellFlags(var3 + var1 * (this.pushTilesW[pushedCrate] + var2), var4 - var6) & 1) != 0) {
            var2 = 0;
         }
      }

      if (this.playerAction == 23 && (this.getCellFlags(this.gw + var1, var4) & 1) != 0) {
         return false;
      }

      for (int var8 = 0; var8 < this.pushTilesW[pushedCrate]; var8++) {
         for (int var7 = 0; var7 < this.pushTilesH[pushedCrate]; var7++) {
            this.clearCellFlags(pushTileX[pushedCrate] + var8, var4 - var7, 1);
            this.clearCellFlags(pushTileX[pushedCrate] + var8, var4 - var7, 512);
            if (eW[pushedCrate]) {
               this.clearCellFlags(pushTileX[pushedCrate] + var8, var4 - var7, 8);
            }
         }
      }

      pushTileX[pushedCrate] = pushTileX[pushedCrate] + (var1 > 0 ? 1 + var2 : -(1 + var2));

      for (int var9 = 0; var9 < this.pushTilesW[pushedCrate]; var9++) {
         for (int var10 = 0; var10 < this.pushTilesH[pushedCrate]; var10++) {
            this.setCellFlags(pushTileX[pushedCrate] + var9, var4 - var10, 1);
            this.setCellFlags(pushTileX[pushedCrate] + var9, var4 - var10, 512);
            if (eW[pushedCrate]) {
               this.setCellFlags(var3 + var9 + var2 + this.pushTilesW[pushedCrate] * var1, var4 - var10, 8);
            }
         }
      }

      this.hG = true;
      this.startAnim(111 + pushedCrate, 6144, this.pushAnim[pushedCrate] + (3 << var2));
      return true;
   }

   // $VF: renamed from: g (int, int) void
   private void onPlayerCell(int var1, int var2) {
      boolean var3 = facingRight && super.animDeltaX > 0 || !facingRight && super.animDeltaX < 0;
      if ((this.getCellFlags(var1, var2) & 1024) != 0) {
         this.checkpointX = var1 * 16;
         this.checkpointY = var2 * 16;
         this.checkpointFacingRight = facingRight;
      }

      if ((this.getCellFlags(var1, var2) & 256) != 0) {
         int var4 = var2;

         while ((this.getCellFlags(var1, var4) & 256) != 0) {
            var4--;
         }

         var4++;

         for (int var5 = 0; var5 < this.triggerGateId.length; var5++) {
            if (this.triggerTileX[var5] == var1 && triggerTileY[var5] == var4) {
               for (int var6 = 0; var6 < gateOpen.length; var6++) {
                  if (this.gateId[var6] == this.triggerGateId[var5]) {
                     gateOpen[var6] = !gateOpen[var6];
                  }
               }
               break;
            }
         }

         while ((this.getCellFlags(var1, var4) & 256) != 0) {
            this.clearCellFlags(var1, var4, 256);
            var4++;
         }
      }

      if ((this.getCellFlags(var1, var2) & 4) != 0) {
         int var15 = var2;

         for (int var22 = 0; (this.getCellFlags(var1, var2 - var22) & 4) != 0; var22++) {
            var15--;
            this.clearCellFlags(var1, var2 - var22, 4);
         }

         int var23 = 1;
         var15++;

         while ((this.getCellFlags(var1, var2 + var23) & 4) != 0) {
            this.clearCellFlags(var1, var2 + var23, 4);
            var23++;
         }

         int var26 = -1;

         for (int var7 = 0; var7 < this.waveTileX.length; var7++) {
            if (this.waveTileX[var7] == var1 && this.waveTileY[var7] == var15) {
               var26 = var7;
               break;
            }
         }

         for (int var29 = 0; var29 <= this.enemyCount; var29++) {
            enemyRespawns[var29] = ed[var29];
            if (this.waveEnemyX[this.enemyWaveSlot[var29] + var26 * 15] != 0) {
               enemyHomeX[var29] = this.waveEnemyX[this.enemyWaveSlot[var29] + var26 * 15] * 16;
               enemyHomeY[var29] = this.waveEnemyY[this.enemyWaveSlot[var29] + var26 * 15] * 16;
               es[var29] = this.waveEnemyFacing[this.enemyWaveSlot[var29] + var26 * 15];
               if (!rectsOverlap(
                  cameraX - 64,
                  cameraY - 64,
                  368,
                  448,
                  enemyX[var29] - this.enemyWidth[var29],
                  this.enemyY[var29] - this.enemyHeight[var29],
                  this.enemyWidth[var29] << 1,
                  this.enemyHeight[var29]
               )) {
                  enemyHealth[var29] = enemyMaxHealth[var29];
                  enemyX[var29] = enemyHomeX[var29];
                  this.enemyY[var29] = enemyHomeY[var29];
                  this.clearCellFlags(this.enemyTileX[var29], this.enemyTileY[var29] - 1, 2);
                  this.enemyTileX[var29] = enemyX[var29] / 16;
                  this.enemyTileY[var29] = this.enemyY[var29] / 16;
                  this.setCellFlags(this.enemyTileX[var29], this.enemyTileY[var29] - 1, 2);
                  switch (this.enemyClass[var29]) {
                     case 1:
                        this.setEnemyAction(0, var29);
                        break;
                     case 2:
                        this.setEnemyAction(0, var29);
                        break;
                     case 3:
                        this.setEnemyAction(0, var29);
                  }
               }
            }
         }
      }

      int var17 = 0;
      this.landed = false;

      for (int var24 = this.playerHeight; var24 > 0; var24 -= 16) {
         if (var2 < mapHeight) {
            if (var2 - var17 < 0 || var2 - var17 >= mapHeight) {
               this.canMoveX = false;
               break;
            }

            if (var24 > 0) {
               if (this.canMoveX && var1 >= 0) {
                  this.canMoveX = (this.getCellFlags(var1, var2 - var17) & 1) == 0;
               } else {
                  this.canMoveX = false;
               }

               if (!this.canMoveX) {
                  if (this.playerAction != 22 && this.pushing && (this.getCellFlags(var1, var2 - var17) & 512) != 0) {
                     int var27 = facingRight ? 1 : -1;
                     int var30 = 0;

                     while ((this.getCellFlags(var1 + var30, var2) & 512) != 0 && !facingRight) {
                        var30 += var27;
                     }

                     var30 += facingRight ? 0 : 1;

                     for (int var8 = pushLast; var8 >= 0; var8--) {
                        if (pushTileX[var8] == var1 + var30 && this.pushTileY[var8] == var2 + 1) {
                           this.blockedByWall = true;
                           this.playerX = var1 * 16 + (!facingRight ? this.frontExtent : this.backExtent);
                           this.setPlayerAction(21);
                           pushedCrate = var8;
                        }
                     }
                  }
                  break;
               }
            }

            if (var1 < 0 || var1 >= mapWidth) {
               this.canMoveX = false;
            }

            if (super.animDeltaY >= 0) {
               var17++;
            } else {
               var17--;
            }

            if (hangingOnBar && var24 - 16 <= 0 && super.animDeltaY == 0 && (this.getCellFlags(var1, var2 - var17) & 16) == 0) {
               this.canMoveX = false;
               this.setPlayerAction(26);
               this.playerY++;
            }
         }
      }

      int var25 = var1;
      if (super.animDeltaX == 0 && super.animDeltaY != 0) {
         var25 += facingRight ? 1 : -1;
      }

      if (super.animDeltaY >= 0) {
         var17 = this.hg;
         if (this.subY < 2048) {
            var17++;
         }
      } else {
         var17 = 0;
      }

      int var28 = var2 - var17;
      int var32 = facingRight ? -1 : 1;
      if (this.health > 0
         && !this.attacking
         && (this.getCellFlags(var25, var28 - 1) & 1) == 0
         && ((this.getCellFlags(var25, var28) & 1) != 0 || this.atLadderTop)
         && (this.getCellFlags(var25 + var32, var28) & 1) == 0
         && (this.getCellFlags(var25 + var32, var28 - 1) & 1) == 0
         && (this.getCellFlags(var25 + var32, var28 + this.hg) & 1) == 0
         && super.animDeltaY != 0
         && (!this.climbing || this.atLadderTop)
         && !ledgeHanging
         && !this.onGround
         && state != 105) {
         if (this.atLadderTop && super.animDeltaY < 0) {
            this.setPlayerAction(38);
            int var34 = 0;
            if ((this.getCellFlags(var25, var2) & 1) == 0) {
               var34++;
            }

            this.playerY = (var2 + var34) * 16 + this.playerHeight;
         } else if (this.playerAction != 40 && !this.climbing) {
            this.setPlayerAction(37);
            this.playerY = (var2 - var17) * 16 + this.playerHeight;
         }

         this.moveAccumY = 0;
         if (!facingRight) {
            var25++;
         }

         this.playerX = var25 * 16 + (facingRight ? -(playerWidth >> 1) : playerWidth >> 1);
         this.moveAccumX = 0;
         canMoveY = false;
         this.canMoveX = false;
      } else {
         if (!this.canMoveX && super.animDeltaX != 0) {
            var17 = var3 ? -1 : 1;
         } else {
            var17 = 0;
         }

         int var33 = var2;
         int var9;
         if ((var9 = super.animDeltaY > 0 ? var33 - this.hg : var33 + this.hg) < 0) {
            var9 = 0;
         }

         if (super.animDeltaY != 0) {
            boolean var10 = false;

            for (int var11 = playerWidth; var11 > 0; var11 -= 16) {
               if (var1 + var17 >= 0 && var1 + var17 < mapWidth) {
                  if (canMoveY) {
                     canMoveY = (this.getCellFlags(var1 + var17, var33) & 1) == 0;
                     if (((this.getCellFlags(var1 + var17, var9) & 16) != 0 || (this.getCellFlags(var1 + var17, var9) & 8192) != 0)
                        && playerAnim != 121
                        && this.playerAction != 38
                        && this.health > 0) {
                        if ((this.getCellFlags(var1 + var17, var9) & 8192) != 0 && playerAnim != 24 && playerAnim != 25 && !this.airAttacking) {
                           this.setPlayerAction(120);
                           this.playerY = (var9 + 1) * 16 + this.playerHeight;
                           canMoveY = false;
                           this.moveAccumY = 0;
                           this.onPlatform = true;
                        } else if ((this.getCellFlags(var1 + var17, var9) & 16) != 0) {
                           this.playerY = (var9 + 1) * 16 + this.playerHeight;
                           canMoveY = false;
                           this.moveAccumY = 0;
                           this.setPlayerAction(45);
                        }
                     }
                  }

                  if (!canMoveY && super.animDeltaY > 0 && !hangingOnBar && this.playerAction != 38) {
                     this.playerY = var2 * 16;
                     this.moveAccumY = 0;
                     this.landed = true;
                     int var12 = var1;
                     if ((!facingRight || super.animDeltaX <= 0) && (facingRight || super.animDeltaX >= 0)) {
                        if (super.animDeltaX != 0) {
                           var12++;
                        }
                     } else {
                        var12--;
                     }

                     if ((this.getCellFlags(var12, var2) & 16384) != 0 && playerAnim != 48) {
                        this.setPlayerAction(50);
                     } else if (this.playerAction != 77
                        && this.playerAction != 95
                        && this.playerAction != 108
                        && this.playerAction != 114
                        && this.playerAction != 115
                        && this.playerAction != 116
                        && this.playerAction != 60
                        && playerAnim != 120
                        && playerAnim != 121
                        && playerAnim != 48) {
                        if (qteActive) {
                           this.abortQte();
                        }

                        this.setPlayerAction(27);
                        if (this.fallSpeed >= 4) {
                           this.cameraShake = this.fallSpeed;
                        }
                     } else if (this.playerAction == 77 || this.playerAction == 60) {
                        this.onGround = true;
                        this.cameraShake += 6;
                        this.stopSounds();
                        this.playSound(2);
                     } else if (this.playerAction == 95 && !var10) {
                        var10 = true;
                        this.spawnPickup(this.playerX, this.playerY - this.playerHeight + (this.playerHeight >> 2), 3, fL[magicCLevel]);
                     }
                  }

                  if (!canMoveY && (playerAnim == 24 || playerAnim == 25) && super.animDeltaY < 0) {
                     this.setPlayerAction(99);
                     break;
                  }

                  if (var33 < 0 || var33 >= mapHeight) {
                     canMoveY = false;
                  }

                  if (super.animDeltaX == 0) {
                     break;
                  }
               }

               var17 = var3 ? --var17 : ++var17;
            }
         }

         if (this.climbing && this.playerAction != 38) {
            int var35 = var1;
            var1 += facingRight ? 1 : -1;
            if ((this.getCellFlags(var1, var33) & 8) == 0) {
               canMoveY = false;
               this.playerY = (var33 + (super.animDeltaY < 0 ? 1 : 0)) * 16 + (super.animDeltaY < 0 ? this.playerHeight : 0);
               if (super.animDeltaY >= 0 || (this.getCellFlags(var1, var33) & 1) != 0) {
                  if (playerAnim == 34) {
                     this.setPlayerAction(26);
                  } else {
                     this.setPlayerAction(33);
                  }

                  canMoveY = false;
               }

               if (super.animDeltaY < 0) {
                  this.atLadderTop = true;
               }
            }

            var1 = var35;
         }

         if (!this.canMoveX && super.animDeltaX != 0 && !this.landed && this.playerAction != 38 && !this.climbing && !this.airAttacking) {
            if ((!facingRight || super.animDeltaX <= 0 || subX << 8 <= 16 - (playerWidth >> 1))
               && (facingRight || super.animDeltaX >= 0 || subX >> 8 >= playerWidth >> 1)) {
               if (!facingRight && super.animDeltaX > 0 && subX << 8 > 16 - (playerWidth >> 1)
                  || facingRight && super.animDeltaX < 0 && subX >> 8 < playerWidth >> 1) {
                  this.playerX = (var1 + 1) * 16 - this.backExtent;
                  this.blockedByWall = true;
                  if ((this.getCellFlags(var1, var33 + (super.animDeltaY > 0 ? -1 : 1)) & 8) != 0
                     && (this.getCellFlags(var1, var33 + (super.animDeltaY > 0 ? -this.hg : this.hg)) & 8) != 0
                     && super.animDeltaY != 0) {
                     this.setPlayerAction(33);
                  }
               }
            } else {
               this.playerX = var1 * 16 - this.frontExtent;
               this.blockedByWall = true;
               if ((this.getCellFlags(var1, var33 + (super.animDeltaY > 0 ? -1 : 1)) & 8) != 0
                  && (this.getCellFlags(var1, var33 + (super.animDeltaY > 0 ? -this.hg : this.hg)) & 8) != 0
                  && this.playerAction != 38
                  && super.animDeltaY != 0) {
                  this.setPlayerAction(33);
               }
            }

            this.moveAccumX = 0;
         }

         if (!this.canMoveX && super.animDeltaX != 0) {
            if (this.playerAction == 9) {
               this.setPlayerAction(0);
            } else if (this.playerAction == 51) {
               this.setPlayerAction(50);
            }
         }

         if (qteActive && (!this.canMoveX || !canMoveY)) {
            this.abortQte();
         }
      }
   }

   // $VF: renamed from: h (int, int) int
   private int getCellFlags(int var1, int var2) {
      return var1 >= 0 && var1 < mapWidth && var2 >= 0 && var2 < mapHeight ? this.cellFlags[var1 + mapWidth * var2] : 65;
   }

   // $VF: renamed from: b (int, int, int) void
   private void setCellFlags(int var1, int var2, int var3) {
      if (var1 >= 0 && var1 < mapWidth && var2 >= 0 && var2 < mapHeight) {
         this.cellFlags[var1 + mapWidth * var2] = (short)(this.cellFlags[var1 + mapWidth * var2] | var3);
      }
   }

   // $VF: renamed from: c (int, int, int) void
   private void clearCellFlags(int var1, int var2, int var3) {
      if (var1 >= 0 && var1 < mapWidth && var2 >= 0 && var2 < mapHeight) {
         this.cellFlags[var1 + mapWidth * var2] = (short)(this.cellFlags[var1 + mapWidth * var2] & ~var3);
      }
   }

   // $VF: renamed from: v () void
   private void abortQte() {
      if (this.enemyClass[this.grappledEnemy] == 1) {
         this.setEnemyAction(0, this.grappledEnemy);
      } else if (this.enemyClass[this.grappledEnemy] == 2) {
         this.setEnemyAction(0, this.grappledEnemy);
      } else if (this.enemyClass[this.grappledEnemy] == 3) {
         this.setEnemyAction(0, this.grappledEnemy);
      }

      this.setPlayerAction(26);
      qteActive = false;
      this.slowMotionShift = 0;
   }

   // $VF: renamed from: i (int, int) void
   private void setEnemyAction(int var1, int var2) {
      this.enemyClimbing[var2] = this.enemyClass[var2] == 1
         && (var1 == 13 || var1 == 17 || var1 == 23 || var1 == 12 || var1 == 15 || var1 == 16 || var1 == 14 || var1 == 21);
      this.eh[var2] = this.enemyClass[var2] == 1 && (var1 == 19 || var1 == 18 || var1 == 26 || var1 == 20);
      if (this.enemyClass[var2] == 1) {
         if (var1 == 5 || var1 == 6 || var1 == 16 || var1 == 15) {
            this.dS[var2] = 0;
         } else if (var1 == 8 || var1 == 9 || var1 == 10 || var1 == 24) {
            this.enemyStatus[var2] = 0;
            this.dS[var2] = 1;
         } else if (var1 == 2 || var1 == 7) {
            this.dS[var2] = 2;
         } else if (var1 != 11 && var1 != 21 && var1 != 3) {
            if (var1 == 1) {
               eu[var2] = random.nextInt() & 511;
            }

            this.dS[var2] = -1;
         } else {
            this.dS[var2] = 3;
         }
      } else if (this.enemyClass[var2] == 2) {
         if (var1 != 7 && var1 != 12 && var1 != 13) {
            this.dS[var2] = -1;
         } else {
            this.enemyStatus[var2] = 0;
            this.dS[var2] = 1;
         }

         if (var1 == 1) {
            eu[var2] = random.nextInt() & 511;
         }
      } else if (this.enemyClass[var2] == 3) {
         if (var1 != 7 && var1 != 13 && var1 != 17 && var1 != 16) {
            this.dS[var2] = -1;
         } else {
            this.enemyStatus[var2] = 0;
            this.dS[var2] = 1;
         }

         if (var1 == 1) {
            eu[var2] = random.nextInt() & 511;
         }
      }

      if ((this.grappledEnemy != -1 && var2 != this.grappledEnemy || this.cameraPanX > 0) && !this.eh[var2] && var1 != 7 && var1 != 11) {
         switch (this.enemyClass[var2]) {
            case 1:
               if (this.enemyAction[var2] == 0 && var1 != 27) {
                  return;
               }

               if (var1 != 27) {
                  var1 = 0;
               }
               break;
            case 2:
               if ((this.enemyAction[var2] == 0 || this.enemyAction[var2] == 12 || this.enemyAction[var2] == 10) && var1 != 14) {
                  return;
               }

               if (var1 != 14) {
                  var1 = 0;
               }
               break;
            case 3:
               if ((this.enemyAction[var2] == 0 || this.enemyAction[var2] == 12 || this.enemyAction[var2] == 11) && var1 != 18) {
                  return;
               }

               if (var1 != 18) {
                  var1 = 0;
               }
         }
      }

      this.enemyAction[var2] = var1;
      if (this.enemyClass[var2] == 1) {
         if (this.dA) {
            this.startAnim(85 + var2, 18432, var1);
         } else {
            this.startAnim(85 + var2, 4096, var1);
         }
      } else if (this.enemyClass[var2] == 2) {
         if (this.dB) {
            this.startAnim(85 + var2, 16384, var1);
         } else {
            this.startAnim(85 + var2, 17408, var1);
         }
      } else {
         if (this.enemyClass[var2] == 3) {
            if (bossIndex == var2 && this.finalBossIndex != var2) {
               this.startAnim(85 + var2, 13312, var1);
               return;
            }

            if (this.finalBossIndex == var2) {
               this.startAnim(85 + var2, 14336, var1);
               return;
            }

            this.startAnim(85 + var2, 15360, var1);
         }
      }
   }

   private void w() {
      this.setPlayerAction(14);
      this.setEnemyAction(24, this.grappledEnemy);
      this.spawnPickup(
         enemyX[this.grappledEnemy], this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1), 1, this.enemyDropAmount[this.grappledEnemy]
      );
      enemyHealth[this.grappledEnemy] = -1;
      this.spawnEffect(
         enemyX[this.grappledEnemy] - (this.enemyWidth[this.grappledEnemy] >> 1),
         this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1),
         22,
         !facingRight ? 2 : 0,
         false
      );
   }

   // $VF: renamed from: s (int) void
   private void setPlayerAction(int var1) {
      this.fO = 0;
      this.fP = 0;
      gc = 0;
      this.playerAction = var1;
      hf = 0;
      boolean var2 = false;
      if (var1 == 22 && magicModeA) {
         var1 = 20;
      }

      if ((var1 == 5 || var1 == 8) && magicModeA) {
         var1++;
      } else if (var1 == 100 && magicModeA) {
         var1++;
      } else if (var1 == 38 && magicModeA) {
         var1 = 39;
      } else if (var1 == 27 && magicModeA) {
         var1 = 29;
      } else if (var1 == 3) {
         if (magicModeA) {
            var1 = 4;
         }
      } else if (var1 == 97 && magicModeA) {
         var1 = 98;
      }

      if (var1 != 14
         && var1 != 88
         && var1 != 90
         && var1 != 89
         && var1 != 91
         && var1 != 108
         && var1 != 109
         && var1 != 114
         && var1 != 116
         && var1 != 115
         && var1 != 113
         && var1 != 93
         && var1 != 92
         && var1 != 12
         && var1 != 13
         && var1 != 117
         && (this.finalBossIndex != this.grappledEnemy || this.grappledEnemy >= 0 && this.enemyAction[this.grappledEnemy] != 16)) {
         qteActive = false;
         this.slowMotionShift = 0;
         this.grappledEnemy = -1;
         this.iB = true;
      }

      if (var1 != 31) {
         this.openingChest = false;
      } else {
         this.openingChest = true;
      }

      if (var1 == 0) {
         this.attacking = false;
         if (this.onPlatform) {
            var1 = 10;
         } else if (magicModeA) {
            var1 = 1;
         }
      } else if (var1 == 31 && magicModeA) {
         var1 = 32;
      } else if (var1 != 54 && var1 != 36 && var1 != 47) {
         this.attackQueued = false;
         this.attacking = false;
         this.fN = false;
      } else {
         this.attacking = true;
         var2 = true;
         if (!this.climbing && !hangingOnBar) {
            if (this.fN) {
               this.fN = false;
               this.comboIndex = 0;
            }

            if (magicModeA) {
               var1 = 72 + this.comboIndex;
               if (this.comboIndex < this.magicAComboLength) {
                  this.comboIndex++;
               } else {
                  this.attackQueued = false;
                  var1 = 77;
                  this.playerAction = 77;
                  this.fN = true;
               }
            } else {
               var1 += this.comboIndex;
               if (this.comboIndex < bladesComboLength) {
                  this.comboIndex++;
               } else {
                  var1 = 60;
                  this.fN = true;
                  this.attackQueued = false;
                  this.playerAction = 60;
               }
            }
         }
      }

      gh = var1 == 7 || var1 == 5 || var1 == 8 || var1 == 6 || var1 == 101 || var1 == 119 || var1 == 118 || var1 == 100 || var1 == 5;
      if (var1 == 67) {
         var2 = true;
         this.airAttacking = true;
         if (magicModeA) {
            var1 = 83 + this.comboIndex;
            if (this.comboIndex > 3 - (bladesLevel < 3 ? 1 : 0)) {
               var1 = 83;
               this.comboIndex = 0;
            } else if (this.comboIndex == 2 - (bladesLevel < 3 ? 1 : 0)) {
               var1 = 85;
            }
         } else {
            var1 = 67 + this.comboIndex;
            if (this.comboIndex >= 3 - (bladesLevel < 3 ? 1 : 0)) {
               var1 = 67;
               this.comboIndex = 0;
            } else if (this.comboIndex == 2 - (bladesLevel < 3 ? 1 : 0)) {
               var1 = 69;
            }
         }

         this.comboIndex++;
      } else {
         this.airAttacking = false;
      }

      if (var1 == 91 || var1 == 92 || var1 == 93) {
         this.airAttacking = true;
      }

      if (!this.airAttacking && !this.attacking) {
         this.comboIndex = 0;
      }

      if (var1 != 35 && var1 != 34 && var1 != 36 && var1 != 33) {
         this.climbing = false;
         this.atLadderTop = false;
      } else {
         this.climbing = true;
      }

      hangingOnBar = var1 == 45 || var1 == 47 || var1 == 46 || var1 == 119 || var1 == 118;
      if (var1 == 9) {
         this.pushing = true;
         if (this.onPlatform) {
            var1 = 11;
         }
      } else {
         this.pushing = false;
      }

      if (var1 != 37 && var1 != 40) {
         ledgeHanging = false;
         this.atLadderTop = false;
      } else {
         ledgeHanging = true;
      }

      this.grabbingLedge = var1 == 30;
      this.gk = var1 == 21 || var1 == 22 || var1 == 23 || var1 == 20;
      this.balancing = var1 == 50 || var1 == 51;
      if (var1 != 15 && var1 != 17) {
         this.usingSwitch = false;
      } else {
         this.usingSwitch = true;
         if (magicModeA) {
            var1++;
         }
      }

      if (var2 && !hangingOnBar && this.health > 0) {
         int var3 = this.randomValue & 1;
         this.playSound(3 + var3);
      }

      playerAnim = var1;
      this.startAnim(135, 28672, var1);
   }

   // $VF: renamed from: t (int) boolean
   private boolean stepSlot(int var1) {
      return this.stepAnim(var1, this.frameDelta);
   }

   // $VF: renamed from: x () int
   private int playerTileX() {
      return this.playerX / 16;
   }

   // $VF: renamed from: y () int
   private int playerTileY() {
      int var1;
      return (var1 = this.playerY / 16) > mapHeight ? mapHeight : var1;
   }

   // $VF: renamed from: z () void
   private void updateGameplay() {
      int var1 = this.playerTileX();
      int var2 = (this.subY >> 8) + 1 >= 16 ? gx + 1 : gx;
      int var3 = 0;
      int var4 = this.playerX - (playerWidth >> 1);
      int var5 = this.playerY;
      this.onGround = gg;
      boolean var6 = this.onPlatform;
      if (!this.onGround) {
         this.onPlatform = (this.getCellFlags(var1, var2) & 8192) != 0 && playerAnim != 99 && playerAnim != 24 && playerAnim != 25 && playerAnim != 26;
         this.onGround = (this.getCellFlags(var1, var2) & 1) != 0;
         this.gA = (this.getCellFlags(var1, var2 - 1) & 2048) != 0;
         gB = (this.getCellFlags(var1, var2 - 1) & 4096) != 0;
      }

      if (this.onPlatform && !var6) {
         if (this.pushing) {
            this.onGround = true;
            this.setPlayerAction(9);
         }
      } else if (!this.onPlatform && var6 && this.pushing) {
         this.setPlayerAction(9);
      }

      boolean var7 = this.stepAnim(135, this.frameDelta);
      gc = gc + this.frameDelta;
      if (!qteActive && (this.getCellFlags(var1, var2) & 128) > 0) {
         for (int var8 = cv; var8 >= 0; var8--) {
            if (this.cl[var8] == var1 && cm[var8] == var2) {
               this.cs = this.cn[var8];
               this.ct = this.cn[var8];
               String var9 = this.getString(this.cs);
               if (!this.aR && var9.charAt(0) == '@') {
                  this.aR = true;
                  this.aS = Engine.parseIntOr(var9.substring(2, 3), 0) == 1;
                  this.aT = Engine.parseIntOr(var9.substring(1, 2), 0);
                  this.startAnim(131, 1027, this.aT);
               } else if (this.aR) {
                  int var67 = super.animDeltaX;
                  int var11 = super.animDeltaY;
                  this.stepSlot(131);
                  super.animDeltaX = var67;
                  super.animDeltaY = var11;
               } else {
                  state = 101;
                  this.setBarTargets(79, 25, 35, 35);
                  if (state != 105) {
                     this.cu = this.ct + this.co[var8];

                     for (int var10 = cv; var10 >= 0; var10--) {
                        if (this.cn[var10] == this.cs) {
                           this.clearCellFlags(this.cl[var10], cm[var10], 128);
                        }
                     }

                     panelText = new String[2];
                     this.startDialogueLine();
                  }
               }
            }
         }
      } else {
         this.aR = false;
      }

      if (this.playerAction != 52 && this.playerAction != 53) {
         if (this.playerAction == 26) {
            super.animDeltaY = super.animDeltaY + this.fallSpeed;
            this.fallTimer = this.fallTimer + this.frameDelta;
            if (this.fallTimer > 200) {
               this.fallTimer -= 200;
               this.fallSpeed = this.fallSpeed + (this.fallSpeed >= 8 ? 0 : 4);
            }
         } else {
            this.fallTimer = 0;
            this.fallSpeed = 0;
         }

         if (super.animDeltaY < 0 && this.playerAction != 60) {
            this.onGround = false;
         }

         if (state != 105 && state != 108 && state != 101) {
            if (!qteActive && this.grappledEnemy < 0 && this.cameraPanX < 0) {
               switch (this.heldKey) {
                  case 1:
                     if (this.climbing
                        && this.playerAction == 33
                        && (
                           (this.getCellFlags(this.gw + (facingRight ? 1 : -1), gx - this.hg - 1) & 8) != 0
                              || (this.getCellFlags(this.gw + (facingRight ? 1 : -1), gx - this.hg - 1) & 1) == 0
                        )) {
                        this.setPlayerAction(35);
                     }
                     break;
                  case 2:
                     if (!this.climbing && !ledgeHanging && !this.gk && this.playerAction != 44 && this.playerAction != 22 && this.playerAction != 38) {
                        if (hangingOnBar && !gh && !this.attacking) {
                           if (this.playerAction != 46) {
                              this.setPlayerAction(46);
                           }

                           facingRight = false;
                        } else {
                           if (this.playerAction == 0 || this.playerAction == 3) {
                              facingRight = false;
                              if ((
                                    (this.getCellFlags(this.gw - 1, gx) & 1) != 0
                                       || (this.getCellFlags(this.gw, gx) & 1) != 0
                                       || (this.getCellFlags(this.gw - 1, gx - 1) & 1) != 0
                                       || (this.getCellFlags(this.gw - 1, gx - 2) & 1) != 0
                                 )
                                 && (this.getCellFlags(this.gw - 1, gx) & 512) == 0) {
                                 if ((this.getCellFlags(this.gw - 1, gx) & 1) != 0
                                    || (this.getCellFlags(this.gw, gx) & 1) != 0
                                    || (this.getCellFlags(this.gw - 1, gx - 1) & 1) != 0
                                    || (this.getCellFlags(this.gw - 1, gx - 2) & 1) != 0) {
                                    this.playerX = (this.gw + ((this.getCellFlags(this.gw, gx) & 1) != 0 ? 1 : 0)) * 16 + (playerWidth >> 1);
                                 }
                              } else {
                                 if ((this.getCellFlags(this.gw - 1, gx) & 512) != 0) {
                                    int var32 = (this.getCellFlags(this.gw, gx) & 512) != 0 ? 1 : 0;
                                    this.playerX = (this.gw + var32) * 16 + (playerWidth >> 1);
                                 }

                                 this.setPlayerAction(9);
                                 this.blocking = false;
                              }
                           } else if (this.playerAction == 50) {
                              facingRight = false;
                              if ((this.getCellFlags(this.gw - 1, gx) & 1) == 0) {
                                 this.setPlayerAction(51);
                              }
                           }

                           if (this.playerAction == 9 || this.playerAction == 51) {
                              facingRight = false;
                           }
                        }
                     }
                  case 3:
                  case 4:
                  case 7:
                  case 8:
                  default:
                     break;
                  case 5:
                     if (!this.climbing && !ledgeHanging && !this.gk && this.playerAction != 44 && this.playerAction != 22 && this.playerAction != 38) {
                        if (hangingOnBar && !gh && !this.attacking) {
                           if (this.playerAction != 46) {
                              this.setPlayerAction(46);
                           }

                           facingRight = true;
                        } else {
                           if (this.playerAction == 0 || this.playerAction == 3) {
                              if ((
                                    (this.getCellFlags(this.gw + 1, gx - 1) & 1) != 0
                                       || (this.getCellFlags(this.gw + 1, gx) & 1) != 0
                                       || (this.getCellFlags(this.gw + 1, gx - 2) & 1) != 0
                                 )
                                 && (this.getCellFlags(this.gw + 1, gx) & 512) == 0) {
                                 if ((this.getCellFlags(this.gw + 1, gx) & 1) != 0) {
                                    this.playerX = (this.gw + 1) * 16 - (playerWidth >> 1);
                                 }
                              } else {
                                 if ((this.getCellFlags(this.gw + 1, gx) & 512) != 0) {
                                    int var31 = (this.getCellFlags(this.gw, gx) & 512) != 0 ? -1 : 0;
                                    this.playerX = (this.gw + 1 + var31) * 16 - (playerWidth >> 1);
                                 }

                                 this.setPlayerAction(9);
                                 this.blocking = false;
                              }

                              facingRight = true;
                           } else if (this.playerAction == 50) {
                              facingRight = true;
                              if ((this.getCellFlags(this.gw + 1, gx) & 1) == 0) {
                                 this.setPlayerAction(51);
                              }
                           }

                           if (this.playerAction == 9 || this.playerAction == 51) {
                              facingRight = true;
                           }
                        }
                     }
                     break;
                  case 6:
                     if (this.climbing) {
                        if (this.playerAction == 33) {
                           if ((this.getCellFlags(this.gw + (facingRight ? 1 : -1), gx + 1) & 8) != 0) {
                              this.setPlayerAction(34);
                           } else {
                              this.setPlayerAction(26);
                           }
                        }
                     } else if (hangingOnBar) {
                        this.setPlayerAction(26);
                     } else if (playerAnim == 120) {
                        this.setPlayerAction(26);
                        this.playerY += 16;
                     }
               }
            }

            if (!qteActive && this.cameraPanX < 0) {
               switch (this.pressedKey) {
                  case 1:
                     if (this.grappledEnemy >= 0) {
                        break;
                     }

                     if (this.playerAction == 21) {
                        this.setPlayerAction(24);
                     } else if (playerAnim == 120) {
                        this.setPlayerAction(121);
                     } else if (!this.grabbingLedge && facingRight && this.gA) {
                        this.setPlayerAction(30);
                     } else if (!this.grabbingLedge && !facingRight && gB) {
                        this.setPlayerAction(30);
                     } else if (!this.openingChest
                        && !this.usingSwitch
                        && !this.climbing
                        && !hangingOnBar
                        && !ledgeHanging
                        && (this.onGround || this.onPlatform)
                        && !this.gk
                        && this.grappledEnemy < 0
                        && !this.attacking) {
                        if (this.blocking) {
                           this.blocking = false;
                           this.setPlayerAction(0);
                        } else if (this.playerAction != 24
                           && this.playerAction != 26
                           && this.playerAction != 3
                           && this.playerAction != 38
                           && this.playerAction != 30) {
                           this.setPlayerAction(24);
                        }
                     } else if (ledgeHanging) {
                        this.setPlayerAction(38);
                     } else if (this.playerAction == 24) {
                        this.setPlayerAction(25);
                     }
                     break;
                  case 2:
                     if (this.gk && this.playerAction == 21) {
                        if (facingRight) {
                           this.setPlayerAction(23);
                           this.gl = 0;
                        } else {
                           this.setPlayerAction(22);
                           this.gl = 1;
                        }

                        if (!this.tryPushCrate()) {
                           this.setPlayerAction(21);
                        } else {
                           this.playSound(3);
                        }
                     } else if (this.grappledEnemy >= 0
                        && enemyHealth[this.grappledEnemy] > 0
                        && this.enemyClass[this.grappledEnemy] == 1
                        && this.playerAction != 14
                        && !this.climbing) {
                        facingRight = false;
                        this.enemyFacingRight[this.grappledEnemy] = false;
                        this.w();
                     } else if (facingRight && (this.attacking || this.airAttacking) && this.grappledEnemy < 0 && !this.climbing) {
                        short var40 = 150;
                        if (magicModeA && this.comboIndex > this.magicAComboLength || !magicModeA && this.comboIndex > bladesComboLength) {
                           var40 = 600;
                        }

                        if (attackTimer > var40) {
                           this.attackQueued = true;
                           this.queuedFacingRight = false;
                        }
                     } else if (this.climbing && !this.attacking) {
                        if (facingRight) {
                           facingRight = false;
                           this.setPlayerAction(44);
                        }
                     } else if (ledgeHanging && !facingRight) {
                        this.setPlayerAction(38);
                     }
                     break;
                  case 5:
                     if (this.gk && this.playerAction == 21) {
                        if (facingRight) {
                           this.setPlayerAction(22);
                           this.gl = 1;
                        } else {
                           this.setPlayerAction(23);
                           this.gl = 0;
                        }

                        if (!this.tryPushCrate()) {
                           this.setPlayerAction(21);
                        } else {
                           this.playSound(3);
                        }
                     } else if (this.grappledEnemy >= 0
                        && enemyHealth[this.grappledEnemy] > 0
                        && this.enemyClass[this.grappledEnemy] == 1
                        && this.playerAction != 14
                        && !this.climbing) {
                        facingRight = true;
                        this.enemyFacingRight[this.grappledEnemy] = true;
                        this.w();
                     } else if (!facingRight && (this.attacking || this.airAttacking) && this.grappledEnemy < 0 && !this.climbing && !hangingOnBar) {
                        short var39 = 150;
                        if (magicModeA && this.comboIndex > this.magicAComboLength || !magicModeA && this.comboIndex > bladesComboLength) {
                           var39 = 600;
                        }

                        if (attackTimer > var39) {
                           this.attackQueued = true;
                           this.queuedFacingRight = true;
                        }
                     } else if (this.climbing && !this.attacking) {
                        if (!facingRight) {
                           facingRight = true;
                           this.setPlayerAction(44);
                        }
                     } else if (ledgeHanging && facingRight) {
                        this.setPlayerAction(38);
                     }
                     break;
                  case 6:
                     if (!this.attacking && (this.playerAction == 0 || this.playerAction == 9) && this.onGround) {
                        for (int var36 = this.enemyCount; var36 >= 0; var36--) {
                           if ((this.playerY == this.enemyY[var36] || this.playerY + 1 == this.enemyY[var36])
                              && rectsOverlap(
                                 enemyX[var36] - (this.enemyWidth[var36] >> 1) - (playerWidth >> 1),
                                 this.enemyY[var36],
                                 this.enemyWidth[var36] + playerWidth,
                                 this.enemyHeight[var36],
                                 this.playerX,
                                 this.playerY,
                                 playerWidth,
                                 this.playerHeight
                              )) {
                              boolean var56 = true;

                              for (int var69 = this.gw; var69 < this.enemyTileX[var36]; var69++) {
                                 var56 &= (this.getCellFlags(var69, gx) & 1) == 0;
                              }

                              if ((this.enemyStatus[var36] <= 0 || this.enemyClass[var36] == 3 && this.enemyAction[var36] == 12) && var56) {
                                 this.iB = true;
                                 if (bossIndex != var36
                                    && this.enemyClass[var36] == 1
                                    && enemyHealth[var36] > 0
                                    && enemyHealth[var36] < enemyMaxHealth[var36] >> 1) {
                                    this.grappledEnemy = var36;
                                    this.playerX = enemyX[var36];
                                    this.enemyFacingRight[var36] = facingRight;
                                    super.animDeltaX = 0;
                                    this.setPlayerAction(12);
                                    this.setEnemyAction(22, var36);
                                    break;
                                 }

                                 if (this.enemyClass[var36] != 2
                                    || (enemyHealth[var36] <= 0 || enemyHealth[var36] >= enemyMaxHealth[var36] >> 1) && this.enemyAction[var36] != 12) {
                                    if (this.enemyClass[var36] != 3
                                       || (enemyHealth[var36] <= 0 || enemyHealth[var36] >= enemyMaxHealth[var36] >> 1)
                                          && (this.enemyAction[var36] != 12 || bossIndex == var36)) {
                                       continue;
                                    }

                                    this.grappledEnemy = var36;
                                    if (this.enemyAction[var36] == 12 && bossIndex != var36) {
                                       this.setPlayerAction(113);
                                       this.spawnPickup(
                                          enemyX[this.grappledEnemy],
                                          this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1),
                                          0,
                                          this.enemyDropAmount[this.grappledEnemy] >> 1
                                       );
                                       this.playerX = enemyX[var36];
                                       facingRight = this.enemyFacingRight[var36];
                                       this.enemyStatus[var36] = 0;
                                       enemyHealth[var36] = -1;
                                       this.setEnemyAction(16, var36);
                                       break;
                                    }

                                    this.playerX = enemyX[var36];
                                    this.enemyFacingRight[var36] = facingRight;
                                    super.animDeltaX = 0;
                                    this.slowMotionShift = 1;
                                    qteActive = true;
                                    this.qteProgress = 0;
                                    this.qteRequired = 3;
                                    this.qteDirection = this.randomQteDirection();
                                    this.startAnim(131, 1027, qteKeyAnims[this.qteDirection]);
                                    if (bossIndex != var36 && this.finalBossIndex != var36) {
                                       this.setPlayerAction(91);
                                       this.setEnemyAction(14, var36);
                                    } else if (this.finalBossIndex == var36) {
                                       this.setPlayerAction(114);
                                       this.setEnemyAction(13, var36);
                                    } else if (bossIndex == var36) {
                                       this.setPlayerAction(108);
                                       this.setEnemyAction(13, var36);
                                    }

                                    this.enemyFacingRight[var36] = !facingRight;
                                    break;
                                 }

                                 this.grappledEnemy = var36;
                                 if (this.enemyAction[var36] != 12 && this.enemyAction[var36] != 10) {
                                    this.playerX = enemyX[var36];
                                    this.enemyFacingRight[var36] = facingRight;
                                    super.animDeltaX = 0;
                                    this.setPlayerAction(88);
                                    this.slowMotionShift = 1;
                                    qteActive = true;
                                    this.qteRequired = 2;
                                    this.qteProgress = 0;
                                    this.qteDirection = this.randomQteDirection();
                                    this.startAnim(131, 1027, qteKeyAnims[this.qteDirection]);
                                    this.setEnemyAction(11, var36);
                                    this.enemyFacingRight[var36] = !facingRight;
                                    break;
                                 }

                                 this.setPlayerAction(117);
                                 this.playerX = enemyX[var36];
                                 enemyHealth[var36] = -1;
                                 this.spawnPickup(
                                    enemyX[this.grappledEnemy],
                                    this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1),
                                    2,
                                    this.enemyDropAmount[this.grappledEnemy] >> 1
                                 );
                                 this.setEnemyAction(13, var36);
                                 break;
                              }
                           }
                        }
                     }

                     if (ledgeHanging) {
                        this.setPlayerAction(40);
                        this.playerY++;
                     } else if (this.playerAction == 0) {
                        if (facingRight) {
                           for (int var37 = this.chestLast; var37 >= 0; var37--) {
                              if (!chestOpened[var37]
                                 && rectsOverlap(
                                    this.chestX[var37],
                                    this.chestY[var37],
                                    this.chestWidth,
                                    this.chestHeight,
                                    this.playerX - this.frontExtent,
                                    this.playerY,
                                    playerWidth,
                                    this.playerHeight
                                 )
                                 && Math.abs(this.playerY - this.chestY[var37]) < 8) {
                                 this.setPlayerAction(31);
                                 this.playerX = this.chestX[var37] + (this.chestWidth >> 1);
                              }
                           }
                        }

                        for (int var38 = this.switchLast; var38 >= 0; var38--) {
                           if (facingRight
                              && this.switchIsLever[var38]
                              && rectsOverlap(
                                 this.playerX - (playerWidth >> 1),
                                 this.playerY - this.playerHeight,
                                 playerWidth,
                                 this.playerHeight,
                                 this.switchX[var38] - 16,
                                 switchY[var38],
                                 32,
                                 16
                              )) {
                              this.hO = var38;
                              this.hP = var38;
                              if (!this.switchOn[var38]) {
                                 this.setPlayerAction(15);
                              } else {
                                 this.setPlayerAction(17);
                              }

                              this.playerX = this.switchX[var38];
                              this.switchOn[var38] = !this.switchOn[var38];
                           }
                        }
                     }

                     if (this.onGround
                        && !this.balancing
                        && !this.gk
                        && !this.usingSwitch
                        && !this.openingChest
                        && this.grappledEnemy < 0
                        && playerAnim != 24
                        && playerAnim != 48
                        && playerAnim != 30) {
                        this.blocking = true;
                        this.setPlayerAction(3);
                     }

                     if (this.onPlatform) {
                        this.setPlayerAction(26);
                     }
                     break;
                  case 8:
                     if (!this.openingChest && !this.gk && !this.usingSwitch && this.onGround && this.grappledEnemy < 0 && !this.onPlatform) {
                        if (this.playerAction != 0 && this.playerAction != 3) {
                           if (!this.onGround || magicModeB || this.magicModeC || magicModeA && magic < 0) {
                              break;
                           }

                           short var35 = 150;
                           if (magicModeA && this.comboIndex > this.magicAComboLength || !magicModeA && this.comboIndex > bladesComboLength) {
                              var35 = 600;
                           }

                           if (attackTimer > var35) {
                              this.attackQueued = true;
                           }
                        } else {
                           this.blocking = false;
                           var7 = true;
                           if (magicModeB && magic > magicBLevel + 1 << 2) {
                              this.setPlayerAction(94);
                           } else if (this.magicModeC && magic > 256 && this.pickupLast < 10) {
                              this.setPlayerAction(95);
                              this.resetWeaponMode();
                           } else {
                              magicModeB = false;
                              this.magicModeC = false;
                              if (!magicModeA || magic <= 0) {
                                 this.resetWeaponMode();
                              }

                              this.queuedFacingRight = facingRight;
                              if (!magicModeA || magic > 0) {
                                 this.setPlayerAction(54);
                              }
                           }
                        }
                     } else if (this.grappledEnemy >= 0 && enemyHealth[this.grappledEnemy] > 0) {
                        if (this.enemyClass[this.grappledEnemy] == 1) {
                           this.setPlayerAction(13);
                           this.setEnemyAction(10, this.grappledEnemy);
                           this.spawnPickup(
                              enemyX[this.grappledEnemy],
                              this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1),
                              0,
                              this.enemyDropAmount[this.grappledEnemy]
                           );
                           enemyHealth[this.grappledEnemy] = -1;
                        } else if (this.enemyClass[this.grappledEnemy] != 2) {
                        }
                     } else if (!this.onGround
                        && !this.onPlatform
                        && !this.climbing
                        && !hangingOnBar
                        && playerAnim != 120
                        && playerAnim != 121
                        && !this.attacking
                        && this.playerAction != 37) {
                        if (magicModeA && magic <= 0 || magicModeB || this.magicModeC) {
                           this.resetWeaponMode();
                        }

                        if (!this.airAttacking) {
                           this.queuedFacingRight = facingRight;
                           this.setPlayerAction(67);
                        } else {
                           short var34 = 150;
                           if (magicModeA && this.comboIndex > this.magicAComboLength || !magicModeA && this.comboIndex > bladesComboLength) {
                              var34 = 600;
                           }

                           if (attackTimer > var34) {
                              this.attackQueued = true;
                           }
                        }
                     } else if (hangingOnBar && !this.attacking) {
                        if (this.playerAction != 47) {
                           this.resetWeaponMode();
                           this.setPlayerAction(47);
                        }
                     } else if (this.climbing && !this.attacking) {
                        this.resetWeaponMode();
                        this.setPlayerAction(36);
                     } else if (playerAnim == 21) {
                        this.setPlayerAction(0);
                     }
                     break;
                  case 27:
                  case 42:
                     if (!this.blocking && !this.attacking) {
                        this.weaponMode++;
                        if (this.weaponMode > 3) {
                           this.weaponMode = 0;
                        }

                        magicModeA = this.weaponMode == 1;
                        magicModeB = this.weaponMode == 2;
                        this.magicModeC = this.weaponMode == 3;
                        if (this.playerAction == 0) {
                           this.setPlayerAction(0);
                        }
                     }
                     break;
                  case 29:
                     if (this.topBarTarget == this.topBar) {
                        this.af = this.topBarTarget >> 8;
                        this.ag = this.bottomBarTarget >> 8;
                        this.J = state;
                        this.setBarTargets(halfHeight, halfHeight, 35, 35);
                        state = 102;
                        pauseMenuIndex = 4;
                     }
                     break;
                  case 35:
                     this.bi = false;
                     state = 106;
               }

               if (this.cheatsEnabled) {
                  if (this.pressedKey == 55) {
                     this.health = -1;
                  }

                  if (this.pressedKey == 48) {
                     this.C = !this.C;
                  }

                  if (this.pressedKey == 57) {
                     this.health = this.maxHealth;
                  }

                  if (this.pressedKey == 51) {
                     this.D = !this.D;
                  }
               }
            } else if (this.cameraPanX < 0) {
               boolean var33 = false;
               int var55 = super.animDeltaX;
               int var68 = super.animDeltaY;
               this.stepSlot(131);
               super.animDeltaX = var55;
               super.animDeltaY = var68;
               if (this.qteProgress >= 0 && this.qteProgress < this.qteRequired) {
                  switch (this.pressedKey) {
                     case 1:
                        if (this.qteDirection == 0) {
                           var33 = true;
                        }
                        break;
                     case 2:
                        if (this.qteDirection == 1) {
                           var33 = true;
                        }
                     case 3:
                     case 4:
                     case 7:
                     default:
                        break;
                     case 5:
                        if (this.qteDirection == 3) {
                           var33 = true;
                        }
                        break;
                     case 6:
                        if (this.qteDirection == 4) {
                           var33 = true;
                        }
                        break;
                     case 8:
                        if (this.qteDirection == 2) {
                           var33 = true;
                        }
                  }

                  if (var33) {
                     int var79 = this.randomQteDirection();
                     this.qteDirection = var79;
                     this.qteProgress++;
                     this.startAnim(131, 1027, qteKeyAnims[this.qteDirection]);
                  } else if (this.pressedKey != 0 && this.pressedKey != 27 && this.pressedKey != 29 && this.pressedKey != 4 && this.pressedKey != 9) {
                     this.qteProgress = -1;
                  }
               }
            }

            if (this.heldKey != 6 && this.blocking) {
               this.blocking = false;
               this.setPlayerAction(0);
            }

            if (this.heldKey != 2 && this.heldKey != 5) {
               if (this.playerAction == 9) {
                  this.setPlayerAction(0);
               } else if (this.playerAction == 46) {
                  this.setPlayerAction(45);
               } else if (this.balancing && this.playerAction != 50) {
                  this.setPlayerAction(50);
               }
            }

            if (this.heldKey != 1 && playerAnim == 35 || this.heldKey != 6 && playerAnim == 34) {
               this.setPlayerAction(33);
            }

            if ((this.heldKey != 8 || magic <= 0) && this.playerAction == 94) {
               this.setPlayerAction(0);
               if (magic <= 0) {
                  magic = 0;
               }

               this.resetWeaponMode();
            }

            if (this.heldKey == 8 && this.playerAction == 94) {
               magic -= 12;
            }

            if (!this.onGround
               && !this.onPlatform
               && !this.airAttacking
               && !hangingOnBar
               && !gg
               && this.playerAction != 26
               && this.playerAction != 99
               && this.playerAction != 48
               && (this.comboIndex != 5 && this.comboIndex != 6 && this.comboIndex != this.magicAComboLength || !magicModeA)
               && !this.grabbingLedge
               && var7) {
               if ((this.playerAction != 24 && this.playerAction != 25 && this.playerAction != 44 && this.playerAction != 38 || var7)
                  && (
                     this.playerAction == 24
                        || this.playerAction == 25
                        || this.playerAction == 44
                        || this.playerAction == 40
                        || this.playerAction == 38
                        || this.playerAction == 108
                        || this.playerAction == 114
                        || this.playerAction == 116
                        || this.playerAction == 115
                        || playerAnim == 121
                        || playerAnim == 120
                        || ledgeHanging
                        || this.climbing
                        || hangingOnBar
                  )) {
                  if ((this.playerAction == 47 || this.playerAction == 118 || this.playerAction == 119) && !var7) {
                     this.setPlayerAction(45);
                  } else if (this.onGround && this.playerAction != 24 && this.playerAction != 26) {
                     this.setPlayerAction(0);
                  }
               } else {
                  this.setPlayerAction(26);
               }
            } else if (!var7) {
               if (this.playerAction == 31 && !var7) {
                  for (int var41 = this.chestLast; var41 >= 0; var41--) {
                     if (!chestOpened[var41]
                        && rectsOverlap(
                           this.chestX[var41],
                           this.chestY[var41],
                           this.chestWidth,
                           this.chestHeight,
                           this.playerX - this.frontExtent,
                           this.playerY,
                           playerWidth,
                           this.playerHeight
                        )) {
                        this.chestAnim[var41] = this.chestAnim[var41] + 4;
                        this.setPlayerAction(31);
                        this.startAnim(121 + var41, 5120, this.chestAnim[var41]);
                        chestOpened[var41] = true;
                        this.e(this.gw, gx);
                     }
                  }
               }

               if (this.playerAction == 27 && !this.blocking && !magicModeA) {
                  this.setPlayerAction(28);
               } else if (this.playerAction == 27 && this.blocking) {
                  this.setPlayerAction(3);
               } else if (this.blocking && this.playerAction == 3) {
                  this.setPlayerAction(3);
               } else if (this.playerAction == 38) {
                  this.setPlayerAction(0);
               } else if (this.playerAction == 40) {
                  this.setPlayerAction(26);
               } else if (playerAnim == 121) {
                  if ((this.getCellFlags(this.gw, gx + 1) & 8192) != 0) {
                     this.onPlatform = true;
                  }

                  this.setPlayerAction(0);
               } else if (playerAnim == 120) {
                  this.playerY += 16;
                  this.setPlayerAction(26);
               } else if (this.playerAction == 47 || this.playerAction == 119 || this.playerAction == 118) {
                  this.setPlayerAction(45);
               } else if (this.playerAction == 97) {
                  this.setPlayerAction(3);
               } else if (this.playerAction == 88) {
                  if (this.qteProgress >= this.qteRequired) {
                     enemyHealth[this.grappledEnemy] = 1;
                     this.setPlayerAction(89);
                     this.spawnPickup(
                        enemyX[this.grappledEnemy],
                        this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1),
                        2,
                        this.enemyDropAmount[this.grappledEnemy] >> 1
                     );
                     this.setEnemyAction(10, this.grappledEnemy);
                  } else {
                     this.setPlayerAction(90);
                     this.setEnemyAction(0, this.grappledEnemy);
                  }

                  qteActive = false;
                  this.slowMotionShift = 0;
               } else if (this.attacking && this.attackQueued) {
                  facingRight = this.queuedFacingRight;
                  this.setPlayerAction(54);
                  attackTimer = 0;
                  this.attackQueued = false;
               } else if ((this.onGround || !this.attackQueued) && !qteActive) {
                  if (this.playerAction == 23) {
                     this.setPlayerAction(21);
                  } else if (this.playerAction == 36) {
                     this.setPlayerAction(33);
                  } else if (this.blocking && this.onGround
                     || !this.onGround
                        && (!this.onPlatform || playerAnim == 26 || playerAnim == 25 || playerAnim == 70 || this.airAttacking || playerAnim == 24)) {
                     if (this.playerAction != 26 && this.airAttacking) {
                        this.setPlayerAction(70);
                     } else if ((!this.onPlatform || playerAnim == 70) && !this.onGround && !hangingOnBar) {
                        this.setPlayerAction(26);
                     }
                  } else if (playerAnim == 48) {
                     this.setPlayerAction(50);
                  } else {
                     this.setPlayerAction(0);
                  }
               } else if (qteActive) {
                  qteActive = false;
                  this.slowMotionShift = 0;
                  this.attackQueued = false;
                  if (this.qteProgress >= this.qteRequired) {
                     if (bossIndex != this.grappledEnemy) {
                        enemyHealth[this.grappledEnemy] = 1;
                        this.setPlayerAction(92);
                        this.spawnPickup(
                           enemyX[this.grappledEnemy],
                           this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1),
                           1,
                           this.enemyDropAmount[this.grappledEnemy]
                        );
                        this.setEnemyAction(11, this.grappledEnemy);
                     } else if (this.finalBossIndex != this.grappledEnemy) {
                        this.setPlayerAction(109);
                        this.spawnPickup(
                           enemyX[this.grappledEnemy],
                           this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1),
                           2,
                           this.enemyDropAmount[this.grappledEnemy]
                        );
                        this.spawnPickup(
                           enemyX[this.grappledEnemy],
                           this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1),
                           1,
                           this.enemyDropAmount[this.grappledEnemy]
                        );
                        enemyHealth[this.grappledEnemy] = enemyMaxHealth[this.grappledEnemy];
                        if (this.levelIndex >= 4) {
                           this.setEnemyAction(14, this.grappledEnemy);
                        } else {
                           this.setEnemyAction(15, this.grappledEnemy);
                        }
                     } else if (this.finalBossIndex == this.grappledEnemy) {
                        this.setPlayerAction(115);
                        enemyHealth[this.grappledEnemy] = enemyMaxHealth[this.grappledEnemy];
                        this.enemyFacingRight[this.grappledEnemy] = facingRight;
                        this.spawnPickup(
                           enemyX[this.grappledEnemy],
                           this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1),
                           2,
                           this.enemyDropAmount[this.grappledEnemy]
                        );
                        this.spawnPickup(
                           enemyX[this.grappledEnemy],
                           this.enemyY[this.grappledEnemy] - (this.enemyHeight[this.grappledEnemy] >> 1),
                           1,
                           this.enemyDropAmount[this.grappledEnemy]
                        );
                        this.setEnemyAction(14, this.grappledEnemy);
                        this.finalBossPhase++;
                        if (this.finalBossPhase >= 3) {
                           this.playerInvulnerable = true;
                        }

                        if (this.finalBossPhase > 3) {
                           enemyHealth[this.grappledEnemy] = -1;
                        }
                     }
                  } else if (bossIndex != this.grappledEnemy) {
                     this.setPlayerAction(93);
                     this.setEnemyAction(0, this.grappledEnemy);
                  } else if (this.finalBossIndex != this.grappledEnemy) {
                     enemyHealth[this.grappledEnemy] = enemyMaxHealth[this.grappledEnemy];
                     this.setEnemyAction(0, this.grappledEnemy);
                     this.setPlayerAction(110);
                  } else if (this.finalBossIndex == this.grappledEnemy) {
                     this.setPlayerAction(116);
                     enemyHealth[this.grappledEnemy] = enemyMaxHealth[this.grappledEnemy];
                     this.enemyFacingRight[this.grappledEnemy] = facingRight;
                     this.setEnemyAction(12, this.grappledEnemy);
                  }
               } else {
                  this.setPlayerAction(67);
                  facingRight = this.queuedFacingRight;
                  this.attackQueued = false;
               }
            } else if (this.playerAction == 3 && !this.blocking) {
               this.setPlayerAction(28);
            }

            if (this.health <= 0 && this.grappledEnemy < 0 && (!this.gk || playerAnim == 21)) {
               if (!this.onGround && playerAnim != 26) {
                  this.setPlayerAction(26);
               } else if (this.onGround && playerAnim != 52 && playerAnim != 53) {
                  this.setPlayerAction(52);
                  this.health = 0;
               }
            }
         } else if (state == 105) {
            if (!this.onGround && !this.airAttacking && this.playerAction != 24 && !this.onPlatform && !hangingOnBar && !gg) {
               if (this.playerAction == 37) {
                  this.setPlayerAction(40);
                  this.playerY++;
               } else {
                  this.setPlayerAction(26);
               }
            }

            if (!var7 && this.playerAction != 26) {
               if (this.aY[this.ba + 1] != 0 || this.aZ[this.bb + 1] != 0 && this.dL >= 0) {
                  if (this.aY[this.ba + 1] == 0) {
                     this.setPlayerAction(this.aY[this.ba]);
                  } else {
                     this.ba++;
                     this.setPlayerAction(this.aY[this.ba]);
                  }
               } else {
                  this.advanceScript();
               }
            }

            if (this.pressedKey == 29 && this.topBarTarget == this.topBar && this.bottomBarTarget == this.bottomBar) {
               this.af = this.topBarTarget >> 8;
               this.ag = this.bottomBarTarget >> 8;
               this.J = state;
               state = 102;
               pauseMenuIndex = 4;
               this.setBarTargets(halfHeight, halfHeight, 35, 35);
            }
         }

         this.movePlayer(var1, var2);
      } else if (this.playerAction == 52 && !var7 && state != 108) {
         this.setBarTargets(halfHeight, halfHeight, 35, 35);
         state = 108;
         this.topBar = 0;
         this.bottomBar = 0;
      }

      if (!this.attacking && !this.airAttacking) {
         attackTimer = 0;
      } else {
         attackTimer = attackTimer + this.frameDelta;
      }

      if (this.C) {
         this.health = this.maxHealth;
      }

      if (this.health >= this.healthPrev && !this.blockedHit
         || this.grappledEnemy >= 0
         || gh
         || this.gk
         || this.attacking
         || playerAnim == 60
         || playerAnim == 77
         || this.health <= 0
         || !this.onGround
         || this.playerX == this.checkpointX && this.playerY == this.checkpointY) {
         if (hangingOnBar && this.health < this.healthPrev && !gh && !this.attacking) {
            if (this.hitFromRight == facingRight) {
               this.setPlayerAction(118);
            } else {
               this.setPlayerAction(119);
            }
         } else if (this.grappledEnemy >= 0) {
            this.health = this.healthPrev;
         }
      } else {
         this.blockedHit = false;
         if (!this.blocking && playerAnim != 27 && playerAnim != 28 && playerAnim != 29) {
            if (this.healthPrev - this.health > 50) {
               facingRight = this.hitFromRight;
               this.setPlayerAction(7);
            } else if (facingRight == this.hitFromRight) {
               this.setPlayerAction(5);
            } else {
               this.setPlayerAction(100);
            }
         } else if (this.blocking) {
            this.blockedHit = false;
            if (playerAnim != 97) {
               facingRight = this.hitFromRight;
               this.setPlayerAction(97);
            }
         }
      }

      this.healthPrev = this.health;
      if (playerAnim == 9
         && (
            (this.getCellFlags(this.gw + (facingRight ? 1 : -1), gx + 2) & 16384) != 0
               || (this.getCellFlags(this.gw + (facingRight ? 1 : -1), gx + 3) & 16384) != 0
         )) {
         this.setPlayerAction(48);
      }

      this.getBoxesAt(this.playerX, this.playerY, 135, this.playerBoxes, facingRight);
      this.comboTimer = this.comboTimer - this.frameDelta;
      if (this.comboTimer < 0 && comboHits != 0) {
         this.comboTimer = 0;
         comboHits = 0;
         this.iB = true;
      }

      if (this.activeArena != -1 && this.arenaKillsNeeded[this.activeArena] - arenaKills[this.activeArena] <= 3 && this.arenaBannerTimer > 0) {
         if (this.arenaKillsNeeded[this.activeArena] <= 0) {
            this.arenaBannerTimer = this.arenaBannerTimer - this.frameDelta;
            if (this.arenaBannerTimer <= 0) {
               this.iB = true;
            }
         }

         this.gL = this.gL - this.frameDelta;
         if (this.gL < 0) {
            this.gL = 200 - this.gL;
            gM = !gM;
            this.iB = true;
         }
      }

      for (int var42 = this.effectLast; var42 >= 0; var42--) {
         if (effectAnim[var42] >= 0 && !this.stepSlot(effectAnim[var42] + 0)) {
            this.removeEffect(var42);
         }
      }

      for (int var43 = this.chestLast; var43 >= 0; var43--) {
         if (this.chestAnim[var43] >= 0) {
            int var57 = this.chestX[var43] - cameraX;
            int var70 = this.chestY[var43] - cameraY;
            if (var57 + this.chestWidth >= 0
               && var70 + this.chestHeight >= 0
               && var57 - this.chestWidth <= 240
               && var70 - this.chestHeight <= 320
               && !this.stepSlot(var43 + 121)
               && chestReward[var43] != 0
               && this.chestAnim[var43] < 8
               && this.chestAnim[var43] >= 4) {
               this.chestAnim[var43] = this.chestAnim[var43] + 4;
               this.startAnim(121 + var43, 5120, this.chestAnim[var43]);
               if (chestReward[var43] == -1) {
                  chestFlags = chestFlags | 1 << this.levelIndex;
                  this.chestPopupTimer = 192;
                  this.healthChestsFound++;
                  state = 104;
                  this.chestPopupKind = 10;
                  this.startAnim(136, 1026, 0);
               } else if (chestReward[var43] == -2) {
                  chestFlags = chestFlags | 1 << this.levelIndex << 10;
                  this.chestPopupTimer = 192;
                  this.magicChestsFound++;
                  state = 104;
                  this.chestPopupKind = 9;
                  this.startAnim(136, 1026, 1);
               } else if (chestReward[var43] != 0) {
                  this.spawnPickup(
                     this.chestX[var43] + (this.chestWidth >> 1), this.chestY[var43] - this.chestHeight - 7, this.chestAnim[var43] - 8, chestReward[var43]
                  );
               }
            }
         }
      }

      for (int var44 = this.pickupLast; var44 >= 0; var44--) {
         int var58 = var44 << 2;
         int var71 = 9 * this.frameDelta;
         int var80 = pickupTarget[var44] < 0 ? this.playerX : enemyX[pickupTarget[var44]];
         int var12 = pickupTarget[var44] < 0 ? this.playerY : this.enemyY[pickupTarget[var44]];
         if (var80 < pickupTrailX[var58] && pickupVelX[var44] > -3584) {
            pickupVelX[var44] = pickupVelX[var44] - var71;
         } else if (var80 > pickupTrailX[var58] && pickupVelX[var44] < 3584) {
            pickupVelX[var44] = pickupVelX[var44] + var71;
         } else {
            pickupVelX[var44] = pickupVelX[var44] >> 2;
         }

         if (var12 - (this.playerHeight >> 1) + 8 < pickupTrailY[var58] && pickupVelY[var44] > -3584) {
            pickupVelY[var44] = pickupVelY[var44] - var71;
         } else if (var12 - (this.playerHeight >> 1) - 8 > pickupTrailY[var58] && pickupVelY[var44] < 3584) {
            pickupVelY[var44] = pickupVelY[var44] + var71;
         } else {
            pickupVelY[var44] = pickupVelY[var44] - (pickupVelY[var44] >> 3);
         }

         if (pointInRect(pickupTrailX[var58], pickupTrailY[var58], var80 + this.backExtent, var12 - this.playerHeight, playerWidth, this.playerHeight)) {
            if (pickupAge[var44] > 75) {
               if (pickupKind[var44] == 1) {
                  if (this.health < this.maxHealth && this.health > 0 && state != 108) {
                     this.health = this.health + pickupAmount[var44];
                     this.healthPrev = this.healthPrev + pickupAmount[var44];
                     if (this.health > this.maxHealth) {
                        this.health = this.maxHealth;
                        this.healthPrev = this.maxHealth;
                     }
                  }
               } else if (pickupKind[var44] == 2) {
                  magic = magic + pickupAmount[var44];
                  if (magic > this.maxMagic) {
                     magic = this.maxMagic;
                  }
               } else if (pickupKind[var44] == 0) {
                  this.upgradePoints = this.upgradePoints + pickupAmount[var44];
                  orbsCollected = orbsCollected + pickupAmount[var44];
                  if (orbsCollected > this.orbBudget) {
                     this.upgradePoints = this.upgradePoints + (this.orbBudget - orbsCollected);
                     orbsCollected = this.orbBudget;
                  }
               } else if (pickupKind[var44] == 3) {
                  int var13 = pickupTarget[var44];
                  byte var14 = this.enemyClass[var13];
                  if (var13 != this.grappledEnemy && (this.enemyClass[var13] != 1 || this.enemyAction[var13] != 22)) {
                     enemyHealth[pickupTarget[var44]] = enemyHealth[pickupTarget[var44]] - pickupAmount[var44];
                  }

                  pickupTarget[var44] = -1;
                  if (var13 != this.grappledEnemy
                     && enemyHealth[var13] <= 0
                     && this.dS[var13] != 1
                     && (this.enemyClass[var13] != 1 || this.enemyAction[var13] != 22)
                     && this.dS[var13] != 3) {
                     if (bossIndex == var13) {
                        enemyHealth[var13] = (enemyMaxHealth[var13] >> 1) - 1;
                     } else {
                        enemyHealth[var13] = -1;
                        if (this.enemyClimbing[var13] || this.eh[var13]) {
                           this.setEnemyAction(11, var13);
                        } else if (var14 == 1) {
                           this.setEnemyAction(8, var13);
                           this.spawnPickup(enemyX[var13], this.enemyY[var13] - (this.enemyHeight[var13] >> 1), 0, this.enemyDropAmount[var13]);
                        } else if (var14 == 2) {
                           this.setEnemyAction(7, var13);
                           this.spawnPickup(enemyX[var13], this.enemyY[var13] - (this.enemyHeight[var13] >> 1), 2, this.enemyDropAmount[var13]);
                        } else if (var14 == 3) {
                           if (this.enemyAction[var13] != 17) {
                              this.setEnemyAction(7, var13);
                           }

                           this.spawnPickup(enemyX[var13], this.enemyY[var13] - (this.enemyHeight[var13] >> 1), 0, this.enemyDropAmount[var13]);
                        }
                     }
                  } else if (this.enemyClass[var13] == 2 && this.enemyAction[var13] == 12) {
                     enemyHealth[var13] = 1;
                  }
               }

               this.removePickup(var44);
            } else {
               pickupAge[var44] = pickupAge[var44] + this.frameDelta;
            }
         }

         pickupTrailX[var58] = pickupTrailX[var58] + (pickupVelX[var44] >> 8);
         pickupTrailY[var58] = pickupTrailY[var58] + (pickupVelY[var44] >> 8);
         System.arraycopy(pickupTrailX, var58, pickupTrailX, var58 + 1, 3);
         System.arraycopy(pickupTrailY, var58, pickupTrailY, var58 + 1, 3);
      }

      for (int var45 = cd + 10; var45 >= 10; var45--) {
         var3 = var45 - 10;
         if (this.bY[var3] >= 0) {
            int var59 = bZ[var3] - cameraX;
            int var72 = ca[var3] - cameraY;
            if (var59 + this.cc[var3] >= 0 && var72 + this.cb[var3] >= 0 && var59 - this.cc[var3] <= 240 && var72 - this.cb[var3] <= 320) {
               if (!this.stepSlot(var45)) {
                  this.bY[var3] = -1;
               }

               bZ[var3] = bZ[var3] + super.animDeltaX;
               ca[var3] = ca[var3] + super.animDeltaY;
            }
         }
      }

      for (int var46 = ck + 40; var46 >= 40; var46--) {
         var3 = var46 - 40;
         if (this.cf[var3] >= 0) {
            int var60 = this.cg[var3] - cameraX;
            int var73 = ch[var3] - cameraY;
            if (var60 + this.cj[var3] >= 0 && var73 + this.ci[var3] >= 0 && var60 - this.cj[var3] <= 240 && var73 - this.ci[var3] <= 320) {
               if (!this.stepSlot(var46)) {
                  this.cf[var3] = -1;
               }

               this.cg[var3] = this.cg[var3] + super.animDeltaX;
               ch[var3] = ch[var3] + super.animDeltaY;
            }
         }
      }

      for (int var47 = bW + 30; var47 >= 30; var47--) {
         var3 = var47 - 30;
         if (this.bO[var3] >= 0) {
            if (!this.stepSlot(var47) && this.bV[var3]) {
               this.bO[var3] = -1;
               this.o(var3);
            } else if ((this.bO[var3] & 1) == 0
               && rectsOverlap(
                  bR[var3],
                  this.bS[var3],
                  this.bU[var3],
                  this.bT[var3],
                  this.playerX - this.frontExtent,
                  this.playerY - this.playerHeight,
                  playerWidth,
                  this.playerHeight
               )) {
               this.bO[var3]++;
               this.startAnim(var47, 5122, this.bO[var3]);
            }

            bP[var3] = bP[var3] + super.animDeltaX;
            this.bQ[var3] = this.bQ[var3] + super.animDeltaY;
         }
      }

      for (int var48 = this.switchLast; var48 >= 0; var48--) {
         int var61 = var48 + 106;
         int var74 = this.switchIsLever[var48] ? 4 : 0;
         boolean var81 = this.stepSlot(var61);
         int var86 = switchAnim[var48];
         if (!this.switchIsLever[var48]
            && (
               this.onGround
                     && rectsOverlap(
                        this.playerX - (playerWidth >> 1),
                        this.playerY - this.playerHeight,
                        playerWidth,
                        this.playerHeight,
                        this.switchX[var48],
                        switchY[var48],
                        16,
                        16
                     )
                  || (this.getCellFlags(this.switchTileX[var48], switchTileY[var48]) & 1) != 0
            )) {
            if (!this.switchOn[var48]) {
               this.switchOn[var48] = true;
               this.triggerSwitchTargets(var48);
               this.hP = var48;
            }
         } else if (!this.switchIsLever[var48] && this.switchOn[var48]) {
            this.switchOn[var48] = false;
            this.triggerSwitchTargets(var48);
            this.hP = var48;
         }

         if (!var81) {
            boolean var91 = false;
            if (!this.switchOn[var48]) {
               if (var86 == 1 + var74) {
                  switchAnim[var48] = 2 + var74;
                  this.startAnim(var61, 2050, switchAnim[var48]);
                  var91 = true;
               }
            } else if (var86 == 3 + var74) {
               switchAnim[var48] = 0 + var74;
               this.startAnim(var61, 2050, switchAnim[var48]);
               var91 = true;
            }

            if ((var86 == 3 + var74 || var86 == 1 + var74) && !var91 && this.hO >= 0) {
               this.triggerSwitchTargets(this.hO);
               this.hO = -1;
            }
         }

         if (this.hP >= 0 && this.hP == var48) {
            this.hP = -1;
            if (var86 == 0 + var74 || var86 == 3 + var74) {
               switchAnim[var48] = 1 + var74;
               this.startAnim(var61, 2050, switchAnim[var48]);
            } else if (var86 == 2 + var74 || var86 == 1 + var74) {
               switchAnim[var48] = 3 + var74;
               this.startAnim(var61, 2050, switchAnim[var48]);
            }
         }
      }

      for (int var49 = gateLast; var49 >= 0; var49--) {
         int var62 = var49 + 100;
         boolean var75 = this.stepSlot(var62);
         int var82 = gateAnim[var49] - (this.gateStyle[var49] << 2);
         if (var75) {
            if (gateOpen[var49]) {
               if (var82 == 2) {
                  gateAnim[var49] = (this.gateStyle[var49] << 2) + 3;
                  this.startAnim(var62, 2049, gateAnim[var49]);
               }
            } else if (var82 == 0) {
               gateAnim[var49] = (this.gateStyle[var49] << 2) + 1;
               this.startAnim(var62, 2049, gateAnim[var49]);
            }
         } else if (!gateOpen[var49]) {
            if (var82 == 3) {
               gateAnim[var49] = (this.gateStyle[var49] << 2) + 0;
               this.startAnim(var62, 2049, gateAnim[var49]);
            } else if (var82 == 1) {
               gateAnim[var49] = (this.gateStyle[var49] << 2) + 2;
               this.startAnim(var62, 2049, gateAnim[var49]);

               for (int var88 = 0; var88 < this.gateTilesH[var49]; var88++) {
                  for (int var93 = 0; var93 < gateTilesW[var49]; var93++) {
                     this.setCellFlags(gateTileX[var49] + var93, gateTileY[var49] - var88, 1);
                  }
               }
            }
         } else if (var82 == 1) {
            gateAnim[var49] = (this.gateStyle[var49] << 2) + 2;
            this.startAnim(var62, 2049, gateAnim[var49]);
         } else if (var82 == 3) {
            gateAnim[var49] = (this.gateStyle[var49] << 2) + 0;
            this.startAnim(var62, 2049, gateAnim[var49]);

            for (int var87 = 0; var87 < this.gateTilesH[var49]; var87++) {
               for (int var92 = 0; var92 < gateTilesW[var49]; var92++) {
                  this.clearCellFlags(gateTileX[var49] + var92, gateTileY[var49] - var87, 1);
               }
            }
         }
      }

      for (int var50 = this.dp + 60; var50 >= 60; var50--) {
         var3 = var50 - 60;
         if (this.di[var3] >= 0) {
            int var63 = dl[var3] - cameraX;
            int var76 = dm[var3] - cameraY;
            if (var63 + this.do_[var3] >= 0 && var76 + this.dn[var3] >= 0 && var63 - this.do_[var3] <= 240 && var76 - this.dn[var3] <= 320) {
               boolean var83 = !this.stepSlot(var50);
               if (this.dk[var3] == 2) {
                  dl[var3] = dl[var3] - super.animDeltaX;
                  dm[var3] = dm[var3] - super.animDeltaY;
               } else {
                  dl[var3] = dl[var3] + super.animDeltaX;
                  dm[var3] = dm[var3] + super.animDeltaY;
               }

               if (!this.attacking && !this.airAttacking && playerAnim != 30
                  || (this.di[var3] & 1) != 0
                  || this.playerBoxes[2] == 0 && this.playerBoxes[7] == 0
                  || !rectsOverlap(
                        this.playerBoxes[0],
                        this.playerBoxes[1],
                        this.playerBoxes[2],
                        this.playerBoxes[3],
                        dl[var3],
                        dm[var3] - this.dn[var3],
                        this.do_[var3],
                        this.dn[var3]
                     )
                     && !rectsOverlap(
                        this.playerBoxes[5],
                        this.playerBoxes[6],
                        this.playerBoxes[7],
                        this.playerBoxes[8],
                        dl[var3],
                        dm[var3] - this.dn[var3],
                        this.do_[var3],
                        this.dn[var3]
                     )) {
                  if (var83 && (this.di[var3] & 1) == 1) {
                     this.spawnDebris(var3, 1);
                     this.p(var3);
                  }
               } else {
                  this.di[var3]++;
                  this.startAnim(var50, 5121, this.di[var3]);
                  this.spawnPickup(dl[var3], dm[var3] - (this.dn[var3] >> 1), 1, 25);
               }
            }
         }
      }

      for (int var51 = pushLast; var51 >= 0; var51--) {
         if (this.hG) {
            this.hG = false;
         } else if (this.stepSlot(var51 + 111)) {
            this.pushX[var51] = this.pushX[var51]
               + ((!facingRight || this.playerAction != 22) && (facingRight || this.playerAction != 23) ? -super.animDeltaX : super.animDeltaX);
            this.pushY[var51] = this.pushY[var51] + super.animDeltaY;
         } else {
            this.startAnim(var51 + 111, 6144, this.pushAnim[var51]);
         }
      }

      for (int var52 = this.breakLast; var52 >= 0; var52--) {
         int var64 = breakX[var52] - cameraX;
         int var77 = this.breakY[var52] - cameraY;
         if (var64 + breakWidth[var52] >= 0
            && var77 + this.breakHeight[var52] >= 0
            && var64 - breakWidth[var52] <= 240
            && var77 - this.breakHeight[var52] <= 320) {
            for (int var84 = 0; var84 < this.playerBoxes.length; var84 += 5) {
               if ((this.breakAnim[var52] & 1) == 0) {
                  if (!magicModeB
                     && this.playerBoxes[var84 + 3] != 0
                     && rectsOverlap(
                        this.playerBoxes[var84],
                        this.playerBoxes[var84 + 1],
                        this.playerBoxes[var84 + 2],
                        this.playerBoxes[var84 + 3],
                        breakX[var52],
                        this.breakY[var52] - this.breakHeight[var52],
                        breakWidth[var52],
                        this.breakHeight[var52]
                     )) {
                     if (!this.stepAnim(116 + var52, 5)) {
                        this.spawnPickup(breakX[var52], this.breakY[var52] - (this.breakHeight[var52] >> 1), 0, 50);
                        this.spawnDebris(var52, 2);

                        for (int var89 = 1; var89 <= this.breakTilesH[var52]; var89++) {
                           for (int var94 = 0; var94 < this.breakTilesW[var52]; var94++) {
                              this.clearCellFlags(this.breakTileX[var52] + var94, breakTileY[var52] - var89, 1);
                           }
                        }

                        this.breakAnim[var52]++;
                        this.startAnim(var52 + 116, 2048, this.breakAnim[var52]);
                        this.removeBreakable(var52);
                     }

                     this.spawnEffect(
                        breakX[var52] + (facingRight ? 0 : breakWidth[var52]),
                        this.playerBoxes[1] + (this.playerBoxes[3] >> 1),
                        28,
                        !facingRight ? 2 : 0,
                        false
                     );
                  }
               } else {
                  this.stepAnim(116 + var52, this.frameDelta);
               }
            }
         }
      }

      for (int var53 = this.hazardLast + 70; var53 >= 70; var53--) {
         var3 = var53 - 70;
         if (this.hazardAnim[var3] >= 0) {
            boolean var65 = !this.stepSlot(var53);
            hazardX[var3] = hazardX[var3] + super.animDeltaX;
            this.hazardY[var3] = this.hazardY[var3] + super.animDeltaY;
            if (var65) {
               hazardX[var3] = this.hazardHomeX[var3];
               this.hazardY[var3] = this.hazardHomeY[var3];
               this.startAnim(var53, 6145, this.hazardAnim[var3]);
            }

            this.getBoxesAt(hazardX[var3], this.hazardY[var3], var53, enemyBoxes, true);
            if (this.grappledEnemy < 0
               && enemyBoxes[2] > 0
               && rectsOverlap(enemyBoxes[0], enemyBoxes[1], enemyBoxes[2], enemyBoxes[3], var4, var5 - this.playerHeight, playerWidth, this.playerHeight)) {
               if (!this.playerInvulnerable) {
                  this.health = this.health - (this.hazardDamage[var3] * this.frameDelta >> 2);
                  if (this.health < 0) {
                     this.health = 0;
                  }
               }

               this.healthPrev = this.health;
               if (!gh && !this.gk && !this.attacking && playerAnim != 52 && playerAnim != 53 && playerAnim != 60 && playerAnim != 77 && this.onGround) {
                  this.setPlayerAction(5);
               }
            }
         }
      }

      this.stepSlot(132);

      for (int var54 = this.enemyCount + 85; var54 >= 85; var54--) {
         var3 = var54 - 85;
         boolean var66 = false;
         if (this.enemyId[var3] >= 0) {
            int var78 = this.enemyY[var3];
            int var85 = enemyX[var3];
            byte var90 = this.enemyClass[var3];
            int var95 = this.enemyAction[var3];
            this.clearCellFlags(this.enemyTileX[var3], this.enemyTileY[var3] - 1, 2);
            this.enemySubY[var3] = var78 - this.enemyTileY[var3] * 16 << 8;
            this.enemyTileX[var3] = enemyTileXOf(var3);
            int var96 = this.enemyTileX[var3];
            int var15 = (this.enemySubY[var3] >> 8) + 1 >= 16 ? this.enemyTileY[var3] + 1 : this.enemyTileY[var3];
            int var16 = this.playerX - var85;
            int var17 = this.playerY - var78;
            int var18 = Math.abs(var16);
            this.dG = var18;
            int var19 = Math.abs(var17);
            enemyOnGround = (this.getCellFlags(var96, var15) & 1) != 0;
            if ((this.getCellFlags(var96, var15) & 64) != 0 && this.dS[var3] != 1 && enemyX[var3] > 0) {
               enemyHealth[var3] = -1;
               if (var90 == 1) {
                  this.setEnemyAction(8, var3);
                  this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 0, this.enemyDropAmount[var3]);
               } else if (var90 == 2) {
                  this.setEnemyAction(7, var3);
                  this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 2, this.enemyDropAmount[var3]);
               }
            }

            if (enemyX[var3] > -10
               && this.enemyY[var3] > -10
               && (
                  rectsOverlap(
                        cameraX - 64,
                        cameraY - 64,
                        368,
                        448,
                        enemyX[var3] - this.enemyWidth[var3],
                        this.enemyY[var3] - this.enemyHeight[var3],
                        this.enemyWidth[var3] << 1,
                        this.enemyHeight[var3]
                     )
                     || this.dL == var3 && state == 105
                     || this.enemyClass[var3] == 1
                        && (
                           this.enemyAction[var3] == 11
                              || this.enemyAction[var3] == 27
                              || this.enemyAction[var3] == 8
                              || this.enemyAction[var3] == 9
                              || this.enemyAction[var3] == 10
                              || this.enemyAction[var3] == 7
                        )
                     || this.enemyClass[var3] == 2
                        && (
                           this.enemyAction[var3] == 8
                              || this.enemyAction[var3] == 14
                              || this.enemyAction[var3] == 7
                              || this.enemyAction[var3] == 10
                              || this.enemyAction[var3] == 9
                        )
                     || this.enemyClass[var3] == 3
                        && (
                           this.enemyAction[var3] == 10
                              || this.enemyAction[var3] == 18
                              || this.enemyAction[var3] == 7
                              || this.enemyAction[var3] == 13
                              || this.enemyAction[var3] == 17
                              || this.enemyAction[var3] == 8
                        )
               )) {
               boolean var20 = false;
               if (this.enemyStatus[var3] <= 500) {
                  var20 = !this.stepAnim(var54, this.frameDelta - (this.enemyStatus[var3] >> 5));
               }

               if (this.enemyAction[var3] == 11 && this.enemyClass[var3] == 1
                  || this.enemyAction[var3] == 8 && this.enemyClass[var3] == 2
                  || this.enemyAction[var3] == 10 && this.enemyClass[var3] == 3) {
                  super.animDeltaY = super.animDeltaY + dJ[var3];
                  this.dK[var3] = this.dK[var3] + this.frameDelta;
                  if (this.dK[var3] > 200) {
                     this.dK[var3] = this.dK[var3] - 200;
                     dJ[var3] = dJ[var3] + (dJ[var3] >= 8 ? 0 : 4);
                  }
               } else {
                  this.dK[var3] = 0;
                  dJ[var3] = 0;
               }

               if (state != 105 && this.enemyStatus[var3] <= 500) {
                  if (var20) {
                     if (state != 105) {
                        switch (var90) {
                           case 1:
                              if (var95 != 8 && var95 != 9 && var95 != 10) {
                                 if (!this.enemyClimbing[var3] && !this.eh[var3]) {
                                    if (var18 < 48 && var19 < 16) {
                                       if (Math.abs(this.randomValue & 3) == 3) {
                                          this.setEnemyAction(6, var3);
                                       } else {
                                          this.setEnemyAction(5, var3);
                                       }

                                       this.enemyFacingRight[var3] = var16 >= 0;
                                    } else if (var95 != 0
                                       && var19 < 32
                                       && (
                                             this.getCellFlags(
                                                   this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] : -enemyHalfWidthTiles[var3]),
                                                   this.enemyTileY[var3] - 1
                                                )
                                                & 3
                                          )
                                          == 0
                                       && (
                                             this.getCellFlags(
                                                   this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] + 1 : -(enemyHalfWidthTiles[var3] + 1)),
                                                   this.enemyTileY[var3] - 1
                                                )
                                                & 3
                                          )
                                          == 0
                                       && (
                                             this.getCellFlags(
                                                   this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] : -enemyHalfWidthTiles[var3]),
                                                   this.enemyTileY[var3]
                                                )
                                                & 3
                                          )
                                          != 0
                                       && var18 < 144) {
                                       if (eu[var3] < 0) {
                                          this.setEnemyAction(1, var3);
                                       } else {
                                          this.setEnemyAction(0, var3);
                                          eu[var3] = eu[var3] - this.frameDelta;
                                       }
                                    } else if (this.enemyAction[var3] == 25) {
                                       this.setEnemyAction(1, var3);
                                    } else {
                                       if (this.enemyAction[var3] == 27) {
                                          enemyOnGround = true;
                                       }

                                       this.setEnemyAction(0, var3);
                                    }

                                    if (ev[var3] && this.enemyAction[var3] == 1) {
                                       int var102;
                                       if ((var102 = enemyX[var3] - enemyHomeX[var3]) > 64) {
                                          this.enemyFacingRight[var3] = false;
                                       } else if (var102 < 64) {
                                          this.enemyFacingRight[var3] = true;
                                       }
                                    }
                                 } else if (this.enemyClimbing[var3]) {
                                    if (var95 != 16 && var95 != 15 && var17 > 0 && var17 < 32 && var18 < 16) {
                                       this.setEnemyAction(16, var3);
                                    } else if (var95 != 15 && var95 != 16 && var17 < 0 && var17 > -64 && var18 < 16) {
                                       this.setEnemyAction(15, var3);
                                    } else if (var17 < 0 && var95 != 12 && var95 != 15 && var95 != 16 && var95 != 21) {
                                       this.setEnemyAction(12, var3);
                                    } else if (var95 != 13 && var95 != 15 && var95 != 16 && var95 != 21) {
                                       this.setEnemyAction(13, var3);
                                    } else if (var95 != 21) {
                                       this.setEnemyAction(23, var3);
                                    }
                                 } else if (this.eh[var3] && (var95 == 20 || var95 == 19)) {
                                    this.setEnemyAction(26, var3);
                                 }
                              } else {
                                 if (this.dH < 25) {
                                    this.spawnDebris(var3, 0);
                                 }

                                 this.countArenaKill(var3);
                                 this.spawnEffect(enemyX[var3], this.enemyY[var3], 26, 0, false);
                                 enemyX[var3] = -1000;
                                 this.enemyY[var3] = -1000;
                                 var85 = -1000;
                                 var78 = -1000;
                                 this.killCount++;
                                 if (challengeMode) {
                                    this.iB = true;
                                 }

                                 this.setEnemyAction(0, var3);
                              }
                              break;
                           case 2:
                              if (var95 != 7 && var95 != 12 && var95 != 13) {
                                 if (var95 != 12) {
                                    byte var100 = 0;
                                    if (this.dB) {
                                       var100 = 1;
                                    }

                                    if (this.enemyAction[var3] == 10) {
                                       this.setEnemyAction(12, var3);
                                    } else if (var18 < 16 * (3 + var100) && var19 < 16) {
                                       if (Math.abs(this.randomValue & 3) == 3) {
                                          this.setEnemyAction(6, var3);
                                       } else {
                                          this.setEnemyAction(5, var3);
                                       }

                                       this.enemyFacingRight[var3] = var16 >= 0;
                                    } else {
                                       if (this.enemyAction[var3] == 27) {
                                          enemyOnGround = true;
                                       }

                                       this.setEnemyAction(0, var3);
                                    }
                                 }
                              } else {
                                 if (this.dH < 25) {
                                    this.spawnDebris(var3, 0);
                                 }

                                 this.countArenaKill(var3);
                                 this.spawnEffect(enemyX[var3], this.enemyY[var3], 26, 0, false);
                                 enemyX[var3] = -1000;
                                 this.enemyY[var3] = -1000;
                                 var85 = -1000;
                                 var78 = -1000;
                                 this.setEnemyAction(0, var3);
                                 this.killCount++;
                                 if (challengeMode) {
                                    this.iB = true;
                                 }
                              }

                              if (ev[var3] && this.enemyAction[var3] == 1) {
                                 int var101;
                                 if ((var101 = enemyX[var3] - enemyHomeX[var3]) > 64) {
                                    this.enemyFacingRight[var3] = false;
                                 } else if (var101 < 64) {
                                    this.enemyFacingRight[var3] = true;
                                 }
                              }
                              break;
                           case 3:
                              if ((var95 == 7 || var95 == 13 || var95 == 17) && bossIndex != var3 && this.finalBossIndex != var3
                                 || bossIndex == var3 && (var95 == 7 || var95 == 16)
                                 || this.finalBossIndex == var3 && var95 == 16) {
                                 if (bossIndex == var3 && var95 == 7 || this.finalBossIndex == var3) {
                                    if (this.finalBossIndex != var3) {
                                       this.cs = 266;
                                       this.ct = 266;
                                       this.cu = 274;
                                    } else {
                                       this.cs = 243;
                                       this.ct = 243;
                                       this.cu = 245;
                                    }

                                    this.setBarTargets(79, 25, 35, 35);
                                    state = 101;
                                    this.startDialogueLine();
                                 }

                                 if (this.dH < 25) {
                                    this.spawnDebris(var3, 0);
                                 }

                                 this.countArenaKill(var3);
                                 if (bossIndex != var3) {
                                    this.spawnEffect(enemyX[var3], this.enemyY[var3], 26, 0, false);
                                 }

                                 enemyX[var3] = -1000;
                                 this.enemyY[var3] = -1000;
                                 var85 = -1000;
                                 var78 = -1000;
                                 this.setEnemyAction(0, var3);
                                 this.killCount++;
                                 if (challengeMode) {
                                    this.iB = true;
                                 }
                              } else if (bossIndex == var3 && this.finalBossIndex != var3 && this.enemyAction[var3] == 15) {
                                 this.setEnemyAction(16, var3);
                              }

                              if (bossIndex != var3 || this.finalBossIndex == var3 || this.enemyAction[var3] != 16) {
                                 if (var95 == 11 && bossIndex != var3) {
                                    this.setEnemyAction(12, var3);
                                 } else if (var95 == 16 && bossIndex != var3 && this.finalBossIndex != var3) {
                                    this.setEnemyAction(17, var3);
                                    enemyHealth[var3] = -1;
                                 } else if (var95 == 12 && bossIndex != var3) {
                                    this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 1, this.enemyDropAmount[var3]);
                                    this.setEnemyAction(13, var3);
                                    enemyHealth[var3] = -1;
                                 } else if (var18 < 16 * (3 + (bossIndex == var3 ? 1 : 0)) && var19 < 16 && this.grappledEnemy < 0) {
                                    if (Math.abs(this.randomValue & 3) == 3) {
                                       if (bossIndex == var3 && (this.randomValue & 1) != 0) {
                                          this.setEnemyAction(12, var3);
                                       } else {
                                          this.setEnemyAction(6, var3);
                                       }
                                    } else {
                                       this.setEnemyAction(3, var3);
                                    }

                                    if (!qteActive) {
                                       this.enemyFacingRight[var3] = var16 >= 8;
                                    }
                                 } else if (var95 != 0 && this.grappledEnemy != var3) {
                                    super.animDeltaX = 0;
                                    super.animDeltaY = 0;
                                    this.setEnemyAction(0, var3);
                                 }

                                 if (ev[var3] && this.enemyAction[var3] == 1) {
                                    int var99;
                                    if ((var99 = enemyX[var3] - enemyHomeX[var3]) > 64) {
                                       this.enemyFacingRight[var3] = false;
                                    } else if (var99 < 64) {
                                       this.enemyFacingRight[var3] = true;
                                    }
                                 }

                                 if (this.finalBossIndex == var3 && var95 == 14 && this.finalBossPhase >= 3) {
                                    this.setEnemyAction(16, var3);
                                 } else if (this.finalBossIndex == var3 && var95 == 14 && this.finalBossPhase < 3) {
                                    this.setEnemyAction(17, var3);
                                    this.enemyFacingRight[var3] = !this.enemyFacingRight[var3];
                                 }
                              }
                        }
                     }
                  } else if (state != 105) {
                     switch (var90) {
                        case 1:
                           if (var95 == 1) {
                              if (var16 > 16 && !this.enemyFacingRight[var3]) {
                                 this.enemyFacingRight[var3] = true;
                              } else if (var16 < -16 && this.enemyFacingRight[var3]) {
                                 this.enemyFacingRight[var3] = false;
                              }

                              if (var18 < 48 && var19 < 16) {
                                 this.setEnemyAction(6, var3);
                                 this.enemyFacingRight[var3] = var16 >= 0;
                              } else if (var18 < 32 && var19 > 16 && var19 < 128 && this.climbing && !this.dA
                                 || var18 < 64 && var19 > 16 && var19 < 32 && hangingOnBar && !this.dA
                                 || var17 > 0
                                    && var19 < 32
                                    && var18 < 48
                                    && this.playerAction != 37
                                    && this.playerAction != 38
                                    && !hangingOnBar
                                    && !ledgeHanging
                                    && this.playerAction != 38) {
                                 this.setEnemyAction(3, var3);
                              }
                           } else if (this.enemyClimbing[var3]) {
                              if (var95 != 16 && var95 != 21 && var17 > 0 && var17 < 32 && var18 < 16) {
                                 this.setEnemyAction(16, var3);
                              } else if (var95 != 15 && var95 != 21 && var17 < 0 && var17 > -64 && var18 < 16) {
                                 this.setEnemyAction(15, var3);
                              } else if (var17 < 0 && var95 != 12 && var95 != 15 && var95 != 16 && var95 != 21) {
                                 this.setEnemyAction(12, var3);
                              } else if (var95 != 13 && var95 != 15 && var95 != 21 && var95 != 16 && var17 > 0) {
                                 this.setEnemyAction(13, var3);
                              } else if (var95 == 21 && enemyOnGround) {
                                 this.setEnemyAction(0, var3);
                              }
                           } else if (!this.eh[var3]) {
                              if ((this.getCellFlags(this.enemyTileX[var3], this.enemyTileY[var3] - 1) & 512) != 0 && this.enemyAction[var3] != 8) {
                                 this.enemyFacingRight[var3] = !facingRight;
                                 enemyHealth[var3] = -1;
                                 this.setEnemyAction(8, var3);
                                 this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 0, this.enemyDropAmount[var3]);
                              } else if (var95 == 0
                                 && var19 < 32
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] : -enemyHalfWidthTiles[var3]),
                                             this.enemyTileY[var3] - 1
                                          )
                                          & 3
                                    )
                                    == 0
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] + 1 : -(enemyHalfWidthTiles[var3] + 1)),
                                             this.enemyTileY[var3] - 1
                                          )
                                          & 3
                                    )
                                    == 0
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] : -enemyHalfWidthTiles[var3]),
                                             this.enemyTileY[var3]
                                          )
                                          & 3
                                    )
                                    != 0
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] + 1 : -(enemyHalfWidthTiles[var3] + 1)),
                                             this.enemyTileY[var3]
                                          )
                                          & 3
                                    )
                                    != 0
                                 && var18 < 144) {
                                 if (eu[var3] < 0) {
                                    this.setEnemyAction(1, var3);
                                 } else {
                                    eu[var3] = eu[var3] - this.frameDelta;
                                 }
                              } else if (var95 == 0 && var17 <= 32 && var17 > 0 && this.onGround && var18 < 48) {
                                 this.setEnemyAction(3, var3);
                              } else if (var95 == 21) {
                                 this.setEnemyAction(0, var3);
                              } else if (this.enemyAction[var3] == 0 && var18 < 48 && var19 < 16) {
                                 if (Math.abs(this.randomValue & 3) == 3) {
                                    this.setEnemyAction(6, var3);
                                 } else {
                                    this.setEnemyAction(5, var3);
                                 }

                                 this.enemyFacingRight[var3] = var16 >= 0;
                              }
                           } else {
                              if (var16 > 16
                                 && var18 < 72
                                 && this.enemyAction[var3] != 19
                                 && this.enemyAction[var3] != 18
                                 && (this.getCellFlags(this.enemyTileX[var3] + 1, this.enemyTileY[var3] - this.enemyHeightTiles[var3] - 1) & 16) != 0) {
                                 this.setEnemyAction(18, var3);
                                 this.enemyFacingRight[var3] = true;
                              } else if (var16 < -16
                                 && var18 < 72
                                 && this.enemyAction[var3] != 19
                                 && this.enemyAction[var3] != 18
                                 && (this.getCellFlags(this.enemyTileX[var3] - 1, this.enemyTileY[var3] - this.enemyHeightTiles[var3] - 1) & 16) != 0) {
                                 this.setEnemyAction(18, var3);
                                 this.enemyFacingRight[var3] = false;
                              }

                              if (this.enemyAction[var3] != 19 && var18 < 48 && var19 < 16) {
                                 this.setEnemyAction(19, var3);
                                 this.enemyFacingRight[var3] = var16 >= 0;
                              }
                           }
                           break;
                        case 2:
                           byte var21 = 0;
                           if (this.dB) {
                              var21 = 1;
                           }

                           if (var95 != 1) {
                              if ((this.getCellFlags(this.enemyTileX[var3], this.enemyTileY[var3] - 1) & 512) != 0 && this.enemyAction[var3] != 7) {
                                 this.enemyFacingRight[var3] = !facingRight;
                                 enemyHealth[var3] = -1;
                                 this.setEnemyAction(7, var3);
                                 this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 2, this.enemyDropAmount[var3]);
                              } else if (var95 == 0
                                 && var19 < 32
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] : -enemyHalfWidthTiles[var3]),
                                             this.enemyTileY[var3] - 1
                                          )
                                          & 3
                                    )
                                    == 0
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] + 1 : -(enemyHalfWidthTiles[var3] + 1)),
                                             this.enemyTileY[var3] - 1
                                          )
                                          & 3
                                    )
                                    == 0
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] : -enemyHalfWidthTiles[var3]),
                                             this.enemyTileY[var3]
                                          )
                                          & 3
                                    )
                                    != 0
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] + 1 : -(enemyHalfWidthTiles[var3] + 1)),
                                             this.enemyTileY[var3]
                                          )
                                          & 3
                                    )
                                    != 0
                                 && var18 < 144) {
                                 if (eu[var3] < 0) {
                                    this.setEnemyAction(1, var3);
                                 } else {
                                    eu[var3] = eu[var3] - this.frameDelta;
                                 }
                              } else if (this.enemyAction[var3] == 0) {
                                 byte var22 = 0;
                                 if (this.dB) {
                                    var22 = 1;
                                 }

                                 if (var18 < 16 * (3 + var22) && var19 < 16) {
                                    if (Math.abs(this.randomValue & 3) == 3) {
                                       this.setEnemyAction(6, var3);
                                    } else {
                                       this.setEnemyAction(5, var3);
                                    }

                                    this.enemyFacingRight[var3] = var16 >= 0;
                                 }
                              }
                           } else {
                              if (var16 > 16 && !this.enemyFacingRight[var3]) {
                                 this.enemyFacingRight[var3] = true;
                              } else if (var16 < -16 && this.enemyFacingRight[var3]) {
                                 this.enemyFacingRight[var3] = false;
                              }

                              if (var18 < 16 * (3 + var21) && var19 < 16) {
                                 this.setEnemyAction(6, var3);
                                 this.enemyFacingRight[var3] = var16 >= 0;
                              }
                           }
                           break;
                        case 3:
                           if (var95 != 12) {
                              if (var95 == 1) {
                                 if (var16 > 16 && !this.enemyFacingRight[var3]) {
                                    this.enemyFacingRight[var3] = true;
                                 } else if (var16 < -16 && this.enemyFacingRight[var3]) {
                                    this.enemyFacingRight[var3] = false;
                                 }

                                 if (var18 < 16 * (3 + (bossIndex == var3 ? 1 : 0)) && var19 < 16) {
                                    this.setEnemyAction(6, var3);
                                    this.enemyFacingRight[var3] = var16 >= 0;
                                 }
                              } else if ((this.getCellFlags(this.enemyTileX[var3], this.enemyTileY[var3] - 1) & 512) != 0 && this.enemyAction[var3] != 7) {
                                 enemyHealth[var3] = -1;
                                 this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 0, this.enemyDropAmount[var3]);
                                 this.setEnemyAction(7, var3);
                                 this.enemyFacingRight[var3] = !facingRight;
                              } else if (var95 == 0
                                 && var19 < 32
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] + 1 : -(enemyHalfWidthTiles[var3] + 1)),
                                             this.enemyTileY[var3] - 1
                                          )
                                          & 3
                                    )
                                    == 0
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] + 1 : -(enemyHalfWidthTiles[var3] + 1)),
                                             this.enemyTileY[var3] - 1
                                          )
                                          & 3
                                    )
                                    == 0
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] + 1 : -(enemyHalfWidthTiles[var3] + 1)),
                                             this.enemyTileY[var3]
                                          )
                                          & 3
                                    )
                                    != 0
                                 && (
                                       this.getCellFlags(
                                             this.enemyTileX[var3] + (var16 > 0 ? enemyHalfWidthTiles[var3] + 1 : -(enemyHalfWidthTiles[var3] + 1)),
                                             this.enemyTileY[var3]
                                          )
                                          & 3
                                    )
                                    != 0
                                 && var18 < 144) {
                                 if (eu[var3] < 0) {
                                    this.setEnemyAction(1, var3);
                                 } else {
                                    eu[var3] = eu[var3] - this.frameDelta;
                                 }
                              }
                           }

                           if (var95 == 0 && var18 < 16 * (3 + (bossIndex == var3 ? 1 : 0)) && var19 < 16 && this.grappledEnemy < 0) {
                              if (Math.abs(this.randomValue & 3) == 3) {
                                 if (bossIndex == var3 && (this.randomValue & 1) != 0) {
                                    this.setEnemyAction(12, var3);
                                 } else {
                                    this.setEnemyAction(6, var3);
                                 }
                              } else {
                                 this.setEnemyAction(3, var3);
                              }

                              if (!qteActive) {
                                 this.enemyFacingRight[var3] = var16 >= 8;
                              }
                           }
                     }
                  }
               } else if ((var3 == this.dL || this.enemyStatus[var3] > 0) && this.enemyStatus[var3] <= 0 && var20) {
                  if (this.aY[this.ba + 1] == 0 && this.aZ[this.bb] == 0) {
                     this.advanceScript();
                  } else if (this.aZ[this.bb + 1] == 0) {
                     this.setEnemyAction(this.aZ[this.bb], var3);
                  } else {
                     this.bb++;
                     this.setEnemyAction(this.aZ[this.bb], var3);
                  }
               }

               if (this.enemyStatus[var3] <= 500) {
                  this.moveEnemy(this.enemyTileX[var3], this.enemyTileY[var3], var3);
               }

               if (!enemyOnGround
                  && !this.enemyClimbing[var3]
                  && !this.eh[var3]
                  && this.dS[var3] != 1
                  && (
                     this.enemyClass[var3] == 1
                           && this.enemyAction[var3] != 11
                           && this.enemyAction[var3] != 27
                           && this.enemyAction[var3] != 3
                           && this.enemyAction[var3] != 11
                           && this.enemyAction[var3] != 24
                        || this.enemyClass[var3] == 2 && this.enemyAction[var3] != 8 && this.enemyAction[var3] != 14
                        || this.enemyClass[var3] == 3 && this.enemyAction[var3] != 10 && this.enemyAction[var3] != 18
                  )
                  && this.finalBossIndex != var3) {
                  switch (this.enemyClass[var3]) {
                     case 1:
                        this.setEnemyAction(11, var3);
                        break;
                     case 2:
                        this.setEnemyAction(8, var3);
                        break;
                     case 3:
                        this.setEnemyAction(10, var3);
                  }
               }

               if (!enemyCanMoveX
                  && (this.enemyAction[var3] == 1 || this.enemyAction[var3] == 18 || this.enemyAction[var3] == 1 || this.enemyAction[var3] == 1)) {
                  switch (this.enemyClass[var3]) {
                     case 1:
                        this.setEnemyAction(0, var3);
                        break;
                     case 2:
                        this.setEnemyAction(0, var3);
                        break;
                     case 3:
                        this.setEnemyAction(0, var3);
                  }
               }
            }

            if (state != 105 && enemyX[var3] < 0 && (enemyRespawns[var3] > 0 || challengeMode)) {
               enemyRespawnTimer[var3] = enemyRespawnTimer[var3] - this.frameDelta;
               if (enemyRespawnTimer[var3] <= 0
                  && this.effectLast < 9
                  && (Math.abs(enemyHomeX[var3] - this.playerX) > 32 || Math.abs(enemyHomeY[var3] - this.playerY) > 32)) {
                  if ((this.getCellFlags(enemyHomeX[var3] / 16, enemyHomeY[var3] / 16 - 1) & 1) == 0
                     && (this.getCellFlags(enemyHomeX[var3] / 16, enemyHomeY[var3] / 16 - 1) & 2) == 0) {
                     enemyRespawns[var3]--;
                     enemyRespawnTimer[var3] = this.enemyRespawnDelay[var3];
                     this.eh[var3] = false;
                     enemyX[var3] = enemyHomeX[var3];
                     this.enemyY[var3] = enemyHomeY[var3];
                     enemyHealth[var3] = enemyMaxHealth[var3];
                     this.enemyTileX[var3] = enemyX[var3] / 16;
                     this.enemyTileY[var3] = this.enemyY[var3] / 16;
                     this.setCellFlags(this.enemyTileX[var3], this.enemyTileY[var3] - 1, 2);
                     this.spawnEffect(enemyX[var3], this.enemyY[var3], 25, 0, false);
                     switch (this.enemyClass[var3]) {
                        case 1:
                           if (this.eh[var3]) {
                              this.setEnemyAction(26, var3);
                           } else {
                              this.setEnemyAction(27, var3);
                           }
                           break;
                        case 2:
                           this.setEnemyAction(14, var3);
                           break;
                        case 3:
                           this.setEnemyAction(18, var3);
                     }
                  } else {
                     enemyRespawnTimer[var3] = 1500;
                  }
               }
            }

            this.getBoxesAt(var85, var78, var3 + 85, enemyBoxes, this.enemyFacingRight[var3]);

            for (int var103 = 0; var103 < this.playerBoxes.length; var103 += 5) {
               if (this.playerBoxes[var103 + 2] != 0) {
                  int var97;
                  if (magicModeA || magicModeB) {
                     var97 = 0;
                  } else if (var103 == 0) {
                     var97 = this.fO;
                  } else {
                     var97 = this.fP;
                  }

                  if (var97 < 2
                     && rectsOverlap(
                        this.playerBoxes[var103],
                        this.playerBoxes[var103 + 1],
                        this.playerBoxes[var103 + 2],
                        this.playerBoxes[var103 + 3],
                        enemyBoxes[0],
                        enemyBoxes[1],
                        enemyBoxes[2],
                        enemyBoxes[3]
                     )) {
                     int var105 = enemyBoxes[0] + (this.enemyFacingRight[var3] ? enemyBoxes[7] : 0);
                     int var23 = enemyBoxes[1] + (enemyBoxes[3] >> 1);
                     if (enemyBoxes[1] < enemyBoxes[3]) {
                        var23 = enemyBoxes[3];
                     } else if (var23 > this.enemyY[var3]) {
                        var23 = this.enemyY[var3];
                     }

                     var97++;
                     int var24 = magicModeA ? fJ[this.comboIndex] << magicALevel : fI[this.comboIndex] << bladesLevel;
                     if (this.D) {
                        var24 = 10000;
                     }

                     if (magicModeA) {
                        magic = magic - ((fJ[this.comboIndex] << 1) + fJ[this.comboIndex]);
                     }

                     if (magicModeA && !this.airAttacking && hf < 3 || !magicModeA && !magicModeB) {
                        enemyHealth[var3] = enemyHealth[var3] - var24;
                        if (!magicModeA) {
                           if (!var66) {
                              this.playSound(3 + (this.randomValue & 1));
                           }

                           if (var97 == 1) {
                              comboHits++;
                           }
                        } else if (!var66) {
                           this.playSound(3 + (this.randomValue & 1));
                        }

                        var66 = true;
                        this.iB = true;
                        this.comboTimer = 2000;
                     } else if (magicModeB) {
                        this.enemyStatus[var3] = this.enemyStatus[var3] + (fK[magicBLevel] << 5) + this.frameDelta;
                     }

                     if (enemyHealth[var3] <= 0 && this.dS[var3] != 1) {
                        enemyHealth[var3] = -1;
                        if (!this.enemyClimbing[var3] && !this.eh[var3]) {
                           if (enemyOnGround) {
                              if (var90 == 1) {
                                 this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 0, this.enemyDropAmount[var3]);
                                 this.setEnemyAction(9, var3);
                              } else if (var90 == 2) {
                                 this.setEnemyAction(7, var3);
                                 this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 2, this.enemyDropAmount[var3]);
                              } else if (var90 == 3) {
                                 if (var95 == 12 && bossIndex != var3) {
                                    this.setEnemyAction(13, var3);
                                    this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 1, this.enemyDropAmount[var3]);
                                 } else if (bossIndex != var3 && this.finalBossIndex != var3) {
                                    this.setEnemyAction(7, var3);
                                    this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 0, this.enemyDropAmount[var3]);
                                 } else {
                                    enemyHealth[var3] = (enemyMaxHealth[var3] >> 1) - 1;
                                 }
                              }
                           }
                        } else {
                           this.setEnemyAction(11, var3);
                        }

                        this.spawnEffect(var105, var23, 0, !facingRight ? 2 : 0, true);
                     } else if (this.dS[var3] != 1 && this.dS[var3] != 3) {
                        if (this.enemyStatus[var3] <= 0) {
                           if (this.enemyClimbing[var3]) {
                              this.setEnemyAction(17, var3);
                           } else if (this.eh[var3]) {
                              this.setEnemyAction(20, var3);
                           } else {
                              this.enemyFacingRight[var3] = var16 > 0;
                              if (var90 == 1) {
                                 if (this.grappledEnemy == -1 && playerAnim != 60 && playerAnim != 77) {
                                    this.setEnemyAction(2, var3);
                                 } else {
                                    this.setEnemyAction(7, var3);
                                 }
                              } else if (var90 == 2) {
                                 if (this.grappledEnemy == -1 && playerAnim != 60 && playerAnim != 77) {
                                    this.setEnemyAction(2, var3);
                                 } else {
                                    this.setEnemyAction(9, var3);
                                 }
                              } else if (var90 == 3) {
                                 if (var95 == 12 && bossIndex != var3) {
                                    this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 1, this.enemyDropAmount[var3]);
                                    this.setEnemyAction(13, var3);
                                 } else if ((bossIndex == var3 || this.grappledEnemy == -1) && playerAnim != 60 && playerAnim != 77) {
                                    this.setEnemyAction(4, var3);
                                 } else {
                                    this.setEnemyAction(8, var3);
                                 }
                              }

                              if (!qteActive) {
                                 this.enemyFacingRight[var3] = enemyX[var3] - this.playerX <= 0;
                              }
                           }
                        }

                        if ((!magicModeA || magicModeA && hf < 3) && !magicModeB) {
                           hf++;
                           this.spawnEffect(var105, var23, 0, !facingRight ? 2 : 0, true);
                        }
                     }

                     if (!magicModeA && !magicModeB && this.grappledEnemy != -1) {
                        this.playerBoxes[var103] = 0;
                        this.playerBoxes[var103 + 1] = 0;
                        this.playerBoxes[var103 + 2] = 0;
                        this.playerBoxes[var103 + 3] = 0;
                     }

                     if (var103 == 0) {
                        this.fO = var97;
                     } else {
                        this.fP = var97;
                     }
                  }

                  if (var97 < 2
                     && rectsOverlap(
                        this.playerBoxes[var103],
                        this.playerBoxes[var103 + 1],
                        this.playerBoxes[var103 + 2],
                        this.playerBoxes[var103 + 3],
                        enemyBoxes[5],
                        enemyBoxes[6],
                        enemyBoxes[7],
                        enemyBoxes[8]
                     )) {
                     int var106 = enemyBoxes[5] + (this.enemyFacingRight[var3] ? enemyBoxes[7] : 0);
                     int var107 = this.playerBoxes[var103 + 1] + (this.playerBoxes[var103 + 3] >> 1);
                     var97++;
                     int var108 = magicModeA ? fJ[this.comboIndex] << magicALevel : fI[this.comboIndex] << bladesLevel;
                     if (this.D) {
                        var108 = 10000;
                     }

                     if (magicModeA && hf < 3 || !magicModeA && !magicModeB) {
                        label2440: {
                           enemyHealth[var3] = enemyHealth[var3] - var108;
                           if (!magicModeA) {
                              if (!var66) {
                                 this.playSound(3 + (this.randomValue & 1));
                              }

                              if (var97 != 1) {
                                 break label2440;
                              }
                           } else if (!var66) {
                              this.playSound(3 + (this.randomValue & 1));
                           }

                           comboHits++;
                        }

                        this.iB = true;
                        var66 = true;
                        this.comboTimer = 2000;
                     } else if (magicModeB) {
                        this.enemyStatus[var3] = this.enemyStatus[var3] + (fK[magicBLevel] << 5) + this.frameDelta;
                     }

                     if (enemyHealth[var3] <= 0 && this.dS[var3] != 1) {
                        enemyHealth[var3] = -1;
                        if (this.enemyClimbing[var3] || this.eh[var3]) {
                           this.setEnemyAction(11, var3);
                        } else if (enemyOnGround) {
                           if (var90 == 1) {
                              this.setEnemyAction(8, var3);
                              this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 0, this.enemyDropAmount[var3]);
                           } else if (var90 == 2) {
                              this.setEnemyAction(7, var3);
                              this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 2, this.enemyDropAmount[var3]);
                           } else if (var90 == 3) {
                              if (var95 == 12 && bossIndex != var3 && this.finalBossIndex != var3) {
                                 this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 1, this.enemyDropAmount[var3]);
                                 this.setEnemyAction(13, var3);
                              } else if (bossIndex != var3 && this.finalBossIndex != var3) {
                                 this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 0, this.enemyDropAmount[var3]);
                                 this.setEnemyAction(7, var3);
                              } else {
                                 enemyHealth[var3] = (enemyMaxHealth[var3] >> 1) - 1;
                              }
                           }
                        }

                        this.spawnEffect(var106, var107, 0, !facingRight ? 2 : 0, true);
                     } else if (this.dS[var3] != 1 && this.dS[var3] != 3) {
                        if (this.enemyStatus[var3] <= 0) {
                           if (this.enemyClimbing[var3]) {
                              this.setEnemyAction(17, var3);
                           } else if (this.eh[var3]) {
                              this.setEnemyAction(20, var3);
                           } else {
                              this.enemyFacingRight[var3] = var16 > 0;
                              if (var90 == 1) {
                                 if (this.grappledEnemy == -1 && playerAnim != 60 && playerAnim != 77) {
                                    this.setEnemyAction(2, var3);
                                 } else {
                                    this.setEnemyAction(7, var3);
                                 }
                              } else if (var90 == 2) {
                                 if (this.grappledEnemy == -1 && playerAnim != 60 && playerAnim != 77) {
                                    this.setEnemyAction(2, var3);
                                 } else {
                                    this.setEnemyAction(9, var3);
                                 }
                              } else if (var90 == 3) {
                                 if (this.grappledEnemy == -1 && playerAnim != 60 && playerAnim != 77) {
                                    this.setEnemyAction(4, var3);
                                 } else {
                                    this.setEnemyAction(8, var3);
                                 }
                              }
                           }
                        }

                        if ((!magicModeA || magicModeA && hf < 3) && !magicModeB) {
                           hf++;
                           this.spawnEffect(var106, var107, 0, !facingRight ? 2 : 0, true);
                        }
                     }

                     if (!magicModeA && this.grappledEnemy != -1) {
                        this.playerBoxes[var103] = 0;
                        this.playerBoxes[var103 + 1] = 0;
                        this.playerBoxes[var103 + 2] = 0;
                        this.playerBoxes[var103 + 3] = 0;
                     }

                     if (var103 == 0) {
                        this.fO = var97;
                     } else {
                        this.fP = var97;
                     }
                  }
               }
            }

            if (enemyBoxes[12] > 0
               && rectsOverlap(
                  this.playerX - this.frontExtent,
                  this.playerY - this.playerHeight,
                  playerWidth,
                  this.playerHeight,
                  enemyBoxes[10],
                  enemyBoxes[11],
                  enemyBoxes[12],
                  enemyBoxes[13]
               )) {
               byte var104 = this.enemyContactDamage[var3];
               if (this.enemyAction[var3] == 6) {
                  var104 <<= 1;
               }

               if (bossIndex != var3) {
                  var104 <<= 1;
               }

               if (bossIndex != var3 && this.enemyAction[var3] == 12) {
                  var104 <<= 2;
               }

               if (!this.blocking) {
                  if (!this.playerInvulnerable) {
                     this.health -= var104;
                     if (this.health < 0) {
                        this.health = 0;
                     }
                  }
               } else {
                  this.blockedHit = true;
               }

               this.hitFromRight = !this.enemyFacingRight[var3];
            }
         }

         if (this.enemyStatus[var3] > 0) {
            this.enemyStatus[var3] = this.enemyStatus[var3] - (this.frameDelta + (enemyMaxHealth[var3] >> 6));
         }
      }
   }

   // $VF: renamed from: A () void
   private void resetWeaponMode() {
      magicModeB = false;
      this.magicModeC = false;
      magicModeA = false;
      this.weaponMode = 0;
   }

   // $VF: renamed from: B () int
   private int randomQteDirection() {
      int var1;
      do {
         var1 = Math.abs(this.randomValue % 5);
         this.randomValue = random.nextInt();
      } while (this.qteDirection == var1);

      return var1;
   }

   // $VF: renamed from: C () void
   private void advanceScript() {
      this.ba += 2;
      this.bb += 2;
      this.cs++;
      if (this.cs >= this.cu) {
         this.setBarTargets(0, 0, 35, 35);
         state = 100;
         this.iB = true;
         this.aW = false;
         this.cu = -1;
         this.cs = -1;
         this.ct = -1;
      } else {
         this.ct = this.cs;
         this.startDialogueLine();
         if (!this.be) {
            state = 101;
         } else {
            this.iI = false;
            this.levelIndex++;
            if (this.levelIndex > this.furthestLevel && (this.demoMode <= 0 || this.levelIndex < this.demoMode)) {
               this.furthestLevel = this.levelIndex;
            }

            this.levelResourceId++;
            this.levelResourceId = levelIds[this.levelIndex];
            this.bf = true;
            this.levelLoadStarted = false;
            this.ae = true;
            this.setBarTargets(halfHeight, halfHeight, 35, 35);
            state = 109;
            this.ae = true;
         }
      }
   }

   // $VF: renamed from: j (int, int) void
   private void spawnDebris(int var1, int var2) {
      Sprite[] var3 = (Sprite[])null;
      int var4 = 85 + var1;
      boolean var5;
      int var6;
      int var7;
      if (var2 == 0) {
         if (this.enemyClass[var1] == 1) {
            var3 = this.dC;
         } else if (this.enemyClass[var1] == 2) {
            var3 = dD;
         } else if (this.enemyClass[var1] == 3) {
            if (bossIndex != var1) {
               var3 = this.dE;
            } else {
               var3 = this.dF;
            }
         }

         var5 = this.enemyFacingRight[var1];
         var6 = enemyX[var1];
         var7 = this.enemyY[var1];
      } else if (var2 == 1) {
         var3 = this.dh;
         var4 = 60 + var1;
         var5 = this.dk[var1] != 2;
         var6 = dl[var1];
         var7 = dm[var1];
      } else {
         var3 = this.eY;
         var4 = 116 + var1;
         var5 = true;
         var6 = breakX[var1];
         var7 = this.breakY[var1];
      }

      int var8 = this.getFrameParts(this.framePartsBuffer, var4, var5 ? 0 : 2);
      if (this.sceneObjectCount + var8 < 1000) {
         this.sceneObjectCount += var8;

         for (int var9 = 0; var9 < var8; var9++) {
            int var10 = var9 << 2;
            this.scene
               .addObject(
                  var3[this.framePartsBuffer[var10]],
                  var6 + this.framePartsBuffer[var10 + 1],
                  var7 + this.framePartsBuffer[var10 + 2],
                  this.framePartsBuffer[var10 + 3]
               );
         }
      }
   }

   // $VF: renamed from: u (int) int
   private static int enemyTileXOf(int var0) {
      return enemyX[var0] / 16;
   }

   // $VF: renamed from: v (int) int
   private int enemyTileYOf(int var1) {
      int var2;
      return (var2 = this.enemyY[var1] / 16) > mapHeight ? mapHeight : var2;
   }

   // $VF: renamed from: d (int, int, int) void
   private void moveEnemy(int var1, int var2, int var3) {
      int var6 = enemyX[var3];
      int var7 = this.enemyY[var3];
      boolean var8 = this.enemyFacingRight[var3];
      short var9 = this.enemyHeight[var3];
      int var10 = this.enemyWidth[var3] >> 1;
      int var11 = (super.animDeltaX > 0 ? super.animDeltaX : -super.animDeltaX) << 8;
      int var12 = (super.animDeltaY > 0 ? super.animDeltaY : -super.animDeltaY) << 8;
      int var13 = var11;
      int var14 = var12;
      if (super.animDeltaX != 0) {
         var6 += (!this.enemyFacingRight[var3] || super.animDeltaX <= 0) && (this.enemyFacingRight[var3] || super.animDeltaX >= 0) ? -var10 : var10 - 1;
      }

      if (super.animDeltaY < 0) {
         var7 -= var9;
         this.enemyY[var3] = this.enemyY[var3] - var9;
      } else {
         var7--;
      }

      int var15 = var1;
      int var16 = this.enemyTileYOf(var3);
      this.enemySubX[var3] = var6 - var1 * 16 << 8;
      if (this.enemySubX[var3] < 0) {
         var15--;
         this.enemySubX[var3] = this.enemySubX[var3] + 4096;
      } else if (this.enemySubX[var3] > 4096) {
         var15++;
         this.enemySubX[var3] = this.enemySubX[var3] - 4096;
      }

      this.enemySubY[var3] = var7 - var16 * 16 << 8;
      if (super.animDeltaX != 0) {
         var6 -= (!var8 || super.animDeltaX <= 0) && (var8 || super.animDeltaX >= 0) ? -var10 : var10 - 1;
      }

      if (super.animDeltaY < 0) {
         var7 += var9;
         this.enemyY[var3] = this.enemyY[var3] + var9;
      } else {
         var7++;
      }

      enemyCanMoveX = true;
      this.enemyCanMoveY = true;
      if (var11 > var12) {
         if (var11 > 4096) {
            var12 = (var12 * 16 << 8) / var11;
            var11 = 4096;
         }
      } else if (var12 > 4096) {
         var11 = (var11 * 16 << 8) / var12;
         var12 = 4096;
      }

      int var4;
      if ((!var8 || super.animDeltaX <= 0) && (var8 || super.animDeltaX >= 0)) {
         var4 = -var11;
      } else {
         var4 = var11;
      }

      int var5 = super.animDeltaY > 0 ? var12 : -var12;
      int var17 = 0;
      int var18 = 0;
      this.moveAccumX = 0;
      this.moveAccumY = 0;
      if (super.animDeltaX != 0 && !this.eh[var3] && this.dS[var3] != 1) {
         this.checkEnemyCell(this.enemyTileX[var3], this.enemyTileY[var3] - 1 - (super.animDeltaY < 0 ? this.enemyHeightTiles[var3] : 0), var3);
      }

      while (var17 < var13 || var18 < var14) {
         this.enemySubX[var3] = this.enemySubX[var3] + var4;
         this.enemySubY[var3] = this.enemySubY[var3] + var5;
         if (this.enemySubX[var3] >= 4096) {
            this.enemySubX[var3] = this.enemySubX[var3] - 4096;
            var15++;
         } else if (this.enemySubX[var3] < 0) {
            this.enemySubX[var3] = this.enemySubX[var3] + 4096;
            var15--;
         }

         if (this.enemySubY[var3] >= 4096) {
            this.enemySubY[var3] = this.enemySubY[var3] - 4096;
            var16++;
         } else if (this.enemySubY[var3] < 0) {
            this.enemySubY[var3] = this.enemySubY[var3] + 4096;
            var16--;
         }

         this.blockedByWall = false;
         this.checkEnemyCell(var15, var16, var3);
         if (enemyCanMoveX) {
            this.moveAccumX += var4;
            var17 += var11;
         } else {
            this.enemySubX[var3] = this.enemySubX[var3] - var4;
            var13 = var17;
            if ((this.getCellFlags(var1, var2) & 1) != 0 && !this.blockedByWall) {
               this.moveAccumX = 0;
               this.blockedByWall = true;
               if ((!this.enemyFacingRight[var3] || super.animDeltaX <= 0) && (this.enemyFacingRight[var3] || super.animDeltaX >= 0)) {
                  enemyX[var3] = var1 * 16 + (this.enemyWidth[var3] >> 1);
               } else {
                  enemyX[var3] = (var1 + 1) * 16 - (this.enemyWidth[var3] >> 1);
               }
            }
         }

         if (this.enemyCanMoveY) {
            this.moveAccumY += var5;
            var18 += var12;
         } else {
            this.enemySubY[var3] = this.enemySubY[var3] - var5;
            var14 = var18;
         }
      }

      var6 += this.moveAccumX >> 8;
      var7 += this.moveAccumY >> 8;
      if (var17 > var13) {
         int var19 = var17 - var13 >> 8;
         var6 -= var4 > 0 ? var19 : -var19;
      }

      if (var18 > var14) {
         int var24 = var18 - var14 >> 8;
         var7 -= var5 > 0 ? var24 : -var24;
      }

      if (enemyCanMoveX && !this.blockedByWall) {
         enemyX[var3] = var6;
      }

      if (this.enemyCanMoveY) {
         this.enemyTileY[var3] = var7 / 16;
         this.enemyY[var3] = var7;
      }

      this.setCellFlags(this.enemyTileX[var3], this.enemyTileY[var3] - 1, 2);
   }

   // $VF: renamed from: D () void
   private void resetLevelState() {
      this.playerInvulnerable = false;
      this.im = 0;
      this.il = 0;
      this.be = false;
      this.ba = 0;
      this.finalBossPhase = 0;
      this.bb = 0;
      this.aY = new int[40];
      this.aZ = new int[40];
      this.pauseConfirming = false;
      this.hO = -1;
      this.cameraPanX = -1;
      this.cameraPanTimer = 0;
      this.cameraPanY = -1;
      this.enemyCount = 0;
      pushLast = -1;
      this.hazardLast = -1;
      bossIndex = -1;
      this.finalBossIndex = -1;
      pushLast = -1;
      this.dp = -1;
      this.effectLast = -1;
      bW = -1;
      ck = -1;
      this.switchLast = -1;
      gateLast = -1;
      this.breakLast = -1;
      this.chestLast = -1;
      this.pickupLast = -1;
      cd = -1;
      this.eY = null;
      cw = null;
      this.cJ = null;
      this.eH = null;
      this.bX = null;
      this.ce = null;
      this.dC = null;
      dD = null;
      this.dE = null;
      this.dF = null;
      this.bN = null;
      this.dh = null;
      this.chestSprites = null;
      this.dq = null;
      this.eM = null;
      this.fH = null;
      this.aW = false;
      this.lockRectCount = -1;
      this.releaseAnimSetsAlias();
      this.scene = null;
      this.tileSheet = null;
   }

   // $VF: renamed from: e (int, int, int) void
   private void checkEnemyCell(int var1, int var2, int var3) {
      short var4 = this.enemyHeight[var3];
      boolean var5;
      boolean var6 = (var5 = this.enemyFacingRight[var3]) && super.animDeltaX > 0 || !var5 && super.animDeltaX < 0;
      int var7 = 0;
      boolean var8 = false;
      this.landed = false;
      this.blockedByWall = false;

      for (short var9 = var4; var9 > 0 && enemyCanMoveX; var9 -= 16) {
         if (var2 < mapHeight) {
            if (var2 - var7 < 0 || var2 - var7 >= mapHeight) {
               break;
            }

            if (var9 > 0) {
               if (enemyCanMoveX && var1 >= 0) {
                  enemyCanMoveX = (this.getCellFlags(var1, var2 - var7) & 1) == 0;
                  if (var7 == 0) {
                     var8 = !enemyCanMoveX && (this.getCellFlags(var1, var2 - var7 - 1) & 1) == 0;
                  }

                  boolean var10 = enemyCanMoveX;
                  if (this.enemyClass[var3] == 1 && this.enemyAction[var3] == 1
                     || this.enemyClass[var3] == 2 && this.enemyAction[var3] == 1
                     || this.enemyClass[var3] == 3 && this.enemyAction[var3] == 1) {
                     enemyCanMoveX = enemyCanMoveX
                        & ((this.getCellFlags(var1, var2 - var7) & 2) == 0 || !enemyOnGround || this.eh[var3] || var1 == this.enemyTileX[var3]);
                  }

                  if (var10 != enemyCanMoveX) {
                     eu[var3] = 1500;
                  }
               }

               if (!enemyCanMoveX) {
                  this.blockedByWall = true;
                  if (var8
                     && super.animDeltaX > 0
                     && (this.enemyFacingRight[var3] || super.animDeltaX < 0 && !this.enemyFacingRight[var3])
                     && super.animDeltaY == 0
                     && (this.getCellFlags(var1, var2 - var7 - 1) & 1) == 0) {
                     switch (this.enemyClass[var3]) {
                        case 1:
                           this.setEnemyAction(3, var3);
                        case 2:
                        case 3:
                     }
                  }
                  break;
               }
            }

            if (var1 < 0 || var1 >= mapWidth) {
               enemyCanMoveX = false;
               var5 = !var5;
            }

            if (super.animDeltaY >= 0) {
               var7++;
            } else {
               var7--;
            }

            if (this.enemyClass[var3] == 1
               && this.eh[var3]
               && this.enemyAction[var3] != 26
               && var9 - 16 < 0
               && (this.getCellFlags(var1, var2 - var7) & 16) == 0) {
               enemyCanMoveX = false;
               this.setEnemyAction(26, var3);
               this.enemyY[var3]++;
               break;
            }
         }
      }

      if (enemyCanMoveX && this.enemyAction[var3] == 1 || this.enemyAction[var3] == 0) {
         enemyCanMoveX = (this.getCellFlags(var1, var2 + 1) & 1) == 1;
      }

      int var27 = var1;
      if (super.animDeltaX == 0 && super.animDeltaY != 0) {
         var27 += var5 ? 1 : -1;
      }

      if (super.animDeltaY >= 0) {
         var7 = this.enemyHeightTiles[var3];
         if (this.enemySubY[var3] < 2048) {
            var7++;
         }
      } else {
         var7 = 0;
      }

      int var28 = var2 - var7;
      int var11 = var5 ? -1 : 1;
      if (this.enemyClass[var3] == 1
         && (this.getCellFlags(var27, var28 - 1) & 1) == 0
         && ((this.getCellFlags(var27, var28) & 1) != 0 || this.enemyAtLadderTop[var3])
         && (this.getCellFlags(var27 + var11, var28) & 1) == 0
         && (this.getCellFlags(var27 + var11, var28 - 1) & 1) == 0
         && (this.getCellFlags(var27 + var11, var28 + this.enemyHeightTiles[var3]) & 1) == 0
         && super.animDeltaY != 0
         && (!this.enemyClimbing[var3] || this.enemyAtLadderTop[var3])
         && !enemyOnGround
         && this.enemyAction[var3] != 21
         && this.enemyAction[var3] != 11) {
         if (this.enemyAtLadderTop[var3] && super.animDeltaY < 0) {
            this.setEnemyAction(21, var3);
            int var29 = 0;
            if ((this.getCellFlags(var27, var2) & 1) == 0) {
               var29++;
            }

            this.enemyY[var3] = (var2 + var29) * 16 + var4;
         }

         this.moveAccumY = 0;
         if (!var5) {
            var27++;
         }

         this.blockedByWall = true;
         enemyX[var3] = var27 * 16 + (var5 ? -(this.enemyWidth[var3] >> 1) : this.enemyWidth[var3] >> 1);
         this.moveAccumX = 0;
         this.enemyCanMoveY = false;
         enemyCanMoveX = false;
      } else {
         if (!enemyCanMoveX && super.animDeltaX != 0) {
            var7 = var6 ? -1 : 1;
         } else {
            var7 = 0;
         }

         int var12 = var2;
         int var13;
         if ((var13 = super.animDeltaY > 0 ? var12 - this.enemyHeightTiles[var3] : var12 + this.enemyHeightTiles[var3]) < 0) {
            var13 = 0;
         }

         if (super.animDeltaY != 0) {
            for (short var14 = this.enemyWidth[var3]; var14 > 0; var14 -= 16) {
               if (var1 + var7 >= 0 && var1 + var7 < mapWidth) {
                  if (this.enemyCanMoveY) {
                     this.enemyCanMoveY = (this.getCellFlags(var1 + var7, var12) & 1) == 0;
                     if (this.enemyClass[var3] == 1 && !this.dA && enemyHealth[var3] > 0 && (this.getCellFlags(var1 + var7, var13) & 16) != 0) {
                        this.enemyY[var3] = (var13 + 1) * 16 + var4;
                        this.enemyCanMoveY = false;
                        this.moveAccumY = 0;
                        this.setEnemyAction(26, var3);
                     }
                  }

                  if (!this.enemyCanMoveY && super.animDeltaY > 0 && !this.eh[var3] && this.enemyAction[var3] != 21) {
                     this.enemyY[var3] = var2 * 16;
                     this.moveAccumY = 0;
                     this.landed = true;
                     enemyOnGround = true;
                     switch (this.enemyClass[var3]) {
                        case 1:
                           if (enemyHealth[var3] < 0) {
                              this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 0, this.enemyDropAmount[var3]);
                              this.setEnemyAction(8, var3);
                           } else {
                              if (this.enemyAction[var3] == 25) {
                                 break;
                              }

                              if (this.enemyAction[var3] != 3 && this.enemyAction[var3] != 27) {
                                 this.setEnemyAction(7, var3);
                                 break;
                              }

                              this.setEnemyAction(25, var3);
                           }
                           break;
                        case 2:
                           if (enemyHealth[var3] < 0) {
                              this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 2, this.enemyDropAmount[var3]);
                              this.setEnemyAction(7, var3);
                           } else if (this.enemyAction[var3] != 14) {
                              this.setEnemyAction(9, var3);
                           }
                           break;
                        case 3:
                           this.cameraShake += 6;
                           if (enemyOnGround) {
                              enemyCanMoveX = true;
                           }

                           if (this.enemyAction[var3] != 6 && bossIndex != var3) {
                              if (enemyHealth[var3] < 0) {
                                 this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 0, this.enemyDropAmount[var3]);
                                 this.setEnemyAction(7, var3);
                              } else if (this.enemyAction[var3] != 18) {
                                 this.setEnemyAction(8, var3);
                              }
                           } else if (bossIndex != var3) {
                              if (this.onGround && this.grappledEnemy < 0 && this.dG < 64 && playerAnim != 52 && playerAnim != 53 && playerAnim != 48) {
                                 this.setPlayerAction(27);
                              }
                           } else if (enemyHealth[var3] < 0) {
                              this.setEnemyAction(7, var3);
                              this.spawnPickup(enemyX[var3], this.enemyY[var3] - (this.enemyHeight[var3] >> 1), 0, this.enemyDropAmount[var3]);
                           } else {
                              enemyX[var3]++;
                           }
                     }
                  }

                  if (!this.enemyCanMoveY) {
                     break;
                  }

                  if (var12 < 0 || var12 >= mapHeight) {
                     this.enemyCanMoveY = false;
                  }

                  if (super.animDeltaX == 0) {
                     break;
                  }
               }

               var7 = var6 ? --var7 : ++var7;
            }
         }

         if (this.enemyClimbing[var3] && this.enemyAction[var3] != 21) {
            int var30 = var1;
            var1 += var5 ? 1 : -1;
            if ((this.getCellFlags(var1, var12) & 8) == 0) {
               this.enemyCanMoveY = false;
               this.enemyY[var3] = (var12 + (super.animDeltaY < 0 ? 1 : -this.enemyHeightTiles[var3] - 1)) * 16 + var4;
               this.enemyAtLadderTop[var3] = true;
            }

            var1 = var30;
         } else {
            this.enemyAtLadderTop[var3] = false;
         }

         if (!enemyCanMoveX && super.animDeltaX != 0 && !this.landed && !this.enemyClimbing[var3]) {
            if ((!var5 || super.animDeltaX <= 0) && (var5 || super.animDeltaX >= 0)) {
               this.blockedByWall = true;
               int var32;
               int var33 = (var32 = (var1 + 1) * 16 + (this.enemyWidth[var3] >> 1) + 1) + (this.enemyWidth[var3] >> 1);
               int var34 = var32 / 16;
               int var35 = var33 / 16;
               int var36 = var34 < var35 ? 1 : -1;
               boolean var37 = true;
               int var38 = Math.abs(var35 - var34);

               for (int var39 = 0; var39 <= var38; var39++) {
                  var37 &= (this.getCellFlags(var34 + var39 * var36, var2) & 1) == 0;
               }

               if (var37) {
                  enemyX[var3] = var32;
               }

               if (this.enemyClass[var3] == 1
                  && enemyHealth[var3] > 0
                  && !this.dA
                  && (this.getCellFlags(var1, var12 + (super.animDeltaY > 0 ? -1 : 1)) & 8) != 0
                  && (this.getCellFlags(var1, var12 + (super.animDeltaY > 0 ? -this.enemyHeightTiles[var3] : this.enemyHeightTiles[var3])) & 8) != 0
                  && super.animDeltaY != 0) {
                  this.setEnemyAction(23, var3);
               }
            } else {
               this.blockedByWall = true;
               int var31;
               int var15 = (var31 = var1 * 16 - (this.enemyWidth[var3] >> 1) - 1) - (this.enemyWidth[var3] >> 1);
               int var16 = var31 / 16;
               int var17 = var15 / 16;
               int var18 = var16 < var17 ? 1 : -1;
               boolean var19 = true;
               int var20 = Math.abs(var17 - var16);

               for (int var21 = 0; var21 <= var20; var21++) {
                  var19 &= (this.getCellFlags(var16 + var21 * var18, var2) & 1) == 0;
               }

               if (var19) {
                  enemyX[var3] = var31;
               }

               if (this.enemyClass[var3] == 1
                  && enemyHealth[var3] > 0
                  && !this.dA
                  && (this.getCellFlags(var1, var12 + (super.animDeltaY > 0 ? -1 : 1)) & 8) != 0
                  && (this.getCellFlags(var1, var12 + (super.animDeltaY > 0 ? -this.enemyHeightTiles[var3] : this.enemyHeightTiles[var3])) & 8) != 0
                  && super.animDeltaY != 0) {
                  this.setEnemyAction(23, var3);
               }
            }

            this.moveAccumX = 0;
         }
      }
   }

   // $VF: renamed from: w (int) void
   private void countArenaKill(int var1) {
      int var2 = enemyHomeX[var1] / 16;
      int var3 = enemyHomeY[var1] / 16;
      if ((this.getCellFlags(var2, var3) & 32) > 0) {
         int var4 = -1;

         for (int var5 = 0; var5 < this.arenaTileX.length; var5++) {
            if (pointInRect(var2, var3, this.arenaTileX[var5], this.arenaTileY[var5], this.arenaWidth[var5], arenaHeight[var5])) {
               var4 = var5;
            }
         }

         if (var4 != -1) {
            arenaKills[var4]++;
            if (arenaKills[var4] >= this.arenaKillsNeeded[var4]) {
               this.arenaKillsNeeded[var4] = -1;
               arenaKills[var4] = -1000000;

               for (int var6 = gateLast; var6 >= 0; var6--) {
                  if (this.gateId[var6] == this.arenaGateId[var4]) {
                     gateOpen[var6] = !gateOpen[var6];
                     if (this.gateShowsCamera[var6]) {
                        this.iB = true;
                        this.cameraPanX = gateX[var6];
                        this.cameraPanY = this.gateY[var6];
                     }
                  }
               }
            }
         }
      }
   }

   // $VF: renamed from: x (int) void
   private void triggerSwitchTargets(int var1) {
      for (int var2 = var1 << 2; var2 < (var1 << 2) + 4; var2++) {
         if (this.switchTargets[var2] != 0) {
            for (int var3 = gateLast; var3 >= 0; var3--) {
               if (this.gateId[var3] == this.switchTargets[var2]) {
                  gateOpen[var3] = !gateOpen[var3];
                  if (this.gateShowsCamera[var3]) {
                     this.cameraPanX = gateX[var3];
                     this.cameraPanY = this.gateY[var3];
                     this.iB = true;
                  }
               }
            }
         }
      }
   }

   // $VF: renamed from: a (int, int, int, int, boolean) void
   private void spawnEffect(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = var3;
      if (var5) {
         int var7 = this.comboIndex - 1;
         if (!magicModeA && playerAnim == 60) {
            var7 = 6;
         }

         byte var8;
         if (this.airAttacking) {
            if (magicModeA) {
               var8 = 17;
            } else {
               var8 = 8;
            }
         } else if (magicModeA) {
            var8 = 11;
         } else {
            var8 = 1;
         }

         var6 = var8 + var7;
      }

      if (this.effectLast < 9 && (var3 != 0 || this.effectLast < 9)) {
         this.effectLast++;
         if (effectAnim[this.effectLast] < 0) {
            this.effectFlip[this.effectLast] = var4;
            this.effectX[this.effectLast] = var1;
            this.effectY[this.effectLast] = var2;
            effectAnim[this.effectLast] = this.effectLast;
            this.startAnim(this.effectLast, 7168, var6);
         }
      }
   }

   private void a(int[] var1, byte[] var2) {
      this.hQ = 220;
      this.setFont(this.mainFont);
      this.a(var1, var2, 12, 30, 211, 270, this.hQ);
   }

   private void E() {
      this.M = this.M + this.frameDelta;
      if (this.M >= 50) {
         this.M = 0;
         if (this.heldKey == 1) {
            this.d(true);
            this.requestClear();
         }

         if (this.heldKey == 6) {
            this.d(false);
            this.requestClear();
         }
      }
   }

   // $VF: renamed from: a (int, int, int, int, int, int) boolean
   private static boolean pointInRect(int var0, int var1, int var2, int var3, int var4, int var5) {
      return var0 > var2 && var0 < var2 + var4 && var1 > var3 && var1 < var3 + var5;
   }

   // $VF: renamed from: a (int, int, int, int, int, int, int, int) boolean
   private static boolean rectsOverlap(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return var2 != 0 && var6 != 0 ? var0 + var2 > var4 && var4 + var6 > var0 && var1 + var3 > var5 && var5 + var7 > var1 : false;
   }

   // $VF: renamed from: y (int) void
   private void playSound(int var1) {
      if (var1 != 3 && var1 != 3 && var1 != 3 && var1 != 3) {
         if (var1 == 0 || var1 == 2 || var1 == 1) {
            if (!this.hR) {
               this.soundPlayer.play(var1);
               if (var1 == 0 && iL) {
                  this.hR = true;
               }
            }
         }
      }
   }

   // $VF: renamed from: F () void
   private void stopSounds() {
      this.hR = false;
      this.soundPlayer.stop();
   }

   private void u(Graphics var1) {
      this.v(var1);
      if (!iT) {
         this.iS[1].draw(var1, 120, halfHeight, 0);
         this.iS[0].draw(var1, 120, halfHeight, 0);
      } else {
         this.drawFrame(var1, this.iS, 0, 120, halfHeight, 0);
      }
   }

   private void v(Graphics var1) {
      this.resetClip(var1);
      this.iB = true;
      var1.setColor(0);
      this.iC = false;
      var1.fillRect(0, 0, 240, 320);
   }

   private void a(int[] var1, byte[] var2, int var3, int var4, int var5, int var6, int var7) {
      hW = new String[var7];
      hY = new byte[var7];
      hS = var3;
      hT = var4;
      hU = var5;
      hV = var6;
      ib = var1[0];
      int var9 = 0;
      this.requestClear();
      int var10 = 0;
      String var11 = "";
      this.ii = 0;

      for (int var8 = 0; var8 < var1.length; var8++) {
         byte var12 = var2[var8];
         int var14;
         if ((var14 = var1[var8]) >= 0) {
            var11 = this.getString(var1[var8]);
         } else if (var14 == -1) {
            hW[var10] = "";
            hY[var10++] = var12;
            var11 = "";
         } else if (var14 == -3) {
            var11 = panelText[var9++];
         }

         if (!var11.equals("")) {
            if (var11.charAt(0) == '&') {
               var11 = var11.substring(2, var11.length());
            } else if (var11.charAt(0) == '^') {
               var11 = var11.substring(2, var11.length());
            } else if (var11.charAt(0) == '*') {
               var11 = var11.substring(1, var11.length());
            }
         }

         int var13 = var11.length();
         int var15 = 0;
         int var16 = 0;

         while (var15 < var13) {
            int var18 = 0;
            boolean var19 = false;
            int var17;
            if (this.cr >= 0 && var10 % 5 * lineHeight < this.cp[0].height << 1) {
               var17 = var5 - (this.cp[0].width + 8);
            } else {
               var17 = var5 - 1 - 4;
            }

            while (var18 <= var17 && var16 < var13) {
               char var20;
               if ((var20 = var11.charAt(var16)) == '\n') {
                  var19 = true;
                  break;
               }

               var18 += this.charWidth(var20);
               var16++;
            }

            if (var8 == 0 && ib != -1) {
               this.ij = 0;
               this.ik = var16;
               var16 = var13;
            }

            int var21;
            if (var19) {
               var21 = var16;
            } else if (var16 == var13) {
               var21 = var13 - 1;
            } else if ((var21 = Math.max(var11.lastIndexOf(32, var16), var11.lastIndexOf(46, var16 - 1))) == -1) {
               var21 = Math.min(var16 - 1, var13 - 1);
            } else if (var21 < var15) {
               var21 = var16 - 1;
            }

            if (var21 == var11.length()) {
               var21--;
            }

            hW[var10] = var11.substring(var15, var21 + 1).trim();
            hY[var10++] = var12;
            this.ii = this.ii + lineHeight;
            var16 = var15 = var21 + 1;
         }
      }

      hZ = var10;
      ia = 0;
      this.il = 0;
      ic = false;
      this.resetFrameTimerAlias();
   }

   // $VF: renamed from: G () void
   private static void clearPanelText() {
      hW = null;
      hY = null;
      panelText = null;
   }

   private void d(boolean var1) {
      if (var1) {
         if (ia > 0) {
            ia--;
            this.requestClear();
            return;
         }
      } else if (ia < hZ && !ic) {
         ia++;
         this.requestClear();
      }
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, boolean) void
   private void drawDialogueText(Graphics var1, boolean var2) {
      this.setClip(var1, 0, hT, 240, hV);
      byte var4 = 0;
      this.ip = true;
      if (hV / lineHeight >= hZ) {
         var4 = 2;
      }

      int var6 = hT;
      if (this.aW) {
         var6 = 295 - (this.in >> 8);
      } else if (state == 79) {
         var6 += 25;
      }

      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      if (state == 101) {
         var6 -= this.fontHeight() >> 1;
      }

      this.io = 0;

      int var3;
      for (var3 = this.il > 0 ? this.il : ia; var3 < hZ && var6 < hT + hV; var3++) {
         var11 = var3;
         if (var9 < 1) {
            var11 = var9;
         }

         byte var8;
         int var12 = ((var8 = hY[var11]) & 2) != 0 ? 4 : 1;
         int var7 = hS + var4 + ((var8 & 2) != 0 ? 0 : hU - 4 >> 1) + 1;
         if (this.cr >= 0 && var6 - lineHeight - hT < this.cp[0].height) {
            var7 += this.cp[0].width + 8;
         }

         String var13 = hW[var11];
         if (state == 101 && !var13.equals("")) {
            if (var13.length() > this.bd - this.io) {
               var13 = var13.substring(0, this.bd - this.io);
               this.io = this.io + var13.length();
               this.ip = false;
            } else {
               this.io = this.io + var13.length();
            }
         }

         if (var3 != ia || ib == -1) {
            this.setFont(this.mainFont);
         } else if (this.menuFont != null) {
            this.setFont(this.titleFont);
         } else {
            this.setFont(this.mainFont);
         }

         this.requestClear();
         this.drawString(var1, var3 == ia && ib != -1 ? var13.substring(this.ij, this.ik) : var13, var7, var6, var12);
         var6 += lineHeight;
         if (state == 101 && var6 >= hV && var11 < hZ) {
            this.im = var11;
            if (hW[var11].equals("") || this.im + 1 == hZ) {
               this.im = -1;
            }
            break;
         }

         this.im = -1;
         if (var9++ < 2) {
            var10 = var6;
         }
      }

      ic = var3 == hZ;
      this.resetClip(var1);
      this.iB = true;
      if (var4 == 0 && var2 && !this.aW) {
         var1.setColor(10377532);
         int var16 = hV - (var10 - 25) - 4;
         var1.drawRect(hS + hU + 7 - 1, var10 - 4, 4, var16);
         int var18 = var10 + ia * var16 / hZ - 3;
         int var14 = var10 + var3 * var16 / hZ - 3;
         var1.setColor(15425792);
         var1.fillRect(hS + hU + 7, var18, 3, var14 - var18 - 1);
      }

      if (this.cr >= 0) {
         if (this.cr > 3) {
            int var17 = this.cr - 3 - 1 + 5;
            byte var19 = 0;
            byte var20 = 0;
            if (var17 == 8) {
               var19 = -3;
            }

            if (var17 == 6) {
               var20 = -3;
            }

            int var15;
            if ((var15 = var17 + (upgradeSelection > 0 ? 4 - upgradeSelection : 0)) > 8) {
               var15 = 5 + (var15 - 8) - 1;
            }

            aL[40].draw(var1, hS + (this.cp[this.cr].width >> 3) - aL[40].offsetX, hT + lineHeight - aL[40].offsetY, 0);
            aL[var15].draw(var1, 13 - aL[var15].offsetX + var19, 15 - aL[var15].offsetY + var20, 0);
         } else {
            this.cp[this.cr].draw(var1, hS + (this.cp[this.cr].width >> 3), hT + lineHeight, 0);
         }

         this.startAnim(136, 1024, 0);
         this.drawFrame(var1, this.cp, 136, hS + (this.cp[this.cr].width >> 3), hT + lineHeight, 0);
      }

      if ((var11 < hZ - 1 || this.cs < this.cu - 1) && state == 101) {
         bo[1].draw(var1, halfWidth, 79 - bo[1].height - 2, 0);
      }
   }

   // $VF: renamed from: z (int) void
   private void saveGame(int var1) {
      saveBuffer = new byte[76];
      int var2 = 0;
      var2 = writeIntBE(bladesLevel, saveBuffer, 0);
      var2 = writeIntBE(magicALevel, saveBuffer, var2);
      var2 = writeIntBE(bladesComboLength, saveBuffer, var2);
      var2 = writeIntBE(this.magicAComboLength, saveBuffer, var2);
      var2 = writeIntBE(magicBLevel, saveBuffer, var2);
      var2 = writeIntBE(magicCLevel, saveBuffer, var2);
      var2 = writeIntBE(this.healthChestsFound, saveBuffer, var2);
      var2 = writeIntBE(this.magicChestsFound, saveBuffer, var2);
      var2 = writeIntBE(this.upgradePoints, saveBuffer, var2);
      var2 = writeIntBE(this.upgradeProgressC, saveBuffer, var2);
      var2 = writeIntBE(this.upgradeProgressD, saveBuffer, var2);
      var2 = writeIntBE(this.upgradeProgressA, saveBuffer, var2);
      var2 = writeIntBE(this.upgradeProgressB, saveBuffer, var2);
      var2 = writeIntBE(this.furthestLevel, saveBuffer, var2);
      var2 = writeIntBE(orbsCollected, saveBuffer, var2);
      var2 = writeIntBE(this.orbBudget, saveBuffer, var2);
      var2 = writeIntBE(chestFlags, saveBuffer, var2);
      if (this.killCount > this.bestKillCount && challengeMode) {
         this.bestKillCount = this.killCount;
      }

      writeIntBE(this.bestKillCount, saveBuffer, var2);
      this.unlockLevelMenuEntries();
      Engine.writeRecord(var1 + 1, saveBuffer);
      this.unlockLevelMenuEntries();
   }

   // $VF: renamed from: A (int) void
   private void loadGame(int var1) {
      saveBuffer = Engine.readRecord(var1 + 1);
      if (saveBuffer == null) {
         bladesComboLength = 3;
         this.magicAComboLength = 2;
         magicBLevel = 0;
         magicCLevel = 0;
         this.healthChestsFound = 0;
         this.magicChestsFound = 0;
         this.maxHealth = 1024;
         this.maxMagic = 1024;
         this.upgradePoints = 0;
         this.upgradeProgressC = 0;
         this.upgradeProgressD = 0;
         this.upgradeProgressA = 0;
         this.upgradeProgressB = 0;
         bladesLevel = 0;
         magicALevel = 0;
         this.levelIndex = 0;
         this.furthestLevel = 0;
         orbsCollected = 0;
         this.orbBudget = 0;
         chestFlags = 0;
         this.bestKillCount = 0;
      } else {
         bladesLevel = (byte)readIntBE(saveBuffer, 0);
         magicALevel = (byte)readIntBE(saveBuffer, 4);
         bladesComboLength = (byte)readIntBE(saveBuffer, 8);
         this.magicAComboLength = (byte)readIntBE(saveBuffer, 12);
         if (bladesComboLength < 3) {
            bladesComboLength = 3;
         }

         if (this.magicAComboLength < 2) {
            this.magicAComboLength = 2;
         }

         magicBLevel = (byte)readIntBE(saveBuffer, 16);
         magicCLevel = (byte)readIntBE(saveBuffer, 20);
         this.healthChestsFound = readIntBE(saveBuffer, 24);
         this.magicChestsFound = readIntBE(saveBuffer, 28);
         this.maxHealth = this.healthChestsFound * 192 + 1024;
         this.maxMagic = this.magicChestsFound * 192 + 1024;
         this.upgradePoints = readIntBE(saveBuffer, 32);
         this.upgradeProgressC = readIntBE(saveBuffer, 36);
         this.upgradeProgressD = readIntBE(saveBuffer, 40);
         this.upgradeProgressA = readIntBE(saveBuffer, 44);
         this.upgradeProgressB = readIntBE(saveBuffer, 48);
         this.furthestLevel = readIntBE(saveBuffer, 52);
         this.levelIndex = this.furthestLevel;
         orbsCollected = readIntBE(saveBuffer, 56);
         this.orbBudget = readIntBE(saveBuffer, 60);
         chestFlags = readIntBE(saveBuffer, 64);
         this.bestKillCount = readIntBE(saveBuffer, 68);
      }

      this.unlockLevelMenuEntries();
   }

   // $VF: renamed from: H () void
   private void unlockLevelMenuEntries() {
      for (int var1 = 0; var1 < 10; var1++) {
         if (var1 <= this.furthestLevel) {
            menuTable[9 + var1] = menuTable[9 + var1] = menuTable[9 + var1] | 50331648;
         } else {
            menuTable[9 + var1] = menuTable[9 + var1] & -50331649;
         }
      }
   }

   // $VF: renamed from: a (int, byte[], int) int
   private static int writeIntBE(int var0, byte[] var1, int var2) {
      var1[var2++] = (byte)(var0 >> 24 & 0xFF);
      var1[var2++] = (byte)(var0 >> 16 & 0xFF);
      var1[var2++] = (byte)(var0 >> 8 & 0xFF);
      var1[var2++] = (byte)(var0 & 0xFF);
      return var2;
   }

   // $VF: renamed from: a (byte[], int) int
   private static int readIntBE(byte[] var0, int var1) {
      return ((var0[0 + var1] & 0xFF) << 24) + ((var0[1 + var1] & 0xFF) << 16) + ((var0[2 + var1] & 0xFF) << 8) + (var0[3 + var1] & 0xFF);
   }

   // $VF: renamed from: I () void
   private void updateFireEffect() {
      int var2 = 240 - (this.iu - (this.iu >> 2));
      if (fireHeat == null) {
         fireHeat = new byte[var2 * 140];
         firePixels = new int[var2 * 140];
      }

      int var3 = 0;
      if (fireReseed) {
         for (int var4 = 0; var4 < var2; var4++) {
            if ((var4 & 3) == 0) {
               var3 = random.nextInt();
            } else {
               var3 >>= 8;
            }

            fireHeat[var4 + 139 * var2] = (byte)(var3 & 0xFF);
            fireHeat[var4 + 138 * var2] = (byte)Math.max(0, (fireHeat[var4 + 139 * var2] & 255) - 4);
            fireReseed = false;
         }
      } else {
         fireReseed = true;
      }

      for (int var5 = 1; var5 < 139; var5++) {
         int var1 = var5 * var2;

         for (int var6 = 0; var6 < var2; var6++) {
            int var9 = var6 + var1;
            int var7 = (fireHeat[var9] & 255) + (fireHeat[var9 + var2] & 255);
            if (var5 > 35) {
               var7 = var7 + (fireHeat[var9 + 1] & 255) + (fireHeat[var9 - 1] & 255) >> 2;
            } else {
               var7 >>= 1;
            }

            var7 -= 2;
            if (var7 < 0) {
               var7 = 0;
            }

            fireHeat[var9 - var2] = (byte)var7;
         }
      }

      int var10 = 0;

      for (int var14 = 0; var14 < 140; var14++) {
         for (int var8 = 0; var8 < var2; var8++) {
            int var11 = Math.max(fireHeat[var10] & 255, 0);
            firePixels[var10] = R[var11];
            var10++;
         }
      }
   }

   // $VF: renamed from: b (javax.microedition.lcdui.Graphics, boolean) void
   private void drawFireEffect(Graphics var1, boolean var2) {
      this.updateFireEffect();
      int var3 = var2 ? 0 : 95;
      int var4 = var2 ? 172 : 173;
      Engine.drawRgbAlias(var1, firePixels, 0, 240 - (this.iu - (this.iu >> 2)), var3, var4, 240 - (this.iu - (this.iu >> 2) + 1), 140, false);
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int, int) void
   private void drawBottomBar(Graphics var1, int var2, int var3) {
      this.iA = var3;
      this.iz = var2;
      this.setFont(this.mainFont);
      var1.setColor(0);
      var1.fillRect(0, 306, 240, 14);
      var1.setColor(9787452);
      var1.drawLine(0, 306, 240, 306);
      var1.setColor(4269078);
      var1.drawLine(0, 307, 240, 307);
      if ((this.topBar == this.topBarTarget && this.bottomBar == this.bottomBarTarget || state == 106) && this.cameraPanX < 0 && (!qteActive || state == 102)) {
         if (var2 != -1) {
            this.drawSoftKeyLabel(var1, 0, var2, 2);
         }

         if (var3 != -1) {
            this.drawSoftKeyLabel(var1, 240, var3, 0);
         }

         if (state == 100) {
            if (!challengeMode) {
               if (this.activeArena == -1 || this.arenaKillsNeeded[this.activeArena] <= 0 && this.arenaBannerTimer <= 0) {
                  if (comboHits > 1 && this.comboTimer > 0 && state == 100 && this.bottomBar <= 0 && this.iv < comboHits) {
                     this.drawString(var1, comboHits + " " + this.getString(171), 120, 306 + halfLineHeight - 3, 1);
                  }
               } else {
                  String var4 = this.arenaKillsNeeded[this.activeArena] - arenaKills[this.activeArena] + " " + this.getString(195);
                  int var5 = this.stringWidth(var4);
                  if (gM && this.arenaKillsNeeded[this.activeArena] > 0) {
                     this.drawString(var1, var4, halfWidth, 306 + halfLineHeight - 3, 1);
                  }

                  if (this.activeArena >= 0 && this.arenaKillsNeeded[this.activeArena] > 0) {
                     int var6 = halfWidth - (var5 >> 1) - 5;
                     int var7 = halfWidth + (var5 >> 1) + 5;
                     var1.setColor(14172934);
                     var1.drawLine(var6 - 4, 307, var6 - 4, 320);
                     var1.drawLine(var7 + 4, 307, var7 + 4, 320);
                     var1.setColor(14038016);
                     var1.drawLine(var6 - 3, 307, var6 - 3, 320);
                     var1.drawLine(var7 + 3, 307, var7 + 3, 320);
                     var1.setColor(13116929);
                     var1.drawLine(var6 - 2, 307, var6 - 2, 320);
                     var1.drawLine(var7 + 2, 307, var7 + 2, 320);
                     var1.setColor(10885383);
                     var1.drawLine(var6 - 1, 307, var6 - 1, 320);
                     var1.drawLine(var7 + 1, 307, var7 + 1, 320);
                     var1.setColor(7146758);
                     var1.drawLine(var6, 307, var6, 320);
                     var1.drawLine(var7, 307, var7, 320);
                  }
               }
            } else if (this.killCount >= 1000) {
               this.drawString(var1, this.getString(275), 120, 306 + halfLineHeight - 3, 1);
            } else {
               this.drawString(var1, this.getString(246) + this.killCount, 120, 306 + halfLineHeight - 3, 1);
            }
         } else {
            this.iB = true;
         }
      }

      this.iB = false;
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int) void
   private void drawSoftKeyLabel(Graphics var1, int var2, int var3, int var4) {
      String var5 = this.getString(var3);
      this.drawString(var1, var5, var2 - (var4 == 0 ? this.stringWidth(var5) + 2 : -2), 306 + halfLineHeight - 3, 20);
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, boolean) void
   private static void drawProgressBar(Graphics var0, int var1, int var2, boolean var3) {
      if (state != 1) {
         var2 -= 2;
         var1 -= 2;
      }

      int var4 = 307;
      if (state == 1) {
         var4 = halfHeight + 5 + (lineHeight >> 2);
         if (challengeMode) {
            var4 += lineHeight + (lineHeight >> 2);
         }
      }

      int var5 = var2 * 5 + (var2 + 1) * 2 - 1;
      int var6 = (240 - var5) / 2;
      var0.setColor(0);
      var0.fillRect(var6 - 1, var4 - 1, var5 + 3, 13);
      var0.setColor(15690496);
      var0.drawRect(var6, var4, var5, 10);
      var0.setColor(16711680);
      var4 += 2;
      var6 += 2;
      if (var3) {
         for (int var7 = 0; var7 < var1; var7++) {
            var0.fillRect(var6, var4, 5, 7);
            var6 += 7;
         }
      }

      var0.setColor(3737600);
      int var11 = var3 ? var1 : 0;

      for (int var8 = (var3 ? var1 : 0) < 0 ? 0 : var11; var8 < var2; var8++) {
         if (!var3) {
            if (var8 == var1) {
               var0.setColor(16711680);
            } else {
               var0.setColor(3737600);
            }
         }

         var0.fillRect(var6, var4, 5, 7);
         var6 += 7;
      }
   }

   // $VF: renamed from: J () void
   private void loadMenuTable() {
      byte[] var1;
      int var2;
      menuTable = new int[var2 = (var1 = this.getResourceBytes(1028)).length >> 2];

      for (int var3 = var2 - 1; var3 >= 0; var3--) {
         int var4 = var3 << 2;
         menuTable[var3] = ((var1[var4] & 255) << 24) + ((var1[var4 + 1] & 255) << 16) + ((var1[var4 + 2] & 255) << 8) + (var1[var4 + 3] & 255);
      }
   }

   // $VF: renamed from: k (int, int) int
   private static int menuNextWithFlag(int var0, int var1) {
      int var2 = var0;

      while (var0 < menuTable.length && (menuTable[var0] & 4194304) == 0) {
         if ((menuTable[++var0] & var1) != 0) {
            return var0;
         }

         if ((menuTable[var0] & 4194304) != 0) {
            return var2;
         }
      }

      return var2;
   }

   // $VF: renamed from: l (int, int) int
   private static int menuPrevWithFlag(int var0, int var1) {
      int var2 = var0;

      do {
         if ((menuTable[var0] & 8388608) == 0) {
            if ((menuTable[--var0] & var1) != 0) {
               var2 = var0;
            }
         }

         if ((menuTable[var0] & 8388608) != 0 && (menuTable[var0] & var1) == 0) {
            return var2;
         }
      } while ((menuTable[var0] & var1) == 0);

      return var2;
   }

   // $VF: renamed from: K () void
   private void updateMenu() {
      int var1 = menuCursor;
      int var2;
      int var3 = (var2 = menuTable[menuCursor]) >> 26;
      int var4 = var2 >> 8 & 0xFF;
      switch (var3) {
         case 0:
            if (this.pressedKey == 8 || this.pressedKey == 27) {
               if (var4 == 9 && this.levelIndex == 0) {
                  challengeMode = false;
                  this.levelIndex = 0;
                  this.levelResourceId = 9217;
                  this.setBarTargets(halfHeight, halfHeight, 35, 35);
                  state = 1;
                  this.resetLevelState();
                  this.soundPlayer.stop();
                  this.levelLoadStarted = false;
                  this.W = true;
               } else {
                  var1 = var4;
               }
            }
            break;
         case 1:
            if (this.pressedKey == 8 || this.pressedKey == 27) {
               this.soundPlayer.setSoundOn(!this.soundPlayer.isSoundOn());
               iL = this.soundPlayer.isSoundOn();
               if (!this.soundPlayer.isSoundOn()) {
                  this.hR = false;
               }

               this.playSound(0);
            }
         case 2:
         case 7:
         default:
            break;
         case 3:
            if (this.pressedKey == 8 || this.pressedKey == 27) {
               this.ai = false;
               this.aj = true;
               this.setBarTargets(halfHeight, halfHeight, 35, 35);
            }
            break;
         case 4:
            if (this.pressedKey == 8 || this.pressedKey == 27) {
               this.ai = true;
               this.aj = true;
               this.setBarTargets(halfHeight, halfHeight, 35, 35);
            }
            break;
         case 5:
            if (this.pressedKey == 8 || this.pressedKey == 27) {
               this.levelIndex = menuCursor - this.iG;
               this.bf = false;
               this.levelResourceId = levelIds[this.levelIndex];
               challengeMode = false;
               this.setBarTargets(halfHeight, halfHeight, 35, 35);
               state = 1;
               this.levelLoadStarted = false;
               this.resetLevelState();
               this.stopSounds();
            }
            break;
         case 6:
            if (this.pressedKey == 8 || this.pressedKey == 27) {
               this.levelResourceId = 9216;
               this.levelIndex = 0;
               this.killCount = 0;
               challengeMode = true;
               this.setBarTargets(halfHeight, halfHeight, 35, 35);
               state = 1;
               this.levelLoadStarted = false;
               this.resetLevelState();
               this.stopSounds();
            }
            break;
         case 8:
            if (this.pressedKey == 8 || this.pressedKey == 27) {
               this.saveAndQuit();
            }
            break;
         case 9:
            if (this.pressedKey == 8 || this.pressedKey == 27) {
               this.loadMenuSprites(false);
               state = this.J;
            }
            break;
         case 10:
            if (this.pressedKey == 8 || this.pressedKey == 27) {
               this.resetLevelState();
               this.playSound(0);
               this.parseBank(null);
               this.saveGame(1);
               this.iy = menuCursor;
               var1 = var4;
            }
            break;
         case 11:
            if (this.pressedKey == 8 || this.pressedKey == 27 || this.pressedKey == 29) {
               if (this.pressedKey != 29) {
                  byte[] var5 = new byte[76];
                  Engine.writeRecord(2, var5);
                  this.loadGame(1);
               }

               var1 = var4;
            }
            break;
         case 12:
            if (this.pressedKey == 8 || this.pressedKey == 27) {
               languageIndex++;
               if (languageIndex > 5) {
                  languageIndex = 0;
               }

               this.loadStringTable(languageStringBanks[languageIndex]);
               this.iB = true;
            }
      }

      if (this.pressedKey != 0) {
         this.iI = false;
         this.iC = true;
      }

      if (this.pressedKey == 2) {
         var1 = menuPrevWithFlag(var1, 33554432);
      }

      if (this.pressedKey == 5) {
         var1 = menuNextWithFlag(var1, 33554432);
      }

      if (this.be) {
         this.iI = false;
         menuCursor++;
         this.levelIndex++;
         if (this.levelIndex > this.furthestLevel) {
            this.furthestLevel = this.levelIndex;
         }

         this.levelResourceId++;
         state = 1;
         this.ae = true;
         this.levelLoadStarted = false;
         this.stopSounds();
      }

      if (this.pressedKey == 29 && var3 != 11) {
         if (this.iA == 2 || this.iA == 29) {
            var1 = this.iy;
            this.iI = false;
         } else if (this.iA == 1) {
            var1 = 23;
         }
      } else if (this.pressedKey == 27 && var3 == 0 && this.iz == 0 && (var4 != 9 || this.levelIndex != 0)) {
         var1 = var4;
         this.iI = false;
      }

      if (menuCursor != var1) {
         menuCursor = var1;
         if ((menuTable[menuCursor] & 33554432) == 0) {
            menuCursor = menuNextWithFlag(var1, 33554432);
         }

         this.requestClear();
      }
   }

   private void L() {
      if (this.pressedKey == 8 || this.pressedKey == 27) {
         this.iC = true;
      }
   }

   // $VF: renamed from: M () void
   private void saveAndQuit() {
      if (state != 0 && state != 79 && !iK) {
         this.saveGame(1);
      }

      this.postLifecycle(3);
   }

   // $VF: renamed from: w (javax.microedition.lcdui.Graphics) void
   private void drawMenu(Graphics var1) {
      int var2 = 0;
      int var3 = 0;
      if (this.screenWidth > this.screenHeight) {
         var2 = -(this.screenWidth >> 3);
      }

      if (this.iC || (this.topBar > 0 || this.ak) && this.iI && state != 1) {
         this.v(var1);
      }

      this.setFont(this.titleFont);
      this.drawString(var1, this.getString(274), halfWidth + var2, this.menuSprites[0].height + this.menuSprites[1].height, 1);
      this.setFont(this.menuFont);
      int var4 = menuCursor;
      int var6 = 0;

      while (var4 == 1 || var4 > 1 && (menuTable[var4] & 8388608) == 0) {
         if ((menuTable[--var4] & 16777216) != 0) {
            var6++;
         }
      }

      int var7 = var4;
      var4 = menuCursor;

      for (int var8 = 0; var8 < var6; var8++) {
         var4 = menuPrevWithFlag(var4, 16777216);
      }

      this.iG = var4;

      for (int var18 = 0; var18 < var6; var18++) {
         var4 = menuPrevWithFlag(var4, 33554432);
      }

      this.iH = var4;
      this.iD = 0;
      int var10 = var4;
      int var11 = var4;
      if (this.iI && this.topBar <= 0 && !this.ak) {
         this.setClip(var1, 0, 166, 240, 140);
      } else {
         this.resetClip(var1);
      }

      this.drawFireEffect(var1, true);

      for (int var13 = this.iI && this.topBar <= 0 && !this.ak ? 2 : 0; var13 <= 4; var13++) {
         this.menuSprites[var13].draw(var1, var13 < 2 ? halfWidth + var2 : this.screenWidth + 0, var13 < 2 ? 0 : this.screenHeight, 0);
      }

      if (this.ak) {
         this.ak = false;
      }

      this.iI = true;
      this.iF = this.menuSprites[0].height + this.menuSprites[1].height + (lineHeight << 1);
      if (-this.menuSprites[2].offsetY + this.iF >= this.screenHeight && var2 == 0) {
         var3 = -(this.screenWidth >> 3);
      }

      while (true) {
         if ((menuTable[var11] & 16777216) != 0) {
            var10 = var11;
         }

         if ((menuTable[var11] & 33554432) != 0) {
            var7 = var11;
         }

         if ((menuTable[var11] & 4194304) != 0) {
            this.iD = this.screenWidth < this.iD ? this.screenWidth : this.iD;
            this.iE = 120;
            var1.setColor(0, 0, 255);
            var4 = this.iG;
            this.setFont(this.menuFont);

            boolean var19;
            do {
               int var9;
               int var5 = (var9 = menuTable[var4]) >> 26;
               if ((var9 & 16777216) != 0) {
                  int var14;
                  if ((var14 = var9 & 0xFF) == 23) {
                     int var15 = languageIndex + 1 > 5 ? 0 : languageIndex + 1;
                     var14 = languageNameStrings[var15];
                  }

                  String var20 = this.getString(var14);
                  switch (var5) {
                     case 1:
                        var20 = var20 + " " + (iL ? this.getString(234) : this.getString(235));
                     case 0:
                     case 3:
                     case 4:
                     case 5:
                     case 6:
                     case 8:
                     case 9:
                     case 10:
                     case 11:
                     case 12:
                        if (var4 == menuCursor) {
                           if (var14 != 28 && var14 != 29) {
                              if (var4 > this.iH) {
                                 bo[2].draw(var1, halfWidth - this.iJ - (bo[2].width << 1) + var2 + var3, this.iF + (lineHeight >> 3) + 4, 0);
                              }

                              this.drawString(var1, var20, this.iE + var2 + var3, this.iF, 1);
                              if (var4 < var7) {
                                 bo[3].draw(var1, halfWidth + this.iJ + bo[3].width + var2 + var3, this.iF + (lineHeight >> 3) + 4, 0);
                              }
                           }

                           this.iF = this.iF + lineHeight + (lineHeight >> 2);
                        }
                     case 2:
                     case 7:
                  }
               }

               if (var19 = var4 < var10) {
                  var4 = menuNextWithFlag(var4, 16777216);
               }
            } while (var19);

            return;
         }

         var11++;
      }
   }
}
