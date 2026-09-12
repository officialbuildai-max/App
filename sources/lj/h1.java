package lj;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class h1 implements d1 {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f69020a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f69021b = new a();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `subtitle_language_map_table` (`lan`,`lanIOS3`,`lanName`,`inSearch`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, SubtitleLanguageMapBean subtitleLanguageMapBean) {
            if (subtitleLanguageMapBean.getLan() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, subtitleLanguageMapBean.getLan());
            }
            if (subtitleLanguageMapBean.getLanIOS3() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, subtitleLanguageMapBean.getLanIOS3());
            }
            if (subtitleLanguageMapBean.getLanName() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, subtitleLanguageMapBean.getLanName());
            }
            eVar.c(4, subtitleLanguageMapBean.getInSearch() ? 1L : 0L);
        }
    }

    public h1(RoomDatabase roomDatabase) {
        this.f69020a = roomDatabase;
    }

    public static List g() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List h(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM SUBTITLE_LANGUAGE_MAP_TABLE ");
        try {
            int d11 = androidx.room.util.k.d(D0, "lan");
            int d12 = androidx.room.util.k.d(D0, "lanIOS3");
            int d13 = androidx.room.util.k.d(D0, "lanName");
            int d14 = androidx.room.util.k.d(D0, "inSearch");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String str = null;
                String n02 = D0.isNull(d11) ? null : D0.n0(d11);
                String n03 = D0.isNull(d12) ? null : D0.n0(d12);
                if (!D0.isNull(d13)) {
                    str = D0.n0(d13);
                }
                arrayList.add(new SubtitleLanguageMapBean(n02, n03, str, ((int) D0.getLong(d14)) != 0));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(SubtitleLanguageMapBean subtitleLanguageMapBean, z3.b bVar) {
        this.f69021b.d(bVar, subtitleLanguageMapBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit j(boolean z10, String str, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE SUBTITLE_LANGUAGE_MAP_TABLE SET inSearch = ?  WHERE lan = ?");
        try {
            D0.c(1, z10 ? 1L : 0L);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    @Override // lj.d1
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.f69020a, true, false, new Function1() { // from class: lj.e1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List h11;
                h11 = h1.h((z3.b) obj);
                return h11;
            }
        }, continuation);
    }

    @Override // lj.d1
    public Object b(final String str, final boolean z10, Continuation continuation) {
        return androidx.room.util.b.f(this.f69020a, false, true, new Function1() { // from class: lj.f1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j11;
                j11 = h1.j(z10, str, (z3.b) obj);
                return j11;
            }
        }, continuation);
    }

    @Override // lj.d1
    public Object c(final SubtitleLanguageMapBean subtitleLanguageMapBean, Continuation continuation) {
        subtitleLanguageMapBean.getClass();
        return androidx.room.util.b.f(this.f69020a, false, true, new Function1() { // from class: lj.g1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i11;
                i11 = h1.this.i(subtitleLanguageMapBean, (z3.b) obj);
                return i11;
            }
        }, continuation);
    }
}
