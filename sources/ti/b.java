package ti;

import android.view.View;
import android.widget.TextView;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f76376a = new b();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TextView textView) {
        String valueOf;
        try {
            Result.Companion companion = Result.INSTANCE;
            String lowerCase = textView.getText().toString().toLowerCase(Locale.ROOT);
            Intrinsics.g(lowerCase, "toLowerCase(...)");
            if (f76376a.b(lowerCase)) {
                if (lowerCase.length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    char charAt = lowerCase.charAt(0);
                    if (Character.isLowerCase(charAt)) {
                        Locale locale = Locale.getDefault();
                        Intrinsics.g(locale, "getDefault(...)");
                        valueOf = CharsKt.d(charAt, locale);
                    } else {
                        valueOf = String.valueOf(charAt);
                    }
                    sb2.append((Object) valueOf);
                    String substring = lowerCase.substring(1);
                    Intrinsics.g(substring, "substring(...)");
                    sb2.append(substring);
                    lowerCase = sb2.toString();
                }
                textView.setText(lowerCase);
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final boolean b(String string) {
        Intrinsics.h(string, "string");
        return new Regex("[a-zA-Z]+").matches(string);
    }

    public final boolean c() {
        return com.transsion.ad.strategy.f.f42286a.c().getBoolean("key_downloading_play_bubble_guide", true);
    }

    public final void d() {
        com.transsion.ad.strategy.f.f42286a.c().putBoolean("key_downloading_play_bubble_guide", false);
    }

    public final void e(View layout, int i11) {
        Intrinsics.h(layout, "layout");
        View findViewById = layout.findViewById(i11);
        if (findViewById != null && (findViewById instanceof TextView)) {
            final TextView textView = (TextView) findViewById;
            textView.post(new Runnable() { // from class: ti.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.f(textView);
                }
            });
        }
    }
}
