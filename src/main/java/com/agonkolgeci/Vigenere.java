package com.agonkolgeci;

import org.jetbrains.annotations.NotNull;

// Chiffrement de Vigenère en Java par Agon KOLGECI
public class Vigenere {

    public static void main(@NotNull String args[]) {
        System.out.println("Question 3. Chiffrement de Vigenère du message \"kingandqueenofthering\" avec la clé 'yeet': " + vigenere("kingandqueenofthering", "yeet", true));
        System.out.println("Question 4. Déchiffrement de Vigenère du message \"iecdgrxsedplxslwmoc\" avec la clé 'paldea': " + vigenere("iecdgrxsedplxslwmoc", "paldea", false));
    }

    @NotNull
    public static String vigenere(@NotNull String message, @NotNull String key, boolean encode) {
        final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        @NotNull final StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < message.length(); i++) {
            final char character = message.charAt(i);

            final int characterPosition = (Character.toLowerCase(character) - 'a');
            final int keyCharacterPosition = (Character.toLowerCase(key.charAt((i + key.length()) % key.length())) - 'a');

            final int targetPosition = ((characterPosition + (encode ? +keyCharacterPosition : -keyCharacterPosition)) + alphabet.length) % alphabet.length;
            final char targetCharacter = alphabet[targetPosition];

            stringBuilder.append(Character.isUpperCase(character) ? Character.toUpperCase(targetCharacter) : Character.toLowerCase(targetCharacter));
        }

        return stringBuilder.toString();
    }
}
