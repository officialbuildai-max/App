package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public class Grant {

    /* renamed from: a, reason: collision with root package name */
    private Grantee f18787a;

    /* renamed from: b, reason: collision with root package name */
    private Permission f18788b;

    public Grant(Grantee grantee, Permission permission) {
        this.f18787a = grantee;
        this.f18788b = permission;
    }

    public Grantee a() {
        return this.f18787a;
    }

    public Permission b() {
        return this.f18788b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Grant grant = (Grant) obj;
        Grantee grantee = this.f18787a;
        if (grantee == null) {
            if (grant.f18787a != null) {
                return false;
            }
        } else if (!grantee.equals(grant.f18787a)) {
            return false;
        }
        return this.f18788b == grant.f18788b;
    }

    public int hashCode() {
        Grantee grantee = this.f18787a;
        int hashCode = ((grantee == null ? 0 : grantee.hashCode()) + 31) * 31;
        Permission permission = this.f18788b;
        return hashCode + (permission != null ? permission.hashCode() : 0);
    }

    public String toString() {
        return "Grant [grantee=" + this.f18787a + ", permission=" + this.f18788b + "]";
    }
}
