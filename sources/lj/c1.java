package lj;

import androidx.core.app.NotificationCompat;
import androidx.room.RoomDatabase;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.baselib.db.download.SubtitleBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class c1 implements v0 {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f68996a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f68997b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f68998c = new b();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `download_subtitle_table` (`resourceId`,`postId`,`url`,`path`,`lan`,`lanName`,`subtitleName`,`size`,`delayDuration`,`status`,`type`,`fileCharsetName`,`subjectId`,`ep`,`se`,`resolution`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, SubtitleBean subtitleBean) {
            if (subtitleBean.getResourceId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, subtitleBean.getResourceId());
            }
            if (subtitleBean.getPostId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, subtitleBean.getPostId());
            }
            if (subtitleBean.getUrl() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, subtitleBean.getUrl());
            }
            if (subtitleBean.getPath() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, subtitleBean.getPath());
            }
            if (subtitleBean.getLan() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, subtitleBean.getLan());
            }
            if (subtitleBean.getLanName() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, subtitleBean.getLanName());
            }
            if (subtitleBean.getSubtitleName() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, subtitleBean.getSubtitleName());
            }
            if (subtitleBean.getSize() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, subtitleBean.getSize().longValue());
            }
            if (subtitleBean.getDelayDuration() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, subtitleBean.getDelayDuration().longValue());
            }
            eVar.c(10, subtitleBean.getStatus());
            eVar.c(11, subtitleBean.getType());
            if (subtitleBean.getFileCharsetName() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, subtitleBean.getFileCharsetName());
            }
            if (subtitleBean.getSubjectId() == null) {
                eVar.g(13);
            } else {
                eVar.j(13, subtitleBean.getSubjectId());
            }
            eVar.c(14, subtitleBean.getEp());
            eVar.c(15, subtitleBean.getSe());
            eVar.c(16, subtitleBean.getResolution());
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `download_subtitle_table` SET `resourceId` = ?,`postId` = ?,`url` = ?,`path` = ?,`lan` = ?,`lanName` = ?,`subtitleName` = ?,`size` = ?,`delayDuration` = ?,`status` = ?,`type` = ?,`fileCharsetName` = ?,`subjectId` = ?,`ep` = ?,`se` = ?,`resolution` = ? WHERE `resourceId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, SubtitleBean subtitleBean) {
            if (subtitleBean.getResourceId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, subtitleBean.getResourceId());
            }
            if (subtitleBean.getPostId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, subtitleBean.getPostId());
            }
            if (subtitleBean.getUrl() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, subtitleBean.getUrl());
            }
            if (subtitleBean.getPath() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, subtitleBean.getPath());
            }
            if (subtitleBean.getLan() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, subtitleBean.getLan());
            }
            if (subtitleBean.getLanName() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, subtitleBean.getLanName());
            }
            if (subtitleBean.getSubtitleName() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, subtitleBean.getSubtitleName());
            }
            if (subtitleBean.getSize() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, subtitleBean.getSize().longValue());
            }
            if (subtitleBean.getDelayDuration() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, subtitleBean.getDelayDuration().longValue());
            }
            eVar.c(10, subtitleBean.getStatus());
            eVar.c(11, subtitleBean.getType());
            if (subtitleBean.getFileCharsetName() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, subtitleBean.getFileCharsetName());
            }
            if (subtitleBean.getSubjectId() == null) {
                eVar.g(13);
            } else {
                eVar.j(13, subtitleBean.getSubjectId());
            }
            eVar.c(14, subtitleBean.getEp());
            eVar.c(15, subtitleBean.getSe());
            eVar.c(16, subtitleBean.getResolution());
            if (subtitleBean.getResourceId() == null) {
                eVar.g(17);
            } else {
                eVar.j(17, subtitleBean.getResourceId());
            }
        }
    }

    public c1(RoomDatabase roomDatabase) {
        this.f68996a = roomDatabase;
    }

    public static List m() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit n(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM DOWNLOAD_SUBTITLE_TABLE WHERE postId=?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List o(z3.b bVar) {
        int i11;
        Long valueOf;
        int i12;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE");
        try {
            int d11 = androidx.room.util.k.d(D0, "resourceId");
            int d12 = androidx.room.util.k.d(D0, "postId");
            int d13 = androidx.room.util.k.d(D0, "url");
            int d14 = androidx.room.util.k.d(D0, "path");
            int d15 = androidx.room.util.k.d(D0, "lan");
            int d16 = androidx.room.util.k.d(D0, "lanName");
            int d17 = androidx.room.util.k.d(D0, "subtitleName");
            int d18 = androidx.room.util.k.d(D0, "size");
            int d19 = androidx.room.util.k.d(D0, "delayDuration");
            int d20 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d21 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d22 = androidx.room.util.k.d(D0, "fileCharsetName");
            int d23 = androidx.room.util.k.d(D0, "subjectId");
            int d24 = androidx.room.util.k.d(D0, "ep");
            int d25 = androidx.room.util.k.d(D0, "se");
            int d26 = androidx.room.util.k.d(D0, "resolution");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n02 = D0.isNull(d11) ? null : D0.n0(d11);
                String n03 = D0.isNull(d12) ? null : D0.n0(d12);
                String n04 = D0.isNull(d13) ? null : D0.n0(d13);
                String n05 = D0.isNull(d14) ? null : D0.n0(d14);
                String n06 = D0.isNull(d15) ? null : D0.n0(d15);
                String n07 = D0.isNull(d16) ? null : D0.n0(d16);
                String n08 = D0.isNull(d17) ? null : D0.n0(d17);
                Long valueOf2 = D0.isNull(d18) ? null : Long.valueOf(D0.getLong(d18));
                if (D0.isNull(d19)) {
                    i12 = d12;
                    i11 = d13;
                    valueOf = null;
                } else {
                    i11 = d13;
                    valueOf = Long.valueOf(D0.getLong(d19));
                    i12 = d12;
                }
                int i13 = d14;
                int i14 = d15;
                int i15 = d25;
                int i16 = d16;
                int i17 = d17;
                int i18 = d19;
                int i19 = d26;
                int i20 = d18;
                arrayList.add(new SubtitleBean(n02, n03, n04, n05, n06, n07, n08, valueOf2, valueOf, (int) D0.getLong(d20), (int) D0.getLong(d21), D0.isNull(d22) ? null : D0.n0(d22), D0.isNull(d23) ? null : D0.n0(d23), (int) D0.getLong(d24), (int) D0.getLong(i15), (int) D0.getLong(i19)));
                d16 = i16;
                d25 = i15;
                d18 = i20;
                d12 = i12;
                d15 = i14;
                d13 = i11;
                d14 = i13;
                d19 = i18;
                d26 = i19;
                d17 = i17;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List p(String str, z3.b bVar) {
        int i11;
        Long valueOf;
        int i12;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE WHERE postId = ? ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "resourceId");
            int d12 = androidx.room.util.k.d(D0, "postId");
            int d13 = androidx.room.util.k.d(D0, "url");
            int d14 = androidx.room.util.k.d(D0, "path");
            int d15 = androidx.room.util.k.d(D0, "lan");
            int d16 = androidx.room.util.k.d(D0, "lanName");
            int d17 = androidx.room.util.k.d(D0, "subtitleName");
            int d18 = androidx.room.util.k.d(D0, "size");
            int d19 = androidx.room.util.k.d(D0, "delayDuration");
            int d20 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d21 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d22 = androidx.room.util.k.d(D0, "fileCharsetName");
            int d23 = androidx.room.util.k.d(D0, "subjectId");
            int d24 = androidx.room.util.k.d(D0, "ep");
            int d25 = androidx.room.util.k.d(D0, "se");
            int d26 = androidx.room.util.k.d(D0, "resolution");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n02 = D0.isNull(d11) ? null : D0.n0(d11);
                String n03 = D0.isNull(d12) ? null : D0.n0(d12);
                String n04 = D0.isNull(d13) ? null : D0.n0(d13);
                String n05 = D0.isNull(d14) ? null : D0.n0(d14);
                String n06 = D0.isNull(d15) ? null : D0.n0(d15);
                String n07 = D0.isNull(d16) ? null : D0.n0(d16);
                String n08 = D0.isNull(d17) ? null : D0.n0(d17);
                Long valueOf2 = D0.isNull(d18) ? null : Long.valueOf(D0.getLong(d18));
                if (D0.isNull(d19)) {
                    i12 = d12;
                    i11 = d13;
                    valueOf = null;
                } else {
                    i11 = d13;
                    valueOf = Long.valueOf(D0.getLong(d19));
                    i12 = d12;
                }
                int i13 = d14;
                int i14 = d15;
                int i15 = d25;
                int i16 = d16;
                int i17 = d17;
                int i18 = d26;
                int i19 = d18;
                int i20 = d19;
                arrayList.add(new SubtitleBean(n02, n03, n04, n05, n06, n07, n08, valueOf2, valueOf, (int) D0.getLong(d20), (int) D0.getLong(d21), D0.isNull(d22) ? null : D0.n0(d22), D0.isNull(d23) ? null : D0.n0(d23), (int) D0.getLong(d24), (int) D0.getLong(i15), (int) D0.getLong(i18)));
                d16 = i16;
                d18 = i19;
                d25 = i15;
                d26 = i18;
                d12 = i12;
                d15 = i14;
                d13 = i11;
                d14 = i13;
                d17 = i17;
                d19 = i20;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List q(String str, z3.b bVar) {
        int i11;
        Long valueOf;
        int i12;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE WHERE subjectId = ? ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "resourceId");
            int d12 = androidx.room.util.k.d(D0, "postId");
            int d13 = androidx.room.util.k.d(D0, "url");
            int d14 = androidx.room.util.k.d(D0, "path");
            int d15 = androidx.room.util.k.d(D0, "lan");
            int d16 = androidx.room.util.k.d(D0, "lanName");
            int d17 = androidx.room.util.k.d(D0, "subtitleName");
            int d18 = androidx.room.util.k.d(D0, "size");
            int d19 = androidx.room.util.k.d(D0, "delayDuration");
            int d20 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d21 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d22 = androidx.room.util.k.d(D0, "fileCharsetName");
            int d23 = androidx.room.util.k.d(D0, "subjectId");
            int d24 = androidx.room.util.k.d(D0, "ep");
            int d25 = androidx.room.util.k.d(D0, "se");
            int d26 = androidx.room.util.k.d(D0, "resolution");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n02 = D0.isNull(d11) ? null : D0.n0(d11);
                String n03 = D0.isNull(d12) ? null : D0.n0(d12);
                String n04 = D0.isNull(d13) ? null : D0.n0(d13);
                String n05 = D0.isNull(d14) ? null : D0.n0(d14);
                String n06 = D0.isNull(d15) ? null : D0.n0(d15);
                String n07 = D0.isNull(d16) ? null : D0.n0(d16);
                String n08 = D0.isNull(d17) ? null : D0.n0(d17);
                Long valueOf2 = D0.isNull(d18) ? null : Long.valueOf(D0.getLong(d18));
                if (D0.isNull(d19)) {
                    i12 = d12;
                    i11 = d13;
                    valueOf = null;
                } else {
                    i11 = d13;
                    valueOf = Long.valueOf(D0.getLong(d19));
                    i12 = d12;
                }
                int i13 = d14;
                int i14 = d15;
                int i15 = d25;
                int i16 = d16;
                int i17 = d17;
                int i18 = d26;
                int i19 = d18;
                int i20 = d19;
                arrayList.add(new SubtitleBean(n02, n03, n04, n05, n06, n07, n08, valueOf2, valueOf, (int) D0.getLong(d20), (int) D0.getLong(d21), D0.isNull(d22) ? null : D0.n0(d22), D0.isNull(d23) ? null : D0.n0(d23), (int) D0.getLong(d24), (int) D0.getLong(i15), (int) D0.getLong(i18)));
                d16 = i16;
                d18 = i19;
                d25 = i15;
                d26 = i18;
                d12 = i12;
                d15 = i14;
                d13 = i11;
                d14 = i13;
                d17 = i17;
                d19 = i20;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List r(String str, int i11, int i12, z3.b bVar) {
        int i13;
        int i14;
        Long valueOf;
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE WHERE subjectId = ? AND ep = ? AND se = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.c(2, i11);
            D0.c(3, i12);
            int d11 = androidx.room.util.k.d(D0, "resourceId");
            int d12 = androidx.room.util.k.d(D0, "postId");
            int d13 = androidx.room.util.k.d(D0, "url");
            int d14 = androidx.room.util.k.d(D0, "path");
            int d15 = androidx.room.util.k.d(D0, "lan");
            int d16 = androidx.room.util.k.d(D0, "lanName");
            int d17 = androidx.room.util.k.d(D0, "subtitleName");
            int d18 = androidx.room.util.k.d(D0, "size");
            int d19 = androidx.room.util.k.d(D0, "delayDuration");
            int d20 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d21 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d22 = androidx.room.util.k.d(D0, "fileCharsetName");
            int d23 = androidx.room.util.k.d(D0, "subjectId");
            int d24 = androidx.room.util.k.d(D0, "ep");
            int d25 = androidx.room.util.k.d(D0, "se");
            int d26 = androidx.room.util.k.d(D0, "resolution");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n02 = D0.isNull(d11) ? null : D0.n0(d11);
                String n03 = D0.isNull(d12) ? null : D0.n0(d12);
                String n04 = D0.isNull(d13) ? null : D0.n0(d13);
                String n05 = D0.isNull(d14) ? null : D0.n0(d14);
                String n06 = D0.isNull(d15) ? null : D0.n0(d15);
                String n07 = D0.isNull(d16) ? null : D0.n0(d16);
                String n08 = D0.isNull(d17) ? null : D0.n0(d17);
                Long valueOf2 = D0.isNull(d18) ? null : Long.valueOf(D0.getLong(d18));
                if (D0.isNull(d19)) {
                    i13 = d12;
                    i14 = d13;
                    valueOf = null;
                } else {
                    i13 = d12;
                    i14 = d13;
                    valueOf = Long.valueOf(D0.getLong(d19));
                }
                int i15 = d14;
                int i16 = d15;
                int i17 = d25;
                int i18 = d16;
                int i19 = d17;
                int i20 = d26;
                int i21 = d18;
                int i22 = d19;
                arrayList.add(new SubtitleBean(n02, n03, n04, n05, n06, n07, n08, valueOf2, valueOf, (int) D0.getLong(d20), (int) D0.getLong(d21), D0.isNull(d22) ? null : D0.n0(d22), D0.isNull(d23) ? null : D0.n0(d23), (int) D0.getLong(d24), (int) D0.getLong(i17), (int) D0.getLong(i20)));
                d16 = i18;
                d18 = i21;
                d12 = i13;
                d13 = i14;
                d25 = i17;
                d26 = i20;
                d14 = i15;
                d15 = i16;
                d17 = i19;
                d19 = i22;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(SubtitleBean subtitleBean, z3.b bVar) {
        this.f68998c.c(bVar, subtitleBean);
        return Unit.f67184a;
    }

    @Override // lj.v0
    public Object a(final SubtitleBean subtitleBean, Continuation continuation) {
        subtitleBean.getClass();
        return androidx.room.util.b.f(this.f68996a, false, true, new Function1() { // from class: lj.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s11;
                s11 = c1.this.s(subtitleBean, (z3.b) obj);
                return s11;
            }
        }, continuation);
    }

    @Override // lj.v0
    public Object b(Continuation continuation) {
        return androidx.room.util.b.f(this.f68996a, true, false, new Function1() { // from class: lj.a1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List o11;
                o11 = c1.o((z3.b) obj);
                return o11;
            }
        }, continuation);
    }

    @Override // lj.v0
    public Object c(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f68996a, true, false, new Function1() { // from class: lj.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List q11;
                q11 = c1.q(str, (z3.b) obj);
                return q11;
            }
        }, continuation);
    }

    @Override // lj.v0
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f68996a, false, true, new Function1() { // from class: lj.b1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n11;
                n11 = c1.n(str, (z3.b) obj);
                return n11;
            }
        }, continuation);
    }

    @Override // lj.v0
    public Object e(final String str, final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f68996a, true, false, new Function1() { // from class: lj.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List r11;
                r11 = c1.r(str, i11, i12, (z3.b) obj);
                return r11;
            }
        }, continuation);
    }

    @Override // lj.v0
    public Object f(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f68996a, true, false, new Function1() { // from class: lj.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List p11;
                p11 = c1.p(str, (z3.b) obj);
                return p11;
            }
        }, continuation);
    }
}
