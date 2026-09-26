import java.io.DataInputStream;
import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class e extends a {
   private static boolean iL = false;
   private final d iM;
   public c[] o;
   public c[] p;
   public c[] q;
   public c[] r;
   public int s;
   public int t;
   public int u = 0;
   public boolean v = false;
   public static int w = 0;
   public static final int[] x = new int[]{10240, 12288, 33792, 29696, 30720, 32768};
   public static final int[] y = new int[]{23, 24, 21, 20, 22, 19};
   public static int z;
   public static int A;
   public boolean B;
   public boolean C = false;
   public boolean D = false;
   public int E = 240;
   public int F = 320;
   public static int G;
   public static int H;
   public static int I;
   public int J;
   public int K = 0;
   public int L;
   public int M;
   public int N;
   public static Random O;
   private static boolean iN = false;
   private b iO;
   private Image iP;
   private static int iQ;
   private static int iR;
   public int[] P = new int[4];
   private c[] iS;
   public int Q = 0;
   private static boolean iT = false;
   private static boolean iU = false;
   public static int[] R;
   public static byte[] S;
   public int T;
   public int U;
   public int V;
   public boolean W;
   public boolean X;
   public boolean Y;
   public boolean Z;
   public int aa;
   public int ab;
   public int ac;
   public int ad;
   public boolean ae;
   public int af;
   public int ag;
   public boolean ah;
   public boolean ai;
   public boolean aj;
   public boolean ak;
   public boolean al;
   public boolean am;
   public boolean an;
   public boolean ao;
   public boolean ap;
   public boolean aq;
   public static byte ar = 4;
   public boolean as;
   public int at;
   public boolean au;
   public int av = 0;
   public int aw = 0;
   public int ax = 200;
   public int ay = -1;
   public int az = -1;
   public int aA;
   public int aB;
   public int aC;
   public int aD = -1;
   public int[] aE;
   public int[] aF;
   public boolean[] aG;
   public boolean[] aH;
   public int aI = 0;
   public int aJ = 0;
   public int aK = 45;
   public static c[] aL;
   public int aM;
   public int aN;
   public int aO;
   public int aP;
   public int[] aQ = new int[2];
   public boolean aR = false;
   public boolean aS;
   public int aT = -1;
   public c[] aU;
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
   public static byte bj = 0;
   public int bk = 0;
   public int bl = 0;
   public static String bm;
   public int bn;
   public static c[] bo;
   public int bp = 0;
   public int bq;
   private byte[] iV;
   private short[] iW;
   private static int iX;
   private static int iY;
   private static int iZ;
   private static int ja;
   private static int jb;
   public int br;
   public int[] bs;
   public int[] bt;
   public int bu;
   public int bv;
   public int bw;
   public int bx;
   public int by;
   public int bz;
   public int bA = -1;
   public static final int[] bB = new int[]{9217, 19456, 20480, 21504, 22528, 23552, 24576, 25600, 26624, 27648};
   public int bC;
   public int bD;
   public int bE;
   public String bF;
   public static final int[] bG = new int[]{-1, -1, -1, 2, 0, 1, 1, 0, 2, 2};
   private byte[] jc;
   private int jd;
   private int je;
   private int jf;
   public c[] bH;
   public static int[] bI = new int[10];
   public int[] bJ = new int[10];
   public int[] bK = new int[10];
   public int[] bL = new int[10];
   public int bM = -1;
   public c[] bN;
   public int[] bO = new int[10];
   public static int[] bP = new int[10];
   public int[] bQ = new int[10];
   public static int[] bR = new int[10];
   public int[] bS = new int[10];
   public int[] bT = new int[10];
   public int[] bU = new int[10];
   public boolean[] bV = new boolean[10];
   public static int bW = -1;
   public c[] bX;
   public int[] bY = new int[20];
   public static int[] bZ = new int[20];
   public static int[] ca = new int[20];
   public int[] cb = new int[20];
   public int[] cc = new int[20];
   public static int cd = -1;
   public c[] ce;
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
   public c[] cp;
   public c[] cq;
   public int cr = -1;
   public int cs;
   public int ct;
   public int cu;
   public static int cv;
   public static c[] cw;
   public int cx = -1;
   public int[] cy;
   public static int[] cz;
   public boolean[] cA;
   public int[] cB;
   public int[] cC;
   public boolean[] cD;
   public static int[] cE;
   public int[] cF;
   public static int[] cG;
   public int[] cH;
   public static int cI = -1;
   public c[] cJ;
   public static int[] cK;
   public static int[] cL;
   public static int[] cM;
   public int[] cN;
   public static int[] cO;
   public static int[] cP;
   public int[] cQ;
   public int[] cR;
   public int[] cS;
   public static int[] cT;
   public int[] cU;
   public static boolean[] cV;
   public boolean[] cW;
   public byte[] cX;
   public int[] cY;
   public static int[] cZ;
   public int[] da;
   public int[] db;
   public int[] dc;
   public static int[] dd;
   public int[] de;
   public static int[] df;
   public int[] dg;
   public c[] dh;
   public int[] di = new int[10];
   public int[] dj = new int[10];
   public int[] dk = new int[10];
   public static int[] dl = new int[10];
   public static int[] dm = new int[10];
   public int[] dn = new int[10];
   public int[] do = new int[10];
   public int dp = -1;
   public c[] dq;
   public int[] dr = new int[15];
   public int[] ds = new int[15];
   public static int[] dt = new int[15];
   public int[] du = new int[15];
   public int[] dv = new int[15];
   public int[] dw = new int[15];
   public static int[] dx = new int[15];
   public int[] dy = new int[15];
   public int dz = -1;
   public boolean dA;
   public boolean dB;
   public c[] dC;
   public static c[] dD;
   public c[] dE;
   public c[] dF;
   public int dG;
   public int dH = 0;
   public int dI;
   public static int[] dJ = new int[15];
   public int[] dK = new int[15];
   public int dL;
   public static int dM;
   public int dN;
   public byte dO;
   public int[] dP = new int[15];
   public byte[] dQ = new byte[15];
   public int[] dR = new int[15];
   public byte[] dS = new byte[15];
   public static int[] dT = new int[15];
   public int[] dU = new int[15];
   public static int[] dV = new int[15];
   public static int[] dW = new int[15];
   public int[] dX = new int[15];
   public byte[] dY = new byte[15];
   public int[] dZ = new int[15];
   public int[] ea = new int[15];
   public static byte[] eb = new byte[15];
   public static byte[] ec = new byte[15];
   public static byte[] ed = new byte[15];
   public short[] ee = new short[15];
   public short[] ef = new short[15];
   public byte[] eg = new byte[15];
   public boolean[] eh = new boolean[15];
   public boolean[] ei = new boolean[15];
   public boolean[] ej = new boolean[15];
   public static int[] ek = new int[15];
   public byte[] el = new byte[15];
   public int[] em = new int[15];
   public static int[] en = new int[15];
   public int[] eo = new int[15];
   public int[] ep = new int[15];
   public boolean[] eq = new boolean[15];
   public static int[] er = new int[15];
   public static boolean[] es = new boolean[15];
   public int[] et = new int[15];
   public static int[] eu = new int[15];
   public static boolean[] ev = new boolean[15];
   public static short[] ew = new short[30];
   public static boolean ex = true;
   public boolean ey;
   public boolean ez = true;
   public static boolean eA = true;
   public int eB;
   public int[] eC;
   public int[] eD;
   public int[] eE;
   public int[] eF;
   public boolean[] eG;
   public c[] eH;
   public int[] eI;
   public int[] eJ;
   public int[] eK;
   public static byte[] eL;
   public c[] eM;
   public int[] eN;
   public int[] eO;
   public int[] eP;
   public static int[] eQ;
   public int[] eR;
   public int[] eS;
   public int[] eT;
   public byte[] eU;
   public byte[] eV;
   public static boolean[] eW;
   public static int eX = -1;
   public c[] eY;
   public int eZ = -1;
   public int[] fa;
   public int[] fb;
   public static int[] fc;
   public static int[] fd;
   public int[] fe;
   public static int[] ff;
   public int[] fg;
   public byte[] fh;
   public byte[] fi;
   public static boolean[] fj;
   public static boolean[] fk;
   public c[] fl;
   public int fm = -1;
   public int fn;
   public int fo;
   public static boolean[] fp;
   public int[] fq;
   public int[] fr;
   public static int[] fs;
   public int[] ft = new int[10];
   public c[] fu;
   public int fv = -1;
   public int fw = 0;
   public c[] fx;
   public static final int[] fy = new int[80];
   public static final int[] fz = new int[80];
   public static final int[] fA = new int[20];
   public static final int[] fB = new int[20];
   public static final int[] fC = new int[20];
   public static final int[] fD = new int[20];
   public static final int[] fE = new int[20];
   public static final int[] fF = new int[20];
   public int fG = -1;
   public c[] fH;
   public static final byte[] fI = new byte[]{2, 2, 2, 4, 4, 4, 8};
   public static final byte[] fJ = new byte[]{4, 4, 10, 10, 18, 18};
   public static final byte[] fK = new byte[]{2, 3, 4, 5, 6};
   public static final int[] fL = new int[]{128, 256, 512, 1024, 1536};
   public int fM = 0;
   public boolean fN;
   public int fO;
   public int fP;
   public int fQ;
   public static boolean fR;
   public int fS;
   public int fT;
   public static final int[] fU = new int[]{2, 4, 5, 6, 8};
   public boolean fV;
   public int fW;
   public int fX;
   public int fY;
   public int fZ;
   public int ga;
   public int gb;
   public static int gc;
   public static int gd;
   public int ge = -1;
   public boolean gf;
   public static boolean gg;
   public static boolean gh;
   public boolean gi;
   public boolean gj;
   public boolean gk;
   public byte gl;
   public boolean gm;
   public boolean gn;
   public boolean go;
   public boolean gp;
   public static boolean gq;
   public static boolean gr;
   public boolean gs;
   public boolean gt;
   public boolean gu;
   public boolean gv;
   public int gw;
   public static int gx;
   public boolean gy;
   public boolean gz;
   public boolean gA;
   public static boolean gB;
   public static int gC;
   public int gD;
   public boolean gE;
   public static int gF;
   public int gG;
   public static int gH = 0;
   public int gI = 0;
   public int gJ = -1;
   public int gK;
   public int gL;
   public static boolean gM;
   public static byte gN;
   public byte gO;
   public static byte gP;
   public static byte gQ;
   public static final int[] gR = new int[]{1000, 2000, 3000, 4000};
   public static final int[] gS = new int[]{1000, 2000, 3000, 4000};
   public static final int[] gT = new int[]{1000, 2000, 3000, 4000};
   public static final int[] gU = new int[]{1000, 2000, 3000, 4000};
   public static byte gV = 0;
   public static byte gW = 0;
   public int gX;
   public int gY;
   public int gZ;
   public int ha;
   public static boolean hb = false;
   public static boolean hc = false;
   public boolean hd = false;
   public static int he;
   public static byte hf;
   public int hg;
   public static int hh;
   public int hi;
   public int hj;
   public int hk;
   public static int hl;
   public int hm;
   public int hn;
   public int ho;
   public int hp;
   public int hq;
   public static int hr;
   public int hs;
   public short[] ht = new short[20];
   public static boolean hu;
   public boolean hv;
   public boolean hw;
   public int hx;
   public int hy;
   public int hz;
   public int hA = -1;
   public static int hB = -1;
   public boolean hC = true;
   public static boolean hD = true;
   public boolean hE = false;
   public boolean hF = false;
   public boolean hG = false;
   public int hH = 0;
   public int hI;
   public int hJ;
   public int hK = 0;
   public int hL = 0;
   public short[] hM = new short[256];
   public int hN = 0;
   public int hO;
   public int hP = -1;
   public int hQ;
   public boolean hR;
   public static int hS;
   public static int hT;
   public static int hU;
   public static int hV;
   public static String[] hW;
   public static String[] hX;
   public static byte[] hY;
   public static int hZ;
   public static int ia;
   public static int ib;
   public static boolean ic;
   public static final int[] id = new int[]{40, -1, -3, -3, -3};
   public static final int[] ie = new int[]{42, -1, -3, -3, -3};
   public static final int[] if = new int[]{44, -1, -3, -3, -3};
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
   public static byte[] iq;
   public static byte[] ir;
   public static int[] is;
   public static boolean it = true;
   public int iu;
   public int iv = -1;
   public static int[] iw;
   public static int ix;
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
      int[] var10000 = new int[]{320, 420, 690, 400, 500, 590, 1030};
      var10000 = new int[]{-1, -1, -1};
      int[] var1 = new byte[]{13, 4, 4};
      var1 = new int[]{-1, 64};
   }

   private void k() {
      int var1 = super.h;
      if (super.h != 0) {
         if ((var1 & 2097408) != 0) {
            this.s = 8;
         } else if ((var1 & 4194336) != 0) {
            this.s = 5;
         } else if ((var1 & 1048580) != 0) {
            this.s = 2;
         } else if ((var1 & 262146) != 0) {
            this.s = 1;
         } else if ((var1 & 16777280) != 0) {
            this.s = 6;
         } else if ((var1 & 131072) != 0) {
            this.s = 49;
         } else if ((var1 & 524288) != 0) {
            this.s = 51;
         } else if ((var1 & 8388608) != 0) {
            this.s = 55;
         } else if ((var1 & 33554432) != 0) {
            this.s = 57;
         } else if ((var1 & 65536) != 0) {
            this.s = 48;
         } else if ((var1 & 1024) != 0) {
            this.s = 42;
         } else if ((var1 & 8) != 0) {
            this.s = 35;
         } else if ((var1 & 134217728) != 0) {
            this.s = 27;
         } else {
            this.s = 0;
         }

         if ((var1 & 603979776) != 0) {
            this.s = 29;
            return;
         }
      } else {
         this.s = 0;
      }
   }

   private void l() {
      int var1 = super.g;
      if (super.g != 0) {
         if ((var1 & 2097408) != 0) {
            this.t = 8;
         } else if ((var1 & 4194336) != 0) {
            this.t = 5;
         } else if ((var1 & 1048580) != 0) {
            this.t = 2;
         } else if ((var1 & 262146) != 0) {
            this.t = 1;
         } else if ((var1 & 16777280) != 0) {
            this.t = 6;
         } else if ((var1 & 131072) != 0) {
            this.t = 49;
         } else if ((var1 & 524288) != 0) {
            this.t = 51;
         } else if ((var1 & 8388608) != 0) {
            this.t = 55;
         } else if ((var1 & 33554432) != 0) {
            this.t = 57;
         } else if ((var1 & 65536) != 0) {
            this.t = 48;
         } else if ((var1 & 1024) != 0) {
            this.t = 42;
         } else if ((var1 & 8) != 0) {
            this.t = 35;
         } else if ((var1 & 134217728) != 0) {
            this.t = 27;
         } else if ((var1 & 604012544) != 0) {
            this.t = 29;
         } else {
            this.t = 0;
         }
      } else {
         this.t = 0;
      }
   }

   public e(GOWMIDlet var1) {
      super(var1);
      super.m = 100;
      super.l = 40;
      this.c(240, 320);
      this.iM = new d(this, 12);
      this.iM.a(false);
      I = 0;

      try {
         this.B = a.a(var1.getAppProperty("ENABLECHEATS"), 0) == 1;
      } catch (Exception var3) {
         this.B = false;
      }

      try {
         this.bE = a.a(var1.getAppProperty("DEMO"), 0);
         this.bF = var1.getAppProperty("DemoBuyURL");
      } catch (Exception var2) {
         this.bE = 0;
         this.bF = "";
      }
   }

   public final void i(int var1) {
      if (var1 != 0) {
         if (var1 == 1) {
            if (I != 102 && I != 107) {
               this.af = this.aa >> 8;
               this.ag = this.ab >> 8;
            }

            if (I != 107 && I != 102) {
               this.J = I;
            }

            if (I != 100
               && I != 78
               && I != 105
               && I != 108
               && I != 101
               && I != 102
               && I != 104
               && I != 106
               && I != 109
               && I != 103
               && I != 79
               && I != -3
               && I != 16
               && I != 107
               && I != 0
               && I != 1) {
               I = 80;
               this.hR = false;
            } else if (I != 79 && I != 106 && I != 108 && I != 109 && I != -3 && I != 1 && I != 16 && I != 107 && I != 0 && I != 78) {
               this.a(H - (z << 1), H - (z << 1), 35, 35);
               this.hR = false;
               this.T = H - (z << 1) << 8;
               this.U = H - (z << 1) << 8;
               this.W = false;
               I = 102;
               this.iB = true;
            }

            this.iI = false;
            this.iC = true;
         } else if (var1 == 5) {
            if (this.hR && I == 80) {
               this.hR = false;
               this.y(0);
            }
         } else if (var1 == 2) {
            if (I == 80) {
               this.y(0);
            }
         } else if (var1 == 3) {
            this.iM.c();
         }
      }

      super.i(var1);
   }

   public final void a() {
      this.L = super.k >> this.hH;
      this.f();
      this.k();
      this.l();
      switch (I) {
         case 0:
            if (this.K <= 13) {
               this.n();
               return;
            }

            this.iS = null;
            this.a((DataInputStream)null);
            this.iC = true;
            this.A(1);
            this.iS = null;
            hX = new String[3];
            hX[0] = this.e(36);
            hX[1] = "";
            hX[2] = "";
            this.a(if, ih);
            I = 78;
            this.d();
            this.K = 0;
            return;
         case 1:
            this.m();
            if (this.v) {
               G();
               if (this.u == 0) {
                  this.D();
                  this.b(false);
                  S = this.c(this.bA);
                  this.ge = -1;
                  dM = -1;
                  this.dN = -1;
               }

               if (this.u <= 10) {
                  this.a(S, false);
                  return;
               }

               this.e();
               S = null;
               if (this.eB >= 1) {
                  this.eB--;
               }

               this.t();
               int var2 = this.u;
               this.u = 0;
               this.u = var2;
               this.v = false;
               this.b(false);
               this.o();
               this.iO.b(iQ, iR);
               this.a(H, H, 35, 35);
               this.bf = true;
               if (this.Q <= 0) {
                  this.al = true;
                  return;
               }
            }

            return;
         case 78:
            if (this.s == 27 || this.s == 8) {
               this.f(x[w]);
               this.iC = true;
               this.h();
               hX = new String[3];
               hX[0] = this.e(36);
               hX[1] = "";
               hX[2] = "";
               this.a(if, ih);
               I = 79;
               return;
            }

            if (this.s == 1) {
               if (w > 0) {
                  w--;
                  return;
               }

               return;
            } else {
               if (this.s == 6) {
                  if (w < 5) {
                     w++;
                     return;
                  }
               } else if (this.s == 29) {
                  this.M();
                  return;
               }

               return;
            }
         case 79:
            this.I();
            this.m();
            if ((this.s == 27 || this.s == 29) && this.T == 0) {
               if (this.s == 27) {
                  this.iM.a(true);
               } else {
                  this.iM.a(false);
               }

               iL = this.iM.b();
               this.y(0);
               if (this.aa == H << 8) {
                  this.a(0, 0, 35, 35);
               } else {
                  this.a(H, H, 35, 35);
               }

               this.iC = true;
               return;
            }

            return;
         case 80:
            this.N = O.nextInt();
            if (this.T == 0) {
               this.L();
               this.K();
            }

            this.m();
            if (this.s == 48 && this.B) {
               for (int var1 = 0; var1 < 10; var1++) {
                  iw[9 + var1] = iw[9 + var1] = iw[9 + var1] | 50331648;
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
            this.hH = 0;
            if (this.fv == 10) {
               this.hm += 3;
               this.hj = this.hj + this.hm / 64;
               if (this.hj > this.hm) {
                  this.hj = this.hm;
               }
            } else {
               this.hn += 3;
               hl = hl + this.hn / 64;
               if (hl > this.hn) {
                  hl = this.hn;
               }
            }

            if (this.fw <= 0) {
               I = 100;
               this.iB = true;
               if (this.hj > this.hm && this.fv == 10) {
                  this.hj = this.hm;
               } else if (this.fv == 9) {
                  hl = this.hn;
               }
            }

            this.fw -= 3;
         case 100:
            this.bp = this.bp + this.L;
            if (this.bp >= 250) {
               this.bp = 0;
               if (this.bq == 0) {
                  this.bq = 16777215;
               } else {
                  this.bq = 0;
               }
            }

            this.bc = false;
            break;
         case 106:
            this.m();
            this.bi = false;
            this.q();
            return;
         case 107:
            if (!this.aW) {
               this.E();
            }

            if (this.aW) {
               if (this.t == 1) {
                  this.aX = 24;
               } else {
                  this.aX = 4;
               }

               if (this.t == 6) {
                  this.aX = -24;
               }

               this.in = this.in + this.L * this.aX;
               if (this.in < 0) {
                  this.in = 0;
               }

               if ((this.in >> 8 > 50 + this.F - z || this.t == 29 && this.T == this.aa) && I == 107 && this.aa < H << 8) {
                  this.a(H, H, 35, 35);
                  if (this.Q > 0) {
                     this.al = true;
                  } else {
                     this.am = true;
                     this.Q = -1;
                  }
               }
            } else if (this.s == 29 && this.T == this.aa) {
               this.ah = true;
               this.a(H, H, 35, 35);
               this.iC = true;
            }

            this.m();
            return;
         case 109:
            this.m();
            if (this.T == this.aa && this.U == this.ab && !this.W) {
               if (this.s == 27 && (this.bE <= 0 || this.bC < this.bE)) {
                  this.au = true;
                  this.z(1);
                  this.a(H, H, 35, 35);
               }

               if (this.s == 29) {
                  this.a(H, H, 35, 35);
                  this.ao = true;
                  this.cr = -1;
                  return;
               }
            }

            return;
         default:
            return;
      }

      this.N = O.nextInt();
      if ((I == 100 || I == 105 || I == 108) && !this.bc) {
         this.z();
      }

      if (I == 105) {
         this.t = 0;
         this.s = 0;
      }

      if (I == 101) {
         if (this.T >= this.aa && this.T < this.F << 8) {
            this.bd = this.bd + (this.L >> 4 - (this.t == 8 ? 3 : 0));
         }

         this.r();
      } else {
         this.bd = 0;
      }

      this.o();
      this.iO.b(iQ, iR);
      this.m();
   }

   private void a(int var1, int var2, int var3, int var4) {
      this.Y = this.T <= var1 << 8;
      this.Z = this.U <= var2 << 8;
      this.W = this.Z || this.Y;
      if (this.W) {
         this.V = 375;
      }

      this.aa = var1 << 8;
      this.ab = var2 << 8;
      this.ac = var3;
      this.ad = var4;
      this.v = false;
      this.ap = false;
      this.ao = false;
      this.X = false;
   }

   private void m() {
      if (this.T >= this.aa && this.U >= this.ab && (I == 105 || I == 100)) {
         this.bc = false;
      }

      if (this.T == this.aa && this.U == this.ab && this.V > 0) {
         if (this.V == 375 && I != 101 && I != 105) {
            this.y(1);
         }

         this.V = this.V - this.L;
         if (this.V < 0) {
            this.V = 0;
            return;
         }
      } else {
         if (I == 1) {
            if (this.T == this.aa && this.U == this.ab && this.W && this.Q <= 0) {
               if (!this.al) {
                  if (!iN) {
                     this.a(H - (z << 1), H - (z << 1), 35, 35);
                  } else {
                     this.a(H - (z << 1) - z, H - (z << 1) - z, 35, 35);
                  }

                  this.W = false;
               } else {
                  this.a(0, 0, 35, 35);
                  I = 100;
                  this.iB = true;
                  this.u = 0;
                  this.Q = 0;
                  this.bf = false;
                  this.al = false;
               }
            } else if (this.Q > 0 && this.u >= 10 && this.T >= this.aa && this.U >= this.ab && this.W) {
               this.bf = true;
               int[] var2;
               (var2 = new int[3])[0] = -1;
               var2[1] = this.Q;
               var2[2] = -1;
               this.cr = -1;
               this.a(var2, aV, 8, 25, 211, 270, 30);
               this.aW = true;
               this.a(25, 25, 35, 35);
               this.in = 0;
               I = 107;
            } else if (this.Q > 0 && this.u > 10 && !this.W && this.T == this.aa && this.U == this.ab) {
               this.aW = true;
               this.bf = true;
               this.a(H, H, 35, 35);
               this.v = true;
            } else if (this.T == this.aa && this.U == this.ab && !this.W && !this.v) {
               this.W = false;
               this.v = true;
            }
         } else if (I == 101) {
            if (this.T == this.aa && this.U == this.ab && this.W && this.aW) {
               this.a(this.aQ, aV, 8, 25, 211, 270, 30);
               if (hX != null) {
                  hX[0] = "";
                  hX[2] = "";
               }

               this.a(25, 25, 35, 35);
               I = 107;
               this.in = 0;
            }
         } else if (I == 102) {
            if (this.T == this.aa && this.U == this.ab && this.W) {
               if (this.ap) {
                  this.a(this.af, this.ag, 35, 35);
                  I = this.J;
                  this.ap = false;
                  this.W = false;
                  this.a(this.aQ, aV, 8, 0, 211, z * 5 + A, 30);
               } else if (this.ao) {
                  this.ao = false;
                  this.D();
                  this.y(0);
                  this.b(true);
                  this.a((DataInputStream)null);
                  ix = 0;
                  this.iy = 0;
                  I = 80;
                  this.a(0, 0, 35, 35);
                  this.z(1);
               } else if (this.an) {
                  this.M();
               } else if (this.aq) {
                  this.h();
                  hX = new String[3];
                  hX[0] = "";
                  hX[2] = "";
                  this.a(this.q);
                  hX[1] = this.e(114) + "\n" + this.e(292) + "\n\n\n\n";
                  this.a(id, ig);
                  this.a(25, 25, 35, 35);
                  I = 107;
                  this.in = 0;
               } else {
                  this.a(H - (z << 1), H - (z << 1), 35, 35);
                  this.X = true;
               }

               this.W = false;
            }
         } else if (I == 80) {
            if (this.T == this.aa && this.U == this.ab && this.W && this.aj) {
               this.aj = false;
               this.h();
               hX = new String[3];
               hX[0] = "";
               hX[2] = "";
               this.a(this.q);
               if (this.ai) {
                  hX[1] = this.e(115);
                  int var1;
                  if ((var1 = hX[1].indexOf(37)) != -1) {
                     hX[1] = hX[1].substring(0, var1) + "1.4.8" + hX[1].substring(var1 + 1, hX[1].length());
                  }

                  this.a(ie, ig);
               } else {
                  hX[1] = this.e(114) + "\n" + this.e(292) + "\n\n\n\n";
                  this.a(id, ig);
               }

               this.a(25, 25, 35, 35);
               I = 107;
            }
         } else if (I == 79) {
            if (this.T == this.aa && this.U == this.ab && this.W) {
               this.a(0, 0, 35, 35);
               this.iI = false;
               this.iC = true;
               this.z(1);
               I = 80;
            }
         } else if (I != 107) {
            if (I == 109) {
               if (this.T == this.aa && this.U == this.ab && this.W) {
                  if (!this.ao && !this.au) {
                     this.a(H - (z << 1), H - (z << 1), 35, 35);
                  } else if (this.au) {
                     I = 106;
                     this.a(0, 0, 35, 35);
                  } else {
                     I = 80;
                     this.y(0);
                     this.ao = false;
                     this.z(1);
                     if (this.bD >= 10) {
                        ix = 9;
                     } else {
                        ix = this.bD + 9;
                     }

                     this.D();
                     this.b(true);
                     this.a((DataInputStream)null);
                     this.bf = false;
                     this.iy = 0;
                     this.a(0, 0, 35, 35);
                  }
               }
            } else if (I == 108 && this.T == this.aa && this.U == this.ab && this.W) {
               if (!this.ao && !this.ap) {
                  if (iN) {
                     this.a(H - (z << 1) - z - (z >> 2), H - (z << 1) - z - (z >> 2), 35, 35);
                  } else {
                     this.a(H - A - (z >> 2), H - A - (z >> 2), 35, 35);
                  }

                  this.X = true;
               } else if (!this.ap && this.ao) {
                  this.ao = false;
                  this.D();
                  this.y(0);
                  this.b(true);
                  this.a((DataInputStream)null);
                  this.iy = 0;
                  ix = 0;
                  I = 80;
                  this.a(0, 0, 35, 35);
                  this.z(1);
               } else {
                  I = 100;
                  this.iB = true;
                  this.a(0, 0, 35, 35);
                  this.X = true;
               }
            }
         } else {
            if (this.T != this.aa || this.U == this.ab) {
               this.h();
            }

            if (this.T == this.aa && this.U == this.ab && this.ah) {
               if (!this.aq) {
                  I = 80;
                  this.ah = false;
                  ix = 0;
                  this.iy = 0;
                  this.a(0, 0, 35, 35);
               } else if (this.T == H << 8) {
                  this.cr = this.at;
                  this.aq = false;
                  this.ah = false;
                  this.a(H - (z << 1), H - (z << 1), 35, 35);
                  I = 102;
               }
            } else if (this.T == this.aa && this.U == this.ab && this.am && this.Q < 0) {
               this.a(H - (z << 1), H - (z << 1), 35, 35);
               this.bf = true;
               this.am = false;
               this.iI = false;
               ix++;
               this.bC++;
               if (this.bC > this.bD && (this.bE <= 0 || this.bC < this.bE)) {
                  this.bD = this.bC;
               }

               if (this.bC < 10) {
                  this.bA = bB[this.bC];
               }

               this.ae = true;
               this.v = false;
               this.D();
               if (this.bC < 10) {
                  I = 109;
               } else {
                  this.D();
                  this.y(0);
                  this.b(true);
                  this.a((DataInputStream)null);
                  this.a(0, 0, 35, 35);
                  this.iy = 0;
                  ix = 0;
                  this.bf = false;
                  I = 80;
                  this.z(1);
               }
            } else if (this.T >= this.aa && this.U >= this.ab && this.Q > 0 && this.al) {
               I = 100;
               this.iB = true;
               this.bf = false;
               this.al = false;
               this.u = 0;
               this.Q = 0;
               this.a(0, 0, 35, 35);
            }
         }

         if (I == 102 && this.X && this.V < 0) {
            this.X = false;
            I = this.J;
            this.bc = true;
            this.iB = true;
         }

         if (this.T > 115) {
            if (I == 108 && this.T == this.aa && !this.W) {
               if (this.s != 8 && this.s != 27) {
                  if (this.s == 29) {
                     this.a(H, H, 35, 35);
                     this.ao = true;
                  }
               } else if (!iN) {
                  this.ga = this.fY;
                  this.gb = this.fZ;
                  hu = this.hv;
                  iQ = this.ga - 120 - ((hu ? 1 : -1) * 240 >> 2);
                  iR = this.gb - 266;
                  this.aO = iQ << 8;
                  this.aP = iR << 8;
                  this.hw = false;
                  this.s(0);
                  this.hj = this.hm;
                  this.hk = this.hm;
                  hl = this.hn;
                  this.a(H, H, 35, 35);
                  this.X = true;
                  this.iB = true;
                  this.gJ = -1;
                  this.ap = true;
               }
            } else if (I == 102 && this.T == this.aa && !this.W) {
               if (this.s != 8 && this.s != 27) {
                  if (this.s == 29) {
                     if (this.as) {
                        this.as = false;
                     } else {
                        this.a(H, H, 35, 35);
                        this.ap = true;
                     }
                  } else if (this.s == 2) {
                     if (!this.as) {
                        ar++;
                        if (ar > 4) {
                           ar = 4;
                        }
                     }
                  } else if (this.s == 5 && !this.as) {
                     ar--;
                     if (ar < 1) {
                        ar = 1;
                     }
                  }
               } else if (ar == 4) {
                  this.iM.a(!this.iM.b());
                  iL = this.iM.b();
               } else if (ar == 2 && this.as) {
                  this.a(H, H, 35, 35);
                  this.cr = -1;
                  this.ao = true;
               } else if (ar == 1 && this.as) {
                  this.a(H, H, 35, 35);
                  this.an = true;
               } else if ((ar == 2 || ar == 1) && !this.as) {
                  this.as = true;
               } else if (ar == 3) {
                  this.aW = false;
                  this.a(H, H, 35, 35);
                  this.aq = true;
                  this.at = this.cr;
                  this.cr = -1;
               } else {
                  this.as = false;
                  this.aq = false;
               }
            }
         }

         if (this.T < this.aa && this.Y && (this.ae && this.U <= this.U || !this.ae)) {
            this.iB = true;
            this.T = this.T + this.L * this.ac;
            if (this.T >= this.aa) {
               this.T = this.aa;
               if (I == 105) {
                  this.bc = false;
               }
            }
         }

         if (this.U < this.ab && this.Z) {
            this.U = this.U + this.L * this.ac;
            this.iB = true;
            if (this.U > this.ab) {
               this.U = this.ab;
            }
         }

         if (this.T > this.aa && !this.Y) {
            this.iB = true;
            this.T = this.T - this.L * this.ac;
            if (this.T <= this.aa) {
               this.T = this.aa;
            }

            this.ak = true;
         }

         if (this.U > this.ab && !this.Z) {
            this.iB = true;
            this.U = this.U - this.L * this.ad;
            if (this.U < this.ab) {
               this.U = this.ab;
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
      switch (this.K) {
         case 0:
            this.h(138);
            this.E = 240;
            this.F = 320;
            G = this.E >> 1;
            H = this.F >> 1;
            this.f(10240);
            byte[] var1;
            R = new int[(var1 = this.c(1053)).length / 3];
            int var2 = 0;

            for (byte var5 = 0; var5 < var1.length; var5 += 3) {
               R[var2] = var1[var5] << 18 | var1[var5 + 1] << 10 | var1[var5 + 2] << 2;
               var2++;
            }

            O = new Random();
            this.b(true);
            this.iS = this.b(1037);
            this.cp = this.b(1035);
            this.g(1024);
            this.a(1024, true);
            this.cq = this.b(1030);
            this.fu = this.b(1038);
            this.g(1026);
            this.a(1026, true);
            break;
         case 1:
            this.q = this.b(1031);
            this.a(this.q);
            z = this.c();
            A = z >> 1;
            this.iJ = this.a("W") * 4;
            this.fx = this.b(1034);

            for (int var3 = 0; var3 < 5; var3++) {
               this.I();
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
            aL = this.b(1036);
            this.g(1027);
            this.a(1027, true);
            this.aU = this.b(1040);
            bo = this.b(1029);
            this.J();
            break;
         case 4:
            this.iM.a(0, 1063, -1, 0);
            this.iM.a(1, 1064, 1, 0);
            this.iM.a(2, 1062, 1, 0);
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
            iw[5] = (iw[5] & -256) + 68;
            iw[5] = iw[5] & -50331649;
            iw[6] = iw[6] & -50331649;
            break;
         case 13:
            this.h();
            if (!iU) {
               iT = true;
               this.iS = this.b(8193);
               this.g(8192);
               this.a(0, 8192, 0);
               iU = true;
            } else {
               iU = this.b(0, super.k);
               if (!iU) {
                  this.M = 0;
               }
            }

            this.h();
      }

      if (!iU && this.K <= 13) {
         this.K++;
      }

      for (int var4 = 0; var4 < 6 && !iU; var4++) {
         this.I();
      }
   }

   private void b(boolean var1) {
      if (var1) {
         this.r = this.b(1039);
         this.o = this.b(1032);
         this.p = this.b(1033);
         this.iI = false;
         this.iC = true;
         this.iu = this.r[3].c;
         this.d();
         this.bC = this.bD;
         this.a((DataInputStream)null);
      } else {
         this.a(132, 1027, 10);
         this.r = null;
         this.o = null;
         this.p = null;
      }
   }

   private void o() {
      int var1 = this.L << 8;
      int var2;
      int var3;
      if (this.ay > 0) {
         var2 = this.ay;
         var3 = this.az;
      } else {
         var2 = this.ga;
         var3 = this.gb;
      }

      int var10000 = (hu && this.ay < 0 ? 1 : -1) * (hB != 109 && hB != 110 ? 240 : -240) >> 2;
      int var4 = 0;
      var4 = var10000 - (this.gn ? (hu ? this.E >> 2 : -(this.E >> 2)) : 0);
      if (hB == 116) {
         var4 = 0;
      }

      int var5 = this.gn ? 80 : 0;
      int var6 = var2 - 120 + var4;
      int var7 = var3 - 266 + var5;
      int var8 = (var6 - iQ + this.aI) * this.L;
      int var9 = (var7 - iR + this.aJ) * this.L;
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
      this.aM = iQ - var6;
      this.aN = iR - var7;
      iQ = var6;
      iR = var7;
      boolean var10 = false;
      boolean var11 = false;
      if (this.ay < 0) {
         for (int var12 = this.aD - 1; var12 >= 0; var12--) {
            if (a(this.aE[var12], this.aF[var12], iQ, iR, 240, 320)) {
               if (!this.aH[var12]) {
                  var10 = true;
                  int var13 = this.aK * this.L >> 8;
                  if (this.aG[var12]) {
                     this.aI -= var13;
                  } else {
                     this.aI += var13;
                  }

                  if (!a(this.aE[var12], this.aF[var12], iQ + this.aI, iR + this.aJ, 240, 320)) {
                     this.aI = this.aE[var12] - iQ - (this.aG[var12] ? 240 : 0);
                  }
               } else {
                  var11 = true;
                  int var18 = this.aK * this.L >> 8;
                  if (this.aG[var12]) {
                     this.aJ -= var18;
                  } else {
                     this.aJ += var18;
                  }

                  if (!a(this.aE[var12], this.aF[var12], iQ + this.aI, iR + this.aJ, 240, 320)) {
                     this.aJ = this.aF[var12] - iR - (this.aG[var12] ? 320 : 0);
                  }
               }
            }
         }

         for (int var17 = this.eZ; var17 >= 0; var17--) {
            if (fj[var17] && a(fd[var17] + (fk[var17] ? ff[var17] : 0), this.fe[var17], iQ, iR, 240, 320)) {
               var10 = true;
               int var19 = this.aK * this.L >> 8;
               if (fk[var17]) {
                  this.aI -= var19;
               } else {
                  this.aI += var19;
               }

               if (!a(fd[var17] + (fk[var17] ? ff[var17] : 0), this.fe[var17], iQ + this.aI, iR + this.aJ, 240, 320)) {
                  this.aI = fd[var17] + (fk[var17] ? ff[var17] : 0) - iQ - (fk[var17] ? 240 : 0);
               }
            }
         }

         iQ = iQ + this.aI;
         iR = iR + this.aJ;
         if (!var10 && this.aI != 0) {
            if (this.aI > 0) {
               this.aI = this.aI - (this.aK * this.L >> 8);
               if (this.aI < 0) {
                  this.aI = 0;
               }
            } else {
               this.aI = this.aI + (this.aK * this.L >> 8);
               if (this.aI > 0) {
                  this.aI = 0;
               }
            }
         }

         if (!var11 && this.aJ != 0) {
            if (this.aJ > 0) {
               this.aJ = this.aJ - (this.aK * this.L >> 8);
               if (this.aJ < 0) {
                  this.aJ = 0;
               }
            } else {
               this.aJ = this.aJ + (this.aK * this.L >> 8);
               if (this.aJ > 0) {
                  this.aJ = 0;
               }
            }
         }

         this.aM = this.aM - this.aI;
         this.aN = this.aN - this.aJ;
         if (this.av != 0) {
            if (this.aw + this.aw * this.hH >= this.ax) {
               iR = iR + this.av;
               iQ = iQ + this.av * ((this.N & 1) == 1 ? -1 : 1);
               this.av = this.av + (this.av < 0 ? 1 : -1);
               this.av = -this.av;
               this.aw = 0;
            } else {
               this.aw = this.aw + this.L;
            }
         } else {
            this.ax = 0;
         }
      } else if (var8 != 0 && this.aA <= 3500) {
         this.aA = this.aA + this.L;
      } else {
         this.ay = -1;
         this.az = -1;
         this.iB = true;
         this.aA = 0;
      }

      if (iQ < 0) {
         iQ = 0;
         this.aO = 0;
         this.aM = 0;
      }

      if (iQ >= this.aB) {
         iQ = this.aB;
         this.aO = this.aB << 8;
         this.aM = 0;
      }

      if (iR < 0) {
         iR = 0;
         this.aP = 0;
         this.aN = 0;
      }

      if (iR >= this.aC) {
         iR = this.aC;
         this.aP = this.aC << 8;
         this.aN = 0;
      }
   }

   private void p() {
      this.ip = false;
      this.aQ[0] = -1;
      this.aQ[1] = this.cs;
      hX = new String[3];
      hX[0] = "";
      hX[1] = this.e(this.aQ[1]);
      this.a(this.q);
      if (hX[1].charAt(0) == '!') {
         I = 105;
         this.bc = true;
         this.s(this.aY[this.ba]);
         if (this.dL != -1) {
            this.i(this.aZ[this.bb], this.dL);
            return;
         }
      } else {
         if (hX[1].charAt(0) == '^') {
            this.cr = a.a(hX[1].substring(1, 2), 0);
            if (this.cr > 3) {
               int var1 = this.cr - 3 - 1;
               this.fM = var1;
               hb = this.fM == 1;
               hc = this.fM == 2;
               this.hd = this.fM == 3;
            }
         } else {
            this.cr = -1;
         }

         hX[1].charAt(0);
         if (hX[1].charAt(0) == '*') {
            if (hX[1].length() != 1) {
               this.aW = true;
               this.a(H, H, 35, 35);
            } else {
               this.be = true;
            }

            this.iC = true;
            return;
         }

         this.aW = false;
         this.a(this.aQ, aV, 8, 0, 211, z * 5 + A, 30);
      }
   }

   private void q() {
      if (this.bk <= 0 && !this.bi) {
         switch (this.s) {
            case 1:
            case 2:
               bj++;
               if (bj > bh) {
                  bj = 0;
               }
               break;
            case 5:
            case 6:
               bj--;
               if (bj < 0) {
                  bj = bh;
               }
               break;
            case 29:
            case 35:
               if (!this.au) {
                  I = 100;
               } else {
                  this.au = false;
                  I = 1;
                  this.a(H, H, 35, 35);
               }

               this.iB = true;
         }

         switch (this.t) {
            case 8:
               if (this.hq > 0 && this.hq >= this.bg) {
                  if (this.bg < 16) {
                     this.bg++;
                  }
               } else if (this.hq < this.bg) {
                  this.bg = this.hq;
               } else if (this.hq <= 0) {
                  this.bg = 0;
               }
            case 27:
               if (this.hq > 100) {
                  this.bg = 100;
               } else {
                  this.bg = this.hq;
               }

               switch (bj) {
                  case 0:
                     if (gP <= 3) {
                        this.gX = this.gX + this.bg;
                        if (this.gX >= gR[gP]) {
                           this.bg = gR[gP] - (this.gX - this.bg);
                           if (gP == 0 || gP == 1 || gP == 2) {
                              gN++;
                           }

                           this.gX = 0;
                           gP++;
                           this.bk = 2500;
                        }
                     } else {
                        this.bg = 0;
                     }
                     break;
                  case 1:
                     if (gQ <= 3) {
                        this.gY = this.gY + this.bg;
                        if (this.gY < gS[gQ]) {
                           break;
                        }

                        this.bg = gS[gQ] - (this.gY - this.bg);
                        if (gQ == 0 || gQ == 1 || gQ == 3) {
                           this.gO++;
                        }

                        this.gY = 0;
                        gQ++;
                        this.bk = 2500;
                        break;
                     }

                     this.bg = 0;
                     break;
                  case 2:
                     if (gV < 4) {
                        this.gZ = this.gZ + this.bg;
                        if (this.gZ >= gT[gV]) {
                           this.bg = gT[gV] - (this.gZ - this.bg);
                           this.gZ = 0;
                           gV++;
                           this.bk = 2500;
                        }
                     } else {
                        this.bg = 0;
                     }
                     break;
                  case 3:
                     if (gW < 4) {
                        this.ha = this.ha + this.bg;
                        if (this.ha >= gU[gW]) {
                           this.bg = gU[gW] - (this.ha - this.bg);
                           this.ha = 0;
                           gW++;
                           this.bk = 2500;
                        }
                     } else {
                        this.bg = 0;
                     }
               }

               this.hq = this.hq - this.bg;
               if (this.hq < 0) {
                  this.hq = 0;
               }
               break;
            default:
               this.bg = 0;
         }
      } else {
         this.bk = this.bk - this.L;
      }

      if (this.B) {
         if (this.t == 57) {
            this.hq += 20;
            return;
         }

         if (this.t == 55) {
            this.hq -= 20;
            if (this.hq < 0) {
               this.hq = 0;
            }
         }
      }
   }

   private void r() {
      if (this.T >= this.aa && this.ip) {
         switch (this.s) {
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
                  this.p();
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

               if ((this.cr <= 3 || this.s != 27) && this.cr > 3) {
                  break;
               }

               this.bd = 0;
               this.il = -1;
               this.im = -1;
               this.cs++;
               if (this.cs >= this.cu) {
                  if (!this.be) {
                     I = 100;
                     this.a(0, 0, 35, 35);
                     this.iB = true;
                     this.aW = false;
                     this.cu = -1;
                     this.cs = -1;
                     this.ct = -1;
                     return;
                  }

                  this.h();
                  this.bC++;
                  if (this.bC > this.bD && (this.bE <= 0 || this.bC < this.bE)) {
                     this.bD = this.bC;
                  }

                  this.bA = bB[this.bC];
                  this.D();
                  this.iC = true;
                  this.iS = null;
                  this.bf = true;
                  I = 1;
                  this.v = false;
                  this.a(H, H, 35, 35);
                  return;
               }

               this.p();
               return;
            case 29:
               if (this.T == this.aa) {
                  this.af = this.aa >> 8;
                  this.ag = this.ab >> 8;
                  this.J = I;
                  I = 102;
                  ar = 4;
                  this.a(H, H, 35, 35);
               }
         }
      }
   }

   public final void a(Graphics var1) {
      switch (I) {
         case 0:
            this.u(var1);
            if (!iU && this.K <= 13) {
               a(var1, this.K, 13, true);
               return;
            }
            break;
         case 1:
         case 80:
         case 109:
            if (!this.bf && I != 1) {
               this.w(var1);
            }

            this.c(var1);
            if (I == 109 && this.T == this.aa && this.U == this.ab && !this.W) {
               if (this.bC >= this.bE && this.bE != 0) {
                  this.a(var1, -1, 197);
                  return;
               }

               this.a(var1, 28, 29);
               return;
            }
            break;
         case 78:
            this.v(var1);
            this.r[0].a(var1, G, 0, 0);
            this.r[1].a(var1, G, 0, 0);
            int var2 = (z << 2) + z;

            for (int var3 = 0; var3 <= 5; var3++) {
               this.a(var1, this.e(y[var3]), G, var2, 1);
               if (var3 == w) {
                  bo[2].a(var1, (G >> 1) - bo[2].c, var2 + (z >> 2), 0);
                  bo[3].a(var1, this.E - (G >> 1), var2 + (z >> 2), 0);
               }

               var2 = var2 + z + (z >> 2);
            }

            if (this.aa != H << 8) {
               this.a(var1, 0, 1);
               return;
            }

            this.b(var1);
            return;
         case 79:
            this.v(var1);
            this.r[0].a(var1, G, 0, 0);
            this.r[1].a(var1, G, 0, 0);
            this.a(var1, false);
            this.c(var1);
            if (this.aa != H << 8) {
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
            if (I == 100 && this.T <= 0 && !this.iB) {
               this.a(var1, 0, 0, 240, 306);
            } else {
               this.iB = true;
               this.b(var1);
            }

            this.d(var1);
            if (I != 101) {
               this.f(var1);
            }

            if (I == 100) {
               if (this.aR && this.aS == hu && !fR && a(this.ga, this.gb, iQ, iR, this.E, this.F)) {
                  this.a(var1, this.aU, 131, 12, this.F - 25, 0);
               }

               if (fR && this.fS >= 0 && this.fS < this.fQ && this.ge >= 0) {
                  this.a(var1, this.aU, 131, dT[this.ge] - iQ, this.dU[this.ge] - this.ef[this.ge] - (this.ef[this.ge] >> 2) - iR, 0);
               }
            }

            if (I == 104) {
               var1.setColor(855564);
               var1.fillRect(G >> 3, H - (H >> 1), this.E - (G >> 2), H + z);
               var1.setColor(4269080);
               var1.drawRect((G >> 3) - 1, H - (H >> 1) - 1, this.E - (G >> 2) + 1, H + z + 1);
               var1.setColor(5911589);
               var1.drawRect((G >> 3) - 2, H - (H >> 1) - 2, this.E - (G >> 2) + 3, H + z + 3);
               this.cq[0].a(var1, (G >> 3) - 3, H - (H >> 1) - 2, 0);
               this.cq[0].a(var1, this.E - (G >> 3) + 3, H - (H >> 1) - 2, 2);
               this.cq[0].a(var1, (G >> 3) - 3, H + (H >> 1) + 2 + z, 1);
               this.cq[0].a(var1, this.E - (G >> 3) + 3, H + (H >> 1) + 2 + z, 3);
               this.a(var1, this.fu, 136, G, H - (z << 1), 0);
               if (this.fv == 9) {
                  this.a(var1, this.e(148), G, H + z, 1);
                  if (this.fw < 96) {
                     this.a(var1, this.e(189), G, H + (z << 1) + z, 1);
                  } else {
                     this.a(var1, this.e(151), G, H + (z << 1) + z, 1);
                  }
               } else {
                  this.a(var1, this.e(147), G, H + z, 1);
                  if (this.fw < 96) {
                     this.a(var1, this.e(158), G, H + (z << 1) + z, 1);
                  } else {
                     this.a(var1, this.e(151), G, H + (z << 1) + z, 1);
                  }
               }
            }

            this.c(var1);
            if (I == 101 && this.T >= this.aa && !this.aW) {
               this.a(var1, false);
            }

            switch (I) {
               case 100:
                  if (this.iB) {
                     this.a(var1, 160, 197);
                     return;
                  }

                  return;
               case 101:
                  if (this.ip) {
                     this.a(var1, 174, 197);
                     return;
                  }

                  this.a(var1, -1, -1);
                  return;
               case 102:
                  if (this.T == this.aa && !this.W) {
                     if ((ar == 1 || ar == 2) && this.as) {
                        this.a(var1, 28, 29);
                        return;
                     }

                     if (ar == 4 && ar != 3) {
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
               if (this.hq > 0) {
                  this.a(var1, !this.bi ? (this.bn <= 3 ? 149 : -1) : -1, !this.bi ? (this.au ? 174 : 2) : -1);
                  return;
               }

               this.a(var1, -1, !this.bi ? (this.au ? 174 : 2) : -1);
               return;
            }

            this.a(var1, -1, -1);
            return;
         case 107:
            if (super.n) {
               this.v(var1);
               this.a(var1, true);
            }

            this.c(var1);
            if (I == 107 && this.T <= 6400) {
               if (!this.aW) {
                  this.a(var1, -1, 2);
                  return;
               }

               this.a(var1, -1, 240);
               return;
            }
      }
   }

   private void c(Graphics var1) {
      int var2 = this.T >> 8;
      int var3 = this.U >> 8;
      if (var2 > 0) {
         if ((!this.W || this.X || this.ao || this.aq || this.ap || this.an) && (I == 108 || I == 102 || I == 1 || I == 109)) {
            var1.setColor(0);
            var1.fillRect(0, var2 + 1, 240, 320 - (var3 << 1) - 1);
            if (I == 108) {
               if (!iN) {
                  this.a(var1, this.e(173), G, H + A + (z >> 3), 33);
               } else {
                  this.a(var1, this.e(173), G, H - (z << 1) + (z >> 1), 33);
                  this.a(var1, this.e(206), G, H - (z >> 2) + (z >> 1), 33);
                  this.a(var1, String.valueOf(this.dI), G, H + z + (z >> 2), 33);
                  if (this.dI > this.hz) {
                     this.a(var1, this.e(207), G, H + (z << 1) + (z >> 1), 33);
                  } else {
                     this.a(var1, this.e(208) + String.valueOf(this.hz), G, H + (z << 1) + (z >> 1), 33);
                  }
               }
            } else if (I == 102) {
               this.a(var1, !iN ? this.e(54 + this.bC) : this.e(66), G, H - (z >> 1), 33);
               if (ar == 4) {
                  this.a(var1, this.e(47) + " " + (this.iM.b() ? this.e(234) : this.e(235)), G, H + z + A, 33);
                  bo[3].a(var1, this.E - 5 - 7, H + (z >> 1) + 4, 0);
               } else if (ar == 2 && !this.as) {
                  this.a(var1, this.e(50), G, H + z + A, 33);
                  bo[2].a(var1, 12 - bo[2].c, H + (z >> 1) + 4, 0);
                  bo[3].a(var1, this.E - 5 - 7, H + (z >> 1) + 4, 0);
               } else if (ar == 2 && this.as) {
                  this.a(var1, this.e(186), G, H + z + A, 33);
               } else if (ar == 1 && !this.as) {
                  this.a(var1, this.e(1), G, H + z + A, 33);
                  bo[2].a(var1, 12 - bo[2].c, H + (z >> 1) + 4, 0);
               } else if (ar == 1 && this.as) {
                  this.a(var1, this.e(185), G, H + z + A, 33);
               } else if (ar == 3) {
                  this.a(var1, this.e(46), G, H + z + A, 33);
                  bo[3].a(var1, this.E - 5 - 7, H + (z >> 1) + 4, 0);
                  bo[2].a(var1, 12 - bo[2].c, H + (z >> 1) + 4, 0);
               }
            } else if (I == 1) {
               this.a(this.q);
               if (iN) {
                  this.a(var1, this.e(66), G, H - z - (z >> 1), 33);
                  this.a(var1, this.e(190), G, H - (z >> 1), 33);
                  this.a(var1, this.e(238), G, H + (z >> 1), 33);
                  this.a(var1, this.e(39), G, H + z + (z >> 1) + (z >> 2), 33);
                  a(var1, this.u, 11, true);
               } else {
                  this.a(var1, this.e(54 + this.bC), G, H - A, 33);
                  this.a(var1, this.e(39), G, H + A, 33);
                  a(var1, this.u, 11, true);
               }
            } else if (I == 109) {
               if (this.bC >= this.bE && this.bE != 0) {
                  this.a(var1, this.e(279), G, H, 33);
                  this.a(var1, this.e(280), G, H + z, 33);
                  byte var4 = 0;

                  for (int var5 = H + z + (z << 1) + 4; var4 < this.bF.length(); var5 += z) {
                     this.a(var1, this.bF.substring(var4, var4 + 18 < this.bF.length() ? var4 + 18 : this.bF.length()), G, var5, 33);
                     var4 += 18;
                  }
               } else {
                  this.a(var1, this.e(54 + this.bC - 1) + this.e(169), G, H, 33);
                  this.a(var1, this.e(168) + this.e(54 + this.bC) + this.e(159), G, H + z, 33);
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
         if (!this.W && I == 108) {
            this.a(var1, iN ? -1 : 198, 45);
         }

         this.cq[0].a(var1, 0, var2, 1);
         this.cq[0].a(var1, 240, var2, 3);
         this.cq[0].a(var1, 0, 320 - (var3 - 1), 0);
         this.cq[0].a(var1, 240, 320 - (var3 - 1), 2);
         if (this.bC >= this.bE && this.bE != 0 && I == 109 && this.T == this.aa && !this.W) {
            byte var6 = 0;

            for (int var7 = H + z + (z << 1) + 4; var6 < this.bF.length(); var7 += z) {
               this.a(var1, this.bF.substring(var6, var6 + 18 < this.bF.length() ? var6 + 18 : this.bF.length()), G, var7, 33);
               var6 += 18;
            }
         }
      }

      if (I == 80 && this.T == 0) {
         switch (this.iG) {
            case 0:
               this.a(var1, 0, 1);
               return;
            case 9:
               if (this.bD >= ix - this.iG + 1) {
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
      this.iO.a(var1);
      var1.translate(-iQ, -(iR + this.bl));
      this.i(var1);
      this.l(var1);
      this.m(var1);
      this.p(var1);
      this.j(var1);
      this.q(var1);
      this.n(var1);
      this.o(var1);
      this.g(var1);
      if (this.ge >= 0 && !fR && hB != 109 && hB != 113 && this.dQ[this.ge] != 2) {
         this.s(var1);
         this.r(var1);
      } else {
         this.r(var1);
         this.s(var1);
      }

      this.h(var1);
      this.t(var1);
      this.k(var1);
      var1.translate(iQ, iR + this.bl);
   }

   private void e(Graphics var1) {
      this.v(var1);
      this.a(this.q);
      this.a(var1, this.e(149), 120, z, 1);
      bm = String.valueOf(this.hq) + " ~";
      this.a(var1, bm, 132, 44, 8);
      bm = this.e(116 + bj);
      bo[0].a(var1, 120, 78 - bo[0].d, 0);
      if (bm.indexOf(10) != -1) {
         this.a(var1, bm.substring(0, bm.indexOf(10)), 120, 80, 1);
         this.a(var1, bm.substring(bm.indexOf(10) + 1, bm.length()), 120, 80 + z, 1);
      } else {
         this.a(var1, this.e(116 + bj), 120, 80, 1);
      }

      int var2 = 0;
      if (bj == 0) {
         this.bn = gP;
         if (gP <= 3) {
            var2 = gR[this.bn] - this.gX;
         }
      } else if (bj == 1) {
         this.bn = gQ;
         if (gQ <= 3) {
            var2 = gS[this.bn] - this.gY;
         }
      } else if (bj == 3) {
         this.bn = gW;
         if (gW <= 3) {
            var2 = gU[this.bn] - this.ha;
         }
      } else {
         this.bn = gV;
         if (gV <= 3) {
            var2 = gT[this.bn] - this.gZ;
         }
      }

      if (this.bn <= 3) {
         this.a(var1, this.e(223) + String.valueOf(this.bn + 1), 120, 80 + (z << 1), 1);
         this.a(var1, String.valueOf(var2) + "~", 132, 120 + (z << 1), 8);
         this.a(var1, this.e(224), 120, 120 + (z << 1) + z, 1);
         this.a(var1, this.e(225), 120, 120 + (z << 2), 1);
      } else {
         this.a(var1, this.e(241), 120, 80 + (z << 1), 1);
      }

      bo[1].a(var1, 120, 80 + (z << 1) + z, 0);
      if (this.bk > 0) {
         var1.setColor(855564);
         var1.fillRect(G - (G >> 1), H - (H >> 2), G, (H >> 1) + z);
         var1.setColor(4269080);
         var1.drawRect(G - (G >> 1) - 1, H - (H >> 2) - 1, G + 1, (H >> 1) + 1 + z);
         var1.setColor(5911589);
         var1.drawRect(G - (G >> 1) - 2, H - (H >> 2) - 2, G + 3, (H >> 1) + 3 + z);
         if (bm.indexOf(10) != -1) {
            this.a(var1, bm.substring(0, bm.indexOf(10)), G, H - z - (z >> 1), 1);
            this.a(var1, bm.substring(bm.indexOf(10) + 1, bm.length()), G, H - (z >> 1), 1);
         } else {
            this.a(var1, this.e(116 + bj), G, H - (H >> 2), 1);
         }

         this.a(var1, this.e(222), G, H + z, 1);
      }
   }

   private void f(Graphics var1) {
      this.a(var1, aL, 133, 0, 0, 0);
      int var2 = 5 + this.fM;
      aL[var2].a(var1, 6, 17, 0);
      var1.setColor(4342338);
      var1.drawRect(42, 13, this.hm * 6 >> 8, 3);
      var1.drawRect(42, 17, this.hn * 6 >> 8, 2);
      var1.setColor(0);
      var1.fillRect(42, 14, this.hm * 6 >> 8, 2);
      var1.fillRect(42, 17, this.hn * 6 >> 8, 2);
      var1.setColor(4783872);
      var1.fillRect(42, 14, this.hj * 6 >> 8, 2);
      if (hl <= 0 && (hb || this.hd || hc)) {
         var1.setColor(this.bq);
         var1.fillRect(42, 17, this.hn * 6 >> 8, 2);
      } else {
         var1.setColor(104191);
         var1.fillRect(42, 17, hl * 6 >> 8, 2);
      }

      this.a(var1, String.valueOf(this.hq), 58, 24, 1);
   }

   private void g(Graphics var1) {
      for (int var2 = this.fm; var2 >= 0; var2--) {
         int var3 = this.fq[var2];
         int var4 = this.fr[var2];
         int var5 = var3 - iQ;
         int var6 = var4 - iR;
         if (var5 + (this.fn << 1) >= 0 && var6 + this.fo >= 0 && var5 - this.fn <= 240 && var6 - this.fo <= 320) {
            this.a(var1, this.fl, var2 + 121, var3, var4, 0);
         }
      }
   }

   private void h(Graphics var1) {
      for (int var2 = this.fG; var2 >= 0; var2--) {
         for (int var3 = 0; var3 < 4; var3++) {
            int var4 = (var2 << 2) + var3;
            int var5 = fy[var4];
            int var6 = fz[var4];
            int var7 = var5 - iQ;
            int var8 = var6 - iR;
            if (var7 + this.fx[fE[var2]].c >= 0 && var8 + this.fx[fE[var2]].d >= 0 && var7 - this.fx[fE[var2]].c <= 240 && var8 - this.fx[fE[var2]].d <= 320) {
               this.fx[(fE[var2] << 2) + var3].a(var1, var5, var6, 0);
            }
         }
      }
   }

   private void i(Graphics var1) {
      for (int var2 = cd; var2 >= 0; var2--) {
         if (this.bY[var2] >= 0) {
            int var3 = bZ[var2];
            int var4 = ca[var2];
            int var5 = var3 - iQ;
            int var6 = var4 - iR;
            if (var5 + this.cc[var2] >= 0 && var6 + this.cb[var2] >= 0 && var5 - this.cc[var2] <= 240 && var6 - this.cb[var2] <= 320) {
               this.a(var1, this.bX, var2 + 10, var3, var4, 0);
            }
         }
      }
   }

   private void j(Graphics var1) {
      for (int var2 = bW; var2 >= 0; var2--) {
         if (this.bO[var2] >= 0) {
            int var3 = bP[var2];
            int var4 = this.bQ[var2];
            int var5 = var3 - iQ;
            int var6 = var4 - iR;
            if (var5 + this.bU[var2] >= 0 && var6 + this.bT[var2] >= 0 && var5 - this.bU[var2] <= 240 && var6 - this.bT[var2] <= 320) {
               this.a(var1, this.bN, var2 + 30, var3, var4, 0);
            }
         }
      }
   }

   private void k(Graphics var1) {
      for (int var2 = ck; var2 >= 0; var2--) {
         if (this.cf[var2] >= 0) {
            int var3 = this.cg[var2];
            int var4 = ch[var2];
            int var5 = var3 - iQ;
            int var6 = var4 - iR;
            if (var5 + this.cj[var2] >= 0 && var6 + this.ci[var2] >= 0 && var5 - this.cj[var2] <= 240 && var6 - this.ci[var2] <= 320) {
               this.a(var1, this.ce, var2 + 40, var3, var4, 0);
            }
         }
      }
   }

   private void l(Graphics var1) {
      for (int var2 = this.dz; var2 >= 0; var2--) {
         if (this.dr[var2] >= 0) {
            int var3 = dt[var2];
            int var4 = this.du[var2];
            int var5 = var3 - iQ;
            int var6 = var4 - iR;
            if (var5 + this.dy[var2] >= 0 && var6 + dx[var2] >= 0 && var5 - this.dy[var2] <= 240 && var6 - dx[var2] <= 320) {
               this.a(var1, this.dq, var2 + 70, var3, var4, 0);
            }
         }
      }
   }

   private void m(Graphics var1) {
      for (int var2 = this.dp; var2 >= 0; var2--) {
         if (this.di[var2] >= 0) {
            int var3 = dl[var2];
            int var4 = dm[var2];
            int var5 = var3 - iQ;
            int var6 = var4 - iR;
            if (var5 + this.do[var2] >= 0 && var6 + this.dn[var2] >= 0 && var5 - this.do[var2] <= 240 && var6 - this.dn[var2] <= 320) {
               this.a(var1, this.dh, var2 + 60, var3, var4, this.dk[var2]);
            }
         }
      }
   }

   private void n(Graphics var1) {
      for (int var2 = eX; var2 >= 0; var2--) {
         if (this.eN[var2] >= 0) {
            int var3 = this.eO[var2];
            int var4 = this.eP[var2];
            int var5 = var3 - iQ;
            int var6 = var4 - iR;
            if (var5 + this.eS[var2] >= 0 && var6 + this.eT[var2] >= 0 && var5 <= 240 && var6 - this.eT[var2] <= 320) {
               this.a(var1, this.eM, var2 + 111, var3, var4, 0);
            }
         }
      }
   }

   private void o(Graphics var1) {
      for (int var2 = this.eZ; var2 >= 0; var2--) {
         if (this.fa[var2] >= 0) {
            int var3 = fd[var2];
            int var4 = this.fe[var2];
            int var5 = var3 - iQ;
            int var6 = var4 - iR;
            if (var5 + (ff[var2] << 1) >= 0 && var6 + this.fg[var2] >= 0 && var5 - ff[var2] <= 240 && var6 - this.fg[var2] <= 320) {
               this.a(var1, this.eY, var2 + 116, var3, var4, 0);
            }
         }
      }
   }

   private void p(Graphics var1) {
      for (int var2 = this.cx; var2 >= 0; var2--) {
         int var3 = this.cy[var2];
         int var4 = cz[var2];
         int var5 = var3 - iQ;
         int var6 = var4 - iR;
         if (var5 + this.cB[var2] >= 0 && var6 + this.cC[var2] >= 0 && var5 - this.cB[var2] <= 240 && var6 - this.cC[var2] <= 320) {
            this.a(var1, cw, var2 + 106, var3, var4, 0);
         }
      }
   }

   private void q(Graphics var1) {
      for (int var2 = cI; var2 >= 0; var2--) {
         if (cT[var2] >= 0) {
            int var3 = cM[var2];
            int var4 = this.cN[var2];
            int var5 = var3 - iQ;
            int var6 = var4 - iR;
            if (var5 + cP[var2] >= 0 && var6 + this.cR[var2] >= 0 && var5 - cP[var2] <= 240 && var6 - this.cR[var2] <= 320) {
               this.a(var1, this.cJ, var2 + 100, var3, var4, 0);
            }
         }
      }
   }

   private void r(Graphics var1) {
      for (int var2 = this.eB; var2 >= 0; var2--) {
         if (this.dP[var2] >= 0) {
            int var3 = dT[var2];
            int var4 = this.dU[var2];
            int var5 = var3 - iQ;
            int var6 = var4 - iR;
            if (var5 + this.ee[var2] >= 0 && var6 + this.ef[var2] >= 0 && var5 - this.ee[var2] <= 240 && var6 - this.ef[var2] <= 320) {
               boolean var7 = this.ej[var2];
               switch (this.dQ[var2]) {
                  case 1:
                     this.a(var1, this.dC, var2 + 85, dT[var2], this.dU[var2], var7 ? 0 : 2);
                     break;
                  case 2:
                     this.a(var1, dD, var2 + 85, dT[var2], this.dU[var2], var7 ? 0 : 2);
                     break;
                  case 3:
                     if (dM == var2) {
                        this.a(var1, this.dF, var2 + 85, dT[var2], this.dU[var2], var7 ? 0 : 2);
                     } else {
                        this.a(var1, this.dE, var2 + 85, dT[var2], this.dU[var2], var7 ? 0 : 2);
                     }
               }

               if (this.dX[var2] > 0) {
                  this.a(var1, this.bH, 137, dT[var2], this.dU[var2], 0);
                  this.b(137, this.L);
               }

               if (I == 100
                  && (
                     this.ge < 0 && this.dX[var2] <= 0 && ek[var2] < en[var2] >> 1 && !this.eh[var2] && ek[var2] >= 0
                        || this.dQ[var2] == 3 && this.dR[var2] == 12 && dM != var2 && this.dN != var2
                        || this.dQ[var2] == 2 && this.dR[var2] == 12 && dM != var2
                  )) {
                  this.a(var1, this.aU, 132, dT[var2], this.dU[var2] - this.ef[var2] - (this.dN == var2 ? -(this.ef[var2] >> 3) : this.ef[var2] >> 2), 0);
               }
            }
         }
      }
   }

   private void s(Graphics var1) {
      this.a(var1, this.fH, 135, this.ga, this.gb, hu ? 0 : 2);
   }

   private void t(Graphics var1) {
      for (int var2 = this.bM; var2 >= 0; var2--) {
         if (bI[var2] >= 0) {
            this.a(var1, this.bH, bI[var2], this.bJ[var2], this.bK[var2], this.bL[var2]);
         }
      }
   }

   private void d(int var1, int var2) {
      switch (var1) {
         case 0:
            for (int var47 = 0; var47 < var2; var47++) {
               int var62 = this.m(10);
               int var76 = this.bs[var47] / 16;
               int var87 = this.bt[var47] / 16;

               for (int var94 = 0; var94 <= var62; var94++) {
                  this.b(var76 + var94, var87, 8192);
               }
            }

            return;
         case 3:
            this.aD = var2;
            this.aH = new boolean[var2];
            this.aG = new boolean[var2];
            this.aE = new int[var2];
            this.aF = new int[var2];

            for (int var23 = 0; var23 < var2; var23++) {
               this.aE[var23] = this.bs[var23];
               this.aF[var23] = this.bt[var23];
               this.aH[var23] = this.m(1) == 1;
               this.aG[var23] = this.m(1) == 1;
            }

            return;
         case 4:
            this.fm = var2 - 1;
            this.ft = new int[var2];
            this.fq = new int[var2];
            this.fr = new int[var2];
            fp = new boolean[var2];
            fs = new int[var2];
            int var46 = 1 << this.bC;

            for (int var61 = 0; var61 < var2; var61++) {
               this.ft[var61] = this.m(3);
               fs[var61] = this.m(10);
               if (this.ft[var61] == 3) {
                  if (fs[var61] > 0) {
                     fs[var61] = -1;
                  } else {
                     fs[var61] = -2;
                  }
               }

               this.fq[var61] = this.bs[var61];
               this.fr[var61] = this.bt[var61];
               if ((fs[var61] != -1 || (he & var46) != var46) && (fs[var61] != -2 || (he & var46 << 10) != var46 << 10)) {
                  fp[var61] = false;
               } else {
                  fp[var61] = true;
                  fs[var61] = 0;
                  this.ft[var61] = this.ft[var61] + 4;
               }

               this.a(121 + var61, 5120, this.ft[var61]);
               if (fp[var61]) {
                  this.b(121 + var61, 2000);
               }

               this.a(this.fl, 121 + var61, 0, 0, 0, this.P);
               this.fn = this.P[2];
               this.fo = this.P[3];
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
               int var75 = this.bs[var45] / 16;
               int var86 = this.bt[var45] / 16;

               for (int var93 = 0; var93 <= var60; var93++) {
                  this.b(var75, var86 + var93, 8);
               }
            }

            return;
         case 6:
            for (int var13 = 0; var13 < 40; var13++) {
               this.aY[var13] = this.m(10);
            }

            for (int var14 = 0; var14 < 40; var14++) {
               this.aZ[var14] = this.m(10);
            }

            return;
         case 7:
            this.fa = new int[var2];
            this.fb = new int[var2];
            fc = new int[var2];
            fd = new int[var2];
            this.fe = new int[var2];
            ff = new int[var2];
            this.fg = new int[var2];
            this.fh = new byte[var2];
            this.fi = new byte[var2];
            fj = new boolean[var2];
            fk = new boolean[var2];

            for (int var44 = 0; var44 < var2; var44++) {
               this.eZ = var44;
               this.fa[var44] = this.m(6) << 1;
               fj[var44] = this.m(1) == 1;
               fk[var44] = this.m(1) == 1;
               this.a(116 + var44, 2048, this.fa[var44]);
               this.a(this.eY, 116 + var44, 0, 0, 0, this.P);
               fd[var44] = this.bs[var44];
               this.fe[var44] = this.bt[var44];
               this.fb[var44] = this.bs[var44] / 16;
               fc[var44] = this.bt[var44] / 16;
               ff[var44] = this.P[2];
               this.fg[var44] = this.P[3];
               this.fh[var44] = (byte)(ff[var44] / 16);
               this.fi[var44] = (byte)(this.fg[var44] / 16);
               int var59 = this.fb[var44];
               int var74 = fc[var44];
               if (!this.b(116 + var44, 1)) {
                  this.j(var44, 2);
                  this.q(var44);
               } else {
                  for (int var85 = 0; var85 < this.fh[var44]; var85++) {
                     for (int var92 = 1; var92 <= this.fi[var44]; var92++) {
                        this.b(var59 + var85, var74 - var92, 1);
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
               this.b(this.cl[var43], cm[var43], 128);
               this.cn[var43] = this.m(10);
               this.co[var43] = this.m(3);
            }

            return;
         case 9:
            this.cX = new byte[var2];
            this.cY = new int[var2];
            cZ = new int[var2];

            for (int var42 = 0; var42 < var2; var42++) {
               int var58 = this.m(10);
               this.cX[var42] = (byte)this.m(3);
               int var73 = this.bs[var42] / 16;
               int var84 = this.bt[var42] / 16;
               this.cY[var42] = var73;
               cZ[var42] = var84;

               for (int var91 = 0; var91 <= var58; var91++) {
                  this.b(var73, var84 + var91, 256);
               }
            }

            return;
         case 10:
            for (int var41 = 0; var41 < var2; var41++) {
               int var57 = this.m(10);
               int var72 = this.bs[var41] / 16;
               int var83 = this.bt[var41] / 16;

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

            for (int var40 = this.eB; var40 < this.eB + var2; var40++) {
               this.dP[var40] = var40;
               dT[var40] = this.bs[var40 - this.eB];
               this.dU[var40] = this.bt[var40 - this.eB];
               this.dZ[var40] = dT[var40] / 16;
               this.ea[var40] = (this.dU[var40] - 1) / 16;
               this.b(this.dZ[var40], this.ea[var40] - 1, 2);
               this.dR[var40] = var28;
               this.dP[var40] = var40;
               this.dQ[var40] = var26;
               eu[var40] = 0;
               dV[var40] = dT[var40];
               dW[var40] = this.dU[var40];
               this.ep[var40] = this.dU[var40] - this.ea[var40] * 16 << 8;
               this.dX[var40] = 0;
               ec[var40] = (byte)this.m(3);
               ed[var40] = ec[var40];
               this.et[var40] = this.m(10) * 1000;
               this.dL = this.m(1) == 1 ? var40 : 0;
               er[var40] = this.et[var40];
               en[var40] = this.m(16);
               ek[var40] = en[var40];
               this.em[var40] = this.m(16);
               this.el[var40] = (byte)this.m(10);
               this.dY[var40] = (byte)this.m(10);
               this.ej[var40] = this.m(1) != 1;
               es[var40] = this.ej[var40];
               ev[var40] = this.m(1) == 1;
               if (var1 == 13) {
                  boolean var56 = this.m(1) == 1;
                  boolean var71 = this.m(1) == 1;
                  if (ev[var40]) {
                     var28 = 1;
                  }

                  if (var56 && !var71) {
                     this.dF = this.b(13313, bG[this.bC] >= 0 ? this.c(13315 + bG[this.bC]) : null);
                     this.g(13312);
                     dM = var40;
                     ek[var40] = ek[var40] << 2;
                     en[var40] = ek[var40];
                  } else if (var71) {
                     this.dF = this.b(14337);
                     this.g(14336);
                     this.dN = var40;
                     dM = var40;
                     ek[var40] = ek[var40] << 2;
                     en[var40] = ek[var40];
                  } else {
                     this.g(15360);
                  }
               } else if (ev[var40]) {
                  var28 = 1;
               }

               this.i(var28, var40);
               this.a(var22, 85 + var40, 0, 0, 0, this.P);
               this.ee[var40] = (short)this.P[2];
               eb[var40] = (byte)(this.ee[var40] / 16 >> 1);
               if (eb[var40] == 0) {
                  eb[var40] = 1;
               }

               this.ef[var40] = (short)this.P[3];
               this.eg[var40] = (byte)(this.ef[var40] / 16);
            }

            this.eB += var2;
            return;
         case 14:
            this.eC = new int[var2];
            this.eD = new int[var2];
            this.eE = new int[var2 * 15];
            this.eF = new int[var2 * 15];
            this.eG = new boolean[var2 * 15];

            for (int var39 = 0; var39 < var2; var39++) {
               int var55 = this.m(10);
               this.eC[var39] = this.bs[var39] / 16;
               this.eD[var39] = this.bt[var39] / 16;

               for (int var69 = 0; var69 < 15; var69++) {
                  if (var69 < 15) {
                     this.eE[var69 + var39 * 15] = this.m(10);
                     this.eF[var69 + var39 * 15] = this.m(10);
                     this.eG[var69 + var39 * 15] = this.m(1) != 1;
                  } else {
                     this.m(10);
                     this.m(10);
                     this.m(1);
                  }
               }

               for (int var70 = 0; var70 < var55; var70++) {
                  this.b(this.eC[var39], this.eD[var39] + var70, 4);
               }
            }

            return;
         case 17:
            ck = var2 - 1;

            for (int var21 = 0; var21 < var2; var21++) {
               this.cf[var21] = this.m(6);
               this.cg[var21] = this.bs[var21];
               ch[var21] = this.bt[var21];
               this.a(40 + var21, 3072, this.cf[var21]);
               this.a(this.ce, 40 + var21, 0, 0, 0, this.P);
               this.cj[var21] = this.P[2];
               this.ci[var21] = this.P[3];
            }

            return;
         case 18:
            for (int var38 = 0; var38 < var2; var38++) {
               int var54 = this.m(10);
               int var68 = this.bs[var38] / 16;
               int var82 = this.bt[var38] / 16;

               for (int var89 = 0; var89 <= var54; var89++) {
                  this.b(var68 + var89, var82, 16);
               }
            }

            return;
         case 21:
            this.dp = var2 - 1;

            for (int var37 = 0; var37 < var2; var37++) {
               this.di[var37] = this.m(6) << 1;
               dl[var37] = this.bs[var37];
               dm[var37] = this.bt[var37];
               this.dk[var37] = 0;
               this.a(60 + var37, 5121, this.di[var37]);
               this.a(this.dh, 60 + var37, 0, 0, 0, this.P);
               this.do[var37] = this.P[2];
               this.dn[var37] = this.P[3];
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

               int var20 = this.bs[var15] / 16;
               int var25 = this.bt[var15] / 16;
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
            this.eI = new int[var2];
            this.eJ = new int[var2];
            this.eK = new int[var2];
            eL = new byte[var2];
            this.br = var2;

            for (int var18 = var2 - 1; var18 >= 0; var18--) {
               this.eI[var18] = this.m(8);
               this.eJ[var18] = this.bs[var2 - var18 - 1];
               this.eK[var18] = this.bt[var2 - var18 - 1];
               eL[var18] = (byte)this.m(3);
            }

            return;
         case 25:
            for (int var35 = 0; var35 < var2; var35++) {
               this.b(this.bs[var35] / 16, this.bt[var35] / 16, 1024);
            }

            return;
         case 26:
            this.fW = this.bs[0];
            this.fX = this.bt[0];
            this.fY = this.fW;
            this.fZ = this.fX;
            this.gu = false;
            this.gn = false;
            this.hj = this.hm;
            hl = this.hn;
            this.hw = false;
            gg = false;
            this.ga = this.fW;
            this.gb = this.fX;
            return;
         case 27:
            eX = var2 - 1;
            this.eN = new int[var2];
            this.eO = new int[var2];
            this.eP = new int[var2];
            eQ = new int[var2];
            this.eR = new int[var2];
            this.eS = new int[var2];
            this.eT = new int[var2];
            this.eU = new byte[var2];
            this.eV = new byte[var2];
            eW = new boolean[var2];

            for (int var34 = 0; var34 < var2; var34++) {
               this.eN[var34] = this.m(3);
               eW[var34] = this.m(1) == 1;
               this.a(111 + var34, 6144, this.eN[var34]);
               this.a(this.eM, 111 + var34, 0, 0, 0, this.P);
               this.eO[var34] = this.bs[var34];
               this.eP[var34] = this.bt[var34];
               eQ[var34] = this.bs[var34] / 16;
               this.eR[var34] = this.bt[var34] / 16;
               this.eS[var34] = this.P[2];
               this.eT[var34] = this.P[3];
               this.eU[var34] = (byte)(this.eS[var34] / 16);
               this.eV[var34] = (byte)(this.eT[var34] / 16);
               int var52 = eQ[var34];
               int var66 = this.eR[var34];

               for (int var77 = 0; var77 < this.eU[var34]; var77++) {
                  for (int var88 = 1; var88 <= this.eV[var34]; var88++) {
                     this.b(var52 + var77, var66 - var88, 1);
                     this.b(var52 + var77, var66 - var88, 512);
                     if (eW[var34]) {
                        this.b(var52 + var77, var66 - var88, 8);
                     }
                  }
               }

               this.b(var52, var66, 1);
            }

            return;
         case 28:
            this.db = new int[var2];
            this.da = new int[var2];
            this.dc = new int[var2];
            dd = new int[var2];
            this.de = new int[var2];
            df = new int[var2];
            this.dg = new int[var2];

            for (int var33 = 0; var33 < var2; var33++) {
               this.da[var33] = this.bs[var33] / 16;
               this.db[var33] = this.bt[var33] / 16;
               this.dc[var33] = this.m(10);
               dd[var33] = this.m(10);
               this.de[var33] = this.m(3);
               this.dg[var33] = this.m(10);
               df[var33] = 0;

               for (int var51 = 0; var51 <= this.dc[var33]; var51++) {
                  for (int var65 = 0; var65 <= dd[var33]; var65++) {
                     this.b(this.da[var33] + var51, this.db[var33] + var65, 32);
                  }
               }
            }

            return;
         case 29:
            for (int var32 = 0; var32 < var2; var32++) {
               int var50 = this.m(10);
               int var64 = this.bs[var32] / 16;
               int var11 = this.bt[var32] / 16;

               for (int var12 = 0; var12 <= var50; var12++) {
                  this.b(var64 + var12, var11, 16384);
               }
            }

            return;
         case 30:
            for (int var31 = 0; var31 < var2; var31++) {
               if (this.m(1) != 0) {
                  this.b(this.bs[var31] / 16, this.bt[var31] / 16, 2048);
               } else {
                  this.b(this.bs[var31] / 16, this.bt[var31] / 16, 4096);
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

               int var24 = this.bs[var17] / 16;
               int var7 = this.bt[var17] / 16;
               this.b(var24, var7, var4);
            }

            return;
         case 32:
            bW = var2 - 1;

            for (int var16 = 0; var16 < var2; var16++) {
               this.bO[var16] = this.m(6) << 1;
               bP[var16] = this.bs[var16];
               this.bQ[var16] = this.bt[var16];
               this.bV[var16] = this.m(1) == 1;
               this.a(30 + var16, 5122, this.bO[var16]);
               this.b(this.ht, 30 + var16, 0);
               bR[var16] = this.ht[0] + bP[var16];
               this.bS[var16] = this.ht[1] + this.bQ[var16];
               this.bU[var16] = this.ht[2];
               this.bT[var16] = this.ht[3];
            }

            return;
         case 33:
            this.dz = var2 - 1;

            for (int var30 = 0; var30 < var2; var30++) {
               this.dr[var30] = this.m(6);
               this.ds[var30] = this.m(10);
               int var49 = this.m(3) * 100;
               dt[var30] = this.bs[var30];
               this.du[var30] = this.bt[var30];
               this.dv[var30] = this.bs[var30];
               this.dw[var30] = this.bt[var30];
               this.a(70 + var30, 6145, this.dr[var30]);
               this.a(this.dq, 70 + var30, 0, 0, 0, this.P);
               this.b(70 + var30, var49);
               this.dy[var30] = this.P[2];
               dx[var30] = this.P[3];
            }

            return;
         case 34:
            this.cx = var2 - 1;
            this.cy = new int[var2];
            cz = new int[var2];
            this.cD = new boolean[var2];
            cG = new int[var2];
            this.cF = new int[var2];
            this.cH = new int[var2 + 1 << 2];
            cE = new int[var2];
            this.cB = new int[var2];
            this.cA = new boolean[var2];
            this.cC = new int[var2];

            for (int var29 = 0; var29 < var2; var29++) {
               int var48 = this.bs[var29] / 16;
               int var63 = this.bt[var29] / 16;
               this.cy[var29] = var48 * 16;
               cz[var29] = var63 * 16;
               this.cF[var29] = var48;
               cG[var29] = var63;
               this.cD[var29] = false;
               this.cA[var29] = this.m(1) == 1;
               cE[var29] = 0 + (this.cA[var29] ? 4 : 0);
               this.cH[var29 << 2] = this.m(3);
               this.cH[(var29 << 2) + 1] = this.m(3);
               this.cH[(var29 << 2) + 2] = this.m(3);
               this.cH[(var29 << 2) + 3] = this.m(3);
               this.a(106 + var29, 2050, cE[var29]);
               this.a(cw, 106 + var29, 0, 0, 0, this.P);
               this.cB[var29] = this.P[2];
               this.cC[var29] = this.P[3];
            }

            return;
         case 35:
            cI = var2 - 1;
            cM = new int[var2];
            this.cN = new int[var2];
            cK = new int[var2];
            cL = new int[var2];
            cV = new boolean[var2];
            this.cS = new int[var2];
            cT = new int[var2];
            this.cU = new int[var2];
            cO = new int[var2];
            this.cQ = new int[var2];
            cP = new int[var2];
            this.cR = new int[var2];
            this.cW = new boolean[var2];

            for (int var8 = 0; var8 < var2; var8++) {
               cM[var8] = this.bs[var8];
               this.cN[var8] = this.bt[var8];
               cK[var8] = this.bs[var8] / 16;
               cL[var8] = this.bt[var8] / 16;
               this.cS[var8] = this.m(3);
               this.cU[var8] = this.m(10);
               cV[var8] = this.m(1) == 1;
               this.cW[var8] = this.m(1) == 1;
               cT[var8] = (this.cU[var8] << 2) + 0;
               this.a(100 + var8, 2049, cT[var8]);
               this.a(this.cJ, 100 + var8, 0, 0, 0, this.P);
               cO[var8] = this.P[2] / 16;
               this.cQ[var8] = this.P[3] / 16;
               cP[var8] = this.P[2];
               this.cR[var8] = this.P[3];
               cT[var8] = (this.cU[var8] << 2) + 2 - (cV[var8] ? 2 : 0);
               this.a(100 + var8, 2049, cT[var8]);

               for (int var9 = 0; var9 < this.cQ[var8]; var9++) {
                  for (int var10 = 0; var10 < cO[var8]; var10++) {
                     if (cV[var8]) {
                        this.c(cK[var8] + var10, cL[var8] - var9, 1);
                     } else {
                        this.b(cK[var8] + var10, cL[var8] - var9, 1);
                     }
                  }
               }
            }

            return;
         case 36:
            cd = var2 - 1;

            for (int var5 = 0; var5 < var2; var5++) {
               this.bY[var5] = this.m(6);
               bZ[var5] = this.bs[var5];
               ca[var5] = this.bt[var5];
               this.a(10 + var5, 3074, this.bY[var5]);
               this.a(this.bX, 10 + var5, 0, 0, 0, this.P);
               this.cc[var5] = this.P[2];
               this.cb[var5] = this.P[3];
            }
      }
   }

   private void a(byte[] var1, boolean var2) {
      switch (this.u) {
         case 0:
            if (!var2) {
               this.iO = null;
               this.iW = null;
               this.iV = null;
            }

            for (int var3 = 0; var3 < 10; var3++) {
               bI[var3] = -1;
            }

            this.a(var1);
            this.m(1);
            this.m(10);
            this.c(var2);
            this.m(1);
            this.bw = this.m(16);
            this.bx = this.m(4);
            int[] var10 = new int[this.bw];

            for (int var4 = 0; var4 < this.bw; var4++) {
               var10[var4] = this.m(this.bx);
            }

            this.by = l(this.bw);
            int var13 = 0;
            int var5 = 0;
            if (var2 && iY != 0) {
               var13 = iY;
               var5 = iX;
            }

            iX = this.m(16);
            iY = this.m(16);
            if (!var2) {
               this.bu = 16 * iX;
               this.bv = 16 * iY;
               this.aB = this.bu - 240;
               this.aC = this.bv - 320;
            }

            iZ = iX * iY;
            if (!var2) {
               this.iW = new short[iZ];
            }

            this.iV = new byte[iZ];

            for (int var6 = 0; var6 < this.iV.length; var6++) {
               this.iV[var6] = (byte)this.m(this.by);
            }

            this.m(8);
            this.b(this.bw, var2);
            this.iO = b.a(240, 320);
            this.iO.a(iX, iY, this.iP, 16, 16);
            int var7 = 0;

            for (int var8 = 0; var8 < iY; var8++) {
               for (int var9 = 0; var9 < iX; var9++) {
                  this.iO.a(var9, var8, 1 + var10[this.iV[var7] & 0xFF]);
                  var7++;
               }
            }

            this.iV = null;
            this.bw = this.m(10);
            if (!var2) {
               ja = iX * 16;
               jb = iY * 16;
            }

            this.bz = l(ja * jb + 1);
            ja = iX * 16;
            jb = iY * 16;
            if (var2 && var13 != 0) {
               iY = var13;
               iX = var5;
            }
         case 1:
         default:
            break;
         case 2:
            if (!var2) {
               this.eY = this.b(2051, bG[this.bC] >= 0 ? this.c(2059 + bG[this.bC]) : null);
            }
            break;
         case 3:
            if (!var2) {
               this.fH = this.b(28673, bG[this.bC] >= 0 ? this.c(28675 + bG[this.bC]) : null);
            }
            break;
         case 4:
            if (!var2) {
               this.eH = this.b(3076, bG[this.bC] >= 0 ? this.c(3084 + bG[this.bC]) : null);
            }
            break;
         case 5:
            if (!var2) {
               if (this.dA) {
                  this.dC = this.b(18433, bG[this.bC] >= 0 ? this.c(18435 + bG[this.bC]) : null);
                  this.g(18432);
               } else {
                  this.dC = this.b(4097, bG[this.bC] >= 0 ? this.c(4099 + bG[this.bC]) : null);
                  this.g(4096);
               }

               if (this.dB) {
                  dD = this.b(16385, bG[this.bC] >= 0 ? this.c(16387 + bG[this.bC]) : null);
                  this.g(16384);
               } else {
                  dD = this.b(17409, bG[this.bC] >= 0 ? this.c(17411 + bG[this.bC]) : null);
                  this.g(17408);
               }

               this.dE = this.b(15361, bG[this.bC] >= 0 ? this.c(15363 + bG[this.bC]) : null);
               this.g(15360);
            }
            break;
         case 6:
            if (!var2) {
               this.bN = this.b(5125, bG[this.bC] >= 0 ? this.c(5142 + bG[this.bC]) : null);
               this.dh = this.b(5124, bG[this.bC] >= 0 ? this.c(5132 + bG[this.bC]) : null);
               this.eM = this.b(6146, bG[this.bC] >= 0 ? this.c(6150 + bG[this.bC]) : null);
            }
            break;
         case 7:
            if (!var2) {
               this.dq = this.b(6147, bG[this.bC] >= 0 ? this.c(6153 + bG[this.bC]) : null);
               this.fl = this.b(5123, bG[this.bC] >= 0 ? this.c(5129 + bG[this.bC]) : null);
            }
            break;
         case 8:
            if (!var2) {
               this.cJ = this.b(2052, bG[this.bC] >= 0 ? this.c(2062 + bG[this.bC]) : null);
               cw = this.b(2053, bG[this.bC] >= 0 ? this.c(2065 + bG[this.bC]) : null);
            }
            break;
         case 9:
            if (!var2) {
               this.bX = this.b(3077, bG[this.bC] >= 0 ? this.c(3087 + bG[this.bC]) : null);
               this.ce = this.b(3075, bG[this.bC] >= 0 ? this.c(3081 + bG[this.bC]) : null);
               this.bH = this.b(7169, null);
               this.a(137, 7168, 31);
            }
      }

      if (this.u == 10 && !var2 || var2) {
         this.br = 0;
         if (!var2) {
            this.iO.a(1000);
         }

         this.hN = 0;

         while (this.bw-- > 0) {
            int var11 = this.m(10);
            int var14 = this.m(16);
            int var15 = 0;
            this.bs = new int[var14];
            this.bt = new int[var14];
            int var16 = 0;

            for (int var17 = 0; var17 < var14; var17++) {
               for (var15 += this.m(this.bz); var15 >= ja; var16++) {
                  var15 -= ja;
               }

               this.bs[var17] = var15;
               this.bt[var17] = var16;
            }

            this.d(var11, var14);
         }

         for (int var12 = this.fm; var12 >= 0; var12--) {
            if (fp[var12]) {
               this.e(this.fq[var12] / 16, this.fr[var12] / 16);
            }
         }

         this.jc = null;
         this.s();
         this.F();
         this.a((DataInputStream)null);
      }

      this.u++;
   }

   private void s() {
      short[] var1 = new short[256];
      int var2 = 0;

      for (int var3 = 0; var3 < this.br; var3++) {
         this.a(136, 3073, this.eI[var3]);
         var2 += this.a(var1, 136, 0);
      }

      this.iO.a(this.br + var2, iX <= iY);

      for (int var7 = 0; var7 <= 7; var7++) {
         for (int var4 = this.br - 1; var4 >= 0; var4--) {
            if (eL[var4] == var7) {
               this.a(136, 3073, this.eI[var4]);
               int var5 = this.a(var1, 136, 0);

               for (int var6 = 0; var6 < var5; var6++) {
                  this.iO.a(this.eH[var1[var6 * 4]], this.eJ[var4] + var1[var6 * 4 + 1], this.eK[var4] + var1[var6 * 4 + 2], var1[var6 * 4 + 3]);
               }
            }
         }
      }

      this.eJ = null;
      this.eK = null;
      this.eI = null;
      eL = null;
   }

   private void c(boolean var1) {
      if (!var1) {
         this.Q = this.m(10);
         hu = this.m(1) != 1;
         this.hv = hu;
         this.dA = this.m(1) == 1;
         this.dB = this.m(1) == 1;
         this.m(1);
         int var2 = this.m(16);
         this.hs = this.hs < var2 ? var2 : this.hs;
      }
   }

   private static int l(int var0) {
      int var1 = -1;

      while (var0 - 1 >> ++var1 > 0) {
      }

      return var1;
   }

   private void a(byte[] var1) {
      this.jc = var1;
      this.jd = 0;
      this.je = 0;
      this.jf = 0;
   }

   private int m(int var1) {
      int var2 = 0;
      int var3 = var1;

      while (var3 > 0) {
         if (this.jf == 0) {
            this.je = this.jc[this.jd++] & 255;
            this.jf = 8;
         }

         int var4 = Math.min(var3, this.jf);
         var2 |= (this.je >> 8 - this.jf & ~(-1 << var4)) << var1 - var3;
         this.jf -= var4;
         var3 -= var4;
      }

      return var2;
   }

   private void b(int var1, boolean var2) {
      for (int var3 = 0; var3 < var1; var3++) {
         for (int var4 = 0; var4 < 1; var4++) {
            if (this.m(1) == 1 && !var2) {
               this.iW[var3] = (short)(this.iW[var3] | 1 << var4);
            }
         }
      }

      if (!var2) {
         this.iP = this.c(2058, bG[this.bC] >= 0 ? this.c(2068 + bG[this.bC]) : null);
      }
   }

   private void n(int var1) {
      this.a(0 + this.bM, 0 + bI[var1]);
      this.bL[var1] = this.bL[this.bM];
      this.bJ[var1] = this.bJ[this.bM];
      this.bK[var1] = this.bK[this.bM];
      bI[this.bM] = -1;
      if (this.bM >= 0) {
         this.bM--;
      }
   }

   private void o(int var1) {
      if (this.bO[bW] >= 0) {
         this.a(bW + 30, var1 + 30);
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
         this.a(this.dp + 60, var1 + 60);
      }

      this.di[var1] = this.di[this.dp];
      dl[var1] = dl[this.dp];
      dm[var1] = dm[this.dp];
      this.dk[var1] = this.dk[this.dp];
      this.dj[var1] = this.dj[this.dp];
      this.dn[var1] = this.dn[var1];
      this.do[var1] = this.do[var1];
      this.di[this.dp] = -1;
      if (this.dp >= 0) {
         this.dp--;
      }
   }

   private void q(int var1) {
      if (this.fa[this.eZ] >= 0) {
         this.a(this.eZ + 116, var1 + 116);
      }

      this.fa[var1] = this.fa[this.eZ];
      fd[var1] = fd[this.eZ];
      this.fe[var1] = this.fe[this.eZ];
      this.fb[var1] = this.fb[this.eZ];
      fc[var1] = fc[this.eZ];
      this.fh[var1] = this.fh[this.eZ];
      this.fi[var1] = this.fi[this.eZ];
      this.fa[this.eZ] = -1;
      if (this.eZ >= 0) {
         this.eZ--;
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
      int var3 = this.fG << 2;
      System.arraycopy(fy, var3, fy, var2, 4);
      System.arraycopy(fz, var3, fz, var2, 4);
      fD[var1] = fD[this.fG];
      fA[var1] = fA[this.fG];
      fB[var1] = fB[this.fG];
      fC[var1] = fC[this.fG];
      fE[var1] = fE[this.fG];
      fF[var1] = fF[this.fG];
      if (this.fG >= 0) {
         this.fG--;
      }
   }

   private void b(int var1, int var2, int var3, int var4) {
      if (var4 != 0 && (var3 != 0 || hr < this.hs)) {
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
            for (int var8 = this.eB; var8 >= 0; var8--) {
               if (a(iQ - 64, iR - 64, 368, 448, dT[var8] - this.ee[var8], this.dU[var8] - this.ef[var8], this.ee[var8] << 1, this.ef[var8])) {
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

            hl -= 256;
            if (hl <= 0) {
               hl = 0;
               this.A();
            }
         }

         int var13 = 0;
         boolean var9 = false;

         while (!var9) {
            this.N = O.nextInt();
            if (this.fG >= 18 && var4 > 0) {
               var9 = true;
               fF[this.fG - 1] = fF[this.fG - 1] + var4;
               var4 = 0;
            } else {
               this.fG++;
               int var10 = this.fG << 2;
               int var11 = (this.N & 128) > 0 ? 1 : -1;
               int var12 = var1 + var11 * (this.N & 9);
               fy[var10++] = var12;
               fy[var10++] = var12;
               fy[var10++] = var12;
               fy[var10++] = var12;
               var10 -= 4;
               fA[this.fG] = var11 * (this.N & 7) << 8;
               var11 = (this.N & 256) > 0 ? 1 : -1;
               var12 = var2 + var11 * (this.N & 9) - 7;
               fz[var10++] = var12;
               fz[var10++] = var12;
               fz[var10++] = var12;
               fz[var10] = var12;
               fB[this.fG] = (this.N >> 3 & 7) << 8;
               fE[this.fG] = var3;
               fD[this.fG] = 0;
               if (var3 == 3) {
                  fC[this.fG] = this.P[var13];
                  if (++var13 > var7) {
                     var13 = 0;
                  }
               } else {
                  fC[this.fG] = -1;
               }

               if (var4 > 24) {
                  fF[this.fG] = var5;
                  var4 -= var5;
               } else {
                  fF[this.fG] = var6;
                  var4 -= var6;
               }

               if (var4 < 0) {
                  fF[this.fG] = fF[this.fG] + var4;
                  var4 = 0;
                  var9 = true;
               }
            }
         }
      }
   }

   private void t() {
      this.gi = false;
      this.ge = -1;
      fR = false;
      this.aR = false;
      this.hw = false;
      this.A();
      this.gw = this.ga / 16;
      gx = this.gb / 16;
      this.hj = this.hm;
      this.hk = this.hj;
      iQ = this.ga - 120 - ((hu ? 1 : -1) * 240 >> 2);
      iR = this.gb - 266;
      this.aO = iQ << 8;
      this.aP = iR << 8;
      this.gJ = -1;
      this.gK = -1;
      this.s(0);
      this.a(133, 1025, 4);
      this.a(this.fH, 135, 0, 0, 0, this.P);
      this.hi = this.gb % 16;
      hh = this.ga % 16;
      gC = this.P[2] >> 1;
      this.gD = this.P[3];
      this.hg = this.gD / 16;
      this.hx = gC >> 1;
      this.hy = -(gC >> 1);
   }

   private void f(int var1, int var2) {
      if (super.a != 0) {
         this.ga = this.ga + ((!hu || super.a <= 0) && (hu || super.a >= 0) ? this.hy : this.hx - 1);
      }

      if (super.b < 0) {
         this.gb = this.gb - this.gD;
      } else {
         this.gb--;
      }

      int var5 = var1;
      int var6 = this.y();
      hh = this.ga - var5 * 16 << 8;
      if (hh <= 0) {
         var5--;
         hh += 4096;
      } else if (hh >= 4096) {
         var5++;
         hh -= 4096;
      }

      this.hi = this.gb - var6 * 16 << 8;
      if (super.a != 0) {
         this.ga = this.ga - ((!hu || super.a <= 0) && (hu || super.a >= 0) ? this.hy : this.hx - 1);
      }

      if (super.b < 0) {
         this.gb = this.gb + this.gD;
      } else {
         this.gb++;
      }

      int var7 = (super.a > 0 ? super.a : -super.a) << 8;
      int var8 = (super.b > 0 ? super.b : -super.b) << 8;
      int var9 = var7;
      int var10 = var8;
      this.hC = true;
      hD = true;
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
      if ((!hu || super.a <= 0) && (hu || super.a >= 0)) {
         var3 = -var7;
      } else {
         var3 = var7;
      }

      int var4 = super.b > 0 ? var8 : -var8;
      int var11 = 0;
      int var12 = 0;
      this.hI = 0;
      this.hJ = 0;

      while (var11 < var9 || var12 < var10) {
         hh += var3;
         this.hi += var4;
         if (hh >= 4096) {
            hh -= 4096;
            var5++;
         } else if (hh < 0) {
            hh += 4096;
            var5--;
         }

         if (this.hi >= 4096) {
            this.hi -= 4096;
            var6++;
         } else if (this.hi < 0) {
            this.hi += 4096;
            var6--;
         }

         this.g(var5, var6);
         if ((this.h(var5, var6) & 32) == 0) {
            this.gK = -1;
            this.gJ = -1;
         } else {
            this.iB = true;
            if (this.gJ == -1) {
               for (int var13 = 0; var13 < this.da.length; var13++) {
                  if (a(var1, var2, this.da[var13], this.db[var13], this.dc[var13], dd[var13])) {
                     if (df[var13] < this.dg[var13] && this.dg[var13] > 0 && this.gK <= 0) {
                        this.gJ = var13;
                        this.gK = 2000;
                        if (df[0] < this.dg[var13]) {
                           gM = true;
                        }
                     } else {
                        this.gK = -1;
                        this.gJ = -1;
                        this.iB = true;
                     }
                  }
               }
            }
         }

         if (this.hC) {
            this.hI += var3;
            var11 += var7;
         } else {
            hh -= var3;
            var9 = var11;
            if ((this.h(var1, var2) & 1) != 0 && !this.hF) {
               this.hI = 0;
               if ((!hu || super.a <= 0) && (hu || super.a >= 0)) {
                  this.ga = var1 * 16 + (gC >> 1);
               } else {
                  this.ga = (var1 + 1) * 16 - (gC >> 1);
               }
            }
         }

         if (hD) {
            this.hJ += var4;
            var12 += var8;
         } else {
            this.hi -= var4;
            var10 = var12;
            if (super.b < 0 && this.gn) {
               var6 += this.hg + 1;
            }
         }
      }

      this.ga = this.ga + (this.hI >> 8);
      this.gb = this.gb + (this.hJ >> 8);
      if (var11 > var9) {
         int var14 = var11 - var9 >> 8;
         this.ga -= var3 > 0 ? var14 : -var14;
      }

      if (var12 > var10) {
         int var15 = var12 - var10 >> 8;
         this.gb -= var4 > 0 ? var15 : -var15;
      }

      if (!this.hC) {
         if (hh < 0) {
            var5--;
         } else if (hh > 16) {
            var5++;
         }
      }

      this.gw = var5;
      gx = var6;
   }

   private boolean u() {
      int var1 = (!hu || this.hA != 22) && (hu || this.hA != 23) ? -1 : 1;
      byte var2 = 0;
      if (this.gl == 1) {
         var2 = 1;
      }

      int var3 = eQ[gd] + (var1 < 0 ? this.eU[gd] - 1 : 0);
      int var4 = gx;
      int var5 = this.eV[gd];
      if (this.hA == 23 && var5 <= this.hg) {
         var5 = this.hg + 1;
      }

      for (int var6 = 0; var6 < var5; var6++) {
         if ((this.h(var3 + var1 + var1, var4 - var6) & 1) != 0) {
            return false;
         }

         if (this.hA == 23 && ((this.h(var3 + var1 + var1 + var1, var4 - var6) & 1) != 0 || (this.h(var3 + var1 + var1 + var1 + var1, var4 - var6) & 1) != 0)) {
            return false;
         }

         if ((this.h(var3 + var1 * (this.eU[gd] + var2), var4 - var6) & 1) != 0) {
            var2 = 0;
         }
      }

      if (this.hA == 23 && (this.h(this.gw + var1, var4) & 1) != 0) {
         return false;
      }

      for (int var8 = 0; var8 < this.eU[gd]; var8++) {
         for (int var7 = 0; var7 < this.eV[gd]; var7++) {
            this.c(eQ[gd] + var8, var4 - var7, 1);
            this.c(eQ[gd] + var8, var4 - var7, 512);
            if (eW[gd]) {
               this.c(eQ[gd] + var8, var4 - var7, 8);
            }
         }
      }

      eQ[gd] = eQ[gd] + (var1 > 0 ? 1 + var2 : -(1 + var2));

      for (int var9 = 0; var9 < this.eU[gd]; var9++) {
         for (int var10 = 0; var10 < this.eV[gd]; var10++) {
            this.b(eQ[gd] + var9, var4 - var10, 1);
            this.b(eQ[gd] + var9, var4 - var10, 512);
            if (eW[gd]) {
               this.b(var3 + var9 + var2 + this.eU[gd] * var1, var4 - var10, 8);
            }
         }
      }

      this.hG = true;
      this.a(111 + gd, 6144, this.eN[gd] + (3 << var2));
      return true;
   }

   private void g(int var1, int var2) {
      boolean var3 = hu && super.a > 0 || !hu && super.a < 0;
      if ((this.h(var1, var2) & 1024) != 0) {
         this.fY = var1 * 16;
         this.fZ = var2 * 16;
         this.hv = hu;
      }

      if ((this.h(var1, var2) & 256) != 0) {
         int var4 = var2;

         while ((this.h(var1, var4) & 256) != 0) {
            var4--;
         }

         var4++;

         for (int var5 = 0; var5 < this.cX.length; var5++) {
            if (this.cY[var5] == var1 && cZ[var5] == var4) {
               for (int var6 = 0; var6 < cV.length; var6++) {
                  if (this.cS[var6] == this.cX[var5]) {
                     cV[var6] = !cV[var6];
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

         for (int var7 = 0; var7 < this.eC.length; var7++) {
            if (this.eC[var7] == var1 && this.eD[var7] == var15) {
               var26 = var7;
               break;
            }
         }

         for (int var29 = 0; var29 <= this.eB; var29++) {
            ec[var29] = ed[var29];
            if (this.eE[this.dY[var29] + var26 * 15] != 0) {
               dV[var29] = this.eE[this.dY[var29] + var26 * 15] * 16;
               dW[var29] = this.eF[this.dY[var29] + var26 * 15] * 16;
               es[var29] = this.eG[this.dY[var29] + var26 * 15];
               if (!a(iQ - 64, iR - 64, 368, 448, dT[var29] - this.ee[var29], this.dU[var29] - this.ef[var29], this.ee[var29] << 1, this.ef[var29])) {
                  ek[var29] = en[var29];
                  dT[var29] = dV[var29];
                  this.dU[var29] = dW[var29];
                  this.c(this.dZ[var29], this.ea[var29] - 1, 2);
                  this.dZ[var29] = dT[var29] / 16;
                  this.ea[var29] = this.dU[var29] / 16;
                  this.b(this.dZ[var29], this.ea[var29] - 1, 2);
                  switch (this.dQ[var29]) {
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
      this.hE = false;

      for (int var24 = this.gD; var24 > 0; var24 -= 16) {
         if (var2 < iY) {
            if (var2 - var17 < 0 || var2 - var17 >= iY) {
               this.hC = false;
               break;
            }

            if (var24 > 0) {
               if (this.hC && var1 >= 0) {
                  this.hC = (this.h(var1, var2 - var17) & 1) == 0;
               } else {
                  this.hC = false;
               }

               if (!this.hC) {
                  if (this.hA != 22 && this.gt && (this.h(var1, var2 - var17) & 512) != 0) {
                     int var27 = hu ? 1 : -1;
                     int var30 = 0;

                     while ((this.h(var1 + var30, var2) & 512) != 0 && !hu) {
                        var30 += var27;
                     }

                     var30 += hu ? 0 : 1;

                     for (int var8 = eX; var8 >= 0; var8--) {
                        if (eQ[var8] == var1 + var30 && this.eR[var8] == var2 + 1) {
                           this.hF = true;
                           this.ga = var1 * 16 + (!hu ? this.hx : this.hy);
                           this.s(21);
                           gd = var8;
                        }
                     }
                  }
                  break;
               }
            }

            if (var1 < 0 || var1 >= iX) {
               this.hC = false;
            }

            if (super.b >= 0) {
               var17++;
            } else {
               var17--;
            }

            if (gq && var24 - 16 <= 0 && super.b == 0 && (this.h(var1, var2 - var17) & 16) == 0) {
               this.hC = false;
               this.s(26);
               this.gb++;
            }
         }
      }

      int var25 = var1;
      if (super.a == 0 && super.b != 0) {
         var25 += hu ? 1 : -1;
      }

      if (super.b >= 0) {
         var17 = this.hg;
         if (this.hi < 2048) {
            var17++;
         }
      } else {
         var17 = 0;
      }

      int var28 = var2 - var17;
      int var32 = hu ? -1 : 1;
      if (this.hj > 0
         && !this.gv
         && (this.h(var25, var28 - 1) & 1) == 0
         && ((this.h(var25, var28) & 1) != 0 || this.gu)
         && (this.h(var25 + var32, var28) & 1) == 0
         && (this.h(var25 + var32, var28 - 1) & 1) == 0
         && (this.h(var25 + var32, var28 + this.hg) & 1) == 0
         && super.b != 0
         && (!this.gn || this.gu)
         && !gr
         && !this.gy
         && I != 105) {
         if (this.gu && super.b < 0) {
            this.s(38);
            int var34 = 0;
            if ((this.h(var25, var2) & 1) == 0) {
               var34++;
            }

            this.gb = (var2 + var34) * 16 + this.gD;
         } else if (this.hA != 40 && !this.gn) {
            this.s(37);
            this.gb = (var2 - var17) * 16 + this.gD;
         }

         this.hJ = 0;
         if (!hu) {
            var25++;
         }

         this.ga = var25 * 16 + (hu ? -(gC >> 1) : gC >> 1);
         this.hI = 0;
         hD = false;
         this.hC = false;
      } else {
         if (!this.hC && super.a != 0) {
            var17 = var3 ? -1 : 1;
         } else {
            var17 = 0;
         }

         int var33 = var2;
         int var9;
         if ((var9 = super.b > 0 ? var33 - this.hg : var33 + this.hg) < 0) {
            var9 = 0;
         }

         if (super.b != 0) {
            boolean var10 = false;

            for (int var11 = gC; var11 > 0; var11 -= 16) {
               if (var1 + var17 >= 0 && var1 + var17 < iX) {
                  if (hD) {
                     hD = (this.h(var1 + var17, var33) & 1) == 0;
                     if (((this.h(var1 + var17, var9) & 16) != 0 || (this.h(var1 + var17, var9) & 8192) != 0) && hB != 121 && this.hA != 38 && this.hj > 0) {
                        if ((this.h(var1 + var17, var9) & 8192) != 0 && hB != 24 && hB != 25 && !this.gp) {
                           this.s(120);
                           this.gb = (var9 + 1) * 16 + this.gD;
                           hD = false;
                           this.hJ = 0;
                           this.gz = true;
                        } else if ((this.h(var1 + var17, var9) & 16) != 0) {
                           this.gb = (var9 + 1) * 16 + this.gD;
                           hD = false;
                           this.hJ = 0;
                           this.s(45);
                        }
                     }
                  }

                  if (!hD && super.b > 0 && !gq && this.hA != 38) {
                     this.gb = var2 * 16;
                     this.hJ = 0;
                     this.hE = true;
                     int var12 = var1;
                     if ((!hu || super.a <= 0) && (hu || super.a >= 0)) {
                        if (super.a != 0) {
                           var12++;
                        }
                     } else {
                        var12--;
                     }

                     if ((this.h(var12, var2) & 16384) != 0 && hB != 48) {
                        this.s(50);
                     } else if (this.hA != 77
                        && this.hA != 95
                        && this.hA != 108
                        && this.hA != 114
                        && this.hA != 115
                        && this.hA != 116
                        && this.hA != 60
                        && hB != 120
                        && hB != 121
                        && hB != 48) {
                        if (fR) {
                           this.v();
                        }

                        this.s(27);
                        if (this.hK >= 4) {
                           this.av = this.hK;
                        }
                     } else if (this.hA == 77 || this.hA == 60) {
                        this.gy = true;
                        this.av += 6;
                        this.F();
                        this.y(2);
                     } else if (this.hA == 95 && !var10) {
                        var10 = true;
                        this.b(this.ga, this.gb - this.gD + (this.gD >> 2), 3, fL[gW]);
                     }
                  }

                  if (!hD && (hB == 24 || hB == 25) && super.b < 0) {
                     this.s(99);
                     break;
                  }

                  if (var33 < 0 || var33 >= iY) {
                     hD = false;
                  }

                  if (super.a == 0) {
                     break;
                  }
               }

               var17 = var3 ? --var17 : ++var17;
            }
         }

         if (this.gn && this.hA != 38) {
            int var35 = var1;
            var1 += hu ? 1 : -1;
            if ((this.h(var1, var33) & 8) == 0) {
               hD = false;
               this.gb = (var33 + (super.b < 0 ? 1 : 0)) * 16 + (super.b < 0 ? this.gD : 0);
               if (super.b >= 0 || (this.h(var1, var33) & 1) != 0) {
                  if (hB == 34) {
                     this.s(26);
                  } else {
                     this.s(33);
                  }

                  hD = false;
               }

               if (super.b < 0) {
                  this.gu = true;
               }
            }

            var1 = var35;
         }

         if (!this.hC && super.a != 0 && !this.hE && this.hA != 38 && !this.gn && !this.gp) {
            if ((!hu || super.a <= 0 || hh << 8 <= 16 - (gC >> 1)) && (hu || super.a >= 0 || hh >> 8 >= gC >> 1)) {
               if (!hu && super.a > 0 && hh << 8 > 16 - (gC >> 1) || hu && super.a < 0 && hh >> 8 < gC >> 1) {
                  this.ga = (var1 + 1) * 16 - this.hy;
                  this.hF = true;
                  if ((this.h(var1, var33 + (super.b > 0 ? -1 : 1)) & 8) != 0
                     && (this.h(var1, var33 + (super.b > 0 ? -this.hg : this.hg)) & 8) != 0
                     && super.b != 0) {
                     this.s(33);
                  }
               }
            } else {
               this.ga = var1 * 16 - this.hx;
               this.hF = true;
               if ((this.h(var1, var33 + (super.b > 0 ? -1 : 1)) & 8) != 0
                  && (this.h(var1, var33 + (super.b > 0 ? -this.hg : this.hg)) & 8) != 0
                  && this.hA != 38
                  && super.b != 0) {
                  this.s(33);
               }
            }

            this.hI = 0;
         }

         if (!this.hC && super.a != 0) {
            if (this.hA == 9) {
               this.s(0);
            } else if (this.hA == 51) {
               this.s(50);
            }
         }

         if (fR && (!this.hC || !hD)) {
            this.v();
         }
      }
   }

   private int h(int var1, int var2) {
      return var1 >= 0 && var1 < iX && var2 >= 0 && var2 < iY ? this.iW[var1 + iX * var2] : 65;
   }

   private void b(int var1, int var2, int var3) {
      if (var1 >= 0 && var1 < iX && var2 >= 0 && var2 < iY) {
         this.iW[var1 + iX * var2] = (short)(this.iW[var1 + iX * var2] | var3);
      }
   }

   private void c(int var1, int var2, int var3) {
      if (var1 >= 0 && var1 < iX && var2 >= 0 && var2 < iY) {
         this.iW[var1 + iX * var2] = (short)(this.iW[var1 + iX * var2] & ~var3);
      }
   }

   private void v() {
      if (this.dQ[this.ge] == 1) {
         this.i(0, this.ge);
      } else if (this.dQ[this.ge] == 2) {
         this.i(0, this.ge);
      } else if (this.dQ[this.ge] == 3) {
         this.i(0, this.ge);
      }

      this.s(26);
      fR = false;
      this.hH = 0;
   }

   private void i(int var1, int var2) {
      this.ei[var2] = this.dQ[var2] == 1 && (var1 == 13 || var1 == 17 || var1 == 23 || var1 == 12 || var1 == 15 || var1 == 16 || var1 == 14 || var1 == 21);
      this.eh[var2] = this.dQ[var2] == 1 && (var1 == 19 || var1 == 18 || var1 == 26 || var1 == 20);
      if (this.dQ[var2] == 1) {
         if (var1 == 5 || var1 == 6 || var1 == 16 || var1 == 15) {
            this.dS[var2] = 0;
         } else if (var1 == 8 || var1 == 9 || var1 == 10 || var1 == 24) {
            this.dX[var2] = 0;
            this.dS[var2] = 1;
         } else if (var1 == 2 || var1 == 7) {
            this.dS[var2] = 2;
         } else if (var1 != 11 && var1 != 21 && var1 != 3) {
            if (var1 == 1) {
               eu[var2] = O.nextInt() & 511;
            }

            this.dS[var2] = -1;
         } else {
            this.dS[var2] = 3;
         }
      } else if (this.dQ[var2] == 2) {
         if (var1 != 7 && var1 != 12 && var1 != 13) {
            this.dS[var2] = -1;
         } else {
            this.dX[var2] = 0;
            this.dS[var2] = 1;
         }

         if (var1 == 1) {
            eu[var2] = O.nextInt() & 511;
         }
      } else if (this.dQ[var2] == 3) {
         if (var1 != 7 && var1 != 13 && var1 != 17 && var1 != 16) {
            this.dS[var2] = -1;
         } else {
            this.dX[var2] = 0;
            this.dS[var2] = 1;
         }

         if (var1 == 1) {
            eu[var2] = O.nextInt() & 511;
         }
      }

      if ((this.ge != -1 && var2 != this.ge || this.ay > 0) && !this.eh[var2] && var1 != 7 && var1 != 11) {
         switch (this.dQ[var2]) {
            case 1:
               if (this.dR[var2] == 0 && var1 != 27) {
                  return;
               }

               if (var1 != 27) {
                  var1 = 0;
               }
               break;
            case 2:
               if ((this.dR[var2] == 0 || this.dR[var2] == 12 || this.dR[var2] == 10) && var1 != 14) {
                  return;
               }

               if (var1 != 14) {
                  var1 = 0;
               }
               break;
            case 3:
               if ((this.dR[var2] == 0 || this.dR[var2] == 12 || this.dR[var2] == 11) && var1 != 18) {
                  return;
               }

               if (var1 != 18) {
                  var1 = 0;
               }
         }
      }

      this.dR[var2] = var1;
      if (this.dQ[var2] == 1) {
         if (this.dA) {
            this.a(85 + var2, 18432, var1);
         } else {
            this.a(85 + var2, 4096, var1);
         }
      } else if (this.dQ[var2] == 2) {
         if (this.dB) {
            this.a(85 + var2, 16384, var1);
         } else {
            this.a(85 + var2, 17408, var1);
         }
      } else {
         if (this.dQ[var2] == 3) {
            if (dM == var2 && this.dN != var2) {
               this.a(85 + var2, 13312, var1);
               return;
            }

            if (this.dN == var2) {
               this.a(85 + var2, 14336, var1);
               return;
            }

            this.a(85 + var2, 15360, var1);
         }
      }
   }

   private void w() {
      this.s(14);
      this.i(24, this.ge);
      this.b(dT[this.ge], this.dU[this.ge] - (this.ef[this.ge] >> 1), 1, this.em[this.ge]);
      ek[this.ge] = -1;
      this.a(dT[this.ge] - (this.ee[this.ge] >> 1), this.dU[this.ge] - (this.ef[this.ge] >> 1), 22, !hu ? 2 : 0, false);
   }

   private void s(int var1) {
      this.fO = 0;
      this.fP = 0;
      gc = 0;
      this.hA = var1;
      hf = 0;
      boolean var2 = false;
      if (var1 == 22 && hb) {
         var1 = 20;
      }

      if ((var1 == 5 || var1 == 8) && hb) {
         var1++;
      } else if (var1 == 100 && hb) {
         var1++;
      } else if (var1 == 38 && hb) {
         var1 = 39;
      } else if (var1 == 27 && hb) {
         var1 = 29;
      } else if (var1 == 3) {
         if (hb) {
            var1 = 4;
         }
      } else if (var1 == 97 && hb) {
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
         && (this.dN != this.ge || this.ge >= 0 && this.dR[this.ge] != 16)) {
         fR = false;
         this.hH = 0;
         this.ge = -1;
         this.iB = true;
      }

      if (var1 != 31) {
         this.gm = false;
      } else {
         this.gm = true;
      }

      if (var1 == 0) {
         this.gv = false;
         if (this.gz) {
            var1 = 10;
         } else if (hb) {
            var1 = 1;
         }
      } else if (var1 == 31 && hb) {
         var1 = 32;
      } else if (var1 != 54 && var1 != 36 && var1 != 47) {
         this.gE = false;
         this.gv = false;
         this.fN = false;
      } else {
         this.gv = true;
         var2 = true;
         if (!this.gn && !gq) {
            if (this.fN) {
               this.fN = false;
               this.gG = 0;
            }

            if (hb) {
               var1 = 72 + this.gG;
               if (this.gG < this.gO) {
                  this.gG++;
               } else {
                  this.gE = false;
                  var1 = 77;
                  this.hA = 77;
                  this.fN = true;
               }
            } else {
               var1 += this.gG;
               if (this.gG < gN) {
                  this.gG++;
               } else {
                  var1 = 60;
                  this.fN = true;
                  this.gE = false;
                  this.hA = 60;
               }
            }
         }
      }

      gh = var1 == 7 || var1 == 5 || var1 == 8 || var1 == 6 || var1 == 101 || var1 == 119 || var1 == 118 || var1 == 100 || var1 == 5;
      if (var1 == 67) {
         var2 = true;
         this.gp = true;
         if (hb) {
            var1 = 83 + this.gG;
            if (this.gG > 3 - (gP < 3 ? 1 : 0)) {
               var1 = 83;
               this.gG = 0;
            } else if (this.gG == 2 - (gP < 3 ? 1 : 0)) {
               var1 = 85;
            }
         } else {
            var1 = 67 + this.gG;
            if (this.gG >= 3 - (gP < 3 ? 1 : 0)) {
               var1 = 67;
               this.gG = 0;
            } else if (this.gG == 2 - (gP < 3 ? 1 : 0)) {
               var1 = 69;
            }
         }

         this.gG++;
      } else {
         this.gp = false;
      }

      if (var1 == 91 || var1 == 92 || var1 == 93) {
         this.gp = true;
      }

      if (!this.gp && !this.gv) {
         this.gG = 0;
      }

      if (var1 != 35 && var1 != 34 && var1 != 36 && var1 != 33) {
         this.gn = false;
         this.gu = false;
      } else {
         this.gn = true;
      }

      gq = var1 == 45 || var1 == 47 || var1 == 46 || var1 == 119 || var1 == 118;
      if (var1 == 9) {
         this.gt = true;
         if (this.gz) {
            var1 = 11;
         }
      } else {
         this.gt = false;
      }

      if (var1 != 37 && var1 != 40) {
         gr = false;
         this.gu = false;
      } else {
         gr = true;
      }

      this.gs = var1 == 30;
      this.gk = var1 == 21 || var1 == 22 || var1 == 23 || var1 == 20;
      this.go = var1 == 50 || var1 == 51;
      if (var1 != 15 && var1 != 17) {
         this.gj = false;
      } else {
         this.gj = true;
         if (hb) {
            var1++;
         }
      }

      if (var2 && !gq && this.hj > 0) {
         int var3 = this.N & 1;
         this.y(3 + var3);
      }

      hB = var1;
      this.a(135, 28672, var1);
   }

   private boolean t(int var1) {
      return this.b(var1, this.L);
   }

   private int x() {
      return this.ga / 16;
   }

   private int y() {
      int var1;
      return (var1 = this.gb / 16) > iY ? iY : var1;
   }

   private void z() {
      int var1 = this.x();
      int var2 = (this.hi >> 8) + 1 >= 16 ? gx + 1 : gx;
      int var3 = 0;
      int var4 = this.ga - (gC >> 1);
      int var5 = this.gb;
      this.gy = gg;
      boolean var6 = this.gz;
      if (!this.gy) {
         this.gz = (this.h(var1, var2) & 8192) != 0 && hB != 99 && hB != 24 && hB != 25 && hB != 26;
         this.gy = (this.h(var1, var2) & 1) != 0;
         this.gA = (this.h(var1, var2 - 1) & 2048) != 0;
         gB = (this.h(var1, var2 - 1) & 4096) != 0;
      }

      if (this.gz && !var6) {
         if (this.gt) {
            this.gy = true;
            this.s(9);
         }
      } else if (!this.gz && var6 && this.gt) {
         this.s(9);
      }

      boolean var7 = this.b(135, this.L);
      gc = gc + this.L;
      if (!fR && (this.h(var1, var2) & 128) > 0) {
         for (int var8 = cv; var8 >= 0; var8--) {
            if (this.cl[var8] == var1 && cm[var8] == var2) {
               this.cs = this.cn[var8];
               this.ct = this.cn[var8];
               String var9 = this.e(this.cs);
               if (!this.aR && var9.charAt(0) == '@') {
                  this.aR = true;
                  this.aS = a.a(var9.substring(2, 3), 0) == 1;
                  this.aT = a.a(var9.substring(1, 2), 0);
                  this.a(131, 1027, this.aT);
               } else if (this.aR) {
                  int var67 = super.a;
                  int var11 = super.b;
                  this.t(131);
                  super.a = var67;
                  super.b = var11;
               } else {
                  I = 101;
                  this.a(79, 25, 35, 35);
                  if (I != 105) {
                     this.cu = this.ct + this.co[var8];

                     for (int var10 = cv; var10 >= 0; var10--) {
                        if (this.cn[var10] == this.cs) {
                           this.c(this.cl[var10], cm[var10], 128);
                        }
                     }

                     hX = new String[2];
                     this.p();
                  }
               }
            }
         }
      } else {
         this.aR = false;
      }

      if (this.hA != 52 && this.hA != 53) {
         if (this.hA == 26) {
            super.b = super.b + this.hK;
            this.hL = this.hL + this.L;
            if (this.hL > 200) {
               this.hL -= 200;
               this.hK = this.hK + (this.hK >= 8 ? 0 : 4);
            }
         } else {
            this.hL = 0;
            this.hK = 0;
         }

         if (super.b < 0 && this.hA != 60) {
            this.gy = false;
         }

         if (I != 105 && I != 108 && I != 101) {
            if (!fR && this.ge < 0 && this.ay < 0) {
               switch (this.t) {
                  case 1:
                     if (this.gn
                        && this.hA == 33
                        && ((this.h(this.gw + (hu ? 1 : -1), gx - this.hg - 1) & 8) != 0 || (this.h(this.gw + (hu ? 1 : -1), gx - this.hg - 1) & 1) == 0)) {
                        this.s(35);
                     }
                     break;
                  case 2:
                     if (!this.gn && !gr && !this.gk && this.hA != 44 && this.hA != 22 && this.hA != 38) {
                        if (gq && !gh && !this.gv) {
                           if (this.hA != 46) {
                              this.s(46);
                           }

                           hu = false;
                        } else {
                           if (this.hA == 0 || this.hA == 3) {
                              hu = false;
                              if ((
                                    (this.h(this.gw - 1, gx) & 1) != 0
                                       || (this.h(this.gw, gx) & 1) != 0
                                       || (this.h(this.gw - 1, gx - 1) & 1) != 0
                                       || (this.h(this.gw - 1, gx - 2) & 1) != 0
                                 )
                                 && (this.h(this.gw - 1, gx) & 512) == 0) {
                                 if ((this.h(this.gw - 1, gx) & 1) != 0
                                    || (this.h(this.gw, gx) & 1) != 0
                                    || (this.h(this.gw - 1, gx - 1) & 1) != 0
                                    || (this.h(this.gw - 1, gx - 2) & 1) != 0) {
                                    this.ga = (this.gw + ((this.h(this.gw, gx) & 1) != 0 ? 1 : 0)) * 16 + (gC >> 1);
                                 }
                              } else {
                                 if ((this.h(this.gw - 1, gx) & 512) != 0) {
                                    int var32 = (this.h(this.gw, gx) & 512) != 0 ? 1 : 0;
                                    this.ga = (this.gw + var32) * 16 + (gC >> 1);
                                 }

                                 this.s(9);
                                 this.hw = false;
                              }
                           } else if (this.hA == 50) {
                              hu = false;
                              if ((this.h(this.gw - 1, gx) & 1) == 0) {
                                 this.s(51);
                              }
                           }

                           if (this.hA == 9 || this.hA == 51) {
                              hu = false;
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
                     if (!this.gn && !gr && !this.gk && this.hA != 44 && this.hA != 22 && this.hA != 38) {
                        if (gq && !gh && !this.gv) {
                           if (this.hA != 46) {
                              this.s(46);
                           }

                           hu = true;
                        } else {
                           if (this.hA == 0 || this.hA == 3) {
                              if (((this.h(this.gw + 1, gx - 1) & 1) != 0 || (this.h(this.gw + 1, gx) & 1) != 0 || (this.h(this.gw + 1, gx - 2) & 1) != 0)
                                 && (this.h(this.gw + 1, gx) & 512) == 0) {
                                 if ((this.h(this.gw + 1, gx) & 1) != 0) {
                                    this.ga = (this.gw + 1) * 16 - (gC >> 1);
                                 }
                              } else {
                                 if ((this.h(this.gw + 1, gx) & 512) != 0) {
                                    int var31 = (this.h(this.gw, gx) & 512) != 0 ? -1 : 0;
                                    this.ga = (this.gw + 1 + var31) * 16 - (gC >> 1);
                                 }

                                 this.s(9);
                                 this.hw = false;
                              }

                              hu = true;
                           } else if (this.hA == 50) {
                              hu = true;
                              if ((this.h(this.gw + 1, gx) & 1) == 0) {
                                 this.s(51);
                              }
                           }

                           if (this.hA == 9 || this.hA == 51) {
                              hu = true;
                           }
                        }
                     }
                     break;
                  case 6:
                     if (this.gn) {
                        if (this.hA == 33) {
                           if ((this.h(this.gw + (hu ? 1 : -1), gx + 1) & 8) != 0) {
                              this.s(34);
                           } else {
                              this.s(26);
                           }
                        }
                     } else if (gq) {
                        this.s(26);
                     } else if (hB == 120) {
                        this.s(26);
                        this.gb += 16;
                     }
               }
            }

            if (!fR && this.ay < 0) {
               switch (this.s) {
                  case 1:
                     if (this.ge >= 0) {
                        break;
                     }

                     if (this.hA == 21) {
                        this.s(24);
                     } else if (hB == 120) {
                        this.s(121);
                     } else if (!this.gs && hu && this.gA) {
                        this.s(30);
                     } else if (!this.gs && !hu && gB) {
                        this.s(30);
                     } else if (!this.gm && !this.gj && !this.gn && !gq && !gr && (this.gy || this.gz) && !this.gk && this.ge < 0 && !this.gv) {
                        if (this.hw) {
                           this.hw = false;
                           this.s(0);
                        } else if (this.hA != 24 && this.hA != 26 && this.hA != 3 && this.hA != 38 && this.hA != 30) {
                           this.s(24);
                        }
                     } else if (gr) {
                        this.s(38);
                     } else if (this.hA == 24) {
                        this.s(25);
                     }
                     break;
                  case 2:
                     if (this.gk && this.hA == 21) {
                        if (hu) {
                           this.s(23);
                           this.gl = 0;
                        } else {
                           this.s(22);
                           this.gl = 1;
                        }

                        if (!this.u()) {
                           this.s(21);
                        } else {
                           this.y(3);
                        }
                     } else if (this.ge >= 0 && ek[this.ge] > 0 && this.dQ[this.ge] == 1 && this.hA != 14 && !this.gn) {
                        hu = false;
                        this.ej[this.ge] = false;
                        this.w();
                     } else if (hu && (this.gv || this.gp) && this.ge < 0 && !this.gn) {
                        short var40 = 150;
                        if (hb && this.gG > this.gO || !hb && this.gG > gN) {
                           var40 = 600;
                        }

                        if (gF > var40) {
                           this.gE = true;
                           this.fV = false;
                        }
                     } else if (this.gn && !this.gv) {
                        if (hu) {
                           hu = false;
                           this.s(44);
                        }
                     } else if (gr && !hu) {
                        this.s(38);
                     }
                     break;
                  case 5:
                     if (this.gk && this.hA == 21) {
                        if (hu) {
                           this.s(22);
                           this.gl = 1;
                        } else {
                           this.s(23);
                           this.gl = 0;
                        }

                        if (!this.u()) {
                           this.s(21);
                        } else {
                           this.y(3);
                        }
                     } else if (this.ge >= 0 && ek[this.ge] > 0 && this.dQ[this.ge] == 1 && this.hA != 14 && !this.gn) {
                        hu = true;
                        this.ej[this.ge] = true;
                        this.w();
                     } else if (!hu && (this.gv || this.gp) && this.ge < 0 && !this.gn && !gq) {
                        short var39 = 150;
                        if (hb && this.gG > this.gO || !hb && this.gG > gN) {
                           var39 = 600;
                        }

                        if (gF > var39) {
                           this.gE = true;
                           this.fV = true;
                        }
                     } else if (this.gn && !this.gv) {
                        if (!hu) {
                           hu = true;
                           this.s(44);
                        }
                     } else if (gr && hu) {
                        this.s(38);
                     }
                     break;
                  case 6:
                     if (!this.gv && (this.hA == 0 || this.hA == 9) && this.gy) {
                        for (int var36 = this.eB; var36 >= 0; var36--) {
                           if ((this.gb == this.dU[var36] || this.gb + 1 == this.dU[var36])
                              && a(
                                 dT[var36] - (this.ee[var36] >> 1) - (gC >> 1),
                                 this.dU[var36],
                                 this.ee[var36] + gC,
                                 this.ef[var36],
                                 this.ga,
                                 this.gb,
                                 gC,
                                 this.gD
                              )) {
                              boolean var56 = true;

                              for (int var69 = this.gw; var69 < this.dZ[var36]; var69++) {
                                 var56 &= (this.h(var69, gx) & 1) == 0;
                              }

                              if ((this.dX[var36] <= 0 || this.dQ[var36] == 3 && this.dR[var36] == 12) && var56) {
                                 this.iB = true;
                                 if (dM != var36 && this.dQ[var36] == 1 && ek[var36] > 0 && ek[var36] < en[var36] >> 1) {
                                    this.ge = var36;
                                    this.ga = dT[var36];
                                    this.ej[var36] = hu;
                                    super.a = 0;
                                    this.s(12);
                                    this.i(22, var36);
                                    break;
                                 }

                                 if (this.dQ[var36] != 2 || (ek[var36] <= 0 || ek[var36] >= en[var36] >> 1) && this.dR[var36] != 12) {
                                    if (this.dQ[var36] != 3 || (ek[var36] <= 0 || ek[var36] >= en[var36] >> 1) && (this.dR[var36] != 12 || dM == var36)) {
                                       continue;
                                    }

                                    this.ge = var36;
                                    if (this.dR[var36] == 12 && dM != var36) {
                                       this.s(113);
                                       this.b(dT[this.ge], this.dU[this.ge] - (this.ef[this.ge] >> 1), 0, this.em[this.ge] >> 1);
                                       this.ga = dT[var36];
                                       hu = this.ej[var36];
                                       this.dX[var36] = 0;
                                       ek[var36] = -1;
                                       this.i(16, var36);
                                       break;
                                    }

                                    this.ga = dT[var36];
                                    this.ej[var36] = hu;
                                    super.a = 0;
                                    this.hH = 1;
                                    fR = true;
                                    this.fS = 0;
                                    this.fQ = 3;
                                    this.fT = this.B();
                                    this.a(131, 1027, fU[this.fT]);
                                    if (dM != var36 && this.dN != var36) {
                                       this.s(91);
                                       this.i(14, var36);
                                    } else if (this.dN == var36) {
                                       this.s(114);
                                       this.i(13, var36);
                                    } else if (dM == var36) {
                                       this.s(108);
                                       this.i(13, var36);
                                    }

                                    this.ej[var36] = !hu;
                                    break;
                                 }

                                 this.ge = var36;
                                 if (this.dR[var36] != 12 && this.dR[var36] != 10) {
                                    this.ga = dT[var36];
                                    this.ej[var36] = hu;
                                    super.a = 0;
                                    this.s(88);
                                    this.hH = 1;
                                    fR = true;
                                    this.fQ = 2;
                                    this.fS = 0;
                                    this.fT = this.B();
                                    this.a(131, 1027, fU[this.fT]);
                                    this.i(11, var36);
                                    this.ej[var36] = !hu;
                                    break;
                                 }

                                 this.s(117);
                                 this.ga = dT[var36];
                                 ek[var36] = -1;
                                 this.b(dT[this.ge], this.dU[this.ge] - (this.ef[this.ge] >> 1), 2, this.em[this.ge] >> 1);
                                 this.i(13, var36);
                                 break;
                              }
                           }
                        }
                     }

                     if (gr) {
                        this.s(40);
                        this.gb++;
                     } else if (this.hA == 0) {
                        if (hu) {
                           for (int var37 = this.fm; var37 >= 0; var37--) {
                              if (!fp[var37]
                                 && a(this.fq[var37], this.fr[var37], this.fn, this.fo, this.ga - this.hx, this.gb, gC, this.gD)
                                 && Math.abs(this.gb - this.fr[var37]) < 8) {
                                 this.s(31);
                                 this.ga = this.fq[var37] + (this.fn >> 1);
                              }
                           }
                        }

                        for (int var38 = this.cx; var38 >= 0; var38--) {
                           if (hu && this.cA[var38] && a(this.ga - (gC >> 1), this.gb - this.gD, gC, this.gD, this.cy[var38] - 16, cz[var38], 32, 16)) {
                              this.hO = var38;
                              this.hP = var38;
                              if (!this.cD[var38]) {
                                 this.s(15);
                              } else {
                                 this.s(17);
                              }

                              this.ga = this.cy[var38];
                              this.cD[var38] = !this.cD[var38];
                           }
                        }
                     }

                     if (this.gy && !this.go && !this.gk && !this.gj && !this.gm && this.ge < 0 && hB != 24 && hB != 48 && hB != 30) {
                        this.hw = true;
                        this.s(3);
                     }

                     if (this.gz) {
                        this.s(26);
                     }
                     break;
                  case 8:
                     if (!this.gm && !this.gk && !this.gj && this.gy && this.ge < 0 && !this.gz) {
                        if (this.hA != 0 && this.hA != 3) {
                           if (!this.gy || hc || this.hd || hb && hl < 0) {
                              break;
                           }

                           short var35 = 150;
                           if (hb && this.gG > this.gO || !hb && this.gG > gN) {
                              var35 = 600;
                           }

                           if (gF > var35) {
                              this.gE = true;
                           }
                        } else {
                           this.hw = false;
                           var7 = true;
                           if (hc && hl > gV + 1 << 2) {
                              this.s(94);
                           } else if (this.hd && hl > 256 && this.fG < 10) {
                              this.s(95);
                              this.A();
                           } else {
                              hc = false;
                              this.hd = false;
                              if (!hb || hl <= 0) {
                                 this.A();
                              }

                              this.fV = hu;
                              if (!hb || hl > 0) {
                                 this.s(54);
                              }
                           }
                        }
                     } else if (this.ge >= 0 && ek[this.ge] > 0) {
                        if (this.dQ[this.ge] == 1) {
                           this.s(13);
                           this.i(10, this.ge);
                           this.b(dT[this.ge], this.dU[this.ge] - (this.ef[this.ge] >> 1), 0, this.em[this.ge]);
                           ek[this.ge] = -1;
                        } else if (this.dQ[this.ge] != 2) {
                        }
                     } else if (!this.gy && !this.gz && !this.gn && !gq && hB != 120 && hB != 121 && !this.gv && this.hA != 37) {
                        if (hb && hl <= 0 || hc || this.hd) {
                           this.A();
                        }

                        if (!this.gp) {
                           this.fV = hu;
                           this.s(67);
                        } else {
                           short var34 = 150;
                           if (hb && this.gG > this.gO || !hb && this.gG > gN) {
                              var34 = 600;
                           }

                           if (gF > var34) {
                              this.gE = true;
                           }
                        }
                     } else if (gq && !this.gv) {
                        if (this.hA != 47) {
                           this.A();
                           this.s(47);
                        }
                     } else if (this.gn && !this.gv) {
                        this.A();
                        this.s(36);
                     } else if (hB == 21) {
                        this.s(0);
                     }
                     break;
                  case 27:
                  case 42:
                     if (!this.hw && !this.gv) {
                        this.fM++;
                        if (this.fM > 3) {
                           this.fM = 0;
                        }

                        hb = this.fM == 1;
                        hc = this.fM == 2;
                        this.hd = this.fM == 3;
                        if (this.hA == 0) {
                           this.s(0);
                        }
                     }
                     break;
                  case 29:
                     if (this.aa == this.T) {
                        this.af = this.aa >> 8;
                        this.ag = this.ab >> 8;
                        this.J = I;
                        this.a(H, H, 35, 35);
                        I = 102;
                        ar = 4;
                     }
                     break;
                  case 35:
                     this.bi = false;
                     I = 106;
               }

               if (this.B) {
                  if (this.s == 55) {
                     this.hj = -1;
                  }

                  if (this.s == 48) {
                     this.C = !this.C;
                  }

                  if (this.s == 57) {
                     this.hj = this.hm;
                  }

                  if (this.s == 51) {
                     this.D = !this.D;
                  }
               }
            } else if (this.ay < 0) {
               boolean var33 = false;
               int var55 = super.a;
               int var68 = super.b;
               this.t(131);
               super.a = var55;
               super.b = var68;
               if (this.fS >= 0 && this.fS < this.fQ) {
                  switch (this.s) {
                     case 1:
                        if (this.fT == 0) {
                           var33 = true;
                        }
                        break;
                     case 2:
                        if (this.fT == 1) {
                           var33 = true;
                        }
                     case 3:
                     case 4:
                     case 7:
                     default:
                        break;
                     case 5:
                        if (this.fT == 3) {
                           var33 = true;
                        }
                        break;
                     case 6:
                        if (this.fT == 4) {
                           var33 = true;
                        }
                        break;
                     case 8:
                        if (this.fT == 2) {
                           var33 = true;
                        }
                  }

                  if (var33) {
                     int var79 = this.B();
                     this.fT = var79;
                     this.fS++;
                     this.a(131, 1027, fU[this.fT]);
                  } else if (this.s != 0 && this.s != 27 && this.s != 29 && this.s != 4 && this.s != 9) {
                     this.fS = -1;
                  }
               }
            }

            if (this.t != 6 && this.hw) {
               this.hw = false;
               this.s(0);
            }

            if (this.t != 2 && this.t != 5) {
               if (this.hA == 9) {
                  this.s(0);
               } else if (this.hA == 46) {
                  this.s(45);
               } else if (this.go && this.hA != 50) {
                  this.s(50);
               }
            }

            if (this.t != 1 && hB == 35 || this.t != 6 && hB == 34) {
               this.s(33);
            }

            if ((this.t != 8 || hl <= 0) && this.hA == 94) {
               this.s(0);
               if (hl <= 0) {
                  hl = 0;
               }

               this.A();
            }

            if (this.t == 8 && this.hA == 94) {
               hl -= 12;
            }

            if (!this.gy
               && !this.gz
               && !this.gp
               && !gq
               && !gg
               && this.hA != 26
               && this.hA != 99
               && this.hA != 48
               && (this.gG != 5 && this.gG != 6 && this.gG != this.gO || !hb)
               && !this.gs
               && var7) {
               if ((this.hA != 24 && this.hA != 25 && this.hA != 44 && this.hA != 38 || var7)
                  && (
                     this.hA == 24
                        || this.hA == 25
                        || this.hA == 44
                        || this.hA == 40
                        || this.hA == 38
                        || this.hA == 108
                        || this.hA == 114
                        || this.hA == 116
                        || this.hA == 115
                        || hB == 121
                        || hB == 120
                        || gr
                        || this.gn
                        || gq
                  )) {
                  if ((this.hA == 47 || this.hA == 118 || this.hA == 119) && !var7) {
                     this.s(45);
                  } else if (this.gy && this.hA != 24 && this.hA != 26) {
                     this.s(0);
                  }
               } else {
                  this.s(26);
               }
            } else if (!var7) {
               if (this.hA == 31 && !var7) {
                  for (int var41 = this.fm; var41 >= 0; var41--) {
                     if (!fp[var41] && a(this.fq[var41], this.fr[var41], this.fn, this.fo, this.ga - this.hx, this.gb, gC, this.gD)) {
                        this.ft[var41] = this.ft[var41] + 4;
                        this.s(31);
                        this.a(121 + var41, 5120, this.ft[var41]);
                        fp[var41] = true;
                        this.e(this.gw, gx);
                     }
                  }
               }

               if (this.hA == 27 && !this.hw && !hb) {
                  this.s(28);
               } else if (this.hA == 27 && this.hw) {
                  this.s(3);
               } else if (this.hw && this.hA == 3) {
                  this.s(3);
               } else if (this.hA == 38) {
                  this.s(0);
               } else if (this.hA == 40) {
                  this.s(26);
               } else if (hB == 121) {
                  if ((this.h(this.gw, gx + 1) & 8192) != 0) {
                     this.gz = true;
                  }

                  this.s(0);
               } else if (hB == 120) {
                  this.gb += 16;
                  this.s(26);
               } else if (this.hA == 47 || this.hA == 119 || this.hA == 118) {
                  this.s(45);
               } else if (this.hA == 97) {
                  this.s(3);
               } else if (this.hA == 88) {
                  if (this.fS >= this.fQ) {
                     ek[this.ge] = 1;
                     this.s(89);
                     this.b(dT[this.ge], this.dU[this.ge] - (this.ef[this.ge] >> 1), 2, this.em[this.ge] >> 1);
                     this.i(10, this.ge);
                  } else {
                     this.s(90);
                     this.i(0, this.ge);
                  }

                  fR = false;
                  this.hH = 0;
               } else if (this.gv && this.gE) {
                  hu = this.fV;
                  this.s(54);
                  gF = 0;
                  this.gE = false;
               } else if ((this.gy || !this.gE) && !fR) {
                  if (this.hA == 23) {
                     this.s(21);
                  } else if (this.hA == 36) {
                     this.s(33);
                  } else if (this.hw && this.gy || !this.gy && (!this.gz || hB == 26 || hB == 25 || hB == 70 || this.gp || hB == 24)) {
                     if (this.hA != 26 && this.gp) {
                        this.s(70);
                     } else if ((!this.gz || hB == 70) && !this.gy && !gq) {
                        this.s(26);
                     }
                  } else if (hB == 48) {
                     this.s(50);
                  } else {
                     this.s(0);
                  }
               } else if (fR) {
                  fR = false;
                  this.hH = 0;
                  this.gE = false;
                  if (this.fS >= this.fQ) {
                     if (dM != this.ge) {
                        ek[this.ge] = 1;
                        this.s(92);
                        this.b(dT[this.ge], this.dU[this.ge] - (this.ef[this.ge] >> 1), 1, this.em[this.ge]);
                        this.i(11, this.ge);
                     } else if (this.dN != this.ge) {
                        this.s(109);
                        this.b(dT[this.ge], this.dU[this.ge] - (this.ef[this.ge] >> 1), 2, this.em[this.ge]);
                        this.b(dT[this.ge], this.dU[this.ge] - (this.ef[this.ge] >> 1), 1, this.em[this.ge]);
                        ek[this.ge] = en[this.ge];
                        if (this.bC >= 4) {
                           this.i(14, this.ge);
                        } else {
                           this.i(15, this.ge);
                        }
                     } else if (this.dN == this.ge) {
                        this.s(115);
                        ek[this.ge] = en[this.ge];
                        this.ej[this.ge] = hu;
                        this.b(dT[this.ge], this.dU[this.ge] - (this.ef[this.ge] >> 1), 2, this.em[this.ge]);
                        this.b(dT[this.ge], this.dU[this.ge] - (this.ef[this.ge] >> 1), 1, this.em[this.ge]);
                        this.i(14, this.ge);
                        this.dO++;
                        if (this.dO >= 3) {
                           this.ey = true;
                        }

                        if (this.dO > 3) {
                           ek[this.ge] = -1;
                        }
                     }
                  } else if (dM != this.ge) {
                     this.s(93);
                     this.i(0, this.ge);
                  } else if (this.dN != this.ge) {
                     ek[this.ge] = en[this.ge];
                     this.i(0, this.ge);
                     this.s(110);
                  } else if (this.dN == this.ge) {
                     this.s(116);
                     ek[this.ge] = en[this.ge];
                     this.ej[this.ge] = hu;
                     this.i(12, this.ge);
                  }
               } else {
                  this.s(67);
                  hu = this.fV;
                  this.gE = false;
               }
            } else if (this.hA == 3 && !this.hw) {
               this.s(28);
            }

            if (this.hj <= 0 && this.ge < 0 && (!this.gk || hB == 21)) {
               if (!this.gy && hB != 26) {
                  this.s(26);
               } else if (this.gy && hB != 52 && hB != 53) {
                  this.s(52);
                  this.hj = 0;
               }
            }
         } else if (I == 105) {
            if (!this.gy && !this.gp && this.hA != 24 && !this.gz && !gq && !gg) {
               if (this.hA == 37) {
                  this.s(40);
                  this.gb++;
               } else {
                  this.s(26);
               }
            }

            if (!var7 && this.hA != 26) {
               if (this.aY[this.ba + 1] != 0 || this.aZ[this.bb + 1] != 0 && this.dL >= 0) {
                  if (this.aY[this.ba + 1] == 0) {
                     this.s(this.aY[this.ba]);
                  } else {
                     this.ba++;
                     this.s(this.aY[this.ba]);
                  }
               } else {
                  this.C();
               }
            }

            if (this.s == 29 && this.aa == this.T && this.ab == this.U) {
               this.af = this.aa >> 8;
               this.ag = this.ab >> 8;
               this.J = I;
               I = 102;
               ar = 4;
               this.a(H, H, 35, 35);
            }
         }

         this.f(var1, var2);
      } else if (this.hA == 52 && !var7 && I != 108) {
         this.a(H, H, 35, 35);
         I = 108;
         this.T = 0;
         this.U = 0;
      }

      if (!this.gv && !this.gp) {
         gF = 0;
      } else {
         gF = gF + this.L;
      }

      if (this.C) {
         this.hj = this.hm;
      }

      if (this.hj >= this.hk && !this.gi
         || this.ge >= 0
         || gh
         || this.gk
         || this.gv
         || hB == 60
         || hB == 77
         || this.hj <= 0
         || !this.gy
         || this.ga == this.fY && this.gb == this.fZ) {
         if (gq && this.hj < this.hk && !gh && !this.gv) {
            if (this.gf == hu) {
               this.s(118);
            } else {
               this.s(119);
            }
         } else if (this.ge >= 0) {
            this.hj = this.hk;
         }
      } else {
         this.gi = false;
         if (!this.hw && hB != 27 && hB != 28 && hB != 29) {
            if (this.hk - this.hj > 50) {
               hu = this.gf;
               this.s(7);
            } else if (hu == this.gf) {
               this.s(5);
            } else {
               this.s(100);
            }
         } else if (this.hw) {
            this.gi = false;
            if (hB != 97) {
               hu = this.gf;
               this.s(97);
            }
         }
      }

      this.hk = this.hj;
      if (hB == 9 && ((this.h(this.gw + (hu ? 1 : -1), gx + 2) & 16384) != 0 || (this.h(this.gw + (hu ? 1 : -1), gx + 3) & 16384) != 0)) {
         this.s(48);
      }

      this.a(this.ga, this.gb, 135, this.ht, hu);
      this.gI = this.gI - this.L;
      if (this.gI < 0 && gH != 0) {
         this.gI = 0;
         gH = 0;
         this.iB = true;
      }

      if (this.gJ != -1 && this.dg[this.gJ] - df[this.gJ] <= 3 && this.gK > 0) {
         if (this.dg[this.gJ] <= 0) {
            this.gK = this.gK - this.L;
            if (this.gK <= 0) {
               this.iB = true;
            }
         }

         this.gL = this.gL - this.L;
         if (this.gL < 0) {
            this.gL = 200 - this.gL;
            gM = !gM;
            this.iB = true;
         }
      }

      for (int var42 = this.bM; var42 >= 0; var42--) {
         if (bI[var42] >= 0 && !this.t(bI[var42] + 0)) {
            this.n(var42);
         }
      }

      for (int var43 = this.fm; var43 >= 0; var43--) {
         if (this.ft[var43] >= 0) {
            int var57 = this.fq[var43] - iQ;
            int var70 = this.fr[var43] - iR;
            if (var57 + this.fn >= 0
               && var70 + this.fo >= 0
               && var57 - this.fn <= 240
               && var70 - this.fo <= 320
               && !this.t(var43 + 121)
               && fs[var43] != 0
               && this.ft[var43] < 8
               && this.ft[var43] >= 4) {
               this.ft[var43] = this.ft[var43] + 4;
               this.a(121 + var43, 5120, this.ft[var43]);
               if (fs[var43] == -1) {
                  he = he | 1 << this.bC;
                  this.fw = 192;
                  this.ho++;
                  I = 104;
                  this.fv = 10;
                  this.a(136, 1026, 0);
               } else if (fs[var43] == -2) {
                  he = he | 1 << this.bC << 10;
                  this.fw = 192;
                  this.hp++;
                  I = 104;
                  this.fv = 9;
                  this.a(136, 1026, 1);
               } else if (fs[var43] != 0) {
                  this.b(this.fq[var43] + (this.fn >> 1), this.fr[var43] - this.fo - 7, this.ft[var43] - 8, fs[var43]);
               }
            }
         }
      }

      for (int var44 = this.fG; var44 >= 0; var44--) {
         int var58 = var44 << 2;
         int var71 = 9 * this.L;
         int var80 = fC[var44] < 0 ? this.ga : dT[fC[var44]];
         int var12 = fC[var44] < 0 ? this.gb : this.dU[fC[var44]];
         if (var80 < fy[var58] && fA[var44] > -3584) {
            fA[var44] = fA[var44] - var71;
         } else if (var80 > fy[var58] && fA[var44] < 3584) {
            fA[var44] = fA[var44] + var71;
         } else {
            fA[var44] = fA[var44] >> 2;
         }

         if (var12 - (this.gD >> 1) + 8 < fz[var58] && fB[var44] > -3584) {
            fB[var44] = fB[var44] - var71;
         } else if (var12 - (this.gD >> 1) - 8 > fz[var58] && fB[var44] < 3584) {
            fB[var44] = fB[var44] + var71;
         } else {
            fB[var44] = fB[var44] - (fB[var44] >> 3);
         }

         if (a(fy[var58], fz[var58], var80 + this.hy, var12 - this.gD, gC, this.gD)) {
            if (fD[var44] > 75) {
               if (fE[var44] == 1) {
                  if (this.hj < this.hm && this.hj > 0 && I != 108) {
                     this.hj = this.hj + fF[var44];
                     this.hk = this.hk + fF[var44];
                     if (this.hj > this.hm) {
                        this.hj = this.hm;
                        this.hk = this.hm;
                     }
                  }
               } else if (fE[var44] == 2) {
                  hl = hl + fF[var44];
                  if (hl > this.hn) {
                     hl = this.hn;
                  }
               } else if (fE[var44] == 0) {
                  this.hq = this.hq + fF[var44];
                  hr = hr + fF[var44];
                  if (hr > this.hs) {
                     this.hq = this.hq + (this.hs - hr);
                     hr = this.hs;
                  }
               } else if (fE[var44] == 3) {
                  int var13 = fC[var44];
                  byte var14 = this.dQ[var13];
                  if (var13 != this.ge && (this.dQ[var13] != 1 || this.dR[var13] != 22)) {
                     ek[fC[var44]] = ek[fC[var44]] - fF[var44];
                  }

                  fC[var44] = -1;
                  if (var13 != this.ge && ek[var13] <= 0 && this.dS[var13] != 1 && (this.dQ[var13] != 1 || this.dR[var13] != 22) && this.dS[var13] != 3) {
                     if (dM == var13) {
                        ek[var13] = (en[var13] >> 1) - 1;
                     } else {
                        ek[var13] = -1;
                        if (this.ei[var13] || this.eh[var13]) {
                           this.i(11, var13);
                        } else if (var14 == 1) {
                           this.i(8, var13);
                           this.b(dT[var13], this.dU[var13] - (this.ef[var13] >> 1), 0, this.em[var13]);
                        } else if (var14 == 2) {
                           this.i(7, var13);
                           this.b(dT[var13], this.dU[var13] - (this.ef[var13] >> 1), 2, this.em[var13]);
                        } else if (var14 == 3) {
                           if (this.dR[var13] != 17) {
                              this.i(7, var13);
                           }

                           this.b(dT[var13], this.dU[var13] - (this.ef[var13] >> 1), 0, this.em[var13]);
                        }
                     }
                  } else if (this.dQ[var13] == 2 && this.dR[var13] == 12) {
                     ek[var13] = 1;
                  }
               }

               this.r(var44);
            } else {
               fD[var44] = fD[var44] + this.L;
            }
         }

         fy[var58] = fy[var58] + (fA[var44] >> 8);
         fz[var58] = fz[var58] + (fB[var44] >> 8);
         System.arraycopy(fy, var58, fy, var58 + 1, 3);
         System.arraycopy(fz, var58, fz, var58 + 1, 3);
      }

      for (int var45 = cd + 10; var45 >= 10; var45--) {
         var3 = var45 - 10;
         if (this.bY[var3] >= 0) {
            int var59 = bZ[var3] - iQ;
            int var72 = ca[var3] - iR;
            if (var59 + this.cc[var3] >= 0 && var72 + this.cb[var3] >= 0 && var59 - this.cc[var3] <= 240 && var72 - this.cb[var3] <= 320) {
               if (!this.t(var45)) {
                  this.bY[var3] = -1;
               }

               bZ[var3] = bZ[var3] + super.a;
               ca[var3] = ca[var3] + super.b;
            }
         }
      }

      for (int var46 = ck + 40; var46 >= 40; var46--) {
         var3 = var46 - 40;
         if (this.cf[var3] >= 0) {
            int var60 = this.cg[var3] - iQ;
            int var73 = ch[var3] - iR;
            if (var60 + this.cj[var3] >= 0 && var73 + this.ci[var3] >= 0 && var60 - this.cj[var3] <= 240 && var73 - this.ci[var3] <= 320) {
               if (!this.t(var46)) {
                  this.cf[var3] = -1;
               }

               this.cg[var3] = this.cg[var3] + super.a;
               ch[var3] = ch[var3] + super.b;
            }
         }
      }

      for (int var47 = bW + 30; var47 >= 30; var47--) {
         var3 = var47 - 30;
         if (this.bO[var3] >= 0) {
            if (!this.t(var47) && this.bV[var3]) {
               this.bO[var3] = -1;
               this.o(var3);
            } else if ((this.bO[var3] & 1) == 0 && a(bR[var3], this.bS[var3], this.bU[var3], this.bT[var3], this.ga - this.hx, this.gb - this.gD, gC, this.gD)) {
               this.bO[var3]++;
               this.a(var47, 5122, this.bO[var3]);
            }

            bP[var3] = bP[var3] + super.a;
            this.bQ[var3] = this.bQ[var3] + super.b;
         }
      }

      for (int var48 = this.cx; var48 >= 0; var48--) {
         int var61 = var48 + 106;
         int var74 = this.cA[var48] ? 4 : 0;
         boolean var81 = this.t(var61);
         int var86 = cE[var48];
         if (!this.cA[var48]
            && (
               this.gy && a(this.ga - (gC >> 1), this.gb - this.gD, gC, this.gD, this.cy[var48], cz[var48], 16, 16)
                  || (this.h(this.cF[var48], cG[var48]) & 1) != 0
            )) {
            if (!this.cD[var48]) {
               this.cD[var48] = true;
               this.x(var48);
               this.hP = var48;
            }
         } else if (!this.cA[var48] && this.cD[var48]) {
            this.cD[var48] = false;
            this.x(var48);
            this.hP = var48;
         }

         if (!var81) {
            boolean var91 = false;
            if (!this.cD[var48]) {
               if (var86 == 1 + var74) {
                  cE[var48] = 2 + var74;
                  this.a(var61, 2050, cE[var48]);
                  var91 = true;
               }
            } else if (var86 == 3 + var74) {
               cE[var48] = 0 + var74;
               this.a(var61, 2050, cE[var48]);
               var91 = true;
            }

            if ((var86 == 3 + var74 || var86 == 1 + var74) && !var91 && this.hO >= 0) {
               this.x(this.hO);
               this.hO = -1;
            }
         }

         if (this.hP >= 0 && this.hP == var48) {
            this.hP = -1;
            if (var86 == 0 + var74 || var86 == 3 + var74) {
               cE[var48] = 1 + var74;
               this.a(var61, 2050, cE[var48]);
            } else if (var86 == 2 + var74 || var86 == 1 + var74) {
               cE[var48] = 3 + var74;
               this.a(var61, 2050, cE[var48]);
            }
         }
      }

      for (int var49 = cI; var49 >= 0; var49--) {
         int var62 = var49 + 100;
         boolean var75 = this.t(var62);
         int var82 = cT[var49] - (this.cU[var49] << 2);
         if (var75) {
            if (cV[var49]) {
               if (var82 == 2) {
                  cT[var49] = (this.cU[var49] << 2) + 3;
                  this.a(var62, 2049, cT[var49]);
               }
            } else if (var82 == 0) {
               cT[var49] = (this.cU[var49] << 2) + 1;
               this.a(var62, 2049, cT[var49]);
            }
         } else if (!cV[var49]) {
            if (var82 == 3) {
               cT[var49] = (this.cU[var49] << 2) + 0;
               this.a(var62, 2049, cT[var49]);
            } else if (var82 == 1) {
               cT[var49] = (this.cU[var49] << 2) + 2;
               this.a(var62, 2049, cT[var49]);

               for (int var88 = 0; var88 < this.cQ[var49]; var88++) {
                  for (int var93 = 0; var93 < cO[var49]; var93++) {
                     this.b(cK[var49] + var93, cL[var49] - var88, 1);
                  }
               }
            }
         } else if (var82 == 1) {
            cT[var49] = (this.cU[var49] << 2) + 2;
            this.a(var62, 2049, cT[var49]);
         } else if (var82 == 3) {
            cT[var49] = (this.cU[var49] << 2) + 0;
            this.a(var62, 2049, cT[var49]);

            for (int var87 = 0; var87 < this.cQ[var49]; var87++) {
               for (int var92 = 0; var92 < cO[var49]; var92++) {
                  this.c(cK[var49] + var92, cL[var49] - var87, 1);
               }
            }
         }
      }

      for (int var50 = this.dp + 60; var50 >= 60; var50--) {
         var3 = var50 - 60;
         if (this.di[var3] >= 0) {
            int var63 = dl[var3] - iQ;
            int var76 = dm[var3] - iR;
            if (var63 + this.do[var3] >= 0 && var76 + this.dn[var3] >= 0 && var63 - this.do[var3] <= 240 && var76 - this.dn[var3] <= 320) {
               boolean var83 = !this.t(var50);
               if (this.dk[var3] == 2) {
                  dl[var3] = dl[var3] - super.a;
                  dm[var3] = dm[var3] - super.b;
               } else {
                  dl[var3] = dl[var3] + super.a;
                  dm[var3] = dm[var3] + super.b;
               }

               if (!this.gv && !this.gp && hB != 30
                  || (this.di[var3] & 1) != 0
                  || this.ht[2] == 0 && this.ht[7] == 0
                  || !a(this.ht[0], this.ht[1], this.ht[2], this.ht[3], dl[var3], dm[var3] - this.dn[var3], this.do[var3], this.dn[var3])
                     && !a(this.ht[5], this.ht[6], this.ht[7], this.ht[8], dl[var3], dm[var3] - this.dn[var3], this.do[var3], this.dn[var3])) {
                  if (var83 && (this.di[var3] & 1) == 1) {
                     this.j(var3, 1);
                     this.p(var3);
                  }
               } else {
                  this.di[var3]++;
                  this.a(var50, 5121, this.di[var3]);
                  this.b(dl[var3], dm[var3] - (this.dn[var3] >> 1), 1, 25);
               }
            }
         }
      }

      for (int var51 = eX; var51 >= 0; var51--) {
         if (this.hG) {
            this.hG = false;
         } else if (this.t(var51 + 111)) {
            this.eO[var51] = this.eO[var51] + ((!hu || this.hA != 22) && (hu || this.hA != 23) ? -super.a : super.a);
            this.eP[var51] = this.eP[var51] + super.b;
         } else {
            this.a(var51 + 111, 6144, this.eN[var51]);
         }
      }

      for (int var52 = this.eZ; var52 >= 0; var52--) {
         int var64 = fd[var52] - iQ;
         int var77 = this.fe[var52] - iR;
         if (var64 + ff[var52] >= 0 && var77 + this.fg[var52] >= 0 && var64 - ff[var52] <= 240 && var77 - this.fg[var52] <= 320) {
            for (byte var84 = 0; var84 < this.ht.length; var84 += 5) {
               if ((this.fa[var52] & 1) == 0) {
                  if (!hc
                     && this.ht[var84 + 3] != 0
                     && a(
                        this.ht[var84],
                        this.ht[var84 + 1],
                        this.ht[var84 + 2],
                        this.ht[var84 + 3],
                        fd[var52],
                        this.fe[var52] - this.fg[var52],
                        ff[var52],
                        this.fg[var52]
                     )) {
                     if (!this.b(116 + var52, 5)) {
                        this.b(fd[var52], this.fe[var52] - (this.fg[var52] >> 1), 0, 50);
                        this.j(var52, 2);

                        for (int var89 = 1; var89 <= this.fi[var52]; var89++) {
                           for (int var94 = 0; var94 < this.fh[var52]; var94++) {
                              this.c(this.fb[var52] + var94, fc[var52] - var89, 1);
                           }
                        }

                        this.fa[var52]++;
                        this.a(var52 + 116, 2048, this.fa[var52]);
                        this.q(var52);
                     }

                     this.a(fd[var52] + (hu ? 0 : ff[var52]), this.ht[1] + (this.ht[3] >> 1), 28, !hu ? 2 : 0, false);
                  }
               } else {
                  this.b(116 + var52, this.L);
               }
            }
         }
      }

      for (int var53 = this.dz + 70; var53 >= 70; var53--) {
         var3 = var53 - 70;
         if (this.dr[var3] >= 0) {
            boolean var65 = !this.t(var53);
            dt[var3] = dt[var3] + super.a;
            this.du[var3] = this.du[var3] + super.b;
            if (var65) {
               dt[var3] = this.dv[var3];
               this.du[var3] = this.dw[var3];
               this.a(var53, 6145, this.dr[var3]);
            }

            this.a(dt[var3], this.du[var3], var53, ew, true);
            if (this.ge < 0 && ew[2] > 0 && a(ew[0], ew[1], ew[2], ew[3], var4, var5 - this.gD, gC, this.gD)) {
               if (!this.ey) {
                  this.hj = this.hj - (this.ds[var3] * this.L >> 2);
                  if (this.hj < 0) {
                     this.hj = 0;
                  }
               }

               this.hk = this.hj;
               if (!gh && !this.gk && !this.gv && hB != 52 && hB != 53 && hB != 60 && hB != 77 && this.gy) {
                  this.s(5);
               }
            }
         }
      }

      this.t(132);

      for (int var54 = this.eB + 85; var54 >= 85; var54--) {
         var3 = var54 - 85;
         boolean var66 = false;
         if (this.dP[var3] >= 0) {
            int var78 = this.dU[var3];
            int var85 = dT[var3];
            byte var90 = this.dQ[var3];
            int var95 = this.dR[var3];
            this.c(this.dZ[var3], this.ea[var3] - 1, 2);
            this.ep[var3] = var78 - this.ea[var3] * 16 << 8;
            this.dZ[var3] = u(var3);
            int var96 = this.dZ[var3];
            int var15 = (this.ep[var3] >> 8) + 1 >= 16 ? this.ea[var3] + 1 : this.ea[var3];
            int var16 = this.ga - var85;
            int var17 = this.gb - var78;
            int var18 = Math.abs(var16);
            this.dG = var18;
            int var19 = Math.abs(var17);
            eA = (this.h(var96, var15) & 1) != 0;
            if ((this.h(var96, var15) & 64) != 0 && this.dS[var3] != 1 && dT[var3] > 0) {
               ek[var3] = -1;
               if (var90 == 1) {
                  this.i(8, var3);
                  this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 0, this.em[var3]);
               } else if (var90 == 2) {
                  this.i(7, var3);
                  this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 2, this.em[var3]);
               }
            }

            if (dT[var3] > -10
               && this.dU[var3] > -10
               && (
                  a(iQ - 64, iR - 64, 368, 448, dT[var3] - this.ee[var3], this.dU[var3] - this.ef[var3], this.ee[var3] << 1, this.ef[var3])
                     || this.dL == var3 && I == 105
                     || this.dQ[var3] == 1
                        && (this.dR[var3] == 11 || this.dR[var3] == 27 || this.dR[var3] == 8 || this.dR[var3] == 9 || this.dR[var3] == 10 || this.dR[var3] == 7)
                     || this.dQ[var3] == 2 && (this.dR[var3] == 8 || this.dR[var3] == 14 || this.dR[var3] == 7 || this.dR[var3] == 10 || this.dR[var3] == 9)
                     || this.dQ[var3] == 3
                        && (
                           this.dR[var3] == 10 || this.dR[var3] == 18 || this.dR[var3] == 7 || this.dR[var3] == 13 || this.dR[var3] == 17 || this.dR[var3] == 8
                        )
               )) {
               boolean var20 = false;
               if (this.dX[var3] <= 500) {
                  var20 = !this.b(var54, this.L - (this.dX[var3] >> 5));
               }

               if (this.dR[var3] == 11 && this.dQ[var3] == 1 || this.dR[var3] == 8 && this.dQ[var3] == 2 || this.dR[var3] == 10 && this.dQ[var3] == 3) {
                  super.b = super.b + dJ[var3];
                  this.dK[var3] = this.dK[var3] + this.L;
                  if (this.dK[var3] > 200) {
                     this.dK[var3] = this.dK[var3] - 200;
                     dJ[var3] = dJ[var3] + (dJ[var3] >= 8 ? 0 : 4);
                  }
               } else {
                  this.dK[var3] = 0;
                  dJ[var3] = 0;
               }

               if (I != 105 && this.dX[var3] <= 500) {
                  if (var20) {
                     if (I != 105) {
                        switch (var90) {
                           case 1:
                              if (var95 != 8 && var95 != 9 && var95 != 10) {
                                 if (!this.ei[var3] && !this.eh[var3]) {
                                    if (var18 < 48 && var19 < 16) {
                                       if (Math.abs(this.N & 3) == 3) {
                                          this.i(6, var3);
                                       } else {
                                          this.i(5, var3);
                                       }

                                       this.ej[var3] = var16 >= 0;
                                    } else if (var95 != 0
                                       && var19 < 32
                                       && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] : -eb[var3]), this.ea[var3] - 1) & 3) == 0
                                       && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] + 1 : -(eb[var3] + 1)), this.ea[var3] - 1) & 3) == 0
                                       && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] : -eb[var3]), this.ea[var3]) & 3) != 0
                                       && var18 < 144) {
                                       if (eu[var3] < 0) {
                                          this.i(1, var3);
                                       } else {
                                          this.i(0, var3);
                                          eu[var3] = eu[var3] - this.L;
                                       }
                                    } else if (this.dR[var3] == 25) {
                                       this.i(1, var3);
                                    } else {
                                       if (this.dR[var3] == 27) {
                                          eA = true;
                                       }

                                       this.i(0, var3);
                                    }

                                    if (ev[var3] && this.dR[var3] == 1) {
                                       int var102;
                                       if ((var102 = dT[var3] - dV[var3]) > 64) {
                                          this.ej[var3] = false;
                                       } else if (var102 < 64) {
                                          this.ej[var3] = true;
                                       }
                                    }
                                 } else if (this.ei[var3]) {
                                    if (var95 != 16 && var95 != 15 && var17 > 0 && var17 < 32 && var18 < 16) {
                                       this.i(16, var3);
                                    } else if (var95 != 15 && var95 != 16 && var17 < 0 && var17 > -64 && var18 < 16) {
                                       this.i(15, var3);
                                    } else if (var17 < 0 && var95 != 12 && var95 != 15 && var95 != 16 && var95 != 21) {
                                       this.i(12, var3);
                                    } else if (var95 != 13 && var95 != 15 && var95 != 16 && var95 != 21) {
                                       this.i(13, var3);
                                    } else if (var95 != 21) {
                                       this.i(23, var3);
                                    }
                                 } else if (this.eh[var3] && (var95 == 20 || var95 == 19)) {
                                    this.i(26, var3);
                                 }
                              } else {
                                 if (this.dH < 25) {
                                    this.j(var3, 0);
                                 }

                                 this.w(var3);
                                 this.a(dT[var3], this.dU[var3], 26, 0, false);
                                 dT[var3] = -1000;
                                 this.dU[var3] = -1000;
                                 var85 = -1000;
                                 var78 = -1000;
                                 this.dI++;
                                 if (iN) {
                                    this.iB = true;
                                 }

                                 this.i(0, var3);
                              }
                              break;
                           case 2:
                              if (var95 != 7 && var95 != 12 && var95 != 13) {
                                 if (var95 != 12) {
                                    byte var100 = 0;
                                    if (this.dB) {
                                       var100 = 1;
                                    }

                                    if (this.dR[var3] == 10) {
                                       this.i(12, var3);
                                    } else if (var18 < 16 * (3 + var100) && var19 < 16) {
                                       if (Math.abs(this.N & 3) == 3) {
                                          this.i(6, var3);
                                       } else {
                                          this.i(5, var3);
                                       }

                                       this.ej[var3] = var16 >= 0;
                                    } else {
                                       if (this.dR[var3] == 27) {
                                          eA = true;
                                       }

                                       this.i(0, var3);
                                    }
                                 }
                              } else {
                                 if (this.dH < 25) {
                                    this.j(var3, 0);
                                 }

                                 this.w(var3);
                                 this.a(dT[var3], this.dU[var3], 26, 0, false);
                                 dT[var3] = -1000;
                                 this.dU[var3] = -1000;
                                 var85 = -1000;
                                 var78 = -1000;
                                 this.i(0, var3);
                                 this.dI++;
                                 if (iN) {
                                    this.iB = true;
                                 }
                              }

                              if (ev[var3] && this.dR[var3] == 1) {
                                 int var101;
                                 if ((var101 = dT[var3] - dV[var3]) > 64) {
                                    this.ej[var3] = false;
                                 } else if (var101 < 64) {
                                    this.ej[var3] = true;
                                 }
                              }
                              break;
                           case 3:
                              if ((var95 == 7 || var95 == 13 || var95 == 17) && dM != var3 && this.dN != var3
                                 || dM == var3 && (var95 == 7 || var95 == 16)
                                 || this.dN == var3 && var95 == 16) {
                                 if (dM == var3 && var95 == 7 || this.dN == var3) {
                                    if (this.dN != var3) {
                                       this.cs = 266;
                                       this.ct = 266;
                                       this.cu = 274;
                                    } else {
                                       this.cs = 243;
                                       this.ct = 243;
                                       this.cu = 245;
                                    }

                                    this.a(79, 25, 35, 35);
                                    I = 101;
                                    this.p();
                                 }

                                 if (this.dH < 25) {
                                    this.j(var3, 0);
                                 }

                                 this.w(var3);
                                 if (dM != var3) {
                                    this.a(dT[var3], this.dU[var3], 26, 0, false);
                                 }

                                 dT[var3] = -1000;
                                 this.dU[var3] = -1000;
                                 var85 = -1000;
                                 var78 = -1000;
                                 this.i(0, var3);
                                 this.dI++;
                                 if (iN) {
                                    this.iB = true;
                                 }
                              } else if (dM == var3 && this.dN != var3 && this.dR[var3] == 15) {
                                 this.i(16, var3);
                              }

                              if (dM != var3 || this.dN == var3 || this.dR[var3] != 16) {
                                 if (var95 == 11 && dM != var3) {
                                    this.i(12, var3);
                                 } else if (var95 == 16 && dM != var3 && this.dN != var3) {
                                    this.i(17, var3);
                                    ek[var3] = -1;
                                 } else if (var95 == 12 && dM != var3) {
                                    this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 1, this.em[var3]);
                                    this.i(13, var3);
                                    ek[var3] = -1;
                                 } else if (var18 < 16 * (3 + (dM == var3 ? 1 : 0)) && var19 < 16 && this.ge < 0) {
                                    if (Math.abs(this.N & 3) == 3) {
                                       if (dM == var3 && (this.N & 1) != 0) {
                                          this.i(12, var3);
                                       } else {
                                          this.i(6, var3);
                                       }
                                    } else {
                                       this.i(3, var3);
                                    }

                                    if (!fR) {
                                       this.ej[var3] = var16 >= 8;
                                    }
                                 } else if (var95 != 0 && this.ge != var3) {
                                    super.a = 0;
                                    super.b = 0;
                                    this.i(0, var3);
                                 }

                                 if (ev[var3] && this.dR[var3] == 1) {
                                    int var99;
                                    if ((var99 = dT[var3] - dV[var3]) > 64) {
                                       this.ej[var3] = false;
                                    } else if (var99 < 64) {
                                       this.ej[var3] = true;
                                    }
                                 }

                                 if (this.dN == var3 && var95 == 14 && this.dO >= 3) {
                                    this.i(16, var3);
                                 } else if (this.dN == var3 && var95 == 14 && this.dO < 3) {
                                    this.i(17, var3);
                                    this.ej[var3] = !this.ej[var3];
                                 }
                              }
                        }
                     }
                  } else if (I != 105) {
                     switch (var90) {
                        case 1:
                           if (var95 == 1) {
                              if (var16 > 16 && !this.ej[var3]) {
                                 this.ej[var3] = true;
                              } else if (var16 < -16 && this.ej[var3]) {
                                 this.ej[var3] = false;
                              }

                              if (var18 < 48 && var19 < 16) {
                                 this.i(6, var3);
                                 this.ej[var3] = var16 >= 0;
                              } else if (var18 < 32 && var19 > 16 && var19 < 128 && this.gn && !this.dA
                                 || var18 < 64 && var19 > 16 && var19 < 32 && gq && !this.dA
                                 || var17 > 0 && var19 < 32 && var18 < 48 && this.hA != 37 && this.hA != 38 && !gq && !gr && this.hA != 38) {
                                 this.i(3, var3);
                              }
                           } else if (this.ei[var3]) {
                              if (var95 != 16 && var95 != 21 && var17 > 0 && var17 < 32 && var18 < 16) {
                                 this.i(16, var3);
                              } else if (var95 != 15 && var95 != 21 && var17 < 0 && var17 > -64 && var18 < 16) {
                                 this.i(15, var3);
                              } else if (var17 < 0 && var95 != 12 && var95 != 15 && var95 != 16 && var95 != 21) {
                                 this.i(12, var3);
                              } else if (var95 != 13 && var95 != 15 && var95 != 21 && var95 != 16 && var17 > 0) {
                                 this.i(13, var3);
                              } else if (var95 == 21 && eA) {
                                 this.i(0, var3);
                              }
                           } else if (!this.eh[var3]) {
                              if ((this.h(this.dZ[var3], this.ea[var3] - 1) & 512) != 0 && this.dR[var3] != 8) {
                                 this.ej[var3] = !hu;
                                 ek[var3] = -1;
                                 this.i(8, var3);
                                 this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 0, this.em[var3]);
                              } else if (var95 == 0
                                 && var19 < 32
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] : -eb[var3]), this.ea[var3] - 1) & 3) == 0
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] + 1 : -(eb[var3] + 1)), this.ea[var3] - 1) & 3) == 0
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] : -eb[var3]), this.ea[var3]) & 3) != 0
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] + 1 : -(eb[var3] + 1)), this.ea[var3]) & 3) != 0
                                 && var18 < 144) {
                                 if (eu[var3] < 0) {
                                    this.i(1, var3);
                                 } else {
                                    eu[var3] = eu[var3] - this.L;
                                 }
                              } else if (var95 == 0 && var17 <= 32 && var17 > 0 && this.gy && var18 < 48) {
                                 this.i(3, var3);
                              } else if (var95 == 21) {
                                 this.i(0, var3);
                              } else if (this.dR[var3] == 0 && var18 < 48 && var19 < 16) {
                                 if (Math.abs(this.N & 3) == 3) {
                                    this.i(6, var3);
                                 } else {
                                    this.i(5, var3);
                                 }

                                 this.ej[var3] = var16 >= 0;
                              }
                           } else {
                              if (var16 > 16
                                 && var18 < 72
                                 && this.dR[var3] != 19
                                 && this.dR[var3] != 18
                                 && (this.h(this.dZ[var3] + 1, this.ea[var3] - this.eg[var3] - 1) & 16) != 0) {
                                 this.i(18, var3);
                                 this.ej[var3] = true;
                              } else if (var16 < -16
                                 && var18 < 72
                                 && this.dR[var3] != 19
                                 && this.dR[var3] != 18
                                 && (this.h(this.dZ[var3] - 1, this.ea[var3] - this.eg[var3] - 1) & 16) != 0) {
                                 this.i(18, var3);
                                 this.ej[var3] = false;
                              }

                              if (this.dR[var3] != 19 && var18 < 48 && var19 < 16) {
                                 this.i(19, var3);
                                 this.ej[var3] = var16 >= 0;
                              }
                           }
                           break;
                        case 2:
                           byte var21 = 0;
                           if (this.dB) {
                              var21 = 1;
                           }

                           if (var95 != 1) {
                              if ((this.h(this.dZ[var3], this.ea[var3] - 1) & 512) != 0 && this.dR[var3] != 7) {
                                 this.ej[var3] = !hu;
                                 ek[var3] = -1;
                                 this.i(7, var3);
                                 this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 2, this.em[var3]);
                              } else if (var95 == 0
                                 && var19 < 32
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] : -eb[var3]), this.ea[var3] - 1) & 3) == 0
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] + 1 : -(eb[var3] + 1)), this.ea[var3] - 1) & 3) == 0
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] : -eb[var3]), this.ea[var3]) & 3) != 0
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] + 1 : -(eb[var3] + 1)), this.ea[var3]) & 3) != 0
                                 && var18 < 144) {
                                 if (eu[var3] < 0) {
                                    this.i(1, var3);
                                 } else {
                                    eu[var3] = eu[var3] - this.L;
                                 }
                              } else if (this.dR[var3] == 0) {
                                 byte var22 = 0;
                                 if (this.dB) {
                                    var22 = 1;
                                 }

                                 if (var18 < 16 * (3 + var22) && var19 < 16) {
                                    if (Math.abs(this.N & 3) == 3) {
                                       this.i(6, var3);
                                    } else {
                                       this.i(5, var3);
                                    }

                                    this.ej[var3] = var16 >= 0;
                                 }
                              }
                           } else {
                              if (var16 > 16 && !this.ej[var3]) {
                                 this.ej[var3] = true;
                              } else if (var16 < -16 && this.ej[var3]) {
                                 this.ej[var3] = false;
                              }

                              if (var18 < 16 * (3 + var21) && var19 < 16) {
                                 this.i(6, var3);
                                 this.ej[var3] = var16 >= 0;
                              }
                           }
                           break;
                        case 3:
                           if (var95 != 12) {
                              if (var95 == 1) {
                                 if (var16 > 16 && !this.ej[var3]) {
                                    this.ej[var3] = true;
                                 } else if (var16 < -16 && this.ej[var3]) {
                                    this.ej[var3] = false;
                                 }

                                 if (var18 < 16 * (3 + (dM == var3 ? 1 : 0)) && var19 < 16) {
                                    this.i(6, var3);
                                    this.ej[var3] = var16 >= 0;
                                 }
                              } else if ((this.h(this.dZ[var3], this.ea[var3] - 1) & 512) != 0 && this.dR[var3] != 7) {
                                 ek[var3] = -1;
                                 this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 0, this.em[var3]);
                                 this.i(7, var3);
                                 this.ej[var3] = !hu;
                              } else if (var95 == 0
                                 && var19 < 32
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] + 1 : -(eb[var3] + 1)), this.ea[var3] - 1) & 3) == 0
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] + 1 : -(eb[var3] + 1)), this.ea[var3] - 1) & 3) == 0
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] + 1 : -(eb[var3] + 1)), this.ea[var3]) & 3) != 0
                                 && (this.h(this.dZ[var3] + (var16 > 0 ? eb[var3] + 1 : -(eb[var3] + 1)), this.ea[var3]) & 3) != 0
                                 && var18 < 144) {
                                 if (eu[var3] < 0) {
                                    this.i(1, var3);
                                 } else {
                                    eu[var3] = eu[var3] - this.L;
                                 }
                              }
                           }

                           if (var95 == 0 && var18 < 16 * (3 + (dM == var3 ? 1 : 0)) && var19 < 16 && this.ge < 0) {
                              if (Math.abs(this.N & 3) == 3) {
                                 if (dM == var3 && (this.N & 1) != 0) {
                                    this.i(12, var3);
                                 } else {
                                    this.i(6, var3);
                                 }
                              } else {
                                 this.i(3, var3);
                              }

                              if (!fR) {
                                 this.ej[var3] = var16 >= 8;
                              }
                           }
                     }
                  }
               } else if ((var3 == this.dL || this.dX[var3] > 0) && this.dX[var3] <= 0 && var20) {
                  if (this.aY[this.ba + 1] == 0 && this.aZ[this.bb] == 0) {
                     this.C();
                  } else if (this.aZ[this.bb + 1] == 0) {
                     this.i(this.aZ[this.bb], var3);
                  } else {
                     this.bb++;
                     this.i(this.aZ[this.bb], var3);
                  }
               }

               if (this.dX[var3] <= 500) {
                  this.d(this.dZ[var3], this.ea[var3], var3);
               }

               if (!eA
                  && !this.ei[var3]
                  && !this.eh[var3]
                  && this.dS[var3] != 1
                  && (
                     this.dQ[var3] == 1 && this.dR[var3] != 11 && this.dR[var3] != 27 && this.dR[var3] != 3 && this.dR[var3] != 11 && this.dR[var3] != 24
                        || this.dQ[var3] == 2 && this.dR[var3] != 8 && this.dR[var3] != 14
                        || this.dQ[var3] == 3 && this.dR[var3] != 10 && this.dR[var3] != 18
                  )
                  && this.dN != var3) {
                  switch (this.dQ[var3]) {
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

               if (!ex && (this.dR[var3] == 1 || this.dR[var3] == 18 || this.dR[var3] == 1 || this.dR[var3] == 1)) {
                  switch (this.dQ[var3]) {
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

            if (I != 105 && dT[var3] < 0 && (ec[var3] > 0 || iN)) {
               er[var3] = er[var3] - this.L;
               if (er[var3] <= 0 && this.bM < 9 && (Math.abs(dV[var3] - this.ga) > 32 || Math.abs(dW[var3] - this.gb) > 32)) {
                  if ((this.h(dV[var3] / 16, dW[var3] / 16 - 1) & 1) == 0 && (this.h(dV[var3] / 16, dW[var3] / 16 - 1) & 2) == 0) {
                     ec[var3]--;
                     er[var3] = this.et[var3];
                     this.eh[var3] = false;
                     dT[var3] = dV[var3];
                     this.dU[var3] = dW[var3];
                     ek[var3] = en[var3];
                     this.dZ[var3] = dT[var3] / 16;
                     this.ea[var3] = this.dU[var3] / 16;
                     this.b(this.dZ[var3], this.ea[var3] - 1, 2);
                     this.a(dT[var3], this.dU[var3], 25, 0, false);
                     switch (this.dQ[var3]) {
                        case 1:
                           if (this.eh[var3]) {
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
                     er[var3] = 1500;
                  }
               }
            }

            this.a(var85, var78, var3 + 85, ew, this.ej[var3]);

            for (byte var103 = 0; var103 < this.ht.length; var103 += 5) {
               if (this.ht[var103 + 2] != 0) {
                  int var97;
                  if (hb || hc) {
                     var97 = 0;
                  } else if (var103 == 0) {
                     var97 = this.fO;
                  } else {
                     var97 = this.fP;
                  }

                  if (var97 < 2 && a(this.ht[var103], this.ht[var103 + 1], this.ht[var103 + 2], this.ht[var103 + 3], ew[0], ew[1], ew[2], ew[3])) {
                     int var105 = ew[0] + (this.ej[var3] ? ew[7] : 0);
                     int var23 = ew[1] + (ew[3] >> 1);
                     if (ew[1] < ew[3]) {
                        var23 = ew[3];
                     } else if (var23 > this.dU[var3]) {
                        var23 = this.dU[var3];
                     }

                     var97++;
                     int var24 = hb ? fJ[this.gG] << gQ : fI[this.gG] << gP;
                     if (this.D) {
                        var24 = 10000;
                     }

                     if (hb) {
                        hl = hl - ((fJ[this.gG] << 1) + fJ[this.gG]);
                     }

                     if (hb && !this.gp && hf < 3 || !hb && !hc) {
                        ek[var3] = ek[var3] - var24;
                        if (!hb) {
                           if (!var66) {
                              this.y(3 + (this.N & 1));
                           }

                           if (var97 == 1) {
                              gH++;
                           }
                        } else if (!var66) {
                           this.y(3 + (this.N & 1));
                        }

                        var66 = true;
                        this.iB = true;
                        this.gI = 2000;
                     } else if (hc) {
                        this.dX[var3] = this.dX[var3] + (fK[gV] << 5) + this.L;
                     }

                     if (ek[var3] <= 0 && this.dS[var3] != 1) {
                        ek[var3] = -1;
                        if (!this.ei[var3] && !this.eh[var3]) {
                           if (eA) {
                              if (var90 == 1) {
                                 this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 0, this.em[var3]);
                                 this.i(9, var3);
                              } else if (var90 == 2) {
                                 this.i(7, var3);
                                 this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 2, this.em[var3]);
                              } else if (var90 == 3) {
                                 if (var95 == 12 && dM != var3) {
                                    this.i(13, var3);
                                    this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 1, this.em[var3]);
                                 } else if (dM != var3 && this.dN != var3) {
                                    this.i(7, var3);
                                    this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 0, this.em[var3]);
                                 } else {
                                    ek[var3] = (en[var3] >> 1) - 1;
                                 }
                              }
                           }
                        } else {
                           this.i(11, var3);
                        }

                        this.a(var105, var23, 0, !hu ? 2 : 0, true);
                     } else if (this.dS[var3] != 1 && this.dS[var3] != 3) {
                        if (this.dX[var3] <= 0) {
                           if (this.ei[var3]) {
                              this.i(17, var3);
                           } else if (this.eh[var3]) {
                              this.i(20, var3);
                           } else {
                              this.ej[var3] = var16 > 0;
                              if (var90 == 1) {
                                 if (this.ge == -1 && hB != 60 && hB != 77) {
                                    this.i(2, var3);
                                 } else {
                                    this.i(7, var3);
                                 }
                              } else if (var90 == 2) {
                                 if (this.ge == -1 && hB != 60 && hB != 77) {
                                    this.i(2, var3);
                                 } else {
                                    this.i(9, var3);
                                 }
                              } else if (var90 == 3) {
                                 if (var95 == 12 && dM != var3) {
                                    this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 1, this.em[var3]);
                                    this.i(13, var3);
                                 } else if ((dM == var3 || this.ge == -1) && hB != 60 && hB != 77) {
                                    this.i(4, var3);
                                 } else {
                                    this.i(8, var3);
                                 }
                              }

                              if (!fR) {
                                 this.ej[var3] = dT[var3] - this.ga <= 0;
                              }
                           }
                        }

                        if ((!hb || hb && hf < 3) && !hc) {
                           hf++;
                           this.a(var105, var23, 0, !hu ? 2 : 0, true);
                        }
                     }

                     if (!hb && !hc && this.ge != -1) {
                        this.ht[var103] = 0;
                        this.ht[var103 + 1] = 0;
                        this.ht[var103 + 2] = 0;
                        this.ht[var103 + 3] = 0;
                     }

                     if (var103 == 0) {
                        this.fO = var97;
                     } else {
                        this.fP = var97;
                     }
                  }

                  if (var97 < 2 && a(this.ht[var103], this.ht[var103 + 1], this.ht[var103 + 2], this.ht[var103 + 3], ew[5], ew[6], ew[7], ew[8])) {
                     int var106 = ew[5] + (this.ej[var3] ? ew[7] : 0);
                     int var107 = this.ht[var103 + 1] + (this.ht[var103 + 3] >> 1);
                     var97++;
                     int var108 = hb ? fJ[this.gG] << gQ : fI[this.gG] << gP;
                     if (this.D) {
                        var108 = 10000;
                     }

                     if (hb && hf < 3 || !hb && !hc) {
                        label2440: {
                           ek[var3] = ek[var3] - var108;
                           if (!hb) {
                              if (!var66) {
                                 this.y(3 + (this.N & 1));
                              }

                              if (var97 != 1) {
                                 break label2440;
                              }
                           } else if (!var66) {
                              this.y(3 + (this.N & 1));
                           }

                           gH++;
                        }

                        this.iB = true;
                        var66 = true;
                        this.gI = 2000;
                     } else if (hc) {
                        this.dX[var3] = this.dX[var3] + (fK[gV] << 5) + this.L;
                     }

                     if (ek[var3] <= 0 && this.dS[var3] != 1) {
                        ek[var3] = -1;
                        if (this.ei[var3] || this.eh[var3]) {
                           this.i(11, var3);
                        } else if (eA) {
                           if (var90 == 1) {
                              this.i(8, var3);
                              this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 0, this.em[var3]);
                           } else if (var90 == 2) {
                              this.i(7, var3);
                              this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 2, this.em[var3]);
                           } else if (var90 == 3) {
                              if (var95 == 12 && dM != var3 && this.dN != var3) {
                                 this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 1, this.em[var3]);
                                 this.i(13, var3);
                              } else if (dM != var3 && this.dN != var3) {
                                 this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 0, this.em[var3]);
                                 this.i(7, var3);
                              } else {
                                 ek[var3] = (en[var3] >> 1) - 1;
                              }
                           }
                        }

                        this.a(var106, var107, 0, !hu ? 2 : 0, true);
                     } else if (this.dS[var3] != 1 && this.dS[var3] != 3) {
                        if (this.dX[var3] <= 0) {
                           if (this.ei[var3]) {
                              this.i(17, var3);
                           } else if (this.eh[var3]) {
                              this.i(20, var3);
                           } else {
                              this.ej[var3] = var16 > 0;
                              if (var90 == 1) {
                                 if (this.ge == -1 && hB != 60 && hB != 77) {
                                    this.i(2, var3);
                                 } else {
                                    this.i(7, var3);
                                 }
                              } else if (var90 == 2) {
                                 if (this.ge == -1 && hB != 60 && hB != 77) {
                                    this.i(2, var3);
                                 } else {
                                    this.i(9, var3);
                                 }
                              } else if (var90 == 3) {
                                 if (this.ge == -1 && hB != 60 && hB != 77) {
                                    this.i(4, var3);
                                 } else {
                                    this.i(8, var3);
                                 }
                              }
                           }
                        }

                        if ((!hb || hb && hf < 3) && !hc) {
                           hf++;
                           this.a(var106, var107, 0, !hu ? 2 : 0, true);
                        }
                     }

                     if (!hb && this.ge != -1) {
                        this.ht[var103] = 0;
                        this.ht[var103 + 1] = 0;
                        this.ht[var103 + 2] = 0;
                        this.ht[var103 + 3] = 0;
                     }

                     if (var103 == 0) {
                        this.fO = var97;
                     } else {
                        this.fP = var97;
                     }
                  }
               }
            }

            if (ew[12] > 0 && a(this.ga - this.hx, this.gb - this.gD, gC, this.gD, ew[10], ew[11], ew[12], ew[13])) {
               byte var104 = this.el[var3];
               if (this.dR[var3] == 6) {
                  var104 <<= 1;
               }

               if (dM != var3) {
                  var104 <<= 1;
               }

               if (dM != var3 && this.dR[var3] == 12) {
                  var104 <<= 2;
               }

               if (!this.hw) {
                  if (!this.ey) {
                     this.hj -= var104;
                     if (this.hj < 0) {
                        this.hj = 0;
                     }
                  }
               } else {
                  this.gi = true;
               }

               this.gf = !this.ej[var3];
            }
         }

         if (this.dX[var3] > 0) {
            this.dX[var3] = this.dX[var3] - (this.L + (en[var3] >> 6));
         }
      }
   }

   private void A() {
      hc = false;
      this.hd = false;
      hb = false;
      this.fM = 0;
   }

   private int B() {
      int var1;
      do {
         var1 = Math.abs(this.N % 5);
         this.N = O.nextInt();
      } while (this.fT == var1);

      return var1;
   }

   private void C() {
      this.ba += 2;
      this.bb += 2;
      this.cs++;
      if (this.cs >= this.cu) {
         this.a(0, 0, 35, 35);
         I = 100;
         this.iB = true;
         this.aW = false;
         this.cu = -1;
         this.cs = -1;
         this.ct = -1;
      } else {
         this.ct = this.cs;
         this.p();
         if (!this.be) {
            I = 101;
         } else {
            this.iI = false;
            this.bC++;
            if (this.bC > this.bD && (this.bE <= 0 || this.bC < this.bE)) {
               this.bD = this.bC;
            }

            this.bA++;
            this.bA = bB[this.bC];
            this.bf = true;
            this.v = false;
            this.ae = true;
            this.a(H, H, 35, 35);
            I = 109;
            this.ae = true;
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
         if (this.dQ[var1] == 1) {
            var3 = this.dC;
         } else if (this.dQ[var1] == 2) {
            var3 = dD;
         } else if (this.dQ[var1] == 3) {
            if (dM != var1) {
               var3 = this.dE;
            } else {
               var3 = this.dF;
            }
         }

         var5 = this.ej[var1];
         var6 = dT[var1];
         var7 = this.dU[var1];
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
         var6 = fd[var1];
         var7 = this.fe[var1];
      }

      int var8 = this.a(this.hM, var4, var5 ? 0 : 2);
      if (this.hN + var8 < 1000) {
         this.hN += var8;

         for (int var9 = 0; var9 < var8; var9++) {
            int var10 = var9 << 2;
            this.iO.b(var3[this.hM[var10]], var6 + this.hM[var10 + 1], var7 + this.hM[var10 + 2], this.hM[var10 + 3]);
         }
      }
   }

   private static int u(int var0) {
      return dT[var0] / 16;
   }

   private int v(int var1) {
      int var2;
      return (var2 = this.dU[var1] / 16) > iY ? iY : var2;
   }

   private void d(int var1, int var2, int var3) {
      int var6 = dT[var3];
      int var7 = this.dU[var3];
      boolean var8 = this.ej[var3];
      short var9 = this.ef[var3];
      int var10 = this.ee[var3] >> 1;
      int var11 = (super.a > 0 ? super.a : -super.a) << 8;
      int var12 = (super.b > 0 ? super.b : -super.b) << 8;
      int var13 = var11;
      int var14 = var12;
      if (super.a != 0) {
         var6 += (!this.ej[var3] || super.a <= 0) && (this.ej[var3] || super.a >= 0) ? -var10 : var10 - 1;
      }

      if (super.b < 0) {
         var7 -= var9;
         this.dU[var3] = this.dU[var3] - var9;
      } else {
         var7--;
      }

      int var15 = var1;
      int var16 = this.v(var3);
      this.eo[var3] = var6 - var1 * 16 << 8;
      if (this.eo[var3] < 0) {
         var15--;
         this.eo[var3] = this.eo[var3] + 4096;
      } else if (this.eo[var3] > 4096) {
         var15++;
         this.eo[var3] = this.eo[var3] - 4096;
      }

      this.ep[var3] = var7 - var16 * 16 << 8;
      if (super.a != 0) {
         var6 -= (!var8 || super.a <= 0) && (var8 || super.a >= 0) ? -var10 : var10 - 1;
      }

      if (super.b < 0) {
         var7 += var9;
         this.dU[var3] = this.dU[var3] + var9;
      } else {
         var7++;
      }

      ex = true;
      this.ez = true;
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
      if ((!var8 || super.a <= 0) && (var8 || super.a >= 0)) {
         var4 = -var11;
      } else {
         var4 = var11;
      }

      int var5 = super.b > 0 ? var12 : -var12;
      int var17 = 0;
      int var18 = 0;
      this.hI = 0;
      this.hJ = 0;
      if (super.a != 0 && !this.eh[var3] && this.dS[var3] != 1) {
         this.e(this.dZ[var3], this.ea[var3] - 1 - (super.b < 0 ? this.eg[var3] : 0), var3);
      }

      while (var17 < var13 || var18 < var14) {
         this.eo[var3] = this.eo[var3] + var4;
         this.ep[var3] = this.ep[var3] + var5;
         if (this.eo[var3] >= 4096) {
            this.eo[var3] = this.eo[var3] - 4096;
            var15++;
         } else if (this.eo[var3] < 0) {
            this.eo[var3] = this.eo[var3] + 4096;
            var15--;
         }

         if (this.ep[var3] >= 4096) {
            this.ep[var3] = this.ep[var3] - 4096;
            var16++;
         } else if (this.ep[var3] < 0) {
            this.ep[var3] = this.ep[var3] + 4096;
            var16--;
         }

         this.hF = false;
         this.e(var15, var16, var3);
         if (ex) {
            this.hI += var4;
            var17 += var11;
         } else {
            this.eo[var3] = this.eo[var3] - var4;
            var13 = var17;
            if ((this.h(var1, var2) & 1) != 0 && !this.hF) {
               this.hI = 0;
               this.hF = true;
               if ((!this.ej[var3] || super.a <= 0) && (this.ej[var3] || super.a >= 0)) {
                  dT[var3] = var1 * 16 + (this.ee[var3] >> 1);
               } else {
                  dT[var3] = (var1 + 1) * 16 - (this.ee[var3] >> 1);
               }
            }
         }

         if (this.ez) {
            this.hJ += var5;
            var18 += var12;
         } else {
            this.ep[var3] = this.ep[var3] - var5;
            var14 = var18;
         }
      }

      var6 += this.hI >> 8;
      var7 += this.hJ >> 8;
      if (var17 > var13) {
         int var19 = var17 - var13 >> 8;
         var6 -= var4 > 0 ? var19 : -var19;
      }

      if (var18 > var14) {
         int var24 = var18 - var14 >> 8;
         var7 -= var5 > 0 ? var24 : -var24;
      }

      if (ex && !this.hF) {
         dT[var3] = var6;
      }

      if (this.ez) {
         this.ea[var3] = var7 / 16;
         this.dU[var3] = var7;
      }

      this.b(this.dZ[var3], this.ea[var3] - 1, 2);
   }

   private void D() {
      this.ey = false;
      this.im = 0;
      this.il = 0;
      this.be = false;
      this.ba = 0;
      this.dO = 0;
      this.bb = 0;
      this.aY = new int[40];
      this.aZ = new int[40];
      this.as = false;
      this.hO = -1;
      this.ay = -1;
      this.aA = 0;
      this.az = -1;
      this.eB = 0;
      eX = -1;
      this.dz = -1;
      dM = -1;
      this.dN = -1;
      eX = -1;
      this.dp = -1;
      this.bM = -1;
      bW = -1;
      ck = -1;
      this.cx = -1;
      cI = -1;
      this.eZ = -1;
      this.fm = -1;
      this.fG = -1;
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
      this.fl = null;
      this.dq = null;
      this.eM = null;
      this.fH = null;
      this.aW = false;
      this.aD = -1;
      this.i();
      this.iO = null;
      this.iP = null;
   }

   private void e(int var1, int var2, int var3) {
      short var4 = this.ef[var3];
      boolean var5;
      boolean var6 = (var5 = this.ej[var3]) && super.a > 0 || !var5 && super.a < 0;
      int var7 = 0;
      boolean var8 = false;
      this.hE = false;
      this.hF = false;

      for (short var9 = var4; var9 > 0 && ex; var9 -= 16) {
         if (var2 < iY) {
            if (var2 - var7 < 0 || var2 - var7 >= iY) {
               break;
            }

            if (var9 > 0) {
               if (ex && var1 >= 0) {
                  ex = (this.h(var1, var2 - var7) & 1) == 0;
                  if (var7 == 0) {
                     var8 = !ex && (this.h(var1, var2 - var7 - 1) & 1) == 0;
                  }

                  boolean var10 = ex;
                  if (this.dQ[var3] == 1 && this.dR[var3] == 1 || this.dQ[var3] == 2 && this.dR[var3] == 1 || this.dQ[var3] == 3 && this.dR[var3] == 1) {
                     ex = ex & ((this.h(var1, var2 - var7) & 2) == 0 || !eA || this.eh[var3] || var1 == this.dZ[var3]);
                  }

                  if (var10 != ex) {
                     eu[var3] = 1500;
                  }
               }

               if (!ex) {
                  this.hF = true;
                  if (var8 && super.a > 0 && (this.ej[var3] || super.a < 0 && !this.ej[var3]) && super.b == 0 && (this.h(var1, var2 - var7 - 1) & 1) == 0) {
                     switch (this.dQ[var3]) {
                        case 1:
                           this.i(3, var3);
                        case 2:
                        case 3:
                     }
                  }
                  break;
               }
            }

            if (var1 < 0 || var1 >= iX) {
               ex = false;
               var5 = !var5;
            }

            if (super.b >= 0) {
               var7++;
            } else {
               var7--;
            }

            if (this.dQ[var3] == 1 && this.eh[var3] && this.dR[var3] != 26 && var9 - 16 < 0 && (this.h(var1, var2 - var7) & 16) == 0) {
               ex = false;
               this.i(26, var3);
               this.dU[var3]++;
               break;
            }
         }
      }

      if (ex && this.dR[var3] == 1 || this.dR[var3] == 0) {
         ex = (this.h(var1, var2 + 1) & 1) == 1;
      }

      int var27 = var1;
      if (super.a == 0 && super.b != 0) {
         var27 += var5 ? 1 : -1;
      }

      if (super.b >= 0) {
         var7 = this.eg[var3];
         if (this.ep[var3] < 2048) {
            var7++;
         }
      } else {
         var7 = 0;
      }

      int var28 = var2 - var7;
      int var11 = var5 ? -1 : 1;
      if (this.dQ[var3] == 1
         && (this.h(var27, var28 - 1) & 1) == 0
         && ((this.h(var27, var28) & 1) != 0 || this.eq[var3])
         && (this.h(var27 + var11, var28) & 1) == 0
         && (this.h(var27 + var11, var28 - 1) & 1) == 0
         && (this.h(var27 + var11, var28 + this.eg[var3]) & 1) == 0
         && super.b != 0
         && (!this.ei[var3] || this.eq[var3])
         && !eA
         && this.dR[var3] != 21
         && this.dR[var3] != 11) {
         if (this.eq[var3] && super.b < 0) {
            this.i(21, var3);
            int var29 = 0;
            if ((this.h(var27, var2) & 1) == 0) {
               var29++;
            }

            this.dU[var3] = (var2 + var29) * 16 + var4;
         }

         this.hJ = 0;
         if (!var5) {
            var27++;
         }

         this.hF = true;
         dT[var3] = var27 * 16 + (var5 ? -(this.ee[var3] >> 1) : this.ee[var3] >> 1);
         this.hI = 0;
         this.ez = false;
         ex = false;
      } else {
         if (!ex && super.a != 0) {
            var7 = var6 ? -1 : 1;
         } else {
            var7 = 0;
         }

         int var12 = var2;
         int var13;
         if ((var13 = super.b > 0 ? var12 - this.eg[var3] : var12 + this.eg[var3]) < 0) {
            var13 = 0;
         }

         if (super.b != 0) {
            for (short var14 = this.ee[var3]; var14 > 0; var14 -= 16) {
               if (var1 + var7 >= 0 && var1 + var7 < iX) {
                  if (this.ez) {
                     this.ez = (this.h(var1 + var7, var12) & 1) == 0;
                     if (this.dQ[var3] == 1 && !this.dA && ek[var3] > 0 && (this.h(var1 + var7, var13) & 16) != 0) {
                        this.dU[var3] = (var13 + 1) * 16 + var4;
                        this.ez = false;
                        this.hJ = 0;
                        this.i(26, var3);
                     }
                  }

                  if (!this.ez && super.b > 0 && !this.eh[var3] && this.dR[var3] != 21) {
                     this.dU[var3] = var2 * 16;
                     this.hJ = 0;
                     this.hE = true;
                     eA = true;
                     switch (this.dQ[var3]) {
                        case 1:
                           if (ek[var3] < 0) {
                              this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 0, this.em[var3]);
                              this.i(8, var3);
                           } else {
                              if (this.dR[var3] == 25) {
                                 break;
                              }

                              if (this.dR[var3] != 3 && this.dR[var3] != 27) {
                                 this.i(7, var3);
                                 break;
                              }

                              this.i(25, var3);
                           }
                           break;
                        case 2:
                           if (ek[var3] < 0) {
                              this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 2, this.em[var3]);
                              this.i(7, var3);
                           } else if (this.dR[var3] != 14) {
                              this.i(9, var3);
                           }
                           break;
                        case 3:
                           this.av += 6;
                           if (eA) {
                              ex = true;
                           }

                           if (this.dR[var3] != 6 && dM != var3) {
                              if (ek[var3] < 0) {
                                 this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 0, this.em[var3]);
                                 this.i(7, var3);
                              } else if (this.dR[var3] != 18) {
                                 this.i(8, var3);
                              }
                           } else if (dM != var3) {
                              if (this.gy && this.ge < 0 && this.dG < 64 && hB != 52 && hB != 53 && hB != 48) {
                                 this.s(27);
                              }
                           } else if (ek[var3] < 0) {
                              this.i(7, var3);
                              this.b(dT[var3], this.dU[var3] - (this.ef[var3] >> 1), 0, this.em[var3]);
                           } else {
                              dT[var3]++;
                           }
                     }
                  }

                  if (!this.ez) {
                     break;
                  }

                  if (var12 < 0 || var12 >= iY) {
                     this.ez = false;
                  }

                  if (super.a == 0) {
                     break;
                  }
               }

               var7 = var6 ? --var7 : ++var7;
            }
         }

         if (this.ei[var3] && this.dR[var3] != 21) {
            int var30 = var1;
            var1 += var5 ? 1 : -1;
            if ((this.h(var1, var12) & 8) == 0) {
               this.ez = false;
               this.dU[var3] = (var12 + (super.b < 0 ? 1 : -this.eg[var3] - 1)) * 16 + var4;
               this.eq[var3] = true;
            }

            var1 = var30;
         } else {
            this.eq[var3] = false;
         }

         if (!ex && super.a != 0 && !this.hE && !this.ei[var3]) {
            if ((!var5 || super.a <= 0) && (var5 || super.a >= 0)) {
               this.hF = true;
               int var32;
               int var33 = (var32 = (var1 + 1) * 16 + (this.ee[var3] >> 1) + 1) + (this.ee[var3] >> 1);
               int var34 = var32 / 16;
               int var35 = var33 / 16;
               int var36 = var34 < var35 ? 1 : -1;
               boolean var37 = true;
               int var38 = Math.abs(var35 - var34);

               for (int var39 = 0; var39 <= var38; var39++) {
                  var37 &= (this.h(var34 + var39 * var36, var2) & 1) == 0;
               }

               if (var37) {
                  dT[var3] = var32;
               }

               if (this.dQ[var3] == 1
                  && ek[var3] > 0
                  && !this.dA
                  && (this.h(var1, var12 + (super.b > 0 ? -1 : 1)) & 8) != 0
                  && (this.h(var1, var12 + (super.b > 0 ? -this.eg[var3] : this.eg[var3])) & 8) != 0
                  && super.b != 0) {
                  this.i(23, var3);
               }
            } else {
               this.hF = true;
               int var31;
               int var15 = (var31 = var1 * 16 - (this.ee[var3] >> 1) - 1) - (this.ee[var3] >> 1);
               int var16 = var31 / 16;
               int var17 = var15 / 16;
               int var18 = var16 < var17 ? 1 : -1;
               boolean var19 = true;
               int var20 = Math.abs(var17 - var16);

               for (int var21 = 0; var21 <= var20; var21++) {
                  var19 &= (this.h(var16 + var21 * var18, var2) & 1) == 0;
               }

               if (var19) {
                  dT[var3] = var31;
               }

               if (this.dQ[var3] == 1
                  && ek[var3] > 0
                  && !this.dA
                  && (this.h(var1, var12 + (super.b > 0 ? -1 : 1)) & 8) != 0
                  && (this.h(var1, var12 + (super.b > 0 ? -this.eg[var3] : this.eg[var3])) & 8) != 0
                  && super.b != 0) {
                  this.i(23, var3);
               }
            }

            this.hI = 0;
         }
      }
   }

   private void w(int var1) {
      int var2 = dV[var1] / 16;
      int var3 = dW[var1] / 16;
      if ((this.h(var2, var3) & 32) > 0) {
         int var4 = -1;

         for (int var5 = 0; var5 < this.da.length; var5++) {
            if (a(var2, var3, this.da[var5], this.db[var5], this.dc[var5], dd[var5])) {
               var4 = var5;
            }
         }

         if (var4 != -1) {
            df[var4]++;
            if (df[var4] >= this.dg[var4]) {
               this.dg[var4] = -1;
               df[var4] = -1000000;

               for (int var6 = cI; var6 >= 0; var6--) {
                  if (this.cS[var6] == this.de[var4]) {
                     cV[var6] = !cV[var6];
                     if (this.cW[var6]) {
                        this.iB = true;
                        this.ay = cM[var6];
                        this.az = this.cN[var6];
                     }
                  }
               }
            }
         }
      }
   }

   private void x(int var1) {
      for (int var2 = var1 << 2; var2 < (var1 << 2) + 4; var2++) {
         if (this.cH[var2] != 0) {
            for (int var3 = cI; var3 >= 0; var3--) {
               if (this.cS[var3] == this.cH[var2]) {
                  cV[var3] = !cV[var3];
                  if (this.cW[var3]) {
                     this.ay = cM[var3];
                     this.az = this.cN[var3];
                     this.iB = true;
                  }
               }
            }
         }
      }
   }

   private void a(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = var3;
      if (var5) {
         int var7 = this.gG - 1;
         if (!hb && hB == 60) {
            var7 = 6;
         }

         byte var8;
         if (this.gp) {
            if (hb) {
               var8 = 17;
            } else {
               var8 = 8;
            }
         } else if (hb) {
            var8 = 11;
         } else {
            var8 = 1;
         }

         var6 = var8 + var7;
      }

      if (this.bM < 9 && (var3 != 0 || this.bM < 9)) {
         this.bM++;
         if (bI[this.bM] < 0) {
            this.bL[this.bM] = var4;
            this.bJ[this.bM] = var1;
            this.bK[this.bM] = var2;
            bI[this.bM] = this.bM;
            this.a(this.bM, 7168, var6);
         }
      }
   }

   private void a(int[] var1, byte[] var2) {
      this.hQ = 220;
      this.a(this.q);
      this.a(var1, var2, 12, 30, 211, 270, this.hQ);
   }

   private void E() {
      this.M = this.M + this.L;
      if (this.M >= 50) {
         this.M = 0;
         if (this.t == 1) {
            this.d(true);
            this.h();
         }

         if (this.t == 6) {
            this.d(false);
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
      if (var1 != 3 && var1 != 3 && var1 != 3 && var1 != 3) {
         if (var1 == 0 || var1 == 2 || var1 == 1) {
            if (!this.hR) {
               this.iM.a(var1);
               if (var1 == 0 && iL) {
                  this.hR = true;
               }
            }
         }
      }
   }

   private void F() {
      this.hR = false;
      this.iM.c();
   }

   private void u(Graphics var1) {
      this.v(var1);
      if (!iT) {
         this.iS[1].a(var1, 120, H, 0);
         this.iS[0].a(var1, 120, H, 0);
      } else {
         this.a(var1, this.iS, 0, 120, H, 0);
      }
   }

   private void v(Graphics var1) {
      this.b(var1);
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
      this.h();
      int var10 = 0;
      String var11 = "";
      this.ii = 0;

      for (int var8 = 0; var8 < var1.length; var8++) {
         byte var12 = var2[var8];
         int var14;
         if ((var14 = var1[var8]) >= 0) {
            var11 = this.e(var1[var8]);
         } else if (var14 == -1) {
            hW[var10] = "";
            hY[var10++] = var12;
            var11 = "";
         } else if (var14 == -3) {
            var11 = hX[var9++];
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
            if (this.cr >= 0 && var10 % 5 * z < this.cp[0].d << 1) {
               var17 = var5 - (this.cp[0].c + 8);
            } else {
               var17 = var5 - 1 - 4;
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
            this.ii = this.ii + z;
            var16 = var15 = var21 + 1;
         }
      }

      hZ = var10;
      ia = 0;
      this.il = 0;
      ic = false;
      this.j();
   }

   private static void G() {
      hW = null;
      hY = null;
      hX = null;
   }

   private void d(boolean var1) {
      if (var1) {
         if (ia > 0) {
            ia--;
            this.h();
            return;
         }
      } else if (ia < hZ && !ic) {
         ia++;
         this.h();
      }
   }

   private void a(Graphics var1, boolean var2) {
      this.a(var1, 0, hT, 240, hV);
      byte var4 = 0;
      this.ip = true;
      if (hV / z >= hZ) {
         var4 = 2;
      }

      int var6 = hT;
      if (this.aW) {
         var6 = 295 - (this.in >> 8);
      } else if (I == 79) {
         var6 += 25;
      }

      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      if (I == 101) {
         var6 -= this.c() >> 1;
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
         if (this.cr >= 0 && var6 - z - hT < this.cp[0].d) {
            var7 += this.cp[0].c + 8;
         }

         String var13 = hW[var11];
         if (I == 101 && !var13.equals("")) {
            if (var13.length() > this.bd - this.io) {
               var13 = var13.substring(0, this.bd - this.io);
               this.io = this.io + var13.length();
               this.ip = false;
            } else {
               this.io = this.io + var13.length();
            }
         }

         if (var3 != ia || ib == -1) {
            this.a(this.q);
         } else if (this.o != null) {
            this.a(this.p);
         } else {
            this.a(this.q);
         }

         this.h();
         this.a(var1, var3 == ia && ib != -1 ? var13.substring(this.ij, this.ik) : var13, var7, var6, var12);
         var6 += z;
         if (I == 101 && var6 >= hV && var11 < hZ) {
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
      this.b(var1);
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
            if ((var15 = var17 + (bj > 0 ? 4 - bj : 0)) > 8) {
               var15 = 5 + (var15 - 8) - 1;
            }

            aL[40].a(var1, hS + (this.cp[this.cr].c >> 3) - aL[40].a, hT + z - aL[40].b, 0);
            aL[var15].a(var1, 13 - aL[var15].a + var19, 15 - aL[var15].b + var20, 0);
         } else {
            this.cp[this.cr].a(var1, hS + (this.cp[this.cr].c >> 3), hT + z, 0);
         }

         this.a(136, 1024, 0);
         this.a(var1, this.cp, 136, hS + (this.cp[this.cr].c >> 3), hT + z, 0);
      }

      if ((var11 < hZ - 1 || this.cs < this.cu - 1) && I == 101) {
         bo[1].a(var1, G, 79 - bo[1].d - 2, 0);
      }
   }

   private void z(int var1) {
      iq = new byte[76];
      int var2 = 0;
      var2 = a(gP, iq, 0);
      var2 = a(gQ, iq, var2);
      var2 = a(gN, iq, var2);
      var2 = a(this.gO, iq, var2);
      var2 = a(gV, iq, var2);
      var2 = a(gW, iq, var2);
      var2 = a(this.ho, iq, var2);
      var2 = a(this.hp, iq, var2);
      var2 = a(this.hq, iq, var2);
      var2 = a(this.gZ, iq, var2);
      var2 = a(this.ha, iq, var2);
      var2 = a(this.gX, iq, var2);
      var2 = a(this.gY, iq, var2);
      var2 = a(this.bD, iq, var2);
      var2 = a(hr, iq, var2);
      var2 = a(this.hs, iq, var2);
      var2 = a(he, iq, var2);
      if (this.dI > this.hz && iN) {
         this.hz = this.dI;
      }

      a(this.hz, iq, var2);
      this.H();
      a.a(var1 + 1, iq);
      this.H();
   }

   private void A(int var1) {
      iq = a.a(var1 + 1);
      if (iq == null) {
         gN = 3;
         this.gO = 2;
         gV = 0;
         gW = 0;
         this.ho = 0;
         this.hp = 0;
         this.hm = 1024;
         this.hn = 1024;
         this.hq = 0;
         this.gZ = 0;
         this.ha = 0;
         this.gX = 0;
         this.gY = 0;
         gP = 0;
         gQ = 0;
         this.bC = 0;
         this.bD = 0;
         hr = 0;
         this.hs = 0;
         he = 0;
         this.hz = 0;
      } else {
         gP = (byte)a(iq, 0);
         gQ = (byte)a(iq, 4);
         gN = (byte)a(iq, 8);
         this.gO = (byte)a(iq, 12);
         if (gN < 3) {
            gN = 3;
         }

         if (this.gO < 2) {
            this.gO = 2;
         }

         gV = (byte)a(iq, 16);
         gW = (byte)a(iq, 20);
         this.ho = a(iq, 24);
         this.hp = a(iq, 28);
         this.hm = this.ho * 192 + 1024;
         this.hn = this.hp * 192 + 1024;
         this.hq = a(iq, 32);
         this.gZ = a(iq, 36);
         this.ha = a(iq, 40);
         this.gX = a(iq, 44);
         this.gY = a(iq, 48);
         this.bD = a(iq, 52);
         this.bC = this.bD;
         hr = a(iq, 56);
         this.hs = a(iq, 60);
         he = a(iq, 64);
         this.hz = a(iq, 68);
      }

      this.H();
   }

   private void H() {
      for (int var1 = 0; var1 < 10; var1++) {
         if (var1 <= this.bD) {
            iw[9 + var1] = iw[9 + var1] = iw[9 + var1] | 50331648;
         } else {
            iw[9 + var1] = iw[9 + var1] & -50331649;
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

   private void I() {
      int var2 = 240 - (this.iu - (this.iu >> 2));
      if (ir == null) {
         ir = new byte[var2 * 140];
         is = new int[var2 * 140];
      }

      int var3 = 0;
      if (it) {
         for (int var4 = 0; var4 < var2; var4++) {
            if ((var4 & 3) == 0) {
               var3 = O.nextInt();
            } else {
               var3 >>= 8;
            }

            ir[var4 + 139 * var2] = (byte)(var3 & 0xFF);
            ir[var4 + 138 * var2] = (byte)Math.max(0, (ir[var4 + 139 * var2] & 255) - 4);
            it = false;
         }
      } else {
         it = true;
      }

      for (int var5 = 1; var5 < 139; var5++) {
         int var1 = var5 * var2;

         for (int var6 = 0; var6 < var2; var6++) {
            int var9 = var6 + var1;
            int var7 = (ir[var9] & 255) + (ir[var9 + var2] & 255);
            if (var5 > 35) {
               var7 = var7 + (ir[var9 + 1] & 255) + (ir[var9 - 1] & 255) >> 2;
            } else {
               var7 >>= 1;
            }

            var7 -= 2;
            if (var7 < 0) {
               var7 = 0;
            }

            ir[var9 - var2] = (byte)var7;
         }
      }

      int var10 = 0;

      for (int var14 = 0; var14 < 140; var14++) {
         for (int var8 = 0; var8 < var2; var8++) {
            int var11 = Math.max(ir[var10] & 255, 0);
            is[var10] = R[var11];
            var10++;
         }
      }
   }

   private void b(Graphics var1, boolean var2) {
      this.I();
      int var3 = var2 ? 0 : 95;
      int var4 = var2 ? 172 : 173;
      a.a(var1, is, 0, 240 - (this.iu - (this.iu >> 2)), var3, var4, 240 - (this.iu - (this.iu >> 2) + 1), 140, false);
   }

   private void a(Graphics var1, int var2, int var3) {
      this.iA = var3;
      this.iz = var2;
      this.a(this.q);
      var1.setColor(0);
      var1.fillRect(0, 306, 240, 14);
      var1.setColor(9787452);
      var1.drawLine(0, 306, 240, 306);
      var1.setColor(4269078);
      var1.drawLine(0, 307, 240, 307);
      if ((this.T == this.aa && this.U == this.ab || I == 106) && this.ay < 0 && (!fR || I == 102)) {
         if (var2 != -1) {
            this.a(var1, 0, var2, 2);
         }

         if (var3 != -1) {
            this.a(var1, 240, var3, 0);
         }

         if (I == 100) {
            if (!iN) {
               if (this.gJ == -1 || this.dg[this.gJ] <= 0 && this.gK <= 0) {
                  if (gH > 1 && this.gI > 0 && I == 100 && this.U <= 0 && this.iv < gH) {
                     this.a(var1, gH + " " + this.e(171), 120, 306 + A - 3, 1);
                  }
               } else {
                  String var4 = this.dg[this.gJ] - df[this.gJ] + " " + this.e(195);
                  int var5 = this.a(var4);
                  if (gM && this.dg[this.gJ] > 0) {
                     this.a(var1, var4, G, 306 + A - 3, 1);
                  }

                  if (this.gJ >= 0 && this.dg[this.gJ] > 0) {
                     int var6 = G - (var5 >> 1) - 5;
                     int var7 = G + (var5 >> 1) + 5;
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
            } else if (this.dI >= 1000) {
               this.a(var1, this.e(275), 120, 306 + A - 3, 1);
            } else {
               this.a(var1, this.e(246) + this.dI, 120, 306 + A - 3, 1);
            }
         } else {
            this.iB = true;
         }
      }

      this.iB = false;
   }

   private void a(Graphics var1, int var2, int var3, int var4) {
      String var5 = this.e(var3);
      this.a(var1, var5, var2 - (var4 == 0 ? this.a(var5) + 2 : -2), 306 + A - 3, 20);
   }

   private static void a(Graphics var0, int var1, int var2, boolean var3) {
      if (I != 1) {
         var2 -= 2;
         var1 -= 2;
      }

      int var4 = 307;
      if (I == 1) {
         var4 = H + 5 + (z >> 2);
         if (iN) {
            var4 += z + (z >> 2);
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

   private void J() {
      byte[] var1;
      int var2;
      iw = new int[var2 = (var1 = this.c(1028)).length >> 2];

      for (int var3 = var2 - 1; var3 >= 0; var3--) {
         int var4 = var3 << 2;
         iw[var3] = ((var1[var4] & 255) << 24) + ((var1[var4 + 1] & 255) << 16) + ((var1[var4 + 2] & 255) << 8) + (var1[var4 + 3] & 255);
      }
   }

   private static int k(int var0, int var1) {
      int var2 = var0;

      while (var0 < iw.length && (iw[var0] & 4194304) == 0) {
         if ((iw[++var0] & var1) != 0) {
            return var0;
         }

         if ((iw[var0] & 4194304) != 0) {
            return var2;
         }
      }

      return var2;
   }

   private static int l(int var0, int var1) {
      int var2 = var0;

      do {
         if ((iw[var0] & 8388608) == 0) {
            if ((iw[--var0] & var1) != 0) {
               var2 = var0;
            }
         }

         if ((iw[var0] & 8388608) != 0 && (iw[var0] & var1) == 0) {
            return var2;
         }
      } while ((iw[var0] & var1) == 0);

      return var2;
   }

   private void K() {
      int var1 = ix;
      int var2;
      int var3 = (var2 = iw[ix]) >> 26;
      int var4 = var2 >> 8 & 0xFF;
      switch (var3) {
         case 0:
            if (this.s == 8 || this.s == 27) {
               if (var4 == 9 && this.bC == 0) {
                  iN = false;
                  this.bC = 0;
                  this.bA = 9217;
                  this.a(H, H, 35, 35);
                  I = 1;
                  this.D();
                  this.iM.c();
                  this.v = false;
                  this.W = true;
               } else {
                  var1 = var4;
               }
            }
            break;
         case 1:
            if (this.s == 8 || this.s == 27) {
               this.iM.a(!this.iM.b());
               iL = this.iM.b();
               if (!this.iM.b()) {
                  this.hR = false;
               }

               this.y(0);
            }
         case 2:
         case 7:
         default:
            break;
         case 3:
            if (this.s == 8 || this.s == 27) {
               this.ai = false;
               this.aj = true;
               this.a(H, H, 35, 35);
            }
            break;
         case 4:
            if (this.s == 8 || this.s == 27) {
               this.ai = true;
               this.aj = true;
               this.a(H, H, 35, 35);
            }
            break;
         case 5:
            if (this.s == 8 || this.s == 27) {
               this.bC = ix - this.iG;
               this.bf = false;
               this.bA = bB[this.bC];
               iN = false;
               this.a(H, H, 35, 35);
               I = 1;
               this.v = false;
               this.D();
               this.F();
            }
            break;
         case 6:
            if (this.s == 8 || this.s == 27) {
               this.bA = 9216;
               this.bC = 0;
               this.dI = 0;
               iN = true;
               this.a(H, H, 35, 35);
               I = 1;
               this.v = false;
               this.D();
               this.F();
            }
            break;
         case 8:
            if (this.s == 8 || this.s == 27) {
               this.M();
            }
            break;
         case 9:
            if (this.s == 8 || this.s == 27) {
               this.b(false);
               I = this.J;
            }
            break;
         case 10:
            if (this.s == 8 || this.s == 27) {
               this.D();
               this.y(0);
               this.a((DataInputStream)null);
               this.z(1);
               this.iy = ix;
               var1 = var4;
            }
            break;
         case 11:
            if (this.s == 8 || this.s == 27 || this.s == 29) {
               if (this.s != 29) {
                  byte[] var5 = new byte[76];
                  a.a(2, var5);
                  this.A(1);
               }

               var1 = var4;
            }
            break;
         case 12:
            if (this.s == 8 || this.s == 27) {
               w++;
               if (w > 5) {
                  w = 0;
               }

               this.f(x[w]);
               this.iB = true;
            }
      }

      if (this.s != 0) {
         this.iI = false;
         this.iC = true;
      }

      if (this.s == 2) {
         var1 = l(var1, 33554432);
      }

      if (this.s == 5) {
         var1 = k(var1, 33554432);
      }

      if (this.be) {
         this.iI = false;
         ix++;
         this.bC++;
         if (this.bC > this.bD) {
            this.bD = this.bC;
         }

         this.bA++;
         I = 1;
         this.ae = true;
         this.v = false;
         this.F();
      }

      if (this.s == 29 && var3 != 11) {
         if (this.iA == 2 || this.iA == 29) {
            var1 = this.iy;
            this.iI = false;
         } else if (this.iA == 1) {
            var1 = 23;
         }
      } else if (this.s == 27 && var3 == 0 && this.iz == 0 && (var4 != 9 || this.bC != 0)) {
         var1 = var4;
         this.iI = false;
      }

      if (ix != var1) {
         ix = var1;
         if ((iw[ix] & 33554432) == 0) {
            ix = k(var1, 33554432);
         }

         this.h();
      }
   }

   private void L() {
      if (this.s == 8 || this.s == 27) {
         this.iC = true;
      }
   }

   private void M() {
      if (I != 0 && I != 79 && !iK) {
         this.z(1);
      }

      this.j(3);
   }

   private void w(Graphics var1) {
      int var2 = 0;
      int var3 = 0;
      if (this.E > this.F) {
         var2 = -(this.E >> 3);
      }

      if (this.iC || (this.T > 0 || this.ak) && this.iI && I != 1) {
         this.v(var1);
      }

      this.a(this.p);
      this.a(var1, this.e(274), G + var2, this.r[0].d + this.r[1].d, 1);
      this.a(this.o);
      int var4 = ix;
      int var6 = 0;

      while (var4 == 1 || var4 > 1 && (iw[var4] & 8388608) == 0) {
         if ((iw[--var4] & 16777216) != 0) {
            var6++;
         }
      }

      int var7 = var4;
      var4 = ix;

      for (int var8 = 0; var8 < var6; var8++) {
         var4 = l(var4, 16777216);
      }

      this.iG = var4;

      for (int var18 = 0; var18 < var6; var18++) {
         var4 = l(var4, 33554432);
      }

      this.iH = var4;
      this.iD = 0;
      int var10 = var4;
      int var11 = var4;
      if (this.iI && this.T <= 0 && !this.ak) {
         this.a(var1, 0, 166, 240, 140);
      } else {
         this.b(var1);
      }

      this.b(var1, true);

      for (int var13 = this.iI && this.T <= 0 && !this.ak ? 2 : 0; var13 <= 4; var13++) {
         this.r[var13].a(var1, var13 < 2 ? G + var2 : this.E + 0, var13 < 2 ? 0 : this.F, 0);
      }

      if (this.ak) {
         this.ak = false;
      }

      this.iI = true;
      this.iF = this.r[0].d + this.r[1].d + (z << 1);
      if (-this.r[2].b + this.iF >= this.F && var2 == 0) {
         var3 = -(this.E >> 3);
      }

      while (true) {
         if ((iw[var11] & 16777216) != 0) {
            var10 = var11;
         }

         if ((iw[var11] & 33554432) != 0) {
            var7 = var11;
         }

         if ((iw[var11] & 4194304) != 0) {
            this.iD = this.E < this.iD ? this.E : this.iD;
            this.iE = 120;
            var1.setColor(0, 0, 255);
            var4 = this.iG;
            this.a(this.o);

            boolean var19;
            do {
               int var9;
               int var5 = (var9 = iw[var4]) >> 26;
               if ((var9 & 16777216) != 0) {
                  int var14;
                  if ((var14 = var9 & 0xFF) == 23) {
                     int var15 = w + 1 > 5 ? 0 : w + 1;
                     var14 = y[var15];
                  }

                  String var20 = this.e(var14);
                  switch (var5) {
                     case 1:
                        var20 = var20 + " " + (iL ? this.e(234) : this.e(235));
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
                        if (var4 == ix) {
                           if (var14 != 28 && var14 != 29) {
                              if (var4 > this.iH) {
                                 bo[2].a(var1, G - this.iJ - (bo[2].c << 1) + var2 + var3, this.iF + (z >> 3) + 4, 0);
                              }

                              this.a(var1, var20, this.iE + var2 + var3, this.iF, 1);
                              if (var4 < var7) {
                                 bo[3].a(var1, G + this.iJ + bo[3].c + var2 + var3, this.iF + (z >> 3) + 4, 0);
                              }
                           }

                           this.iF = this.iF + z + (z >> 2);
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
