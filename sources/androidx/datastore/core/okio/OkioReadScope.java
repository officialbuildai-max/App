package androidx.datastore.core.okio;

import androidx.datastore.core.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.Path;

/* loaded from: classes.dex */
public class OkioReadScope implements p {

    /* renamed from: a, reason: collision with root package name */
    private final FileSystem f8687a;

    /* renamed from: b, reason: collision with root package name */
    private final Path f8688b;

    /* renamed from: c, reason: collision with root package name */
    private final b f8689c;

    /* renamed from: d, reason: collision with root package name */
    private final a f8690d;

    public OkioReadScope(FileSystem fileSystem, Path path, b serializer) {
        Intrinsics.h(fileSystem, "fileSystem");
        Intrinsics.h(path, "path");
        Intrinsics.h(serializer, "serializer");
        this.f8687a = fileSystem;
        this.f8688b = path;
        this.f8689c = serializer;
        this.f8690d = new a(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090 A[Catch: FileNotFoundException -> 0x008a, TryCatch #8 {FileNotFoundException -> 0x008a, blocks: (B:40:0x0090, B:42:0x0094, B:55:0x0086, B:52:0x0081), top: B:51:0x0081, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0094 A[Catch: FileNotFoundException -> 0x008a, TRY_LEAVE, TryCatch #8 {FileNotFoundException -> 0x008a, blocks: (B:40:0x0090, B:42:0x0094, B:55:0x0086, B:52:0x0081), top: B:51:0x0081, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object j(androidx.datastore.core.okio.OkioReadScope r7, kotlin.coroutines.Continuation r8) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.j(androidx.datastore.core.okio.OkioReadScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.datastore.core.p
    public Object c(Continuation continuation) {
        return j(this, continuation);
    }

    @Override // androidx.datastore.core.b
    public void close() {
        this.f8690d.b(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f() {
        if (this.f8690d.a()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FileSystem g() {
        return this.f8687a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Path h() {
        return this.f8688b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b i() {
        return this.f8689c;
    }
}
