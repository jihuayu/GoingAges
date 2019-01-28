package io.jihuayu.goingages.api;

import com.mojang.authlib.Agent;
import com.mojang.authlib.AuthenticationService;
import com.mojang.authlib.UserAuthentication;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.util.UUIDTypeAdapter;
import com.sun.istack.internal.NotNull;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

import java.lang.reflect.Field;
import java.util.UUID;

public class GAAuth {
    public static void login(@NotNull String name,@NotNull String password) throws Exception {
        if(name.equals("")||password.equals(""))return;
        UUID uuid = UUID.randomUUID();
        AuthenticationService authService = new YggdrasilAuthenticationService(Minecraft.getMinecraft().getProxy(),
                uuid.toString());
        UserAuthentication auth = authService.createUserAuthentication(Agent.MINECRAFT);
        authService.createMinecraftSessionService();
        auth.logOut();
        auth.setUsername(name);
        auth.setPassword(password);
        auth.logIn();
        Session session = new Session(auth.getSelectedProfile().getName(), UUIDTypeAdapter.fromUUID(auth.getSelectedProfile().getId()), auth.getAuthenticatedToken(), auth.getUserType().getName());
        setSession(session);
    }

    private static void setSession(Session s) throws Exception {
        Class<? extends Minecraft> mc = Minecraft.getMinecraft().getClass();
        try {
            Field session = null;
            for (Field f : mc.getDeclaredFields()) {
                if (f.getType().isInstance(s)) {
                    session = f;
                }
            }
            session.setAccessible(true);
            session.set(Minecraft.getMinecraft(), s);
            session.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
