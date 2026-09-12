package m4;

import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public class l implements m, j {

    /* renamed from: d, reason: collision with root package name */
    private final String f69370d;

    /* renamed from: f, reason: collision with root package name */
    private final MergePaths f69372f;

    /* renamed from: a, reason: collision with root package name */
    private final Path f69367a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Path f69368b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f69369c = new Path();

    /* renamed from: e, reason: collision with root package name */
    private final List f69371e = new ArrayList();

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f69373a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f69373a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69373a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f69373a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f69373a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f69373a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(MergePaths mergePaths) {
        this.f69370d = mergePaths.c();
        this.f69372f = mergePaths;
    }

    private void a() {
        for (int i11 = 0; i11 < this.f69371e.size(); i11++) {
            this.f69369c.addPath(((m) this.f69371e.get(i11)).getPath());
        }
    }

    private void b(Path.Op op2) {
        this.f69368b.reset();
        this.f69367a.reset();
        for (int size = this.f69371e.size() - 1; size >= 1; size--) {
            m mVar = (m) this.f69371e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List k11 = dVar.k();
                for (int size2 = k11.size() - 1; size2 >= 0; size2--) {
                    Path path = ((m) k11.get(size2)).getPath();
                    path.transform(dVar.l());
                    this.f69368b.addPath(path);
                }
            } else {
                this.f69368b.addPath(mVar.getPath());
            }
        }
        m mVar2 = (m) this.f69371e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List k12 = dVar2.k();
            for (int i11 = 0; i11 < k12.size(); i11++) {
                Path path2 = ((m) k12.get(i11)).getPath();
                path2.transform(dVar2.l());
                this.f69367a.addPath(path2);
            }
        } else {
            this.f69367a.set(mVar2.getPath());
        }
        this.f69369c.op(this.f69367a, this.f69368b, op2);
    }

    @Override // m4.c
    public void c(List list, List list2) {
        for (int i11 = 0; i11 < this.f69371e.size(); i11++) {
            ((m) this.f69371e.get(i11)).c(list, list2);
        }
    }

    @Override // m4.j
    public void g(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar instanceof m) {
                this.f69371e.add((m) cVar);
                listIterator.remove();
            }
        }
    }

    @Override // m4.m
    public Path getPath() {
        this.f69369c.reset();
        if (this.f69372f.d()) {
            return this.f69369c;
        }
        int i11 = a.f69373a[this.f69372f.b().ordinal()];
        if (i11 == 1) {
            a();
        } else if (i11 == 2) {
            b(Path.Op.UNION);
        } else if (i11 == 3) {
            b(Path.Op.REVERSE_DIFFERENCE);
        } else if (i11 == 4) {
            b(Path.Op.INTERSECT);
        } else if (i11 == 5) {
            b(Path.Op.XOR);
        }
        return this.f69369c;
    }
}
