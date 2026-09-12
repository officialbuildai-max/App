package k0;

import java.text.CharacterIterator;

/* loaded from: classes2.dex */
public final class b0 implements CharacterIterator {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f66593a;

    /* renamed from: b, reason: collision with root package name */
    private final int f66594b;

    /* renamed from: c, reason: collision with root package name */
    private final int f66595c;

    /* renamed from: d, reason: collision with root package name */
    private int f66596d;

    public b0(CharSequence charSequence, int i11, int i12) {
        this.f66593a = charSequence;
        this.f66594b = i11;
        this.f66595c = i12;
        this.f66596d = i11;
    }

    @Override // java.text.CharacterIterator
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.text.CharacterIterator
    public char current() {
        int i11 = this.f66596d;
        if (i11 == this.f66595c) {
            return (char) 65535;
        }
        return this.f66593a.charAt(i11);
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.f66596d = this.f66594b;
        return current();
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.f66594b;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.f66595c;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.f66596d;
    }

    @Override // java.text.CharacterIterator
    public char last() {
        int i11 = this.f66594b;
        int i12 = this.f66595c;
        if (i11 == i12) {
            this.f66596d = i12;
            return (char) 65535;
        }
        int i13 = i12 - 1;
        this.f66596d = i13;
        return this.f66593a.charAt(i13);
    }

    @Override // java.text.CharacterIterator
    public char next() {
        int i11 = this.f66596d + 1;
        this.f66596d = i11;
        int i12 = this.f66595c;
        if (i11 < i12) {
            return this.f66593a.charAt(i11);
        }
        this.f66596d = i12;
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        int i11 = this.f66596d;
        if (i11 <= this.f66594b) {
            return (char) 65535;
        }
        int i12 = i11 - 1;
        this.f66596d = i12;
        return this.f66593a.charAt(i12);
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int i11) {
        int i12 = this.f66594b;
        if (i11 > this.f66595c || i12 > i11) {
            throw new IllegalArgumentException("invalid position");
        }
        this.f66596d = i11;
        return current();
    }
}
