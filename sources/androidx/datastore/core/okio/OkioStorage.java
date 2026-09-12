package androidx.datastore.core.okio;

import androidx.datastore.core.k;
import androidx.datastore.core.okio.OkioStorage;
import androidx.datastore.core.s;
import androidx.datastore.core.t;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.Path;

/* loaded from: classes.dex */
public final class OkioStorage implements s {

    /* renamed from: f, reason: collision with root package name */
    public static final a f8691f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Set f8692g = new LinkedHashSet();

    /* renamed from: h, reason: collision with root package name */
    private static final d f8693h = new d();

    /* renamed from: a, reason: collision with root package name */
    private final FileSystem f8694a;

    /* renamed from: b, reason: collision with root package name */
    private final b f8695b;

    /* renamed from: c, reason: collision with root package name */
    private final Function2 f8696c;

    /* renamed from: d, reason: collision with root package name */
    private final Function0 f8697d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f8698e;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set a() {
            return OkioStorage.f8692g;
        }

        public final d b() {
            return OkioStorage.f8693h;
        }
    }

    public OkioStorage(FileSystem fileSystem, b serializer, Function2 coordinatorProducer, Function0 producePath) {
        Intrinsics.h(fileSystem, "fileSystem");
        Intrinsics.h(serializer, "serializer");
        Intrinsics.h(coordinatorProducer, "coordinatorProducer");
        Intrinsics.h(producePath, "producePath");
        this.f8694a = fileSystem;
        this.f8695b = serializer;
        this.f8696c = coordinatorProducer;
        this.f8697d = producePath;
        this.f8698e = LazyKt.b(new Function0<Path>() { // from class: androidx.datastore.core.okio.OkioStorage$canonicalPath$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Path invoke() {
                Function0 function0;
                Function0 function02;
                function0 = OkioStorage.this.f8697d;
                Path path = (Path) function0.invoke();
                boolean isAbsolute = path.isAbsolute();
                OkioStorage okioStorage = OkioStorage.this;
                if (isAbsolute) {
                    return path.normalized();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("OkioStorage requires absolute paths, but did not get an absolute path from producePath = ");
                function02 = okioStorage.f8697d;
                sb2.append(function02);
                sb2.append(", instead got ");
                sb2.append(path);
                throw new IllegalStateException(sb2.toString().toString());
            }
        });
    }

    public /* synthetic */ OkioStorage(FileSystem fileSystem, b bVar, Function2 function2, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileSystem, bVar, (i11 & 4) != 0 ? new Function2<Path, FileSystem, k>() { // from class: androidx.datastore.core.okio.OkioStorage.1
            @Override // kotlin.jvm.functions.Function2
            public final k invoke(Path path, FileSystem fileSystem2) {
                Intrinsics.h(path, "path");
                Intrinsics.h(fileSystem2, "<anonymous parameter 1>");
                return c.a(path);
            }
        } : function2, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Path f() {
        return (Path) this.f8698e.getValue();
    }

    @Override // androidx.datastore.core.s
    public t a() {
        String path = f().toString();
        synchronized (f8693h) {
            Set set = f8692g;
            if (set.contains(path)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + path + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            set.add(path);
        }
        return new OkioStorageConnection(this.f8694a, f(), this.f8695b, (k) this.f8696c.invoke(f(), this.f8694a), new Function0<Unit>() { // from class: androidx.datastore.core.okio.OkioStorage$createConnection$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m396invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m396invoke() {
                Path f11;
                OkioStorage.a aVar = OkioStorage.f8691f;
                d b11 = aVar.b();
                OkioStorage okioStorage = OkioStorage.this;
                synchronized (b11) {
                    Set a11 = aVar.a();
                    f11 = okioStorage.f();
                    a11.remove(f11.toString());
                    Unit unit = Unit.f67184a;
                }
            }
        });
    }
}
