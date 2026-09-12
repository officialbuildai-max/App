package com.bigkoo.pickerview.view;

import android.view.View;
import com.bigkoo.pickerview.R$id;
import com.bigkoo.pickerview.R$string;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.contrarywind.view.WheelView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: y, reason: collision with root package name */
    public static DateFormat f20050y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: a, reason: collision with root package name */
    private View f20051a;

    /* renamed from: b, reason: collision with root package name */
    private WheelView f20052b;

    /* renamed from: c, reason: collision with root package name */
    private WheelView f20053c;

    /* renamed from: d, reason: collision with root package name */
    private WheelView f20054d;

    /* renamed from: e, reason: collision with root package name */
    private WheelView f20055e;

    /* renamed from: f, reason: collision with root package name */
    private WheelView f20056f;

    /* renamed from: g, reason: collision with root package name */
    private WheelView f20057g;

    /* renamed from: h, reason: collision with root package name */
    private int f20058h;

    /* renamed from: i, reason: collision with root package name */
    private boolean[] f20059i;

    /* renamed from: p, reason: collision with root package name */
    private int f20066p;

    /* renamed from: q, reason: collision with root package name */
    private int f20067q;

    /* renamed from: r, reason: collision with root package name */
    private int f20068r;

    /* renamed from: s, reason: collision with root package name */
    private int f20069s;

    /* renamed from: t, reason: collision with root package name */
    private int f20070t;

    /* renamed from: u, reason: collision with root package name */
    private float f20071u;

    /* renamed from: v, reason: collision with root package name */
    private WheelView.DividerType f20072v;

    /* renamed from: x, reason: collision with root package name */
    private q5.a f20074x;

    /* renamed from: j, reason: collision with root package name */
    private int f20060j = 1900;

    /* renamed from: k, reason: collision with root package name */
    private int f20061k = 2100;

    /* renamed from: l, reason: collision with root package name */
    private int f20062l = 1;

    /* renamed from: m, reason: collision with root package name */
    private int f20063m = 12;

    /* renamed from: n, reason: collision with root package name */
    private int f20064n = 1;

    /* renamed from: o, reason: collision with root package name */
    private int f20065o = 31;

    /* renamed from: w, reason: collision with root package name */
    private boolean f20073w = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements n7.b {
        a() {
        }

        @Override // n7.b
        public void a(int i11) {
            int h11;
            int i12 = i11 + b.this.f20060j;
            b.this.f20053c.setAdapter(new n5.a(r5.a.d(i12)));
            if (r5.a.g(i12) == 0 || b.this.f20053c.getCurrentItem() <= r5.a.g(i12) - 1) {
                b.this.f20053c.setCurrentItem(b.this.f20053c.getCurrentItem());
            } else {
                b.this.f20053c.setCurrentItem(b.this.f20053c.getCurrentItem() + 1);
            }
            if (r5.a.g(i12) == 0 || b.this.f20053c.getCurrentItem() <= r5.a.g(i12) - 1) {
                b.this.f20054d.setAdapter(new n5.a(r5.a.b(r5.a.h(i12, b.this.f20053c.getCurrentItem() + 1))));
                h11 = r5.a.h(i12, b.this.f20053c.getCurrentItem() + 1);
            } else if (b.this.f20053c.getCurrentItem() == r5.a.g(i12) + 1) {
                b.this.f20054d.setAdapter(new n5.a(r5.a.b(r5.a.f(i12))));
                h11 = r5.a.f(i12);
            } else {
                b.this.f20054d.setAdapter(new n5.a(r5.a.b(r5.a.h(i12, b.this.f20053c.getCurrentItem()))));
                h11 = r5.a.h(i12, b.this.f20053c.getCurrentItem());
            }
            int i13 = h11 - 1;
            if (b.this.f20054d.getCurrentItem() > i13) {
                b.this.f20054d.setCurrentItem(i13);
            }
            if (b.this.f20074x != null) {
                b.this.f20074x.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bigkoo.pickerview.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0191b implements n7.b {
        C0191b() {
        }

        @Override // n7.b
        public void a(int i11) {
            int h11;
            int currentItem = b.this.f20052b.getCurrentItem() + b.this.f20060j;
            if (r5.a.g(currentItem) == 0 || i11 <= r5.a.g(currentItem) - 1) {
                int i12 = i11 + 1;
                b.this.f20054d.setAdapter(new n5.a(r5.a.b(r5.a.h(currentItem, i12))));
                h11 = r5.a.h(currentItem, i12);
            } else if (b.this.f20053c.getCurrentItem() == r5.a.g(currentItem) + 1) {
                b.this.f20054d.setAdapter(new n5.a(r5.a.b(r5.a.f(currentItem))));
                h11 = r5.a.f(currentItem);
            } else {
                b.this.f20054d.setAdapter(new n5.a(r5.a.b(r5.a.h(currentItem, i11))));
                h11 = r5.a.h(currentItem, i11);
            }
            int i13 = h11 - 1;
            if (b.this.f20054d.getCurrentItem() > i13) {
                b.this.f20054d.setCurrentItem(i13);
            }
            if (b.this.f20074x != null) {
                b.this.f20074x.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements n7.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f20077a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f20078b;

        c(List list, List list2) {
            this.f20077a = list;
            this.f20078b = list2;
        }

        @Override // n7.b
        public void a(int i11) {
            int i12 = i11 + b.this.f20060j;
            b.this.f20066p = i12;
            int currentItem = b.this.f20053c.getCurrentItem();
            if (b.this.f20060j == b.this.f20061k) {
                b.this.f20053c.setAdapter(new n5.b(b.this.f20062l, b.this.f20063m));
                if (currentItem > b.this.f20053c.getAdapter().a() - 1) {
                    currentItem = b.this.f20053c.getAdapter().a() - 1;
                    b.this.f20053c.setCurrentItem(currentItem);
                }
                int i13 = currentItem + b.this.f20062l;
                if (b.this.f20062l == b.this.f20063m) {
                    b bVar = b.this;
                    bVar.F(i12, i13, bVar.f20064n, b.this.f20065o, this.f20077a, this.f20078b);
                } else if (i13 == b.this.f20062l) {
                    b bVar2 = b.this;
                    bVar2.F(i12, i13, bVar2.f20064n, 31, this.f20077a, this.f20078b);
                } else if (i13 == b.this.f20063m) {
                    b bVar3 = b.this;
                    bVar3.F(i12, i13, 1, bVar3.f20065o, this.f20077a, this.f20078b);
                } else {
                    b.this.F(i12, i13, 1, 31, this.f20077a, this.f20078b);
                }
            } else if (i12 == b.this.f20060j) {
                b.this.f20053c.setAdapter(new n5.b(b.this.f20062l, 12));
                if (currentItem > b.this.f20053c.getAdapter().a() - 1) {
                    currentItem = b.this.f20053c.getAdapter().a() - 1;
                    b.this.f20053c.setCurrentItem(currentItem);
                }
                int i14 = currentItem + b.this.f20062l;
                if (i14 == b.this.f20062l) {
                    b bVar4 = b.this;
                    bVar4.F(i12, i14, bVar4.f20064n, 31, this.f20077a, this.f20078b);
                } else {
                    b.this.F(i12, i14, 1, 31, this.f20077a, this.f20078b);
                }
            } else if (i12 == b.this.f20061k) {
                b.this.f20053c.setAdapter(new n5.b(1, b.this.f20063m));
                if (currentItem > b.this.f20053c.getAdapter().a() - 1) {
                    currentItem = b.this.f20053c.getAdapter().a() - 1;
                    b.this.f20053c.setCurrentItem(currentItem);
                }
                int i15 = 1 + currentItem;
                if (i15 == b.this.f20063m) {
                    b bVar5 = b.this;
                    bVar5.F(i12, i15, 1, bVar5.f20065o, this.f20077a, this.f20078b);
                } else {
                    b.this.F(i12, i15, 1, 31, this.f20077a, this.f20078b);
                }
            } else {
                b.this.f20053c.setAdapter(new n5.b(1, 12));
                b bVar6 = b.this;
                bVar6.F(i12, 1 + bVar6.f20053c.getCurrentItem(), 1, 31, this.f20077a, this.f20078b);
            }
            if (b.this.f20074x != null) {
                b.this.f20074x.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements n7.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f20080a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f20081b;

        d(List list, List list2) {
            this.f20080a = list;
            this.f20081b = list2;
        }

        @Override // n7.b
        public void a(int i11) {
            int i12 = i11 + 1;
            if (b.this.f20060j == b.this.f20061k) {
                int i13 = (i12 + b.this.f20062l) - 1;
                if (b.this.f20062l == b.this.f20063m) {
                    b bVar = b.this;
                    bVar.F(bVar.f20066p, i13, b.this.f20064n, b.this.f20065o, this.f20080a, this.f20081b);
                } else if (b.this.f20062l == i13) {
                    b bVar2 = b.this;
                    bVar2.F(bVar2.f20066p, i13, b.this.f20064n, 31, this.f20080a, this.f20081b);
                } else if (b.this.f20063m == i13) {
                    b bVar3 = b.this;
                    bVar3.F(bVar3.f20066p, i13, 1, b.this.f20065o, this.f20080a, this.f20081b);
                } else {
                    b bVar4 = b.this;
                    bVar4.F(bVar4.f20066p, i13, 1, 31, this.f20080a, this.f20081b);
                }
            } else if (b.this.f20066p == b.this.f20060j) {
                int i14 = (i12 + b.this.f20062l) - 1;
                if (i14 == b.this.f20062l) {
                    b bVar5 = b.this;
                    bVar5.F(bVar5.f20066p, i14, b.this.f20064n, 31, this.f20080a, this.f20081b);
                } else {
                    b bVar6 = b.this;
                    bVar6.F(bVar6.f20066p, i14, 1, 31, this.f20080a, this.f20081b);
                }
            } else if (b.this.f20066p != b.this.f20061k) {
                b bVar7 = b.this;
                bVar7.F(bVar7.f20066p, i12, 1, 31, this.f20080a, this.f20081b);
            } else if (i12 == b.this.f20063m) {
                b bVar8 = b.this;
                bVar8.F(bVar8.f20066p, b.this.f20053c.getCurrentItem() + 1, 1, b.this.f20065o, this.f20080a, this.f20081b);
            } else {
                b bVar9 = b.this;
                bVar9.F(bVar9.f20066p, b.this.f20053c.getCurrentItem() + 1, 1, 31, this.f20080a, this.f20081b);
            }
            if (b.this.f20074x != null) {
                b.this.f20074x.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements n7.b {
        e() {
        }

        @Override // n7.b
        public void a(int i11) {
            b.this.f20074x.a();
        }
    }

    public b(View view, boolean[] zArr, int i11, int i12) {
        this.f20051a = view;
        this.f20059i = zArr;
        this.f20058h = i11;
        this.f20067q = i12;
        N(view);
    }

    private void B(int i11, int i12, int i13, boolean z10, int i14, int i15, int i16) {
        WheelView wheelView = (WheelView) this.f20051a.findViewById(R$id.year);
        this.f20052b = wheelView;
        wheelView.setAdapter(new n5.a(r5.a.e(this.f20060j, this.f20061k)));
        this.f20052b.setLabel("");
        this.f20052b.setCurrentItem(i11 - this.f20060j);
        this.f20052b.setGravity(this.f20058h);
        WheelView wheelView2 = (WheelView) this.f20051a.findViewById(R$id.month);
        this.f20053c = wheelView2;
        wheelView2.setAdapter(new n5.a(r5.a.d(i11)));
        this.f20053c.setLabel("");
        this.f20053c.setConvertMonth(true);
        int g11 = r5.a.g(i11);
        if (g11 == 0 || (i12 <= g11 - 1 && !z10)) {
            this.f20053c.setCurrentItem(i12);
        } else {
            this.f20053c.setCurrentItem(i12 + 1);
        }
        this.f20053c.setGravity(this.f20058h);
        this.f20054d = (WheelView) this.f20051a.findViewById(R$id.day);
        if (r5.a.g(i11) == 0) {
            this.f20054d.setAdapter(new n5.a(r5.a.b(r5.a.h(i11, i12))));
        } else {
            this.f20054d.setAdapter(new n5.a(r5.a.b(r5.a.f(i11))));
        }
        this.f20054d.setLabel("");
        this.f20054d.setCurrentItem(i13 - 1);
        this.f20054d.setGravity(this.f20058h);
        WheelView wheelView3 = (WheelView) this.f20051a.findViewById(R$id.hour);
        this.f20055e = wheelView3;
        wheelView3.setAdapter(new n5.b(0, 23));
        this.f20055e.setCurrentItem(i14);
        this.f20055e.setGravity(this.f20058h);
        WheelView wheelView4 = (WheelView) this.f20051a.findViewById(R$id.min);
        this.f20056f = wheelView4;
        wheelView4.setAdapter(new n5.b(0, 59));
        this.f20056f.setCurrentItem(i15);
        this.f20056f.setGravity(this.f20058h);
        WheelView wheelView5 = (WheelView) this.f20051a.findViewById(R$id.second);
        this.f20057g = wheelView5;
        wheelView5.setAdapter(new n5.b(0, 59));
        this.f20057g.setCurrentItem(i15);
        this.f20057g.setGravity(this.f20058h);
        this.f20052b.setOnItemSelectedListener(new a());
        this.f20053c.setOnItemSelectedListener(new C0191b());
        q(this.f20054d);
        q(this.f20055e);
        q(this.f20056f);
        q(this.f20057g);
        boolean[] zArr = this.f20059i;
        if (zArr.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.f20052b.setVisibility(zArr[0] ? 0 : 8);
        this.f20053c.setVisibility(this.f20059i[1] ? 0 : 8);
        this.f20054d.setVisibility(this.f20059i[2] ? 0 : 8);
        this.f20055e.setVisibility(this.f20059i[3] ? 0 : 8);
        this.f20056f.setVisibility(this.f20059i[4] ? 0 : 8);
        this.f20057g.setVisibility(this.f20059i[5] ? 0 : 8);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i11, int i12, int i13, int i14, List list, List list2) {
        int currentItem = this.f20054d.getCurrentItem();
        if (list.contains(String.valueOf(i12))) {
            if (i14 > 31) {
                i14 = 31;
            }
            this.f20054d.setAdapter(new n5.b(i13, i14));
        } else if (list2.contains(String.valueOf(i12))) {
            if (i14 > 30) {
                i14 = 30;
            }
            this.f20054d.setAdapter(new n5.b(i13, i14));
        } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % 400 != 0) {
            if (i14 > 28) {
                i14 = 28;
            }
            this.f20054d.setAdapter(new n5.b(i13, i14));
        } else {
            if (i14 > 29) {
                i14 = 29;
            }
            this.f20054d.setAdapter(new n5.b(i13, i14));
        }
        if (currentItem > this.f20054d.getAdapter().a() - 1) {
            this.f20054d.setCurrentItem(this.f20054d.getAdapter().a() - 1);
        }
    }

    private void G(int i11, int i12, int i13, int i14, int i15, int i16) {
        int i17;
        int i18;
        String[] strArr = {"1", "3", "5", "7", PrepareException.ERROR_MANIFEST_INFO, "10", "12"};
        String[] strArr2 = {"4", PrepareException.ERROR_NO_URL, PrepareException.ERROR_MINI_APP_CLOSE, PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY};
        List asList = Arrays.asList(strArr);
        List asList2 = Arrays.asList(strArr2);
        this.f20066p = i11;
        WheelView wheelView = (WheelView) this.f20051a.findViewById(R$id.year);
        this.f20052b = wheelView;
        wheelView.setAdapter(new n5.b(this.f20060j, this.f20061k));
        this.f20052b.setCurrentItem(i11 - this.f20060j);
        this.f20052b.setGravity(this.f20058h);
        WheelView wheelView2 = (WheelView) this.f20051a.findViewById(R$id.month);
        this.f20053c = wheelView2;
        wheelView2.setConvertMonth(true);
        int i19 = this.f20060j;
        int i20 = this.f20061k;
        if (i19 == i20) {
            this.f20053c.setAdapter(new n5.b(this.f20062l, this.f20063m));
            this.f20053c.setCurrentItem((i12 + 1) - this.f20062l);
        } else if (i11 == i19) {
            this.f20053c.setAdapter(new n5.b(this.f20062l, 12));
            this.f20053c.setCurrentItem((i12 + 1) - this.f20062l);
        } else if (i11 == i20) {
            this.f20053c.setAdapter(new n5.b(1, this.f20063m));
            this.f20053c.setCurrentItem(i12);
        } else {
            this.f20053c.setAdapter(new n5.b(1, 12));
            this.f20053c.setCurrentItem(i12);
        }
        this.f20053c.setGravity(this.f20058h);
        this.f20054d = (WheelView) this.f20051a.findViewById(R$id.day);
        int i21 = this.f20060j;
        int i22 = this.f20061k;
        if (i21 == i22 && this.f20062l == this.f20063m) {
            int i23 = i12 + 1;
            if (asList.contains(String.valueOf(i23))) {
                if (this.f20065o > 31) {
                    this.f20065o = 31;
                }
                this.f20054d.setAdapter(new n5.b(this.f20064n, this.f20065o));
            } else if (asList2.contains(String.valueOf(i23))) {
                if (this.f20065o > 30) {
                    this.f20065o = 30;
                }
                this.f20054d.setAdapter(new n5.b(this.f20064n, this.f20065o));
            } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % 400 != 0) {
                if (this.f20065o > 28) {
                    this.f20065o = 28;
                }
                this.f20054d.setAdapter(new n5.b(this.f20064n, this.f20065o));
            } else {
                if (this.f20065o > 29) {
                    this.f20065o = 29;
                }
                this.f20054d.setAdapter(new n5.b(this.f20064n, this.f20065o));
            }
            this.f20054d.setCurrentItem(i13 - this.f20064n);
        } else if (i11 == i21 && (i18 = i12 + 1) == this.f20062l) {
            if (asList.contains(String.valueOf(i18))) {
                this.f20054d.setAdapter(new n5.b(this.f20064n, 31));
            } else if (asList2.contains(String.valueOf(i18))) {
                this.f20054d.setAdapter(new n5.b(this.f20064n, 30));
            } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % 400 != 0) {
                this.f20054d.setAdapter(new n5.b(this.f20064n, 28));
            } else {
                this.f20054d.setAdapter(new n5.b(this.f20064n, 29));
            }
            this.f20054d.setCurrentItem(i13 - this.f20064n);
        } else if (i11 == i22 && (i17 = i12 + 1) == this.f20063m) {
            if (asList.contains(String.valueOf(i17))) {
                if (this.f20065o > 31) {
                    this.f20065o = 31;
                }
                this.f20054d.setAdapter(new n5.b(1, this.f20065o));
            } else if (asList2.contains(String.valueOf(i17))) {
                if (this.f20065o > 30) {
                    this.f20065o = 30;
                }
                this.f20054d.setAdapter(new n5.b(1, this.f20065o));
            } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % 400 != 0) {
                if (this.f20065o > 28) {
                    this.f20065o = 28;
                }
                this.f20054d.setAdapter(new n5.b(1, this.f20065o));
            } else {
                if (this.f20065o > 29) {
                    this.f20065o = 29;
                }
                this.f20054d.setAdapter(new n5.b(1, this.f20065o));
            }
            this.f20054d.setCurrentItem(i13 - 1);
        } else {
            int i24 = i12 + 1;
            if (asList.contains(String.valueOf(i24))) {
                this.f20054d.setAdapter(new n5.b(1, 31));
            } else if (asList2.contains(String.valueOf(i24))) {
                this.f20054d.setAdapter(new n5.b(1, 30));
            } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % 400 != 0) {
                this.f20054d.setAdapter(new n5.b(1, 28));
            } else {
                this.f20054d.setAdapter(new n5.b(1, 29));
            }
            this.f20054d.setCurrentItem(i13 - 1);
        }
        this.f20054d.setGravity(this.f20058h);
        WheelView wheelView3 = (WheelView) this.f20051a.findViewById(R$id.hour);
        this.f20055e = wheelView3;
        wheelView3.setAdapter(new n5.b(0, 23));
        this.f20055e.setCurrentItem(i14);
        this.f20055e.setGravity(this.f20058h);
        WheelView wheelView4 = (WheelView) this.f20051a.findViewById(R$id.min);
        this.f20056f = wheelView4;
        wheelView4.setAdapter(new n5.b(0, 59));
        this.f20056f.setCurrentItem(i15);
        this.f20056f.setGravity(this.f20058h);
        WheelView wheelView5 = (WheelView) this.f20051a.findViewById(R$id.second);
        this.f20057g = wheelView5;
        wheelView5.setAdapter(new n5.b(0, 59));
        this.f20057g.setCurrentItem(i16);
        this.f20057g.setGravity(this.f20058h);
        this.f20052b.setOnItemSelectedListener(new c(asList, asList2));
        this.f20053c.setOnItemSelectedListener(new d(asList, asList2));
        q(this.f20054d);
        q(this.f20055e);
        q(this.f20056f);
        q(this.f20057g);
        boolean[] zArr = this.f20059i;
        if (zArr.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.f20052b.setVisibility(zArr[0] ? 0 : 8);
        this.f20053c.setVisibility(this.f20059i[1] ? 0 : 8);
        this.f20054d.setVisibility(this.f20059i[2] ? 0 : 8);
        this.f20055e.setVisibility(this.f20059i[3] ? 0 : 8);
        this.f20056f.setVisibility(this.f20059i[4] ? 0 : 8);
        this.f20057g.setVisibility(this.f20059i[5] ? 0 : 8);
        r();
    }

    private void I() {
        this.f20054d.setTextColorCenter(this.f20069s);
        this.f20053c.setTextColorCenter(this.f20069s);
        this.f20052b.setTextColorCenter(this.f20069s);
        this.f20055e.setTextColorCenter(this.f20069s);
        this.f20056f.setTextColorCenter(this.f20069s);
        this.f20057g.setTextColorCenter(this.f20069s);
    }

    private void K() {
        this.f20054d.setTextColorOut(this.f20068r);
        this.f20053c.setTextColorOut(this.f20068r);
        this.f20052b.setTextColorOut(this.f20068r);
        this.f20055e.setTextColorOut(this.f20068r);
        this.f20056f.setTextColorOut(this.f20068r);
        this.f20057g.setTextColorOut(this.f20068r);
    }

    private String n() {
        int currentItem;
        boolean z10;
        int currentItem2;
        StringBuilder sb2 = new StringBuilder();
        int currentItem3 = this.f20052b.getCurrentItem() + this.f20060j;
        if (r5.a.g(currentItem3) == 0) {
            currentItem2 = this.f20053c.getCurrentItem();
        } else {
            if ((this.f20053c.getCurrentItem() + 1) - r5.a.g(currentItem3) > 0) {
                if ((this.f20053c.getCurrentItem() + 1) - r5.a.g(currentItem3) == 1) {
                    currentItem = this.f20053c.getCurrentItem();
                    z10 = true;
                    int[] b11 = r5.b.b(currentItem3, currentItem, this.f20054d.getCurrentItem() + 1, z10);
                    sb2.append(b11[0]);
                    sb2.append("-");
                    sb2.append(b11[1]);
                    sb2.append("-");
                    sb2.append(b11[2]);
                    sb2.append(" ");
                    sb2.append(this.f20055e.getCurrentItem());
                    sb2.append(":");
                    sb2.append(this.f20056f.getCurrentItem());
                    sb2.append(":");
                    sb2.append(this.f20057g.getCurrentItem());
                    return sb2.toString();
                }
                currentItem = this.f20053c.getCurrentItem();
                z10 = false;
                int[] b112 = r5.b.b(currentItem3, currentItem, this.f20054d.getCurrentItem() + 1, z10);
                sb2.append(b112[0]);
                sb2.append("-");
                sb2.append(b112[1]);
                sb2.append("-");
                sb2.append(b112[2]);
                sb2.append(" ");
                sb2.append(this.f20055e.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f20056f.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f20057g.getCurrentItem());
                return sb2.toString();
            }
            currentItem2 = this.f20053c.getCurrentItem();
        }
        currentItem = currentItem2 + 1;
        z10 = false;
        int[] b1122 = r5.b.b(currentItem3, currentItem, this.f20054d.getCurrentItem() + 1, z10);
        sb2.append(b1122[0]);
        sb2.append("-");
        sb2.append(b1122[1]);
        sb2.append("-");
        sb2.append(b1122[2]);
        sb2.append(" ");
        sb2.append(this.f20055e.getCurrentItem());
        sb2.append(":");
        sb2.append(this.f20056f.getCurrentItem());
        sb2.append(":");
        sb2.append(this.f20057g.getCurrentItem());
        return sb2.toString();
    }

    private void q(WheelView wheelView) {
        if (this.f20074x != null) {
            wheelView.setOnItemSelectedListener(new e());
        }
    }

    private void r() {
        this.f20054d.setTextSize(this.f20067q);
        this.f20053c.setTextSize(this.f20067q);
        this.f20052b.setTextSize(this.f20067q);
        this.f20055e.setTextSize(this.f20067q);
        this.f20056f.setTextSize(this.f20067q);
        this.f20057g.setTextSize(this.f20067q);
    }

    private void t() {
        this.f20054d.setDividerColor(this.f20070t);
        this.f20053c.setDividerColor(this.f20070t);
        this.f20052b.setDividerColor(this.f20070t);
        this.f20055e.setDividerColor(this.f20070t);
        this.f20056f.setDividerColor(this.f20070t);
        this.f20057g.setDividerColor(this.f20070t);
    }

    private void v() {
        this.f20054d.setDividerType(this.f20072v);
        this.f20053c.setDividerType(this.f20072v);
        this.f20052b.setDividerType(this.f20072v);
        this.f20055e.setDividerType(this.f20072v);
        this.f20056f.setDividerType(this.f20072v);
        this.f20057g.setDividerType(this.f20072v);
    }

    private void z() {
        this.f20054d.setLineSpacingMultiplier(this.f20071u);
        this.f20053c.setLineSpacingMultiplier(this.f20071u);
        this.f20052b.setLineSpacingMultiplier(this.f20071u);
        this.f20055e.setLineSpacingMultiplier(this.f20071u);
        this.f20056f.setLineSpacingMultiplier(this.f20071u);
        this.f20057g.setLineSpacingMultiplier(this.f20071u);
    }

    public void A(float f11) {
        this.f20071u = f11;
        z();
    }

    public void C(boolean z10) {
        this.f20073w = z10;
    }

    public void D(int i11, int i12, int i13, int i14, int i15, int i16) {
        if (!this.f20073w) {
            G(i11, i12, i13, i14, i15, i16);
        } else {
            int[] d11 = r5.b.d(i11, i12 + 1, i13);
            B(d11[0], d11[1] - 1, d11[2], d11[3] == 1, i14, i15, i16);
        }
    }

    public void E(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i11 = calendar2.get(1);
            int i12 = calendar2.get(2) + 1;
            int i13 = calendar2.get(5);
            int i14 = this.f20060j;
            if (i11 > i14) {
                this.f20061k = i11;
                this.f20063m = i12;
                this.f20065o = i13;
                return;
            } else {
                if (i11 == i14) {
                    int i15 = this.f20062l;
                    if (i12 > i15) {
                        this.f20061k = i11;
                        this.f20063m = i12;
                        this.f20065o = i13;
                        return;
                    } else {
                        if (i12 != i15 || i13 <= this.f20064n) {
                            return;
                        }
                        this.f20061k = i11;
                        this.f20063m = i12;
                        this.f20065o = i13;
                        return;
                    }
                }
                return;
            }
        }
        if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.f20060j = calendar.get(1);
            this.f20061k = calendar2.get(1);
            this.f20062l = calendar.get(2) + 1;
            this.f20063m = calendar2.get(2) + 1;
            this.f20064n = calendar.get(5);
            this.f20065o = calendar2.get(5);
            return;
        }
        int i16 = calendar.get(1);
        int i17 = calendar.get(2) + 1;
        int i18 = calendar.get(5);
        int i19 = this.f20061k;
        if (i16 < i19) {
            this.f20062l = i17;
            this.f20064n = i18;
            this.f20060j = i16;
        } else if (i16 == i19) {
            int i20 = this.f20063m;
            if (i17 < i20) {
                this.f20062l = i17;
                this.f20064n = i18;
                this.f20060j = i16;
            } else {
                if (i17 != i20 || i18 >= this.f20065o) {
                    return;
                }
                this.f20062l = i17;
                this.f20064n = i18;
                this.f20060j = i16;
            }
        }
    }

    public void H(int i11) {
        this.f20060j = i11;
    }

    public void J(int i11) {
        this.f20069s = i11;
        I();
    }

    public void L(int i11) {
        this.f20068r = i11;
        K();
    }

    public void M(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f20054d.setTextXOffset(i11);
        this.f20053c.setTextXOffset(i12);
        this.f20052b.setTextXOffset(i13);
        this.f20055e.setTextXOffset(i14);
        this.f20056f.setTextXOffset(i15);
        this.f20057g.setTextXOffset(i16);
    }

    public void N(View view) {
        this.f20051a = view;
    }

    public String o() {
        if (this.f20073w) {
            return n();
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f20066p == this.f20060j) {
            int currentItem = this.f20053c.getCurrentItem();
            int i11 = this.f20062l;
            if (currentItem + i11 == i11) {
                sb2.append(this.f20052b.getCurrentItem() + this.f20060j);
                sb2.append("-");
                sb2.append(this.f20053c.getCurrentItem() + this.f20062l);
                sb2.append("-");
                sb2.append(this.f20054d.getCurrentItem() + this.f20064n);
                sb2.append(" ");
                sb2.append(this.f20055e.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f20056f.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f20057g.getCurrentItem());
            } else {
                sb2.append(this.f20052b.getCurrentItem() + this.f20060j);
                sb2.append("-");
                sb2.append(this.f20053c.getCurrentItem() + this.f20062l);
                sb2.append("-");
                sb2.append(this.f20054d.getCurrentItem() + 1);
                sb2.append(" ");
                sb2.append(this.f20055e.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f20056f.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f20057g.getCurrentItem());
            }
        } else {
            sb2.append(this.f20052b.getCurrentItem() + this.f20060j);
            sb2.append("-");
            sb2.append(this.f20053c.getCurrentItem() + 1);
            sb2.append("-");
            sb2.append(this.f20054d.getCurrentItem() + 1);
            sb2.append(" ");
            sb2.append(this.f20055e.getCurrentItem());
            sb2.append(":");
            sb2.append(this.f20056f.getCurrentItem());
            sb2.append(":");
            sb2.append(this.f20057g.getCurrentItem());
        }
        return sb2.toString();
    }

    public void p(boolean z10) {
        this.f20054d.isCenterLabel(z10);
        this.f20053c.isCenterLabel(z10);
        this.f20052b.isCenterLabel(z10);
        this.f20055e.isCenterLabel(z10);
        this.f20056f.isCenterLabel(z10);
        this.f20057g.isCenterLabel(z10);
    }

    public void s(boolean z10) {
        this.f20052b.setCyclic(z10);
        this.f20053c.setCyclic(z10);
        this.f20054d.setCyclic(z10);
        this.f20055e.setCyclic(z10);
        this.f20056f.setCyclic(z10);
        this.f20057g.setCyclic(z10);
    }

    public void u(int i11) {
        this.f20070t = i11;
        t();
    }

    public void w(WheelView.DividerType dividerType) {
        this.f20072v = dividerType;
        v();
    }

    public void x(int i11) {
        this.f20061k = i11;
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.f20073w) {
            return;
        }
        if (str != null) {
            this.f20052b.setLabel(str);
        } else {
            this.f20052b.setLabel(this.f20051a.getContext().getString(R$string.pickerview_year));
        }
        if (str2 != null) {
            this.f20053c.setLabel(str2);
        } else {
            this.f20053c.setLabel(this.f20051a.getContext().getString(R$string.pickerview_month));
        }
        if (str3 != null) {
            this.f20054d.setLabel(str3);
        } else {
            this.f20054d.setLabel(this.f20051a.getContext().getString(R$string.pickerview_day));
        }
        if (str4 != null) {
            this.f20055e.setLabel(str4);
        } else {
            this.f20055e.setLabel(this.f20051a.getContext().getString(R$string.pickerview_hours));
        }
        if (str5 != null) {
            this.f20056f.setLabel(str5);
        } else {
            this.f20056f.setLabel(this.f20051a.getContext().getString(R$string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f20057g.setLabel(str6);
        } else {
            this.f20057g.setLabel(this.f20051a.getContext().getString(R$string.pickerview_seconds));
        }
    }
}
