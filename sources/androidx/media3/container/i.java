package androidx.media3.container;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final b f10759a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque f10760b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque f10761c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    private final PriorityQueue f10762d = new PriorityQueue();

    /* renamed from: e, reason: collision with root package name */
    private int f10763e = -1;

    /* renamed from: f, reason: collision with root package name */
    private a f10764f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a implements Comparable {

        /* renamed from: b, reason: collision with root package name */
        public long f10766b = C.TIME_UNSET;

        /* renamed from: a, reason: collision with root package name */
        public final List f10765a = new ArrayList();

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Long.compare(this.f10766b, aVar.f10766b);
        }

        public void b(long j11, j0 j0Var) {
            androidx.media3.common.util.a.a(j11 != C.TIME_UNSET);
            androidx.media3.common.util.a.g(this.f10765a.isEmpty());
            this.f10766b = j11;
            this.f10765a.add(j0Var);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(long j11, j0 j0Var);
    }

    public i(b bVar) {
        this.f10759a = bVar;
    }

    private j0 c(j0 j0Var) {
        j0 j0Var2 = this.f10760b.isEmpty() ? new j0() : (j0) this.f10760b.pop();
        j0Var2.S(j0Var.a());
        System.arraycopy(j0Var.e(), j0Var.f(), j0Var2.e(), 0, j0Var2.a());
        return j0Var2;
    }

    private void e(int i11) {
        while (this.f10762d.size() > i11) {
            a aVar = (a) a1.i((a) this.f10762d.poll());
            for (int i12 = 0; i12 < aVar.f10765a.size(); i12++) {
                this.f10759a.a(aVar.f10766b, (j0) aVar.f10765a.get(i12));
                this.f10760b.push((j0) aVar.f10765a.get(i12));
            }
            aVar.f10765a.clear();
            a aVar2 = this.f10764f;
            if (aVar2 != null && aVar2.f10766b == aVar.f10766b) {
                this.f10764f = null;
            }
            this.f10761c.push(aVar);
        }
    }

    public void a(long j11, j0 j0Var) {
        int i11 = this.f10763e;
        if (i11 == 0 || (i11 != -1 && this.f10762d.size() >= this.f10763e && j11 < ((a) a1.i((a) this.f10762d.peek())).f10766b)) {
            this.f10759a.a(j11, j0Var);
            return;
        }
        j0 c11 = c(j0Var);
        a aVar = this.f10764f;
        if (aVar != null && j11 == aVar.f10766b) {
            aVar.f10765a.add(c11);
            return;
        }
        a aVar2 = this.f10761c.isEmpty() ? new a() : (a) this.f10761c.pop();
        aVar2.b(j11, c11);
        this.f10762d.add(aVar2);
        this.f10764f = aVar2;
        int i12 = this.f10763e;
        if (i12 != -1) {
            e(i12);
        }
    }

    public void b() {
        this.f10762d.clear();
    }

    public void d() {
        e(0);
    }

    public int f() {
        return this.f10763e;
    }

    public void g(int i11) {
        androidx.media3.common.util.a.g(i11 >= 0);
        this.f10763e = i11;
        e(i11);
    }
}
