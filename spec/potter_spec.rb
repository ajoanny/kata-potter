require './lib/potter'
RSpec.describe Kata do
  # 2 - Avec deux fois le même livre
  # 3 - Avec 2 livres différents
  # 4 - Avec 3 livres différents
  # 5 - Avec 4 livres différents
  # 6 - Avec 5 livres différents
  # 7 - Avec 3 dont deux identiques
  # 8 - Avec 0 livre

  describe 'when there are several times the same book' do
    it 'does not apply any discount' do
      expect(price([1, 1])).to eq 16
    end
  end

  describe 'when there is no book' do
    it 'returns 0' do
      expect(price([])).to eq 0
    end
  end

  describe 'when there are two different books' do
    it 'apply 5% discount' do
      total = 16
      five_percent_discount = total * 0.05
      expect(price([1, 2])).to eq(total - five_percent_discount)
    end
  end

  describe 'when there is book 2 two times' do
    it 'does not apply discount' do
      expect(price([2, 2])).to eq 16
    end
  end

  describe 'when there are book 2 and 3' do
    it 'apply 5% discount' do
      total = 16
      five_percent_discount = total * 0.05
      expect(price([2, 3])).to eq(total - five_percent_discount)
    end
  end
end

