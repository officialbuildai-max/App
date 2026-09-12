package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.f;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.n0;

/* loaded from: classes.dex */
public final class PreferenceDataStoreSingletonDelegate implements ReadOnlyProperty {

    /* renamed from: a, reason: collision with root package name */
    private final String f8724a;

    /* renamed from: b, reason: collision with root package name */
    private final j1.b f8725b;

    /* renamed from: c, reason: collision with root package name */
    private final Function1 f8726c;

    /* renamed from: d, reason: collision with root package name */
    private final n0 f8727d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f8728e;

    /* renamed from: f, reason: collision with root package name */
    private volatile f f8729f;

    public PreferenceDataStoreSingletonDelegate(String name, j1.b bVar, Function1 produceMigrations, n0 scope) {
        Intrinsics.h(name, "name");
        Intrinsics.h(produceMigrations, "produceMigrations");
        Intrinsics.h(scope, "scope");
        this.f8724a = name;
        this.f8725b = bVar;
        this.f8726c = produceMigrations;
        this.f8727d = scope;
        this.f8728e = new Object();
    }

    @Override // kotlin.properties.ReadOnlyProperty
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f a(Context thisRef, KProperty property) {
        f fVar;
        Intrinsics.h(thisRef, "thisRef");
        Intrinsics.h(property, "property");
        f fVar2 = this.f8729f;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (this.f8728e) {
            try {
                if (this.f8729f == null) {
                    final Context applicationContext = thisRef.getApplicationContext();
                    PreferenceDataStoreFactory preferenceDataStoreFactory = PreferenceDataStoreFactory.f8736a;
                    j1.b bVar = this.f8725b;
                    Function1 function1 = this.f8726c;
                    Intrinsics.g(applicationContext, "applicationContext");
                    this.f8729f = preferenceDataStoreFactory.b(bVar, (List) function1.invoke(applicationContext), this.f8727d, new Function0<File>() { // from class: androidx.datastore.preferences.PreferenceDataStoreSingletonDelegate$getValue$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final File invoke() {
                            String str;
                            Context applicationContext2 = applicationContext;
                            Intrinsics.g(applicationContext2, "applicationContext");
                            str = this.f8724a;
                            return a.a(applicationContext2, str);
                        }
                    });
                }
                fVar = this.f8729f;
                Intrinsics.e(fVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }
}
