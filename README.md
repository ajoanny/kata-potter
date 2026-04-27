# README — Kata Potter

## Description

Le **Kata Potter** est un exercice classique de conception logicielle proposé par Coding Dojo.
L’objectif est de développer une fonction capable de calculer le prix optimal d’un panier contenant plusieurs tomes de Harry Potter, en appliquant automatiquement la meilleure combinaison de réductions possibles.

---

## Règles du problème

Chaque livre coûte **8 €** à l’unité.

| Nombre de livres différents | Réduction |
| --------------------------- | --------- |
| 1                           | 0%        |
| 2                           | 5%        |
| 3                           | 10%       |
| 4                           | 20%       |
| 5                           | 25%       |

---

# Version TypeScript

## Setup du projet

### Initialisation

```bash id="b6k2zr"
mkdir potter-kata
cd potter-kata
npm init -y
npm install --save-dev typescript jest ts-jest @types/jest
npx tsc --init
npx ts-jest config:init
```

### Structure du projet

```txt id="r7d9wp"
potter-kata/
│
├── src/
│   └── potter.ts
│
├── tests/
│   └── potter.test.ts
│
├── package.json
├── tsconfig.json
├── jest.config.js
└── README.md
```

### package.json

```json id="y4q8na"
"scripts": {
  "test": "jest"
}
```

### Exemple de tests TypeScript

```ts id="x8v3je"
import { price } from "../src/potter";

describe("Potter Kata", () => {
  test("plusieurs remises", () => {
    expect(price([0, 0, 1])).toBeCloseTo(8 + (8 * 2 * 0.95));
    expect(price([0, 0, 1, 1])).toBeCloseTo(2 * (8 * 2 * 0.95));
    expect(price([0, 0, 1, 2, 2, 3])).toBeCloseTo((8 * 4 * 0.8) + (8 * 2 * 0.95));
    expect(price([0, 1, 1, 2, 3, 4])).toBeCloseTo(8 + (8 * 5 * 0.75));
  });

  test("cas limites", () => {
    expect(price([0, 0, 1, 1, 2, 2, 3, 4]))
      .toBeCloseTo(2 * (8 * 4 * 0.8));

    expect(
      price([
        0,0,0,0,0,
        1,1,1,1,1,
        2,2,2,2,
        3,3,3,3,3,
        4,4,4,4
      ])
    ).toBeCloseTo(
      (3 * (8 * 5 * 0.75)) + (2 * (8 * 4 * 0.8))
    );
  });
});
```

### Lancer les tests

```bash id="u2f9mk"
npm test
```

---

# Version Java

## Setup du projet

### Initialisation Maven

```bash id="t6p4zw"
mvn archetype:generate -DgroupId=com.potterkata -DartifactId=potter-kata -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
cd potter-kata
```

### Structure du projet

```txt id="k3v8pq"
potter-kata/
│
├── src/
│   ├── main/java/com/potterkata/
│   │   └── PotterKata.java
│   │
│   └── test/java/com/potterkata/
│       └── PotterKataTest.java
│
└── pom.xml
```

### Configuration `pom.xml`

```xml id="d9w2ls"
<properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
</properties>

<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.2.5</version>
        </plugin>
    </plugins>
</build>
```

### Exemple de tests Java

```java id="j4r8nx"
package com.potterkata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PotterKataTest {

    private final PotterKata potterKata = new PotterKata();

    @Test
    void plusieursRemises() {
        assertEquals(8 + (8 * 2 * 0.95), potterKata.price(List.of(0, 0, 1)), 0.001);
        assertEquals(2 * (8 * 2 * 0.95), potterKata.price(List.of(0, 0, 1, 1)), 0.001);
        assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95),
                potterKata.price(List.of(0, 0, 1, 2, 2, 3)), 0.001);
        assertEquals(8 + (8 * 5 * 0.75),
                potterKata.price(List.of(0, 1, 1, 2, 3, 4)), 0.001);
    }

    @Test
    void casLimites() {
        assertEquals(
                2 * (8 * 4 * 0.8),
                potterKata.price(List.of(0, 0, 1, 1, 2, 2, 3, 4)),
                0.001
        );

        assertEquals(
                (3 * (8 * 5 * 0.75)) + (2 * (8 * 4 * 0.8)),
                potterKata.price(List.of(
                        0,0,0,0,0,
                        1,1,1,1,1,
                        2,2,2,2,
                        3,3,3,3,3,
                        4,4,4,4
                )),
                0.001
        );
    }
}
```

### Lancer les tests

```bash id="h8q2vy"
mvn test
```

---

## Référence officielle

Kata original : [https://codingdojo.org/kata/Potter/](https://codingdojo.org/kata/Potter/)

---

## Résumé

Le Kata Potter consiste à calculer automatiquement **le prix minimum possible** d’un panier en trouvant la combinaison de groupes de livres la plus avantageuse.
