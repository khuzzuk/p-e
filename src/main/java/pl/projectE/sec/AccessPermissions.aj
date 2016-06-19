package pl.projectE.sec;

public aspect AccessPermissions {

    pointcut fieldAccess(): set(@pl.projectE.sec.LimitedAccess * *.*)
            || get(@pl.projectE.sec.LimitedAccess * *.*);

    pointcut noPermission(): !@withincode(pl.projectE.sec.Privileged);

    pointcut permissionCheck(Privileged access): @within(access);

    before(): fieldAccess() && noPermission() {
        throw new IllegalAccessError("not permitted to access field");
    }
}
