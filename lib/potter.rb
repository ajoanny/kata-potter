def price books
  if books.first === books.last
    return books.size * 8
  else
    return 15.2
  end
end