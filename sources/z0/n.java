package z0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.provider.k;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.List;
import y0.e;

/* loaded from: classes2.dex */
public class n extends o {
    private Font i(FontFamily fontFamily, int i11) {
        FontStyle fontStyle = new FontStyle((i11 & 1) != 0 ? LogSeverity.ALERT_VALUE : 400, (i11 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int k11 = k(fontStyle, font.getStyle());
        for (int i12 = 1; i12 < fontFamily.getSize(); i12++) {
            Font font2 = fontFamily.getFont(i12);
            int k12 = k(fontStyle, font2.getStyle());
            if (k12 < k11) {
                font = font2;
                k11 = k12;
            }
        }
        return font;
    }

    private static FontFamily j(CancellationSignal cancellationSignal, k.b[] bVarArr, ContentResolver contentResolver) {
        int i11;
        ParcelFileDescriptor openFileDescriptor;
        int length = bVarArr.length;
        FontFamily.Builder builder = null;
        while (i11 < length) {
            k.b bVar = bVarArr[i11];
            try {
                openFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), CampaignEx.JSON_KEY_AD_R, cancellationSignal);
            } catch (IOException e11) {
                Log.w("TypefaceCompatApi29Impl", "Font load failed", e11);
            }
            if (openFileDescriptor != null) {
                try {
                    Font build = new Font.Builder(openFileDescriptor).setWeight(bVar.e()).setSlant(bVar.f() ? 1 : 0).setTtcIndex(bVar.c()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (Throwable th2) {
                    try {
                        openFileDescriptor.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                    break;
                }
            } else {
                i11 = openFileDescriptor == null ? i11 + 1 : 0;
            }
            openFileDescriptor.close();
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    private static int k(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // z0.o
    public Typeface a(Context context, e.c cVar, Resources resources, int i11) {
        try {
            FontFamily.Builder builder = null;
            for (e.d dVar : cVar.a()) {
                try {
                    Font build = new Font.Builder(resources, dVar.b()).setWeight(dVar.e()).setSlant(dVar.f() ? 1 : 0).setTtcIndex(dVar.c()).setFontVariationSettings(dVar.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(i(build2, i11).getStyle()).build();
        } catch (Exception e11) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e11);
            return null;
        }
    }

    @Override // z0.o
    public Typeface b(Context context, CancellationSignal cancellationSignal, k.b[] bVarArr, int i11) {
        try {
            FontFamily j11 = j(cancellationSignal, bVarArr, context.getContentResolver());
            if (j11 == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(j11).setStyle(i(j11, i11).getStyle()).build();
        } catch (Exception e11) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e11);
            return null;
        }
    }

    @Override // z0.o
    public Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i11) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily j11 = j(cancellationSignal, (k.b[]) list.get(0), contentResolver);
            if (j11 == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(j11);
            for (int i12 = 1; i12 < list.size(); i12++) {
                FontFamily j12 = j(cancellationSignal, (k.b[]) list.get(i12), contentResolver);
                if (j12 != null) {
                    customFallbackBuilder.addCustomFallback(j12);
                }
            }
            return customFallbackBuilder.setStyle(i(j11, i11).getStyle()).build();
        } catch (Exception e11) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e11);
            return null;
        }
    }

    @Override // z0.o
    public Typeface e(Context context, Resources resources, int i11, String str, int i12) {
        try {
            Font build = new Font.Builder(resources, i11).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception e11) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e11);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // z0.o
    public k.b h(k.b[] bVarArr, int i11) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
