package b4;

import a4.e;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class h implements e.c {
    @Override // a4.e.c
    public a4.e a(e.b configuration) {
        Intrinsics.h(configuration, "configuration");
        return new FrameworkSQLiteOpenHelper(configuration.f231a, configuration.f232b, configuration.f233c, configuration.f234d, configuration.f235e);
    }
}
