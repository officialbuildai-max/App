package l2;

import androidx.media3.common.util.a1;
import androidx.media3.common.x;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class e0 {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f68687c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f68688a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f68689b = -1;

    private boolean b(String str) {
        Matcher matcher = f68687c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt((String) a1.i(matcher.group(1)), 16);
            int parseInt2 = Integer.parseInt((String) a1.i(matcher.group(2)), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f68688a = parseInt;
            this.f68689b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f68688a == -1 || this.f68689b == -1) ? false : true;
    }

    public boolean c(androidx.media3.common.x xVar) {
        for (int i11 = 0; i11 < xVar.e(); i11++) {
            x.a d11 = xVar.d(i11);
            if (d11 instanceof z2.e) {
                z2.e eVar = (z2.e) d11;
                if ("iTunSMPB".equals(eVar.f79304c) && b(eVar.f79305d)) {
                    return true;
                }
            } else if (d11 instanceof z2.k) {
                z2.k kVar = (z2.k) d11;
                if ("com.apple.iTunes".equals(kVar.f79317b) && "iTunSMPB".equals(kVar.f79318c) && b(kVar.f79319d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
