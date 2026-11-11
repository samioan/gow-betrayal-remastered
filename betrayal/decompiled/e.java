import java.io.DataInputStream;
import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class e extends a {
   private static boolean iQ = false;
   private final d iR;
   public c[] m;
   public c[] n;
   public c[] o;
   public c[] p;
   public int q;
   public int r;
   public String s;
   public int t = 0;
   public boolean u = false;
   public static int v = 0;
   public static final int[] w = new int[]{10240, 12288, 33792, 29696, 30720, 32768};
   public static final int[] x = new int[]{23, 24, 21, 20, 22, 19};
   public static int y;
   public static int z;
   public boolean A;
   public boolean B = false;
   public boolean C = false;
   public int D = 240;
   public int E = 320;
   public static int F;
   public static int G;
   public static int H;
   public int I;
   public int J = 0;
   public int K;
   public int L;
   public int M;
   public static Random N;
   private static boolean iS = false;
   private b iT;
   private Image iU;
   private b iV;
   private static int iW;
   private static int iX;
   public int[] O = new int[4];
   private c[] iY;
   public int P = 0;
   private static boolean iZ = false;
   private static boolean ja = false;
   public static int[] Q;
   public static byte[] R;
   public int S;
   public int T;
   public int U;
   public boolean V;
   public boolean W;
   public boolean X;
   public boolean Y;
   public int Z;
   public int aa;
   public int ab;
   public int ac;
   public boolean ad;
   public int ae;
   public int af;
   public boolean ag;
   public boolean ah;
   public boolean ai;
   public boolean aj;
   public boolean ak;
   public boolean al;
   public boolean am;
   public boolean an;
   public boolean ao;
   public boolean ap;
   public static byte aq = 4;
   public boolean ar;
   public int as;
   public boolean at;
   public int au = 0;
   public int av = 0;
   public int aw = 200;
   public int ax = -1;
   public int ay = -1;
   public int az;
   public int aA;
   public int aB;
   public int aC = -1;
   public int[] aD;
   public int[] aE;
   public boolean[] aF;
   public boolean[] aG;
   public int aH = 0;
   public int aI = 0;
   public int aJ = 60;
   public static c[] aK;
   public int aL;
   public int aM;
   public int aN;
   public int aO;
   public int[] aP = new int[2];
   public boolean aQ = false;
   public boolean aR;
   public int aS = -1;
   public c[] aT;
   public static final byte[] aU = new byte[]{11, 2, 2, 2, 2};
   public boolean aV = false;
   public int aW;
   public int[] aX = new int[40];
   public int[] aY = new int[40];
   public int aZ;
   public int ba;
   public boolean bb;
   public int bc;
   public boolean bd = false;
   public boolean be = false;
   public int bf = 0;
   public static byte bg = 3;
   public boolean bh;
   public static byte bi = 0;
   public boolean bj = false;
   public int bk = 0;
   public int bl = 0;
   public int bm;
   public static String bn;
   public int bo;
   public int bp;
   public static c[] bq;
   public int br = 0;
   public int bs;
   private byte[] jb;
   private short[] jc;
   private static int jd;
   private static int je;
   private static int jf;
   private static int jg;
   private static int jh;
   public int bt;
   public int[] bu;
   public int[] bv;
   public int bw;
   public int bx;
   public int by;
   public int bz;
   public int bA;
   public int bB;
   public int bC = -1;
   public static final int[] bD = new int[]{9217, 19456, 20480, 21504, 22528, 23552, 24576, 25600, 26624, 27648};
   public static final int[] bE = new int[]{9219, 19457, 20481, 21505, 22529, 23553, 24577, 25601, 26625, 27649};
   public int bF;
   public int bG;
   public int bH;
   public String bI;
   public int bJ = -1;
   public static final int[] bK = new int[]{-1, -1, -1, 2, 0, 1, 1, 0, 2, 2};
   private byte[] ji;
   private int jj;
   private int jk;
   private int jl;
   public c[] bL;
   public static int[] bM = new int[10];
   public int[] bN = new int[10];
   public int[] bO = new int[10];
   public int[] bP = new int[10];
   public int bQ = -1;
   public c[] bR;
   public int[] bS = new int[10];
   public static int[] bT = new int[10];
   public int[] bU = new int[10];
   public static int[] bV = new int[10];
   public int[] bW = new int[10];
   public int[] bX = new int[10];
   public int[] bY = new int[10];
   public boolean[] bZ = new boolean[10];
   public static int ca = -1;
   public c[] cb;
   public int[] cc = new int[20];
   public static int[] cd = new int[20];
   public static int[] ce = new int[20];
   public int[] cf = new int[20];
   public int[] cg = new int[20];
   public static int ch = -1;
   public c[] ci;
   public int[] cj = new int[20];
   public int[] ck = new int[20];
   public static int[] cl = new int[20];
   public int[] cm = new int[20];
   public int[] cn = new int[20];
   public static int co = -1;
   public int[] cp;
   public static int[] cq;
   public int[] cr;
   public int[] cs;
   public c[] ct;
   public c[] cu;
   public int cv = -1;
   public int cw;
   public int cx;
   public int cy;
   public static int cz;
   public static c[] cA;
   public int cB = -1;
   public int[] cC;
   public static int[] cD;
   public boolean[] cE;
   public int[] cF;
   public int[] cG;
   public boolean[] cH;
   public static int[] cI;
   public int[] cJ;
   public static int[] cK;
   public int[] cL;
   public static int cM = -1;
   public c[] cN;
   public static int[] cO;
   public static int[] cP;
   public static int[] cQ;
   public int[] cR;
   public static int[] cS;
   public static int[] cT;
   public int[] cU;
   public int[] cV;
   public int[] cW;
   public static int[] cX;
   public int[] cY;
   public static boolean[] cZ;
   public boolean[] da;
   public byte[] db;
   public int[] dc;
   public static int[] dd;
   public int[] de;
   public int[] df;
   public int[] dg;
   public static int[] dh;
   public int[] di;
   public static int[] dj;
   public int[] dk;
   public c[] dl;
   public int[] dm = new int[10];
   public int[] dn = new int[10];
   public int[] do = new int[10];
   public static int[] dp = new int[10];
   public static int[] dq = new int[10];
   public int[] dr = new int[10];
   public int[] ds = new int[10];
   public int dt = -1;
   public c[] du;
   public int[] dv = new int[15];
   public int[] dw = new int[15];
   public static int[] dx = new int[15];
   public int[] dy = new int[15];
   public int[] dz = new int[15];
   public int[] dA = new int[15];
   public static int[] dB = new int[15];
   public int[] dC = new int[15];
   public int dD = -1;
   public boolean dE;
   public boolean dF;
   public c[] dG;
   public static c[] dH;
   public c[] dI;
   public c[] dJ;
   public int dK;
   public int dL = 0;
   public int dM;
   public static int[] dN = new int[15];
   public int[] dO = new int[15];
   public int dP;
   public static int dQ;
   public int dR;
   public byte dS;
   public int[] dT = new int[15];
   public byte[] dU = new byte[15];
   public int[] dV = new int[15];
   public byte[] dW = new byte[15];
   public static int[] dX = new int[15];
   public int[] dY = new int[15];
   public static int[] dZ = new int[15];
   public static int[] ea = new int[15];
   public int[] eb = new int[15];
   public byte[] ec = new byte[15];
   public int[] ed = new int[15];
   public int[] ee = new int[15];
   public static byte[] ef = new byte[15];
   public static byte[] eg = new byte[15];
   public static byte[] eh = new byte[15];
   public short[] ei = new short[15];
   public short[] ej = new short[15];
   public byte[] ek = new byte[15];
   public boolean[] el = new boolean[15];
   public boolean[] em = new boolean[15];
   public boolean[] en = new boolean[15];
   public static int[] eo = new int[15];
   public byte[] ep = new byte[15];
   public int[] eq = new int[15];
   public static int[] er = new int[15];
   public int[] es = new int[15];
   public int[] et = new int[15];
   public boolean[] eu = new boolean[15];
   public static int[] ev = new int[15];
   public static boolean[] ew = new boolean[15];
   public int[] ex = new int[15];
   public static int[] ey = new int[15];
   public static boolean[] ez = new boolean[15];
   public static short[] eA = new short[30];
   public static boolean eB = true;
   public boolean eC;
   public boolean eD = true;
   public static boolean eE = true;
   public int eF;
   public int[] eG;
   public int[] eH;
   public int[] eI;
   public int[] eJ;
   public boolean[] eK;
   public c[] eL;
   public int[] eM;
   public int[] eN;
   public int[] eO;
   public static byte[] eP;
   public c[] eQ;
   public int[] eR;
   public int[] eS;
   public int[] eT;
   public static int[] eU;
   public int[] eV;
   public int[] eW;
   public int[] eX;
   public byte[] eY;
   public byte[] eZ;
   public static boolean[] fa;
   public static int fb = -1;
   public c[] fc;
   public int fd = -1;
   public int[] fe;
   public int[] ff;
   public static int[] fg;
   public static int[] fh;
   public int[] fi;
   public static int[] fj;
   public int[] fk;
   public byte[] fl;
   public byte[] fm;
   public static boolean[] fn;
   public static boolean[] fo;
   public c[] fp;
   public int fq = -1;
   public int fr;
   public int fs;
   public static boolean[] ft;
   public int[] fu;
   public int[] fv;
   public static int[] fw;
   public int[] fx = new int[10];
   public c[] fy;
   public int fz = -1;
   public int fA = 0;
   public c[] fB;
   public static final int[] fC = new int[80];
   public static final int[] fD = new int[80];
   public static final int[] fE = new int[20];
   public static final int[] fF = new int[20];
   public static final int[] fG = new int[20];
   public static final int[] fH = new int[20];
   public static final int[] fI = new int[20];
   public static final int[] fJ = new int[20];
   public int fK = -1;
   public c[] fL;
   public static final byte[] fM = new byte[]{2, 2, 2, 4, 4, 4, 8};
   public static final byte[] fN = new byte[]{4, 4, 10, 10, 18, 18};
   public static final byte[] fO = new byte[]{2, 3, 4, 5, 6};
   public static final int[] fP = new int[]{128, 256, 512, 1024, 1536};
   public int fQ = 0;
   public boolean fR;
   public int fS;
   public int fT;
   public int fU;
   public static boolean fV;
   public int fW;
   public int fX;
   public static final int[] fY = new int[]{2, 4, 5, 6, 8};
   public boolean fZ;
   public int ga;
   public int gb;
   public int gc;
   public int gd;
   public int ge;
   public int gf;
   public static int gg;
   public static int gh;
   public int gi = -1;
   public boolean gj;
   public static boolean gk;
   public static boolean gl;
   public boolean gm;
   public boolean gn;
   public boolean go;
   public byte gp;
   public boolean gq;
   public boolean gr;
   public boolean gs;
   public boolean gt;
   public static boolean gu;
   public static boolean gv;
   public boolean gw;
   public boolean gx;
   public boolean gy;
   public boolean gz;
   public int gA;
   public static int gB;
   public boolean gC;
   public boolean gD;
   public boolean gE;
   public static boolean gF;
   public static int gG;
   public int gH;
   public boolean gI;
   public static int gJ;
   public int gK;
   public static int gL = 0;
   public int gM = 0;
   public int gN = -1;
   public int gO;
   public int gP;
   public static boolean gQ;
   public static byte gR;
   public byte gS;
   public static byte gT;
   public static byte gU;
   public static final int[] gV = new int[]{1000, 2000, 3000, 4000};
   public static final int[] gW = new int[]{1000, 2000, 3000, 4000};
   public static final int[] gX = new int[]{1000, 2000, 3000, 4000};
   public static final int[] gY = new int[]{1000, 2000, 3000, 4000};
   public static byte gZ = 0;
   public static byte ha = 0;
   public int hb;
   public int hc;
   public int hd;
   public int he;
   public static boolean hf = false;
   public static boolean hg = false;
   public boolean hh = false;
   public static int hi;
   public static byte hj;
   public int hk;
   public static int hl;
   public int hm;
   public int hn;
   public int ho;
   public static int hp;
   public int hq;
   public int hr;
   public int hs;
   public int ht;
   public int hu;
   public static int hv;
   public int hw;
   public short[] hx = new short[20];
   public static boolean hy;
   public boolean hz;
   public boolean hA;
   public int hB;
   public int hC;
   public int hD;
   public int hE = -1;
   public static int hF = -1;
   public boolean hG = true;
   public static boolean hH = true;
   public boolean hI = false;
   public boolean hJ = false;
   public boolean hK = false;
   public int hL = 0;
   public int hM;
   public int hN;
   public int hO = 0;
   public int hP = 0;
   public short[] hQ = new short[256];
   public int hR = 0;
   public int hS;
   public int hT = -1;
   public int hU;
   public boolean hV;
   public static int hW;
   public static int hX;
   public static int hY;
   public static int hZ;
   public static String[] ia;
   public static String[] ib;
   public static byte[] ic;
   public static int id;
   public static int ie;
   public static int if;
   public static boolean ig;
   public static final int[] ih = new int[]{40, -1, -3, -3, -3};
   public static final int[] ii = new int[]{42, -1, -3, -3, -3};
   public static final int[] ij = new int[]{44, -1, -3, -3, -3};
   public static final byte[] ik = new byte[]{13, 4, 2, 2, 2};
   public static final byte[] il = new byte[]{13, 4, 4, 4, 4};
   public int im;
   public int in;
   public int io;
   public int ip;
   public int iq;
   public int ir;
   public int is;
   public boolean it;
   public static byte[] iu;
   public static byte[] iv;
   public static int[] iw;
   public static boolean ix = true;
   public int iy;
   public int iz = -1;
   public static int[] iA;
   public static int iB;
   public int iC;
   public int iD;
   public int iE;
   public boolean iF;
   public boolean iG = false;
   public boolean iH = false;
   public int iI;
   public int iJ;
   public int iK;
   public int iL;
   public int iM;
   public boolean iN = false;
   public int iO;
   public static boolean iP;

   static {
      int[] var10000 = new int[]{320, 420, 690, 400, 500, 590, 1030};
      var10000 = new int[]{-1, -1, -1};
      int[] var1 = new byte[]{13, 4, 4};
      var1 = new int[]{-1, 64};
   }

   private void k() {
      int var1 = super.h;
      if (super.h != 0) {
         if ((var1 & 2097408) != 0) {
            this.q = 8;
         } else if ((var1 & 4194336) != 0) {
            this.q = 5;
         } else if ((var1 & 1048580) != 0) {
            this.q = 2;
         } else if ((var1 & 262146) != 0) {
            this.q = 1;
         } else if ((var1 & 16777280) != 0) {
            this.q = 6;
         } else if ((var1 & 131072) != 0) {
            this.q = 49;
         } else if ((var1 & 524288) != 0) {
            this.q = 51;
         } else if ((var1 & 8388608) != 0) {
            this.q = 55;
         } else if ((var1 & 33554432) != 0) {
            this.q = 57;
         } else if ((var1 & 65536) != 0) {
            this.q = 48;
         } else if ((var1 & 1024) != 0) {
            this.q = 42;
         } else if ((var1 & 8) != 0) {
            this.q = 35;
         } else if ((var1 & 134217728) != 0) {
            this.q = 27;
         } else {
            this.q = 0;
         }

         if ((var1 & 603979776) != 0) {
            this.q = 29;
            return;
         }
      } else {
         this.q = 0;
      }
   }

   private void l() {
      int var1 = super.g;
      if (super.g != 0) {
         if ((var1 & 2097408) != 0) {
            this.r = 8;
         } else if ((var1 & 4194336) != 0) {
            this.r = 5;
         } else if ((var1 & 1048580) != 0) {
            this.r = 2;
         } else if ((var1 & 262146) != 0) {
            this.r = 1;
         } else if ((var1 & 16777280) != 0) {
            this.r = 6;
         } else if ((var1 & 131072) != 0) {
            this.r = 49;
         } else if ((var1 & 524288) != 0) {
            this.r = 51;
         } else if ((var1 & 8388608) != 0) {
            this.r = 55;
         } else if ((var1 & 33554432) != 0) {
            this.r = 57;
         } else if ((var1 & 65536) != 0) {
            this.r = 48;
         } else if ((var1 & 1024) != 0) {
            this.r = 42;
         } else if ((var1 & 8) != 0) {
            this.r = 35;
         } else if ((var1 & 134217728) != 0) {
            this.r = 27;
         } else if ((var1 & 604012544) != 0) {
            this.r = 29;
         } else {
            this.r = 0;
         }
      } else {
         this.r = 0;
      }
   }

   public e(GOWMIDlet var1) {
      super(var1);
      super.k = 100;
      super.j = 40;
      this.c(240, 320);
      this.iR = new d(this, 12);
      this.iR.a(false);
      H = 0;

      try {
         this.A = a.a(var1.getAppProperty("ENABLECHEATS"), 0) == 1;
      } catch (Exception var4) {
         this.A = false;
      }

      try {
         this.bH = a.a(var1.getAppProperty("DEMO"), 0);
         this.bI = var1.getAppProperty("DemoBuyURL");
      } catch (Exception var3) {
         this.bH = 0;
         this.bI = "";
      }

      try {
         this.s = var1.getAppProperty("carrierurl");
      } catch (Exception var2) {
         this.s = null;
      }
   }

   public final void i(int var1) {
      if (var1 != 0) {
         if (var1 == 1) {
            if (H != 102 && H != 107) {
               this.ae = this.Z >> 8;
               this.af = this.aa >> 8;
            }

            if (H != 107 && H != 102) {
               this.I = H;
            }

            if (H != 100
               && H != 78
               && H != 105
               && H != 108
               && H != 101
               && H != 102
               && H != 104
               && H != 106
               && H != 109
               && H != 103
               && H != 79
               && H != -3
               && H != 16
               && H != 107
               && H != 0
               && H != 1) {
               H = 80;
               this.hV = false;
            } else if (H != 79 && H != 106 && H != 108 && H != 109 && H != -3 && H != 1 && H != 16 && H != 107 && H != 0 && H != 78) {
               this.a(G - (y << 1), G - (y << 1), 35, 35);
               this.hV = false;
               this.S = G - (y << 1) << 8;
               this.T = G - (y << 1) << 8;
               this.V = false;
               H = 102;
               this.iF = true;
            }

            this.iN = false;
            this.iG = true;
         } else if (var1 == 5) {
            if (this.hV && H == 80) {
               this.hV = false;
               this.y(9);
            }
         } else if (var1 == 2) {
            if (H == 80) {
               this.y(9);
            }
         } else if (var1 == 3) {
            this.iR.c();
         }
      }

      super.i(var1);
   }

   public final void a() {
      this.K = super.i >> this.hL;
      this.f();
      this.k();
      this.l();
      switch (H) {
         case 0:
            if (this.J <= 13) {
               this.n();
               return;
            }

            this.iY = null;
            this.a((DataInputStream)null);
            this.iG = true;
            this.A(1);
            this.iY = null;
            ib = new String[3];
            ib[0] = this.e(36);
            ib[1] = "";
            ib[2] = "";
            this.a(ij, il);
            H = 78;
            this.d();
            this.J = 0;
            return;
         case 1:
            this.m();
            if (this.u) {
               F();
               if (this.t == 0) {
                  this.C();
                  this.b(false);
                  R = this.c(this.bC);
                  this.gi = -1;
                  dQ = -1;
                  this.dR = -1;
               }

               if (this.t <= 10) {
                  this.a(R, false);
                  return;
               }

               this.e();
               R = null;
               if (this.eF >= 1) {
                  this.eF--;
               }

               this.s();
               int var5 = this.t;
               this.t = 0;
               this.a(this.c(this.bJ), true);
               this.t = var5;
               this.u = false;
               this.o();
               this.iV.b(iW >> 1, iX >> 1);
               this.iT.b(iW, iX);
               this.a(G, G, 35, 35);
               this.be = true;
               if (this.P <= 0) {
                  this.ak = true;
                  return;
               }
            }

            return;
         case 78:
            if (this.q == 27 || this.q == 8) {
               this.f(w[v]);
               this.iG = true;
               this.h();
               ib = new String[3];
               ib[0] = this.e(36);
               ib[1] = "";
               ib[2] = "";
               this.a(ij, il);
               H = 79;
               return;
            }

            if (this.q == 1) {
               if (v > 0) {
                  v--;
                  return;
               }

               return;
            } else {
               if (this.q == 6) {
                  if (v < 5) {
                     v++;
                     return;
                  }
               } else if (this.q == 29) {
                  this.L();
                  return;
               }

               return;
            }
         case 79:
            this.H();
            this.m();
            if ((this.q == 27 || this.q == 29) && this.S == 0) {
               if (this.q == 27) {
                  this.iR.a(true);
               } else {
                  this.iR.a(false);
               }

               iQ = this.iR.b();
               this.y(9);
               if (this.Z == G << 8) {
                  this.a(0, 0, 35, 35);
               } else {
                  this.a(G, G, 35, 35);
               }

               this.iG = true;
               return;
            }

            return;
         case 80:
            this.M = N.nextInt();
            if (this.S == 0) {
               this.K();
               this.J();
            }

            this.m();
            if (this.q == 48 && this.A) {
               for (int var4 = 0; var4 < 10; var4++) {
                  iA[9 + var4] = iA[9 + var4] = iA[9 + var4] | 50331648;
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
            this.hL = 0;
            if (this.fz == 10) {
               this.hq += 3;
               this.hn = this.hn + this.hq / 64;
               if (this.hn > this.hq) {
                  this.hn = this.hq;
               }
            } else {
               this.hr += 3;
               hp = hp + this.hr / 64;
               if (hp > this.hr) {
                  hp = this.hr;
               }
            }

            if (this.fA <= 0) {
               H = 100;
               this.iF = true;
               if (this.hn > this.hq && this.fz == 10) {
                  this.hn = this.hq;
               } else if (this.fz == 9) {
                  hp = this.hr;
               }
            }

            this.fA -= 3;
         case 100:
            this.br = this.br + this.K;
            if (this.br >= 250) {
               this.br = 0;
               if (this.bs == 0) {
                  this.bs = 16777215;
               } else {
                  this.bs = 0;
               }
            }

            this.bb = false;
            break;
         case 106:
            this.m();
            this.t(134);
            if (!this.t(133)) {
               if (this.bh) {
                  c var1 = aK[this.bj ? 37 : 34];
                  c var2 = aK[this.bj ? 41 : 38];
                  if (!this.bj) {
                     for (int var6 = 0; var6 <= bg; var6++) {
                        aK[34 + var6] = var6 + 1 > bg ? var1 : aK[34 + var6 + 1];
                        aK[38 + var6] = var6 + 1 > bg ? var2 : aK[38 + var6 + 1];
                     }
                  } else {
                     for (int var3 = 0; var3 <= bg; var3++) {
                        aK[37 - var3] = var3 + 1 > bg ? var1 : aK[37 - var3 - 1];
                        aK[41 - var3] = var3 + 1 > bg ? var2 : aK[41 - var3 - 1];
                     }
                  }
               }

               this.bh = false;
               this.a(133, 1025, 2);
            }

            this.q();
            this.H();
            return;
         case 107:
            if (!this.aV) {
               this.D();
            }

            if (this.aV) {
               if (this.r == 1) {
                  this.aW = 24;
               } else {
                  this.aW = 4;
               }

               if (this.r == 6) {
                  this.aW = -24;
               }

               this.ir = this.ir + this.K * this.aW;
               if (this.ir < 0) {
                  this.ir = 0;
               }

               if ((this.ir >> 8 > 70 + this.E - y || this.r == 29 && this.S == this.Z) && H == 107 && this.Z < G << 8) {
                  this.a(G, G, 35, 35);
                  if (this.P > 0) {
                     this.ak = true;
                  } else {
                     this.al = true;
                     this.P = -1;
                  }
               }
            } else if (this.q == 29 && this.S == this.Z) {
               this.ag = true;
               this.a(G, G, 35, 35);
               this.iG = true;
            }

            this.m();
            return;
         case 109:
            this.m();
            if (this.S == this.Z && this.T == this.aa && !this.V) {
               if (this.q == 27) {
                  this.a(133, 1025, 2);
                  this.a(134, 1025, 3);
                  if (this.bH > 0 && this.bF >= this.bH) {
                     iP = true;
                     this.b(this.bI);
                     this.L();
                  } else {
                     this.bm = (256 - (this.hu & 0xFF)) * 320 >> 8;
                     this.at = true;
                     this.z(1);
                     this.a(G, G, 35, 35);
                  }
               }

               if (this.q == 29) {
                  this.a(G, G, 35, 35);
                  this.an = true;
                  this.cv = -1;
                  return;
               }
            }

            return;
         default:
            return;
      }

      this.M = N.nextInt();
      if ((H == 100 || H == 105 || H == 108) && !this.bb) {
         this.y();
      }

      if (H == 105) {
         this.r = 0;
         this.q = 0;
      }

      if (H == 101) {
         if (this.S >= this.Z && this.S < this.E << 8) {
            this.bc = this.bc + (this.K >> 4 - (this.r == 8 ? 3 : 0));
         }

         this.r();
      } else {
         this.bc = 0;
      }

      this.o();
      this.iT.b(iW, iX);
      this.iV.b(iW >> 1, iX >> 1);
      this.m();
   }

   private void a(int var1, int var2, int var3, int var4) {
      this.X = this.S <= var1 << 8;
      this.Y = this.T <= var2 << 8;
      this.V = this.Y || this.X;
      if (this.V) {
         this.U = 375;
      }

      this.Z = var1 << 8;
      this.aa = var2 << 8;
      this.ab = var3;
      this.ac = var4;
      this.u = false;
      this.ao = false;
      this.an = false;
      this.W = false;
   }

   private void m() {
      if (this.S >= this.Z && this.T >= this.aa && (H == 105 || H == 100)) {
         this.bb = false;
      }

      if (this.S == this.Z && this.T == this.aa && this.U > 0) {
         if (this.U == 375 && H != 101 && H != 105) {
            this.y(10);
         }

         this.U = this.U - this.K;
         if (this.U < 0) {
            this.U = 0;
            return;
         }
      } else {
         if (H == 1) {
            if (this.S == this.Z && this.T == this.aa && this.V && this.P <= 0) {
               if (!this.ak) {
                  if (!iS) {
                     this.a(G - (y << 1), G - (y << 1), 35, 35);
                  } else {
                     this.a(G - (y << 1) - y, G - (y << 1) - y, 35, 35);
                  }

                  this.V = false;
               } else {
                  this.a(0, 0, 35, 35);
                  H = 100;
                  this.iF = true;
                  this.t = 0;
                  this.P = 0;
                  this.be = false;
                  this.ak = false;
               }
            } else if (this.P > 0 && this.t >= 10 && this.S >= this.Z && this.T >= this.aa && this.V) {
               this.be = true;
               int[] var2;
               (var2 = new int[3])[0] = -1;
               var2[1] = this.P;
               var2[2] = -1;
               this.cv = -1;
               this.a(var2, aU, 12, 35, 200, 250, 30);
               this.aV = true;
               this.a(35, 35, 35, 35);
               this.ir = 0;
               H = 107;
            } else if (this.P > 0 && this.t > 10 && !this.V && this.S == this.Z && this.T == this.aa) {
               this.aV = true;
               this.be = true;
               this.a(G, G, 35, 35);
               this.u = true;
            } else if (this.S == this.Z && this.T == this.aa && !this.V && !this.u) {
               this.V = false;
               this.u = true;
            }
         } else if (H == 101) {
            if (this.S == this.Z && this.T == this.aa && this.V && this.aV) {
               this.a(this.aP, aU, 12, 35, 200, 250, 30);
               if (ib != null) {
                  ib[0] = "";
                  ib[2] = "";
               }

               this.a(35, 35, 35, 35);
               H = 107;
               this.ir = 0;
            }
         } else if (H == 102) {
            if (this.S == this.Z && this.T == this.aa && this.V) {
               if (this.ao) {
                  this.a(this.ae, this.af, 35, 35);
                  H = this.I;
                  this.ao = false;
                  this.V = false;
                  this.a(this.aP, aU, 12, 0, 200, y * 5 + z, 30);
               } else if (this.an) {
                  this.an = false;
                  this.C();
                  this.y(9);
                  this.b(true);
                  this.a((DataInputStream)null);
                  iB = 0;
                  this.iC = 0;
                  H = 80;
                  this.a(0, 0, 35, 35);
                  this.z(1);
               } else if (this.am) {
                  this.L();
               } else if (this.ap) {
                  this.h();
                  ib = new String[3];
                  ib[0] = "";
                  ib[2] = "";
                  this.a(this.o);
                  ib[1] = this.e(114) + "\n" + this.e(292) + "\n\n\n\n";
                  this.a(ih, ik);
                  this.a(35, 35, 35, 35);
                  H = 107;
                  this.ir = 0;
               } else {
                  this.a(G - (y << 1), G - (y << 1), 35, 35);
                  this.W = true;
               }

               this.V = false;
            }
         } else if (H == 80) {
            if (this.S == this.Z && this.T == this.aa && this.V && this.ai) {
               this.ai = false;
               this.h();
               ib = new String[3];
               ib[0] = "";
               ib[2] = "";
               this.a(this.o);
               if (this.ah) {
                  ib[1] = this.e(115);
                  int var1;
                  if ((var1 = ib[1].indexOf(37)) != -1) {
                     ib[1] = ib[1].substring(0, var1) + "1.4.20" + ib[1].substring(var1 + 1, ib[1].length());
                  }

                  this.a(ii, ik);
               } else {
                  ib[1] = this.e(114) + "\n" + this.e(292) + "\n\n\n\n";
                  this.a(ih, ik);
               }

               this.a(35, 35, 35, 35);
               H = 107;
            }
         } else if (H == 79) {
            if (this.S == this.Z && this.T == this.aa && this.V) {
               this.a(0, 0, 35, 35);
               this.iN = false;
               this.iG = true;
               this.z(1);
               H = 80;
            }
         } else if (H != 107) {
            if (H == 109) {
               if (this.S == this.Z && this.T == this.aa && this.V) {
                  if (!this.an && !this.at) {
                     this.a(G - (y << 1), G - (y << 1), 35, 35);
                  } else if (this.at) {
                     this.a(133, 1025, 2);
                     this.a(134, 1025, 3);
                     H = 106;
                     this.a(0, 0, 35, 35);
                  } else {
                     H = 80;
                     this.y(9);
                     this.an = false;
                     this.z(1);
                     if (this.bG >= 10) {
                        iB = 9;
                     } else {
                        iB = this.bG + 9;
                     }

                     this.C();
                     this.b(true);
                     this.a((DataInputStream)null);
                     this.be = false;
                     this.iC = 0;
                     this.a(0, 0, 35, 35);
                  }
               }
            } else if (H == 108 && this.S == this.Z && this.T == this.aa && this.V) {
               if (!this.an && !this.ao) {
                  if (iS) {
                     this.a(G - (y << 1) - y - (y >> 2), G - (y << 1) - y - (y >> 2), 35, 35);
                  } else {
                     this.a(G - z - (y >> 2), G - z - (y >> 2), 35, 35);
                  }

                  this.W = true;
               } else if (!this.ao && this.an) {
                  this.an = false;
                  this.C();
                  this.y(9);
                  this.b(true);
                  this.a((DataInputStream)null);
                  this.iC = 0;
                  iB = 0;
                  H = 80;
                  this.a(0, 0, 35, 35);
                  this.z(1);
               } else {
                  H = 100;
                  this.iF = true;
                  this.a(0, 0, 35, 35);
                  this.W = true;
               }
            }
         } else {
            if (this.S != this.Z || this.T == this.aa) {
               this.h();
            }

            if (this.S == this.Z && this.T == this.aa && this.ag) {
               if (!this.ap) {
                  H = 80;
                  this.ag = false;
                  iB = 0;
                  this.iC = 0;
                  this.a(0, 0, 35, 35);
               } else if (this.S == G << 8) {
                  this.cv = this.as;
                  this.ap = false;
                  this.ag = false;
                  this.a(G - (y << 1), G - (y << 1), 35, 35);
                  H = 102;
               }
            } else if (this.S == this.Z && this.T == this.aa && this.al && this.P < 0) {
               this.a(G - (y << 1), G - (y << 1), 35, 35);
               this.be = true;
               this.al = false;
               this.iN = false;
               iB++;
               this.bF++;
               if (this.bF > this.bG && (this.bH <= 0 || this.bF < this.bH)) {
                  this.bG = this.bF;
               }

               if (this.bF < 10) {
                  this.bC = bD[this.bF];
                  this.bJ = bE[this.bF];
               }

               this.ad = true;
               this.u = false;
               this.C();
               if (this.bF < 10) {
                  H = 109;
               } else {
                  this.C();
                  this.y(9);
                  this.b(true);
                  this.a((DataInputStream)null);
                  this.a(0, 0, 35, 35);
                  this.iC = 0;
                  iB = 0;
                  this.be = false;
                  H = 80;
                  this.z(1);
               }
            } else if (this.S >= this.Z && this.T >= this.aa && this.P > 0 && this.ak) {
               H = 100;
               this.iF = true;
               this.be = false;
               this.ak = false;
               this.t = 0;
               this.P = 0;
               this.a(0, 0, 35, 35);
            }
         }

         if (H == 102 && this.W && this.U < 0) {
            this.W = false;
            H = this.I;
            this.bb = true;
            this.iF = true;
         }

         if (this.S > 115) {
            if (H == 108 && this.S == this.Z && !this.V) {
               if (this.q != 8 && this.q != 27) {
                  if (this.q == 29) {
                     this.a(G, G, 35, 35);
                     this.an = true;
                  }
               } else if (!iS) {
                  this.ge = this.gc;
                  this.gf = this.gd;
                  hy = this.hz;
                  iW = this.ge - 120 - ((hy ? 1 : -1) * 240 >> 2);
                  iX = this.gf - 266;
                  this.aN = iW << 8;
                  this.aO = iX << 8;
                  this.hA = false;
                  this.s(0);
                  this.hn = this.hq;
                  this.ho = this.hq;
                  hp = this.hr;
                  this.a(G, G, 35, 35);
                  this.W = true;
                  this.iF = true;
                  this.gN = -1;
                  this.ao = true;
               }
            } else if (H == 102 && this.S == this.Z && !this.V) {
               if (this.q != 8 && this.q != 27) {
                  if (this.q == 29) {
                     if (this.ar) {
                        this.ar = false;
                     } else {
                        this.a(G, G, 35, 35);
                        this.ao = true;
                     }
                  } else if (this.q == 2) {
                     if (!this.ar) {
                        aq++;
                        if (aq > 4) {
                           aq = 4;
                        }
                     }
                  } else if (this.q == 5 && !this.ar) {
                     aq--;
                     if (aq < 1) {
                        aq = 1;
                     }
                  }
               } else if (aq == 4) {
                  this.iR.a(!this.iR.b());
                  iQ = this.iR.b();
               } else if (aq == 2 && this.ar) {
                  this.a(G, G, 35, 35);
                  this.cv = -1;
                  this.an = true;
               } else if (aq == 1 && this.ar) {
                  this.a(G, G, 35, 35);
                  this.am = true;
               } else if ((aq == 2 || aq == 1) && !this.ar) {
                  this.ar = true;
               } else if (aq == 3) {
                  this.aV = false;
                  this.a(G, G, 35, 35);
                  this.ap = true;
                  this.as = this.cv;
                  this.cv = -1;
               } else {
                  this.ar = false;
                  this.ap = false;
               }
            }
         }

         if (this.S < this.Z && this.X && (this.ad && this.T <= this.T || !this.ad)) {
            this.iF = true;
            this.S = this.S + this.K * this.ab;
            if (this.S >= this.Z) {
               this.S = this.Z;
               if (H == 105) {
                  this.bb = false;
               }
            }
         }

         if (this.T < this.aa && this.Y) {
            this.T = this.T + this.K * this.ab;
            this.iF = true;
            if (this.T > this.aa) {
               this.T = this.aa;
            }
         }

         if (this.S > this.Z && !this.X) {
            this.iF = true;
            this.S = this.S - this.K * this.ab;
            if (this.S <= this.Z) {
               this.S = this.Z;
            }

            this.aj = true;
         }

         if (this.T > this.aa && !this.Y) {
            this.iF = true;
            this.T = this.T - this.K * this.ac;
            if (this.T < this.aa) {
               this.T = this.aa;
            }
         }
      }
   }

   private void a(int var1, int var2, int var3, short[] var4, boolean var5) {
      for (int var6 = 0; var6 < var4.length; var6++) {
         var4[var6] = 0;
      }

      this.b(var4, var3, var5 ? 0 : 2);

      for (byte var7 = 0; var7 < var4.length; var7 += 5) {
         var4[var7] = (short)(var4[var7] + var1);
         var4[var7 + 1] = (short)(var4[var7 + 1] + var2);
      }
   }

   private void n() {
      switch (this.J) {
         case 0:
            this.h(138);
            this.D = 240;
            this.E = 320;
            F = this.D >> 1;
            G = this.E >> 1;
            this.f(10240);
            byte[] var1;
            Q = new int[(var1 = this.c(1053)).length / 3];
            int var2 = 0;

            for (byte var7 = 0; var7 < var1.length; var7 += 3) {
               Q[var2] = var1[var7] << 18 | var1[var7 + 1] << 10 | var1[var7 + 2] << 2;
               var2++;
            }

            N = new Random();
            this.b(true);
            this.iY = this.b(1037);
            this.ct = this.b(1035);
            this.g(1024);
            this.a(1024, true);
            this.cu = this.b(1030);
            this.fy = this.b(1038);
            this.g(1026);
            this.a(1026, true);
            break;
         case 1:
            this.o = this.b(1031);
            this.a(this.o);
            y = this.c();
            z = y >> 1;
            this.iO = this.a("W") * 4;
            this.fB = this.b(1034);

            for (int var6 = 0; var6 < 5; var6++) {
               this.H();
            }
         case 2:
         case 6:
         case 9:
         case 10:
         case 11:
         default:
            break;
         case 3:
            this.g(1025);
            this.a(1025, true);
            aK = this.b(1036);
            this.g(1027);
            this.a(1027, true);
            this.aT = this.b(1040);
            bq = this.b(1029);
            this.I();
            break;
         case 4:
            for (int var3 = 0; var3 < 11; var3++) {
               d var10000;
               int var10001;
               int var10002;
               byte var10003;
               byte var10004;
               label62: {
                  if (1054 + var3 == 1063) {
                     var10000 = this.iR;
                     var10001 = var3;
                     var10002 = 1054 + var3;
                     var10003 = -1;
                  } else {
                     var10000 = this.iR;
                     var10001 = var3;
                     var10002 = 1054 + var3;
                     var10003 = 1;
                     if (1054 + var3 == 1062) {
                        var10004 = 1;
                        break label62;
                     }
                  }

                  var10004 = 0;
               }

               var10000.a(var10001, var10002, var10003, var10004);
            }
            break;
         case 5:
            this.g(2048);
            this.a(2048, true);
            this.g(2049);
            this.g(2050);
            this.a(2049, true);
            this.a(2050, true);
            break;
         case 7:
            this.g(3074);
            this.a(3074, true);
            this.g(3072);
            this.a(3072, true);
            this.g(3073);
            this.a(3073, true);
            this.g(5122);
            this.a(5122, true);
            break;
         case 8:
            this.g(5121);
            this.a(5121, true);
            this.g(6145);
            this.a(6145, true);
            this.g(6144);
            this.a(6144, true);
            this.g(5120);
            this.a(5120, true);
            this.g(28672);
            this.a(28672, true);
            this.g(7168);
            this.a(7168, true);
            break;
         case 12:
            iA[5] = (iA[5] & -256) + 68;
            iA[5] = iA[5] & -50331649;
            if (this.s == null) {
               iA[6] = iA[6] & -50331649;
            }
            break;
         case 13:
            this.h();
            if (!ja) {
               iZ = true;
               this.iY = this.b(8193);
               this.g(8192);
               this.a(0, 8192, 0);
               ja = true;
            } else {
               ja = this.b(0, super.i);
               if (!ja) {
                  this.L = 0;
               }
            }

            this.h();
      }

      if (!ja && this.J <= 13) {
         this.J++;
      }

      for (int var5 = 0; var5 < 6 && !ja; var5++) {
         this.H();
      }
   }

   private void b(boolean var1) {
      if (var1) {
         this.p = this.b(1039);
         this.m = this.b(1032);
         this.n = this.b(1033);
         this.iN = false;
         this.iG = true;
         this.iy = this.p[3].c;
         this.d();
         this.bF = this.bG;
         this.a((DataInputStream)null);
      } else {
         this.a(132, 1027, 10);
         this.p = null;
         this.m = null;
         this.n = null;
      }
   }

   private void o() {
      int var1 = this.K << 8;
      int var2;
      int var3;
      if (this.ax > 0) {
         var2 = this.ax;
         var3 = this.ay;
      } else {
         var2 = this.ge;
         var3 = this.gf;
      }

      int var10000 = (hy && this.ax < 0 ? 1 : -1) * (hF != 109 && hF != 110 ? 240 : -240) >> 2;
      int var4 = 0;
      var4 = var10000 - (this.gr ? (hy ? this.D >> 2 : -(this.D >> 2)) : 0);
      if (hF == 116) {
         var4 = 0;
      }

      int var5 = this.gr ? 80 : 0;
      int var6 = var2 - 120 + var4;
      int var7 = var3 - 266 + var5;
      int var8 = (var6 - iW + this.aH) * this.K;
      int var9 = (var7 - iX + this.aI) * this.K;
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

      this.aN += var8;
      this.aO += var9;
      var6 = this.aN >> 8;
      var7 = this.aO >> 8;
      this.aL = iW - var6;
      this.aM = iX - var7;
      iW = var6;
      iX = var7;
      boolean var10 = false;
      boolean var11 = false;
      if (this.ax < 0) {
         for (int var12 = this.aC - 1; var12 >= 0; var12--) {
            if (a(this.aD[var12], this.aE[var12], iW, iX, 240, 320)) {
               if (!this.aG[var12]) {
                  var10 = true;
                  int var13 = this.aJ * this.K >> 8;
                  if (this.aF[var12]) {
                     this.aH -= var13;
                  } else {
                     this.aH += var13;
                  }

                  if (!a(this.aD[var12], this.aE[var12], iW + this.aH, iX + this.aI, 240, 320)) {
                     this.aH = this.aD[var12] - iW - (this.aF[var12] ? 240 : 0);
                  }
               } else {
                  var11 = true;
                  int var18 = this.aJ * this.K >> 8;
                  if (this.aF[var12]) {
                     this.aI -= var18;
                  } else {
                     this.aI += var18;
                  }

                  if (!a(this.aD[var12], this.aE[var12], iW + this.aH, iX + this.aI, 240, 320)) {
                     this.aI = this.aE[var12] - iX - (this.aF[var12] ? 320 : 0);
                  }
               }
            }
         }

         for (int var17 = this.fd; var17 >= 0; var17--) {
            if (fn[var17] && a(fh[var17] + (fo[var17] ? fj[var17] : 0), this.fi[var17], iW, iX, 240, 320)) {
               var10 = true;
               int var19 = this.aJ * this.K >> 8;
               if (fo[var17]) {
                  this.aH -= var19;
               } else {
                  this.aH += var19;
               }

               if (!a(fh[var17] + (fo[var17] ? fj[var17] : 0), this.fi[var17], iW + this.aH, iX + this.aI, 240, 320)) {
                  this.aH = fh[var17] + (fo[var17] ? fj[var17] : 0) - iW - (fo[var17] ? 240 : 0);
               }
            }
         }

         iW = iW + this.aH;
         iX = iX + this.aI;
         if (!var10 && this.aH != 0) {
            if (this.aH > 0) {
               this.aH = this.aH - (this.aJ * this.K >> 8);
               if (this.aH < 0) {
                  this.aH = 0;
               }
            } else {
               this.aH = this.aH + (this.aJ * this.K >> 8);
               if (this.aH > 0) {
                  this.aH = 0;
               }
            }
         }

         if (!var11 && this.aI != 0) {
            if (this.aI > 0) {
               this.aI = this.aI - (this.aJ * this.K >> 8);
               if (this.aI < 0) {
                  this.aI = 0;
               }
            } else {
               this.aI = this.aI + (this.aJ * this.K >> 8);
               if (this.aI > 0) {
                  this.aI = 0;
               }
            }
         }

         this.aL = this.aL - this.aH;
         this.aM = this.aM - this.aI;
         if (this.au != 0) {
            if (this.av + this.av * this.hL >= this.aw) {
               iX = iX + this.au;
               iW = iW + this.au * ((this.M & 1) == 1 ? -1 : 1);
               this.au = this.au + (this.au < 0 ? 1 : -1);
               this.au = -this.au;
               this.av = 0;
            } else {
               this.av = this.av + this.K;
            }
         } else {
            this.aw = 0;
         }
      } else if (var8 != 0 && this.az <= 3500) {
         this.az = this.az + this.K;
      } else {
         this.ax = -1;
         this.ay = -1;
         this.iF = true;
         this.az = 0;
      }

      if (iW < 0) {
         iW = 0;
         this.aN = 0;
         this.aL = 0;
      }

      if (iW >= this.aA) {
         iW = this.aA;
         this.aN = this.aA << 8;
         this.aL = 0;
      }

      if (iX < 0) {
         iX = 0;
         this.aO = 0;
         this.aM = 0;
      }

      if (iX >= this.aB) {
         iX = this.aB;
         this.aO = this.aB << 8;
         this.aM = 0;
      }
   }

   private void p() {
      this.it = false;
      this.aP[0] = -1;
      this.aP[1] = this.cw;
      ib = new String[3];
      ib[0] = "";
      ib[1] = this.e(this.aP[1]);
      this.a(this.o);
      if (ib[1].charAt(0) == '!') {
         H = 105;
         this.bb = true;
         this.s(this.aX[this.aZ]);
         if (this.dP != -1) {
            this.i(this.aY[this.ba], this.dP);
            return;
         }
      } else {
         if (ib[1].charAt(0) == '^') {
            this.cv = a.a(ib[1].substring(1, 2), 0);
            if (this.cv > 3) {
               int var1 = this.cv - 3 - 1;
               this.fQ = var1;
               hf = this.fQ == 1;
               hg = this.fQ == 2;
               this.hh = this.fQ == 3;
            }
         } else {
            this.cv = -1;
         }

         ib[1].charAt(0);
         if (ib[1].charAt(0) == '*') {
            if (ib[1].length() != 1) {
               this.aV = true;
               this.a(G, G, 35, 35);
            } else {
               this.bd = true;
            }

            this.iG = true;
            return;
         }

         this.aV = false;
         this.a(this.aP, aU, 12, 0, 200, y * 5 + z, 30);
      }
   }

   private void q() {
      if (this.bk <= 0 && !this.bh) {
         switch (this.q) {
            case 1:
            case 2:
               this.a(133, 1025, 1);
               this.bh = true;
               bi++;
               if (bi > bg) {
                  bi = 0;
               }

               this.bj = false;
               break;
            case 5:
            case 6:
               this.a(133, 1025, 0);
               this.bh = true;
               bi--;
               if (bi < 0) {
                  bi = bg;
               }

               this.bj = true;
               break;
            case 29:
            case 35:
               this.a(133, 1025, 4);
               if (!this.at) {
                  H = 100;
               } else {
                  this.at = false;
                  H = 1;
                  this.a(G, G, 35, 35);
               }

               this.iF = true;
         }

         switch (this.r) {
            case 8:
            case 27:
               if (this.hu > 0 && this.hu >= this.bf) {
                  if (this.bf < 16) {
                     this.bf++;
                  }
               } else if (this.hu < this.bf) {
                  this.bf = this.hu;
               } else if (this.hu <= 0) {
                  this.bf = 0;
               }

               switch (bi) {
                  case 0:
                     if (gT <= 3) {
                        this.hb = this.hb + this.bf;
                        if (this.hb >= gV[gT]) {
                           this.bf = gV[gT] - (this.hb - this.bf);
                           if (gT == 0 || gT == 1 || gT == 2) {
                              gR++;
                           }

                           this.hb = 0;
                           gT++;
                           this.bk = 2500;
                        }
                     } else {
                        this.bf = 0;
                     }
                     break;
                  case 1:
                     if (gU <= 3) {
                        this.hc = this.hc + this.bf;
                        if (this.hc < gW[gU]) {
                           break;
                        }

                        this.bf = gW[gU] - (this.hc - this.bf);
                        if (gU == 0 || gU == 1 || gU == 3) {
                           this.gS++;
                        }

                        this.hc = 0;
                        gU++;
                        this.bk = 2500;
                        break;
                     }

                     this.bf = 0;
                     break;
                  case 2:
                     if (gZ < 4) {
                        this.hd = this.hd + this.bf;
                        if (this.hd >= gX[gZ]) {
                           this.bf = gX[gZ] - (this.hd - this.bf);
                           this.hd = 0;
                           gZ++;
                           this.bk = 2500;
                        }
                     } else {
                        this.bf = 0;
                     }
                     break;
                  case 3:
                     if (ha < 4) {
                        this.he = this.he + this.bf;
                        if (this.he >= gY[ha]) {
                           this.bf = gY[ha] - (this.he - this.bf);
                           this.he = 0;
                           ha++;
                           this.bk = 2500;
                        }
                     } else {
                        this.bf = 0;
                     }
               }

               this.hu = this.hu - this.bf;
               if (this.hu < 0) {
                  this.hu = 0;
               }

               this.bm = (256 - (this.hu & 0xFF)) * 320 >> 8;
               break;
            default:
               this.bf = 0;
         }
      } else {
         this.bk = this.bk - this.K;
      }

      if (this.A) {
         if (this.r == 57) {
            this.hu += 20;
            return;
         }

         if (this.r == 55) {
            this.hu -= 20;
            if (this.hu < 0) {
               this.hu = 0;
            }
         }
      }
   }

   private void r() {
      if (this.S >= this.Z && this.it) {
         switch (this.q) {
            case 1:
            case 2:
               if (this.ip >= 5) {
                  this.bc = 0;
                  this.ip -= 5;
                  return;
               }

               if (this.cw > this.cx) {
                  this.cw--;
                  this.bc = 0;
                  this.p();
                  return;
               }
               break;
            case 5:
            case 6:
            case 8:
            case 27:
               if (this.iq > 0) {
                  this.bc = 0;
                  this.ip = this.iq;
                  return;
               }

               if ((this.cv <= 3 || this.q != 27) && this.cv > 3) {
                  break;
               }

               this.bc = 0;
               this.ip = -1;
               this.iq = -1;
               this.cw++;
               if (this.cw >= this.cy) {
                  if (!this.bd) {
                     H = 100;
                     this.a(0, 0, 35, 35);
                     this.iF = true;
                     this.aV = false;
                     this.cy = -1;
                     this.cw = -1;
                     this.cx = -1;
                     return;
                  }

                  this.h();
                  this.bF++;
                  if (this.bF > this.bG && (this.bH <= 0 || this.bF < this.bH)) {
                     this.bG = this.bF;
                  }

                  this.bC = bD[this.bF];
                  this.C();
                  this.iG = true;
                  this.iY = null;
                  this.be = true;
                  H = 1;
                  this.u = false;
                  this.a(G, G, 35, 35);
                  return;
               }

               this.p();
               return;
            case 29:
               if (this.S == this.Z) {
                  this.ae = this.Z >> 8;
                  this.af = this.aa >> 8;
                  this.I = H;
                  H = 102;
                  aq = 4;
                  this.a(G, G, 35, 35);
               }
         }
      }
   }

   public final void a(Graphics var1) {
      switch (H) {
         case 0:
            this.u(var1);
            if (!ja && this.J <= 13) {
               a(var1, this.J, 13, true);
               return;
            }
            break;
         case 1:
         case 80:
         case 109:
            if (!this.be && H != 1) {
               this.w(var1);
            }

            this.c(var1);
            if (H == 109 && this.S == this.Z && this.T == this.aa && !this.V) {
               this.a(var1, 28, 29);
               return;
            }
            break;
         case 78:
            this.v(var1);
            this.p[0].a(var1, F, 0, 0);
            this.p[1].a(var1, F, 0, 0);
            int var2 = (y << 2) + y;

            for (int var3 = 0; var3 <= 5; var3++) {
               this.a(var1, this.e(x[var3]), F, var2, 1);
               if (var3 == v) {
                  bq[2].a(var1, (F >> 1) - bq[2].c, var2 + (y >> 2), 0);
                  bq[3].a(var1, this.D - (F >> 1), var2 + (y >> 2), 0);
               }

               var2 = var2 + y + (y >> 2);
            }

            if (this.Z != G << 8) {
               this.a(var1, 0, 1);
               return;
            }

            this.b(var1);
            return;
         case 79:
            this.v(var1);
            this.p[0].a(var1, F, 0, 0);
            this.p[1].a(var1, F, 0, 0);
            this.a(var1, false);
            this.c(var1);
            if (this.Z != G << 8) {
               this.a(var1, 28, 29);
               return;
            }

            this.b(var1);
            return;
         case 100:
         case 101:
         case 102:
         case 104:
         case 105:
         case 108:
            if (H == 100 && this.S <= 0 && !this.iF) {
               this.a(var1, 0, 0, 240, 306);
            } else {
               this.iF = true;
               this.b(var1);
            }

            this.d(var1);
            if (H != 101) {
               this.f(var1);
            }

            if (H == 100) {
               if (this.aQ && this.aR == hy && !fV && a(this.ge, this.gf, iW, iX, this.D, this.E)) {
                  this.a(var1, this.aT, 131, 17, this.E - 30, 0);
               }

               if (fV && this.fW >= 0 && this.fW < this.fU && this.gi >= 0) {
                  this.a(var1, this.aT, 131, dX[this.gi] - iW, this.dY[this.gi] - this.ej[this.gi] - (this.ej[this.gi] >> 2) - iX, 0);
               }
            }

            if (H == 104) {
               var1.setColor(855564);
               var1.fillRect(F >> 3, G - (G >> 1), this.D - (F >> 2), G + y);
               var1.setColor(4269080);
               var1.drawRect((F >> 3) - 1, G - (G >> 1) - 1, this.D - (F >> 2) + 1, G + y + 1);
               var1.setColor(5911589);
               var1.drawRect((F >> 3) - 2, G - (G >> 1) - 2, this.D - (F >> 2) + 3, G + y + 3);
               this.cu[0].a(var1, (F >> 3) - 3, G - (G >> 1) - 2, 0);
               this.cu[0].a(var1, this.D - (F >> 3) + 3, G - (G >> 1) - 2, 2);
               this.cu[0].a(var1, (F >> 3) - 3, G + (G >> 1) + 2 + y, 1);
               this.cu[0].a(var1, this.D - (F >> 3) + 3, G + (G >> 1) + 2 + y, 3);
               this.a(var1, this.fy, 136, F, G - (y << 1), 0);
               if (this.fz == 9) {
                  this.a(var1, this.e(148), F, G + y, 1);
                  if (this.fA < 96) {
                     this.a(var1, this.e(189), F, G + (y << 1) + y, 1);
                  } else {
                     this.a(var1, this.e(151), F, G + (y << 1) + y, 1);
                  }
               } else {
                  this.a(var1, this.e(147), F, G + y, 1);
                  if (this.fA < 96) {
                     this.a(var1, this.e(158), F, G + (y << 1) + y, 1);
                  } else {
                     this.a(var1, this.e(151), F, G + (y << 1) + y, 1);
                  }
               }
            }

            this.c(var1);
            if (H == 101 && this.S >= this.Z && !this.aV) {
               this.a(var1, false);
            }

            switch (H) {
               case 100:
                  if (this.iF) {
                     this.a(var1, 160, 197);
                     return;
                  }

                  return;
               case 101:
                  if (this.it) {
                     this.a(var1, 174, 197);
                     return;
                  }

                  this.a(var1, -1, -1);
                  return;
               case 102:
                  if (this.S == this.Z && !this.V) {
                     if ((aq == 1 || aq == 2) && this.ar) {
                        this.a(var1, 28, 29);
                        return;
                     }

                     if (aq == 4 && aq != 3) {
                        this.a(var1, 200, 199);
                        return;
                     }

                     this.a(var1, 0, 199);
                     return;
                  }

                  return;
               case 103:
               default:
                  return;
               case 104:
                  return;
               case 105:
                  this.a(var1, -1, 197);
                  return;
            }
         case 106:
            this.e(var1);
            this.c(var1);
            if (this.bk <= 0) {
               if (this.hu > 0) {
                  this.a(var1, !this.bh ? (this.bo <= 3 ? 149 : -1) : -1, !this.bh ? (this.at ? 174 : 2) : -1);
                  return;
               }

               this.a(var1, -1, !this.bh ? (this.at ? 174 : 2) : -1);
               return;
            }

            this.a(var1, -1, -1);
            return;
         case 107:
            if (super.l) {
               this.v(var1);
               this.a(var1, true);
            }

            this.c(var1);
            if (H == 107 && this.S <= 8960) {
               if (!this.aV) {
                  this.a(var1, -1, 2);
                  return;
               }

               this.a(var1, -1, 240);
               return;
            }
      }
   }

   private void c(Graphics var1) {
      int var2 = this.S >> 8;
      int var3 = this.T >> 8;
      if (var2 > 0) {
         if ((!this.V || this.W || this.an || this.ap || this.ao || this.am) && (H == 108 || H == 102 || H == 1 || H == 109)) {
            var1.setColor(0);
            var1.fillRect(0, var2 + 1, 240, 320 - (var3 << 1) - 1);
            if (H == 108) {
               if (!iS) {
                  this.a(var1, this.e(173), F, G + z + (y >> 3), 33);
               } else {
                  this.a(var1, this.e(173), F, G - (y << 1) + (y >> 1), 33);
                  this.a(var1, this.e(206), F, G - (y >> 2) + (y >> 1), 33);
                  this.a(var1, String.valueOf(this.dM), F, G + y + (y >> 2), 33);
                  if (this.dM > this.hD) {
                     this.a(var1, this.e(207), F, G + (y << 1) + (y >> 1), 33);
                  } else {
                     this.a(var1, this.e(208) + String.valueOf(this.hD), F, G + (y << 1) + (y >> 1), 33);
                  }
               }
            } else if (H == 102) {
               this.a(var1, !iS ? this.e(54 + this.bF) : this.e(66), F, G - (y >> 1), 33);
               if (aq == 4) {
                  this.a(var1, this.e(47) + " " + (this.iR.b() ? this.e(234) : this.e(235)), F, G + y + z, 33);
                  bq[3].a(var1, this.D - 7 - 10, G + (y >> 1) + 1, 0);
               } else if (aq == 2 && !this.ar) {
                  this.a(var1, this.e(50), F, G + y + z, 33);
                  bq[2].a(var1, 17 - bq[2].c, G + (y >> 1) + 1, 0);
                  bq[3].a(var1, this.D - 7 - 10, G + (y >> 1) + 1, 0);
               } else if (aq == 2 && this.ar) {
                  this.a(var1, this.e(186), F, G + y + z, 33);
               } else if (aq == 1 && !this.ar) {
                  this.a(var1, this.e(1), F, G + y + z, 33);
                  bq[2].a(var1, 17 - bq[2].c, G + (y >> 1) + 1, 0);
               } else if (aq == 1 && this.ar) {
                  this.a(var1, this.e(185), F, G + y + z, 33);
               } else if (aq == 3) {
                  this.a(var1, this.e(46), F, G + y + z, 33);
                  bq[3].a(var1, this.D - 7 - 10, G + (y >> 1) + 1, 0);
                  bq[2].a(var1, 17 - bq[2].c, G + (y >> 1) + 1, 0);
               }
            } else if (H == 1) {
               this.a(this.o);
               if (iS) {
                  this.a(var1, this.e(66), F, G - y - (y >> 1), 33);
                  this.a(var1, this.e(190), F, G - (y >> 1), 33);
                  this.a(var1, this.e(238), F, G + (y >> 1), 33);
                  this.a(var1, this.e(39), F, G + y + (y >> 1) + (y >> 2), 33);
                  a(var1, this.t, 11, true);
               } else {
                  this.a(var1, this.e(54 + this.bF), F, G - z, 33);
                  this.a(var1, this.e(39), F, G + z, 33);
                  a(var1, this.t, 11, true);
               }
            } else if (H == 109) {
               if (this.bF >= this.bH && this.bH != 0) {
                  this.a(var1, this.e(279), F, G, 33);
                  this.a(var1, this.e(280), F, G + y, 33);
               } else {
                  this.a(var1, this.e(54 + this.bF - 1) + this.e(169), F, G, 33);
                  this.a(var1, this.e(168) + this.e(54 + this.bF) + this.e(159), F, G + y, 33);
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
         if (!this.V && H == 108) {
            this.a(var1, iS ? -1 : 198, 45);
         }

         this.cu[0].a(var1, 0, var2, 1);
         this.cu[0].a(var1, 240, var2, 3);
         this.cu[0].a(var1, 0, 320 - (var3 - 1), 0);
         this.cu[0].a(var1, 240, 320 - (var3 - 1), 2);
      }

      if (H == 80 && this.S == 0) {
         switch (this.iL) {
            case 0:
               this.a(var1, 0, 1);
               return;
            case 9:
               if (this.bG >= iB - this.iL + 1) {
                  this.a(var1, 196, 2);
                  return;
               }

               this.a(var1, 120, 2);
               return;
            case 23:
               this.a(var1, 28, 29);
               return;
            case 30:
               this.a(var1, 28, 29);
               return;
            default:
               this.a(var1, 0, 2);
         }
      }
   }

   private void d(Graphics var1) {
      this.iV.a(var1);
      this.iT.a(var1);
      var1.translate(-iW, -(iX + this.bl));
      this.i(var1);
      this.l(var1);
      this.m(var1);
      this.p(var1);
      this.j(var1);
      this.q(var1);
      this.n(var1);
      this.o(var1);
      this.g(var1);
      if (this.gi >= 0 && !fV && hF != 109 && hF != 113 && this.dU[this.gi] != 2) {
         this.s(var1);
         this.r(var1);
      } else {
         this.r(var1);
         this.s(var1);
      }

      this.h(var1);
      this.t(var1);
      this.k(var1);
      var1.translate(iW, iX + this.bl);
   }

   private void e(Graphics var1) {
      this.bp = 0;
      var1.setColor(0);
      var1.fillRect(F - 5 - 25, 0, F + 5 + 25, 320);
      var1.fillRect(5, 0, 70, this.bm + this.bp);
      this.a(this.o);
      this.b(var1, false);
      this.a(var1, aK, 134, 5, this.bm + this.bp, 0);
      this.a(var1, aK, 133, 0, this.bp, 0);
      bn = "~ " + String.valueOf(this.hu);
      this.a(var1, bn, 13, 4, 4);
      bn = this.e(116 + bi);
      bq[0].a(var1, 175, 38 - bq[0].d, 0);
      if (bn.indexOf(10) != -1) {
         this.a(var1, bn.substring(0, bn.indexOf(10)), 175, 40, 1);
         this.a(var1, bn.substring(bn.indexOf(10) + 1, bn.length()), 175, 40 + y, 1);
      } else {
         this.a(var1, this.e(116 + bi), 175, 40, 1);
      }

      int var2 = 0;
      if (bi == 0) {
         this.bo = gT;
         if (gT <= 3) {
            var2 = gV[this.bo] - this.hb;
         }
      } else if (bi == 1) {
         this.bo = gU;
         if (gU <= 3) {
            var2 = gW[this.bo] - this.hc;
         }
      } else if (bi == 3) {
         this.bo = ha;
         if (ha <= 3) {
            var2 = gY[this.bo] - this.he;
         }
      } else {
         this.bo = gZ;
         if (gZ <= 3) {
            var2 = gX[this.bo] - this.hd;
         }
      }

      if (this.bo <= 3) {
         this.a(var1, this.e(223) + String.valueOf(this.bo + 1), 175, 40 + (y << 1), 1);
         this.a(var1, String.valueOf(var2) + "~", 200, 80 + (y << 1), 8);
         this.a(var1, this.e(224), 175, 80 + (y << 1) + y, 1);
         this.a(var1, this.e(225), 175, 80 + (y << 2), 1);
      } else {
         this.a(var1, this.e(241), 175, 40 + (y << 1), 1);
      }

      bq[1].a(var1, 175, 40 + (y << 1) + y, 0);
      if (this.bk > 0) {
         var1.setColor(855564);
         var1.fillRect(F - (F >> 1), G - (G >> 2), F, (G >> 1) + y);
         var1.setColor(4269080);
         var1.drawRect(F - (F >> 1) - 1, G - (G >> 2) - 1, F + 1, (G >> 1) + 1 + y);
         var1.setColor(5911589);
         var1.drawRect(F - (F >> 1) - 2, G - (G >> 2) - 2, F + 3, (G >> 1) + 3 + y);
         if (bn.indexOf(10) != -1) {
            this.a(var1, bn.substring(0, bn.indexOf(10)), F, G - y - (y >> 1), 1);
            this.a(var1, bn.substring(bn.indexOf(10) + 1, bn.length()), F, G - (y >> 1), 1);
         } else {
            this.a(var1, this.e(116 + bi), F, G - (G >> 2), 1);
         }

         this.a(var1, this.e(222), F, G + y, 1);
      }
   }

   private void f(Graphics var1) {
      this.a(var1, aK, 133, 0, 0, 0);
      int var2;
      if ((var2 = 38 + this.fQ + (bi > 0 ? 4 - bi : 0)) > 41) {
         var2 = 38 + (var2 - 41) - 1;
      }

      aK[var2].a(var1, 12, 27, 0);
      var1.setColor(4342338);
      var1.drawRect(56, 17, this.hq * 9 >> 8, 4);
      var1.drawRect(56, 23, this.hr * 9 >> 8, 3);
      var1.setColor(0);
      var1.fillRect(56, 18, this.hq * 9 >> 8, 3);
      var1.fillRect(56, 23, this.hr * 9 >> 8, 3);
      var1.setColor(4783872);
      var1.fillRect(56, 18, this.hn * 9 >> 8, 3);
      if (hp <= 0 && (hf || this.hh || hg)) {
         var1.setColor(this.bs);
         var1.fillRect(56, 23, this.hr * 9 >> 8, 3);
      } else {
         var1.setColor(104191);
         var1.fillRect(56, 23, hp * 9 >> 8, 3);
      }

      this.a(var1, String.valueOf(this.hu), 79, 33, 1);
   }

   private void g(Graphics var1) {
      for (int var2 = this.fq; var2 >= 0; var2--) {
         int var3 = this.fu[var2];
         int var4 = this.fv[var2];
         int var5 = var3 - iW;
         int var6 = var4 - iX;
         if (var5 + (this.fr << 1) >= 0 && var6 + this.fs >= 0 && var5 - this.fr <= 240 && var6 - this.fs <= 320) {
            this.a(var1, this.fp, var2 + 121, var3, var4, 0);
         }
      }
   }

   private void h(Graphics var1) {
      for (int var2 = this.fK; var2 >= 0; var2--) {
         for (int var3 = 0; var3 < 4; var3++) {
            int var4 = (var2 << 2) + var3;
            int var5 = fC[var4];
            int var6 = fD[var4];
            int var7 = var5 - iW;
            int var8 = var6 - iX;
            if (var7 + this.fB[fI[var2]].c >= 0 && var8 + this.fB[fI[var2]].d >= 0 && var7 - this.fB[fI[var2]].c <= 240 && var8 - this.fB[fI[var2]].d <= 320) {
               this.fB[(fI[var2] << 2) + var3].a(var1, var5, var6, 0);
            }
         }
      }
   }

   private void i(Graphics var1) {
      for (int var2 = ch; var2 >= 0; var2--) {
         if (this.cc[var2] >= 0) {
            int var3 = cd[var2];
            int var4 = ce[var2];
            int var5 = var3 - iW;
            int var6 = var4 - iX;
            if (var5 + this.cg[var2] >= 0 && var6 + this.cf[var2] >= 0 && var5 - this.cg[var2] <= 240 && var6 - this.cf[var2] <= 320) {
               this.a(var1, this.cb, var2 + 10, var3, var4, 0);
            }
         }
      }
   }

   private void j(Graphics var1) {
      for (int var2 = ca; var2 >= 0; var2--) {
         if (this.bS[var2] >= 0) {
            int var3 = bT[var2];
            int var4 = this.bU[var2];
            int var5 = var3 - iW;
            int var6 = var4 - iX;
            if (var5 + this.bY[var2] >= 0 && var6 + this.bX[var2] >= 0 && var5 - this.bY[var2] <= 240 && var6 - this.bX[var2] <= 320) {
               this.a(var1, this.bR, var2 + 30, var3, var4, 0);
            }
         }
      }
   }

   private void k(Graphics var1) {
      for (int var2 = co; var2 >= 0; var2--) {
         if (this.cj[var2] >= 0) {
            int var3 = this.ck[var2];
            int var4 = cl[var2];
            int var5 = var3 - iW;
            int var6 = var4 - iX;
            if (var5 + this.cn[var2] >= 0 && var6 + this.cm[var2] >= 0 && var5 - this.cn[var2] <= 240 && var6 - this.cm[var2] <= 320) {
               this.a(var1, this.ci, var2 + 40, var3, var4, 0);
            }
         }
      }
   }

   private void l(Graphics var1) {
      for (int var2 = this.dD; var2 >= 0; var2--) {
         if (this.dv[var2] >= 0) {
            int var3 = dx[var2];
            int var4 = this.dy[var2];
            int var5 = var3 - iW;
            int var6 = var4 - iX;
            if (var5 + this.dC[var2] >= 0 && var6 + dB[var2] >= 0 && var5 - this.dC[var2] <= 240 && var6 - dB[var2] <= 320) {
               this.a(var1, this.du, var2 + 70, var3, var4, 0);
            }
         }
      }
   }

   private void m(Graphics var1) {
      for (int var2 = this.dt; var2 >= 0; var2--) {
         if (this.dm[var2] >= 0) {
            int var3 = dp[var2];
            int var4 = dq[var2];
            int var5 = var3 - iW;
            int var6 = var4 - iX;
            if (var5 + this.ds[var2] >= 0 && var6 + this.dr[var2] >= 0 && var5 - this.ds[var2] <= 240 && var6 - this.dr[var2] <= 320) {
               this.a(var1, this.dl, var2 + 60, var3, var4, this.do[var2]);
            }
         }
      }
   }

   private void n(Graphics var1) {
      for (int var2 = fb; var2 >= 0; var2--) {
         if (this.eR[var2] >= 0) {
            int var3 = this.eS[var2];
            int var4 = this.eT[var2];
            int var5 = var3 - iW;
            int var6 = var4 - iX;
            if (var5 + this.eW[var2] >= 0 && var6 + this.eX[var2] >= 0 && var5 <= 240 && var6 - this.eX[var2] <= 320) {
               this.a(var1, this.eQ, var2 + 111, var3, var4, 0);
            }
         }
      }
   }

   private void o(Graphics var1) {
      for (int var2 = this.fd; var2 >= 0; var2--) {
         if (this.fe[var2] >= 0) {
            int var3 = fh[var2];
            int var4 = this.fi[var2];
            int var5 = var3 - iW;
            int var6 = var4 - iX;
            if (var5 + (fj[var2] << 1) >= 0 && var6 + this.fk[var2] >= 0 && var5 - fj[var2] <= 240 && var6 - this.fk[var2] <= 320) {
               this.a(var1, this.fc, var2 + 116, var3, var4, 0);
            }
         }
      }
   }

   private void p(Graphics var1) {
      for (int var2 = this.cB; var2 >= 0; var2--) {
         int var3 = this.cC[var2];
         int var4 = cD[var2];
         int var5 = var3 - iW;
         int var6 = var4 - iX;
         if (var5 + this.cF[var2] >= 0 && var6 + this.cG[var2] >= 0 && var5 - this.cF[var2] <= 240 && var6 - this.cG[var2] <= 320) {
            this.a(var1, cA, var2 + 106, var3, var4, 0);
         }
      }
   }

   private void q(Graphics var1) {
      for (int var2 = cM; var2 >= 0; var2--) {
         if (cX[var2] >= 0) {
            int var3 = cQ[var2];
            int var4 = this.cR[var2];
            int var5 = var3 - iW;
            int var6 = var4 - iX;
            if (var5 + cT[var2] >= 0 && var6 + this.cV[var2] >= 0 && var5 - cT[var2] <= 240 && var6 - this.cV[var2] <= 320) {
               this.a(var1, this.cN, var2 + 100, var3, var4, 0);
            }
         }
      }
   }

   private void r(Graphics var1) {
      for (int var2 = this.eF; var2 >= 0; var2--) {
         if (this.dT[var2] >= 0) {
            int var3 = dX[var2];
            int var4 = this.dY[var2];
            int var5 = var3 - iW;
            int var6 = var4 - iX;
            if (var5 + this.ei[var2] >= 0 && var6 + this.ej[var2] >= 0 && var5 - this.ei[var2] <= 240 && var6 - this.ej[var2] <= 320) {
               boolean var7 = this.en[var2];
               switch (this.dU[var2]) {
                  case 1:
                     this.a(var1, this.dG, var2 + 85, dX[var2], this.dY[var2], var7 ? 0 : 2);
                     break;
                  case 2:
                     this.a(var1, dH, var2 + 85, dX[var2], this.dY[var2], var7 ? 0 : 2);
                     break;
                  case 3:
                     if (dQ == var2) {
                        this.a(var1, this.dJ, var2 + 85, dX[var2], this.dY[var2], var7 ? 0 : 2);
                     } else {
                        this.a(var1, this.dI, var2 + 85, dX[var2], this.dY[var2], var7 ? 0 : 2);
                     }
               }

               if (this.eb[var2] > 0) {
                  this.a(var1, this.bL, 137, dX[var2], this.dY[var2], 0);
                  this.b(137, this.K);
               }

               if (H == 100
                  && (
                     this.gi < 0 && this.eb[var2] <= 0 && eo[var2] < er[var2] >> 1 && !this.el[var2] && eo[var2] >= 0
                        || this.dU[var2] == 3 && this.dV[var2] == 12 && dQ != var2 && this.dR != var2
                        || this.dU[var2] == 2 && this.dV[var2] == 12 && dQ != var2
                  )) {
                  this.a(var1, this.aT, 132, dX[var2], this.dY[var2] - this.ej[var2] - (this.dR == var2 ? -(this.ej[var2] >> 3) : this.ej[var2] >> 2), 0);
               }
            }
         }
      }
   }

   private void s(Graphics var1) {
      this.a(var1, this.fL, 135, this.ge, this.gf, hy ? 0 : 2);
   }

   private void t(Graphics var1) {
      for (int var2 = this.bQ; var2 >= 0; var2--) {
         if (bM[var2] >= 0) {
            this.a(var1, this.bL, bM[var2], this.bN[var2], this.bO[var2], this.bP[var2]);
         }
      }
   }

   private void d(int var1, int var2) {
      switch (var1) {
         case 0:
            for (int var47 = 0; var47 < var2; var47++) {
               int var62 = this.m(10);
               int var76 = this.bu[var47] / 22;
               int var87 = this.bv[var47] / 22;

               for (int var94 = 0; var94 <= var62; var94++) {
                  this.b(var76 + var94, var87, 8192);
               }
            }

            return;
         case 3:
            this.aC = var2;
            this.aG = new boolean[var2];
            this.aF = new boolean[var2];
            this.aD = new int[var2];
            this.aE = new int[var2];

            for (int var23 = 0; var23 < var2; var23++) {
               this.aD[var23] = this.bu[var23];
               this.aE[var23] = this.bv[var23];
               this.aG[var23] = this.m(1) == 1;
               this.aF[var23] = this.m(1) == 1;
            }

            return;
         case 4:
            this.fq = var2 - 1;
            this.fx = new int[var2];
            this.fu = new int[var2];
            this.fv = new int[var2];
            ft = new boolean[var2];
            fw = new int[var2];
            int var46 = 1 << this.bF;

            for (int var61 = 0; var61 < var2; var61++) {
               this.fx[var61] = this.m(3);
               fw[var61] = this.m(10);
               if (this.fx[var61] == 3) {
                  if (fw[var61] > 0) {
                     fw[var61] = -1;
                  } else {
                     fw[var61] = -2;
                  }
               }

               this.fu[var61] = this.bu[var61];
               this.fv[var61] = this.bv[var61];
               if ((fw[var61] != -1 || (hi & var46) != var46) && (fw[var61] != -2 || (hi & var46 << 10) != var46 << 10)) {
                  ft[var61] = false;
               } else {
                  ft[var61] = true;
                  fw[var61] = 0;
                  this.fx[var61] = this.fx[var61] + 4;
               }

               this.a(121 + var61, 5120, this.fx[var61]);
               if (ft[var61]) {
                  this.b(121 + var61, 2000);
               }

               this.a(this.fp, 121 + var61, 0, 0, 0, this.O);
               this.fr = this.O[2];
               this.fs = this.O[3];
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
               int var60 = this.m(10);
               int var75 = this.bu[var45] / 22;
               int var86 = this.bv[var45] / 22;

               for (int var93 = 0; var93 <= var60; var93++) {
                  this.b(var75, var86 + var93, 8);
               }
            }

            return;
         case 6:
            for (int var13 = 0; var13 < 40; var13++) {
               this.aX[var13] = this.m(10);
            }

            for (int var14 = 0; var14 < 40; var14++) {
               this.aY[var14] = this.m(10);
            }

            return;
         case 7:
            this.fe = new int[var2];
            this.ff = new int[var2];
            fg = new int[var2];
            fh = new int[var2];
            this.fi = new int[var2];
            fj = new int[var2];
            this.fk = new int[var2];
            this.fl = new byte[var2];
            this.fm = new byte[var2];
            fn = new boolean[var2];
            fo = new boolean[var2];

            for (int var44 = 0; var44 < var2; var44++) {
               this.fd = var44;
               this.fe[var44] = this.m(6) << 1;
               fn[var44] = this.m(1) == 1;
               fo[var44] = this.m(1) == 1;
               this.a(116 + var44, 2048, this.fe[var44]);
               this.a(this.fc, 116 + var44, 0, 0, 0, this.O);
               fh[var44] = this.bu[var44];
               this.fi[var44] = this.bv[var44];
               this.ff[var44] = this.bu[var44] / 22;
               fg[var44] = this.bv[var44] / 22;
               fj[var44] = this.O[2];
               this.fk[var44] = this.O[3];
               this.fl[var44] = (byte)(fj[var44] / 22);
               this.fm[var44] = (byte)(this.fk[var44] / 22);
               int var59 = this.ff[var44];
               int var74 = fg[var44];
               if (!this.b(116 + var44, 1)) {
                  this.j(var44, 2);
                  this.q(var44);
               } else {
                  for (int var85 = 0; var85 < this.fl[var44]; var85++) {
                     for (int var92 = 1; var92 <= this.fm[var44]; var92++) {
                        this.b(var59 + var85, var74 - var92, 1);
                     }
                  }
               }
            }

            return;
         case 8:
            this.cp = new int[var2];
            cq = new int[var2];
            this.cr = new int[var2];
            this.cs = new int[var2];
            cz = var2 - 1;

            for (int var43 = 0; var43 < var2; var43++) {
               this.cp[var43] = this.bu[var43] / 22;
               cq[var43] = this.bv[var43] / 22;
               this.b(this.cp[var43], cq[var43], 128);
               this.cr[var43] = this.m(10);
               this.cs[var43] = this.m(3);
            }

            return;
         case 9:
            this.db = new byte[var2];
            this.dc = new int[var2];
            dd = new int[var2];

            for (int var42 = 0; var42 < var2; var42++) {
               int var58 = this.m(10);
               this.db[var42] = (byte)this.m(3);
               int var73 = this.bu[var42] / 22;
               int var84 = this.bv[var42] / 22;
               this.dc[var42] = var73;
               dd[var42] = var84;

               for (int var91 = 0; var91 <= var58; var91++) {
                  this.b(var73, var84 + var91, 256);
               }
            }

            return;
         case 10:
            for (int var41 = 0; var41 < var2; var41++) {
               int var57 = this.m(10);
               int var72 = this.bu[var41] / 22;
               int var83 = this.bv[var41] / 22;

               for (int var90 = 0; var90 <= var57; var90++) {
                  this.b(var72 + var90, var83, 64);
               }
            }

            return;
         case 11:
         case 12:
         case 13:
            c[] var22 = (c[])null;
            byte var26 = -1;
            byte var28 = -1;
            if (var1 == 11) {
               var22 = this.dG;
               var26 = 1;
               var28 = 0;
               if (this.dE) {
               }
            } else if (var1 == 12) {
               var22 = dH;
               var26 = 2;
               var28 = 0;
               if (this.dF) {
               }
            } else if (var1 == 13) {
               var22 = this.dI;
               var26 = 3;
               var28 = 0;
            }

            for (int var40 = this.eF; var40 < this.eF + var2; var40++) {
               this.dT[var40] = var40;
               dX[var40] = this.bu[var40 - this.eF];
               this.dY[var40] = this.bv[var40 - this.eF];
               this.ed[var40] = dX[var40] / 22;
               this.ee[var40] = (this.dY[var40] - 1) / 22;
               this.b(this.ed[var40], this.ee[var40] - 1, 2);
               this.dV[var40] = var28;
               this.dT[var40] = var40;
               this.dU[var40] = var26;
               ey[var40] = 0;
               dZ[var40] = dX[var40];
               ea[var40] = this.dY[var40];
               this.et[var40] = this.dY[var40] - this.ee[var40] * 22 << 8;
               this.eb[var40] = 0;
               eg[var40] = (byte)this.m(3);
               eh[var40] = eg[var40];
               this.ex[var40] = this.m(10) * 1000;
               this.dP = this.m(1) == 1 ? var40 : 0;
               ev[var40] = this.ex[var40];
               er[var40] = this.m(16);
               eo[var40] = er[var40];
               this.eq[var40] = this.m(16);
               this.ep[var40] = (byte)this.m(10);
               this.ec[var40] = (byte)this.m(10);
               this.en[var40] = this.m(1) != 1;
               ew[var40] = this.en[var40];
               ez[var40] = this.m(1) == 1;
               if (var1 == 13) {
                  boolean var56 = this.m(1) == 1;
                  boolean var71 = this.m(1) == 1;
                  if (ez[var40]) {
                     var28 = 1;
                  }

                  if (var56 && !var71) {
                     this.dJ = this.b(13313, bK[this.bF] >= 0 ? this.c(13315 + bK[this.bF]) : null);
                     this.g(13312);
                     dQ = var40;
                     eo[var40] = eo[var40] << 2;
                     er[var40] = eo[var40];
                  } else if (var71) {
                     this.dJ = this.b(14337);
                     this.g(14336);
                     this.dR = var40;
                     dQ = var40;
                     eo[var40] = eo[var40] << 2;
                     er[var40] = eo[var40];
                  } else {
                     this.g(15360);
                  }
               } else if (ez[var40]) {
                  var28 = 1;
               }

               this.i(var28, var40);
               this.a(var22, 85 + var40, 0, 0, 0, this.O);
               this.ei[var40] = (short)this.O[2];
               ef[var40] = (byte)(this.ei[var40] / 22 >> 1);
               if (ef[var40] == 0) {
                  ef[var40] = 1;
               }

               this.ej[var40] = (short)this.O[3];
               this.ek[var40] = (byte)(this.ej[var40] / 22);
            }

            this.eF += var2;
            return;
         case 14:
            this.eG = new int[var2];
            this.eH = new int[var2];
            this.eI = new int[var2 * 15];
            this.eJ = new int[var2 * 15];
            this.eK = new boolean[var2 * 15];

            for (int var39 = 0; var39 < var2; var39++) {
               int var55 = this.m(10);
               this.eG[var39] = this.bu[var39] / 22;
               this.eH[var39] = this.bv[var39] / 22;

               for (int var69 = 0; var69 < 15; var69++) {
                  if (var69 < 15) {
                     this.eI[var69 + var39 * 15] = this.m(10);
                     this.eJ[var69 + var39 * 15] = this.m(10);
                     this.eK[var69 + var39 * 15] = this.m(1) != 1;
                  } else {
                     this.m(10);
                     this.m(10);
                     this.m(1);
                  }
               }

               for (int var70 = 0; var70 < var55; var70++) {
                  this.b(this.eG[var39], this.eH[var39] + var70, 4);
               }
            }

            return;
         case 17:
            co = var2 - 1;

            for (int var21 = 0; var21 < var2; var21++) {
               this.cj[var21] = this.m(6);
               this.ck[var21] = this.bu[var21];
               cl[var21] = this.bv[var21];
               this.a(40 + var21, 3072, this.cj[var21]);
               this.a(this.ci, 40 + var21, 0, 0, 0, this.O);
               this.cn[var21] = this.O[2];
               this.cm[var21] = this.O[3];
            }

            return;
         case 18:
            for (int var38 = 0; var38 < var2; var38++) {
               int var54 = this.m(10);
               int var68 = this.bu[var38] / 22;
               int var82 = this.bv[var38] / 22;

               for (int var89 = 0; var89 <= var54; var89++) {
                  this.b(var68 + var89, var82, 16);
               }
            }

            return;
         case 21:
            this.dt = var2 - 1;

            for (int var37 = 0; var37 < var2; var37++) {
               this.dm[var37] = this.m(6) << 1;
               dp[var37] = this.bu[var37];
               dq[var37] = this.bv[var37];
               this.do[var37] = 0;
               this.a(60 + var37, 5121, this.dm[var37]);
               this.a(this.dl, 60 + var37, 0, 0, 0, this.O);
               this.ds[var37] = this.O[2];
               this.dr[var37] = this.O[3];
            }

            return;
         case 22:
            for (int var15 = 0; var15 < var2; var15++) {
               int var3 = 0;

               for (int var19 = 0; var19 < 1; var19++) {
                  if (this.m(1) == 1) {
                     var3 |= 1 << var19;
                  }
               }

               int var20 = this.bu[var15] / 22;
               int var25 = this.bv[var15] / 22;
               int var27 = this.m(10);
               int var36 = this.m(10);
               int var53 = this.m(10);
               int var67 = this.m(10);

               for (int var78 = 0; var78 <= var27; var78++) {
                  this.b(var20, var25 - var78, var3);
               }

               for (int var79 = 0; var79 <= var36; var79++) {
                  this.b(var20, var25 + var79, var3);
               }

               for (int var80 = 0; var80 <= var53; var80++) {
                  this.b(var20 - var80, var25, var3);
               }

               for (int var81 = 0; var81 <= var67; var81++) {
                  this.b(var20 + var81, var25, var3);
               }
            }

            return;
         case 23:
            this.eM = new int[var2];
            this.eN = new int[var2];
            this.eO = new int[var2];
            eP = new byte[var2];
            this.bt = var2;

            for (int var18 = var2 - 1; var18 >= 0; var18--) {
               this.eM[var18] = this.m(8);
               this.eN[var18] = this.bu[var2 - var18 - 1];
               this.eO[var18] = this.bv[var2 - var18 - 1];
               eP[var18] = (byte)this.m(3);
            }

            return;
         case 25:
            for (int var35 = 0; var35 < var2; var35++) {
               this.b(this.bu[var35] / 22, this.bv[var35] / 22, 1024);
            }

            return;
         case 26:
            this.ga = this.bu[0];
            this.gb = this.bv[0];
            this.gc = this.ga;
            this.gd = this.gb;
            this.gy = false;
            this.gr = false;
            this.hn = this.hq;
            hp = this.hr;
            this.hA = false;
            gk = false;
            this.ge = this.ga;
            this.gf = this.gb;
            return;
         case 27:
            fb = var2 - 1;
            this.eR = new int[var2];
            this.eS = new int[var2];
            this.eT = new int[var2];
            eU = new int[var2];
            this.eV = new int[var2];
            this.eW = new int[var2];
            this.eX = new int[var2];
            this.eY = new byte[var2];
            this.eZ = new byte[var2];
            fa = new boolean[var2];

            for (int var34 = 0; var34 < var2; var34++) {
               this.eR[var34] = this.m(3);
               fa[var34] = this.m(1) == 1;
               this.a(111 + var34, 6144, this.eR[var34]);
               this.a(this.eQ, 111 + var34, 0, 0, 0, this.O);
               this.eS[var34] = this.bu[var34];
               this.eT[var34] = this.bv[var34];
               eU[var34] = this.bu[var34] / 22;
               this.eV[var34] = this.bv[var34] / 22;
               this.eW[var34] = this.O[2];
               this.eX[var34] = this.O[3];
               this.eY[var34] = (byte)(this.eW[var34] / 22);
               this.eZ[var34] = (byte)(this.eX[var34] / 22);
               int var52 = eU[var34];
               int var66 = this.eV[var34];

               for (int var77 = 0; var77 < this.eY[var34]; var77++) {
                  for (int var88 = 1; var88 <= this.eZ[var34]; var88++) {
                     this.b(var52 + var77, var66 - var88, 1);
                     this.b(var52 + var77, var66 - var88, 512);
                     if (fa[var34]) {
                        this.b(var52 + var77, var66 - var88, 8);
                     }
                  }
               }

               this.b(var52, var66, 1);
            }

            return;
         case 28:
            this.df = new int[var2];
            this.de = new int[var2];
            this.dg = new int[var2];
            dh = new int[var2];
            this.di = new int[var2];
            dj = new int[var2];
            this.dk = new int[var2];

            for (int var33 = 0; var33 < var2; var33++) {
               this.de[var33] = this.bu[var33] / 22;
               this.df[var33] = this.bv[var33] / 22;
               this.dg[var33] = this.m(10);
               dh[var33] = this.m(10);
               this.di[var33] = this.m(3);
               this.dk[var33] = this.m(10);
               dj[var33] = 0;

               for (int var51 = 0; var51 <= this.dg[var33]; var51++) {
                  for (int var65 = 0; var65 <= dh[var33]; var65++) {
                     this.b(this.de[var33] + var51, this.df[var33] + var65, 32);
                  }
               }
            }

            return;
         case 29:
            for (int var32 = 0; var32 < var2; var32++) {
               int var50 = this.m(10);
               int var64 = this.bu[var32] / 22;
               int var11 = this.bv[var32] / 22;

               for (int var12 = 0; var12 <= var50; var12++) {
                  this.b(var64 + var12, var11, 16384);
               }
            }

            return;
         case 30:
            for (int var31 = 0; var31 < var2; var31++) {
               if (this.m(1) != 0) {
                  this.b(this.bu[var31] / 22, this.bv[var31] / 22, 2048);
               } else {
                  this.b(this.bu[var31] / 22, this.bv[var31] / 22, 4096);
               }
            }

            return;
         case 31:
            for (int var17 = 0; var17 < var2; var17++) {
               int var4 = 0;

               for (int var6 = 0; var6 < 1; var6++) {
                  if (this.m(1) == 1) {
                     var4 |= 1 << var6;
                  }
               }

               int var24 = this.bu[var17] / 22;
               int var7 = this.bv[var17] / 22;
               this.b(var24, var7, var4);
            }

            return;
         case 32:
            ca = var2 - 1;

            for (int var16 = 0; var16 < var2; var16++) {
               this.bS[var16] = this.m(6) << 1;
               bT[var16] = this.bu[var16];
               this.bU[var16] = this.bv[var16];
               this.bZ[var16] = this.m(1) == 1;
               this.a(30 + var16, 5122, this.bS[var16]);
               this.b(this.hx, 30 + var16, 0);
               bV[var16] = this.hx[0] + bT[var16];
               this.bW[var16] = this.hx[1] + this.bU[var16];
               this.bY[var16] = this.hx[2];
               this.bX[var16] = this.hx[3];
            }

            return;
         case 33:
            this.dD = var2 - 1;

            for (int var30 = 0; var30 < var2; var30++) {
               this.dv[var30] = this.m(6);
               this.dw[var30] = this.m(10);
               int var49 = this.m(3) * 100;
               dx[var30] = this.bu[var30];
               this.dy[var30] = this.bv[var30];
               this.dz[var30] = this.bu[var30];
               this.dA[var30] = this.bv[var30];
               this.a(70 + var30, 6145, this.dv[var30]);
               this.a(this.du, 70 + var30, 0, 0, 0, this.O);
               this.b(70 + var30, var49);
               this.dC[var30] = this.O[2];
               dB[var30] = this.O[3];
            }

            return;
         case 34:
            this.cB = var2 - 1;
            this.cC = new int[var2];
            cD = new int[var2];
            this.cH = new boolean[var2];
            cK = new int[var2];
            this.cJ = new int[var2];
            this.cL = new int[var2 + 1 << 2];
            cI = new int[var2];
            this.cF = new int[var2];
            this.cE = new boolean[var2];
            this.cG = new int[var2];

            for (int var29 = 0; var29 < var2; var29++) {
               int var48 = this.bu[var29] / 22;
               int var63 = this.bv[var29] / 22;
               this.cC[var29] = var48 * 22;
               cD[var29] = var63 * 22;
               this.cJ[var29] = var48;
               cK[var29] = var63;
               this.cH[var29] = false;
               this.cE[var29] = this.m(1) == 1;
               cI[var29] = 0 + (this.cE[var29] ? 4 : 0);
               this.cL[var29 << 2] = this.m(3);
               this.cL[(var29 << 2) + 1] = this.m(3);
               this.cL[(var29 << 2) + 2] = this.m(3);
               this.cL[(var29 << 2) + 3] = this.m(3);
               this.a(106 + var29, 2050, cI[var29]);
               this.a(cA, 106 + var29, 0, 0, 0, this.O);
               this.cF[var29] = this.O[2];
               this.cG[var29] = this.O[3];
            }

            return;
         case 35:
            cM = var2 - 1;
            cQ = new int[var2];
            this.cR = new int[var2];
            cO = new int[var2];
            cP = new int[var2];
            cZ = new boolean[var2];
            this.cW = new int[var2];
            cX = new int[var2];
            this.cY = new int[var2];
            cS = new int[var2];
            this.cU = new int[var2];
            cT = new int[var2];
            this.cV = new int[var2];
            this.da = new boolean[var2];

            for (int var8 = 0; var8 < var2; var8++) {
               cQ[var8] = this.bu[var8];
               this.cR[var8] = this.bv[var8];
               cO[var8] = this.bu[var8] / 22;
               cP[var8] = this.bv[var8] / 22;
               this.cW[var8] = this.m(3);
               this.cY[var8] = this.m(10);
               cZ[var8] = this.m(1) == 1;
               this.da[var8] = this.m(1) == 1;
               cX[var8] = (this.cY[var8] << 2) + 0;
               this.a(100 + var8, 2049, cX[var8]);
               this.a(this.cN, 100 + var8, 0, 0, 0, this.O);
               cS[var8] = this.O[2] / 22;
               this.cU[var8] = this.O[3] / 22;
               cT[var8] = this.O[2];
               this.cV[var8] = this.O[3];
               cX[var8] = (this.cY[var8] << 2) + 2 - (cZ[var8] ? 2 : 0);
               this.a(100 + var8, 2049, cX[var8]);

               for (int var9 = 0; var9 < this.cU[var8]; var9++) {
                  for (int var10 = 0; var10 < cS[var8]; var10++) {
                     if (cZ[var8]) {
                        this.c(cO[var8] + var10, cP[var8] - var9, 1);
                     } else {
                        this.b(cO[var8] + var10, cP[var8] - var9, 1);
                     }
                  }
               }
            }

            return;
         case 36:
            ch = var2 - 1;

            for (int var5 = 0; var5 < var2; var5++) {
               this.cc[var5] = this.m(6);
               cd[var5] = this.bu[var5];
               ce[var5] = this.bv[var5];
               this.a(10 + var5, 3074, this.cc[var5]);
               this.a(this.cb, 10 + var5, 0, 0, 0, this.O);
               this.cg[var5] = this.O[2];
               this.cf[var5] = this.O[3];
            }
      }
   }

   private void a(byte[] var1, boolean var2) {
      switch (this.t) {
         case 0:
            if (!var2) {
               this.iT = null;
               this.jc = null;
               this.jb = null;
            }

            for (int var3 = 0; var3 < 10; var3++) {
               bM[var3] = -1;
            }

            this.a(var1);
            this.m(1);
            this.m(10);
            this.d(var2);
            this.m(1);
            this.by = this.m(16);
            this.bz = this.m(4);
            int[] var10 = new int[this.by];

            for (int var4 = 0; var4 < this.by; var4++) {
               var10[var4] = this.m(this.bz);
            }

            this.bA = l(this.by);
            int var13 = 0;
            int var5 = 0;
            if (var2 && je != 0) {
               var13 = je;
               var5 = jd;
            }

            jd = this.m(16);
            je = this.m(16);
            if (!var2) {
               this.bw = 22 * jd;
               this.bx = 22 * je;
               this.aA = this.bw - 240;
               this.aB = this.bx - 320;
            }

            jf = jd * je;
            if (!var2) {
               this.jc = new short[jf];
            }

            this.jb = new byte[jf];

            for (int var6 = 0; var6 < this.jb.length; var6++) {
               this.jb[var6] = (byte)this.m(this.bA);
            }

            this.m(8);
            this.b(this.by, var2);
            if (!var2) {
               this.iT = b.a(240, 320);
               this.iT.a(jd, je, this.iU, 22, 22);
            } else {
               this.iV = b.a(240, 320);
               this.iV.a(jd, je, this.iU, 22, 22);
            }

            int var7 = 0;

            for (int var8 = 0; var8 < je; var8++) {
               for (int var9 = 0; var9 < jd; var9++) {
                  if (!var2) {
                     if (var10[this.jb[var7] & 0xFF] != 1
                        && var10[this.jb[var7] & 0xFF] != 12
                        && var10[this.jb[var7] & 0xFF] != 24
                        && var10[this.jb[var7] & 0xFF] != 25
                        && var10[this.jb[var7] & 0xFF] != 51
                        && var10[this.jb[var7] & 0xFF] != 90
                        && var10[this.jb[var7] & 0xFF] != 104
                        && var10[this.jb[var7] & 0xFF] != 105
                        && var10[this.jb[var7] & 0xFF] != 108
                        && var10[this.jb[var7] & 0xFF] != 109
                        && var10[this.jb[var7] & 0xFF] != 111
                        && var10[this.jb[var7] & 0xFF] != 119
                        && var10[this.jb[var7] & 0xFF] != 124
                        && var10[this.jb[var7] & 0xFF] != 82) {
                        this.iT.a(var9, var8, 1 + var10[this.jb[var7] & 0xFF]);
                     } else {
                        this.iT.a(var9, var8, 0);
                     }
                  } else {
                     this.iV.a(var9, var8, 1 + var10[this.jb[var7]] & 0xFF);
                  }

                  var7++;
               }
            }

            this.jb = null;
            this.by = this.m(10);
            if (!var2) {
               jg = jd * 22;
               jh = je * 22;
            }

            this.bB = l(jg * jh + 1);
            jg = jd * 22;
            jh = je * 22;
            if (var2 && var13 != 0) {
               je = var13;
               jd = var5;
            }
         case 1:
         default:
            break;
         case 2:
            if (!var2) {
               this.fc = this.b(2051, bK[this.bF] >= 0 ? this.c(2059 + bK[this.bF]) : null);
            }
            break;
         case 3:
            if (!var2) {
               this.fL = this.b(28673, bK[this.bF] >= 0 ? this.c(28675 + bK[this.bF]) : null);
            }
            break;
         case 4:
            if (!var2) {
               this.eL = this.b(3076, bK[this.bF] >= 0 ? this.c(3084 + bK[this.bF]) : null);
            }
            break;
         case 5:
            if (!var2) {
               if (this.dE) {
                  this.dG = this.b(18433, bK[this.bF] >= 0 ? this.c(18435 + bK[this.bF]) : null);
                  this.g(18432);
               } else {
                  this.dG = this.b(4097, bK[this.bF] >= 0 ? this.c(4099 + bK[this.bF]) : null);
                  this.g(4096);
               }

               if (this.dF) {
                  dH = this.b(16385, bK[this.bF] >= 0 ? this.c(16387 + bK[this.bF]) : null);
                  this.g(16384);
               } else {
                  dH = this.b(17409, bK[this.bF] >= 0 ? this.c(17411 + bK[this.bF]) : null);
                  this.g(17408);
               }

               this.dI = this.b(15361, bK[this.bF] >= 0 ? this.c(15363 + bK[this.bF]) : null);
               this.g(15360);
            }
            break;
         case 6:
            if (!var2) {
               this.bR = this.b(5125, bK[this.bF] >= 0 ? this.c(5142 + bK[this.bF]) : null);
               this.dl = this.b(5124, bK[this.bF] >= 0 ? this.c(5132 + bK[this.bF]) : null);
               this.eQ = this.b(6146, bK[this.bF] >= 0 ? this.c(6150 + bK[this.bF]) : null);
            }
            break;
         case 7:
            if (!var2) {
               this.du = this.b(6147, bK[this.bF] >= 0 ? this.c(6153 + bK[this.bF]) : null);
               this.fp = this.b(5123, bK[this.bF] >= 0 ? this.c(5129 + bK[this.bF]) : null);
            }
            break;
         case 8:
            if (!var2) {
               this.cN = this.b(2052, bK[this.bF] >= 0 ? this.c(2062 + bK[this.bF]) : null);
               cA = this.b(2053, bK[this.bF] >= 0 ? this.c(2065 + bK[this.bF]) : null);
            }
            break;
         case 9:
            if (!var2) {
               this.cb = this.b(3077, bK[this.bF] >= 0 ? this.c(3087 + bK[this.bF]) : null);
               this.ci = this.b(3075, bK[this.bF] >= 0 ? this.c(3081 + bK[this.bF]) : null);
               this.bL = this.b(7169, null);
               this.a(137, 7168, 31);
            }
      }

      if (this.t == 10 && !var2 || var2) {
         this.bt = 0;
         if (!var2) {
            this.iT.a(1000);
         }

         this.hR = 0;

         while (this.by-- > 0) {
            int var11 = this.m(10);
            int var14 = this.m(16);
            int var15 = 0;
            this.bu = new int[var14];
            this.bv = new int[var14];
            int var16 = 0;

            for (int var17 = 0; var17 < var14; var17++) {
               for (var15 += this.m(this.bB); var15 >= jg; var16++) {
                  var15 -= jg;
               }

               this.bu[var17] = var15;
               this.bv[var17] = var16;
            }

            this.d(var11, var14);
         }

         for (int var12 = this.fq; var12 >= 0; var12--) {
            if (ft[var12]) {
               this.e(this.fu[var12] / 22, this.fv[var12] / 22);
            }
         }

         this.ji = null;
         this.c(var2);
         this.E();
         this.a((DataInputStream)null);
      }

      this.t++;
   }

   private void c(boolean var1) {
      short[] var2 = new short[256];
      int var3 = 0;

      for (int var4 = 0; var4 < this.bt; var4++) {
         this.a(136, 3073, this.eM[var4]);
         var3 += this.a(var2, 136, 0);
      }

      if (!var1) {
         this.iT.a(this.bt + var3, jd <= je);
      } else {
         this.iV.a(this.bt + var3, jd <= je);
      }

      for (int var8 = 0; var8 <= 7; var8++) {
         for (int var5 = this.bt - 1; var5 >= 0; var5--) {
            if (eP[var5] == var8) {
               this.a(136, 3073, this.eM[var5]);
               int var6 = this.a(var2, 136, 0);

               for (int var7 = 0; var7 < var6; var7++) {
                  if (!var1) {
                     this.iT.a(this.eL[var2[var7 * 4]], this.eN[var5] + var2[var7 * 4 + 1], this.eO[var5] + var2[var7 * 4 + 2], var2[var7 * 4 + 3]);
                  } else {
                     this.iV.a(this.eL[var2[var7 * 4]], this.eN[var5] + var2[var7 * 4 + 1], this.eO[var5] + var2[var7 * 4 + 2], var2[var7 * 4 + 3]);
                  }
               }
            }
         }
      }

      this.eN = null;
      this.eO = null;
      this.eM = null;
      eP = null;
   }

   private void d(boolean var1) {
      if (!var1) {
         this.P = this.m(10);
         hy = this.m(1) != 1;
         this.hz = hy;
         this.dE = this.m(1) == 1;
         this.dF = this.m(1) == 1;
         this.m(1);
         int var2 = this.m(16);
         this.hw = this.hw < var2 ? var2 : this.hw;
      }
   }

   private static int l(int var0) {
      int var1 = -1;

      while (var0 - 1 >> ++var1 > 0) {
      }

      return var1;
   }

   private void a(byte[] var1) {
      this.ji = var1;
      this.jj = 0;
      this.jk = 0;
      this.jl = 0;
   }

   private int m(int var1) {
      int var2 = 0;
      int var3 = var1;

      while (var3 > 0) {
         if (this.jl == 0) {
            this.jk = this.ji[this.jj++] & 255;
            this.jl = 8;
         }

         int var4 = Math.min(var3, this.jl);
         var2 |= (this.jk >> 8 - this.jl & ~(-1 << var4)) << var1 - var3;
         this.jl -= var4;
         var3 -= var4;
      }

      return var2;
   }

   private void b(int var1, boolean var2) {
      for (int var3 = 0; var3 < var1; var3++) {
         for (int var4 = 0; var4 < 1; var4++) {
            if (this.m(1) == 1 && !var2) {
               this.jc[var3] = (short)(this.jc[var3] | 1 << var4);
            }
         }
      }

      if (!var2) {
         this.iU = this.c(2058, bK[this.bF] >= 0 ? this.c(2068 + bK[this.bF]) : null);
      }
   }

   private void n(int var1) {
      this.a(0 + this.bQ, 0 + bM[var1]);
      this.bP[var1] = this.bP[this.bQ];
      this.bN[var1] = this.bN[this.bQ];
      this.bO[var1] = this.bO[this.bQ];
      bM[this.bQ] = -1;
      if (this.bQ >= 0) {
         this.bQ--;
      }
   }

   private void o(int var1) {
      if (this.bS[ca] >= 0) {
         this.a(ca + 30, var1 + 30);
      }

      this.bS[var1] = this.bS[ca];
      bT[var1] = bT[ca];
      this.bU[var1] = this.bU[ca];
      this.bY[var1] = this.bY[ca];
      this.bX[var1] = this.bX[ca];
      bV[var1] = bV[ca];
      this.bW[var1] = this.bW[ca];
      this.bS[ca] = -1;
      if (ca > 0) {
         ca--;
      }
   }

   private void p(int var1) {
      if (this.dm[this.dt] >= 0) {
         this.a(this.dt + 60, var1 + 60);
      }

      this.dm[var1] = this.dm[this.dt];
      dp[var1] = dp[this.dt];
      dq[var1] = dq[this.dt];
      this.do[var1] = this.do[this.dt];
      this.dn[var1] = this.dn[this.dt];
      this.dr[var1] = this.dr[var1];
      this.ds[var1] = this.ds[var1];
      this.dm[this.dt] = -1;
      if (this.dt >= 0) {
         this.dt--;
      }
   }

   private void q(int var1) {
      if (this.fe[this.fd] >= 0) {
         this.a(this.fd + 116, var1 + 116);
      }

      this.fe[var1] = this.fe[this.fd];
      fh[var1] = fh[this.fd];
      this.fi[var1] = this.fi[this.fd];
      this.ff[var1] = this.ff[this.fd];
      fg[var1] = fg[this.fd];
      this.fl[var1] = this.fl[this.fd];
      this.fm[var1] = this.fm[this.fd];
      this.fe[this.fd] = -1;
      if (this.fd >= 0) {
         this.fd--;
      }
   }

   private void e(int var1, int var2) {
      this.c(var1 + 1, var2, 128);
      this.c(var1 - 1, var2 + 1, 128);
      this.c(var1 - 1, var2, 128);
      this.c(var1 + 1, var2 + 1, 128);
      this.c(var1, var2 + 1, 128);
      this.c(var1, var2, 128);
   }

   private void r(int var1) {
      int var2 = var1 << 2;
      int var3 = this.fK << 2;
      System.arraycopy(fC, var3, fC, var2, 4);
      System.arraycopy(fD, var3, fD, var2, 4);
      fH[var1] = fH[this.fK];
      fE[var1] = fE[this.fK];
      fF[var1] = fF[this.fK];
      fG[var1] = fG[this.fK];
      fI[var1] = fI[this.fK];
      fJ[var1] = fJ[this.fK];
      if (this.fK >= 0) {
         this.fK--;
      }
   }

   private void b(int var1, int var2, int var3, int var4) {
      if (var4 != 0 && (var3 != 0 || hv < this.hw)) {
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
            for (int var8 = this.eF; var8 >= 0; var8--) {
               if (a(iW - 88, iX - 88, 416, 496, dX[var8] - this.ei[var8], this.dY[var8] - this.ej[var8], this.ei[var8] << 1, this.ej[var8])) {
                  if (++var7 >= this.O.length) {
                     var7 = this.O.length - 1;
                     break;
                  }

                  this.O[var7] = var8;
               }
            }

            if (var7 == -1) {
               return;
            }

            hp -= 256;
            if (hp <= 0) {
               hp = 0;
               this.z();
            }
         }

         int var13 = 0;
         boolean var9 = false;

         while (!var9) {
            this.M = N.nextInt();
            if (this.fK >= 18 && var4 > 0) {
               var9 = true;
               fJ[this.fK - 1] = fJ[this.fK - 1] + var4;
               var4 = 0;
            } else {
               this.fK++;
               int var10 = this.fK << 2;
               int var11 = (this.M & 128) > 0 ? 1 : -1;
               int var12 = var1 + var11 * (this.M & 15);
               fC[var10++] = var12;
               fC[var10++] = var12;
               fC[var10++] = var12;
               fC[var10++] = var12;
               var10 -= 4;
               fE[this.fK] = var11 * (this.M & 7) << 8;
               var11 = (this.M & 256) > 0 ? 1 : -1;
               var12 = var2 + var11 * (this.M & 15) - 10;
               fD[var10++] = var12;
               fD[var10++] = var12;
               fD[var10++] = var12;
               fD[var10] = var12;
               fF[this.fK] = (this.M >> 3 & 7) << 8;
               fI[this.fK] = var3;
               fH[this.fK] = 0;
               if (var3 == 3) {
                  fG[this.fK] = this.O[var13];
                  if (++var13 > var7) {
                     var13 = 0;
                  }
               } else {
                  fG[this.fK] = -1;
               }

               if (var4 > 24) {
                  fJ[this.fK] = var5;
                  var4 -= var5;
               } else {
                  fJ[this.fK] = var6;
                  var4 -= var6;
               }

               if (var4 < 0) {
                  fJ[this.fK] = fJ[this.fK] + var4;
                  var4 = 0;
                  var9 = true;
               }
            }
         }
      }
   }

   private void s() {
      this.gm = false;
      this.gi = -1;
      fV = false;
      this.aQ = false;
      this.hA = false;
      this.z();
      this.gA = this.ge / 22;
      gB = this.gf / 22;
      this.hn = this.hq;
      this.ho = this.hn;
      iW = this.ge - 120 - ((hy ? 1 : -1) * 240 >> 2);
      iX = this.gf - 266;
      this.aN = iW << 8;
      this.aO = iX << 8;
      this.gN = -1;
      this.gO = -1;
      this.s(0);
      this.a(133, 1025, 4);
      this.a(this.fL, 135, 0, 0, 0, this.O);
      this.hm = this.gf % 22;
      hl = this.ge % 22;
      gG = this.O[2] >> 1;
      this.gH = this.O[3];
      this.hk = this.gH / 22;
      this.hB = gG >> 1;
      this.hC = -(gG >> 1);
   }

   private void f(int var1, int var2) {
      if (super.a != 0) {
         this.ge = this.ge + ((!hy || super.a <= 0) && (hy || super.a >= 0) ? this.hC : this.hB - 1);
      }

      if (super.b < 0) {
         this.gf = this.gf - this.gH;
      } else {
         this.gf--;
      }

      int var5 = var1;
      int var6 = this.x();
      hl = this.ge - var5 * 22 << 8;
      if (hl <= 0) {
         var5--;
         hl += 5632;
      } else if (hl >= 5632) {
         var5++;
         hl -= 5632;
      }

      this.hm = this.gf - var6 * 22 << 8;
      if (super.a != 0) {
         this.ge = this.ge - ((!hy || super.a <= 0) && (hy || super.a >= 0) ? this.hC : this.hB - 1);
      }

      if (super.b < 0) {
         this.gf = this.gf + this.gH;
      } else {
         this.gf++;
      }

      int var7 = (super.a > 0 ? super.a : -super.a) << 8;
      int var8 = (super.b > 0 ? super.b : -super.b) << 8;
      int var9 = var7;
      int var10 = var8;
      this.hG = true;
      hH = true;
      if (var7 > var8) {
         if (var7 > 5632) {
            var8 = (var8 * 22 << 8) / var7;
            var7 = 5632;
         }
      } else if (var8 > 5632) {
         var7 = (var7 * 22 << 8) / var8;
         var8 = 5632;
      }

      int var3;
      if ((!hy || super.a <= 0) && (hy || super.a >= 0)) {
         var3 = -var7;
      } else {
         var3 = var7;
      }

      int var4 = super.b > 0 ? var8 : -var8;
      int var11 = 0;
      int var12 = 0;
      this.hM = 0;
      this.hN = 0;

      while (var11 < var9 || var12 < var10) {
         hl += var3;
         this.hm += var4;
         if (hl >= 5632) {
            hl -= 5632;
            var5++;
         } else if (hl < 0) {
            hl += 5632;
            var5--;
         }

         if (this.hm >= 5632) {
            this.hm -= 5632;
            var6++;
         } else if (this.hm < 0) {
            this.hm += 5632;
            var6--;
         }

         this.g(var5, var6);
         if ((this.h(var5, var6) & 32) == 0) {
            this.gO = -1;
            this.gN = -1;
         } else {
            this.iF = true;
            if (this.gN == -1) {
               for (int var13 = 0; var13 < this.de.length; var13++) {
                  if (a(var1, var2, this.de[var13], this.df[var13], this.dg[var13], dh[var13])) {
                     if (dj[var13] < this.dk[var13] && this.dk[var13] > 0 && this.gO <= 0) {
                        this.gN = var13;
                        this.gO = 2000;
                        if (dj[0] < this.dk[var13]) {
                           gQ = true;
                        }
                     } else {
                        this.gO = -1;
                        this.gN = -1;
                        this.iF = true;
                     }
                  }
               }
            }
         }

         if (this.hG) {
            this.hM += var3;
            var11 += var7;
         } else {
            hl -= var3;
            var9 = var11;
            if ((this.h(var1, var2) & 1) != 0 && !this.hJ) {
               this.hM = 0;
               if ((!hy || super.a <= 0) && (hy || super.a >= 0)) {
                  this.ge = var1 * 22 + (gG >> 1);
               } else {
                  this.ge = (var1 + 1) * 22 - (gG >> 1);
               }
            }
         }

         if (hH) {
            this.hN += var4;
            var12 += var8;
         } else {
            this.hm -= var4;
            var10 = var12;
            if (super.b < 0 && this.gr) {
               var6 += this.hk + 1;
            }
         }
      }

      this.ge = this.ge + (this.hM >> 8);
      this.gf = this.gf + (this.hN >> 8);
      if (var11 > var9) {
         int var14 = var11 - var9 >> 8;
         this.ge -= var3 > 0 ? var14 : -var14;
      }

      if (var12 > var10) {
         int var15 = var12 - var10 >> 8;
         this.gf -= var4 > 0 ? var15 : -var15;
      }

      if (!this.hG) {
         if (hl < 0) {
            var5--;
         } else if (hl > 22) {
            var5++;
         }
      }

      this.gA = var5;
      gB = var6;
   }

   private boolean t() {
      int var1 = (!hy || this.hE != 22) && (hy || this.hE != 23) ? -1 : 1;
      byte var2 = 0;
      if (this.gp == 1) {
         var2 = 1;
      }

      int var3 = eU[gh] + (var1 < 0 ? this.eY[gh] - 1 : 0);
      int var4 = gB;
      int var5 = this.eZ[gh];
      if (this.hE == 23 && var5 <= this.hk) {
         var5 = this.hk + 1;
      }

      for (int var6 = 0; var6 < var5; var6++) {
         if ((this.h(var3 + var1 + var1, var4 - var6) & 1) != 0) {
            return false;
         }

         if (this.hE == 23 && ((this.h(var3 + var1 + var1 + var1, var4 - var6) & 1) != 0 || (this.h(var3 + var1 + var1 + var1 + var1, var4 - var6) & 1) != 0)) {
            return false;
         }

         if ((this.h(var3 + var1 * (this.eY[gh] + var2), var4 - var6) & 1) != 0) {
            var2 = 0;
         }
      }

      if (this.hE == 23 && (this.h(this.gA + var1, var4) & 1) != 0) {
         return false;
      }

      for (int var8 = 0; var8 < this.eY[gh]; var8++) {
         for (int var7 = 0; var7 < this.eZ[gh]; var7++) {
            this.c(eU[gh] + var8, var4 - var7, 1);
            this.c(eU[gh] + var8, var4 - var7, 512);
            if (fa[gh]) {
               this.c(eU[gh] + var8, var4 - var7, 8);
            }
         }
      }

      eU[gh] = eU[gh] + (var1 > 0 ? 1 + var2 : -(1 + var2));

      for (int var9 = 0; var9 < this.eY[gh]; var9++) {
         for (int var10 = 0; var10 < this.eZ[gh]; var10++) {
            this.b(eU[gh] + var9, var4 - var10, 1);
            this.b(eU[gh] + var9, var4 - var10, 512);
            if (fa[gh]) {
               this.b(var3 + var9 + var2 + this.eY[gh] * var1, var4 - var10, 8);
            }
         }
      }

      this.hK = true;
      this.a(111 + gh, 6144, this.eR[gh] + (3 << var2));
      return true;
   }

   private void g(int var1, int var2) {
      boolean var3 = hy && super.a > 0 || !hy && super.a < 0;
      if ((this.h(var1, var2) & 1024) != 0) {
         this.gc = var1 * 22;
         this.gd = var2 * 22;
         this.hz = hy;
      }

      if ((this.h(var1, var2) & 256) != 0) {
         int var4 = var2;

         while ((this.h(var1, var4) & 256) != 0) {
            var4--;
         }

         var4++;

         for (int var5 = 0; var5 < this.db.length; var5++) {
            if (this.dc[var5] == var1 && dd[var5] == var4) {
               for (int var6 = 0; var6 < cZ.length; var6++) {
                  if (this.cW[var6] == this.db[var5]) {
                     cZ[var6] = !cZ[var6];
                  }
               }
               break;
            }
         }

         while ((this.h(var1, var4) & 256) != 0) {
            this.c(var1, var4, 256);
            var4++;
         }
      }

      if ((this.h(var1, var2) & 4) != 0) {
         int var15 = var2;

         for (int var22 = 0; (this.h(var1, var2 - var22) & 4) != 0; var22++) {
            var15--;
            this.c(var1, var2 - var22, 4);
         }

         int var23 = 1;
         var15++;

         while ((this.h(var1, var2 + var23) & 4) != 0) {
            this.c(var1, var2 + var23, 4);
            var23++;
         }

         int var26 = -1;

         for (int var7 = 0; var7 < this.eG.length; var7++) {
            if (this.eG[var7] == var1 && this.eH[var7] == var15) {
               var26 = var7;
               break;
            }
         }

         for (int var29 = 0; var29 <= this.eF; var29++) {
            eg[var29] = eh[var29];
            if (this.eI[this.ec[var29] + var26 * 15] != 0) {
               dZ[var29] = this.eI[this.ec[var29] + var26 * 15] * 22;
               ea[var29] = this.eJ[this.ec[var29] + var26 * 15] * 22;
               ew[var29] = this.eK[this.ec[var29] + var26 * 15];
               if (!a(iW - 88, iX - 88, 416, 496, dX[var29] - this.ei[var29], this.dY[var29] - this.ej[var29], this.ei[var29] << 1, this.ej[var29])) {
                  eo[var29] = er[var29];
                  dX[var29] = dZ[var29];
                  this.dY[var29] = ea[var29];
                  this.c(this.ed[var29], this.ee[var29] - 1, 2);
                  this.ed[var29] = dX[var29] / 22;
                  this.ee[var29] = this.dY[var29] / 22;
                  this.b(this.ed[var29], this.ee[var29] - 1, 2);
                  switch (this.dU[var29]) {
                     case 1:
                        this.i(0, var29);
                        break;
                     case 2:
                        this.i(0, var29);
                        break;
                     case 3:
                        this.i(0, var29);
                  }
               }
            }
         }
      }

      int var17 = 0;
      this.hI = false;

      for (int var24 = this.gH; var24 > 0; var24 -= 22) {
         if (var2 < je) {
            if (var2 - var17 < 0 || var2 - var17 >= je) {
               this.hG = false;
               break;
            }

            if (var24 > 0) {
               if (this.hG && var1 >= 0) {
                  this.hG = (this.h(var1, var2 - var17) & 1) == 0;
               } else {
                  this.hG = false;
               }

               if (!this.hG) {
                  if (this.hE != 22 && this.gx && (this.h(var1, var2 - var17) & 512) != 0) {
                     int var27 = hy ? 1 : -1;
                     int var30 = 0;

                     while ((this.h(var1 + var30, var2) & 512) != 0 && !hy) {
                        var30 += var27;
                     }

                     var30 += hy ? 0 : 1;

                     for (int var8 = fb; var8 >= 0; var8--) {
                        if (eU[var8] == var1 + var30 && this.eV[var8] == var2 + 1) {
                           this.hJ = true;
                           this.ge = var1 * 22 + (!hy ? this.hB : this.hC);
                           this.s(21);
                           gh = var8;
                        }
                     }
                  }
                  break;
               }
            }

            if (var1 < 0 || var1 >= jd) {
               this.hG = false;
            }

            if (super.b >= 0) {
               var17++;
            } else {
               var17--;
            }

            if (gu && var24 - 22 <= 0 && super.b == 0 && (this.h(var1, var2 - var17) & 16) == 0) {
               this.hG = false;
               this.s(26);
               this.gf++;
            }
         }
      }

      int var25 = var1;
      if (super.a == 0 && super.b != 0) {
         var25 += hy ? 1 : -1;
      }

      if (super.b >= 0) {
         var17 = this.hk;
         if (this.hm < 2816) {
            var17++;
         }
      } else {
         var17 = 0;
      }

      int var28 = var2 - var17;
      int var32 = hy ? -1 : 1;
      if (this.hn > 0
         && !this.gz
         && (this.h(var25, var28 - 1) & 1) == 0
         && ((this.h(var25, var28) & 1) != 0 || this.gy)
         && (this.h(var25 + var32, var28) & 1) == 0
         && (this.h(var25 + var32, var28 - 1) & 1) == 0
         && (this.h(var25 + var32, var28 + this.hk) & 1) == 0
         && super.b != 0
         && (!this.gr || this.gy)
         && !gv
         && !this.gC
         && H != 105) {
         if (this.gy && super.b < 0) {
            this.s(38);
            int var34 = 0;
            if ((this.h(var25, var2) & 1) == 0) {
               var34++;
            }

            this.gf = (var2 + var34) * 22 + this.gH;
         } else if (this.hE != 40 && !this.gr) {
            this.s(37);
            this.gf = (var2 - var17) * 22 + this.gH;
         }

         this.hN = 0;
         if (!hy) {
            var25++;
         }

         this.ge = var25 * 22 + (hy ? -(gG >> 1) : gG >> 1);
         this.hM = 0;
         hH = false;
         this.hG = false;
      } else {
         if (!this.hG && super.a != 0) {
            var17 = var3 ? -1 : 1;
         } else {
            var17 = 0;
         }

         int var33 = var2;
         int var9;
         if ((var9 = super.b > 0 ? var33 - this.hk : var33 + this.hk) < 0) {
            var9 = 0;
         }

         if (super.b != 0) {
            boolean var10 = false;

            for (int var11 = gG; var11 > 0; var11 -= 22) {
               if (var1 + var17 >= 0 && var1 + var17 < jd) {
                  if (hH) {
                     hH = (this.h(var1 + var17, var33) & 1) == 0;
                     if (((this.h(var1 + var17, var9) & 16) != 0 || (this.h(var1 + var17, var9) & 8192) != 0) && hF != 121 && this.hE != 38 && this.hn > 0) {
                        if ((this.h(var1 + var17, var9) & 8192) != 0 && hF != 24 && hF != 25 && !this.gt) {
                           this.s(120);
                           this.gf = (var9 + 1) * 22 + this.gH;
                           hH = false;
                           this.hN = 0;
                           this.gD = true;
                        } else if ((this.h(var1 + var17, var9) & 16) != 0) {
                           this.gf = (var9 + 1) * 22 + this.gH;
                           hH = false;
                           this.hN = 0;
                           this.s(45);
                        }
                     }
                  }

                  if (!hH && super.b > 0 && !gu && this.hE != 38) {
                     this.gf = var2 * 22;
                     this.hN = 0;
                     this.hI = true;
                     int var12 = var1;
                     if ((!hy || super.a <= 0) && (hy || super.a >= 0)) {
                        if (super.a != 0) {
                           var12++;
                        }
                     } else {
                        var12--;
                     }

                     if ((this.h(var12, var2) & 16384) != 0 && hF != 48) {
                        this.s(50);
                     } else if (this.hE != 77
                        && this.hE != 95
                        && this.hE != 108
                        && this.hE != 114
                        && this.hE != 115
                        && this.hE != 116
                        && this.hE != 60
                        && hF != 120
                        && hF != 121
                        && hF != 48) {
                        if (fV) {
                           this.u();
                        }

                        this.s(27);
                        if (this.hO >= 4) {
                           this.au = this.hO;
                        }
                     } else if (this.hE == 77 || this.hE == 60) {
                        this.gC = true;
                        this.au += 6;
                        this.E();
                        this.y(8);
                     } else if (this.hE == 95 && !var10) {
                        var10 = true;
                        this.b(this.ge, this.gf - this.gH + (this.gH >> 2), 3, fP[ha]);
                     }
                  }

                  if (!hH && (hF == 24 || hF == 25) && super.b < 0) {
                     this.s(99);
                     break;
                  }

                  if (var33 < 0 || var33 >= je) {
                     hH = false;
                  }

                  if (super.a == 0) {
                     break;
                  }
               }

               var17 = var3 ? --var17 : ++var17;
            }
         }

         if (this.gr && this.hE != 38) {
            int var35 = var1;
            var1 += hy ? 1 : -1;
            if ((this.h(var1, var33) & 8) == 0) {
               hH = false;
               this.gf = (var33 + (super.b < 0 ? 1 : 0)) * 22 + (super.b < 0 ? this.gH : 0);
               if (super.b >= 0 || (this.h(var1, var33) & 1) != 0) {
                  if (hF == 34) {
                     this.s(26);
                  } else {
                     this.s(33);
                  }

                  hH = false;
               }

               if (super.b < 0) {
                  this.gy = true;
               }
            }

            var1 = var35;
         }

         if (!this.hG && super.a != 0 && !this.hI && this.hE != 38 && !this.gr && !this.gt) {
            if ((!hy || super.a <= 0 || hl << 8 <= 22 - (gG >> 1)) && (hy || super.a >= 0 || hl >> 8 >= gG >> 1)) {
               if (!hy && super.a > 0 && hl << 8 > 22 - (gG >> 1) || hy && super.a < 0 && hl >> 8 < gG >> 1) {
                  this.ge = (var1 + 1) * 22 - this.hC;
                  this.hJ = true;
                  if ((this.h(var1, var33 + (super.b > 0 ? -1 : 1)) & 8) != 0
                     && (this.h(var1, var33 + (super.b > 0 ? -this.hk : this.hk)) & 8) != 0
                     && super.b != 0) {
                     this.s(33);
                  }
               }
            } else {
               this.ge = var1 * 22 - this.hB;
               this.hJ = true;
               if ((this.h(var1, var33 + (super.b > 0 ? -1 : 1)) & 8) != 0
                  && (this.h(var1, var33 + (super.b > 0 ? -this.hk : this.hk)) & 8) != 0
                  && this.hE != 38
                  && super.b != 0) {
                  this.s(33);
               }
            }

            this.hM = 0;
         }

         if (!this.hG && super.a != 0) {
            if (this.hE == 9) {
               this.s(0);
            } else if (this.hE == 51) {
               this.s(50);
            }
         }

         if (fV && (!this.hG || !hH)) {
            this.u();
         }
      }
   }

   private int h(int var1, int var2) {
      return var1 >= 0 && var1 < jd && var2 >= 0 && var2 < je ? this.jc[var1 + jd * var2] : 65;
   }

   private void b(int var1, int var2, int var3) {
      if (var1 >= 0 && var1 < jd && var2 >= 0 && var2 < je) {
         this.jc[var1 + jd * var2] = (short)(this.jc[var1 + jd * var2] | var3);
      }
   }

   private void c(int var1, int var2, int var3) {
      if (var1 >= 0 && var1 < jd && var2 >= 0 && var2 < je) {
         this.jc[var1 + jd * var2] = (short)(this.jc[var1 + jd * var2] & ~var3);
      }
   }

   private void u() {
      if (this.dU[this.gi] == 1) {
         this.i(0, this.gi);
      } else if (this.dU[this.gi] == 2) {
         this.i(0, this.gi);
      } else if (this.dU[this.gi] == 3) {
         this.i(0, this.gi);
      }

      this.s(26);
      fV = false;
      this.hL = 0;
   }

   private void i(int var1, int var2) {
      this.em[var2] = this.dU[var2] == 1 && (var1 == 13 || var1 == 17 || var1 == 23 || var1 == 12 || var1 == 15 || var1 == 16 || var1 == 14 || var1 == 21);
      this.el[var2] = this.dU[var2] == 1 && (var1 == 19 || var1 == 18 || var1 == 26 || var1 == 20);
      if (this.dU[var2] == 1) {
         if (var1 == 5 || var1 == 6 || var1 == 16 || var1 == 15) {
            this.dW[var2] = 0;
         } else if (var1 == 8 || var1 == 9 || var1 == 10 || var1 == 24) {
            this.eb[var2] = 0;
            this.dW[var2] = 1;
         } else if (var1 == 2 || var1 == 7) {
            this.dW[var2] = 2;
         } else if (var1 != 11 && var1 != 21 && var1 != 3) {
            if (var1 == 1) {
               ey[var2] = N.nextInt() & 511;
            }

            this.dW[var2] = -1;
         } else {
            this.dW[var2] = 3;
         }
      } else if (this.dU[var2] == 2) {
         if (var1 != 7 && var1 != 12 && var1 != 13) {
            this.dW[var2] = -1;
         } else {
            this.eb[var2] = 0;
            this.dW[var2] = 1;
         }

         if (var1 == 1) {
            ey[var2] = N.nextInt() & 511;
         }
      } else if (this.dU[var2] == 3) {
         if (var1 != 7 && var1 != 13 && var1 != 17 && var1 != 16) {
            this.dW[var2] = -1;
         } else {
            this.eb[var2] = 0;
            this.dW[var2] = 1;
         }

         if (var1 == 1) {
            ey[var2] = N.nextInt() & 511;
         }
      }

      if ((this.gi != -1 && var2 != this.gi || this.ax > 0) && !this.el[var2] && var1 != 7 && var1 != 11) {
         switch (this.dU[var2]) {
            case 1:
               if (this.dV[var2] == 0 && var1 != 27) {
                  return;
               }

               if (var1 != 27) {
                  var1 = 0;
               }
               break;
            case 2:
               if ((this.dV[var2] == 0 || this.dV[var2] == 12 || this.dV[var2] == 10) && var1 != 14) {
                  return;
               }

               if (var1 != 14) {
                  var1 = 0;
               }
               break;
            case 3:
               if ((this.dV[var2] == 0 || this.dV[var2] == 12 || this.dV[var2] == 11) && var1 != 18) {
                  return;
               }

               if (var1 != 18) {
                  var1 = 0;
               }
         }
      }

      this.dV[var2] = var1;
      if (this.dU[var2] == 1) {
         if (this.dE) {
            this.a(85 + var2, 18432, var1);
         } else {
            this.a(85 + var2, 4096, var1);
         }
      } else if (this.dU[var2] == 2) {
         if (this.dF) {
            this.a(85 + var2, 16384, var1);
         } else {
            this.a(85 + var2, 17408, var1);
         }
      } else {
         if (this.dU[var2] == 3) {
            if (dQ == var2 && this.dR != var2) {
               this.a(85 + var2, 13312, var1);
               return;
            }

            if (this.dR == var2) {
               this.a(85 + var2, 14336, var1);
               return;
            }

            this.a(85 + var2, 15360, var1);
         }
      }
   }

   private void v() {
      this.s(14);
      this.i(24, this.gi);
      this.b(dX[this.gi], this.dY[this.gi] - (this.ej[this.gi] >> 1), 1, this.eq[this.gi]);
      eo[this.gi] = -1;
      this.a(dX[this.gi] - (this.ei[this.gi] >> 1), this.dY[this.gi] - (this.ej[this.gi] >> 1), 22, !hy ? 2 : 0, false);
   }

   private void s(int var1) {
      this.fS = 0;
      this.fT = 0;
      gg = 0;
      this.hE = var1;
      hj = 0;
      boolean var2 = false;
      if (var1 == 22 && hf) {
         var1 = 20;
      }

      if ((var1 == 5 || var1 == 8) && hf) {
         var1++;
      } else if (var1 == 100 && hf) {
         var1++;
      } else if (var1 == 38 && hf) {
         var1 = 39;
      } else if (var1 == 27 && hf) {
         var1 = 29;
      } else if (var1 == 3) {
         if (hf) {
            var1 = 4;
         }
      } else if (var1 == 97 && hf) {
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
         && (this.dR != this.gi || this.gi >= 0 && this.dV[this.gi] != 16)) {
         fV = false;
         this.hL = 0;
         this.gi = -1;
         this.iF = true;
      }

      if (var1 != 31) {
         this.gq = false;
      } else {
         this.gq = true;
      }

      if (var1 == 0) {
         this.gz = false;
         if (this.gD) {
            var1 = 10;
         } else if (hf) {
            var1 = 1;
         }
      } else if (var1 == 31 && hf) {
         var1 = 32;
      } else if (var1 != 54 && var1 != 36 && var1 != 47) {
         this.gI = false;
         this.gz = false;
         this.fR = false;
      } else {
         this.gz = true;
         var2 = true;
         if (!this.gr && !gu) {
            if (this.fR) {
               this.fR = false;
               this.gK = 0;
            }

            if (hf) {
               var1 = 72 + this.gK;
               if (this.gK < this.gS) {
                  this.gK++;
               } else {
                  this.gI = false;
                  var1 = 77;
                  this.hE = 77;
                  this.fR = true;
               }
            } else {
               var1 += this.gK;
               if (this.gK < gR) {
                  this.gK++;
               } else {
                  var1 = 60;
                  this.fR = true;
                  this.gI = false;
                  this.hE = 60;
               }
            }
         }
      }

      gl = var1 == 7 || var1 == 5 || var1 == 8 || var1 == 6 || var1 == 101 || var1 == 119 || var1 == 118 || var1 == 100 || var1 == 5;
      if (var1 == 67) {
         var2 = true;
         this.gt = true;
         if (hf) {
            var1 = 83 + this.gK;
            if (this.gK > 3 - (gT < 3 ? 1 : 0)) {
               var1 = 83;
               this.gK = 0;
            } else if (this.gK == 2 - (gT < 3 ? 1 : 0)) {
               var1 = 85;
            }
         } else {
            var1 = 67 + this.gK;
            if (this.gK >= 3 - (gT < 3 ? 1 : 0)) {
               var1 = 67;
               this.gK = 0;
            } else if (this.gK == 2 - (gT < 3 ? 1 : 0)) {
               var1 = 69;
            }
         }

         this.gK++;
      } else {
         this.gt = false;
      }

      if (var1 == 91 || var1 == 92 || var1 == 93) {
         this.gt = true;
      }

      if (!this.gt && !this.gz) {
         this.gK = 0;
      }

      if (var1 != 35 && var1 != 34 && var1 != 36 && var1 != 33) {
         this.gr = false;
         this.gy = false;
      } else {
         this.gr = true;
      }

      gu = var1 == 45 || var1 == 47 || var1 == 46 || var1 == 119 || var1 == 118;
      if (var1 == 9) {
         this.gx = true;
         if (this.gD) {
            var1 = 11;
         }
      } else {
         this.gx = false;
      }

      if (var1 != 37 && var1 != 40) {
         gv = false;
         this.gy = false;
      } else {
         gv = true;
      }

      this.gw = var1 == 30;
      this.go = var1 == 21 || var1 == 22 || var1 == 23 || var1 == 20;
      this.gs = var1 == 50 || var1 == 51;
      if (var1 != 15 && var1 != 17) {
         this.gn = false;
      } else {
         this.gn = true;
         if (hf) {
            var1++;
         }
      }

      if (var2 && !gu && this.hn > 0) {
         int var3 = this.M & 1;
         if (hf && !this.gr) {
            this.y(4 + var3);
         } else {
            this.y(6 + var3);
         }
      }

      hF = var1;
      this.a(135, 28672, var1);
   }

   private boolean t(int var1) {
      return this.b(var1, this.K);
   }

   private int w() {
      return this.ge / 22;
   }

   private int x() {
      int var1;
      return (var1 = this.gf / 22) > je ? je : var1;
   }

   private void y() {
      int var1 = this.w();
      int var2 = (this.hm >> 8) + 1 >= 22 ? gB + 1 : gB;
      int var3 = 0;
      int var4 = this.ge - (gG >> 1);
      int var5 = this.gf;
      this.gC = gk;
      boolean var6 = this.gD;
      if (!this.gC) {
         this.gD = (this.h(var1, var2) & 8192) != 0 && hF != 99 && hF != 24 && hF != 25 && hF != 26;
         this.gC = (this.h(var1, var2) & 1) != 0;
         this.gE = (this.h(var1, var2 - 1) & 2048) != 0;
         gF = (this.h(var1, var2 - 1) & 4096) != 0;
      }

      if (this.gD && !var6) {
         if (this.gx) {
            this.gC = true;
            this.s(9);
         }
      } else if (!this.gD && var6 && this.gx) {
         this.s(9);
      }

      boolean var7 = this.b(135, this.K);
      gg = gg + this.K;
      if (!fV && (this.h(var1, var2) & 128) > 0) {
         for (int var8 = cz; var8 >= 0; var8--) {
            if (this.cp[var8] == var1 && cq[var8] == var2) {
               this.cw = this.cr[var8];
               this.cx = this.cr[var8];
               String var9 = this.e(this.cw);
               if (!this.aQ && var9.charAt(0) == '@') {
                  this.aQ = true;
                  this.aR = a.a(var9.substring(2, 3), 0) == 1;
                  this.aS = a.a(var9.substring(1, 2), 0);
                  this.a(131, 1027, this.aS);
               } else if (this.aQ) {
                  int var67 = super.a;
                  int var11 = super.b;
                  this.t(131);
                  super.a = var67;
                  super.b = var11;
               } else {
                  H = 101;
                  this.a(95, 35, 35, 35);
                  if (H != 105) {
                     this.cy = this.cx + this.cs[var8];

                     for (int var10 = cz; var10 >= 0; var10--) {
                        if (this.cr[var10] == this.cw) {
                           this.c(this.cp[var10], cq[var10], 128);
                        }
                     }

                     ib = new String[2];
                     this.p();
                  }
               }
            }
         }
      } else {
         this.aQ = false;
      }

      if (this.hE != 52 && this.hE != 53) {
         if (this.hE == 26) {
            super.b = super.b + this.hO;
            this.hP = this.hP + this.K;
            if (this.hP > 200) {
               this.hP -= 200;
               this.hO = this.hO + (this.hO >= 8 ? 0 : 4);
            }
         } else {
            this.hP = 0;
            this.hO = 0;
         }

         if (super.b < 0 && this.hE != 60) {
            this.gC = false;
         }

         if (H != 105 && H != 108 && H != 101) {
            if (!fV && this.gi < 0 && this.ax < 0) {
               switch (this.r) {
                  case 1:
                     if (this.gr
                        && this.hE == 33
                        && ((this.h(this.gA + (hy ? 1 : -1), gB - this.hk - 1) & 8) != 0 || (this.h(this.gA + (hy ? 1 : -1), gB - this.hk - 1) & 1) == 0)) {
                        this.s(35);
                     }
                     break;
                  case 2:
                     if (!this.gr && !gv && !this.go && this.hE != 44 && this.hE != 22 && this.hE != 38) {
                        if (gu && !gl && !this.gz) {
                           if (this.hE != 46) {
                              this.s(46);
                           }

                           hy = false;
                        } else {
                           if (this.hE == 0 || this.hE == 3) {
                              hy = false;
                              if ((
                                    (this.h(this.gA - 1, gB) & 1) != 0
                                       || (this.h(this.gA, gB) & 1) != 0
                                       || (this.h(this.gA - 1, gB - 1) & 1) != 0
                                       || (this.h(this.gA - 1, gB - 2) & 1) != 0
                                 )
                                 && (this.h(this.gA - 1, gB) & 512) == 0) {
                                 if ((this.h(this.gA - 1, gB) & 1) != 0
                                    || (this.h(this.gA, gB) & 1) != 0
                                    || (this.h(this.gA - 1, gB - 1) & 1) != 0
                                    || (this.h(this.gA - 1, gB - 2) & 1) != 0) {
                                    this.ge = (this.gA + ((this.h(this.gA, gB) & 1) != 0 ? 1 : 0)) * 22 + (gG >> 1);
                                 }
                              } else {
                                 if ((this.h(this.gA - 1, gB) & 512) != 0) {
                                    int var32 = (this.h(this.gA, gB) & 512) != 0 ? 1 : 0;
                                    this.ge = (this.gA + var32) * 22 + (gG >> 1);
                                 }

                                 this.s(9);
                                 this.hA = false;
                              }
                           } else if (this.hE == 50) {
                              hy = false;
                              if ((this.h(this.gA - 1, gB) & 1) == 0) {
                                 this.s(51);
                              }
                           }

                           if (this.hE == 9 || this.hE == 51) {
                              hy = false;
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
                     if (!this.gr && !gv && !this.go && this.hE != 44 && this.hE != 22 && this.hE != 38) {
                        if (gu && !gl && !this.gz) {
                           if (this.hE != 46) {
                              this.s(46);
                           }

                           hy = true;
                        } else {
                           if (this.hE == 0 || this.hE == 3) {
                              if (((this.h(this.gA + 1, gB - 1) & 1) != 0 || (this.h(this.gA + 1, gB) & 1) != 0 || (this.h(this.gA + 1, gB - 2) & 1) != 0)
                                 && (this.h(this.gA + 1, gB) & 512) == 0) {
                                 if ((this.h(this.gA + 1, gB) & 1) != 0) {
                                    this.ge = (this.gA + 1) * 22 - (gG >> 1);
                                 }
                              } else {
                                 if ((this.h(this.gA + 1, gB) & 512) != 0) {
                                    int var31 = (this.h(this.gA, gB) & 512) != 0 ? -1 : 0;
                                    this.ge = (this.gA + 1 + var31) * 22 - (gG >> 1);
                                 }

                                 this.s(9);
                                 this.hA = false;
                              }

                              hy = true;
                           } else if (this.hE == 50) {
                              hy = true;
                              if ((this.h(this.gA + 1, gB) & 1) == 0) {
                                 this.s(51);
                              }
                           }

                           if (this.hE == 9 || this.hE == 51) {
                              hy = true;
                           }
                        }
                     }
                     break;
                  case 6:
                     if (this.gr) {
                        if (this.hE == 33) {
                           if ((this.h(this.gA + (hy ? 1 : -1), gB + 1) & 8) != 0) {
                              this.s(34);
                           } else {
                              this.s(26);
                           }
                        }
                     } else if (gu) {
                        this.s(26);
                     } else if (hF == 120) {
                        this.s(26);
                        this.gf += 22;
                     }
               }
            }

            if (!fV && this.ax < 0) {
               switch (this.q) {
                  case 1:
                     if (this.gi >= 0) {
                        break;
                     }

                     if (this.hE == 21) {
                        this.s(24);
                     } else if (hF == 120) {
                        this.s(121);
                     } else if (!this.gw && hy && this.gE) {
                        this.s(30);
                     } else if (!this.gw && !hy && gF) {
                        this.s(30);
                     } else if (!this.gq && !this.gn && !this.gr && !gu && !gv && (this.gC || this.gD) && !this.go && this.gi < 0 && !this.gz) {
                        if (this.hA) {
                           this.hA = false;
                           this.s(0);
                        } else if (this.hE != 24 && this.hE != 26 && this.hE != 3 && this.hE != 38 && this.hE != 30) {
                           this.s(24);
                        }
                     } else if (gv) {
                        this.s(38);
                     } else if (this.hE == 24) {
                        this.s(25);
                     }
                     break;
                  case 2:
                     if (this.go && this.hE == 21) {
                        if (hy) {
                           this.s(23);
                           this.gp = 0;
                        } else {
                           this.s(22);
                           this.gp = 1;
                        }

                        if (!this.t()) {
                           this.s(21);
                        } else {
                           this.y(6);
                        }
                     } else if (this.gi >= 0 && eo[this.gi] > 0 && this.dU[this.gi] == 1 && this.hE != 14 && !this.gr) {
                        hy = false;
                        this.en[this.gi] = false;
                        this.v();
                     } else if (hy && (this.gz || this.gt) && this.gi < 0 && !this.gr) {
                        short var40 = 150;
                        if (hf && this.gK > this.gS || !hf && this.gK > gR) {
                           var40 = 600;
                        }

                        if (gJ > var40) {
                           this.gI = true;
                           this.fZ = false;
                        }
                     } else if (this.gr && !this.gz) {
                        if (hy) {
                           hy = false;
                           this.s(44);
                        }
                     } else if (gv && !hy) {
                        this.s(38);
                     }
                     break;
                  case 5:
                     if (this.go && this.hE == 21) {
                        if (hy) {
                           this.s(22);
                           this.gp = 1;
                        } else {
                           this.s(23);
                           this.gp = 0;
                        }

                        if (!this.t()) {
                           this.s(21);
                        } else {
                           this.y(6);
                        }
                     } else if (this.gi >= 0 && eo[this.gi] > 0 && this.dU[this.gi] == 1 && this.hE != 14 && !this.gr) {
                        hy = true;
                        this.en[this.gi] = true;
                        this.v();
                     } else if (!hy && (this.gz || this.gt) && this.gi < 0 && !this.gr && !gu) {
                        short var39 = 150;
                        if (hf && this.gK > this.gS || !hf && this.gK > gR) {
                           var39 = 600;
                        }

                        if (gJ > var39) {
                           this.gI = true;
                           this.fZ = true;
                        }
                     } else if (this.gr && !this.gz) {
                        if (!hy) {
                           hy = true;
                           this.s(44);
                        }
                     } else if (gv && hy) {
                        this.s(38);
                     }
                     break;
                  case 6:
                     if (!this.gz && (this.hE == 0 || this.hE == 9) && this.gC) {
                        for (int var36 = this.eF; var36 >= 0; var36--) {
                           if ((this.gf == this.dY[var36] || this.gf + 1 == this.dY[var36])
                              && a(
                                 dX[var36] - (this.ei[var36] >> 1) - (gG >> 1),
                                 this.dY[var36],
                                 this.ei[var36] + gG,
                                 this.ej[var36],
                                 this.ge,
                                 this.gf,
                                 gG,
                                 this.gH
                              )) {
                              boolean var56 = true;

                              for (int var69 = this.gA; var69 < this.ed[var36]; var69++) {
                                 var56 &= (this.h(var69, gB) & 1) == 0;
                              }

                              if ((this.eb[var36] <= 0 || this.dU[var36] == 3 && this.dV[var36] == 12) && var56) {
                                 this.iF = true;
                                 if (dQ != var36 && this.dU[var36] == 1 && eo[var36] > 0 && eo[var36] < er[var36] >> 1) {
                                    this.gi = var36;
                                    this.ge = dX[var36];
                                    this.en[var36] = hy;
                                    super.a = 0;
                                    this.s(12);
                                    this.i(22, var36);
                                    break;
                                 }

                                 if (this.dU[var36] != 2 || (eo[var36] <= 0 || eo[var36] >= er[var36] >> 1) && this.dV[var36] != 12) {
                                    if (this.dU[var36] != 3 || (eo[var36] <= 0 || eo[var36] >= er[var36] >> 1) && (this.dV[var36] != 12 || dQ == var36)) {
                                       continue;
                                    }

                                    this.gi = var36;
                                    if (this.dV[var36] == 12 && dQ != var36) {
                                       this.s(113);
                                       this.b(dX[this.gi], this.dY[this.gi] - (this.ej[this.gi] >> 1), 0, this.eq[this.gi] >> 1);
                                       this.ge = dX[var36];
                                       hy = this.en[var36];
                                       this.eb[var36] = 0;
                                       eo[var36] = -1;
                                       this.i(16, var36);
                                       break;
                                    }

                                    this.ge = dX[var36];
                                    this.en[var36] = hy;
                                    super.a = 0;
                                    this.hL = 1;
                                    fV = true;
                                    this.fW = 0;
                                    this.fU = 3;
                                    this.fX = this.A();
                                    this.a(131, 1027, fY[this.fX]);
                                    if (dQ != var36 && this.dR != var36) {
                                       this.s(91);
                                       this.i(14, var36);
                                    } else if (this.dR == var36) {
                                       this.s(114);
                                       this.i(13, var36);
                                    } else if (dQ == var36) {
                                       this.s(108);
                                       this.i(13, var36);
                                    }

                                    this.en[var36] = !hy;
                                    break;
                                 }

                                 this.gi = var36;
                                 if (this.dV[var36] != 12 && this.dV[var36] != 10) {
                                    this.ge = dX[var36];
                                    this.en[var36] = hy;
                                    super.a = 0;
                                    this.s(88);
                                    this.hL = 1;
                                    fV = true;
                                    this.fU = 2;
                                    this.fW = 0;
                                    this.fX = this.A();
                                    this.a(131, 1027, fY[this.fX]);
                                    this.i(11, var36);
                                    this.en[var36] = !hy;
                                    break;
                                 }

                                 this.s(117);
                                 this.ge = dX[var36];
                                 eo[var36] = -1;
                                 this.b(dX[this.gi], this.dY[this.gi] - (this.ej[this.gi] >> 1), 2, this.eq[this.gi] >> 1);
                                 this.i(13, var36);
                                 break;
                              }
                           }
                        }
                     }

                     if (gv) {
                        this.s(40);
                        this.gf++;
                     } else if (this.hE == 0) {
                        if (hy) {
                           for (int var37 = this.fq; var37 >= 0; var37--) {
                              if (!ft[var37]
                                 && a(this.fu[var37], this.fv[var37], this.fr, this.fs, this.ge - this.hB, this.gf, gG, this.gH)
                                 && Math.abs(this.gf - this.fv[var37]) < 11) {
                                 this.s(31);
                                 this.ge = this.fu[var37] + (this.fr >> 1);
                              }
                           }
                        }

                        for (int var38 = this.cB; var38 >= 0; var38--) {
                           if (hy && this.cE[var38] && a(this.ge - (gG >> 1), this.gf - this.gH, gG, this.gH, this.cC[var38] - 22, cD[var38], 44, 22)) {
                              this.hS = var38;
                              this.hT = var38;
                              if (!this.cH[var38]) {
                                 this.s(15);
                              } else {
                                 this.s(17);
                              }

                              this.ge = this.cC[var38];
                              this.cH[var38] = !this.cH[var38];
                           }
                        }
                     }

                     if (this.gC && !this.gs && !this.go && !this.gn && !this.gq && this.gi < 0 && hF != 24 && hF != 48 && hF != 30) {
                        this.hA = true;
                        this.s(3);
                     }

                     if (this.gD) {
                        this.s(26);
                     }
                     break;
                  case 8:
                     if (!this.gq && !this.go && !this.gn && this.gC && this.gi < 0 && !this.gD) {
                        if (this.hE != 0 && this.hE != 3) {
                           if (!this.gC || hg || this.hh || hf && hp < 0) {
                              break;
                           }

                           short var35 = 150;
                           if (hf && this.gK > this.gS || !hf && this.gK > gR) {
                              var35 = 600;
                           }

                           if (gJ > var35) {
                              this.gI = true;
                           }
                        } else {
                           this.hA = false;
                           var7 = true;
                           if (hg && hp > gZ + 1 << 2) {
                              this.s(94);
                           } else if (this.hh && hp > 256 && this.fK < 10) {
                              this.s(95);
                              this.z();
                           } else {
                              hg = false;
                              this.hh = false;
                              if (!hf || hp <= 0) {
                                 this.z();
                              }

                              this.fZ = hy;
                              if (!hf || hp > 0) {
                                 this.s(54);
                              }
                           }
                        }
                     } else if (this.gi >= 0 && eo[this.gi] > 0) {
                        if (this.dU[this.gi] == 1) {
                           this.s(13);
                           this.i(10, this.gi);
                           this.b(dX[this.gi], this.dY[this.gi] - (this.ej[this.gi] >> 1), 0, this.eq[this.gi]);
                           eo[this.gi] = -1;
                        } else if (this.dU[this.gi] != 2) {
                        }
                     } else if (!this.gC && !this.gD && !this.gr && !gu && hF != 120 && hF != 121 && !this.gz && this.hE != 37) {
                        if (hf && hp <= 0 || hg || this.hh) {
                           this.z();
                        }

                        if (!this.gt) {
                           this.fZ = hy;
                           this.s(67);
                        } else {
                           short var34 = 150;
                           if (hf && this.gK > this.gS || !hf && this.gK > gR) {
                              var34 = 600;
                           }

                           if (gJ > var34) {
                              this.gI = true;
                           }
                        }
                     } else if (gu && !this.gz) {
                        if (this.hE != 47) {
                           this.z();
                           this.s(47);
                        }
                     } else if (this.gr && !this.gz) {
                        this.z();
                        this.s(36);
                     } else if (hF == 21) {
                        this.s(0);
                     }
                     break;
                  case 27:
                  case 42:
                     if (!this.hA && !this.gz) {
                        this.fQ++;
                        if (this.fQ > 3) {
                           this.fQ = 0;
                        }

                        hf = this.fQ == 1;
                        hg = this.fQ == 2;
                        this.hh = this.fQ == 3;
                        if (this.hE == 0) {
                           this.s(0);
                        }
                     }
                     break;
                  case 29:
                     if (this.Z == this.S) {
                        this.ae = this.Z >> 8;
                        this.af = this.aa >> 8;
                        this.I = H;
                        this.a(G, G, 35, 35);
                        H = 102;
                        aq = 4;
                     }
                     break;
                  case 35:
                     this.bh = false;
                     this.a(133, 1025, 2);
                     this.a(134, 1025, 3);
                     this.bm = (256 - (this.hu & 0xFF)) * 320 >> 8;
                     H = 106;
               }

               if (this.A) {
                  if (this.q == 55) {
                     this.hn = -1;
                  }

                  if (this.q == 48) {
                     this.B = !this.B;
                  }

                  if (this.q == 57) {
                     this.hn = this.hq;
                  }

                  if (this.q == 51) {
                     this.C = !this.C;
                  }
               }
            } else if (this.ax < 0) {
               boolean var33 = false;
               int var55 = super.a;
               int var68 = super.b;
               this.t(131);
               super.a = var55;
               super.b = var68;
               if (this.fW >= 0 && this.fW < this.fU) {
                  switch (this.q) {
                     case 1:
                        if (this.fX == 0) {
                           var33 = true;
                        }
                        break;
                     case 2:
                        if (this.fX == 1) {
                           var33 = true;
                        }
                     case 3:
                     case 4:
                     case 7:
                     default:
                        break;
                     case 5:
                        if (this.fX == 3) {
                           var33 = true;
                        }
                        break;
                     case 6:
                        if (this.fX == 4) {
                           var33 = true;
                        }
                        break;
                     case 8:
                        if (this.fX == 2) {
                           var33 = true;
                        }
                  }

                  if (var33) {
                     int var79 = this.A();
                     this.fX = var79;
                     this.fW++;
                     this.a(131, 1027, fY[this.fX]);
                  } else if (this.q != 0 && this.q != 27 && this.q != 29 && this.q != 4 && this.q != 9) {
                     this.fW = -1;
                  }
               }
            }

            if (this.r != 6 && this.hA) {
               this.hA = false;
               this.s(0);
            }

            if (this.r != 2 && this.r != 5) {
               if (this.hE == 9) {
                  this.s(0);
               } else if (this.hE == 46) {
                  this.s(45);
               } else if (this.gs && this.hE != 50) {
                  this.s(50);
               }
            }

            if (this.r != 1 && hF == 35 || this.r != 6 && hF == 34) {
               this.s(33);
            }

            if ((this.r != 8 || hp <= 0) && this.hE == 94) {
               this.s(0);
               if (hp <= 0) {
                  hp = 0;
               }

               this.z();
            }

            if (this.r == 8 && this.hE == 94) {
               hp -= 12;
            }

            if (!this.gC
               && !this.gD
               && !this.gt
               && !gu
               && !gk
               && this.hE != 26
               && this.hE != 99
               && this.hE != 48
               && (this.gK != 5 && this.gK != 6 && this.gK != this.gS || !hf)
               && !this.gw
               && var7) {
               if ((this.hE != 24 && this.hE != 25 && this.hE != 44 && this.hE != 38 || var7)
                  && (
                     this.hE == 24
                        || this.hE == 25
                        || this.hE == 44
                        || this.hE == 40
                        || this.hE == 38
                        || this.hE == 108
                        || this.hE == 114
                        || this.hE == 116
                        || this.hE == 115
                        || hF == 121
                        || hF == 120
                        || gv
                        || this.gr
                        || gu
                  )) {
                  if ((this.hE == 47 || this.hE == 118 || this.hE == 119) && !var7) {
                     this.s(45);
                  } else if (this.gC && this.hE != 24 && this.hE != 26) {
                     this.s(0);
                  }
               } else {
                  this.s(26);
               }
            } else if (!var7) {
               if (this.hE == 31 && !var7) {
                  for (int var41 = this.fq; var41 >= 0; var41--) {
                     if (!ft[var41] && a(this.fu[var41], this.fv[var41], this.fr, this.fs, this.ge - this.hB, this.gf, gG, this.gH)) {
                        this.fx[var41] = this.fx[var41] + 4;
                        this.s(31);
                        this.a(121 + var41, 5120, this.fx[var41]);
                        ft[var41] = true;
                        this.e(this.gA, gB);
                     }
                  }
               }

               if (this.hE == 27 && !this.hA && !hf) {
                  this.s(28);
               } else if (this.hE == 27 && this.hA) {
                  this.s(3);
               } else if (this.hA && this.hE == 3) {
                  this.s(3);
               } else if (this.hE == 38) {
                  this.s(0);
               } else if (this.hE == 40) {
                  this.s(26);
               } else if (hF == 121) {
                  if ((this.h(this.gA, gB + 1) & 8192) != 0) {
                     this.gD = true;
                  }

                  this.s(0);
               } else if (hF == 120) {
                  this.gf += 22;
                  this.s(26);
               } else if (this.hE == 47 || this.hE == 119 || this.hE == 118) {
                  this.s(45);
               } else if (this.hE == 97) {
                  this.s(3);
               } else if (this.hE == 88) {
                  if (this.fW >= this.fU) {
                     eo[this.gi] = 1;
                     this.s(89);
                     this.b(dX[this.gi], this.dY[this.gi] - (this.ej[this.gi] >> 1), 2, this.eq[this.gi] >> 1);
                     this.i(10, this.gi);
                  } else {
                     this.s(90);
                     this.i(0, this.gi);
                  }

                  fV = false;
                  this.hL = 0;
               } else if (this.gz && this.gI) {
                  hy = this.fZ;
                  this.s(54);
                  gJ = 0;
                  this.gI = false;
               } else if ((this.gC || !this.gI) && !fV) {
                  if (this.hE == 23) {
                     this.s(21);
                  } else if (this.hE == 36) {
                     this.s(33);
                  } else if (this.hA && this.gC || !this.gC && (!this.gD || hF == 26 || hF == 25 || hF == 70 || this.gt || hF == 24)) {
                     if (this.hE != 26 && this.gt) {
                        this.s(70);
                     } else if ((!this.gD || hF == 70) && !this.gC && !gu) {
                        this.s(26);
                     }
                  } else if (hF == 48) {
                     this.s(50);
                  } else {
                     this.s(0);
                  }
               } else if (fV) {
                  fV = false;
                  this.hL = 0;
                  this.gI = false;
                  if (this.fW >= this.fU) {
                     if (dQ != this.gi) {
                        eo[this.gi] = 1;
                        this.s(92);
                        this.b(dX[this.gi], this.dY[this.gi] - (this.ej[this.gi] >> 1), 1, this.eq[this.gi]);
                        this.i(11, this.gi);
                     } else if (this.dR != this.gi) {
                        this.s(109);
                        this.b(dX[this.gi], this.dY[this.gi] - (this.ej[this.gi] >> 1), 2, this.eq[this.gi]);
                        this.b(dX[this.gi], this.dY[this.gi] - (this.ej[this.gi] >> 1), 1, this.eq[this.gi]);
                        eo[this.gi] = er[this.gi];
                        if (this.bF >= 4) {
                           this.i(14, this.gi);
                        } else {
                           this.i(15, this.gi);
                        }
                     } else if (this.dR == this.gi) {
                        this.s(115);
                        eo[this.gi] = er[this.gi];
                        this.en[this.gi] = hy;
                        this.b(dX[this.gi], this.dY[this.gi] - (this.ej[this.gi] >> 1), 2, this.eq[this.gi]);
                        this.b(dX[this.gi], this.dY[this.gi] - (this.ej[this.gi] >> 1), 1, this.eq[this.gi]);
                        this.i(14, this.gi);
                        this.dS++;
                        if (this.dS >= 3) {
                           this.eC = true;
                        }

                        if (this.dS > 3) {
                           eo[this.gi] = -1;
                        }
                     }
                  } else if (dQ != this.gi) {
                     this.s(93);
                     this.i(0, this.gi);
                  } else if (this.dR != this.gi) {
                     eo[this.gi] = er[this.gi];
                     this.i(0, this.gi);
                     this.s(110);
                  } else if (this.dR == this.gi) {
                     this.s(116);
                     eo[this.gi] = er[this.gi];
                     this.en[this.gi] = hy;
                     this.i(12, this.gi);
                  }
               } else {
                  this.s(67);
                  hy = this.fZ;
                  this.gI = false;
               }
            } else if (this.hE == 3 && !this.hA) {
               this.s(28);
            }

            if (this.hn <= 0 && this.gi < 0 && (!this.go || hF == 21)) {
               if (!this.gC && hF != 26) {
                  this.s(26);
               } else if (this.gC && hF != 52 && hF != 53) {
                  this.s(52);
                  this.hn = 0;
               }
            }
         } else if (H == 105) {
            if (!this.gC && !this.gt && this.hE != 24 && !this.gD && !gu && !gk) {
               if (this.hE == 37) {
                  this.s(40);
                  this.gf++;
               } else {
                  this.s(26);
               }
            }

            if (!var7 && this.hE != 26) {
               if (this.aX[this.aZ + 1] != 0 || this.aY[this.ba + 1] != 0 && this.dP >= 0) {
                  if (this.aX[this.aZ + 1] == 0) {
                     this.s(this.aX[this.aZ]);
                  } else {
                     this.aZ++;
                     this.s(this.aX[this.aZ]);
                  }
               } else {
                  this.B();
               }
            }

            if (this.q == 29 && this.Z == this.S && this.aa == this.T) {
               this.ae = this.Z >> 8;
               this.af = this.aa >> 8;
               this.I = H;
               H = 102;
               aq = 4;
               this.a(G, G, 35, 35);
            }
         }

         this.f(var1, var2);
      } else if (this.hE == 52 && !var7 && H != 108) {
         this.a(G, G, 35, 35);
         H = 108;
         this.S = 0;
         this.T = 0;
      }

      if (!this.gz && !this.gt) {
         gJ = 0;
      } else {
         gJ = gJ + this.K;
      }

      if (this.B) {
         this.hn = this.hq;
      }

      if (this.hn >= this.ho && !this.gm
         || this.gi >= 0
         || gl
         || this.go
         || this.gz
         || hF == 60
         || hF == 77
         || this.hn <= 0
         || !this.gC
         || this.ge == this.gc && this.gf == this.gd) {
         if (gu && this.hn < this.ho && !gl && !this.gz) {
            if (this.gj == hy) {
               this.s(118);
            } else {
               this.s(119);
            }
         } else if (this.gi >= 0) {
            this.hn = this.ho;
         }
      } else {
         this.gm = false;
         if (!this.hA && hF != 27 && hF != 28 && hF != 29) {
            if (this.ho - this.hn > 50) {
               hy = this.gj;
               this.s(7);
            } else if (hy == this.gj) {
               this.s(5);
            } else {
               this.s(100);
            }
         } else if (this.hA) {
            this.gm = false;
            if (hF != 97) {
               hy = this.gj;
               this.s(97);
            }
         }
      }

      this.ho = this.hn;
      if (hF == 9 && ((this.h(this.gA + (hy ? 1 : -1), gB + 2) & 16384) != 0 || (this.h(this.gA + (hy ? 1 : -1), gB + 3) & 16384) != 0)) {
         this.s(48);
      }

      this.a(this.ge, this.gf, 135, this.hx, hy);
      this.gM = this.gM - this.K;
      if (this.gM < 0 && gL != 0) {
         this.gM = 0;
         gL = 0;
         this.iF = true;
      }

      if (this.gN != -1 && this.dk[this.gN] - dj[this.gN] <= 3 && this.gO > 0) {
         if (this.dk[this.gN] <= 0) {
            this.gO = this.gO - this.K;
            if (this.gO <= 0) {
               this.iF = true;
            }
         }

         this.gP = this.gP - this.K;
         if (this.gP < 0) {
            this.gP = 200 - this.gP;
            gQ = !gQ;
            this.iF = true;
         }
      }

      for (int var42 = this.bQ; var42 >= 0; var42--) {
         if (bM[var42] >= 0 && !this.t(bM[var42] + 0)) {
            this.n(var42);
         }
      }

      for (int var43 = this.fq; var43 >= 0; var43--) {
         if (this.fx[var43] >= 0) {
            int var57 = this.fu[var43] - iW;
            int var70 = this.fv[var43] - iX;
            if (var57 + this.fr >= 0
               && var70 + this.fs >= 0
               && var57 - this.fr <= 240
               && var70 - this.fs <= 320
               && !this.t(var43 + 121)
               && fw[var43] != 0
               && this.fx[var43] < 8
               && this.fx[var43] >= 4) {
               this.fx[var43] = this.fx[var43] + 4;
               this.a(121 + var43, 5120, this.fx[var43]);
               if (fw[var43] == -1) {
                  hi = hi | 1 << this.bF;
                  this.fA = 192;
                  this.hs++;
                  H = 104;
                  this.fz = 10;
                  this.a(136, 1026, 0);
               } else if (fw[var43] == -2) {
                  hi = hi | 1 << this.bF << 10;
                  this.fA = 192;
                  this.ht++;
                  H = 104;
                  this.fz = 9;
                  this.a(136, 1026, 1);
               } else if (fw[var43] != 0) {
                  this.b(this.fu[var43] + (this.fr >> 1), this.fv[var43] - this.fs - 10, this.fx[var43] - 8, fw[var43]);
               }
            }
         }
      }

      for (int var44 = this.fK; var44 >= 0; var44--) {
         int var58 = var44 << 2;
         int var71 = 12 * this.K;
         int var80 = fG[var44] < 0 ? this.ge : dX[fG[var44]];
         int var12 = fG[var44] < 0 ? this.gf : this.dY[fG[var44]];
         if (var80 < fC[var58] && fE[var44] > -4608) {
            fE[var44] = fE[var44] - var71;
         } else if (var80 > fC[var58] && fE[var44] < 4608) {
            fE[var44] = fE[var44] + var71;
         } else {
            fE[var44] = fE[var44] >> 2;
         }

         if (var12 - (this.gH >> 1) + 11 < fD[var58] && fF[var44] > -4608) {
            fF[var44] = fF[var44] - var71;
         } else if (var12 - (this.gH >> 1) - 11 > fD[var58] && fF[var44] < 4608) {
            fF[var44] = fF[var44] + var71;
         } else {
            fF[var44] = fF[var44] - (fF[var44] >> 3);
         }

         if (a(fC[var58], fD[var58], var80 + this.hC, var12 - this.gH, gG, this.gH)) {
            if (fH[var44] > 75) {
               if (fI[var44] == 1) {
                  if (this.hn < this.hq && this.hn > 0 && H != 108) {
                     this.hn = this.hn + fJ[var44];
                     this.ho = this.ho + fJ[var44];
                     if (this.hn > this.hq) {
                        this.hn = this.hq;
                        this.ho = this.hq;
                     }
                  }
               } else if (fI[var44] == 2) {
                  hp = hp + fJ[var44];
                  if (hp > this.hr) {
                     hp = this.hr;
                  }
               } else if (fI[var44] == 0) {
                  this.hu = this.hu + fJ[var44];
                  hv = hv + fJ[var44];
                  if (hv > this.hw) {
                     this.hu = this.hu + (this.hw - hv);
                     hv = this.hw;
                  }
               } else if (fI[var44] == 3) {
                  int var13 = fG[var44];
                  byte var14 = this.dU[var13];
                  if (var13 != this.gi && (this.dU[var13] != 1 || this.dV[var13] != 22)) {
                     eo[fG[var44]] = eo[fG[var44]] - fJ[var44];
                  }

                  fG[var44] = -1;
                  if (var13 != this.gi && eo[var13] <= 0 && this.dW[var13] != 1 && (this.dU[var13] != 1 || this.dV[var13] != 22) && this.dW[var13] != 3) {
                     if (dQ == var13) {
                        eo[var13] = (er[var13] >> 1) - 1;
                     } else {
                        eo[var13] = -1;
                        if (this.em[var13] || this.el[var13]) {
                           this.i(11, var13);
                        } else if (var14 == 1) {
                           this.i(8, var13);
                           this.b(dX[var13], this.dY[var13] - (this.ej[var13] >> 1), 0, this.eq[var13]);
                        } else if (var14 == 2) {
                           this.i(7, var13);
                           this.b(dX[var13], this.dY[var13] - (this.ej[var13] >> 1), 2, this.eq[var13]);
                        } else if (var14 == 3) {
                           if (this.dV[var13] != 17) {
                              this.i(7, var13);
                           }

                           this.b(dX[var13], this.dY[var13] - (this.ej[var13] >> 1), 0, this.eq[var13]);
                        }
                     }
                  } else if (this.dU[var13] == 2 && this.dV[var13] == 12) {
                     eo[var13] = 1;
                  }
               }

               this.r(var44);
            } else {
               fH[var44] = fH[var44] + this.K;
            }
         }

         fC[var58] = fC[var58] + (fE[var44] >> 8);
         fD[var58] = fD[var58] + (fF[var44] >> 8);
         System.arraycopy(fC, var58, fC, var58 + 1, 3);
         System.arraycopy(fD, var58, fD, var58 + 1, 3);
      }

      for (int var45 = ch + 10; var45 >= 10; var45--) {
         var3 = var45 - 10;
         if (this.cc[var3] >= 0) {
            int var59 = cd[var3] - iW;
            int var72 = ce[var3] - iX;
            if (var59 + this.cg[var3] >= 0 && var72 + this.cf[var3] >= 0 && var59 - this.cg[var3] <= 240 && var72 - this.cf[var3] <= 320) {
               if (!this.t(var45)) {
                  this.cc[var3] = -1;
               }

               cd[var3] = cd[var3] + super.a;
               ce[var3] = ce[var3] + super.b;
            }
         }
      }

      for (int var46 = co + 40; var46 >= 40; var46--) {
         var3 = var46 - 40;
         if (this.cj[var3] >= 0) {
            int var60 = this.ck[var3] - iW;
            int var73 = cl[var3] - iX;
            if (var60 + this.cn[var3] >= 0 && var73 + this.cm[var3] >= 0 && var60 - this.cn[var3] <= 240 && var73 - this.cm[var3] <= 320) {
               if (!this.t(var46)) {
                  this.cj[var3] = -1;
               }

               this.ck[var3] = this.ck[var3] + super.a;
               cl[var3] = cl[var3] + super.b;
            }
         }
      }

      for (int var47 = ca + 30; var47 >= 30; var47--) {
         var3 = var47 - 30;
         if (this.bS[var3] >= 0) {
            if (!this.t(var47) && this.bZ[var3]) {
               this.bS[var3] = -1;
               this.o(var3);
            } else if ((this.bS[var3] & 1) == 0 && a(bV[var3], this.bW[var3], this.bY[var3], this.bX[var3], this.ge - this.hB, this.gf - this.gH, gG, this.gH)) {
               this.bS[var3]++;
               this.a(var47, 5122, this.bS[var3]);
            }

            bT[var3] = bT[var3] + super.a;
            this.bU[var3] = this.bU[var3] + super.b;
         }
      }

      for (int var48 = this.cB; var48 >= 0; var48--) {
         int var61 = var48 + 106;
         int var74 = this.cE[var48] ? 4 : 0;
         boolean var81 = this.t(var61);
         int var86 = cI[var48];
         if (!this.cE[var48]
            && (
               this.gC && a(this.ge - (gG >> 1), this.gf - this.gH, gG, this.gH, this.cC[var48], cD[var48], 22, 22)
                  || (this.h(this.cJ[var48], cK[var48]) & 1) != 0
            )) {
            if (!this.cH[var48]) {
               this.cH[var48] = true;
               this.x(var48);
               this.hT = var48;
            }
         } else if (!this.cE[var48] && this.cH[var48]) {
            this.cH[var48] = false;
            this.x(var48);
            this.hT = var48;
         }

         if (!var81) {
            boolean var91 = false;
            if (!this.cH[var48]) {
               if (var86 == 1 + var74) {
                  cI[var48] = 2 + var74;
                  this.a(var61, 2050, cI[var48]);
                  var91 = true;
               }
            } else if (var86 == 3 + var74) {
               cI[var48] = 0 + var74;
               this.a(var61, 2050, cI[var48]);
               var91 = true;
            }

            if ((var86 == 3 + var74 || var86 == 1 + var74) && !var91 && this.hS >= 0) {
               this.x(this.hS);
               this.hS = -1;
            }
         }

         if (this.hT >= 0 && this.hT == var48) {
            this.hT = -1;
            if (var86 == 0 + var74 || var86 == 3 + var74) {
               cI[var48] = 1 + var74;
               this.a(var61, 2050, cI[var48]);
            } else if (var86 == 2 + var74 || var86 == 1 + var74) {
               cI[var48] = 3 + var74;
               this.a(var61, 2050, cI[var48]);
            }
         }
      }

      for (int var49 = cM; var49 >= 0; var49--) {
         int var62 = var49 + 100;
         boolean var75 = this.t(var62);
         int var82 = cX[var49] - (this.cY[var49] << 2);
         if (var75) {
            if (cZ[var49]) {
               if (var82 == 2) {
                  cX[var49] = (this.cY[var49] << 2) + 3;
                  this.a(var62, 2049, cX[var49]);
               }
            } else if (var82 == 0) {
               cX[var49] = (this.cY[var49] << 2) + 1;
               this.a(var62, 2049, cX[var49]);
            }
         } else if (!cZ[var49]) {
            if (var82 == 3) {
               cX[var49] = (this.cY[var49] << 2) + 0;
               this.a(var62, 2049, cX[var49]);
            } else if (var82 == 1) {
               cX[var49] = (this.cY[var49] << 2) + 2;
               this.a(var62, 2049, cX[var49]);

               for (int var88 = 0; var88 < this.cU[var49]; var88++) {
                  for (int var93 = 0; var93 < cS[var49]; var93++) {
                     this.b(cO[var49] + var93, cP[var49] - var88, 1);
                  }
               }
            }
         } else if (var82 == 1) {
            cX[var49] = (this.cY[var49] << 2) + 2;
            this.a(var62, 2049, cX[var49]);
         } else if (var82 == 3) {
            cX[var49] = (this.cY[var49] << 2) + 0;
            this.a(var62, 2049, cX[var49]);

            for (int var87 = 0; var87 < this.cU[var49]; var87++) {
               for (int var92 = 0; var92 < cS[var49]; var92++) {
                  this.c(cO[var49] + var92, cP[var49] - var87, 1);
               }
            }
         }
      }

      for (int var50 = this.dt + 60; var50 >= 60; var50--) {
         var3 = var50 - 60;
         if (this.dm[var3] >= 0) {
            int var63 = dp[var3] - iW;
            int var76 = dq[var3] - iX;
            if (var63 + this.ds[var3] >= 0 && var76 + this.dr[var3] >= 0 && var63 - this.ds[var3] <= 240 && var76 - this.dr[var3] <= 320) {
               boolean var83 = !this.t(var50);
               if (this.do[var3] == 2) {
                  dp[var3] = dp[var3] - super.a;
                  dq[var3] = dq[var3] - super.b;
               } else {
                  dp[var3] = dp[var3] + super.a;
                  dq[var3] = dq[var3] + super.b;
               }

               if (!this.gz && !this.gt && hF != 30
                  || (this.dm[var3] & 1) != 0
                  || this.hx[2] == 0 && this.hx[7] == 0
                  || !a(this.hx[0], this.hx[1], this.hx[2], this.hx[3], dp[var3], dq[var3] - this.dr[var3], this.ds[var3], this.dr[var3])
                     && !a(this.hx[5], this.hx[6], this.hx[7], this.hx[8], dp[var3], dq[var3] - this.dr[var3], this.ds[var3], this.dr[var3])) {
                  if (var83 && (this.dm[var3] & 1) == 1) {
                     this.j(var3, 1);
                     this.p(var3);
                  }
               } else {
                  this.dm[var3]++;
                  this.a(var50, 5121, this.dm[var3]);
                  this.b(dp[var3], dq[var3] - (this.dr[var3] >> 1), 1, 25);
               }
            }
         }
      }

      for (int var51 = fb; var51 >= 0; var51--) {
         if (this.hK) {
            this.hK = false;
         } else if (this.t(var51 + 111)) {
            this.eS[var51] = this.eS[var51] + ((!hy || this.hE != 22) && (hy || this.hE != 23) ? -super.a : super.a);
            this.eT[var51] = this.eT[var51] + super.b;
         } else {
            this.a(var51 + 111, 6144, this.eR[var51]);
         }
      }

      for (int var52 = this.fd; var52 >= 0; var52--) {
         int var64 = fh[var52] - iW;
         int var77 = this.fi[var52] - iX;
         if (var64 + fj[var52] >= 0 && var77 + this.fk[var52] >= 0 && var64 - fj[var52] <= 240 && var77 - this.fk[var52] <= 320) {
            for (byte var84 = 0; var84 < this.hx.length; var84 += 5) {
               if ((this.fe[var52] & 1) == 0) {
                  if (!hg
                     && this.hx[var84 + 3] != 0
                     && a(
                        this.hx[var84],
                        this.hx[var84 + 1],
                        this.hx[var84 + 2],
                        this.hx[var84 + 3],
                        fh[var52],
                        this.fi[var52] - this.fk[var52],
                        fj[var52],
                        this.fk[var52]
                     )) {
                     if (!this.b(116 + var52, 5)) {
                        this.b(fh[var52], this.fi[var52] - (this.fk[var52] >> 1), 0, 50);
                        this.j(var52, 2);

                        for (int var89 = 1; var89 <= this.fm[var52]; var89++) {
                           for (int var94 = 0; var94 < this.fl[var52]; var94++) {
                              this.c(this.ff[var52] + var94, fg[var52] - var89, 1);
                           }
                        }

                        this.fe[var52]++;
                        this.a(var52 + 116, 2048, this.fe[var52]);
                        this.q(var52);
                     }

                     this.a(fh[var52] + (hy ? 0 : fj[var52]), this.hx[1] + (this.hx[3] >> 1), 28, !hy ? 2 : 0, false);
                  }
               } else {
                  this.b(116 + var52, this.K);
               }
            }
         }
      }

      for (int var53 = this.dD + 70; var53 >= 70; var53--) {
         var3 = var53 - 70;
         if (this.dv[var3] >= 0) {
            boolean var65 = !this.t(var53);
            dx[var3] = dx[var3] + super.a;
            this.dy[var3] = this.dy[var3] + super.b;
            if (var65) {
               dx[var3] = this.dz[var3];
               this.dy[var3] = this.dA[var3];
               this.a(var53, 6145, this.dv[var3]);
            }

            this.a(dx[var3], this.dy[var3], var53, eA, true);
            if (this.gi < 0 && eA[2] > 0 && a(eA[0], eA[1], eA[2], eA[3], var4, var5 - this.gH, gG, this.gH)) {
               if (!this.eC) {
                  this.hn = this.hn - (this.dw[var3] * this.K >> 2);
                  if (this.hn < 0) {
                     this.hn = 0;
                  }
               }

               this.ho = this.hn;
               if (!gl && !this.go && !this.gz && hF != 52 && hF != 53 && hF != 60 && hF != 77 && this.gC) {
                  this.s(5);
               }
            }
         }
      }

      this.t(132);

      for (int var54 = this.eF + 85; var54 >= 85; var54--) {
         var3 = var54 - 85;
         boolean var66 = false;
         if (this.dT[var3] >= 0) {
            int var78 = this.dY[var3];
            int var85 = dX[var3];
            byte var90 = this.dU[var3];
            int var95 = this.dV[var3];
            this.c(this.ed[var3], this.ee[var3] - 1, 2);
            this.et[var3] = var78 - this.ee[var3] * 22 << 8;
            this.ed[var3] = u(var3);
            int var96 = this.ed[var3];
            int var15 = (this.et[var3] >> 8) + 1 >= 22 ? this.ee[var3] + 1 : this.ee[var3];
            int var16 = this.ge - var85;
            int var17 = this.gf - var78;
            int var18 = Math.abs(var16);
            this.dK = var18;
            int var19 = Math.abs(var17);
            eE = (this.h(var96, var15) & 1) != 0;
            if ((this.h(var96, var15) & 64) != 0 && this.dW[var3] != 1 && dX[var3] > 0) {
               eo[var3] = -1;
               if (var90 == 1) {
                  this.i(8, var3);
                  this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 0, this.eq[var3]);
               } else if (var90 == 2) {
                  this.i(7, var3);
                  this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 2, this.eq[var3]);
               }
            }

            if (dX[var3] > -10
               && this.dY[var3] > -10
               && (
                  a(iW - 88, iX - 88, 416, 496, dX[var3] - this.ei[var3], this.dY[var3] - this.ej[var3], this.ei[var3] << 1, this.ej[var3])
                     || this.dP == var3 && H == 105
                     || this.dU[var3] == 1
                        && (this.dV[var3] == 11 || this.dV[var3] == 27 || this.dV[var3] == 8 || this.dV[var3] == 9 || this.dV[var3] == 10 || this.dV[var3] == 7)
                     || this.dU[var3] == 2 && (this.dV[var3] == 8 || this.dV[var3] == 14 || this.dV[var3] == 7 || this.dV[var3] == 10 || this.dV[var3] == 9)
                     || this.dU[var3] == 3
                        && (
                           this.dV[var3] == 10 || this.dV[var3] == 18 || this.dV[var3] == 7 || this.dV[var3] == 13 || this.dV[var3] == 17 || this.dV[var3] == 8
                        )
               )) {
               boolean var20 = false;
               if (this.eb[var3] <= 500) {
                  var20 = !this.b(var54, this.K - (this.eb[var3] >> 5));
               }

               if (this.dV[var3] == 11 && this.dU[var3] == 1 || this.dV[var3] == 8 && this.dU[var3] == 2 || this.dV[var3] == 10 && this.dU[var3] == 3) {
                  super.b = super.b + dN[var3];
                  this.dO[var3] = this.dO[var3] + this.K;
                  if (this.dO[var3] > 200) {
                     this.dO[var3] = this.dO[var3] - 200;
                     dN[var3] = dN[var3] + (dN[var3] >= 8 ? 0 : 4);
                  }
               } else {
                  this.dO[var3] = 0;
                  dN[var3] = 0;
               }

               if (H != 105 && this.eb[var3] <= 500) {
                  if (var20) {
                     if (H != 105) {
                        switch (var90) {
                           case 1:
                              if (var95 != 8 && var95 != 9 && var95 != 10) {
                                 if (!this.em[var3] && !this.el[var3]) {
                                    if (var18 < 66 && var19 < 22) {
                                       if (Math.abs(this.M & 3) == 3) {
                                          this.i(6, var3);
                                       } else {
                                          this.i(5, var3);
                                       }

                                       this.en[var3] = var16 >= 0;
                                    } else if (var95 != 0
                                       && var19 < 44
                                       && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] : -ef[var3]), this.ee[var3] - 1) & 3) == 0
                                       && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] + 1 : -(ef[var3] + 1)), this.ee[var3] - 1) & 3) == 0
                                       && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] : -ef[var3]), this.ee[var3]) & 3) != 0
                                       && var18 < 198) {
                                       if (ey[var3] < 0) {
                                          this.i(1, var3);
                                       } else {
                                          this.i(0, var3);
                                          ey[var3] = ey[var3] - this.K;
                                       }
                                    } else if (this.dV[var3] == 25) {
                                       this.i(1, var3);
                                    } else {
                                       if (this.dV[var3] == 27) {
                                          eE = true;
                                       }

                                       this.i(0, var3);
                                    }

                                    if (ez[var3] && this.dV[var3] == 1) {
                                       int var102;
                                       if ((var102 = dX[var3] - dZ[var3]) > 88) {
                                          this.en[var3] = false;
                                       } else if (var102 < 88) {
                                          this.en[var3] = true;
                                       }
                                    }
                                 } else if (this.em[var3]) {
                                    if (var95 != 16 && var95 != 15 && var17 > 0 && var17 < 44 && var18 < 22) {
                                       this.i(16, var3);
                                    } else if (var95 != 15 && var95 != 16 && var17 < 0 && var17 > -88 && var18 < 22) {
                                       this.i(15, var3);
                                    } else if (var17 < 0 && var95 != 12 && var95 != 15 && var95 != 16 && var95 != 21) {
                                       this.i(12, var3);
                                    } else if (var95 != 13 && var95 != 15 && var95 != 16 && var95 != 21) {
                                       this.i(13, var3);
                                    } else if (var95 != 21) {
                                       this.i(23, var3);
                                    }
                                 } else if (this.el[var3] && (var95 == 20 || var95 == 19)) {
                                    this.i(26, var3);
                                 }
                              } else {
                                 if (this.dL < 25) {
                                    this.j(var3, 0);
                                 }

                                 this.w(var3);
                                 this.a(dX[var3], this.dY[var3], 26, 0, false);
                                 dX[var3] = -1000;
                                 this.dY[var3] = -1000;
                                 var85 = -1000;
                                 var78 = -1000;
                                 this.dM++;
                                 if (iS) {
                                    this.iF = true;
                                 }

                                 this.i(0, var3);
                              }
                              break;
                           case 2:
                              if (var95 != 7 && var95 != 12 && var95 != 13) {
                                 if (var95 != 12) {
                                    byte var100 = 0;
                                    if (this.dF) {
                                       var100 = 1;
                                    }

                                    if (this.dV[var3] == 10) {
                                       this.i(12, var3);
                                    } else if (var18 < 22 * (3 + var100) && var19 < 22) {
                                       if (Math.abs(this.M & 3) == 3) {
                                          this.i(6, var3);
                                       } else {
                                          this.i(5, var3);
                                       }

                                       this.en[var3] = var16 >= 0;
                                    } else {
                                       if (this.dV[var3] == 27) {
                                          eE = true;
                                       }

                                       this.i(0, var3);
                                    }
                                 }
                              } else {
                                 if (this.dL < 25) {
                                    this.j(var3, 0);
                                 }

                                 this.w(var3);
                                 this.a(dX[var3], this.dY[var3], 26, 0, false);
                                 dX[var3] = -1000;
                                 this.dY[var3] = -1000;
                                 var85 = -1000;
                                 var78 = -1000;
                                 this.i(0, var3);
                                 this.dM++;
                                 if (iS) {
                                    this.iF = true;
                                 }
                              }

                              if (ez[var3] && this.dV[var3] == 1) {
                                 int var101;
                                 if ((var101 = dX[var3] - dZ[var3]) > 88) {
                                    this.en[var3] = false;
                                 } else if (var101 < 88) {
                                    this.en[var3] = true;
                                 }
                              }
                              break;
                           case 3:
                              if ((var95 == 7 || var95 == 13 || var95 == 17) && dQ != var3 && this.dR != var3
                                 || dQ == var3 && (var95 == 7 || var95 == 16)
                                 || this.dR == var3 && var95 == 16) {
                                 if (dQ == var3 && var95 == 7 || this.dR == var3) {
                                    if (this.dR != var3) {
                                       this.cw = 266;
                                       this.cx = 266;
                                       this.cy = 274;
                                    } else {
                                       this.cw = 243;
                                       this.cx = 243;
                                       this.cy = 245;
                                    }

                                    this.a(95, 35, 35, 35);
                                    H = 101;
                                    this.p();
                                 }

                                 if (this.dL < 25) {
                                    this.j(var3, 0);
                                 }

                                 this.w(var3);
                                 if (dQ != var3) {
                                    this.a(dX[var3], this.dY[var3], 26, 0, false);
                                 }

                                 dX[var3] = -1000;
                                 this.dY[var3] = -1000;
                                 var85 = -1000;
                                 var78 = -1000;
                                 this.i(0, var3);
                                 this.dM++;
                                 if (iS) {
                                    this.iF = true;
                                 }
                              } else if (dQ == var3 && this.dR != var3 && this.dV[var3] == 15) {
                                 this.i(16, var3);
                              }

                              if (dQ != var3 || this.dR == var3 || this.dV[var3] != 16) {
                                 if (var95 == 11 && dQ != var3) {
                                    this.i(12, var3);
                                 } else if (var95 == 16 && dQ != var3 && this.dR != var3) {
                                    this.i(17, var3);
                                    eo[var3] = -1;
                                 } else if (var95 == 12 && dQ != var3) {
                                    this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 1, this.eq[var3]);
                                    this.i(13, var3);
                                    eo[var3] = -1;
                                 } else if (var18 < 22 * (3 + (dQ == var3 ? 1 : 0)) && var19 < 22 && this.gi < 0) {
                                    if (Math.abs(this.M & 3) == 3) {
                                       if (dQ == var3 && (this.M & 1) != 0) {
                                          this.i(12, var3);
                                       } else {
                                          this.i(6, var3);
                                       }
                                    } else {
                                       this.i(3, var3);
                                    }

                                    if (!fV) {
                                       this.en[var3] = var16 >= 11;
                                    }
                                 } else if (var95 != 0 && this.gi != var3) {
                                    super.a = 0;
                                    super.b = 0;
                                    this.i(0, var3);
                                 }

                                 if (ez[var3] && this.dV[var3] == 1) {
                                    int var99;
                                    if ((var99 = dX[var3] - dZ[var3]) > 88) {
                                       this.en[var3] = false;
                                    } else if (var99 < 88) {
                                       this.en[var3] = true;
                                    }
                                 }

                                 if (this.dR == var3 && var95 == 14 && this.dS >= 3) {
                                    this.i(16, var3);
                                 } else if (this.dR == var3 && var95 == 14 && this.dS < 3) {
                                    this.i(17, var3);
                                    this.en[var3] = !this.en[var3];
                                 }
                              }
                        }
                     }
                  } else if (H != 105) {
                     switch (var90) {
                        case 1:
                           if (var95 == 1) {
                              if (var16 > 22 && !this.en[var3]) {
                                 this.en[var3] = true;
                              } else if (var16 < -22 && this.en[var3]) {
                                 this.en[var3] = false;
                              }

                              if (var18 < 66 && var19 < 22) {
                                 this.i(6, var3);
                                 this.en[var3] = var16 >= 0;
                              } else if (var18 < 44 && var19 > 22 && var19 < 176 && this.gr && !this.dE
                                 || var18 < 88 && var19 > 22 && var19 < 44 && gu && !this.dE
                                 || var17 > 0 && var19 < 44 && var18 < 66 && this.hE != 37 && this.hE != 38 && !gu && !gv && this.hE != 38) {
                                 this.i(3, var3);
                              }
                           } else if (this.em[var3]) {
                              if (var95 != 16 && var95 != 21 && var17 > 0 && var17 < 44 && var18 < 22) {
                                 this.i(16, var3);
                              } else if (var95 != 15 && var95 != 21 && var17 < 0 && var17 > -88 && var18 < 22) {
                                 this.i(15, var3);
                              } else if (var17 < 0 && var95 != 12 && var95 != 15 && var95 != 16 && var95 != 21) {
                                 this.i(12, var3);
                              } else if (var95 != 13 && var95 != 15 && var95 != 21 && var95 != 16 && var17 > 0) {
                                 this.i(13, var3);
                              } else if (var95 == 21 && eE) {
                                 this.i(0, var3);
                              }
                           } else if (!this.el[var3]) {
                              if ((this.h(this.ed[var3], this.ee[var3] - 1) & 512) != 0 && this.dV[var3] != 8) {
                                 this.en[var3] = !hy;
                                 eo[var3] = -1;
                                 this.i(8, var3);
                                 this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 0, this.eq[var3]);
                              } else if (var95 == 0
                                 && var19 < 44
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] : -ef[var3]), this.ee[var3] - 1) & 3) == 0
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] + 1 : -(ef[var3] + 1)), this.ee[var3] - 1) & 3) == 0
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] : -ef[var3]), this.ee[var3]) & 3) != 0
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] + 1 : -(ef[var3] + 1)), this.ee[var3]) & 3) != 0
                                 && var18 < 198) {
                                 if (ey[var3] < 0) {
                                    this.i(1, var3);
                                 } else {
                                    ey[var3] = ey[var3] - this.K;
                                 }
                              } else if (var95 == 0 && var17 <= 44 && var17 > 0 && this.gC && var18 < 66) {
                                 this.i(3, var3);
                              } else if (var95 == 21) {
                                 this.i(0, var3);
                              } else if (this.dV[var3] == 0 && var18 < 66 && var19 < 22) {
                                 if (Math.abs(this.M & 3) == 3) {
                                    this.i(6, var3);
                                 } else {
                                    this.i(5, var3);
                                 }

                                 this.en[var3] = var16 >= 0;
                              }
                           } else {
                              if (var16 > 22
                                 && var18 < 99
                                 && this.dV[var3] != 19
                                 && this.dV[var3] != 18
                                 && (this.h(this.ed[var3] + 1, this.ee[var3] - this.ek[var3] - 1) & 16) != 0) {
                                 this.i(18, var3);
                                 this.en[var3] = true;
                              } else if (var16 < -22
                                 && var18 < 99
                                 && this.dV[var3] != 19
                                 && this.dV[var3] != 18
                                 && (this.h(this.ed[var3] - 1, this.ee[var3] - this.ek[var3] - 1) & 16) != 0) {
                                 this.i(18, var3);
                                 this.en[var3] = false;
                              }

                              if (this.dV[var3] != 19 && var18 < 66 && var19 < 22) {
                                 this.i(19, var3);
                                 this.en[var3] = var16 >= 0;
                              }
                           }
                           break;
                        case 2:
                           byte var21 = 0;
                           if (this.dF) {
                              var21 = 1;
                           }

                           if (var95 != 1) {
                              if ((this.h(this.ed[var3], this.ee[var3] - 1) & 512) != 0 && this.dV[var3] != 7) {
                                 this.en[var3] = !hy;
                                 eo[var3] = -1;
                                 this.i(7, var3);
                                 this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 2, this.eq[var3]);
                              } else if (var95 == 0
                                 && var19 < 44
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] : -ef[var3]), this.ee[var3] - 1) & 3) == 0
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] + 1 : -(ef[var3] + 1)), this.ee[var3] - 1) & 3) == 0
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] : -ef[var3]), this.ee[var3]) & 3) != 0
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] + 1 : -(ef[var3] + 1)), this.ee[var3]) & 3) != 0
                                 && var18 < 198) {
                                 if (ey[var3] < 0) {
                                    this.i(1, var3);
                                 } else {
                                    ey[var3] = ey[var3] - this.K;
                                 }
                              } else if (this.dV[var3] == 0) {
                                 byte var22 = 0;
                                 if (this.dF) {
                                    var22 = 1;
                                 }

                                 if (var18 < 22 * (3 + var22) && var19 < 22) {
                                    if (Math.abs(this.M & 3) == 3) {
                                       this.i(6, var3);
                                    } else {
                                       this.i(5, var3);
                                    }

                                    this.en[var3] = var16 >= 0;
                                 }
                              }
                           } else {
                              if (var16 > 22 && !this.en[var3]) {
                                 this.en[var3] = true;
                              } else if (var16 < -22 && this.en[var3]) {
                                 this.en[var3] = false;
                              }

                              if (var18 < 22 * (3 + var21) && var19 < 22) {
                                 this.i(6, var3);
                                 this.en[var3] = var16 >= 0;
                              }
                           }
                           break;
                        case 3:
                           if (var95 != 12) {
                              if (var95 == 1) {
                                 if (var16 > 22 && !this.en[var3]) {
                                    this.en[var3] = true;
                                 } else if (var16 < -22 && this.en[var3]) {
                                    this.en[var3] = false;
                                 }

                                 if (var18 < 22 * (3 + (dQ == var3 ? 1 : 0)) && var19 < 22) {
                                    this.i(6, var3);
                                    this.en[var3] = var16 >= 0;
                                 }
                              } else if ((this.h(this.ed[var3], this.ee[var3] - 1) & 512) != 0 && this.dV[var3] != 7) {
                                 eo[var3] = -1;
                                 this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 0, this.eq[var3]);
                                 this.i(7, var3);
                                 this.en[var3] = !hy;
                              } else if (var95 == 0
                                 && var19 < 44
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] + 1 : -(ef[var3] + 1)), this.ee[var3] - 1) & 3) == 0
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] + 1 : -(ef[var3] + 1)), this.ee[var3] - 1) & 3) == 0
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] + 1 : -(ef[var3] + 1)), this.ee[var3]) & 3) != 0
                                 && (this.h(this.ed[var3] + (var16 > 0 ? ef[var3] + 1 : -(ef[var3] + 1)), this.ee[var3]) & 3) != 0
                                 && var18 < 198) {
                                 if (ey[var3] < 0) {
                                    this.i(1, var3);
                                 } else {
                                    ey[var3] = ey[var3] - this.K;
                                 }
                              }
                           }

                           if (var95 == 0 && var18 < 22 * (3 + (dQ == var3 ? 1 : 0)) && var19 < 22 && this.gi < 0) {
                              if (Math.abs(this.M & 3) == 3) {
                                 if (dQ == var3 && (this.M & 1) != 0) {
                                    this.i(12, var3);
                                 } else {
                                    this.i(6, var3);
                                 }
                              } else {
                                 this.i(3, var3);
                              }

                              if (!fV) {
                                 this.en[var3] = var16 >= 11;
                              }
                           }
                     }
                  }
               } else if ((var3 == this.dP || this.eb[var3] > 0) && this.eb[var3] <= 0 && var20) {
                  if (this.aX[this.aZ + 1] == 0 && this.aY[this.ba] == 0) {
                     this.B();
                  } else if (this.aY[this.ba + 1] == 0) {
                     this.i(this.aY[this.ba], var3);
                  } else {
                     this.ba++;
                     this.i(this.aY[this.ba], var3);
                  }
               }

               if (this.eb[var3] <= 500) {
                  this.d(this.ed[var3], this.ee[var3], var3);
               }

               if (!eE
                  && !this.em[var3]
                  && !this.el[var3]
                  && this.dW[var3] != 1
                  && (
                     this.dU[var3] == 1 && this.dV[var3] != 11 && this.dV[var3] != 27 && this.dV[var3] != 3 && this.dV[var3] != 11 && this.dV[var3] != 24
                        || this.dU[var3] == 2 && this.dV[var3] != 8 && this.dV[var3] != 14
                        || this.dU[var3] == 3 && this.dV[var3] != 10 && this.dV[var3] != 18
                  )
                  && this.dR != var3) {
                  switch (this.dU[var3]) {
                     case 1:
                        this.i(11, var3);
                        break;
                     case 2:
                        this.i(8, var3);
                        break;
                     case 3:
                        this.i(10, var3);
                  }
               }

               if (!eB && (this.dV[var3] == 1 || this.dV[var3] == 18 || this.dV[var3] == 1 || this.dV[var3] == 1)) {
                  switch (this.dU[var3]) {
                     case 1:
                        this.i(0, var3);
                        break;
                     case 2:
                        this.i(0, var3);
                        break;
                     case 3:
                        this.i(0, var3);
                  }
               }
            }

            if (H != 105 && dX[var3] < 0 && (eg[var3] > 0 || iS)) {
               ev[var3] = ev[var3] - this.K;
               if (ev[var3] <= 0 && this.bQ < 9 && (Math.abs(dZ[var3] - this.ge) > 44 || Math.abs(ea[var3] - this.gf) > 44)) {
                  if ((this.h(dZ[var3] / 22, ea[var3] / 22 - 1) & 1) == 0 && (this.h(dZ[var3] / 22, ea[var3] / 22 - 1) & 2) == 0) {
                     eg[var3]--;
                     ev[var3] = this.ex[var3];
                     this.el[var3] = false;
                     dX[var3] = dZ[var3];
                     this.dY[var3] = ea[var3];
                     eo[var3] = er[var3];
                     this.ed[var3] = dX[var3] / 22;
                     this.ee[var3] = this.dY[var3] / 22;
                     this.b(this.ed[var3], this.ee[var3] - 1, 2);
                     this.a(dX[var3], this.dY[var3], 25, 0, false);
                     switch (this.dU[var3]) {
                        case 1:
                           if (this.el[var3]) {
                              this.i(26, var3);
                           } else {
                              this.i(27, var3);
                           }
                           break;
                        case 2:
                           this.i(14, var3);
                           break;
                        case 3:
                           this.i(18, var3);
                     }
                  } else {
                     ev[var3] = 1500;
                  }
               }
            }

            this.a(var85, var78, var3 + 85, eA, this.en[var3]);

            for (byte var103 = 0; var103 < this.hx.length; var103 += 5) {
               if (this.hx[var103 + 2] != 0) {
                  int var97;
                  if (hf || hg) {
                     var97 = 0;
                  } else if (var103 == 0) {
                     var97 = this.fS;
                  } else {
                     var97 = this.fT;
                  }

                  if (var97 < 2 && a(this.hx[var103], this.hx[var103 + 1], this.hx[var103 + 2], this.hx[var103 + 3], eA[0], eA[1], eA[2], eA[3])) {
                     int var105 = eA[0] + (this.en[var3] ? eA[7] : 0);
                     int var23 = eA[1] + (eA[3] >> 1);
                     if (eA[1] < eA[3]) {
                        var23 = eA[3];
                     } else if (var23 > this.dY[var3]) {
                        var23 = this.dY[var3];
                     }

                     var97++;
                     int var24 = hf ? fN[this.gK] << gU : fM[this.gK] << gT;
                     if (this.C) {
                        var24 = 10000;
                     }

                     if (hf) {
                        hp = hp - ((fN[this.gK] << 1) + fN[this.gK]);
                     }

                     if (hf && !this.gt && hj < 3 || !hf && !hg) {
                        eo[var3] = eo[var3] - var24;
                        if (!hf) {
                           if (!var66) {
                              this.y(2 + (this.M & 1));
                           }

                           if (var97 == 1) {
                              gL++;
                           }
                        } else if (!var66) {
                           this.y(0 + (this.M & 1));
                        }

                        var66 = true;
                        this.iF = true;
                        this.gM = 2000;
                     } else if (hg) {
                        this.eb[var3] = this.eb[var3] + (fO[gZ] << 5) + this.K;
                     }

                     if (eo[var3] <= 0 && this.dW[var3] != 1) {
                        eo[var3] = -1;
                        if (!this.em[var3] && !this.el[var3]) {
                           if (eE) {
                              if (var90 == 1) {
                                 this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 0, this.eq[var3]);
                                 this.i(9, var3);
                              } else if (var90 == 2) {
                                 this.i(7, var3);
                                 this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 2, this.eq[var3]);
                              } else if (var90 == 3) {
                                 if (var95 == 12 && dQ != var3) {
                                    this.i(13, var3);
                                    this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 1, this.eq[var3]);
                                 } else if (dQ != var3 && this.dR != var3) {
                                    this.i(7, var3);
                                    this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 0, this.eq[var3]);
                                 } else {
                                    eo[var3] = (er[var3] >> 1) - 1;
                                 }
                              }
                           }
                        } else {
                           this.i(11, var3);
                        }

                        this.a(var105, var23, 0, !hy ? 2 : 0, true);
                     } else if (this.dW[var3] != 1 && this.dW[var3] != 3) {
                        if (this.eb[var3] <= 0) {
                           if (this.em[var3]) {
                              this.i(17, var3);
                           } else if (this.el[var3]) {
                              this.i(20, var3);
                           } else {
                              this.en[var3] = var16 > 0;
                              if (var90 == 1) {
                                 if (this.gi == -1 && hF != 60 && hF != 77) {
                                    this.i(2, var3);
                                 } else {
                                    this.i(7, var3);
                                 }
                              } else if (var90 == 2) {
                                 if (this.gi == -1 && hF != 60 && hF != 77) {
                                    this.i(2, var3);
                                 } else {
                                    this.i(9, var3);
                                 }
                              } else if (var90 == 3) {
                                 if (var95 == 12 && dQ != var3) {
                                    this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 1, this.eq[var3]);
                                    this.i(13, var3);
                                 } else if ((dQ == var3 || this.gi == -1) && hF != 60 && hF != 77) {
                                    this.i(4, var3);
                                 } else {
                                    this.i(8, var3);
                                 }
                              }

                              if (!fV) {
                                 this.en[var3] = dX[var3] - this.ge <= 0;
                              }
                           }
                        }

                        if ((!hf || hf && hj < 3) && !hg) {
                           hj++;
                           this.a(var105, var23, 0, !hy ? 2 : 0, true);
                        }
                     }

                     if (!hf && !hg && this.gi != -1) {
                        this.hx[var103] = 0;
                        this.hx[var103 + 1] = 0;
                        this.hx[var103 + 2] = 0;
                        this.hx[var103 + 3] = 0;
                     }

                     if (var103 == 0) {
                        this.fS = var97;
                     } else {
                        this.fT = var97;
                     }
                  }

                  if (var97 < 2 && a(this.hx[var103], this.hx[var103 + 1], this.hx[var103 + 2], this.hx[var103 + 3], eA[5], eA[6], eA[7], eA[8])) {
                     int var106 = eA[5] + (this.en[var3] ? eA[7] : 0);
                     int var107 = this.hx[var103 + 1] + (this.hx[var103 + 3] >> 1);
                     var97++;
                     int var108 = hf ? fN[this.gK] << gU : fM[this.gK] << gT;
                     if (this.C) {
                        var108 = 10000;
                     }

                     if (hf && hj < 3 || !hf && !hg) {
                        label2440: {
                           eo[var3] = eo[var3] - var108;
                           if (!hf) {
                              if (!var66) {
                                 this.y(2 + (this.M & 1));
                              }

                              if (var97 != 1) {
                                 break label2440;
                              }
                           } else if (!var66) {
                              this.y(0 + (this.M & 1));
                           }

                           gL++;
                        }

                        this.iF = true;
                        var66 = true;
                        this.gM = 2000;
                     } else if (hg) {
                        this.eb[var3] = this.eb[var3] + (fO[gZ] << 5) + this.K;
                     }

                     if (eo[var3] <= 0 && this.dW[var3] != 1) {
                        eo[var3] = -1;
                        if (this.em[var3] || this.el[var3]) {
                           this.i(11, var3);
                        } else if (eE) {
                           if (var90 == 1) {
                              this.i(8, var3);
                              this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 0, this.eq[var3]);
                           } else if (var90 == 2) {
                              this.i(7, var3);
                              this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 2, this.eq[var3]);
                           } else if (var90 == 3) {
                              if (var95 == 12 && dQ != var3 && this.dR != var3) {
                                 this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 1, this.eq[var3]);
                                 this.i(13, var3);
                              } else if (dQ != var3 && this.dR != var3) {
                                 this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 0, this.eq[var3]);
                                 this.i(7, var3);
                              } else {
                                 eo[var3] = (er[var3] >> 1) - 1;
                              }
                           }
                        }

                        this.a(var106, var107, 0, !hy ? 2 : 0, true);
                     } else if (this.dW[var3] != 1 && this.dW[var3] != 3) {
                        if (this.eb[var3] <= 0) {
                           if (this.em[var3]) {
                              this.i(17, var3);
                           } else if (this.el[var3]) {
                              this.i(20, var3);
                           } else {
                              this.en[var3] = var16 > 0;
                              if (var90 == 1) {
                                 if (this.gi == -1 && hF != 60 && hF != 77) {
                                    this.i(2, var3);
                                 } else {
                                    this.i(7, var3);
                                 }
                              } else if (var90 == 2) {
                                 if (this.gi == -1 && hF != 60 && hF != 77) {
                                    this.i(2, var3);
                                 } else {
                                    this.i(9, var3);
                                 }
                              } else if (var90 == 3) {
                                 if (this.gi == -1 && hF != 60 && hF != 77) {
                                    this.i(4, var3);
                                 } else {
                                    this.i(8, var3);
                                 }
                              }
                           }
                        }

                        if ((!hf || hf && hj < 3) && !hg) {
                           hj++;
                           this.a(var106, var107, 0, !hy ? 2 : 0, true);
                        }
                     }

                     if (!hf && this.gi != -1) {
                        this.hx[var103] = 0;
                        this.hx[var103 + 1] = 0;
                        this.hx[var103 + 2] = 0;
                        this.hx[var103 + 3] = 0;
                     }

                     if (var103 == 0) {
                        this.fS = var97;
                     } else {
                        this.fT = var97;
                     }
                  }
               }
            }

            if (eA[12] > 0 && a(this.ge - this.hB, this.gf - this.gH, gG, this.gH, eA[10], eA[11], eA[12], eA[13])) {
               byte var104 = this.ep[var3];
               if (this.dV[var3] == 6) {
                  var104 <<= 1;
               }

               if (dQ != var3) {
                  var104 <<= 1;
               }

               if (dQ != var3 && this.dV[var3] == 12) {
                  var104 <<= 2;
               }

               if (!this.hA) {
                  if (!this.eC) {
                     this.hn -= var104;
                     if (this.hn < 0) {
                        this.hn = 0;
                     }
                  }
               } else {
                  this.gm = true;
               }

               this.gj = !this.en[var3];
            }
         }

         if (this.eb[var3] > 0) {
            this.eb[var3] = this.eb[var3] - (this.K + (er[var3] >> 6));
         }
      }
   }

   private void z() {
      hg = false;
      this.hh = false;
      hf = false;
      this.fQ = 0;
   }

   private int A() {
      int var1;
      do {
         var1 = Math.abs(this.M % 5);
         this.M = N.nextInt();
      } while (this.fX == var1);

      return var1;
   }

   private void B() {
      this.aZ += 2;
      this.ba += 2;
      this.cw++;
      if (this.cw >= this.cy) {
         this.a(0, 0, 35, 35);
         H = 100;
         this.iF = true;
         this.aV = false;
         this.cy = -1;
         this.cw = -1;
         this.cx = -1;
      } else {
         this.cx = this.cw;
         this.p();
         if (!this.bd) {
            H = 101;
         } else {
            this.iN = false;
            this.bF++;
            if (this.bF > this.bG && (this.bH <= 0 || this.bF < this.bH)) {
               this.bG = this.bF;
            }

            this.bC++;
            this.bC = bD[this.bF];
            this.bJ = bE[this.bF];
            this.be = true;
            this.u = false;
            this.ad = true;
            this.a(G, G, 35, 35);
            H = 109;
            this.ad = true;
         }
      }
   }

   private void j(int var1, int var2) {
      c[] var3 = (c[])null;
      int var4 = 85 + var1;
      boolean var5;
      int var6;
      int var7;
      if (var2 == 0) {
         if (this.dU[var1] == 1) {
            var3 = this.dG;
         } else if (this.dU[var1] == 2) {
            var3 = dH;
         } else if (this.dU[var1] == 3) {
            if (dQ != var1) {
               var3 = this.dI;
            } else {
               var3 = this.dJ;
            }
         }

         var5 = this.en[var1];
         var6 = dX[var1];
         var7 = this.dY[var1];
      } else if (var2 == 1) {
         var3 = this.dl;
         var4 = 60 + var1;
         var5 = this.do[var1] != 2;
         var6 = dp[var1];
         var7 = dq[var1];
      } else {
         var3 = this.fc;
         var4 = 116 + var1;
         var5 = true;
         var6 = fh[var1];
         var7 = this.fi[var1];
      }

      int var8 = this.a(this.hQ, var4, var5 ? 0 : 2);
      if (this.hR + var8 < 1000) {
         this.hR += var8;

         for (int var9 = 0; var9 < var8; var9++) {
            int var10 = var9 << 2;
            this.iT.b(var3[this.hQ[var10]], var6 + this.hQ[var10 + 1], var7 + this.hQ[var10 + 2], this.hQ[var10 + 3]);
         }
      }
   }

   private static int u(int var0) {
      return dX[var0] / 22;
   }

   private int v(int var1) {
      int var2;
      return (var2 = this.dY[var1] / 22) > je ? je : var2;
   }

   private void d(int var1, int var2, int var3) {
      int var6 = dX[var3];
      int var7 = this.dY[var3];
      boolean var8 = this.en[var3];
      short var9 = this.ej[var3];
      int var10 = this.ei[var3] >> 1;
      int var11 = (super.a > 0 ? super.a : -super.a) << 8;
      int var12 = (super.b > 0 ? super.b : -super.b) << 8;
      int var13 = var11;
      int var14 = var12;
      if (super.a != 0) {
         var6 += (!this.en[var3] || super.a <= 0) && (this.en[var3] || super.a >= 0) ? -var10 : var10 - 1;
      }

      if (super.b < 0) {
         var7 -= var9;
         this.dY[var3] = this.dY[var3] - var9;
      } else {
         var7--;
      }

      int var15 = var1;
      int var16 = this.v(var3);
      this.es[var3] = var6 - var1 * 22 << 8;
      if (this.es[var3] < 0) {
         var15--;
         this.es[var3] = this.es[var3] + 5632;
      } else if (this.es[var3] > 5632) {
         var15++;
         this.es[var3] = this.es[var3] - 5632;
      }

      this.et[var3] = var7 - var16 * 22 << 8;
      if (super.a != 0) {
         var6 -= (!var8 || super.a <= 0) && (var8 || super.a >= 0) ? -var10 : var10 - 1;
      }

      if (super.b < 0) {
         var7 += var9;
         this.dY[var3] = this.dY[var3] + var9;
      } else {
         var7++;
      }

      eB = true;
      this.eD = true;
      if (var11 > var12) {
         if (var11 > 5632) {
            var12 = (var12 * 22 << 8) / var11;
            var11 = 5632;
         }
      } else if (var12 > 5632) {
         var11 = (var11 * 22 << 8) / var12;
         var12 = 5632;
      }

      int var4;
      if ((!var8 || super.a <= 0) && (var8 || super.a >= 0)) {
         var4 = -var11;
      } else {
         var4 = var11;
      }

      int var5 = super.b > 0 ? var12 : -var12;
      int var17 = 0;
      int var18 = 0;
      this.hM = 0;
      this.hN = 0;
      if (super.a != 0 && !this.el[var3] && this.dW[var3] != 1) {
         this.e(this.ed[var3], this.ee[var3] - 1 - (super.b < 0 ? this.ek[var3] : 0), var3);
      }

      while (var17 < var13 || var18 < var14) {
         this.es[var3] = this.es[var3] + var4;
         this.et[var3] = this.et[var3] + var5;
         if (this.es[var3] >= 5632) {
            this.es[var3] = this.es[var3] - 5632;
            var15++;
         } else if (this.es[var3] < 0) {
            this.es[var3] = this.es[var3] + 5632;
            var15--;
         }

         if (this.et[var3] >= 5632) {
            this.et[var3] = this.et[var3] - 5632;
            var16++;
         } else if (this.et[var3] < 0) {
            this.et[var3] = this.et[var3] + 5632;
            var16--;
         }

         this.hJ = false;
         this.e(var15, var16, var3);
         if (eB) {
            this.hM += var4;
            var17 += var11;
         } else {
            this.es[var3] = this.es[var3] - var4;
            var13 = var17;
            if ((this.h(var1, var2) & 1) != 0 && !this.hJ) {
               this.hM = 0;
               this.hJ = true;
               if ((!this.en[var3] || super.a <= 0) && (this.en[var3] || super.a >= 0)) {
                  dX[var3] = var1 * 22 + (this.ei[var3] >> 1);
               } else {
                  dX[var3] = (var1 + 1) * 22 - (this.ei[var3] >> 1);
               }
            }
         }

         if (this.eD) {
            this.hN += var5;
            var18 += var12;
         } else {
            this.et[var3] = this.et[var3] - var5;
            var14 = var18;
         }
      }

      var6 += this.hM >> 8;
      var7 += this.hN >> 8;
      if (var17 > var13) {
         int var19 = var17 - var13 >> 8;
         var6 -= var4 > 0 ? var19 : -var19;
      }

      if (var18 > var14) {
         int var24 = var18 - var14 >> 8;
         var7 -= var5 > 0 ? var24 : -var24;
      }

      if (eB && !this.hJ) {
         dX[var3] = var6;
      }

      if (this.eD) {
         this.ee[var3] = var7 / 22;
         this.dY[var3] = var7;
      }

      this.b(this.ed[var3], this.ee[var3] - 1, 2);
   }

   private void C() {
      this.eC = false;
      this.iq = 0;
      this.ip = 0;
      this.bd = false;
      this.aZ = 0;
      this.dS = 0;
      this.ba = 0;
      this.aX = new int[40];
      this.aY = new int[40];
      this.ar = false;
      this.hS = -1;
      this.ax = -1;
      this.az = 0;
      this.ay = -1;
      this.eF = 0;
      fb = -1;
      this.dD = -1;
      dQ = -1;
      this.dR = -1;
      fb = -1;
      this.dt = -1;
      this.bQ = -1;
      ca = -1;
      co = -1;
      this.cB = -1;
      cM = -1;
      this.fd = -1;
      this.fq = -1;
      this.fK = -1;
      ch = -1;
      this.fc = null;
      cA = null;
      this.cN = null;
      this.eL = null;
      this.cb = null;
      this.ci = null;
      this.dG = null;
      dH = null;
      this.dI = null;
      this.dJ = null;
      this.bR = null;
      this.dl = null;
      this.fp = null;
      this.du = null;
      this.eQ = null;
      this.fL = null;
      this.aV = false;
      this.aC = -1;
      this.i();
      this.iT = null;
      this.iU = null;
   }

   private void e(int var1, int var2, int var3) {
      short var4 = this.ej[var3];
      boolean var5;
      boolean var6 = (var5 = this.en[var3]) && super.a > 0 || !var5 && super.a < 0;
      int var7 = 0;
      boolean var8 = false;
      this.hI = false;
      this.hJ = false;

      for (short var9 = var4; var9 > 0 && eB; var9 -= 22) {
         if (var2 < je) {
            if (var2 - var7 < 0 || var2 - var7 >= je) {
               break;
            }

            if (var9 > 0) {
               if (eB && var1 >= 0) {
                  eB = (this.h(var1, var2 - var7) & 1) == 0;
                  if (var7 == 0) {
                     var8 = !eB && (this.h(var1, var2 - var7 - 1) & 1) == 0;
                  }

                  boolean var10 = eB;
                  if (this.dU[var3] == 1 && this.dV[var3] == 1 || this.dU[var3] == 2 && this.dV[var3] == 1 || this.dU[var3] == 3 && this.dV[var3] == 1) {
                     eB = eB & ((this.h(var1, var2 - var7) & 2) == 0 || !eE || this.el[var3] || var1 == this.ed[var3]);
                  }

                  if (var10 != eB) {
                     ey[var3] = 1500;
                  }
               }

               if (!eB) {
                  this.hJ = true;
                  if (var8 && super.a > 0 && (this.en[var3] || super.a < 0 && !this.en[var3]) && super.b == 0 && (this.h(var1, var2 - var7 - 1) & 1) == 0) {
                     switch (this.dU[var3]) {
                        case 1:
                           this.i(3, var3);
                        case 2:
                        case 3:
                     }
                  }
                  break;
               }
            }

            if (var1 < 0 || var1 >= jd) {
               eB = false;
               var5 = !var5;
            }

            if (super.b >= 0) {
               var7++;
            } else {
               var7--;
            }

            if (this.dU[var3] == 1 && this.el[var3] && this.dV[var3] != 26 && var9 - 22 < 0 && (this.h(var1, var2 - var7) & 16) == 0) {
               eB = false;
               this.i(26, var3);
               this.dY[var3]++;
               break;
            }
         }
      }

      if (eB && this.dV[var3] == 1 || this.dV[var3] == 0) {
         eB = (this.h(var1, var2 + 1) & 1) == 1;
      }

      int var27 = var1;
      if (super.a == 0 && super.b != 0) {
         var27 += var5 ? 1 : -1;
      }

      if (super.b >= 0) {
         var7 = this.ek[var3];
         if (this.et[var3] < 2816) {
            var7++;
         }
      } else {
         var7 = 0;
      }

      int var28 = var2 - var7;
      int var11 = var5 ? -1 : 1;
      if (this.dU[var3] == 1
         && (this.h(var27, var28 - 1) & 1) == 0
         && ((this.h(var27, var28) & 1) != 0 || this.eu[var3])
         && (this.h(var27 + var11, var28) & 1) == 0
         && (this.h(var27 + var11, var28 - 1) & 1) == 0
         && (this.h(var27 + var11, var28 + this.ek[var3]) & 1) == 0
         && super.b != 0
         && (!this.em[var3] || this.eu[var3])
         && !eE
         && this.dV[var3] != 21
         && this.dV[var3] != 11) {
         if (this.eu[var3] && super.b < 0) {
            this.i(21, var3);
            int var29 = 0;
            if ((this.h(var27, var2) & 1) == 0) {
               var29++;
            }

            this.dY[var3] = (var2 + var29) * 22 + var4;
         }

         this.hN = 0;
         if (!var5) {
            var27++;
         }

         this.hJ = true;
         dX[var3] = var27 * 22 + (var5 ? -(this.ei[var3] >> 1) : this.ei[var3] >> 1);
         this.hM = 0;
         this.eD = false;
         eB = false;
      } else {
         if (!eB && super.a != 0) {
            var7 = var6 ? -1 : 1;
         } else {
            var7 = 0;
         }

         int var12 = var2;
         int var13;
         if ((var13 = super.b > 0 ? var12 - this.ek[var3] : var12 + this.ek[var3]) < 0) {
            var13 = 0;
         }

         if (super.b != 0) {
            for (short var14 = this.ei[var3]; var14 > 0; var14 -= 22) {
               if (var1 + var7 >= 0 && var1 + var7 < jd) {
                  if (this.eD) {
                     this.eD = (this.h(var1 + var7, var12) & 1) == 0;
                     if (this.dU[var3] == 1 && !this.dE && eo[var3] > 0 && (this.h(var1 + var7, var13) & 16) != 0) {
                        this.dY[var3] = (var13 + 1) * 22 + var4;
                        this.eD = false;
                        this.hN = 0;
                        this.i(26, var3);
                     }
                  }

                  if (!this.eD && super.b > 0 && !this.el[var3] && this.dV[var3] != 21) {
                     this.dY[var3] = var2 * 22;
                     this.hN = 0;
                     this.hI = true;
                     eE = true;
                     switch (this.dU[var3]) {
                        case 1:
                           if (eo[var3] < 0) {
                              this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 0, this.eq[var3]);
                              this.i(8, var3);
                           } else {
                              if (this.dV[var3] == 25) {
                                 break;
                              }

                              if (this.dV[var3] != 3 && this.dV[var3] != 27) {
                                 this.i(7, var3);
                                 break;
                              }

                              this.i(25, var3);
                           }
                           break;
                        case 2:
                           if (eo[var3] < 0) {
                              this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 2, this.eq[var3]);
                              this.i(7, var3);
                           } else if (this.dV[var3] != 14) {
                              this.i(9, var3);
                           }
                           break;
                        case 3:
                           this.au += 6;
                           if (eE) {
                              eB = true;
                           }

                           if (this.dV[var3] != 6 && dQ != var3) {
                              if (eo[var3] < 0) {
                                 this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 0, this.eq[var3]);
                                 this.i(7, var3);
                              } else if (this.dV[var3] != 18) {
                                 this.i(8, var3);
                              }
                           } else if (dQ != var3) {
                              if (this.gC && this.gi < 0 && this.dK < 88 && hF != 52 && hF != 53 && hF != 48) {
                                 this.s(27);
                              }
                           } else if (eo[var3] < 0) {
                              this.i(7, var3);
                              this.b(dX[var3], this.dY[var3] - (this.ej[var3] >> 1), 0, this.eq[var3]);
                           } else {
                              dX[var3]++;
                           }
                     }
                  }

                  if (!this.eD) {
                     break;
                  }

                  if (var12 < 0 || var12 >= je) {
                     this.eD = false;
                  }

                  if (super.a == 0) {
                     break;
                  }
               }

               var7 = var6 ? --var7 : ++var7;
            }
         }

         if (this.em[var3] && this.dV[var3] != 21) {
            int var30 = var1;
            var1 += var5 ? 1 : -1;
            if ((this.h(var1, var12) & 8) == 0) {
               this.eD = false;
               this.dY[var3] = (var12 + (super.b < 0 ? 1 : -this.ek[var3] - 1)) * 22 + var4;
               this.eu[var3] = true;
            }

            var1 = var30;
         } else {
            this.eu[var3] = false;
         }

         if (!eB && super.a != 0 && !this.hI && !this.em[var3]) {
            if ((!var5 || super.a <= 0) && (var5 || super.a >= 0)) {
               this.hJ = true;
               int var32;
               int var33 = (var32 = (var1 + 1) * 22 + (this.ei[var3] >> 1) + 1) + (this.ei[var3] >> 1);
               int var34 = var32 / 22;
               int var35 = var33 / 22;
               int var36 = var34 < var35 ? 1 : -1;
               boolean var37 = true;
               int var38 = Math.abs(var35 - var34);

               for (int var39 = 0; var39 <= var38; var39++) {
                  var37 &= (this.h(var34 + var39 * var36, var2) & 1) == 0;
               }

               if (var37) {
                  dX[var3] = var32;
               }

               if (this.dU[var3] == 1
                  && eo[var3] > 0
                  && !this.dE
                  && (this.h(var1, var12 + (super.b > 0 ? -1 : 1)) & 8) != 0
                  && (this.h(var1, var12 + (super.b > 0 ? -this.ek[var3] : this.ek[var3])) & 8) != 0
                  && super.b != 0) {
                  this.i(23, var3);
               }
            } else {
               this.hJ = true;
               int var31;
               int var15 = (var31 = var1 * 22 - (this.ei[var3] >> 1) - 1) - (this.ei[var3] >> 1);
               int var16 = var31 / 22;
               int var17 = var15 / 22;
               int var18 = var16 < var17 ? 1 : -1;
               boolean var19 = true;
               int var20 = Math.abs(var17 - var16);

               for (int var21 = 0; var21 <= var20; var21++) {
                  var19 &= (this.h(var16 + var21 * var18, var2) & 1) == 0;
               }

               if (var19) {
                  dX[var3] = var31;
               }

               if (this.dU[var3] == 1
                  && eo[var3] > 0
                  && !this.dE
                  && (this.h(var1, var12 + (super.b > 0 ? -1 : 1)) & 8) != 0
                  && (this.h(var1, var12 + (super.b > 0 ? -this.ek[var3] : this.ek[var3])) & 8) != 0
                  && super.b != 0) {
                  this.i(23, var3);
               }
            }

            this.hM = 0;
         }
      }
   }

   private void w(int var1) {
      int var2 = dZ[var1] / 22;
      int var3 = ea[var1] / 22;
      if ((this.h(var2, var3) & 32) > 0) {
         int var4 = -1;

         for (int var5 = 0; var5 < this.de.length; var5++) {
            if (a(var2, var3, this.de[var5], this.df[var5], this.dg[var5], dh[var5])) {
               var4 = var5;
            }
         }

         if (var4 != -1) {
            dj[var4]++;
            if (dj[var4] >= this.dk[var4]) {
               this.dk[var4] = -1;
               dj[var4] = -1000000;

               for (int var6 = cM; var6 >= 0; var6--) {
                  if (this.cW[var6] == this.di[var4]) {
                     cZ[var6] = !cZ[var6];
                     if (this.da[var6]) {
                        this.iF = true;
                        this.ax = cQ[var6];
                        this.ay = this.cR[var6];
                     }
                  }
               }
            }
         }
      }
   }

   private void x(int var1) {
      for (int var2 = var1 << 2; var2 < (var1 << 2) + 4; var2++) {
         if (this.cL[var2] != 0) {
            for (int var3 = cM; var3 >= 0; var3--) {
               if (this.cW[var3] == this.cL[var2]) {
                  cZ[var3] = !cZ[var3];
                  if (this.da[var3]) {
                     this.ax = cQ[var3];
                     this.ay = this.cR[var3];
                     this.iF = true;
                  }
               }
            }
         }
      }
   }

   private void a(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = var3;
      if (var5) {
         int var7 = this.gK - 1;
         if (!hf && hF == 60) {
            var7 = 6;
         }

         byte var8;
         if (this.gt) {
            if (hf) {
               var8 = 17;
            } else {
               var8 = 8;
            }
         } else if (hf) {
            var8 = 11;
         } else {
            var8 = 1;
         }

         var6 = var8 + var7;
      }

      if (this.bQ < 9 && (var3 != 0 || this.bQ < 9)) {
         this.bQ++;
         if (bM[this.bQ] < 0) {
            this.bP[this.bQ] = var4;
            this.bN[this.bQ] = var1;
            this.bO[this.bQ] = var2;
            bM[this.bQ] = this.bQ;
            this.a(this.bQ, 7168, var6);
         }
      }
   }

   private void a(int[] var1, byte[] var2) {
      this.hU = 220;
      this.a(this.o);
      this.a(var1, var2, 17, 42, 200, 250, this.hU);
   }

   private void D() {
      this.L = this.L + this.K;
      if (this.L >= 50) {
         this.L = 0;
         if (this.r == 1) {
            this.e(true);
            this.h();
         }

         if (this.r == 6) {
            this.e(false);
            this.h();
         }
      }
   }

   private static boolean a(int var0, int var1, int var2, int var3, int var4, int var5) {
      return var0 > var2 && var0 < var2 + var4 && var1 > var3 && var1 < var3 + var5;
   }

   private static boolean a(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return var2 != 0 && var6 != 0 ? var0 + var2 > var4 && var4 + var6 > var0 && var1 + var3 > var5 && var5 + var7 > var1 : false;
   }

   private void y(int var1) {
      if (!this.hV) {
         this.iR.a(var1);
         if (var1 == 9 && iQ) {
            this.hV = true;
         }
      }
   }

   private void E() {
      this.hV = false;
      this.iR.c();
   }

   private void u(Graphics var1) {
      this.v(var1);
      if (!iZ) {
         this.iY[1].a(var1, 120, G, 0);
         this.iY[0].a(var1, 120, G, 0);
      } else {
         this.a(var1, this.iY, 0, 120, G, 0);
      }
   }

   private void v(Graphics var1) {
      this.b(var1);
      this.iF = true;
      var1.setColor(0);
      this.iG = false;
      var1.fillRect(0, 0, 240, 320);
   }

   private void a(int[] var1, byte[] var2, int var3, int var4, int var5, int var6, int var7) {
      ia = new String[var7];
      ic = new byte[var7];
      hW = var3;
      hX = var4;
      hY = var5;
      hZ = var6;
      if = var1[0];
      int var9 = 0;
      this.h();
      int var10 = 0;
      String var11 = "";
      this.im = 0;

      for (int var8 = 0; var8 < var1.length; var8++) {
         byte var12 = var2[var8];
         int var14;
         if ((var14 = var1[var8]) >= 0) {
            var11 = this.e(var1[var8]);
         } else if (var14 == -1) {
            ia[var10] = "";
            ic[var10++] = var12;
            var11 = "";
         } else if (var14 == -3) {
            var11 = ib[var9++];
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
            if (this.cv >= 0 && var10 % 5 * y < this.ct[0].d << 1) {
               var17 = var5 - (this.ct[0].c + 8);
            } else {
               var17 = var5 - 1 - 5;
            }

            while (var18 <= var17 && var16 < var13) {
               char var20;
               if ((var20 = var11.charAt(var16)) == '\n') {
                  var19 = true;
                  break;
               }

               var18 += this.a(var20);
               var16++;
            }

            if (var8 == 0 && if != -1) {
               this.in = 0;
               this.io = var16;
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

            ia[var10] = var11.substring(var15, var21 + 1).trim();
            ic[var10++] = var12;
            this.im = this.im + y;
            var16 = var15 = var21 + 1;
         }
      }

      id = var10;
      ie = 0;
      this.ip = 0;
      ig = false;
      this.j();
   }

   private static void F() {
      ia = null;
      ic = null;
      ib = null;
   }

   private void e(boolean var1) {
      if (var1) {
         if (ie > 0) {
            ie--;
            this.h();
            return;
         }
      } else if (ie < id && !ig) {
         ie++;
         this.h();
      }
   }

   private void a(Graphics var1, boolean var2) {
      this.a(var1, 0, hX, 240, hZ);
      byte var4 = 0;
      this.it = true;
      if (hZ / y >= id) {
         var4 = 3;
      }

      int var6 = hX;
      if (this.aV) {
         var6 = 285 - (this.ir >> 8);
      } else if (H == 79) {
         var6 += 35;
      }

      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      if (H == 101) {
         var6 -= this.c() >> 1;
      }

      this.is = 0;

      int var3;
      for (var3 = this.ip > 0 ? this.ip : ie; var3 < id && var6 < hX + hZ; var3++) {
         var11 = var3;
         if (var9 < 1) {
            var11 = var9;
         }

         byte var8;
         int var12 = ((var8 = ic[var11]) & 2) != 0 ? 4 : 1;
         int var7 = hW + var4 + ((var8 & 2) != 0 ? 0 : hY - 5 >> 1) + 1;
         if (this.cv >= 0 && var6 - y - hX < this.ct[0].d) {
            var7 += this.ct[0].c + 8;
         }

         String var13 = ia[var11];
         if (H == 101 && !var13.equals("")) {
            if (var13.length() > this.bc - this.is) {
               var13 = var13.substring(0, this.bc - this.is);
               this.is = this.is + var13.length();
               this.it = false;
            } else {
               this.is = this.is + var13.length();
            }
         }

         if (var3 != ie || if == -1) {
            this.a(this.o);
         } else if (this.m != null) {
            this.a(this.n);
         } else {
            this.a(this.o);
         }

         this.h();
         this.a(var1, var3 == ie && if != -1 ? var13.substring(this.in, this.io) : var13, var7, var6, var12);
         var6 += y;
         if (H == 101 && var6 >= hZ && var11 < id) {
            this.iq = var11;
            if (ia[var11].equals("") || this.iq + 1 == id) {
               this.iq = -1;
            }
            break;
         }

         this.iq = -1;
         if (var9++ < 2) {
            var10 = var6;
         }
      }

      ig = var3 == id;
      this.b(var1);
      this.iF = true;
      if (var4 == 0 && var2 && !this.aV) {
         var1.setColor(10377532);
         int var16 = hZ - (var10 - 35) - 4;
         var1.drawRect(hW + hY + 10 - 1, var10 - 4, 5, var16);
         int var18 = var10 + ie * var16 / id - 3;
         int var14 = var10 + var3 * var16 / id - 3;
         var1.setColor(15425792);
         var1.fillRect(hW + hY + 10, var18, 4, var14 - var18 - 1);
      }

      if (this.cv >= 0) {
         if (this.cv > 3) {
            int var17 = this.cv - 3 - 1 + 38;
            byte var19 = 0;
            byte var20 = 0;
            if (var17 == 41) {
               var19 = -3;
            }

            if (var17 == 39) {
               var20 = -3;
            }

            int var15;
            if ((var15 = var17 + (bi > 0 ? 4 - bi : 0)) > 41) {
               var15 = 38 + (var15 - 41) - 1;
            }

            aK[89].a(var1, hW + (this.ct[this.cv].c >> 3) - aK[89].a, hX + y - aK[89].b, 0);
            aK[var15].a(var1, 19 - aK[var15].a + var19, 19 - aK[var15].b + var20, 0);
         } else {
            this.ct[this.cv].a(var1, hW + (this.ct[this.cv].c >> 3), hX + y, 0);
         }

         this.a(136, 1024, 0);
         this.a(var1, this.ct, 136, hW + (this.ct[this.cv].c >> 3), hX + y, 0);
      }

      if ((var11 < id - 1 || this.cw < this.cy - 1) && H == 101) {
         bq[1].a(var1, F, 95 - bq[1].d - 2, 0);
      }
   }

   private void z(int var1) {
      iu = new byte[76];
      int var2 = 0;
      var2 = a(gT, iu, 0);
      var2 = a(gU, iu, var2);
      var2 = a(gR, iu, var2);
      var2 = a(this.gS, iu, var2);
      var2 = a(gZ, iu, var2);
      var2 = a(ha, iu, var2);
      var2 = a(this.hs, iu, var2);
      var2 = a(this.ht, iu, var2);
      var2 = a(this.hu, iu, var2);
      var2 = a(this.hd, iu, var2);
      var2 = a(this.he, iu, var2);
      var2 = a(this.hb, iu, var2);
      var2 = a(this.hc, iu, var2);
      var2 = a(this.bG, iu, var2);
      var2 = a(hv, iu, var2);
      var2 = a(this.hw, iu, var2);
      var2 = a(hi, iu, var2);
      if (this.dM > this.hD && iS) {
         this.hD = this.dM;
      }

      a(this.hD, iu, var2);
      this.G();
      a.a(var1 + 1, iu);
      this.G();
   }

   private void A(int var1) {
      iu = a.a(var1 + 1);
      if (iu == null) {
         gR = 3;
         this.gS = 2;
         gZ = 0;
         ha = 0;
         this.hs = 0;
         this.ht = 0;
         this.hq = 1024;
         this.hr = 1024;
         this.hu = 0;
         this.hd = 0;
         this.he = 0;
         this.hb = 0;
         this.hc = 0;
         gT = 0;
         gU = 0;
         this.bF = 0;
         this.bG = 0;
         hv = 0;
         this.hw = 0;
         hi = 0;
         this.hD = 0;
      } else {
         gT = (byte)a(iu, 0);
         gU = (byte)a(iu, 4);
         gR = (byte)a(iu, 8);
         this.gS = (byte)a(iu, 12);
         if (gR < 3) {
            gR = 3;
         }

         if (this.gS < 2) {
            this.gS = 2;
         }

         gZ = (byte)a(iu, 16);
         ha = (byte)a(iu, 20);
         this.hs = a(iu, 24);
         this.ht = a(iu, 28);
         this.hq = this.hs * 192 + 1024;
         this.hr = this.ht * 192 + 1024;
         this.hu = a(iu, 32);
         this.hd = a(iu, 36);
         this.he = a(iu, 40);
         this.hb = a(iu, 44);
         this.hc = a(iu, 48);
         this.bG = a(iu, 52);
         this.bF = this.bG;
         hv = a(iu, 56);
         this.hw = a(iu, 60);
         hi = a(iu, 64);
         this.hD = a(iu, 68);
      }

      this.G();
   }

   private void G() {
      for (int var1 = 0; var1 < 10; var1++) {
         if (var1 <= this.bG) {
            iA[9 + var1] = iA[9 + var1] = iA[9 + var1] | 50331648;
         } else {
            iA[9 + var1] = iA[9 + var1] & -50331649;
         }
      }
   }

   private static int a(int var0, byte[] var1, int var2) {
      var1[var2++] = (byte)(var0 >> 24 & 0xFF);
      var1[var2++] = (byte)(var0 >> 16 & 0xFF);
      var1[var2++] = (byte)(var0 >> 8 & 0xFF);
      var1[var2++] = (byte)(var0 & 0xFF);
      return var2;
   }

   private static int a(byte[] var0, int var1) {
      return ((var0[0 + var1] & 0xFF) << 24) + ((var0[1 + var1] & 0xFF) << 16) + ((var0[2 + var1] & 0xFF) << 8) + (var0[3 + var1] & 0xFF);
   }

   private void H() {
      int var2 = 240 - (this.iy - (this.iy >> 2));
      if (iv == null) {
         iv = new byte[var2 * 140];
         iw = new int[var2 * 140];
      }

      int var3 = 0;
      if (ix) {
         for (int var4 = 0; var4 < var2; var4++) {
            if ((var4 & 3) == 0) {
               var3 = N.nextInt();
            } else {
               var3 >>= 8;
            }

            iv[var4 + 139 * var2] = (byte)(var3 & 0xFF);
            iv[var4 + 138 * var2] = (byte)Math.max(0, (iv[var4 + 139 * var2] & 255) - 4);
            ix = false;
         }
      } else {
         ix = true;
      }

      for (int var5 = 1; var5 < 139; var5++) {
         int var1 = var5 * var2;

         for (int var6 = 0; var6 < var2; var6++) {
            int var9 = var6 + var1;
            int var7 = (iv[var9] & 255) + (iv[var9 + var2] & 255);
            if (var5 > 35) {
               var7 = var7 + (iv[var9 + 1] & 255) + (iv[var9 - 1] & 255) >> 2;
            } else {
               var7 >>= 1;
            }

            if (--var7 < 0) {
               var7 = 0;
            }

            iv[var9 - var2] = (byte)var7;
         }
      }

      int var10 = 0;

      for (int var14 = 0; var14 < 140; var14++) {
         for (int var8 = 0; var8 < var2; var8++) {
            int var11 = Math.max(iv[var10] & 255, 0);
            iw[var10] = Q[var11];
            var10++;
         }
      }
   }

   private void b(Graphics var1, boolean var2) {
      this.H();
      int var3 = var2 ? 0 : 95;
      int var4 = var2 ? 168 : 173;
      a.a(var1, iw, 0, 240 - (this.iy - (this.iy >> 2)), var3, var4, 240 - (this.iy - (this.iy >> 2) + 1), 140, false);
   }

   private void a(Graphics var1, int var2, int var3) {
      this.iE = var3;
      this.iD = var2;
      this.a(this.o);
      var1.setColor(0);
      var1.fillRect(0, 306, 240, 14);
      var1.setColor(9787452);
      var1.drawLine(0, 306, 240, 306);
      var1.setColor(4269078);
      var1.drawLine(0, 307, 240, 307);
      if ((this.S == this.Z && this.T == this.aa || H == 106) && this.ax < 0 && (!fV || H == 102)) {
         if (var2 != -1) {
            this.a(var1, 0, var2, 2);
         }

         if (var3 != -1) {
            this.a(var1, 240, var3, 0);
         }

         if (H == 100) {
            if (!iS) {
               if (this.gN == -1 || this.dk[this.gN] <= 0 && this.gO <= 0) {
                  if (gL > 1 && this.gM > 0 && H == 100 && this.T <= 0 && this.iz < gL) {
                     this.a(var1, gL + " " + this.e(171), 120, 306 + z - 6, 1);
                  }
               } else {
                  String var4 = this.dk[this.gN] - dj[this.gN] + " " + this.e(195);
                  int var5 = this.a(var4);
                  if (gQ && this.dk[this.gN] > 0) {
                     this.a(var1, var4, F, 306 + z - 6, 1);
                  }

                  if (this.gN >= 0 && this.dk[this.gN] > 0) {
                     int var6 = F - (var5 >> 1) - 7;
                     int var7 = F + (var5 >> 1) + 7;
                     var1.setColor(13868629);
                     var1.drawLine(var6 - 8, 307, var6 - 8, 320);
                     var1.drawLine(var7 + 8, 307, var7 + 8, 320);
                     var1.setColor(14116120);
                     var1.drawLine(var6 - 7, 307, var6 - 7, 320);
                     var1.drawLine(var7 + 7, 307, var7 + 7, 320);
                     var1.setColor(14114838);
                     var1.drawLine(var6 - 6, 307, var6 - 6, 320);
                     var1.drawLine(var7 + 6, 307, var7 + 6, 320);
                     var1.setColor(14111501);
                     var1.drawLine(var6 - 5, 307, var6 - 5, 320);
                     var1.drawLine(var7 + 5, 307, var7 + 5, 320);
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
            } else if (this.dM >= 1000) {
               this.a(var1, this.e(275), 120, 306 + z - 6, 1);
            } else {
               this.a(var1, this.e(246) + this.dM, 120, 306 + z - 6, 1);
            }
         } else {
            this.iF = true;
         }
      }

      this.iF = false;
   }

   private void a(Graphics var1, int var2, int var3, int var4) {
      String var5 = this.e(var3);
      this.a(var1, var5, var2 - (var4 == 0 ? this.a(var5) + 3 : -3), 306 + z - 6, 20);
   }

   private static void a(Graphics var0, int var1, int var2, boolean var3) {
      if (H != 1) {
         var2 -= 2;
         var1 -= 2;
      }

      int var4 = 302;
      if (H == 1) {
         var4 = G + 5 + (y >> 2);
         if (iS) {
            var4 += y + (y >> 2);
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

   private void I() {
      byte[] var1;
      int var2;
      iA = new int[var2 = (var1 = this.c(1028)).length >> 2];

      for (int var3 = var2 - 1; var3 >= 0; var3--) {
         int var4 = var3 << 2;
         iA[var3] = ((var1[var4] & 255) << 24) + ((var1[var4 + 1] & 255) << 16) + ((var1[var4 + 2] & 255) << 8) + (var1[var4 + 3] & 255);
      }
   }

   private static int k(int var0, int var1) {
      int var2 = var0;

      while (var0 < iA.length && (iA[var0] & 4194304) == 0) {
         if ((iA[++var0] & var1) != 0) {
            return var0;
         }

         if ((iA[var0] & 4194304) != 0) {
            return var2;
         }
      }

      return var2;
   }

   private static int l(int var0, int var1) {
      int var2 = var0;

      do {
         if ((iA[var0] & 8388608) == 0) {
            if ((iA[--var0] & var1) != 0) {
               var2 = var0;
            }
         }

         if ((iA[var0] & 8388608) != 0 && (iA[var0] & var1) == 0) {
            return var2;
         }
      } while ((iA[var0] & var1) == 0);

      return var2;
   }

   private void J() {
      int var1 = iB;
      int var2;
      int var3 = (var2 = iA[iB]) >> 26;
      int var4 = var2 >> 8 & 0xFF;
      switch (var3) {
         case 0:
            if (this.q == 8 || this.q == 27) {
               if (var4 == 9 && this.bF == 0) {
                  iS = false;
                  this.bF = 0;
                  this.bC = 9217;
                  this.bJ = 9219;
                  this.a(G, G, 35, 35);
                  H = 1;
                  this.C();
                  this.iR.c();
                  this.u = false;
                  this.V = true;
               } else {
                  var1 = var4;
               }
            }
            break;
         case 1:
            if (this.q == 8 || this.q == 27) {
               this.iR.a(!this.iR.b());
               iQ = this.iR.b();
               if (!this.iR.b()) {
                  this.hV = false;
               }

               this.y(9);
            }
         case 2:
         case 7:
         default:
            break;
         case 3:
            if (this.q == 8 || this.q == 27) {
               this.ah = false;
               this.ai = true;
               this.a(G, G, 35, 35);
            }
            break;
         case 4:
            if (this.q == 8 || this.q == 27) {
               this.ah = true;
               this.ai = true;
               this.a(G, G, 35, 35);
            }
            break;
         case 5:
            if (this.q == 8 || this.q == 27) {
               this.bF = iB - this.iL;
               this.be = false;
               this.bC = bD[this.bF];
               iS = false;
               this.bJ = bE[this.bF];
               this.a(G, G, 35, 35);
               H = 1;
               this.u = false;
               this.C();
               this.E();
            }
            break;
         case 6:
            if (this.q == 8 || this.q == 27) {
               this.bC = 9216;
               this.bF = 0;
               this.dM = 0;
               iS = true;
               this.bJ = 9218;
               this.a(G, G, 35, 35);
               H = 1;
               this.u = false;
               this.C();
               this.E();
            }
            break;
         case 8:
            if (this.q == 8 || this.q == 27) {
               this.L();
            }
            break;
         case 9:
            if (this.q == 8 || this.q == 27) {
               this.b(false);
               H = this.I;
            }
            break;
         case 10:
            if (this.q == 8 || this.q == 27) {
               this.C();
               this.y(9);
               this.a((DataInputStream)null);
               this.z(1);
               this.iC = iB;
               var1 = var4;
            }
            break;
         case 11:
            if (this.q == 8 || this.q == 27 || this.q == 29) {
               if (this.q != 29) {
                  if (this.iH) {
                     iP = true;
                     this.b(this.s);
                     this.L();
                  } else {
                     byte[] var5 = new byte[76];
                     a.a(2, var5);
                     this.A(1);
                  }
               }

               var1 = var4;
               if (this.iH) {
                  var1 = 0;
                  this.iH = false;
               }
            }
            break;
         case 12:
            if (this.q == 8 || this.q == 27) {
               v++;
               if (v > 5) {
                  v = 0;
               }

               this.f(w[v]);
               this.iF = true;
            }
      }

      if (this.q != 0) {
         this.iN = false;
         this.iG = true;
      }

      if (this.q == 2) {
         var1 = l(var1, 33554432);
      }

      if (this.q == 5) {
         var1 = k(var1, 33554432);
      }

      if (this.bd) {
         this.iN = false;
         iB++;
         this.bF++;
         if (this.bF > this.bG) {
            this.bG = this.bF;
         }

         this.bC++;
         this.bJ = bE[this.bF];
         H = 1;
         this.ad = true;
         this.u = false;
         this.E();
      }

      if (this.q == 29 && var3 != 11) {
         if (this.iE == 2 || this.iE == 29) {
            var1 = this.iC;
            this.iN = false;
         } else if (this.iE == 1) {
            var1 = 23;
         }
      } else if (this.q == 27 && var3 == 0 && this.iD == 0 && (var4 != 9 || this.bF != 0)) {
         var1 = var4;
         this.iN = false;
      }

      if (iB != var1) {
         iB = var1;
         if ((iA[iB] & 33554432) == 0) {
            iB = k(var1, 33554432);
         }

         this.h();
      }
   }

   private void K() {
      if (this.q == 8 || this.q == 27) {
         int var1 = iA[iB];
         this.iG = true;
         switch (var1 & 0xFF) {
            case 5:
               this.iH = true;
         }
      }
   }

   private void L() {
      if (H != 0 && H != 79 && !iP) {
         this.z(1);
      }

      this.j(3);
   }

   private void w(Graphics var1) {
      int var2 = 0;
      int var3 = 0;
      if (this.D > this.E) {
         var2 = -(this.D >> 3);
      }

      if (this.iG || (this.S > 0 || this.aj) && this.iN && H != 1) {
         this.v(var1);
      }

      this.a(this.n);
      this.a(var1, this.e(274), F + var2, this.p[0].d + this.p[1].d, 1);
      this.a(this.m);
      int var4 = iB;
      int var6 = 0;

      while (var4 == 1 || var4 > 1 && (iA[var4] & 8388608) == 0) {
         if ((iA[--var4] & 16777216) != 0) {
            var6++;
         }
      }

      int var7 = var4;
      var4 = iB;

      for (int var8 = 0; var8 < var6; var8++) {
         var4 = l(var4, 16777216);
      }

      this.iL = var4;

      for (int var18 = 0; var18 < var6; var18++) {
         var4 = l(var4, 33554432);
      }

      this.iM = var4;
      this.iI = 0;
      int var10 = var4;
      int var11 = var4;
      if (this.iN && this.S <= 0 && !this.aj) {
         this.a(var1, 0, 166, 240, 140);
      } else {
         this.b(var1);
      }

      this.b(var1, true);

      for (int var13 = this.iN && this.S <= 0 && !this.aj ? 2 : 0; var13 <= 4; var13++) {
         this.p[var13].a(var1, var13 < 2 ? F + var2 : this.D + 0, var13 < 2 ? 0 : this.E, 0);
      }

      if (this.aj) {
         this.aj = false;
      }

      this.iN = true;
      this.iK = this.p[0].d + this.p[1].d + (y << 1);
      if (-this.p[2].b + this.iK >= this.E && var2 == 0) {
         var3 = -(this.D >> 3);
      }

      while (true) {
         if ((iA[var11] & 16777216) != 0) {
            var10 = var11;
         }

         if ((iA[var11] & 33554432) != 0) {
            var7 = var11;
         }

         if ((iA[var11] & 4194304) != 0) {
            this.iI = this.D < this.iI ? this.D : this.iI;
            this.iJ = 120;
            var1.setColor(0, 0, 255);
            var4 = this.iL;
            this.a(this.m);

            boolean var19;
            do {
               int var9;
               int var5 = (var9 = iA[var4]) >> 26;
               if ((var9 & 16777216) != 0) {
                  int var14;
                  if ((var14 = var9 & 0xFF) == 23) {
                     int var15 = v + 1 > 5 ? 0 : v + 1;
                     var14 = x[var15];
                  }

                  String var20 = this.e(var14);
                  switch (var5) {
                     case 1:
                        var20 = var20 + " " + (iQ ? this.e(234) : this.e(235));
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
                        if (var4 == iB) {
                           if (var14 != 28 && var14 != 29) {
                              if (var4 > this.iM) {
                                 bq[2].a(var1, F - this.iO - (bq[2].c << 1) + var2 + var3, this.iK + (y >> 3) + 1, 0);
                              }

                              this.a(var1, var20, this.iJ + var2 + var3, this.iK, 1);
                              if (var4 < var7) {
                                 bq[3].a(var1, F + this.iO + bq[3].c + var2 + var3, this.iK + (y >> 3) + 1, 0);
                              }
                           }

                           this.iK = this.iK + y + (y >> 2);
                        }
                     case 2:
                     case 7:
                  }
               }

               if (var19 = var4 < var10) {
                  var4 = k(var4, 16777216);
               }
            } while (var19);

            return;
         }

         var11++;
      }
   }
}
