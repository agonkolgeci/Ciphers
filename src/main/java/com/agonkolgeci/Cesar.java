package com.agonkolgeci;

import org.jetbrains.annotations.NotNull;

// Chiffrement de César en Java par Agon KOLGECI
public class Cesar {

    public static void main(@NotNull String args[]) {
        System.out.println("Question 1. Chiffrement de César du message \"PAPERMARIOLAPORTEMILLENAIRE\" avec la clé 4: " + cesar("PAPERMARIOLAPORTEMILLENAIRE", 4, true));
        System.out.println("Question 2. Déchiffrement de César du message \"DFNQRZOHGJHPH\" avec la clé 3: " + cesar("DFNQRZOHGJHPH", 3, false));
    }

    @NotNull
    public static String cesar(@NotNull String message, int key, boolean encode) {
        final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        @NotNull final StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < message.length(); i++) {
            final char character = message.charAt(i);

            final int characterIndex = (Character.toLowerCase(character) - 'a');

            final int targetIndex = ((characterIndex + (encode ? +key : -key)) + alphabet.length) % alphabet.length;
            final char targetCharacter = alphabet[targetIndex];

            stringBuilder.append(Character.isUpperCase(character) ? Character.toUpperCase(targetCharacter) : Character.toLowerCase(targetCharacter));
        }

        return stringBuilder.toString();
    }
}