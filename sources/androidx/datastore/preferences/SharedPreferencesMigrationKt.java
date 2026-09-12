package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.migrations.SharedPreferencesMigration;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class SharedPreferencesMigrationKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Set f8730a = new LinkedHashSet();

    public static final SharedPreferencesMigration a(Context context, String sharedPreferencesName, Set keysToMigrate) {
        Intrinsics.h(context, "context");
        Intrinsics.h(sharedPreferencesName, "sharedPreferencesName");
        Intrinsics.h(keysToMigrate, "keysToMigrate");
        return keysToMigrate == f8730a ? new SharedPreferencesMigration(context, sharedPreferencesName, null, e(keysToMigrate), d(), 4, null) : new SharedPreferencesMigration(context, sharedPreferencesName, keysToMigrate, e(keysToMigrate), d());
    }

    public static /* synthetic */ SharedPreferencesMigration b(Context context, String str, Set set, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            set = f8730a;
        }
        return a(context, str, set);
    }

    public static final Set c() {
        return f8730a;
    }

    private static final Function3 d() {
        return new SharedPreferencesMigrationKt$getMigrationFunction$1(null);
    }

    private static final Function2 e(Set set) {
        return new SharedPreferencesMigrationKt$getShouldRunMigration$1(set, null);
    }
}
