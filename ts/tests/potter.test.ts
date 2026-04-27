import potter from "../src/potter";

describe('potter', () => {
  it('failing tests', () => {
      const price = potter([])
      expect(price).toBe(0);
  });

  it('when one book', () => {
        const price = potter([1])
        expect(price).toBe(8);
  });

  it('when two time same books', () => {
        const price = potter([1, 1])
        expect(price).toBe(16);
  });

  it('when several same books', () => {
        const price = potter([1, 1, 1])
        expect(price).toBe(24);
  });

  it('when when two different books', () => {
        const price = potter([1, 2])
        expect(price).toBe((8 * 2) * 0.95);
  });

  it('when when three different books', () => {
      const price = potter([1, 2, 3])
      expect(price).toBe((8 * 3) * 0.90);
  });

    it('when when four different books', () => {
        const price = potter([1, 2, 3, 4])
        expect(price).toBe((8 * 4) * 0.80);
    });

    it('when when five different books', () => {
        const price = potter([1, 2, 3, 4, 5])
        expect(price).toBe((8 * 5) * 0.75);
    });

    it('when [1,1,2]', () => {
        const price = potter([1, 1,2])
        expect(price).toBe(8 + (8 * 2) * 0.95);
    });

    it('when [1,1,2,2]', () => {
        const price = potter([1, 1, 1, 2])
        expect(price).toBe(8 *2 + (8 * 2) * 0.95);
    });

    it("several disconts", () => {
        expect(potter([0, 0, 1])).toBe(8 + (8 * 2 * 0.95))
        expect(potter([0, 0, 1, 1])).toBe(2 * (8 * 2 * 0.95))
        expect(potter([0, 0, 1, 2, 2, 3])).toBe((8 * 4 * 0.8) + (8 * 2 * 0.95))
        expect(potter([0, 1, 1, 2, 3, 4])).toBe(8 + (8 * 5 * 0.75))

    })

    it("edge cases", () => {
        expect(
            potter([0, 0, 1, 1, 2, 2, 3, 4])
        ).toBe((2 * (8 * 4 * 0.8)))
        expect(potter([0, 0, 0, 0, 0,
            1, 1, 1, 1, 1,
            2, 2, 2, 2,
            3, 3, 3, 3, 3,
            4, 4, 4, 4])).toBe(
                (3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8)))
    })
});
