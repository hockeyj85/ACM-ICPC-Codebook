

// Input:
// Values (stored in array v)
// Weights (stored in array w)
// Number of distinct items (n)
// Knapsack capacity (W)
for j from 0 to W do
  m[0, j] := 0
end for 
for i from 1 to n do
  for j from 0 to W do
    if w[i] <= j then
      m[i, j] := max(m[i-1, j], m[i-1, j-w[i]] + v[i])
    else
      m[i, j] := m[i-1, j]
    end if
  end for
end for
