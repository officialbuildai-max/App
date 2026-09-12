package kotlin.io;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f\u001d&B\u008b\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u00128\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001b\u001a\u00020\u00002\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"RF\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010$R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010%¨\u0006'"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/Function1;", "", "onEnter", "", "onLeave", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "onFail", "", "maxDepth", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "", "iterator", "()Ljava/util/Iterator;", "function", "i", "(Lkotlin/jvm/functions/Function2;)Lkotlin/io/FileTreeWalk;", "a", "Ljava/io/File;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/io/FileWalkDirection;", "c", "Lkotlin/jvm/functions/Function1;", "d", "Lkotlin/jvm/functions/Function2;", "I", "FileTreeWalkIterator", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class FileTreeWalk implements Sequence<File> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final File start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final FileWalkDirection direction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function1 onEnter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function1 onLeave;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function2 onFail;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int maxDepth;

    /* loaded from: classes7.dex */
    private final class FileTreeWalkIterator extends AbstractIterator {

        /* renamed from: c, reason: collision with root package name */
        private final ArrayDeque f67335c;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
        /* loaded from: classes7.dex */
        public /* synthetic */ class WhenMappings {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f67337a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f67337a = iArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes7.dex */
        public final class a extends a {

            /* renamed from: b, reason: collision with root package name */
            private boolean f67338b;

            /* renamed from: c, reason: collision with root package name */
            private File[] f67339c;

            /* renamed from: d, reason: collision with root package name */
            private int f67340d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f67341e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f67342f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.h(rootDir, "rootDir");
                this.f67342f = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.b
            public File b() {
                if (!this.f67341e && this.f67339c == null) {
                    Function1 function1 = FileTreeWalk.this.onEnter;
                    if (function1 != null && !((Boolean) function1.invoke(a())).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.f67339c = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = FileTreeWalk.this.onFail;
                        if (function2 != null) {
                            function2.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f67341e = true;
                    }
                }
                File[] fileArr = this.f67339c;
                if (fileArr != null) {
                    int i11 = this.f67340d;
                    Intrinsics.e(fileArr);
                    if (i11 < fileArr.length) {
                        File[] fileArr2 = this.f67339c;
                        Intrinsics.e(fileArr2);
                        int i12 = this.f67340d;
                        this.f67340d = i12 + 1;
                        return fileArr2[i12];
                    }
                }
                if (!this.f67338b) {
                    this.f67338b = true;
                    return a();
                }
                Function1 function12 = FileTreeWalk.this.onLeave;
                if (function12 != null) {
                    function12.invoke(a());
                }
                return null;
            }
        }

        /* loaded from: classes7.dex */
        private final class b extends b {

            /* renamed from: b, reason: collision with root package name */
            private boolean f67343b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f67344c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(FileTreeWalkIterator fileTreeWalkIterator, File rootFile) {
                super(rootFile);
                Intrinsics.h(rootFile, "rootFile");
                this.f67344c = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.b
            public File b() {
                if (this.f67343b) {
                    return null;
                }
                this.f67343b = true;
                return a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes7.dex */
        public final class c extends a {

            /* renamed from: b, reason: collision with root package name */
            private boolean f67345b;

            /* renamed from: c, reason: collision with root package name */
            private File[] f67346c;

            /* renamed from: d, reason: collision with root package name */
            private int f67347d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f67348e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.h(rootDir, "rootDir");
                this.f67348e = fileTreeWalkIterator;
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // kotlin.io.FileTreeWalk.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f67345b
                    r1 = 0
                    if (r0 != 0) goto L28
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f67348e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.e(r0)
                    if (r0 == 0) goto L20
                    java.io.File r2 = r10.a()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    return r1
                L20:
                    r0 = 1
                    r10.f67345b = r0
                    java.io.File r0 = r10.a()
                    return r0
                L28:
                    java.io.File[] r0 = r10.f67346c
                    if (r0 == 0) goto L47
                    int r2 = r10.f67347d
                    kotlin.jvm.internal.Intrinsics.e(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L35
                    goto L47
                L35:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f67348e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.g(r0)
                    if (r0 == 0) goto L46
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L46:
                    return r1
                L47:
                    java.io.File[] r0 = r10.f67346c
                    if (r0 != 0) goto L93
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f67346c = r0
                    if (r0 != 0) goto L77
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f67348e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function2 r0 = kotlin.io.FileTreeWalk.f(r0)
                    if (r0 == 0) goto L77
                    java.io.File r2 = r10.a()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.a()
                    r7 = 2
                    r8 = 0
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r9)
                L77:
                    java.io.File[] r0 = r10.f67346c
                    if (r0 == 0) goto L81
                    kotlin.jvm.internal.Intrinsics.e(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L93
                L81:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f67348e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.g(r0)
                    if (r0 == 0) goto L92
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L92:
                    return r1
                L93:
                    java.io.File[] r0 = r10.f67346c
                    kotlin.jvm.internal.Intrinsics.e(r0)
                    int r1 = r10.f67347d
                    int r2 = r1 + 1
                    r10.f67347d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.FileTreeWalkIterator.c.b():java.io.File");
            }
        }

        public FileTreeWalkIterator() {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f67335c = arrayDeque;
            if (FileTreeWalk.this.start.isDirectory()) {
                arrayDeque.push(h(FileTreeWalk.this.start));
            } else if (FileTreeWalk.this.start.isFile()) {
                arrayDeque.push(new b(this, FileTreeWalk.this.start));
            } else {
                c();
            }
        }

        private final a h(File file) {
            int i11 = WhenMappings.f67337a[FileTreeWalk.this.direction.ordinal()];
            if (i11 == 1) {
                return new c(this, file);
            }
            if (i11 == 2) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        private final File i() {
            File b11;
            while (true) {
                b bVar = (b) this.f67335c.peek();
                if (bVar == null) {
                    return null;
                }
                b11 = bVar.b();
                if (b11 == null) {
                    this.f67335c.pop();
                } else {
                    if (Intrinsics.c(b11, bVar.a()) || !b11.isDirectory() || this.f67335c.size() >= FileTreeWalk.this.maxDepth) {
                        break;
                    }
                    this.f67335c.push(h(b11));
                }
            }
            return b11;
        }

        @Override // kotlin.collections.AbstractIterator
        protected void a() {
            File i11 = i();
            if (i11 != null) {
                e(i11);
            } else {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static abstract class a extends b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File rootDir) {
            super(rootDir);
            Intrinsics.h(rootDir, "rootDir");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private final File f67349a;

        public b(File root) {
            Intrinsics.h(root, "root");
            this.f67349a = root;
        }

        public final File a() {
            return this.f67349a;
        }

        public abstract File b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(File start, FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        Intrinsics.h(start, "start");
        Intrinsics.h(direction, "direction");
    }

    private FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i11) {
        this.start = file;
        this.direction = fileWalkDirection;
        this.onEnter = function1;
        this.onLeave = function12;
        this.onFail = function2;
        this.maxDepth = i11;
    }

    /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i12 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function12, function2, (i12 & 32) != 0 ? Integer.MAX_VALUE : i11);
    }

    public final FileTreeWalk i(Function2 function) {
        Intrinsics.h(function, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, function, this.maxDepth);
    }

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getF67553a() {
        return new FileTreeWalkIterator();
    }
}
