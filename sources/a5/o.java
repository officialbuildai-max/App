package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Type;
import y4.a;
import z4.b2;

/* loaded from: classes2.dex */
public class o implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final o f369a = new o();

    private Object i(y4.a aVar, Object obj) {
        y4.b s11 = aVar.s();
        s11.q(4);
        String k02 = s11.k0();
        aVar.y0(aVar.n(), obj);
        aVar.i(new a.C0994a(aVar.n(), k02));
        aVar.v0();
        aVar.E0(1);
        s11.c0(13);
        aVar.b(13);
        return null;
    }

    public static boolean j(Class cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    @Override // z4.b2
    public int b() {
        return 12;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        Point f11;
        y4.b bVar = aVar.f78954f;
        if (bVar.q0() == 8) {
            bVar.c0(16);
            return null;
        }
        if (bVar.q0() != 12 && bVar.q0() != 16) {
            throw new JSONException("syntax error");
        }
        bVar.Z();
        if (type == Point.class) {
            f11 = g(aVar, obj);
        } else if (type == Rectangle.class) {
            f11 = h(aVar);
        } else if (type == Color.class) {
            f11 = e(aVar);
        } else {
            if (type != Font.class) {
                throw new JSONException("not support awt class : " + type);
            }
            f11 = f(aVar);
        }
        y4.g n11 = aVar.n();
        aVar.y0(f11, obj);
        aVar.B0(n11);
        return f11;
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        if (obj == null) {
            j1Var.m0();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            j1Var.U(k(j1Var, Point.class, '{'), "x", point.x);
            j1Var.U(',', "y", point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            j1Var.Z(k(j1Var, Font.class, '{'), "name", font.getName());
            j1Var.U(',', TtmlNode.TAG_STYLE, font.getStyle());
            j1Var.U(',', "size", font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            j1Var.U(k(j1Var, Rectangle.class, '{'), "x", rectangle.x);
            j1Var.U(',', "y", rectangle.y);
            j1Var.U(',', "width", rectangle.width);
            j1Var.U(',', "height", rectangle.height);
        } else {
            if (!(obj instanceof Color)) {
                throw new JSONException("not support awt class : " + obj.getClass().getName());
            }
            Color color = (Color) obj;
            j1Var.U(k(j1Var, Color.class, '{'), CampaignEx.JSON_KEY_AD_R, color.getRed());
            j1Var.U(',', be.g.f16474b, color.getGreen());
            j1Var.U(',', DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, color.getBlue());
            if (color.getAlpha() > 0) {
                j1Var.U(',', "alpha", color.getAlpha());
            }
        }
        j1Var.write(Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
    }

    protected Color e(y4.a aVar) {
        y4.b bVar = aVar.f78954f;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (bVar.q0() != 13) {
            if (bVar.q0() != 4) {
                throw new JSONException("syntax error");
            }
            String k02 = bVar.k0();
            bVar.q(2);
            if (bVar.q0() != 2) {
                throw new JSONException("syntax error");
            }
            int o11 = bVar.o();
            bVar.Z();
            if (k02.equalsIgnoreCase(CampaignEx.JSON_KEY_AD_R)) {
                i11 = o11;
            } else if (k02.equalsIgnoreCase(be.g.f16474b)) {
                i12 = o11;
            } else if (k02.equalsIgnoreCase(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                i13 = o11;
            } else {
                if (!k02.equalsIgnoreCase("alpha")) {
                    throw new JSONException("syntax error, " + k02);
                }
                i14 = o11;
            }
            if (bVar.q0() == 16) {
                bVar.c0(4);
            }
        }
        bVar.Z();
        return new Color(i11, i12, i13, i14);
    }

    protected Font f(y4.a aVar) {
        y4.b bVar = aVar.f78954f;
        int i11 = 0;
        String str = null;
        int i12 = 0;
        while (bVar.q0() != 13) {
            if (bVar.q0() != 4) {
                throw new JSONException("syntax error");
            }
            String k02 = bVar.k0();
            bVar.q(2);
            if (k02.equalsIgnoreCase("name")) {
                if (bVar.q0() != 4) {
                    throw new JSONException("syntax error");
                }
                str = bVar.k0();
                bVar.Z();
            } else if (k02.equalsIgnoreCase(TtmlNode.TAG_STYLE)) {
                if (bVar.q0() != 2) {
                    throw new JSONException("syntax error");
                }
                i11 = bVar.o();
                bVar.Z();
            } else {
                if (!k02.equalsIgnoreCase("size")) {
                    throw new JSONException("syntax error, " + k02);
                }
                if (bVar.q0() != 2) {
                    throw new JSONException("syntax error");
                }
                i12 = bVar.o();
                bVar.Z();
            }
            if (bVar.q0() == 16) {
                bVar.c0(4);
            }
        }
        bVar.Z();
        return new Font(str, i11, i12);
    }

    protected Point g(y4.a aVar, Object obj) {
        int p02;
        y4.b bVar = aVar.f78954f;
        int i11 = 0;
        int i12 = 0;
        while (bVar.q0() != 13) {
            if (bVar.q0() != 4) {
                throw new JSONException("syntax error");
            }
            String k02 = bVar.k0();
            if (com.alibaba.fastjson.a.DEFAULT_TYPE_KEY.equals(k02)) {
                aVar.d("java.awt.Point");
            } else {
                if ("$ref".equals(k02)) {
                    return (Point) i(aVar, obj);
                }
                bVar.q(2);
                int q02 = bVar.q0();
                if (q02 == 2) {
                    p02 = bVar.o();
                    bVar.Z();
                } else {
                    if (q02 != 3) {
                        throw new JSONException("syntax error : " + bVar.v());
                    }
                    p02 = (int) bVar.p0();
                    bVar.Z();
                }
                if (k02.equalsIgnoreCase("x")) {
                    i11 = p02;
                } else {
                    if (!k02.equalsIgnoreCase("y")) {
                        throw new JSONException("syntax error, " + k02);
                    }
                    i12 = p02;
                }
                if (bVar.q0() == 16) {
                    bVar.c0(4);
                }
            }
        }
        bVar.Z();
        return new Point(i11, i12);
    }

    protected Rectangle h(y4.a aVar) {
        int p02;
        y4.b bVar = aVar.f78954f;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (bVar.q0() != 13) {
            if (bVar.q0() != 4) {
                throw new JSONException("syntax error");
            }
            String k02 = bVar.k0();
            bVar.q(2);
            int q02 = bVar.q0();
            if (q02 == 2) {
                p02 = bVar.o();
                bVar.Z();
            } else {
                if (q02 != 3) {
                    throw new JSONException("syntax error");
                }
                p02 = (int) bVar.p0();
                bVar.Z();
            }
            if (k02.equalsIgnoreCase("x")) {
                i11 = p02;
            } else if (k02.equalsIgnoreCase("y")) {
                i12 = p02;
            } else if (k02.equalsIgnoreCase("width")) {
                i13 = p02;
            } else {
                if (!k02.equalsIgnoreCase("height")) {
                    throw new JSONException("syntax error, " + k02);
                }
                i14 = p02;
            }
            if (bVar.q0() == 16) {
                bVar.c0(4);
            }
        }
        bVar.Z();
        return new Rectangle(i11, i12, i13, i14);
    }

    protected char k(j1 j1Var, Class cls, char c11) {
        if (!j1Var.q(SerializerFeature.WriteClassName)) {
            return c11;
        }
        j1Var.write(Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        j1Var.w(com.alibaba.fastjson.a.DEFAULT_TYPE_KEY);
        j1Var.q0(cls.getName());
        return ',';
    }
}
