package gm;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.mvel2.ast.ASTNode;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f64005a = new h();

    private h() {
    }

    private final boolean b(String str, Context context) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            Intrinsics.g(parseUri, "parseUri(...)");
            parseUri.setFlags(ASTNode.DEOP);
            if (context == null) {
                return true;
            }
            context.startActivity(parseUri);
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, Context context) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (StringsKt.W(str, "https://play.google.com/store/apps/", false, 2, null) || StringsKt.W(str, "http://play.google.com/store/apps/", false, 2, null)) {
            return b(str, context);
        }
        if (StringsKt.W(str, "http", false, 2, null)) {
            return false;
        }
        b(str, context);
        return true;
    }
}
